package io.github.vicen621.cuentaconganchos;

public class CajaDeAhorro extends Cuenta {
    @Override
    protected boolean puedeExtraer(double amount) {
        return this.getSaldo() - (amount * 1.02) >= 0;
    }

    @Override
    protected void extraerSinControlar(double amount) {
        super.extraerSinControlar(amount * 1.02);
    }
}
