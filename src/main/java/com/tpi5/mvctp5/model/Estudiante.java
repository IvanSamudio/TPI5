package com.tpi5.mvctp5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "Estudiante")
@Data
public class Estudiante implements Serializable {
    @Id
    private Long nroLibreta;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String genero;
    @Column
    private Long dni;
    @Column
    private String residencia;



    @OneToMany(mappedBy="estudiante", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private List<DatosAcademicos> carreras = new ArrayList<>();

    public Estudiante() {

    }

    public Estudiante(Long nroLibreta) {
        this.nroLibreta = nroLibreta;
    }

    public Estudiante(Long nroLibreta,String nombre, String apellido , Integer edad, String genero, Long dni, String residencia){
        this.nroLibreta = nroLibreta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero.toLowerCase(Locale.ROOT);
        this.dni = dni;
        this.residencia = residencia.toLowerCase(Locale.ROOT);
    }

    public void addCarreras(DatosAcademicos d) {
        this.carreras.add(d);
    }

    public void addCarreras(Carrera c) {
        this.carreras.add(new DatosAcademicos(c,this));
    }
}
