package ar.edu.et7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

    // Test cuenta ARS deposito
    @Test
    void testDepositoArs() {
        CuentaBancaria cuenta = new CuentaBancaria();
        boolean resultado = cuenta.deposito("ARS", 1010L);
        assertTrue(resultado);
        long saldo = cuenta.saldo("ARS");
        assertEquals(1010L, saldo);
    }

    // Test cuenta USD extracción igual al saldo
    @Test
    void testExtraccionUsdIgualAlSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria();
        // Primero, realizamos un depósito en USD
        boolean depositoExitoso = cuenta.deposito("USD", 1000L);
        assertTrue(depositoExitoso);

        // Verificamos que el saldo sea el esperado
        long saldoInicial = cuenta.saldo("USD");
        assertEquals(1000L, saldoInicial);

        // Realizamos una extracción igual al saldo
        boolean extraccionExitoso = cuenta.extraccion("USD", 1000L);
        assertTrue(extraccionExitoso);

        // Verificamos que el saldo sea 0 después de la extracción
        long saldoFinal = cuenta.saldo("USD");
        assertEquals(0L, saldoFinal);
    }

	 
	 //TODO Test cuenta USD deposito

	 //TODO Test cuenta ARS extracción menor al saldo
	 
	 //TODO Test cuenta USD extracción menor al saldo
	 
	 //TODO Test cuenta ARS extraccion mayor al saldo
	 
	 //TODO Test cuenta USD extraccion mayor al saldo
	 
	 //TODO Test cuenta ARS extraccion igual al saldo
	 
	 //TODO Test cuenta USD extraccion igual al saldo *
	 
	 //TODO Test simular cuota prestamo sistema frances
	 
	 //TODO Test cambio de moneda
}
