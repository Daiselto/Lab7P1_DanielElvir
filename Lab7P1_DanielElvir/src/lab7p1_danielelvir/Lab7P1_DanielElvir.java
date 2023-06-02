/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_danielelvir;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Lab7P1_DanielElvir {

    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir) {
            int op = menu();

            switch (op) {
                case 1: {
                    System.out.println("Ingrese el valor de n");
                    int ValorN = leer.nextInt();
                    System.out.println("Ingrese el valor de m");
                    int ValorM = leer.nextInt();

                    boolean mayor = true;
                    while (mayor) {
                        if (ValorN * ValorM > 88) {
                            System.out.println("El tablero no puede ser tan grande");
                            System.out.println("Ingrese el valor de n");
                            ValorN = leer.nextInt();
                            System.out.println("Ingrese el valor de m");
                            ValorM = leer.nextInt();
                            mayor = true;

                        } else {
                            mayor = false;
                        }
                    }

                    System.out.println("Ingrese la cantidad de balas");
                    int balas = leer.nextInt();

                    boolean cant = true;
                    while (cant) {
                        if ((balas > (ValorN * ValorM / 2))) {
                            System.out.println("No puede tener tantas balas");
                            System.out.println("Ingrese la cantidad de balas");
                            balas = leer.nextInt();
                        } else {
                            cant = false;
                        }
                    }

                    int[][] generado = generarMatrizRandom(ValorN, ValorM);
                    ImprimirMatriz(generado);
                    int puntajeJugador1 = 0;
                    int puntajeJugador2 = 0;
                    int balasrestantes1 = balas;
                    int balasrestantes2 = balas;

                    for (int i = 0; i < balas; i++) {
                        System.out.println("Jugador 1 - Ingrese el número a disparar: ");
                        System.out.println("Te quedan " + balasrestantes1-- + " balas");
                        int bala1 = leer.nextInt();

                        if (!Acerto(generado, bala1)) {
                            System.out.println("El número ya ha sido disparado. Pierdes el turno.");
                            continue;
                        }

                        puntajeJugador1 += dispararNumero(generado, bala1, 99);

                        System.out.println("Estado de la matriz después del disparo:");
                        ImprimirMatriz(generado);

                        System.out.println("Puntaje - Jugador 1: " + puntajeJugador1 + ", Jugador 2: " + puntajeJugador2);
                        System.out.println("");

                        System.out.println("Jugador 2 - Ingrese el número a disparar: ");
                        System.out.println("Te quedan " + balasrestantes2-- + " balas");
                        int bala2 = leer.nextInt();

                        if (!Acerto(generado, bala2)) {
                            System.out.println("El número ya ha sido disparado. Pierdes el turno.");
                            continue;
                        }

                        puntajeJugador2 += dispararNumero(generado, bala2, 88);

                        System.out.println("Estado de la matriz después del disparo:");
                        ImprimirMatriz(generado);
                        System.out.println("Puntaje - Jugador 1: " + puntajeJugador1 + ", Jugador 2: " + puntajeJugador2);
                        System.out.println("");
                    }
                    System.out.println("¡Juego terminado!");
                    if (puntajeJugador1 > puntajeJugador2) {
                        System.out.println("¡Gana el Jugador 1!");
                    } else if (puntajeJugador2 > puntajeJugador1) {
                        System.out.println("¡Gana el Jugador 2!");
                    } else {
                        System.out.println("¡Empate!");
                    }
                    System.out.println("Puntaje Final - Jugador 1: " + puntajeJugador1 + ", Jugador 2: " + puntajeJugador2);
                    break;
                }

                case 2: {
                    System.out.println("Elija que quiere usar");
                    System.out.println("1. Piedra");
                    System.out.println("2. Papel");
                    System.out.println("3. Tijera");
                    System.out.println("4. Lagarto");
                    System.out.println("5. Spock");
                    int opcion = leer.nextInt();
                    int opcionmaquina = 1 + ran.nextInt(5);
         
                    switch(opcion){
                        case 1:{
                            System.out.println("Usted escogió Piedra ");
                            break;
                        }
                        
                        case 2:{
                            System.out.println("Usted escogió Papel ");
                            break;
                        }
                        
                        case 3:{
                           System.out.println("Usted escogió Tijera "); 
                           break;
                        }
                        
                        case 4:{
                           System.out.println("Usted escogió Lagarto "); 
                           break;
                        }
                        
                        case 5:{
                           System.out.println("Usted escogió Spock "); 
                           break;
                        }
                    }
                    
                    switch(opcionmaquina){
                        case 1:{
                            System.out.println("La maquina escogió Piedra");
                            break;
                        }
                        
                        case 2:{
                            System.out.println("La maquina escogió Papel");
                            break;
                        }
                        
                        case 3:{
                            System.out.println("La maquina escogió Tijera");
                            break;
                        }
                        
                        case 4:{
                            System.out.println("La maquina escogió Lagarto");
                            break;
                        }
                        
                        case 5:{
                            System.out.println("La maquina escogió Spock");
                            break;
                        }
                    }
                    String ganar = Juego(opcion, opcionmaquina);
                    System.out.println(ganar);
                    

                    break;
                }

                case 3: {
                    System.out.println("Gracias por usar el programa");
                    seguir = false;
                    break;
                }
            }
        }
    }

    public static int menu() {
        System.out.println("1. She shoots, She Scores");
        System.out.println("2. Piedra, Papel, o....");
        System.out.println("3. Para Salir");
        int opcion = leer.nextInt();

        return opcion;
    }

    public static void ImprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]" + "\t");
            }
            System.out.println("");
        }

    }

    public static int[][] generarMatrizRandom(int n, int m) {
        int[][] temporal = new int[n][m];
        int ValorMax = n * m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int random;
                do {
                    random = 1 + ran.nextInt(ValorMax);
                } while (!EsUnico(temporal, random, i, j));

                temporal[i][j] = random;
            }
        }

        return temporal;
    }

    public static boolean EsUnico(int[][] matriz, int valor, int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ((i != fila || j != columna) && matriz[i][j] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean Acerto(int[][] matriz, int numero) {
        int n = matriz.length;
        int m = matriz[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] == numero && matriz[i][j] != 99 && matriz[i][j] != 88) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int dispararNumero(int[][] matriz, int numero, int jugador) {
        int puntaje = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == numero && matriz[i][j] != 99 && matriz[i][j] != 88) {
                    puntaje += numero;
                    matriz[i][j] = jugador;
                    return puntaje;
                }
            }
        }

        return puntaje;
    }

    public static int[][] MatrizJuego() {
        int[][] Juego = {{0, -1, 1, 1, -1}, {1, 0, -1, -1, 1}, {-1, 1, 0, 1, -1}, {-1, 1, -1, 0, 1}, {1, -1, 1, 1, 0}};

        return Juego;
    }

    public static String Juego(int jug, int maq) {
        int[][] temporal = MatrizJuego();
        String resultado = "";
        if (temporal[jug - 1][maq - 1] == 0) {
            resultado = "Empate";
        } else if (temporal[jug - 1][maq - 1] == 1) {
            resultado = "Ganas vos";
        } else if (temporal[jug - 1][maq - 1] == -1) {
            resultado = "Gana la maquina";
        }
        return resultado;
    }

    
}
