package com.tpi5.mvctp5.utils;


import com.tpi5.mvctp5.model.Carrera;
import com.tpi5.mvctp5.model.Estudiante;
import com.tpi5.mvctp5.repository.CarreraRepository;
import com.tpi5.mvctp5.repository.EstudianteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabaseEstudiante(@Qualifier("estudianteRepository") EstudianteRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Estudiante((long)1,"Ivan", "Samudio",22,"Masculino", 42391607L,"Tandil")));
            log.info("Preloading " + repository.save(new Estudiante((long)2,"Pedro", "Perez",24,"Masculino",41322715L,"Tandil")));
            log.info("Preloading " + repository.save(new Estudiante((long)3,"Homero", "Simpson",36,"Masculino",20222333L,"Spingfield")));
            log.info("Preloading " + repository.save(new Estudiante((long)4,"Juan", "Topo",72,"Masculino",10324715L,"Spingfield")));
            log.info("Preloading " + repository.save(new Estudiante((long)5,"Marge", "Simpson",30,"Femenino",23200300L,"Spingfield")));
        };
    }
    @Bean
     CommandLineRunner initDatabaseCarrera(@Qualifier("carreraRepository") CarreraRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Carrera(1L,"Tudai")));
            log.info("Preloading " + repository.save(new Carrera(2L,"Ingenieria en sistemas")));
        };
    }
}
