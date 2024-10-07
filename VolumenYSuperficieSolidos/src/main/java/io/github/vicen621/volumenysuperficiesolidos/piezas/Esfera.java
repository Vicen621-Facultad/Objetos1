package io.github.vicen621.volumenysuperficiesolidos.piezas;

public class Esfera extends Pieza {
    private int radio;

    public Esfera(String material, String color, int radio) {
        super(material, color);
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    @Override
    public double getVolumen() {
        return ((double) 4/3) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double getSuperficie() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
}
