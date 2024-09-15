package ar.edu.info.unlp.balanzaelectronica;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
    private List<Producto> productos;
    private LocalDate fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;

    public Ticket(int cantidadDeProductos, double pesoTotal, double precioTotal, List<Producto> productos) {
        this.fecha = LocalDate.now();
        this.cantidadDeProductos = cantidadDeProductos;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
        this.productos = productos;
    }

    public double impuesto() {
        return precioTotal * 0.21;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
