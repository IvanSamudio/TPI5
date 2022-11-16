package com.tpi5.mvctp5.repository;

import com.tpi5.mvctp5.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {

    public Estudiante getEstudianteByNroLibreta(Long nro);

    @Query("SELECT e FROM Estudiante e order by e.edad DESC ")
    public Iterable<Estudiante> getAllEstudiantesOrderByEdad();

    public Iterable<Estudiante> getAllByGenero(String genero);

    @Query("SELECT d.estudiante FROM DatosAcademicos d INNER JOIN d.estudiante  WHERE d.carrera.idCarrera = :idCarrera and d.estudiante.residencia = :residencia group by d.estudiante.nroLibreta")
    public Iterable<Estudiante> getEstudiantesByCarreras(Long idCarrera,String residencia);
}
