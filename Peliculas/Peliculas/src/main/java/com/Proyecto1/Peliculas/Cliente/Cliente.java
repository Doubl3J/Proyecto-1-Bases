package com.Proyecto1.Peliculas.Cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name="cliente")

public class Cliente {
    @Id
    private Long cedula;

    @NotBlank(message = "Nombre no puede estar vacío")
    @Column (nullable = false)
    private String nombre;

    @NotBlank(message = "Primer apellido no puede estar vacío")
    @Column (nullable = false)
    private String primer_apellido;

    private String segundo_apellido;

    @NotBlank(message = "Email no puede estar vacío")
    @Column (nullable = false)
    private String email;

    private int numero_telefono;

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(int numero_telefono) {
        this.numero_telefono = numero_telefono;
    }


}
