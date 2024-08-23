package ar.edu.et7;

public abstract class AbstractCuentaBancaria {
	abstract boolean deposito(String moneda, long importe);
	abstract boolean extraccion(String moneda, long importe);
	abstract String generarReporteSaldo();
	abstract String simularPrestamo(long importe, int cuotas);
}