package com.tpi5.mvctp5.repository;

import com.tpi5.mvctp5.model.DatosAcademicos;
import com.tpi5.mvctp5.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DatosAcademicosRepository extends JpaRepository<DatosAcademicos,Long> {
    @Query("SELECT t FROM Estudiante t where t.nroLibreta = :nro")
    public Estudiante getEstudianteByNroLibreta(Long nro);

    @Query("SELECT t FROM DatosAcademicos t where t.estudiante.nroLibreta = :nroLibreta and t.carrera.idCarrera = :idCarrera")
    public DatosAcademicos getDatosAcademicos(Long nroLibreta,Long idCarrera);

    @Query("SELECT d from  DatosAcademicos d order by d.carrera.nombre,d.fechaIngreso,d.fechaGraduacion asc")
    public Iterable<DatosAcademicos> getInformeDatosAcademicos();

}
