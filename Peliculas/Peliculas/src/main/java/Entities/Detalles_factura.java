package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="detalles_factura")


public class Detalles_factura {

    @Id
    private Long id_detalle;

    @ManyToOne
    @JoinColumn (name ="id_pelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn (name ="id_factura")
    private Factura factura;

}
