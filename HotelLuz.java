import java.util.Random;

public class HotelLuz {

    public static void main(String[] args) {

        // Generar un numero de hoteles aleatorio
        Random random = new Random();
        int numHoteles = random.nextInt(3) + 1;

        // Inicializar variables horas encendidas y el gasto total
        double horasEncendidas = 0.0;
        double gastoTotal = 0.0;

        // Simulación de cada hotel
        for (int hotel = 1; hotel <= numHoteles; hotel++) {

            // Generar un número aleatorio de pisos por hotel
            int numPisos = random.nextInt(4) + 1;
            System.out.println("Numero Hotel " + hotel + ":");

            for (int piso = 1; piso <= numPisos; piso++) {

                // Generamos un número aleatorio de horas que las luces estuvieron encendidas
                horasEncendidas = random.nextInt(24);

                // Generamos un número aleatorio para el tipo de luz
                int tipoLuz = random.nextInt(3) + 1;

                // Definimos el costo por hora para cada tipo de luz
                double costoPorHora;

                if (tipoLuz == 1) {
                    costoPorHora = 0.25; // Tipo de luz 1
                } else if (tipoLuz == 2) {
                    costoPorHora = 0.50; // Tipo de luz 2
                } else {
                    costoPorHora = 1; // Tipo de luz 3
                }

                // Calculamos el gasto en luces para este piso del hotel
                double gastoPiso = horasEncendidas * costoPorHora;

                // Agregamos el gasto de este piso al gasto total
                gastoTotal += gastoPiso;

                // Imprimimos información sobre el piso
                System.out.println("Numero del hotel " + hotel + ", Numero de piso " + piso + ":");
                System.out.println("Horas encendidas: " + horasEncendidas);
                System.out.println("Tipo de luz: " + tipoLuz);
                System.out.println("Gasto en luces: $" + gastoPiso);
                System.out.println("________");

                // Imprimimos el gasto total en luces para todos los hoteles
                System.out.println("Gasto total en luces para " + hotel + " hoteles: $" + gastoTotal );

            }
        }

    }
}