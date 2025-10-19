package com.Proyecto1.Peliculas.Pelicula;

import com.Proyecto1.Peliculas.Genero.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name="pelicula")

public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pelicula;

    @NotBlank(message = "Nombre de película no puede estar vacío")
    @Column (nullable = false)
    private String nombre_pelicula;

    private String idioma;

    private Long precio_venta;

    @ManyToOne
    @JoinColumn (name ="id_genero")
    private Genero genero;

    public Long getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Long id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Long precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
