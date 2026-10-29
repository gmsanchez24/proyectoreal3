import java.util.Scanner;
import java.util.Random;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static void main(String[] args) throws Exception {

        
    }

    public static void ejercicioLaCifraExacta() {
        System.out.println("PRUEBA 3.1 LA CIFRA EXACTA");

        System.out.println("TURNO DEL JUGADOR 1");
        double diferenciaJugador1 = jugarPartidaCifras();

        System.out.println("TURNO DEL JUGADOR 2");
        double diferenciaJugador2 = jugarPartidaCifras();

        System.out.println("RESULTADOS FINALES");
        System.out.println("Diferencia Jugador 1: " + diferenciaJugador1);
        System.out.println("Diferencia Jugador 2: " + diferenciaJugador2);

        if (diferenciaJugador1 < diferenciaJugador2) {
            System.out.println("Ha ganado el Jugador 1 por estar mas cerca del objetivo!");
        } else if (diferenciaJugador2 < diferenciaJugador1) {
            System.out.println("Ha ganado el Jugador 2 por estar mas cerca del objetivo!");
        } else {
            System.out.println("Empate. Los dos jugadores obtuvieron la misma diferencia.");
        }
    }

    public static double jugarPartidaCifras() {

        int objetivo = r.nextInt(900) + 100;

        System.out.println("Numero objetivo: " + objetivo);
        System.out.print("Numeros auxiliares: ");

        for (int i = 0; i < 6; i++) {
            int aux = r.nextInt(10) + 1;
            System.out.print(aux + " ");
        }
        System.out.println("\n------------------------------");

        System.out.print("Introduce tu numero inicial: ");
        double total = sc.nextDouble();
        sc.nextLine();

        for (int paso = 1; paso <= 5; paso++) {
            System.out.println("--- Operacion " + paso + " de 5 (Llevas: " + total + ") ---");

            System.out.print("Elige operacion (+, -, *, /): ");
            String seleccionOperacion = sc.nextLine();

            System.out.print("Introduce el siguiente numero: ");
            double siguienteNum = sc.nextDouble();
            sc.nextLine();

            if (seleccionOperacion.equals("+")) {
                total += siguienteNum;
            } else if (seleccionOperacion.equals("-")) {
                total -= siguienteNum;
            } else if (seleccionOperacion.equals("*")) {
                total *= siguienteNum;
            } else if (seleccionOperacion.equals("/")) {
                if (siguienteNum == 0) {
                    System.out.println("Error. No se puede dividir entre cero. Repite.");
                    paso--;
                    continue;
                }
                total /= siguienteNum;
            } else {
                System.out.println("Operacion no valida. Usa +, -, * o /. Repite.");
                paso--;
                continue;
            }

            System.out.println("Resultado: " + total);
        }

        double diferencia = Math.abs(objetivo - total);
        System.out.println("------------------------------");
        System.out.println("Diferencia: " + diferencia);

        return diferencia;
    }

    public static void EjercicioCalculadoraHumana() {

        int cantidadOperaciones = 5;

        System.out.println("PRUEBA 3.3 LA CALCULADORA HUMANA");

        System.out.println("TURNO DEL JUGADOR 1");
        double tiempoJugador1 = jugarCalculadoraHumana(cantidadOperaciones);

        System.out.println("TURNO DEL JUGADOR 2");
        double tiempoJugador2 = jugarCalculadoraHumana(cantidadOperaciones);

        System.out.println("RESULTADOS FINALES");
        System.out.println("Tiempo final Jugador 1: " + tiempoJugador1 + " s");
        System.out.println("Tiempo final Jugador 2: " + tiempoJugador2 + " s");

        if (tiempoJugador1 < tiempoJugador2) {
            System.out.println("Ha ganado el Jugador 1 por ser mas rapido!");
        } else if (tiempoJugador2 < tiempoJugador1) {
            System.out.println("Ha ganado el Jugador 2 por ser mas rapido!");
        } else {
            System.out.println("Empate. Ambos jugadores obtuvieron el mismo tiempo.");
        }
    }

    public static double jugarCalculadoraHumana(int cantidadOperaciones) {

        int numeroInicial1 = r.nextInt(100) + 1;
        int fallos = 0;

        String operacionAritmetica1 = "+";
        String operacionAritmetica2 = "-";
        String operacionAritmetica3 = "*";
        String operacionAritmetica4 = "/";

        System.out.print("Pulsa ENTER para empezar: ");
        sc.nextLine();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= cantidadOperaciones; i++) {

            int minimo = 0;
            int maximo = 0;

            int seleccionOperacion = r.nextInt(4);

            if (seleccionOperacion == 3) {
                boolean tieneDivisor = false;
                for (int d = 2; d <= 9; d++) {
                    if (numeroInicial1 % d == 0) {
                        tieneDivisor = true;
                    }
                }
                if (!tieneDivisor) {
                    seleccionOperacion = r.nextInt(3);
                }
            }

            if (seleccionOperacion == 0 || seleccionOperacion == 1) {
                minimo = 10;
                maximo = 99;
            } else if (seleccionOperacion == 2) {
                minimo = 1;
                maximo = 9;
            } else {
                minimo = 2;
                maximo = 9;
            }

            int numeroInicial2 = r.nextInt(maximo - minimo + 1) + minimo;

            if (seleccionOperacion == 3) {
                while (numeroInicial1 % numeroInicial2 != 0) {
                    numeroInicial2 = r.nextInt(maximo - minimo + 1) + minimo;
                }
            }

            int resultadoCorrecto = 0;

            System.out.println("--- Operacion " + i + " de " + cantidadOperaciones + " ---");

            switch (seleccionOperacion) {
                case 0:
                    System.out.print(numeroInicial1 + " " + operacionAritmetica1 + " " + numeroInicial2 + " = ");
                    resultadoCorrecto = numeroInicial1 + numeroInicial2;
                    break;

                case 1:
                    System.out.print(numeroInicial1 + " " + operacionAritmetica2 + " " + numeroInicial2 + " = ");
                    resultadoCorrecto = numeroInicial1 - numeroInicial2;
                    break;

                case 2:
                    System.out.print(numeroInicial1 + " " + operacionAritmetica3 + " " + numeroInicial2 + " = ");
                    resultadoCorrecto = numeroInicial1 * numeroInicial2;
                    break;

                case 3:
                    System.out.print(numeroInicial1 + " " + operacionAritmetica4 + " " + numeroInicial2 + " = ");
                    resultadoCorrecto = numeroInicial1 / numeroInicial2;
                    break;

                default:
                    break;
            }

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("No es valido. Introduce un numero entero porfavor: ");
            }
            int respuesta = sc.nextInt();
            sc.nextLine();

            if (respuesta == resultadoCorrecto) {
                System.out.println("Correcto!");
            } else {
                fallos++;
                System.out.println(
                        "Es erroneo. El resultado correcto era: " + resultadoCorrecto + " (+20 s de penalizacion)");
            }

            numeroInicial1 = resultadoCorrecto;
        }

        long fin = System.currentTimeMillis();

        double tiempoFinal = (fin - inicio) / 1000.0 + fallos * 20;

        System.out.println("Fallos: " + fallos + " | Tiempo final: " + tiempoFinal + " decimas");
        System.out.println("------------------------------");

        return tiempoFinal;
    }

}
