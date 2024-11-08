package io.github.vicen621.poolcar;

public class Pasajero extends Usuario {

    public Pasajero(String nombre) {
        super(nombre);
    }

    public void registrarseViaje(Viaje viaje) {
        viaje.registrarPasajero(this);
    }

    @Override
    double calcularComision(double amount) {
        return hizoViajeMenos30Dias() ? amount : amount * 0.9;
    }

    @Override
    double calcularBonificacion() {
        return hizoViajes() ? 500 : 0;
    }
}
