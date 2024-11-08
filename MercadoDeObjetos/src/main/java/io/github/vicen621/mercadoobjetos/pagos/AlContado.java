package io.github.vicen621.mercadoobjetos.pagos;

public class AlContado implements FormaDePago {
    @Override
    public double calcularTotal(double precio) {
        return precio;
    }
}
