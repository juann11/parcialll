import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Transaccion {
    int id;
    Date fecha;
    double monto;

    public Transaccion(int id, Date fecha, double monto) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
    }
}

public class MayorDineroPorDiaSemana {
    public static void main(String[] args) {
        String nombreArchivo = "transacciones.txt"; // ubicación de archivo de transacciones

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            Map<Integer, Double> dineroPorDiaSemana = new HashMap<>();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();

            while ((linea = br.readLine()) != null) {
                

                String[] partes = linea.split(",");
                Date fecha = dateFormat.parse(partes[0]);
                double monto = Double.parseDouble(partes[1]);

                calendar.setTime(fecha);
                int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

                if (dineroPorDiaSemana.containsKey(diaSemana)) {
                    double sumaActual = dineroPorDiaSemana.get(diaSemana);
                    dineroPorDiaSemana.put(diaSemana, sumaActual + monto);
                } else {
                    dineroPorDiaSemana.put(diaSemana, monto);
                }
            }

            int diaSemanaMayorDinero = 0;
            double mayorSumaDinero = 0.0;

            for (Map.Entry<Integer, Double> entry : dineroPorDiaSemana.entrySet()) {
                int diaSemana = entry.getKey();
                double sumaDinero = entry.getValue();

                if (sumaDinero > mayorSumaDinero) {
                    diaSemanaMayorDinero = diaSemana;
                    mayorSumaDinero = sumaDinero;
                }
            }

            String[] diasSemana = {"", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
            System.out.println("El día de la semana con la mayor cantidad de dinero es: " + diasSemana[diaSemanaMayorDinero]);
            System.out.println("Monto total: " + mayorSumaDinero);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

public class MayorDineroPromedioPorHora {
    public static void main(String[] args) {
        String nombreArchivo = "transacciones.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            Map<Integer, Double> dineroPorHora = new HashMap();
            Map<Integer, Integer> conteoPorHora = new HashMap();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();

            while ((linea = br.readLine()) != null) {
                
                String[] partes = linea.split(",");
                Date fecha = dateFormat.parse(partes[0]);
                double monto = Double.parseDouble(partes[1]);

                calendar.setTime(fecha);
                int hora = calendar.get(Calendar.HOUR_OF_DAY);

                
                dineroPorHora.put(hora, dineroPorHora.getOrDefault(hora, 0.0) + monto);
                conteoPorHora.put(hora, conteoPorHora.getOrDefault(hora, 0) + 1);
            }

            // hora con la mayor suma de dinero en promedio
            int horaMayorDineroPromedio = 0;
            double mayorPromedio = 0.0;

            for (int hora : dineroPorHora.keySet()) {
                double sumaDinero = dineroPorHora.get(hora);
                int conteo = conteoPorHora.get(hora);
                double promedio = sumaDinero / conteo;

                if (promedio > mayorPromedio) {
                    horaMayorDineroPromedio = hora;
                    mayorPromedio = promedio;
                }
            }

            System.out.println("La hora del día con la mayor cantidad de dinero en promedio es: " + horaMayorDineroPromedio + ":00");
            System.out.println("Promedio total: " + mayorPromedio);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

public class BuscarTransaccionPorID {
    public static void main(String[] args) {
        String nombreArchivo = "transacciones.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Transaccion transaccionEncontrada = null;

            
            int idBuscado = obtenerIDUsuario();

            while ((linea = br.readLine()) != null) {
               
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                Date fecha = dateFormat.parse(partes[1]);
                double monto = Double.parseDouble(partes[2]);

                if (id == idBuscado) {
                    transaccionEncontrada = new Transaccion(id, fecha, monto);
                    break; 
                }
            }

            if (transaccionEncontrada != null) {
                System.out.println("Transacción encontrada:");
                System.out.println("ID: " + transaccionEncontrada.id);
                System.out.println("Fecha: " + dateFormat.format(transaccionEncontrada.fecha));
                System.out.println("Monto: " + transaccionEncontrada.monto);
            } else {
                System.out.println("Transacción no encontrada con el ID proporcionado.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
