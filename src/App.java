import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static void main(String[] args) throws Exception {
        //LaPalabraMasLarga();
        cifradoCesar();
    }

    /*
    Minijuego LA PALABRA MAS LARGA
    */
    public static void LaPalabraMasLarga(){
        String letrasRandom = letras();
        int puntoJugador1 = 0;
        int puntoJugador2 = 0;
        boolean esValido = true;
        String palabraJugador1;
        String palabraJugador2;

        for (int i = 0; i < 1; i++) {
            System.out.println("Jugador1, forma una palabra con las siguientes letras:");
            System.out.println(letrasRandom);
            do {
                palabraJugador1 = sc.nextLine();
                if (puedeFormarse(palabraJugador1, letrasRandom)) {
                    esValido = true;
                    if (esValido(palabraJugador1)==false) {
                        esValido = false;
                    System.out.println("Introduce una palabra valida.");
                    } 
                } else {
                    esValido=false;
                    System.out.println("La palabra no puede ser formada con las letras disponibles.");
                }
            } while (esValido==false);
            System.out.println("¡Palabra valida!");


            System.out.println("Jugador2, forma una palabra con las siguientes letras:");
            letrasRandom = letras();
            System.out.println(letrasRandom);
           do {
                palabraJugador2 = sc.nextLine();
                if (puedeFormarse(palabraJugador2, letrasRandom)) {
                    esValido = true;
                    if (esValido(palabraJugador2)==false) {
                        esValido = false;
                    System.out.println("Introduce una palabra valida.");
                    } 
                } else {
                    esValido=false;
                    System.out.println("La palabra no puede ser formada con las letras disponibles.");
                }
            } while (esValido==false);
            System.out.println("¡Palabra valida!");
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
            } else {System.out.println("Ningun jugador consigue el punto, las dos palabras son igual de largas.");}
        }

        System.out.println("---PARTIDA FINALIZADA---");
        System.out.println("Puntos del jugador1: " + puntoJugador1 );
        System.out.println("Puntos del jugador2: " + puntoJugador2 );
        if (puntoJugador1 > puntoJugador2) {
            System.out.println("El ganador de la partida ha sido el JUGADOR1");
        }else if (puntoJugador2 > puntoJugador1) {
            System.out.println("El ganador de la partida ha sido el JUGADOR2");
        } else {System.out.println("La partida queda en EMPATE.");}
    }
        
        
        

/*
Función para generar letras aleatorias acorde a lo indicado
*/
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

    /*
    Función que verifica que la palabra sea valida en base a una comprobación realizada por el jugador
    */
    public static boolean esValido(String palabraJugador){
        boolean esValido = false;
        String palabraValida;
        do {
            System.out.println("¿Es valida? s/n");
            palabraValida = sc.nextLine();
            if (palabraValida.equalsIgnoreCase("S")) {
            return  true;
            }   else if (palabraValida.equalsIgnoreCase("n")) {esValido=false;}
        } while (palabraValida.equalsIgnoreCase("s") && palabraValida.equalsIgnoreCase("n") );
        
        return esValido;
    }

    /*
    Función que verifica que la palabra se pueda formar con las letras generadas 
    */
    public static boolean puedeFormarse(String palabraJugador, String letrasRandom){
        palabraJugador = palabraJugador.toUpperCase();
        letrasRandom = letrasRandom.toUpperCase();
        for (int i = 0; i < palabraJugador.length(); i++) {
           String letrasSobra = letrasRandom.replaceFirst(String.valueOf(palabraJugador.charAt(i)), "");
            if (letrasSobra.length() == letrasRandom.length() ) {
                return false;
            }
            letrasRandom = letrasSobra;
        }
        return true;
    }


/*
Minijuego 
*/
    public static void cifradoCesar(){
        int desplazamiento;
        String palabraJugador1;
        String palabraJugador2;
        String descifrar;
       for (int i = 0; i < 1; i++) {
            System.out.println("Jugador1 introduce una cadena de texto:");
            do {
                System.out.println("Máximo 7 caracteres");
                palabraJugador1 = sc.nextLine();
            } while (palabraJugador1.length() > 7  || palabraJugador1.length() <= 0);
            
            System.out.println("Selecciona el número de posiciones desplazadas para el cifrado:");
            do {
                System.out.println("máximo 20");
                desplazamiento = sc.nextInt();
            } while (desplazamiento > 20 || desplazamiento <= 0);
            String palabraCifrada = palabraCifrada(palabraJugador1, desplazamiento);
            
            System.out.println("Jugador2, debes descifrar esta cadena: " + palabraCifrada);
            System.out.println("Desplazamiento: " + desplazamiento);
            System.out.println("Pulsa Intro cuando estes preparado");
            sc.nextLine();
            sc.nextLine();
            
            Instant inicio = Instant.now();
            do {
                descifrar = sc.nextLine();
            } while (!descifrar.equalsIgnoreCase(palabraJugador1));
            Instant fin = Instant.now();
            Duration duracion =  Duration.between(inicio, fin);
            int duracionJugador2 = Math.toIntExact(duracion.toSeconds());

            System.out.println("Jugador1 introduce una cadena de texto:");
            do {
                System.out.println("Máximo 7 caracteres");
                palabraJugador2 = sc.nextLine();
            } while (palabraJugador2.length()>7 || palabraJugador2.length() <= 0);
            
            System.out.println("Selecciona el número de posiciones desplazadas para el cifrado:");
            do {
                System.out.println("máximo 20");
                desplazamiento = sc.nextInt();
            } while (desplazamiento > 20 || desplazamiento <= 0);
            palabraCifrada = palabraCifrada(palabraJugador2, desplazamiento);
            
            System.out.println("Jugador2, debes descifrar esta cadena: " + palabraCifrada);
            System.out.println("Desplazamiento: " + desplazamiento);
            System.out.println("Pulsa Intro cuando estes preparado");
            sc.nextLine();
            sc.nextLine();
            
            inicio = Instant.now();
            do {
                descifrar = sc.nextLine();
            } while (!descifrar.equalsIgnoreCase(palabraJugador1));
            fin = Instant.now();
            duracion =  Duration.between(inicio, fin);
            int duracionJugador1 = Math.toIntExact(duracion.toSeconds());

            System.out.println("---Duraciones de los jugadores---");
            System.out.println("Jugador1: " + duracionJugador1 + " segundos");
            System.out.println("Jugador2: " + duracionJugador2 + " segundos");

            if (duracionJugador1 < duracionJugador2) {
                System.out.println("El ganador es el Jugador1 por diferencia de " + (duracionJugador2-duracionJugador1) + " segundos");
            } else if (duracionJugador2 < duracionJugador1) {
                System.out.println("El ganador es el Jugador1 por diferencia de " + (duracionJugador1-duracionJugador2) + " segundos");
            } else {System.out.println("EMPATE, ambos jugadores han durado lo mismo");}
        }
    }


/*
Función que cifra la cadena de texto en función al desplazamiento otorgado
*/
    public static String palabraCifrada(String palabraJugador, int desplazamiento){
        palabraJugador = palabraJugador.toUpperCase();
        String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String palabraCifrada = "";
        for (int i = 0; i < palabraJugador.length(); i++) {
            int posicion = alfabeto.indexOf(palabraJugador.charAt(i));
            palabraCifrada += String.valueOf(alfabeto.charAt(posicion + desplazamiento));
        }
        return palabraCifrada;
    }
}
