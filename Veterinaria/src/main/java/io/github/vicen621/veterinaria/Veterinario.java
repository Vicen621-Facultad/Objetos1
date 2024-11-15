package io.github.vicen621.veterinaria;

import java.time.LocalDate;

public class Veterinario {
    private String nombre;
    private LocalDate fechaIngreso;
    private double honorariosAtencion;

    public Veterinario(String nombre, LocalDate fechaIngreso, double honorariosAtencion) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.honorariosAtencion = honorariosAtencion;
    }

    public int getAntiguedad() {
        return LocalDate.now().getYear() - fechaIngreso.getYear();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public double getHonorariosAtencion() {
        return honorariosAtencion;
    }
}
