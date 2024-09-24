package io.github.vicen621.inversiones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlazoFijoTest {

    private PlazoFijo inversion;

    @BeforeEach
    public void setup() {
        inversion = new PlazoFijo(LocalDate.now(), 1000, 0.01);
    }

    @Test
    public void test_getters() {
        assertEquals(LocalDate.now(), inversion.getFechaDeConstitucion());
        assertEquals(1000, inversion.getMontoDepositado());
        assertEquals(0.01, inversion.getPorcentajeDeInteresDiario());
    }

    @Test
    public void test_calcular_valor() {
        PlazoFijo inversionCalcularValor = new PlazoFijo(LocalDate.of(2024, 9, 14), 1000, 0.01);
        assertEquals(1100, inversionCalcularValor.calcularValorActual());
    }
}
