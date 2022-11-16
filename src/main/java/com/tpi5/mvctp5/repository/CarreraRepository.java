package com.tpi5.mvctp5.repository;

import com.tpi5.mvctp5.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera,Long> {
    @Query("SELECT t FROM Carrera t where t.idCarrera = :nro")
    public Carrera getCarreraByIdCarrera(Long nro);

    @Query("SELECT d.carrera , count (d.estudiante) AS Inscriptos FROM DatosAcademicos d INNER JOIN d.carrera group by d.carrera.idCarrera order by count (d.carrera.idCarrera) DESC")
    public Iterable<Carrera> getCarreraByInscriptos();
}
