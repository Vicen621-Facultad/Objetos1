package io.github.vicen621.figurasycuerpos;

public class Circulo implements Figura {
    private double radio;

    public Circulo() {
        this(0.0);
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return this.radio * 2;
    }

    public void setDiametro(double diametro) {
        this.radio = diametro / 2;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double getPerimetro() {
        return Math.PI * this.getDiametro();
    }

    @Override
    public double getArea() {
        return Math.PI * this.getRadio() * this.getRadio();
    }
}
