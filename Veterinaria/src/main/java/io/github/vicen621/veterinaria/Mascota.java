package io.github.vicen621.veterinaria;

import io.github.vicen621.veterinaria.servicios.ConsultaMedica;
import io.github.vicen621.veterinaria.servicios.Guarderia;
import io.github.vicen621.veterinaria.servicios.Servicio;
import io.github.vicen621.veterinaria.servicios.Vacunacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private String especie;
    private LocalDate fechaNacimiento;
    private List<Servicio> servicios;

    public Mascota(String nombre, String especie, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.servicios = new ArrayList<>();
    }

    public boolean tieneMasServicios(int cantidad) {
        return this.servicios.size() > cantidad;
    }

    public void registrarGuarderia(int cantDias) {
        this.servicios.add(new Guarderia(this, cantDias));
    }

    public void registrarConsultaMedica(Veterinario veterinario) {
        this.servicios.add(new ConsultaMedica(this, veterinario));
    }

    public void registrarVacunacion(Veterinario veterinario, String vacuna, double costoVacuna) {
        this.servicios.add(new Vacunacion(this, veterinario, vacuna, costoVacuna));
    }

    public double calcularRecaudacion(LocalDate fecha) {
        return this.servicios.stream()
                .filter(servicio -> servicio.fueEnFecha(fecha))
                .mapToDouble(Servicio::calcularCosto)
                .sum();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
