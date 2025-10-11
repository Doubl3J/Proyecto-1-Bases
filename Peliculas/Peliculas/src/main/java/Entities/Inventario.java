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
