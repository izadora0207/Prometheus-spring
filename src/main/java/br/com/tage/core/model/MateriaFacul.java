package br.com.tage.core.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_MATERIA")
@SequenceGenerator(name = "materia", sequenceName = "SQ_MATERIA", allocationSize = 1)
public class MateriaFacul {

  @Id
  @Column(name = "cd_materia")
  @GeneratedValue(generator = "materia", strategy = GenerationType.SEQUENCE)
  public int id;
  @Column(name = "nm_materia")
  public String nomeFacul;
  @Column(name = "desc_materia")
  public String desc;

  @Enumerated(EnumType.STRING)
  @Column(name = "dif_materia")
  private Dificuldade dificuldade;

  public MateriaFacul() {
  }

  public MateriaFacul(String nomeFacul, String desc, Dificuldade dificuldade) {
    this.nomeFacul = nomeFacul;
    this.desc = desc;
    this.dificuldade = dificuldade;
  }

  public Dificuldade getDificuldade() {
    return dificuldade;
  }

  public void setDificuldade(Dificuldade dificuldade) {
    this.dificuldade = dificuldade;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNomeFacul() {
    return nomeFacul;
  }

  public void setNomeFacul(String nomeFacul) {
    this.nomeFacul = nomeFacul;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

}
