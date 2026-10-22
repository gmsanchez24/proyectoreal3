import java.util.Scanner;
import java.util.Random;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static void main(String[] args) throws Exception {
        
        ejercicioLaCifraExacta();
    }

    
    public static void ejercicioLaCifraExacta() {
        System.out.println("PRUEBA 3.1 LA CIFRA EXACTA");
        
        System.out.println("TURNO DEL JUGADOR 1");
        double diferenciaJugador1 = jugarPartidaCifras();

        System.out.println("TURNO DEL JUGADOR 2");
        double diferenciaJugador2 = jugarPartidaCifras();

        
        System.out.println("          RESULTADOS FINALES           ");
        System.out.println("Diferencia Jugador 1: " + diferenciaJugador1);
        System.out.println("Diferencia Jugador 2: " + diferenciaJugador2);

        
        if (diferenciaJugador1 < diferenciaJugador2) {
            System.out.println("Ha ganado el Jugador 1 por estar mas cerca del objetivo!");
        } else if (diferenciaJugador2 < diferenciaJugador1) {
            System.out.println("Ha ganado el Jugador 2 por estar mas cerca del objetivo!");
        } else {
            System.out.println("Empate. Ambos jugadores obtuvieron la misma diferencia.");
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
}
