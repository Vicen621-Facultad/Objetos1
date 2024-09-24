package io.github.vicen621.cuentaconganchos;

public abstract class Cuenta {
    private double saldo;

    public Cuenta() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double amount) {
        this.saldo += amount;
    }

    protected void extraerSinControlar(double amount) {
        this.saldo -= amount;
    }

    public boolean extraer(double amount) {
        if (!this.puedeExtraer(amount))
            return false;

        this.extraerSinControlar(amount);
        return true;
    }

    public boolean transferirACuenta(double amount, Cuenta destino) {
        if (!this.puedeExtraer(amount))
            return false;

        this.extraerSinControlar(amount);
        destino.depositar(amount);
        return true;
    }

    protected abstract boolean puedeExtraer(double amount);
}
