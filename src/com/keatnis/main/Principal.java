package com.keatnis.main;

import com.keatnis.dao.Converter;
import com.keatnis.dao.ConvertirArchivo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Converter consultaAPI = new Converter();
        ConvertirArchivo convertirArchivo = new ConvertirArchivo();
        Scanner teclado = new Scanner(System.in);
        String monedas = """
                    ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
                     BIENVENIDO/A AL CONVERSOR DE MONEDAS
                    ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
                              
                1. Conversor de monedas
                2. Monedas soportadas
                3. Mostrar historial de conversiones realizadas
                4. Salir

                Seleccione una opcion valida: """;

        String ejemplos = "*NOTA: Para hacer las conversiones debe de escribir las siglas de la moneda, aqui se muestran algunos ejemplos: \n" +
                "  USD - Dólar estadounidense \n" +
                "  ARS - Peso argentino \n" +
                "  BRL - Real brasileño\n" +
                "  MXN - Peso Mexicano ";
        int opcion = 0;

        while (opcion != 8) {
            System.out.println(monedas);
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
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
                    consultaAPI.convertirMoneda(monedaActual, monedaConvertir, valor);
                    break;

                case 2:
                    System.out.println("A continuacion, se muestra una lista de las monedas soportadas");
                    convertirArchivo.leerArchivo();
                    break;
                case 3:
                    consultaAPI.gethistorial();
                    break;
                case 4:
                    System.out.println("Gracias por usar nuestra aplicacion, hasta la proxima.");
                    break;
                default:
                    break;
            }

        }

    }
}
