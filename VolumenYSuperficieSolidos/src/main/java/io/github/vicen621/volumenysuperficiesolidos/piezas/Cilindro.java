package io.github.vicen621.volumenysuperficiesolidos.piezas;

public class Cilindro extends Pieza {
    private int radio;
    private int altura;

    public Cilindro(String material, String color, int radio, int altura) {
        super(material, color);
        this.radio = radio;
        this.altura = altura;
    }

    public int getRadio() {
        return radio;
    }

    public int getAltura() {
        return altura;
    }

    private double getAreaBase() {
        return Math.PI * Math.pow(radio, 2);
    }

    private double getPerimetroBase() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double getVolumen() {
        // pi * radio^2 * altura
        return this.getAreaBase() * altura;
    }

    @Override
    public double getSuperficie() {
        return this.getPerimetroBase() * altura + 2 * getAreaBase();
    }
}
