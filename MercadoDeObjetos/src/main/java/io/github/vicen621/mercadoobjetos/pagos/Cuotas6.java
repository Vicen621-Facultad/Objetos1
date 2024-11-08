package io.github.vicen621.mercadoobjetos.pagos;

public class Cuotas6 implements FormaDePago {
    @Override
    public double calcularTotal(double precio) {
        return precio * 1.20;
    }
}
