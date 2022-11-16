package com.tpi5.mvctp5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

@Entity
@Data
public class Carrera implements Serializable {
    @Id
    private Long idCarrera;
    @Column
    private String nombre;
    @OneToMany(mappedBy="carrera", cascade= {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE}, fetch=FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private List<DatosAcademicos> estudiantes;

    public Carrera(Long idCarrera, String nombre) {
        this.nombre = nombre.toLowerCase(Locale.ROOT);
        this.idCarrera = idCarrera;
    }

    public Carrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Carrera() {
    }
}
