package io.github.vicen621.veterinaria.servicios;

import io.github.vicen621.veterinaria.Mascota;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Servicio {
    private LocalDate fecha;
    private Mascota mascota;

    public Servicio(Mascota mascota) {
        this.mascota = mascota;
        this.fecha = LocalDate.now();
    }

    public boolean fueEnDomingo() {
        return getFecha().getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public boolean fueEnFecha(LocalDate date) {
        return fecha.equals(date);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public abstract double calcularCosto();
}
