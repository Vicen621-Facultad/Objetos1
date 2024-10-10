package io.github.vicen621.distribuidoraelectrica;

import java.time.LocalDate;

public class Consumo {
    private double cantEnergiaActiva;
    private double cantEnergiaReactiva;
    private LocalDate fecha;

    public Consumo(double cantEnergiaActiva, double cantEnergiaReactiva, LocalDate fecha) {
        this.cantEnergiaActiva = cantEnergiaActiva;
        this.cantEnergiaReactiva = cantEnergiaReactiva;
        this.fecha = fecha;
    }

    public Consumo(double cantEnergiaActiva, double cantEnergiaReactiva) {
        this(cantEnergiaActiva, cantEnergiaReactiva, LocalDate.now());
    }

    public double calcularFpe() {
        return cantEnergiaActiva / Math.sqrt(Math.pow(cantEnergiaActiva, 2) + Math.pow(cantEnergiaReactiva, 2));
    }

    public double calcularPrecio(CuadroTarifario tarifa) {
        return this.cantEnergiaActiva * tarifa.getTarifaActual();
    }

    public double getCantEnergiaActiva() {
        return cantEnergiaActiva;
    }

    public double getCantEnergiaReactiva() {
        return cantEnergiaReactiva;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
