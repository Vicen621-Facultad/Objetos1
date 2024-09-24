package io.github.vicen621.inversiones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InversorTest {

    private Inversor inversor;

    @BeforeEach
    public void setup() {
        inversor = new Inversor("test");
        inversor.agregarInversion(new InversionEnAcciones("acciones", 4, 100));
        inversor.agregarInversion(new PlazoFijo(LocalDate.of(2024, 9, 14), 1000, 0.01));
    }

    @Test
    public void test_get_nombre() {
        assertEquals("test", inversor.getNombre());
    }

    @Test
    public void test_valor_actual() {
        assertEquals(1500, inversor.valorActual());
    }
}
