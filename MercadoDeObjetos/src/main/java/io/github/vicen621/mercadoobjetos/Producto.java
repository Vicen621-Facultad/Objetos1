package io.github.vicen621.mercadoobjetos;

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    public Producto(String nombre, String categoria, double precio, int cantidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecioParaCantidad(int cantidad) {
        return this.precio * cantidad;
    }

    public boolean hayDisponible(int cantidad) {
        return this.cantidad >= cantidad;
    }

    public void decrementarCantidad(int cantidad) {
        this.cantidad -= cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
