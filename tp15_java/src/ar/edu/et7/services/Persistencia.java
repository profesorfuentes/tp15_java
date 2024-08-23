package ar.edu.et7.services;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    private static final String SALDO_FILE = "saldo.csv";
    private static final String MOVIMIENTOS_FILE = "movimientos.csv";

    public void guardarSaldo(long saldo, String moneda) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SALDO_FILE))) {
            writer.write("saldo_ars,saldo_usd\n");
            if (moneda.equalsIgnoreCase("ARS")) {
                writer.write(saldo + "," + leerSaldo("USD") + "\n");
            } else if (moneda.equalsIgnoreCase("USD")) {
                writer.write(leerSaldo("ARS") + "," + saldo + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long leerSaldo(String moneda) {
        try (BufferedReader reader = new BufferedReader(new FileReader(SALDO_FILE))) {
            String line;
            reader.readLine(); // Skip header
            if ((line = reader.readLine()) != null) {
                String[] saldos = line.split(",");
                return moneda.equalsIgnoreCase("ARS") ? Long.parseLong(saldos[0]) : Long.parseLong(saldos[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void guardarMovimiento(String movimiento, LocalDateTime timestamp, long importe) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MOVIMIENTOS_FILE, true))) {
            writer.write(movimiento + "," + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "," + importe + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> leerMovimientos() {
        List<String> movimientos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MOVIMIENTOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                movimientos.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movimientos;
    }
}
