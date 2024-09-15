package io.github.vicen621.figurasycuerpos;

public class Cuerpo3D {
    private Figura caraBasal;
    private double altura;

    public Cuerpo3D() {
        this(null, 0.0);
    }

    public Cuerpo3D(Figura caraBasal, double altura) {
        this.caraBasal = caraBasal;
        this.altura = altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setCaraBasal(Figura caraBasal) {
        this.caraBasal = caraBasal;
    }

    public double getVolumen() {
        return this.caraBasal.getArea() * this.getAltura();
    }

    public double getSuperficieExterior() {
        return 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.getAltura();
    }
}
