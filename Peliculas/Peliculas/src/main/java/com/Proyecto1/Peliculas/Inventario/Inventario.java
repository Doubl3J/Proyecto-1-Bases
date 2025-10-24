package com.Proyecto1.Peliculas.Inventario;

import com.Proyecto1.Peliculas.Pelicula.Pelicula;
import com.Proyecto1.Peliculas.Tienda.Tienda;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name="inventario",  uniqueConstraints = {@UniqueConstraint(name = "uc_pelicula_tienda",columnNames = {"id_pelicula","id_tienda"})})

public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inventario;

    private int cantidad_disponible;

    @ManyToOne
    @JoinColumn (name ="id_pelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn (name ="id_tienda")
    private Tienda tienda;

    public Long getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(Long id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
