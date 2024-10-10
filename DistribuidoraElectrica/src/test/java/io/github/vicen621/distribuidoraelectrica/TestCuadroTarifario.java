package io.github.vicen621.distribuidoraelectrica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCuadroTarifario {

    private CuadroTarifario tarifas;

    @BeforeEach
    public void setup() {
        tarifas = new CuadroTarifario(100);
    }

    @Test
    public void getTarifa() {
        assertEquals(tarifas.getTarifaActual(), 100);
    }

    @Test
    public void setTarifa() {
        tarifas.setTarifaActual(200);
        assertEquals(tarifas.getTarifaActual(), 200);
    }
}
