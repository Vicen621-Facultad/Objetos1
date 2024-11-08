package io.github.vicen621.poolcar;

import java.time.LocalDate;

public class Conductor extends Usuario {
    private Vehiculo vehiculo;

    public Conductor(String nombre, Vehiculo vehiculo) {
        super(nombre);
        this.vehiculo = vehiculo;
    }

    public void altaViaje(String origen, String destino, double costoTotal, LocalDate fecha) {
        new Viaje(origen, destino, costoTotal, fecha, this);
    }

    @Override
    double calcularComision(double amount) {
        return vehiculo.getAntiguedad() < 5 ? amount * 0.99 : amount * 0.90;
    }

    @Override
    double calcularBonificacion() {
        return this.getVehiculo().getValor() * 0.001;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
