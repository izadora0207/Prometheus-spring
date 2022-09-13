package br.com.tage.core.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tage.core.exception.ResourceNotFoundException;
import br.com.tage.core.model.MateriaFacul;
import br.com.tage.core.repository.MateriaFaculRepository;

@Controller
@RequestMapping({ "materia", "/" })
public class MateriaFaculController {

  private MateriaFaculRepository repository;

  public MateriaFaculController(MateriaFaculRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public String getAll(Model model) {
    model.addAttribute("materiaFacul", repository.findAll());
    return "materia/index";
  }

  @GetMapping("cadastrar")
  public String cadastrar(MateriaFacul materiaFacul) {
    return "materia/form";
  }

  @PostMapping("cadastrar")
  public String cadastrar(MateriaFacul materiaFacul, RedirectAttributes redirectAttributes) {

    String msg = "Matéria cadastrada com sucesso!";
    if (materiaFacul.getId() != 0)
      msg = "Matéria Atualizada com sucesso!";

    repository.save(materiaFacul);
    redirectAttributes.addFlashAttribute("msg", msg);

    return "redirect:/";
  }

  @GetMapping("editar/{id}")
  public String update(@PathVariable("id") int id, Model model) {

    model.addAttribute("materiaFacul", repository.findById(id));

    return "materia/form";
  }

  @PostMapping("excluir/{id}")
  public String excluir(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {

    repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    repository.deleteById(id);

    redirectAttributes.addFlashAttribute("msg", "Matéria Removida!");

    return "redirect:/";
  }

  @GetMapping("buscar")
  public List<MateriaFacul> buscarMateriaPeloNome(@RequestParam String nome) {
    return repository.findByNomeFaculContainsIgnoreCase(nome);
  }

}
