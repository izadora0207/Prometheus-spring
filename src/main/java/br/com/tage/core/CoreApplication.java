package br.com.tage.core;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.tage.core.model.Dificuldade;
import br.com.tage.core.model.MateriaFacul;
import br.com.tage.core.repository.MateriaFaculRepository;

@SpringBootApplication
public class CoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    @Bean
    public ApplicationRunner firstCarga(MateriaFaculRepository repository) {
        return args -> {

            MateriaFacul m = new MateriaFacul("Quimica 1", "A mais avançada quimica", Dificuldade.FACIL);
            repository.save(m);
        };
    }

}