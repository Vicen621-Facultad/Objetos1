package io.github.vicen621.distribuidoraelectrica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFactura {
    private Usuario user;
    private Factura factura;
    private Factura facturaBonificación;

    @BeforeEach
    public void setup() {
        user = new Usuario("sin bonificacion", "test123");

        this.facturaBonificación = new Factura(user, 0.1, 100);
        this.factura = new Factura(user, 0.0, 100);
    }

    @Test
    public void test_get_montofinal() {
        assertEquals(this.facturaBonificación.getMontoFinal(), 90);
        assertEquals(this.factura.getMontoFinal(), 100);
    }

    @Test
    public void get_user() {
        assertEquals(this.factura.getUsuario(), user);
        assertEquals(this.facturaBonificación.getUsuario(), user);
    }

    @Test
    public void test_get_porcentajebonificacion() {
        assertEquals(this.factura.getPorcentajeBonificacion(), 0.0);
        assertEquals(this.facturaBonificación.getPorcentajeBonificacion(), 0.1);
    }

    @Test
    public void test_get_fecha_emision() {
        assertEquals(this.factura.getFechaEmision(), LocalDate.now());
        assertEquals(this.facturaBonificación.getFechaEmision(), LocalDate.now());
    }
}
