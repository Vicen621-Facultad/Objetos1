package io.github.vicen621.poolcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConductorTest {

    private Conductor conductor;

    @BeforeEach
    public void setup() {
        Vehiculo vehiculo = new Vehiculo("test desc", 5, 2009, 1_000_000);
        conductor = new Conductor("test", vehiculo);
    }

    @Test
    public void testCalcularComision() {
        assertEquals(180, conductor.calcularComision(200));
    }

    @Test
    public void testCalcularBonificacion() {
        assertEquals(1000, conductor.calcularBonificacion());
    }
}
