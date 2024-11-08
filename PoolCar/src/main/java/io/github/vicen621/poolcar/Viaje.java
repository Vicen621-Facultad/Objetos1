package io.github.vicen621.poolcar;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Viaje {
    private String origen;
    private String destino;
    private double costoTotal;
    private LocalDate fecha;
    private Vehiculo vehiculo;
    private Set<Usuario> pasajeros;

    public Viaje(String origen, String destino, double costoTotal, LocalDate fecha, Conductor conductor) {
        this.origen = origen;
        this.destino = destino;
        this.costoTotal = costoTotal;
        this.fecha = fecha;
        this.vehiculo = conductor.getVehiculo();
        this.pasajeros = new HashSet<>();
        this.registrarPasajero(conductor);
    }

    private int getCantidadPasajeros() {
        return this.pasajeros.size();
    }

    public void registrarPasajero(Usuario usuario) {
        if (getCantidadPasajeros() >= this.vehiculo.getCapacidad())
            return;

        if (LocalDate.now().isAfter(fecha.minusDays(2)))
            return;

        if (usuario.tieneSaldoRojo())
            return;

        this.pasajeros.add(usuario);
        usuario.agregarViaje(this);
    }

    public void procesarViaje() {
        double amount = costoTotal / getCantidadPasajeros();
        pasajeros.forEach(usuario -> usuario.usarSaldo(amount));
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
