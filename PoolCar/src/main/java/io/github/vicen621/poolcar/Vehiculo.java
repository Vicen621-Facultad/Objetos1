package io.github.vicen621.poolcar;

import java.time.LocalDate;

public class Vehiculo {
    private String descripcion;
    private int capacidad;
    private int anoFabricacion;
    private double valor;

    public Vehiculo(String descripcion, int capacidad, int anoFabricacion, double valor) {
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.anoFabricacion = anoFabricacion;
        this.valor = valor;
    }

    public int getAntiguedad() {
        return LocalDate.now().getYear() - anoFabricacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public double getValor() {
        return valor;
    }
}
