package io.github.vicen621.inversiones;

public class InversionEnAcciones implements Calculable {
    private String nombre;
    private int cantidad;
    private double valorUnitario;

    public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public double calcularValorActual() {
        return cantidad * valorUnitario;
    }
}
