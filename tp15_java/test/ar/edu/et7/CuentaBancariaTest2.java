package ar.edu.et7;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CuentaBancariaTest2 {

	 @Test
	    void testDepositoArs() {
		 CuentaBancaria cuenta = new CuentaBancaria();
	        boolean resultado = cuenta.deposito("ARS", 500L);
	        long saldo = cuenta.saldo();
	        assertEquals(resultado, saldo);
	    }
}
