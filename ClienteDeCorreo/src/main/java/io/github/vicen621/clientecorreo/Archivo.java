package io.github.vicen621.clientecorreo;

public class Archivo {
    private String nombre;

    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    public int tamano() {
        return this.nombre.length();
    }

    public String getNombre() {
        return nombre;
    }
}
