package com.Proyecto1.Peliculas.Factura;

import com.Proyecto1.Peliculas.Cliente.Cliente;
import com.Proyecto1.Peliculas.Tienda.Tienda;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name="factura")


public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    @NotBlank(message = "Fecha de factura no puede estar vacía")
    @Column (nullable = false)
    private String fecha_factura;

    private Long total_factura;

    @ManyToOne
    @JoinColumn (name ="id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn (name ="id_tienda")
    private Tienda tienda;

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public Long getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(Long total_factura) {
        this.total_factura = total_factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
