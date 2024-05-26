import com.google.gson.Gson;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaAPI consultaAPI = new ConsultaAPI();
        Scanner teclado = new Scanner(System.in);
        String monedas = """
                ----------------------------
                Bienvenido/a al conversor de monedas
                ----------------------------
                1. USD - Dólar estadounidense ==> ARS - Peso argentino
                2. ARS - Peso argentino       ==> USD - Dólar estadounidense
                3. USD - Dólar estadounidense ==> BRL - Real brasileño
                4. BRL - Real brasileño       ==> USD - Dólar estadounidense
                5. USD - Dólar estadounidense ==> MXN - Peso Mexicano
                6. MXN - Peso Mexicano        ==> USD - Dólar estadounidense
                7. Otra moneda
                8. Salir
                        
                Seleccione una opcion valida: """;

        int opcion = 0;

        while (opcion != 8) {
            System.out.println(monedas);
            opcion = teclado.nextInt();
            System.out.println("Ingres el valor que desea convertir");
            Double valor = teclado.nextDouble();
            switch (opcion) {
                case 1:
                    System.out.printf("Convirtiendo ... \n");
                    consultaAPI.obtenerValorMoneda("USD", "ARS", valor);
                    break;
                case 2:
                    System.out.printf("Convirtiendo ... \n");
                    consultaAPI.obtenerValorMoneda("ARS", "USD", valor);
                    break;
                case 3:
                    System.out.printf("Convirtiendo ... \n");
                    consultaAPI.obtenerValorMoneda("USD", "BRL", valor);
                    break;

                case 4:
                    System.out.printf("Convirtiendo ... \n");
                    consultaAPI.obtenerValorMoneda("BRL", "USD", valor);
                    break;
                case 5:
                    System.out.printf("Convirtiendo ... \n");
                    consultaAPI.obtenerValorMoneda("USD", "MXN", valor);
                    break;
                case 6:
                    System.out.printf("Convirtiendo ... \n");
                    consultaAPI.obtenerValorMoneda("MXN", "USD", valor);
                    break;
                case 7:
                    System.out.printf(" **** Para convertir otra moneda debe conocer las siglas de la moneda: \n");
                    System.out.println("Escriba las siglas de la moneda actual");
                    String monedaActual = teclado.next();
                    monedaActual.toUpperCase();
                    System.out.println("Esciba las siglas de la moneda a la que desea convertir");
                    String monedaConvertir = teclado.next();
                    monedaConvertir.toUpperCase();
                    System.out.println("Convirtiendo moneda ...");
                    consultaAPI.obtenerValorMoneda(monedaActual, monedaConvertir, valor);
                    break;
                default:
                    break;
            }

        }
    }
}
