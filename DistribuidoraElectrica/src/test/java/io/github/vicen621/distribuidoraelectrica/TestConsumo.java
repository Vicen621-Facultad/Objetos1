package io.github.vicen621.distribuidoraelectrica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConsumo {
    private Consumo consumo;

    @BeforeEach
    public void setup() {
        consumo = new Consumo(100, 50);
    }

    @Test
    public void test_calcular_fpe() {
        DecimalFormat df = new DecimalFormat("#.###");
        assertEquals(df.format(consumo.calcularFpe()), "0.894");
    }

    @Test
    public void test_calcular_precio() {
        CuadroTarifario tarifas = new CuadroTarifario(100);
        assertEquals(consumo.calcularPrecio(tarifas), 10000);
    }

    @Test
    public void test_get_fecha() {
        LocalDate date = LocalDate.of(2024, 10, 15);
        Consumo consumoFecha = new Consumo(1, 1, date);

        assertEquals(consumo.getFecha(), LocalDate.now());
        assertEquals(consumoFecha.getFecha(), date);
    }

    @Test
    public void testGetEnergiaActiva() {
        assertEquals(consumo.getCantEnergiaActiva(), 100);
    }

    @Test
    public void testGetEnergiaReactiva() {
        assertEquals(consumo.getCantEnergiaReactiva(), 50);
    }
}
