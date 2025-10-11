package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="factura")


public class Factura {

    @Id
    private Long id_factura;
    private String fecha_factura;
    private Long total_factura;

    @ManyToOne
    @JoinColumn (name ="id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn (name ="id_tienda")
    private Tienda tienda;

}
