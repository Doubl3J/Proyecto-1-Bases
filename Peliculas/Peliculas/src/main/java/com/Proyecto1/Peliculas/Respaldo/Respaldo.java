package com.Proyecto1.Peliculas.Respaldo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="respaldo")

public class Respaldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respaldo;

    private String nombre_tabla;

    private Long id_tabla;

    private String operacion;

    private LocalDateTime fecha_hora;

    private String usuario;

    private String datos_anteriores;

    private String datos_nuevos;

    public Long getId_respaldo() {
        return id_respaldo;
    }

    public void setId_respaldo(Long id_respaldo) {
        this.id_respaldo = id_respaldo;
    }

    public String getNombre_tabla() {
        return nombre_tabla;
    }

    public void setNombre_tabla(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
    }

    public Long getId_tabla() {
        return id_tabla;
    }

    public void setId_tabla(Long id_tabla) {
        this.id_tabla = id_tabla;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDatos_anteriores() {
        return datos_anteriores;
    }

    public void setDatos_anteriores(String datos_anteriores) {
        this.datos_anteriores = datos_anteriores;
    }

    public String getDatos_nuevos() {
        return datos_nuevos;
    }

    public void setDatos_nuevos(String datos_nuevos) {
        this.datos_nuevos = datos_nuevos;
    }




}
