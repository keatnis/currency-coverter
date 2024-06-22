package com.keatnis.mod;

import com.keatnis.dao.Converter;
import com.keatnis.dao.ConvertirArchivo;
import com.keatnis.dao.HistorialConversion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private  ConvertirArchivo convertirArchivo = new ConvertirArchivo();
    private  Converter converter = new Converter();
    private  HistorialConversion historialConversion = new HistorialConversion();

    public Menu() {


        Scanner teclado = new Scanner(System.in);
        String monedas = """
                    ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
                     BIENVENIDO/A AL CONVERSOR DE MONEDAS
                    ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
                1. Elegir opciones de conversion prestablecidas             
                2. Conversor de monedas (personalizado)
                3. Monedas soportadas
                4. Mostrar historial de conversiones realizadas
                5. Salir

                Seleccione una opcion valida: """;


        int opcion = 0;

        do {
            System.out.println(monedas);
            try {

                opcion = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: introduzca un numero valido");
                teclado.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    submenu();
                    break;
                case 2:

                    try {
                        System.out.println("Ingrese el valor que desea convertir: ");
                        Double valor = teclado.nextDouble();
                        System.out.println(ejemplos);
                        System.out.println("Desde la moneda: ");
                        String monedaActual = teclado.next();
                        monedaActual.toUpperCase();
                        System.out.println("A la moneda: ");
                        String monedaConvertir = teclado.next();
                        monedaConvertir.toUpperCase();
                        System.out.println("Convirtiendo moneda ...");
                        Converter convertirMoneda = converter.realizarConversion(monedaActual, monedaConvertir, valor);
                        historialConversion.agregarConversion(convertirMoneda);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Indroduzca correctamente el codigo/valor");
                        teclado.next();
                        continue;
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                case 3:
                    System.out.println("A continuacion, se muestra una lista de las monedas soportadas");
                    String urlArchivoMonedas = "src/monedas.txt";
                    convertirArchivo.leerArchivo(urlArchivoMonedas);
                    break;
                case 4:

                    historialConversion.mostrarHistorial();
                    convertirArchivo.guardarConversiones(historialConversion.getConverterList());
                    break;
                case 5:

                    System.out.println("Gracias por usar nuestra aplicacion, hasta la proxima. " +
                            "\nSe generó el archivo con las conversiones realizadas.");
                    convertirArchivo.guardarConversiones(historialConversion.getConverterList());
                    break;
                default:
                    System.out.println(" *** Introduzca un opcion valida");

            }


        } while (opcion != 5);
        teclado.close();

    }

    private void submenu() {
        Scanner sc = new Scanner(System.in);
        String monedas = """
                ----------------------------
                            SUBMENÚ
                Opciones de Conversion [1-6]
                ----------------------------
                1. USD - Dólar estadounidense ==> ARS - Peso argentino
                2. ARS - Peso argentino       ==> USD - Dólar estadounidense
                3. USD - Dólar estadounidense ==> BRL - Real brasileño
                4. BRL - Real brasileño       ==> USD - Dólar estadounidense
                5. USD - Dólar estadounidense ==> MXN - Peso Mexicano
                6. MXN - Peso Mexicano        ==> USD - Dólar estadounidense
                7. Regresar al menu principal               
                Seleccione una opcion valida: """;

        int opcion = 0;
        while (opcion < 7) {
            Double valor = null;
            Converter conversion;
            try {
                System.out.println(monedas);
                opcion = sc.nextInt();
                if (opcion != 7) {
                    System.out.println("Ingres el valor que desea convertir");
                    valor = sc.nextDouble();
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Seleccione una opcion valida.");
                sc.next();
                continue;
            }


            switch (opcion) {
                case 1:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.realizarConversion("USD", "ARS", valor);
                    historialConversion.agregarConversion(conversion);
                    break;
                case 2:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.realizarConversion("ARS", "USD", valor);
                    historialConversion.agregarConversion(conversion);
                    break;
                case 3:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.realizarConversion("USD", "BRL", valor);
                    historialConversion.agregarConversion(conversion);
                    break;

                case 4:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.realizarConversion("BRL", "USD", valor);
                    historialConversion.agregarConversion(conversion);
                    break;
                case 5:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.realizarConversion("USD", "MXN", valor);
                    historialConversion.agregarConversion(conversion);
                    break;
                case 6:
                    System.out.printf("Convirtiendo ... \n");
                    conversion = converter.realizarConversion("MXN", "USD", valor);
                    historialConversion.agregarConversion(conversion);
                    break;
                case 7:
                    System.out.println(" **  Regresando al menu principal ** ");
                    break;

                default:
                    break;

            }


        }
    }

    String ejemplos = "\n *NOTA: Para hacer las conversiones debe de escribir el código (3 letras) de la moneda, por ejemplo: \n" +
            "  | USD - Dólar estadounidense \t" +
            "  | ARS - Peso argentino \t" +
            "  | BRL - Real brasileño\t" +
            "  | MXN - Peso Mexicano \t";
}

