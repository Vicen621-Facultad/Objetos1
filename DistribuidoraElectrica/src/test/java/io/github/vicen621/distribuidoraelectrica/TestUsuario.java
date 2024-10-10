package io.github.vicen621.distribuidoraelectrica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUsuario {
    private Usuario usuario;
    private Consumo consumo;

    @BeforeEach
    public void setup() {
        this.usuario = new Usuario("test", "test 123");
        consumo = new Consumo(100, 50);
        usuario.agregarConsumo(consumo);
    }

    @Test
    void testCrearFactura() {
        CuadroTarifario tarifario = new CuadroTarifario(100);

        Factura factura = usuario.crearFacturaUltimoConsumo(tarifario);
        assertEquals(9_000, factura.getMontoFinal());
        assertEquals(factura.getUsuario(), usuario);
        assertEquals(factura.getPorcentajeBonificacion(), 0.1);
        assertEquals(factura.getFechaEmision(), LocalDate.now());
    }
}
