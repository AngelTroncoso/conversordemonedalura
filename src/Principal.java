import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
//variables
        int opcion=0;
        double cantidad = 0;
        double convertir = 0;
        String monedaOrigen;
        String monedaDestino;

        Scanner lectura = new Scanner(System.in);

        //Instanciamos un objeto de la clase Conversion para usar sus metodos para convertir
        Convertidor conversion = new Convertidor();

        //Instanciamos un objeto de tipo ConsultaAPI
        ConexionApi consultaAPI = new ConexionApi();
        //Instanciamos un objeto de clase Record JsonToClass y lo inicializamos con
        //el objeto consultaAPI para usar el metodo consultarApi() y pueda almacenar la informacion de la
        //clave conversion_rates que viene del json, en un map
        JsonClass jsonToClass = consultaAPI.consultarApi();
        //System.out.println("Json a Clase: "+jsonToAPI);

        //Menu de usuario
        do {
            try { //excepcion para cuando el usuario no ingrese una opcion valida
                System.out.println("""
                        \nSea bienvenido/a al Conversor de Monedas
                        ********************************************************
                        1) Dolar =>> Peso Chileno (CLP)
                        2) Peso Chileno ==> Dolar
                        3) Dolar ==> Real brasileño (BRL)
                        4) Real Brasileño ==> Dolar
                        5) Dolar ==> Euro (EUR)
                        6) Euro ==> Dolar
                        7) Convertir entre otras monedas
                        8) Consultar códigos ISO de otras monedas
                        9) Salir
                        ********************************************************
                        Elija una opcion válida: 
                        """);
                opcion = lectura.nextInt();

                //switch para ejecutar las acciones de cada opcion del menu
                switch (opcion) {
                    case 1:
                        conversion.imprimirSolicitarCantidad("USD", "CLP");
                        cantidad = lectura.nextDouble(); //leemos la cantidad ingresada por el usuario
                        convertir = conversion.convertirMonedas("USD", "CLP", cantidad);
                        conversion.imprimirResultado(cantidad, "USD", convertir, "CLP");
                        break;
                    case 2:
                        conversion.imprimirSolicitarCantidad("CLP", "USD");
                        cantidad = lectura.nextDouble();
                        convertir = conversion.convertirMonedas("CLP", "USD", cantidad);
                        conversion.imprimirResultado(cantidad, "CLP", convertir, "USD");
                        break;
                    case 3:
                        conversion.imprimirSolicitarCantidad("USD", "BRL");
                        cantidad = lectura.nextDouble();
                        convertir = conversion.convertirMonedas("USD", "BRL", cantidad);
                        conversion.imprimirResultado(cantidad, "USD", convertir, "BRL");
                        break;
                    case 4:
                        conversion.imprimirSolicitarCantidad("BRL", "USD");
                        cantidad = lectura.nextDouble();
                        convertir = conversion.convertirMonedas("BRL", "USD", cantidad);
                        conversion.imprimirResultado(cantidad, "BRL", convertir, "USD");
                        break;
                    case 5:
                        conversion.imprimirSolicitarCantidad("USD", "EUR");
                        cantidad = lectura.nextDouble();
                        convertir = conversion.convertirMonedas("USD", "EUR", cantidad);
                        conversion.imprimirResultado(cantidad, "USD", convertir, "EUR");
                        break;
                    case 6:
                        conversion.imprimirSolicitarCantidad("EUR", "USD");
                        cantidad = lectura.nextDouble();
                        convertir = conversion.convertirMonedas("EUR", "USD", cantidad);
                        conversion.imprimirResultado(cantidad, "EUR", convertir, "USD");
                        break;
                    case 7:
                        System.out.println("Ingresa el código de la moneda origen: ");
                        monedaOrigen = lectura.next().toUpperCase(); //convertimos a mayuscula la
                        System.out.println("Ingresa el código de la moneda destino: ");
                        monedaDestino = lectura.next().toUpperCase();
                        System.out.println("Ingresa la cantidad a convertir: ");
                        cantidad = lectura.nextDouble();
                        convertir = conversion.convertirMonedas(monedaOrigen, monedaDestino, cantidad);
                        conversion.imprimirResultado(cantidad, monedaOrigen, convertir, monedaDestino);
                        break;
                    case 8:
                        //Imprimimos el map que contiene las tasas de cambio
                        //System.out.println("Códigos de monedas: " +jsonToClass.conversion_rates());
                        conversion.imprimirCodigoMonedas();
                        break;
                    case 9:
                        System.out.println("Saliendo del programa. Gracias por utilizar nuestros servicios.");
                        break;
                    default:
                        System.out.println("Opcion no valida!!!");
                }
            } catch(NullPointerException e){
                System.out.println("Error: Una o más divisas no fueron encontradas, verifique.");
                lectura.nextLine(); // Limpiar el buffer del scanner después de la excepción
            } catch (Exception e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
                lectura.nextLine();
            }
        } while (opcion != 9);

    }
}

