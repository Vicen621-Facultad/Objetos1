package io.github.vicen621.mercadoobjetos;

import io.github.vicen621.mercadoobjetos.envios.FormaDeEnvio;
import io.github.vicen621.mercadoobjetos.pagos.FormaDePago;

public class Pedido {
    private FormaDePago formaPago;
    private FormaDeEnvio formaEnvio;
    private Producto producto;
    private int cantidad;
    private double kilometros;

    public Pedido(FormaDePago formaDePago, FormaDeEnvio formaFormaDeEnvio, Producto producto, int cantidad, double kilometros) {
        this.formaPago = formaDePago;
        this.formaEnvio = formaFormaDeEnvio;
        this.producto = producto;
        this.cantidad = cantidad;
        this.kilometros = kilometros;
    }

    public double costoTotal() {
        return formaPago.calcularTotal(this.producto.getPrecioParaCantidad(cantidad)) + formaEnvio.calcularEnvio(kilometros);
    }

    public FormaDePago getFormaPago() {
        return formaPago;
    }

    public FormaDeEnvio getFormaEnvio() {
        return formaEnvio;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getKilometros() {
        return kilometros;
    }
}
