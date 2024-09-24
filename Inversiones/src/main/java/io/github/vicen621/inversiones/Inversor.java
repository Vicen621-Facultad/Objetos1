package io.github.vicen621.inversiones;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private String nombre;
    private List<Calculable> inversiones;

    public Inversor(String nombre) {
        this.nombre = nombre;
        this.inversiones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarInversion(Calculable inversion) {
        inversiones.add(inversion);
    }

    public void eliminarInversion(Calculable inversion) {
        inversiones.remove(inversion);
    }

    public double valorActual() {
        return inversiones.stream().mapToDouble(Calculable::calcularValorActual).sum();
    }
}
