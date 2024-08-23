package ar.edu.et7;

import java.util.List;
import java.util.Scanner;

import ar.edu.et7.services.Persistencia;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persistencia persistencia = new Persistencia();
        CuentaBancaria cuenta = new CuentaBancaria(persistencia);
        String command;

        while (true) {
            System.out.print("Comando: ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("salir")) {
                break;
            }

            switch (command.toLowerCase()) {
                case "deposito":
                    System.out.print("Moneda (ARS/USD): ");
                    String moneda = scanner.nextLine();
                    System.out.print("Importe: ");
                    long importe = Long.parseLong(scanner.nextLine());
                    if (cuenta.deposito(moneda, importe)) {
                        System.out.println("Deposito exitoso.");
                    } else {
                        System.out.println("Deposito fallido.");
                    }
                    break;

                case "extraccion":
                    System.out.print("Moneda (ARS/USD): ");
                    moneda = scanner.nextLine();
                    System.out.print("Importe: ");
                    importe = Long.parseLong(scanner.nextLine());
                    if (cuenta.extraccion(moneda, importe)) {
                        System.out.println("Extracción exitosa.");
                    } else {
                        System.out.println("Extracción fallida.");
                    }
                    break;

                case "saldo":
                    System.out.println(cuenta.generarReporteSaldo());
                    break;

                case "prestamo":
                    System.out.print("Importe: ");
                    importe = Long.parseLong(scanner.nextLine());
                    System.out.print("Cuotas: ");
                    int cuotas = Integer.parseInt(scanner.nextLine());
                    System.out.println(cuenta.simularCuotaPrestamoSistemaFrances(importe, cuotas));
                    break;

                case "movimientos":
                    List<String> movimientos = persistencia.leerMovimientos();
                    for (String mov : movimientos) {
                        System.out.println(mov);
                    }
                    break;

                default:
                    System.out.println("Comando no reconocido.");
                    break;
            }
        }

        scanner.close();
    }
}
