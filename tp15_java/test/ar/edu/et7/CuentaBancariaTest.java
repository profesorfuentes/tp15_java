package ar.edu.et7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.et7.services.Persistencia;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

class CuentaBancariaTest {

    private CuentaBancaria cuenta;
    private Persistencia mockPersistencia;

    @BeforeEach
    void setUp() {
        mockPersistencia = mock(Persistencia.class);
        when(mockPersistencia.leerSaldo("ARS")).thenReturn(1000L);
        when(mockPersistencia.leerSaldo("USD")).thenReturn(500L);

        // Se pasa la instancia mock de Persistencia al constructor de CuentaBancaria
        cuenta = new CuentaBancaria(mockPersistencia);
    }

    @Test
    void testDepositoArs() {
        boolean resultado = cuenta.deposito("ARS", 500L);
        assertTrue(resultado);
        verify(mockPersistencia).guardarSaldo(1500L, "ARS");
        verify(mockPersistencia).guardarMovimiento("Deposito ARS", any(LocalDateTime.class), 500L);
    }

    @Test
    void testDepositoUsd() {
        boolean resultado = cuenta.deposito("USD", 300L);
        assertTrue(resultado);
        verify(mockPersistencia).guardarSaldo(800L, "USD");
        verify(mockPersistencia).guardarMovimiento("Deposito USD", any(LocalDateTime.class), 300L);
    }

    @Test
    void testExtraccionArs() {
        boolean resultado = cuenta.extraccion("ARS", 500L);
        assertTrue(resultado);
        verify(mockPersistencia).guardarSaldo(500L, "ARS");
        verify(mockPersistencia).guardarMovimiento("Extraccion ARS", any(LocalDateTime.class), -500L);
    }

    @Test
    void testExtraccionUsd() {
        boolean resultado = cuenta.extraccion("USD", 200L);
        assertTrue(resultado);
        verify(mockPersistencia).guardarSaldo(300L, "USD");
        verify(mockPersistencia).guardarMovimiento("Extraccion USD", any(LocalDateTime.class), -200L);
    }

    @Test
    void testExtraccionArsSaldoInsuficiente() {
        boolean resultado = cuenta.extraccion("ARS", 1500L);
        assertFalse(resultado);
        verify(mockPersistencia, never()).guardarSaldo(anyLong(), eq("ARS"));
        verify(mockPersistencia, never()).guardarMovimiento(anyString(), any(LocalDateTime.class), anyLong());
    }

    @Test
    void testExtraccionUsdSaldoInsuficiente() {
        boolean resultado = cuenta.extraccion("USD", 600L);
        assertFalse(resultado);
        verify(mockPersistencia, never()).guardarSaldo(anyLong(), eq("USD"));
        verify(mockPersistencia, never()).guardarMovimiento(anyString(), any(LocalDateTime.class), anyLong());
    }

    @Test
    void testGenerarReporteSaldo() {
        String reporte = cuenta.generarReporteSaldo();
        assertEquals("Saldo ARS: 1000\nSaldo USD: 500", reporte);
    }

    @Test
    void testSimularPrestamo() {
        String resultado = cuenta.simularPrestamo(10000L, 12);
        assertTrue(resultado.startsWith("Cuota Mensual:"));
    }
}
