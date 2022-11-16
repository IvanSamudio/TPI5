package com.tpi5.mvctp5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
public class DatosAcademicos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDatosAcademicos;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nroLibreta")
    @NotFound(action = NotFoundAction.IGNORE)
    private Estudiante estudiante;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCarrera")
    @NotFound(action = NotFoundAction.IGNORE)
    private Carrera carrera;
    @Column
    private Timestamp fechaIngreso;
    @Column
    private  boolean graduado;
    @Column
    private Timestamp fechaGraduacion;

    public DatosAcademicos() {
    }

    public DatosAcademicos(Carrera c,Estudiante e) {
        //GENERO FECHA RANDOM ENTRE 2010 Y 2022
        long offset = Timestamp.valueOf("2010-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        this.fechaIngreso = new Timestamp(offset + (long)(Math.random() * diff));
        this.graduado=false;
        this.carrera = c;
        this.estudiante = e;
    }

    public DatosAcademicos (Long idCarrera,Long nroLibreta){
        long offset = Timestamp.valueOf("2010-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        this.fechaIngreso = new Timestamp(offset + (long)(Math.random() * diff));
        this.graduado=false;
        this.carrera = new Carrera(idCarrera);
        this.estudiante = new Estudiante(nroLibreta);
    }

    public void graduarEstudiante(){
        long end = Timestamp.valueOf("2022-10-01 00:00:00").getTime();
        long diff = end - fechaIngreso.getTime() + 1;
        this.fechaGraduacion = new Timestamp(fechaIngreso.getTime() + (long)(Math.random() * diff));
        this.graduado=true;
    }


}
