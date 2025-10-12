package Provincia;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="provincia")

public class Provincia {

    @Id
    private Long id_provincia;
    private String nombre_provincia;

    public Long getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Long id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
    }
}
