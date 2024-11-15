package io.github.vicen621.veterinaria.servicios;

import io.github.vicen621.veterinaria.DateLapseDays;
import io.github.vicen621.veterinaria.Mascota;

import java.time.LocalDate;

public class Guarderia extends Servicio {
    private int cantDias;

    public Guarderia(Mascota mascota, int cantDias) {
        super(mascota);
        this.cantDias = cantDias;
    }

    /**
     * se cobra según un costo diario de $500 y
     * si la mascota utilizó previamente 5 o más servicios, se le aplica un descuento del 10%.
     * @return el costo total
     */
    public double calcularCostoTotal() {
        return calcularCosto() * cantDias;
    }

    /**
     * se cobra según un costo diario de $500 y
     * si la mascota utilizó previamente 5 o más servicios, se le aplica un descuento del 10%.
     * @return el costo por dia
     */
    @Override
    public double calcularCosto() {
        return 500 * (getMascota().tieneMasServicios(5) ? 0.9 : 1);
    }

    @Override
    public boolean fueEnFecha(LocalDate date) {
        return new DateLapseDays(getFecha(), cantDias).includesDate(date);
    }
}
