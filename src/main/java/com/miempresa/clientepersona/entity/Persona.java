package com.miempresa.clientepersona.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Persona {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El género no puede estar vacío")
    private String genero;

    private int edad;

    @Size(min = 10, max = 10, message = "La identificación debe tener 10 caracteres")
    private String identificacion;

    @NotBlank(message = "La dirección no puede estar vacía")
    private String direccion;

    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;
}
