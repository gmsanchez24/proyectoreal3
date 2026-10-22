import java.util.Scanner;
import java.util.Random;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }


    public static void LaPalabraMasLarga(){
            System.out.println("Jugador 1, forma una palabra con las siguientes letras:");
            System.out.println(letras());
            String palabraJugador = sc.nextLine();
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
}
