package ar.edu.et7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

	
	void testSimularCuotaPrestamoFrances() {
        // Datos del préstamo
        long montoPrestamo = 10000; // Monto del préstamo
        //double tasaInteresAnual = 5.0;  // Tasa de interés anual en porcentaje
        //int numeroAnios = 2;           // Duración del préstamo en años
        int cantidadCuotas = 3;

        CuentaBancaria c = new CuentaBancaria();
        
        // Calcular la cuota mensual usando la calculadora de préstamo
        double cuotaCalculada = c.simularCuotaPrestamoSistemaFrances(montoPrestamo, cantidadCuotas);

        // Valor esperado para la cuota mensual, puede variar ligeramente
        double cuotaEsperadaAproximada = 438.71; // Ajusta este valor según el cálculo exacto

        // Comprobar que la cuota calculada es aproximadamente igual a la esperada
        assertEquals(cuotaEsperadaAproximada, cuotaCalculada, 0.01);
    }

	 
	 //TODO Test cuenta USD deposito

	 //TODO Test cuenta ARS extracción menor al saldo
	 
	 //TODO Test cuenta USD extracción menor al saldo
	 
	 //TODO Test cuenta ARS extraccion mayor al saldo
	 
	 //TODO Test cuenta USD extraccion mayor al saldo
	 
	 //TODO Test cuenta ARS extraccion igual al saldo
	 
	 //TODO Test cuenta USD extraccion igual al saldo
	 
	 //TODO Test simular cuota prestamo sistema frances
	 
	 //TODO Test cambio de moneda
}
