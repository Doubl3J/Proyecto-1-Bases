package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="genero")

public class Genero {

    @Id
    private Long id_genero;
    private String nombre_genero;

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }
}
