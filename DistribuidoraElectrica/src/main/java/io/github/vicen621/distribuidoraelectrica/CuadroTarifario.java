package io.github.vicen621.distribuidoraelectrica;

public class CuadroTarifario {
    private double tarifaActual;

    public CuadroTarifario(double tarifaActual) {
        this.tarifaActual = tarifaActual;
    }

    public double getTarifaActual() {
        return tarifaActual;
    }

    public void setTarifaActual(double tarifaActual) {
        this.tarifaActual = tarifaActual;
    }
}
