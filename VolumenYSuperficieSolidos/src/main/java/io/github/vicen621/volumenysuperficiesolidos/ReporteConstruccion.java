package io.github.vicen621.volumenysuperficiesolidos;

import io.github.vicen621.volumenysuperficiesolidos.piezas.Pieza;

import java.util.ArrayList;
import java.util.List;

//TODO: Hacer tests
public class ReporteConstruccion {
    private List<Pieza> piezas;

    public ReporteConstruccion() {
        this.piezas = new ArrayList<>();
    }

    public double getVolumenDeMaterial(String material) {
        return piezas.stream()
                .filter(pieza -> pieza.getMaterial().equals(material))
                .mapToDouble(Pieza::getVolumen)
                .sum();
    }

    public double getSuperficieDeColor(String color) {
        return piezas.stream()
                .filter(pieza -> pieza.getColor().equals(color))
                .mapToDouble(Pieza::getSuperficie)
                .sum();
    }
}
