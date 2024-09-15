package ar.edu.info.unlp.balanzaelectronica;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
    private List<Producto> productos;
    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public Balanza() {
        this.productos = new ArrayList<>();
        ponerEnCero();
    }

    public void ponerEnCero() {
        this.productos.clear();
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
    }

    public void agregarProducto(Producto producto) {
        this.precioTotal += producto.getPrecio();
        this.pesoTotal += producto.getPeso();
        this.productos.add(producto);
        this.cantidadDeProductos++;
    }

    public Ticket emitirTicket() {
        return new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal, this.productos);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }
}
