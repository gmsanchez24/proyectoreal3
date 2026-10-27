import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    static int pruebaJ1 = 0, pruebaJ2 = 0;   
    static int puntosGlobalJ1 = 0, puntosGlobalJ2 = 0;
    static int selector , selectorConfig;
    static int numRondas= 1;
    static int cantidadLetras=2;
    static int cantidadOperaciones = 4;
    public static void main(String[] args) throws Exception {
        do {
            System.out.println("--------------------");
            System.out.println("---MODOS DE JUEGO---");
            System.out.println("--------------------");
            System.out.println("1. Modo CONCURSO");
            System.out.println("2. Modo RÁPIDO");
            System.out.println("3. Configuración");
            System.out.println("4. Salir");
            selector = sc.nextInt();
            sc.nextLine();
            switch (selector) {
                case 1:
                    System.out.println("---------------------------------");
                    System.out.println("---BIENVENIDO AL MODO CONCURSO---");
                    System.out.println("---------------------------------");
                    LaPalabraMasLarga();
                    puntuacionGlobal();
                    cifradoCesar();
                    puntuacionGlobal();
                    ganadorFinal();
                    break;

                case 2:
                    do {
                        System.out.println("-------------------------------");
                        System.out.println("---BIENVENIDO AL MODO RAPIDO---");
                        System.out.println("-------------------------------");
                        System.out.println("Selecciona la prueba que deas jugar");
                        System.out.println("1. La Cifra Exacta");
                        System.out.println("2. La Palabra Más Larga");
                        System.out.println("3. La Calculadora Humana");
                        System.out.println("4. Cifrado Cesar");
                        System.out.println("5. SALIR");
                        selector = sc.nextInt();
                        sc.nextLine();
                    
                        switch (selector) {
                        case 1:
                            
                            break;
                        case 2:
                            LaPalabraMasLarga();
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            cifradoCesar();
                            break;
                        case 5:
                            System.out.println("SALIENDO DEL MODO RÁPIDO...");
                            break;
                    
                        default:
                            System.out.println("ERROR: Selecciona una opción del 1 al 5.");
                            break;
                        } 
                    }while (selector!=5); 
                    break;
                case 3:
                    configuracion();;
                    break;
                case 4:
                    System.out.println("SALIENDO DEL JUEGO...");
                    break;
                default:
                    System.out.println("ERROR: Selecciona una opción del 1 al 3.");
                    break;
            }
        } while (selector!=4);
    }

    /*
    Minijuego LA PALABRA MAS LARGA
    */
    public static void LaPalabraMasLarga(){
        String letrasRandom;
        boolean esValido = true;
        String palabraJugador1;
        String palabraJugador2;
        for (int i = 0; i < numRondas; i++) {
            letrasRandom = letras();
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

            

            System.out.println("Longitud de las palabras:");
            System.out.println("Palabra del jugador 1: " + palabraJugador1.length());
            System.out.println("Palabra del jugador 2: " + palabraJugador2.length());

            if (palabraJugador1.length() > palabraJugador2.length()) {
                pruebaJ1++;
                System.out.println("Jugador1 gana la ronda.");

            } else if (palabraJugador2.length() > palabraJugador1.length()) {
                pruebaJ2++;
                System.out.println("Jugador2 gana la ronda."); 
            } else {System.out.println("Ningun jugador consigue el punto, las dos palabras son igual de largas.");}
        }
        marcadorPrueba();
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
        if (cantidadLetras>0) {
            for (int i = 0; i < cantidadLetras; i++) {
            letrasRandom += String.valueOf(alfabeto.charAt(r.nextInt(alfabeto.length() - 1)));
            }
        }
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
       for (int i = 0; i < numRondas; i++) {
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
            
            Instant inicio = Instant.now();
            do {
                descifrar = sc.nextLine();
            } while (!descifrar.equalsIgnoreCase(palabraJugador1));
            Instant fin = Instant.now();
            Duration duracion =  Duration.between(inicio, fin);
            int duracionJugador2 = Math.toIntExact(duracion.toSeconds());

            System.out.println("Jugador2 introduce una cadena de texto:");
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
            
            inicio = Instant.now();
            do {
                descifrar = sc.nextLine();
            } while (!descifrar.equalsIgnoreCase(palabraJugador2));
            fin = Instant.now();
            duracion =  Duration.between(inicio, fin);
            int duracionJugador1 = Math.toIntExact(duracion.toSeconds());

            System.out.println("---Duraciones de los jugadores---");
            System.out.println("Jugador1: " + duracionJugador1 + " segundos");
            System.out.println("Jugador2: " + duracionJugador2 + " segundos");

            if (duracionJugador1 < duracionJugador2) {
                pruebaJ1++;
                System.out.println("El ganador es el Jugador1 por diferencia de " + (duracionJugador2-duracionJugador1) + " segundos");
            } else if (duracionJugador2 < duracionJugador1) {
                pruebaJ2++;
                System.out.println("El ganador es el Jugador2 por diferencia de " + (duracionJugador1-duracionJugador2) + " segundos");
            } else {System.out.println("EMPATE, ambos jugadores han durado lo mismo");}
        }
        marcadorPrueba();
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

    public static void marcadorPrueba(){
        System.out.println("---PARTIDA FINALIZADA---");
        System.out.println("Jugador1:" + pruebaJ1);
        System.out.println("Jugador2:" + pruebaJ2);
        if (pruebaJ1 > pruebaJ2) {
            System.out.println("El ganador de la partida ha sido el JUGADOR1");
        }else if (pruebaJ2 > pruebaJ1) {
            System.out.println("El ganador de la partida ha sido el JUGADOR2");
        } else {System.out.println("La prueba queda en EMPATE.");}
    }

    public static void puntuacionGlobal() {
    if (pruebaJ1 > pruebaJ2) {
        puntosGlobalJ1++;
    } else if (pruebaJ2 > pruebaJ1) {
        puntosGlobalJ2++;
    }
    pruebaJ1 = 0;
    pruebaJ2 = 0;
    System.out.println("Puntos totales Jugador1: " + puntosGlobalJ1);
    System.out.println("Puntos totales Jugador2: " + puntosGlobalJ2);
    System.out.println("Presione INTRO para seguir con el concurso.");
    sc.nextLine();
    }

    public static void ganadorFinal() {
    System.out.println("---CONCURSO FINALIZADO---");
        if (puntosGlobalJ1 > puntosGlobalJ2) {
            System.out.println("Gana el JUGADOR1");
        } else if (puntosGlobalJ2 > puntosGlobalJ1) {
            System.out.println("Gana el JUGADOR2");
        } else {
            System.out.println("El concurso termina en EMPATE");
        }
        puntosGlobalJ1=0;
        puntosGlobalJ2=0;
    }

    public static void configuracion(){
        do {
            System.out.println("-------------------");
            System.out.println("---CONFIGURACIÓN---");
            System.out.println("-------------------");
            System.out.println("¿Que deseas modificar?");
            System.out.println("1. Repeticiones de las pruebas");
            System.out.println("2. Cantidad de letras(La Palabra más larga)");
            System.out.println("2. Cantidad de operaciones(La Calculadora Humana)");
            System.out.println("4. Salir");
            selectorConfig = sc.nextInt();
            sc.nextLine();
                switch (selectorConfig) {
                case 1:
                    System.out.println("Escriba a continuacion el numero de rondas por prueba que desea:");
                    numRondas = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Escriba a la cantidad de letras extras para la prueba 'La Palabra más Larga':");
                    cantidadLetras = sc.nextInt();
                    break;
                case 3:
                    System.out.println("Escribe la cantidad de operaciones que desea realizar en 'La Calculadora Humana':");
                    break;
                case 4:
                    System.out.println("SALIENDO...");
                    break;
            
                default:
                    System.out.println("ERROR: SLECCIONE UNA OPCION CORRECTA");
                    break;
            }
        } while (selectorConfig!=4);
            
    }
}
