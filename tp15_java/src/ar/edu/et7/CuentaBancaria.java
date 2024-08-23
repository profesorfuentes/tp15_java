package ar.edu.et7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ar.edu.et7.services.Persistencia;

public class CuentaBancaria extends AbstractCuentaBancaria {
    private long saldoArs;
    private long saldoUsd;
    private Persistencia persistencia;

    // Constructor por defecto
    public CuentaBancaria() {
        this(new Persistencia()); // Utiliza una instancia de Persistencia por defecto
    }
  
    
    // Constructor que acepta una instancia de Persistencia
    public CuentaBancaria(Persistencia persistencia) {
        this.persistencia = persistencia;
        saldoArs = persistencia.leerSaldo("ARS");
        saldoUsd = persistencia.leerSaldo("USD");
    }

    @Override
    public boolean deposito(String moneda, long importe) {
        if (importe <= 0) return false;

        if (moneda.equalsIgnoreCase("ARS")) {
            saldoArs += importe;
            persistencia.guardarSaldo(saldoArs, "ARS");
        } else if (moneda.equalsIgnoreCase("USD")) {
            saldoUsd += importe;
            persistencia.guardarSaldo(saldoUsd, "USD");
        } else {
            return false;
        }

        persistencia.guardarMovimiento("Deposito " + moneda, LocalDateTime.now(), importe);
        return true;
    }

    @Override
    public boolean extraccion(String moneda, long importe) {
        if (importe <= 0) return false;

        if (moneda.equalsIgnoreCase("ARS") && saldoArs >= importe) {
            saldoArs -= importe;
            persistencia.guardarSaldo(saldoArs, "ARS");
        } else if (moneda.equalsIgnoreCase("USD") && saldoUsd >= importe) {
            saldoUsd -= importe;
            persistencia.guardarSaldo(saldoUsd, "USD");
        } else {
            return false;
        }

        persistencia.guardarMovimiento("Extraccion " + moneda, LocalDateTime.now(), -importe);
        return true;
    }

    @Override
    public String generarReporteSaldo() {
        return "Saldo ARS: " + saldoArs + "\nSaldo USD: " + saldoUsd;
    }

    @Override
    public String simularPrestamo(long importe, int cuotas) {
        double tasaInteres = 0.05;
        double cuotaMensual = (importe * tasaInteres * Math.pow(1 + tasaInteres, cuotas)) / (Math.pow(1 + tasaInteres, cuotas) - 1);
        return "Cuota Mensual: " + Math.round(cuotaMensual) + " durante " + cuotas + " meses.";
    }
}
