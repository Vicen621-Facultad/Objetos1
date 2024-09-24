package io.github.vicen621.inversiones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InversionEnAccionesTest {

    private InversionEnAcciones inversion;

    @BeforeEach
    public void setup() {
        inversion = new InversionEnAcciones("test", 4, 100);
    }

    @Test
    public void test_getters() {
        assertEquals("test", inversion.getNombre());
        assertEquals(4, inversion.getCantidad());
        assertEquals(100, inversion.getValorUnitario());
    }

    @Test
    public void test_setters() {
        inversion.setValorUnitario(12);
        assertEquals(12, inversion.getValorUnitario());
    }

    @Test
    public void test_calcular_valor() {
        assertEquals(400, inversion.calcularValorActual());

        inversion.setValorUnitario(1293.41);
        assertEquals(5173.64, inversion.calcularValorActual());
    }
}
