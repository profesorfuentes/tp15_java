package ar.edu.et7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

	 //Test cuenta ARS deposito
	 //	@Test
	 //   void testDepositoArs() { 
	//	    CuentaBancaria cuenta = new CuentaBancaria();
	 //       boolean resultado = cuenta.deposito("ARS", 500L);
	 //       assertTrue(resultado);
	  //      long saldo = cuenta.saldo("ARS");
	  //      assertEquals(500L, saldo);
	  //  }
	 
	 //TODO Test cuenta USD deposito

	 //TODO Test cuenta ARS extracción menor al saldo
	 
	 //TODO Test cuenta USD extracción menor al saldo
	 
	 //TODO Test cuenta ARS extraccion mayor al saldo
	 
	 //TODO Test cuenta USD extraccion mayor al saldo
	 
	 //TODO Test cuenta ARS extraccion igual al saldo
	 @Test
	    void testExtraccionIgualSaldo() {
		    CuentaBancaria cuenta = new CuentaBancaria();
	        boolean resultado = cuenta.deposito("ARS", 500L);
	        long saldo = cuenta.saldo("ARS");
	        resultado = cuenta.extraccion("ARS", saldo);
	        assertTrue(resultado);
	        saldo = cuenta.saldo("ARS");
	        assertEquals(0L, saldo);
	    }
	 
	 //TODO Test cuenta USD extraccion igual al saldo
	 
	 //TODO Test simular cuota prestamo sistema frances
	 
	 //TODO Test cambio de moneda
}
