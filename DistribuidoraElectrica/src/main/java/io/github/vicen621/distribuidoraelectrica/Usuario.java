package io.github.vicen621.distribuidoraelectrica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Usuario {
    private String nombre;
    private String domicilio;
    private List<Consumo> consumos;

    public Usuario(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.consumos = new ArrayList<>();
    }

    public Factura crearFacturaUltimoConsumo(CuadroTarifario tarifa) {
        Consumo consumoMes = consumos.stream().max(Comparator.comparing(Consumo::getFecha))
                .orElse(new Consumo(0, 0));

        double bonificacion = (consumoMes.calcularFpe() > 0.8 ? 0.1 : 0.0);

        return new Factura(
                this,
                bonificacion,
                consumoMes.calcularPrecio(tarifa)
        );
    }

    public void agregarConsumo(Consumo consumo) {
        this.consumos.add(consumo);
    }

    public void eliminarConsumo(Consumo consumo) {
        this.consumos.remove(consumo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }
}
