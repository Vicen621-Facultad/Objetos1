package io.github.vicen621.inversiones;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Calculable {
    private LocalDate fechaDeConstitucion;
    private double montoDepositado;
    private double porcentajeDeInteresDiario;

    public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
        this.fechaDeConstitucion = fechaDeConstitucion;
        this.montoDepositado = montoDepositado;
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }

    public LocalDate getFechaDeConstitucion() {
        return fechaDeConstitucion;
    }

    public double getMontoDepositado() {
        return montoDepositado;
    }

    public double getPorcentajeDeInteresDiario() {
        return porcentajeDeInteresDiario;
    }

    @Override
    public double calcularValorActual() {
        double ganancia = ChronoUnit.DAYS.between(fechaDeConstitucion, LocalDate.now()) * porcentajeDeInteresDiario * montoDepositado;
        return montoDepositado + ganancia;
    }
}
