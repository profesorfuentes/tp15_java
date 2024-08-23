package ar.edu.et7;

public abstract class AbstractCuentaBancaria {
	abstract boolean deposito(String moneda, long importe);
	abstract boolean extraccion(String moneda, long importe);
	abstract boolean compra(String moneda, long importe);
	abstract long saldo(String moneda);
	abstract String generarReporteSaldo();
	abstract long simularCuotaPrestamoSistemaFrances(long importe, int cuotas);
}