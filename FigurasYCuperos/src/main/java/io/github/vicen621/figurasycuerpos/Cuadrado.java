package io.github.vicen621.figurasycuerpos;

public class Cuadrado implements Figura {
    private double lado;

    public Cuadrado() {
        this(0.0);
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getPerimetro() {
        return this.getLado() * 4;
    }

    @Override
    public double getArea() {
        return this.getLado() * this.getLado();
    }
}
