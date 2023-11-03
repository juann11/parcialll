import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Transaccion {
    private String id;
    private Date fecha;
    private double monto;

    public Transaccion(String id, Date fecha, double monto) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }
}

public class AnalisisTransacciones {

    public static void main(String[] args) throws IOException, ParseException {
        List<Transaccion> transacciones = leerTransaccionesDesdeArchivo("transacciones.txt");

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Día de la semana con más transacciones de dinero");
            System.out.println("2. Hora del día con más transacciones de dinero promedio");
            System.out.println("3. Buscar información de una transacción por ID");
            System.out.println("4. Visualizar N datos de un día específico");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    calcularDiaMasTransacciones(transacciones);
                    break;
                case 2:
                    calcularHoraMasTransaccionesPromedio(transacciones);
                    break;
                case 3:
                    buscarTransaccionPorID(transacciones);
                    break;
                case 4:
                    visualizarDatosDeDiaEspecifico(transacciones);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    private static List<Transaccion> leerTransaccionesDesdeArchivo(String nombreArchivo) throws IOException, ParseException {
        List<Transaccion> transacciones = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            String id = partes[0];
            Date fecha = dateFormat.parse(partes[1]);
            double monto = Double.parseDouble(partes[2]);
            Transaccion transaccion = new Transaccion(id, fecha, monto);
            transacciones.add(transaccion);
        }
        br.close();

        return transacciones;
    }

    private static void calcularDiaMasTransacciones(List<Transaccion> transacciones) {
        // Lógica para calcular el día de la semana con más transacciones de dinero
        // ...
    }

    private static void calcularHoraMasTransaccionesPromedio(List<Transaccion> transacciones) {
        // Lógica para calcular la hora del día con más transacciones de dinero en promedio
        // ...
    }

    private static void buscarTransaccionPorID(List<Transaccion> transacciones) {
        // Lógica para buscar información de una transacción por ID
        // ...
    }

    private static void visualizarDatosDeDiaEspecifico(List<Transaccion> transacciones) {
        // Lógica para visualizar N datos de un día específico
        // ...
    }
}
