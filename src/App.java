import java.util.Scanner;
import java.util.Random;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static void main(String[] args) throws Exception {
        LaPalabraMasLarga();
    }


    public static void LaPalabraMasLarga(){
        String letrasRandom = letras();
        int puntoJugador1 = 0;
        int puntoJugador2 = 0;
        String palabraJugador1;
        String palabraJugador2;
        for (int i = 0; i < 2; i++) {
            System.out.println("Jugador1, forma una palabra con las siguientes letras:");
            System.out.println(letras());
            do {
                palabraJugador1 = sc.nextLine();  
                if (esValido(palabraJugador1)==false) {
                    System.out.println("Introduce una palabra valida.");
                }
            } while (esValido(palabraJugador1));
            System.out.println("¡Palabra valida!");

            System.out.println("Jugador2, forma una palabra con las siguientes letras:");
            System.out.println(letras());
           do {
                palabraJugador2 = sc.nextLine();  
                if (esValido(palabraJugador2)==false) {
                    System.out.println("Introduce una palabra valida.");
                }
            } while (esValido(palabraJugador2));
            System.out.println("¡Palabra valida!");
            
            System.out.println("Longitud de las palabras:");
            System.out.println("Palabra del jugador 1: " + palabraJugador1.length());
            System.out.println("Palabra del jugador 2: " + palabraJugador2.length());

            if (palabraJugador1.length() > palabraJugador2.length()) {
                puntoJugador1++;
                System.out.println("Jugador1 gana la ronda.");

            } else if (palabraJugador2.length() > palabraJugador1.length()) {
                puntoJugador2++;
                System.out.println("Jugador2 gana la ronda."); 
            } else {System.out.println("EMPATE, las dos palabras son igual de largas.");}
        }
    }
        
        
        


    public static String letras(){
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJLMNPQRSTV";
        String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String letrasRandom = "";
        for (int i = 0; i < 4; i++) {
            letrasRandom += String.valueOf(vocales.charAt(r.nextInt(vocales.length() - 1)));
            letrasRandom += String.valueOf(consonantes.charAt(r.nextInt(consonantes.length() - 1)));
        }
        letrasRandom += String.valueOf(alfabeto.charAt(r.nextInt(alfabeto.length() - 1)));
        letrasRandom += String.valueOf(alfabeto.charAt(r.nextInt(alfabeto.length() - 1)));

        return letrasRandom;
    }

    public static boolean esValido(String palabraJugador){
        boolean esValido;
        String palabraValida;
        do {
            System.out.println("¿Es valida? s/n");
            palabraValida = sc.nextLine();
        } while (palabraValida!="s" || palabraValida!="n");
        if (palabraValida=="s") {
            esValido = true;
        } else {esValido=false;}
        return esValido;
    }
}
