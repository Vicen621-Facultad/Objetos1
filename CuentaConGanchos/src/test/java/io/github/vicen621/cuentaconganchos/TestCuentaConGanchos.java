package io.github.vicen621.cuentaconganchos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCuentaConGanchos {

    private CajaDeAhorro cajaDeAhorro;
    private CuentaCorriente cuentaCorriente;

    @BeforeEach
    public void setup() {
        cajaDeAhorro = new CajaDeAhorro();
        cuentaCorriente = new CuentaCorriente();
        cuentaCorriente.depositar(1000);
        cuentaCorriente.setLimiteDeDescubierto(-100);
        cajaDeAhorro.depositar(1000);
    }

    @Test
    public void test_get_saldo() {
        assertEquals(1000, cajaDeAhorro.getSaldo());
        assertEquals(1000, cuentaCorriente.getSaldo());
    }

    @Test
    public void test_depositar() {
        cajaDeAhorro.depositar(10);
        cuentaCorriente.depositar(10);
        assertEquals(1010, cajaDeAhorro.getSaldo());
        assertEquals(1010, cuentaCorriente.getSaldo());
    }

    @Test
    public void test_extraer_sin_controlar() {
        cajaDeAhorro.extraerSinControlar(100);
        cuentaCorriente.extraerSinControlar(100);
        assertEquals(898, cajaDeAhorro.getSaldo());
        assertEquals(900, cuentaCorriente.getSaldo());
    }

    @Test
    public void test_puede_extraer_true() {
        assertTrue(cajaDeAhorro.puedeExtraer(100));
        assertTrue(cajaDeAhorro.puedeExtraer(980));

        assertTrue(cuentaCorriente.puedeExtraer(100));
        assertTrue(cuentaCorriente.puedeExtraer(1100));
    }

    @Test
    public void test_puede_extraer_false() {
        assertFalse(cajaDeAhorro.puedeExtraer(981));
        assertFalse(cuentaCorriente.puedeExtraer(1101));
    }

    @Test
    public void test_extraer_true() {
        assertTrue(cajaDeAhorro.extraer(100));
        assertTrue(cuentaCorriente.extraer(100));
        assertEquals(898, cajaDeAhorro.getSaldo());
        assertEquals(900, cuentaCorriente.getSaldo());

        // Testeo que la cuenta corriente pueda extraer y quedar en negativo
        assertTrue(cuentaCorriente.extraer(1000));
        assertEquals(-100, cuentaCorriente.getSaldo());
    }

    @Test
    public void test_extraer_false() {
        assertFalse(cajaDeAhorro.extraer(981));
        assertFalse(cuentaCorriente.extraer(1101));
        assertEquals(1000, cajaDeAhorro.getSaldo());
        assertEquals(1000, cuentaCorriente.getSaldo());
    }

    @Test
    public void test_transferir_a_cuenta_true() {
        assertTrue(cajaDeAhorro.transferirACuenta(100, cuentaCorriente));
        assertEquals(898, cajaDeAhorro.getSaldo());
        assertEquals(1100, cuentaCorriente.getSaldo());

        assertTrue(cuentaCorriente.transferirACuenta(100, cajaDeAhorro));
        assertEquals(998, cajaDeAhorro.getSaldo());
        assertEquals(1000, cuentaCorriente.getSaldo());

        // Testeo que la cuenta corriente puede hacer transferencia e ir a negativo
        assertTrue(cuentaCorriente.transferirACuenta(1100, cajaDeAhorro));
        assertEquals(2098, cajaDeAhorro.getSaldo());
        assertEquals(-100, cuentaCorriente.getSaldo());
    }

    @Test
    public void test_transferir_a_cuenta_false() {
        assertFalse(cajaDeAhorro.transferirACuenta(981, cuentaCorriente));
        assertEquals(1000, cajaDeAhorro.getSaldo());
        assertEquals(1000, cuentaCorriente.getSaldo());

        assertFalse(cuentaCorriente.transferirACuenta(1101, cajaDeAhorro));
        assertEquals(1000, cajaDeAhorro.getSaldo());
        assertEquals(1000, cuentaCorriente.getSaldo());
    }
}
