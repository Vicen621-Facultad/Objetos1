package ar.edu.info.unlp.balanzaelectronica;

public class Balanza {
    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public void ponerEnCero() {
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
    }

    public void agregarProducto(Producto producto) {
        this.precioTotal += producto.getPrecio();
        this.pesoTotal += producto.getPeso();
        this.cantidadDeProductos++;
    }

    public Ticket emitirTicket() {
        return new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal);
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
