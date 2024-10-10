package io.github.vicen621.distribuidoraelectrica;

import java.time.LocalDate;

public class Factura {
    private Usuario usuario;
    private LocalDate fechaEmision;
    private double porcentajeBonificacion;
    private double montoFinal;

    public Factura(Usuario usuario, double porcentajeBonificacion, double monto) {
        this.usuario = usuario;
        this.fechaEmision = LocalDate.now();
        this.porcentajeBonificacion = porcentajeBonificacion;
        this.montoFinal = monto * (1 - porcentajeBonificacion);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public double getPorcentajeBonificacion() {
        return porcentajeBonificacion;
    }

    public double getMontoFinal() {
        return montoFinal;
    }
}
