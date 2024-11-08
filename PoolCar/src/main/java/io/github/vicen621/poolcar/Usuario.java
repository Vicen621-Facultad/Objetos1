package io.github.vicen621.poolcar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public abstract class Usuario {
    private String nombre;
    private double saldo;
    private Set<Viaje> viajes;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.saldo = 0;
        this.viajes = new HashSet<>();
    }

    public void agregarViaje(Viaje viaje) {
        this.viajes.add(viaje);
    }

    public void cargarSaldo(double amount) {
        amount = calcularComision(amount);
        this.saldo += amount;
    }

    public void usarSaldo(double amount) {
        amount = Math.max(0, amount - calcularBonificacion());
        this.saldo -= amount;
    }

    public boolean tieneSaldoRojo() {
        return this.saldo < 0;
    }

    public boolean hizoViajes() {
        return !this.viajes.isEmpty();
    }

    public boolean hizoViajeMenos30Dias() {
        if (!hizoViajes())
            return false;

        Viaje viaje = this.viajes.stream()
                .max(Comparator.comparing(Viaje::getFecha)).get();

        return ChronoUnit.DAYS.between(LocalDate.now(), viaje.getFecha()) < 30;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    abstract double calcularBonificacion();
    abstract double calcularComision(double amount);
}
