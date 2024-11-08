package io.github.vicen621.mercadoobjetos;

import io.github.vicen621.mercadoobjetos.envios.CalculadoraDeDistancia;
import io.github.vicen621.mercadoobjetos.envios.FormaDeEnvio;
import io.github.vicen621.mercadoobjetos.pagos.FormaDePago;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Usuario {
    private String nombre;
    private String direccion;
    private List<Producto> productos;
    private List<Pedido> pedidos;

    public Usuario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.productos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    /**
     * Crea y guarda un pedido hecho por el cliente
     * @param pago La forma de pago
     * @param formaDeEnvio La forma de envio
     * @param producto El producto
     * @param cantidad La cantidad deseada del producto
     * @return True si se creo el pedido, false en caso contrario
     */
    public boolean crearPedido(Usuario vendedor, FormaDePago pago, FormaDeEnvio formaDeEnvio, Producto producto, int cantidad) {
        if (producto.hayDisponible(cantidad))
            return false;

        producto.decrementarCantidad(cantidad);
        Pedido pedido = new Pedido(pago, formaDeEnvio, producto, cantidad, CalculadoraDeDistancia.distanciaEntre(vendedor.getDireccion(), this.getDireccion()));
        return pedidos.add(pedido);
    }

    public Map<String, Long> cantidadPorCategoria() {
        return this.pedidos.stream()
                .map(Pedido::getProducto)
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.counting()
                ));
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        this.productos.remove(producto);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
