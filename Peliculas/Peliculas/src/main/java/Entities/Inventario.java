package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="inventario")

public class Inventario {

    private int cantidad_disponible;

    @ManyToOne
    @JoinColumn (name ="id_pelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn (name ="id_tienda")
    private Tienda tienda;
}
