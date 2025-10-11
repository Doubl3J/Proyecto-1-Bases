package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="tienda")


public class Tienda {

    @Id
    private Long id_tienda;
    private String nombre_tienda;
    private String direccion_exacta;
    private int telefono_tienda;
    private String email_tienda;

    @ManyToOne
    @JoinColumn (name ="id_provincia")
    private Provincia provincia;

    public Long getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(Long id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getDireccion_exacta() {
        return direccion_exacta;
    }

    public void setDireccion_exacta(String direccion_exacta) {
        this.direccion_exacta = direccion_exacta;
    }

    public int getTelefono_tienda() {
        return telefono_tienda;
    }

    public void setTelefono_tienda(int telefono_tienda) {
        this.telefono_tienda = telefono_tienda;
    }

    public String getEmail_tienda() {
        return email_tienda;
    }

    public void setEmail_tienda(String email_tienda) {
        this.email_tienda = email_tienda;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
