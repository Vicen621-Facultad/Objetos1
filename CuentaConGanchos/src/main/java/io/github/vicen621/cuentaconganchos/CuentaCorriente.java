package io.github.vicen621.cuentaconganchos;

public class CuentaCorriente extends Cuenta {
    // El limite descubierto debe ser un valor negativo
    private double limiteDeDescubierto;

    public CuentaCorriente() {
        this.limiteDeDescubierto = 0;
    }

    public double getLimiteDeDescubierto() {
        return limiteDeDescubierto;
    }

    public void setLimiteDeDescubierto(double limiteDeDescubierto) {
        this.limiteDeDescubierto = limiteDeDescubierto;
    }

    @Override
    protected boolean puedeExtraer(double amount) {
        return getSaldo() - amount >= getLimiteDeDescubierto();
    }
}
