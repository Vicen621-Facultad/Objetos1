package io.github.vicen621;

import io.github.vicen621.datelapse.DateRangeable;

import java.util.Objects;

public class Reserva {
    private DateRangeable dateLapse;
    private Propiedad propiedad;

    public Reserva(Propiedad propiedad, DateRangeable dateLapse) {
        this.dateLapse = dateLapse;
        this.propiedad = propiedad;
    }

    /**
     * @param other La fecha con la que comparar
     * @return true si el período de tiempo del receptor se superpone con el recibido por parámetro
     */
    public boolean overlapsDates(DateRangeable other) {
        return this.dateLapse.overlaps(other);
    }

    /**
     * @return El precio total de la reserva
     */
    public double calcularPrecio() {
        return this.propiedad.getPrecio() * this.dateLapse.sizeInDays();
    }

    public DateRangeable getDateLapse() {
        return dateLapse;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return getPropiedad().equals(reserva.getPropiedad()) &&
                getDateLapse().equals(reserva.getDateLapse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateLapse(), getPropiedad());
    }
}
