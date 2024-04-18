/* NOTAS: infoArrayTresEnRaya es una matriz 4x3. Las primeras tres filas son las del tablero y la ultima fila se utiliza como almacen de variables auxiliares,
 * como los turnos.
 * 
 * VARIABLES EN EL ARRAY:
 * turnos = infoArrayTresEnRaya[3][0] */

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class tresenraya {

    public static void main (String[]args) {
      inicializarTresEnRaya(preinicializacionTresEnRaya());
    }

    /* FUNCIONES AUXILIARES */
    
   public static boolean casillaVacia(char[][] infoArrayTresEnRaya, int posicion) { // no se necesita en el main es una funcion auxiliar
        boolean resultado = false;
        
        if ((posicion < 9 || posicion > 1) && posicion == 1) {    
          posicion = infoArrayTresEnRaya[0][0];
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 2) {
          posicion = infoArrayTresEnRaya[0][1];
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 3) {
          posicion = infoArrayTresEnRaya[0][2];
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 4) {
          posicion = infoArrayTresEnRaya[1][0];
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 5) {
          posicion = infoArrayTresEnRaya[1][1];
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 6) {
          posicion = infoArrayTresEnRaya[1][2];
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 7) {
          posicion = infoArrayTresEnRaya[2][0];
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 8) {
          posicion = infoArrayTresEnRaya[2][1];
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 9) {
          posicion = infoArrayTresEnRaya[2][2];
        }
// marcador de chqueo
        
        if (posicion == ' ') {    
          resultado = true;
        }
        
        return resultado;
   }
   
   public static char[][] preinicializacionTresEnRaya() {
      char[][] casillas = new char[4][3];
      for (int i = 0; i<casillas.length; i++) {
        for (int j = 0; j<casillas[0].length; j++) { // asumo matriz cuadrada
          casillas[i][j] = ' ';
        }
       casillas[3][0] = 1; // turnos por defecto
      }
      return casillas;
   }
    
    public static boolean esTurnoX(char[][] infoArrayTresEnRaya) { // x será el primer jugador, aviso ya. Funcion auxiliar. Turnos impares son de la x, se empieza en turno 1.
      boolean resultado = false;
      if ((infoArrayTresEnRaya[3][0])%2 == 1) {
        resultado = true;
      }
      return resultado;
    }
    
    public static boolean tablaCompleta(char[][] infoArrayTresEnRaya) {
      boolean resultado = true; // por defecto marco true, y busco un "contraejemplo"
      
      for (int i = 0; i<3; i++) {
        for (int j = 0; j<3; j++) {
          if (infoArrayTresEnRaya[i][j] == ' ') { // busco huecos en blanco, si no hay me devuelve true.
            resultado = false;
          }
        }
      }
      return resultado;
    }
    
    /* FUNCIONES DE UN JUGADOR */
    
    public static void unJugadorTresEnRaya(char[][] infoArrayTresEnRaya) {
        try { 
            FileReader reader = new FileReader("puntuacionTresEnRayaUnJugador.txt"); 
            BufferedReader reader2 = new BufferedReader(reader); 
            int puntuacionJ1 = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario 
            int puntuacionJ2 = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
            int puntuacionZ = Integer.parseInt(reader2.readLine()); // la tercera linea es el número de empates.
            
            if (ganadorTresEnRaya(infoArrayTresEnRaya) == 1) {
              puntuacionJ1++; 
            }
            else if (ganadorTresEnRaya(infoArrayTresEnRaya) == 2) {
              puntuacionJ2++;
            }
            else if (ganadorTresEnRaya(infoArrayTresEnRaya) == 3) {
              puntuacionZ++;
            }
            
            FileWriter fw = new FileWriter("puntuacionTresEnRayaUnJugador.txt"); 
            BufferedWriter bw = new BufferedWriter(fw); 
            PrintWriter pw = new PrintWriter(fw); 
            pw.println(puntuacionJ1);  
            pw.println(puntuacionJ2); 
            pw.println(puntuacionZ); 
            reader2.close(); 
            bw.close(); 
        } catch (Exception f) { 
            System.err.println("ERROR: "+f); 
        } 
        
      if(ganadorTresEnRaya(infoArrayTresEnRaya) == 1) {
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        System.err.println("Las X ganan!");
        ejecutarTresEnRaya(preinicializacionTresEnRaya());
      }
      else if(ganadorTresEnRaya(infoArrayTresEnRaya) == 2) {
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        System.err.println("Las O ganan!");
        ejecutarTresEnRaya(preinicializacionTresEnRaya());
      }
      else if(ganadorTresEnRaya(infoArrayTresEnRaya) == 3) {
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        System.err.println("Empate!");
        ejecutarTresEnRaya(preinicializacionTresEnRaya());
      }
      else if ((infoArrayTresEnRaya[3][0]%2) == 0) {
        System.err.println("Turno del jugador 'O'");
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        rellenarCasillaUnJugador(infoArrayTresEnRaya);
      }
      else if ((infoArrayTresEnRaya[3][0]%2) == 1){
        System.err.println("Turno del jugador 'X'");
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        rellenarCasillaUnJugador(infoArrayTresEnRaya);
      }
    }
    
    /* FUNCIONES DE DOS JUGADORES */
    
    public static void dosJugadoresTresEnRaya(char[][] infoArrayTresEnRaya) {
      try { 
        FileReader reader = new FileReader("puntuacionTresEnRayaDosJugadores.txt"); 
        BufferedReader reader2 = new BufferedReader(reader); 
        int puntuacionJ1 = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario 
        int puntuacionJ2 = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
        int puntuacionZ = Integer.parseInt(reader2.readLine()); // la tercera linea es el número de empates.
        
        if (ganadorTresEnRaya(infoArrayTresEnRaya) == 1) {
          puntuacionJ1++; 
        }
        else if (ganadorTresEnRaya(infoArrayTresEnRaya) == 2) {
          puntuacionJ2++;
        }
        else if (ganadorTresEnRaya(infoArrayTresEnRaya) == 3) {
          puntuacionZ++;
        }
        
        FileWriter fw = new FileWriter("puntuacionTresEnRayaDosJugadores.txt"); 
        BufferedWriter bw = new BufferedWriter(fw); 
        PrintWriter pw = new PrintWriter(fw); 
        pw.println(puntuacionJ1);  
        pw.println(puntuacionJ2); 
        pw.println(puntuacionZ); 
        reader2.close(); 
        bw.close(); 
    } catch (Exception f) { 
        System.err.println("ERROR: "+f); 
    }
      
      if(ganadorTresEnRaya(infoArrayTresEnRaya) == 1) {
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        System.err.println("Las X ganan!");
        ejecutarTresEnRaya(preinicializacionTresEnRaya());
      }
      else if(ganadorTresEnRaya(infoArrayTresEnRaya) == 2) {
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        System.err.println("Las O ganan!");
        ejecutarTresEnRaya(preinicializacionTresEnRaya());
      }
      else if(ganadorTresEnRaya(infoArrayTresEnRaya) == 3) {
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        System.err.println("Empate!");
        ejecutarTresEnRaya(preinicializacionTresEnRaya());
      }
      else if ((infoArrayTresEnRaya[3][0]%2) == 0) {
        System.err.println("Turno del jugador 'O'");
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        rellenarCasillaDosJugadores(infoArrayTresEnRaya);
      }
      else if ((infoArrayTresEnRaya[3][0]%2) == 1){
        System.err.println("Turno del jugador 'X'");
        imprimirTablaTresEnRaya(infoArrayTresEnRaya);
        rellenarCasillaDosJugadores(infoArrayTresEnRaya);
      }
    }
   
    
    /*FUNCIONES GENERALES*/
    
    public static void inicializarTresEnRaya(char[][] infoArrayTresEnRaya) {
     
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("Hola! Bienvenido al juego de tres en raya. Para jugar, se han de escoger posiciones de un tablero de 3x3 marcadas de la siguiente manera: \n");
      System.out.println("1 | 2 | 3");
      System.out.println("--+---+--");
      System.out.println("4 | 5 | 6");
      System.out.println("--+---+--");
      System.out.println("7 | 8 | 9 \n");
      System.out.println("Empiezan las X, gana quien consiga hacer tres casillas suyas en raya");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      ejecutarTresEnRaya(infoArrayTresEnRaya);
    }
    
    public static void ejecutarTresEnRaya(char[][] infoArrayTresEnRaya) {
      
      Scanner teclado = new Scanner(System.in);
      
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("Elige si quieres jugar contra la máquina (un jugador) o contra otro jugador: \n");
      System.out.println("1. Un jugador");
      System.out.println("2. Dos jugadores");
      System.out.println("3. Volver al menú principal");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      
      char eleccion = teclado.next().charAt(0); // llevo la eleccion con chars para ahorrarme try catch.
      switch (eleccion) {
        case '1': {
          unJugadorTresEnRaya(infoArrayTresEnRaya);
          break;
        }
        case '2': {
          dosJugadoresTresEnRaya(infoArrayTresEnRaya);
          break;
        }
        case '3': {
          //inicializarMenu(); // DESCOMENTAR CUANDO SE UNA todo!
          break;
        }
        default: {
          System.err.println("ERROR: Introduce la opción válida");
          inicializarTresEnRaya(infoArrayTresEnRaya);
        }
      }

    }

    public static void imprimirTablaTresEnRaya(char[][] casillas) {
        System.out.println(casillas[0][0]+" | "+casillas[0][1]+" | "+casillas[0][2]);
        System.out.println("--+---+--");
        System.out.println(casillas[1][0]+" | "+casillas[1][1]+" | "+casillas[1][2]);
        System.out.println("--+---+--");
        System.out.println(casillas[2][0]+" | "+casillas[2][1]+" | "+casillas[2][2]+"\n");
    }

    public static char[][] rellenarCasillaDosJugadores(char[][] infoArrayTresEnRaya) {
      Scanner teclado = new Scanner(System.in);
      
      char simbolo;
      if (esTurnoX(infoArrayTresEnRaya)) {
        simbolo = 'X';
      }
      else {
        simbolo = 'O';
      }
      
      System.out.println("Escoge la posicion que quieres rellenar: ");
      int posicion = teclado.nextInt(); // usando char me ahorro el inputMismatchException
      
      
      boolean salioBien = false;
      while (!salioBien) { // chequeo de que el numero que han metido es una posicion, y traduzco el numero dado a posicion matricial
        if ((posicion < 9 || posicion > 1) && posicion == 1 && casillaVacia(infoArrayTresEnRaya, posicion)) {    
          salioBien = true;
          infoArrayTresEnRaya[0][0] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 2 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[0][1] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 3 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[0][2] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 4 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[1][0] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 5 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[1][1] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 6 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[1][2] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 7 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[2][0] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 8 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[2][1] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 9 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[2][2] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if (posicion > 9 || posicion < 1){
          System.err.println("ERROR: esa posición no es válida!");
          System.out.println("Introduce tu elección: ");
          imprimirTablaTresEnRaya(infoArrayTresEnRaya);
          posicion = teclado.nextInt();
        }
        else if (!casillaVacia(infoArrayTresEnRaya, posicion)) {
          System.err.println("ERROR: esa casilla está ocupada!");
          System.out.println("Introduce tu elección: ");
          imprimirTablaTresEnRaya(infoArrayTresEnRaya);
          posicion = teclado.nextInt();
        }
      }

        dosJugadoresTresEnRaya(infoArrayTresEnRaya);
        
        return infoArrayTresEnRaya;
    }
    
    public static char[][] rellenarCasillaUnJugador(char[][] infoArrayTresEnRaya) {
      Scanner teclado = new Scanner(System.in);
      Random random = new Random();
      
      char simbolo;
      
      int posicionPC = 0;
      while((!casillaVacia(infoArrayTresEnRaya, posicionPC))) { // si la primera eleccion es de una casilla cogida pues se intentan posiciones buenas hasta que tire.
          posicionPC = random.nextInt(9) + 1;
      }
      
      int posicion; // inicializo para evitar errores por el tema de la incertidumbre del loop que me pide el compilador
      
      if (esTurnoX(infoArrayTresEnRaya)) {
        simbolo = 'X';
        System.out.println("Escoge la posicion que quieres rellenar: ");
        posicion = teclado.nextInt();
      }
      else {
        simbolo = 'O';
        posicion = posicionPC;
      }
      
      boolean salioBien = false;
      while (!salioBien) { // chequeo de que el numero que han metido es una posicion, y traduzco el numero dado a posicion matricial
        if ((posicion < 9 || posicion > 1) && posicion == 1 && casillaVacia(infoArrayTresEnRaya, posicion)) {    
          salioBien = true;
          infoArrayTresEnRaya[0][0] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 2 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[0][1] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 3 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[0][2] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 4 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[1][0] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 5 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[1][1] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 6 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[1][2] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 7 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[2][0] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 8 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[2][1] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if ((posicion < 9 || posicion > 1) && posicion == 9 && casillaVacia(infoArrayTresEnRaya, posicion)) {
          salioBien = true;
          infoArrayTresEnRaya[2][2] = simbolo;
          infoArrayTresEnRaya[3][0]+=1; // incremento uno a los turnos.
        }
        else if (posicion > 9 || posicion < 1){
          System.err.println("ERROR: esa posición no es válida!");
          System.out.println("Introduce tu elección: ");
          imprimirTablaTresEnRaya(infoArrayTresEnRaya);
          posicion = teclado.nextInt();
        }
        else if (!casillaVacia(infoArrayTresEnRaya, posicion)) {
          System.err.println("ERROR: esa casilla está ocupada!");
          System.out.println("Introduce tu elección: ");
          imprimirTablaTresEnRaya(infoArrayTresEnRaya);
          posicion = teclado.nextInt();
        }
      }

        unJugadorTresEnRaya(infoArrayTresEnRaya);
        
        return infoArrayTresEnRaya;
    }
   
    public static int ganadorTresEnRaya(char[][] infoArrayTresEnRaya) { // 1 es X, 2 es O, 3 es Empate
      int resultado = -1;
        for (int i = 0; i<3; i++) { // escaneo filas y columnas
          for (int j = 0; j<3; j++) {
            if ((infoArrayTresEnRaya[i][0] == infoArrayTresEnRaya[i][1]) && (infoArrayTresEnRaya[i][1] == infoArrayTresEnRaya[i][2]) && (infoArrayTresEnRaya[i][0] == 'X')) {
              resultado = 1; // comprueba filas
            }
            else if ((infoArrayTresEnRaya[0][j] == infoArrayTresEnRaya[1][j]) && (infoArrayTresEnRaya[1][j] == infoArrayTresEnRaya[2][j]) && (infoArrayTresEnRaya[0][j] == 'X')) {
              resultado = 1; // compruebo columnas
            }
            else if ((infoArrayTresEnRaya[i][0] == infoArrayTresEnRaya[i][1]) && (infoArrayTresEnRaya[i][1] == infoArrayTresEnRaya[i][2]) && (infoArrayTresEnRaya[i][0] == 'O')) {
              resultado = 2; // comprueba filas
            }
            else if ((infoArrayTresEnRaya[0][j] == infoArrayTresEnRaya[1][j]) && (infoArrayTresEnRaya[1][j] == infoArrayTresEnRaya[2][j]) && (infoArrayTresEnRaya[0][j] == 'O')) {
              resultado = 2; // compruebo columnas
            } 
          }
        }
        
        // diagonales:
        if ((infoArrayTresEnRaya[0][2] == infoArrayTresEnRaya[1][1]) && (infoArrayTresEnRaya[1][1] == infoArrayTresEnRaya[2][0]) && (infoArrayTresEnRaya[0][2] == 'X')) {
          resultado = 1;
        } // compruebo diagonal secundaria
        else if ((infoArrayTresEnRaya[0][2] == infoArrayTresEnRaya[1][1]) && (infoArrayTresEnRaya[1][1] == infoArrayTresEnRaya[2][0]) && (infoArrayTresEnRaya[0][2] == 'O')) {
          resultado = 2;
        } // compruebo diagonal secundaria
        if ((infoArrayTresEnRaya[0][0] == infoArrayTresEnRaya[1][1]) && (infoArrayTresEnRaya[1][1] == infoArrayTresEnRaya[2][2]) && (infoArrayTresEnRaya[1][1] == 'X')) {
          resultado = 1;
        } // compruebo diagonal principal
        else if ((infoArrayTresEnRaya[0][0] == infoArrayTresEnRaya[1][1]) && (infoArrayTresEnRaya[1][1] == infoArrayTresEnRaya[2][2]) && (infoArrayTresEnRaya[1][1] == 'O')) {
          resultado = 2;
        } // compruebo diagonal principal

        // empates:
        if(tablaCompleta(infoArrayTresEnRaya)) { // si no separalo en otra funcion, wuyita el while y transforma esta funcion a boolean
          resultado = 3;
        }
      return resultado;
    }   
    
    public static void imprimirLeaderboardTresEnRaya() {
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("Escoge que leaderboard deseas imprimir: ");
      System.out.println("1. Un jugador");
      System.out.println("2. Dos jugadores");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      char eleccion;
      boolean eleccionCorrecta = false;
      while(!eleccionCorrecta) {
        switch eleccion {
          case '1': {
            imprimirLeaderboardUnJugadorTresEnRaya();
            eleccionCorrecta = true;
            break;
          }
          case '2': {
            imprimirLeaderboardDosJugadoresTresEnRaya();
            eleccionCorrecta = true;
            break;
          }
          default: {
            System.err.println("ERROR: la opción seleccionada es inválida.")
          }
        }
      }
    }

    public static void imprimirLeaderboardUnJugadorTresEnRaya() {
      FileReader reader = new FileReader("puntuacionTresEnRayaUnJugador.txt"); 
      BufferedReader reader2 = new BufferedReader(reader); 
      int puntuacionJ1 = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario 
      int puntuacionJ2 = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
      int puntuacionZ = Integer.parseInt(reader2.readLine()); // la tercera linea es el número de empates.
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("                                                          LEADERBOARD");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println(puntuacionJ1);
      System.out.println(puntuacionJ2);
      System.out.println("EMPATES: "+puntuacionZ);
    }

    public static void imprimirLeaderboardDosJugadoresTresEnRaya() {
      FileReader reader = new FileReader("puntuacionTresEnRayaDosJugadores.txt"); 
      BufferedReader reader2 = new BufferedReader(reader); 
      int puntuacionJ1 = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario 
      int puntuacionJ2 = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
      int puntuacionZ = Integer.parseInt(reader2.readLine()); // la tercera linea es el número de empates.
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("                                                          LEADERBOARD");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println(puntuacionJ1);
      System.out.println("ORDENADOR"+puntuacionJ2);
      System.out.println("EMPATES: "+puntuacionZ);
    }
}



