import java.util.*;
import java.io.*;

public class ordenadorMultifuncion {
    public static void main(String[]args) {
        // FUNCIONES DEL MENU //
        String nombreUsuario = configInicial();
        menuEleccion(nombreUsuario);
    }
    /*----------------------------------------------------------------------- FUNCIONES DEL MENÚ -----------------------------------------------------------------------*/

    public static String configInicial() { // Función que recoge datos del usuario.
        Scanner teclado = new Scanner (System.in);
        System.out.println("Bienvenido a tu ordenador personal. Por favor introduce tu nombre:");
        String nombre = teclado.nextLine().trim(); // nos tienen que enseñar a almacenarlos en un archivo de texto.
        System.out.print("Ha quedado registrado como: "); System.err.print(nombre); System.out.print(". Disfrute su sesión. \n");
        return nombre;
    }

    public static void menuEleccion(String nombre) {
        Scanner teclado = new Scanner (System.in);
        int eleccion;

        System.out.println("-------------------------------------------------------------------");
        System.out.print("Hola "); System.err.print(nombre); System.out.println(", elija la opción que desee introduciendo el número asociado a ella: \n");
        System.out.println("1. Abrir calculadora");
        System.out.println("2. Abrir chat y contactos");
        System.out.println("3. Abrir cámara");
        System.out.println("4. Abrir agenda");
        System.out.println("5. Abrir tres en raya");
        System.out.println("6. Apagar móvil");
        System.out.println("-------------------------------------------------------------------");

        eleccion = teclado.nextInt();
        confirmarEleccion(eleccion, nombre);
    }

    public static void confirmarEleccion(int eleccion, String nombre) {
        Scanner teclado = new Scanner (System.in);
        
        boolean salioBienExterno = false;
        while(!salioBienExterno) {
          switch (eleccion) { 
            case 1: {
                  int subEleccion = 0;
                  System.out.println("-------------------------------------------------------------------");
                  System.out.println("¿Estás seguro de que quieres abrir la calculadora? \n");
                  System.out.println("1. Si");
                  System.out.println("2. Volver al menú principal");
                  System.out.println("-------------------------------------------------------------------");

                  boolean salioBien = false; 
                  while(salioBien == false) {
                    try {
                          subEleccion = teclado.nextInt();

                          boolean salioBienInterno = false;
                          while (!salioBienInterno) {
                            switch (subEleccion) {
                              case 1: {
                                inicializarCalculadora(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              case 2: {
                                menuEleccion(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              default: {
                                System.err.println("ERROR: Introduce una opción válida");
                                subEleccion = teclado.nextInt();
                              }
                            }
                          }
                    } 
                    catch (Exception e) { // Exception que llamo e para referenciarla.
                      System.err.println("ERROR: Tipo de datos introducido incorrecto u opción escogida no contemplada. Reinicia el programa o escribe 1 dos veces."); // cubro el caso de que metamos un string para identificar el error.
                      teclado.next();
                    } 
                  }
                  break;
            } 
                  
            
            case 2: {
              int subEleccion = 0;
              System.out.println("-------------------------------------------------------------------");
              System.out.println("¿Estás seguro de que quieres abrir chat y contactos? \n");
              System.out.println("1. Si");
              System.out.println("2. Volver al menú principal");
              System.out.println("-------------------------------------------------------------------");

              boolean salioBien = false; // Manera de reintentar try catch
              while(salioBien == false) {
                try { // mediante try catch contemplo la opcion de que difiera de las opciones numericas o de que si pongo string pues en vez de petar el programa me salga
                      subEleccion = teclado.nextInt();

                      boolean salioBienInterno = false;
                          while (!salioBienInterno) {
                            switch (subEleccion) {
                              case 1: {
                                inicializarChatYContactos(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              case 2: {
                                menuEleccion(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              default: {
                                System.err.println("ERROR: Introduce una opción válida");
                                subEleccion = teclado.nextInt();
                              }
                            }
                          }
                  } 
                  catch (Exception e) { // Exception que llamo e para referenciarla.
                      System.err.println("ERROR: Tipo de datos introducido incorrecto u opción escogida no contemplada. Reinicia el programa o escribe 1 dos veces."); // cubro el caso de que metamos un string para identificar el error.
                      teclado.next();
                  }
            }
              break;
            }
            case 3: { 
              int subEleccion = 0;
              System.out.println("-------------------------------------------------------------------");
              System.out.println("¿Estás seguro de que quieres abrir la camara? \n");
              System.out.println("1. Si");
              System.out.println("2. Volver al menú principal");
              System.out.println("-------------------------------------------------------------------");

              boolean salioBien = false; // Manera de reintentar try catch
              while(salioBien == false) {
                  try { // mediante try catch contemplo la opcion de que difiera de las opciones numericas o de que si pongo string pues en vez de petar el programa me salga
                      subEleccion = teclado.nextInt();

                      boolean salioBienInterno = false;
                          while (!salioBienInterno) {
                            switch (subEleccion) {
                              case 1: {
                                inicializarCamara(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              case 2: {
                                menuEleccion(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              default: {
                                System.err.println("ERROR: Introduce una opción válida");
                                subEleccion = teclado.nextInt();
                              }
                            }
                          }
                  } 
                  catch (Exception e) { // Exception que llamo e para referenciarla.
                      System.err.println("ERROR: Tipo de datos introducido incorrecto u opción escogida no contemplada. Reinicia el programa o escribe 1 dos veces."); // cubro el caso de que metamos un string para identificar el error.
                      teclado.next();
                  }
              }
              break;
            }
            case 4: {
              int subEleccion = 0;
              System.out.println("-------------------------------------------------------------------");
              System.out.println("¿Estás seguro de que quieres abrir la agenda? \n");
              System.out.println("1. Si");
              System.out.println("2. Volver al menú principal");
              System.out.println("-------------------------------------------------------------------");

              boolean salioBien = false; // Manera de reintentar try catch
              while(salioBien == false) {
                  try { // mediante try catch contemplo la opcion de que difiera de las opciones numericas o de que si pongo string pues en vez de petar el programa me salga
                      subEleccion = teclado.nextInt();

                      boolean salioBienInterno = false;
                          while (!salioBienInterno) {
                            switch (subEleccion) {
                              case 1: {
                                inicializarAgenda(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              case 2: {
                                menuEleccion(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              default: {
                                System.err.println("ERROR: Introduce una opción válida");
                                subEleccion = teclado.nextInt();
                              }
                            }
                          }
                  } 
                  catch (Exception e) { // Exception que llamo e para referenciarla.
                      System.err.println("ERROR: Tipo de datos introducido incorrecto u opción escogida no contemplada. Reinicia el programa o escribe 1 dos veces."); // cubro el caso de que metamos un string para identificar el error.
                      teclado.next(); // lo que dijimos que era magia en la tutoria
                  }
              }
              break;
            }
            case 5: {
              int subEleccion = 0;
              System.out.println("-------------------------------------------------------------------");
              System.out.println("¿Estás seguro de que quieres jugar a las tres en raya? \n");
              System.out.println("1. Si");
              System.out.println("2. Volver al menú principal");
              System.out.println("-------------------------------------------------------------------");

              boolean salioBien = false; // Manera de reintentar try catch
              while(salioBien == false) {
                  try { // mediante try catch contemplo la opcion de que difiera de las opciones numericas o de que si pongo string pues en vez de petar el programa me salga
                      subEleccion = teclado.nextInt();

                      boolean salioBienInterno = false;
                          while (!salioBienInterno) {
                            switch (subEleccion) {
                              case 1: {
                                inicializarTresEnRaya(preinicializacionTresEnRaya(), nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              case 2: {
                                menuEleccion(nombre);
                                salioBienInterno = true;
                                salioBien = true;
                                break;
                              }
                              default: {
                                System.err.println("ERROR: Introduce una opción válida");
                                subEleccion = teclado.nextInt();
                              }
                            }
                          }
                  } 
                  catch (Exception e) { // Exception que llamo e para referenciarla.
                      System.err.println("ERROR: Tipo de datos introducido incorrecto u opción escogida no contemplada. Reinicia el programa o escribe 1 dos veces."); // cubro el caso de que metamos un string para identificar el error.
                      teclado.next();
                  }
              }
              break;
            }
            case 6: {
              barraDeCarga();
              System.exit(0);
            }
            default: {
              System.err.println("ERROR: Introduce una opción válida");
              eleccion = teclado.nextInt();
            }
          
          }
        }
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

public static void unJugadorTresEnRaya(char[][] infoArrayTresEnRaya, String nombreUsuario) {
    try { 
        FileReader reader = new FileReader("puntuacionTresEnRayaUnJugador.txt"); 
        BufferedReader reader2 = new BufferedReader(reader); 
        int puntuacionJ1 = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del X
        int puntuacionJ2 = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de O
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
    ejecutarTresEnRaya(preinicializacionTresEnRaya(), nombreUsuario);
  }
  else if(ganadorTresEnRaya(infoArrayTresEnRaya) == 2) {
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    System.err.println("Las O ganan!");
    ejecutarTresEnRaya(preinicializacionTresEnRaya(), nombreUsuario);
  }
  else if(ganadorTresEnRaya(infoArrayTresEnRaya) == 3) {
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    System.err.println("Empate!");
    ejecutarTresEnRaya(preinicializacionTresEnRaya(), nombreUsuario);
  }
  else if ((infoArrayTresEnRaya[3][0]%2) == 0) {
    System.err.println("Turno del jugador 'O'");
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    rellenarCasillaUnJugador(infoArrayTresEnRaya, nombreUsuario);
  }
  else if ((infoArrayTresEnRaya[3][0]%2) == 1){
    System.err.println("Turno del jugador 'X'");
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    rellenarCasillaUnJugador(infoArrayTresEnRaya, nombreUsuario);
  }
}

/* FUNCIONES DE DOS JUGADORES */

public static void dosJugadoresTresEnRaya(char[][] infoArrayTresEnRaya, String nombreUsuario) {
  try { 
    FileReader reader = new FileReader("puntuacionTresEnRayaDosJugadores.txt"); 
    BufferedReader reader2 = new BufferedReader(reader); 
    int puntuacionJ1 = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del X
        int puntuacionJ2 = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de O
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
  }
  catch (Exception f) { 
    System.err.println("ERROR: "+f); 
  }
  
  if(ganadorTresEnRaya(infoArrayTresEnRaya) == 1) {
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    System.err.println("Las X ganan!");
    ejecutarTresEnRaya(preinicializacionTresEnRaya(), nombreUsuario);
  }
  else if(ganadorTresEnRaya(infoArrayTresEnRaya) == 2) {
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    System.err.println("Las O ganan!");
    ejecutarTresEnRaya(preinicializacionTresEnRaya(), nombreUsuario);
  }
  else if(ganadorTresEnRaya(infoArrayTresEnRaya) == 3) {
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    System.err.println("Empate!");
    ejecutarTresEnRaya(preinicializacionTresEnRaya(), nombreUsuario);
  }
  else if ((infoArrayTresEnRaya[3][0]%2) == 0) {
    System.err.println("Turno del jugador 'O'");
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    rellenarCasillaDosJugadores(infoArrayTresEnRaya, nombreUsuario);
  }
  else if ((infoArrayTresEnRaya[3][0]%2) == 1){
    System.err.println("Turno del jugador 'X'");
    imprimirTablaTresEnRaya(infoArrayTresEnRaya);
    rellenarCasillaDosJugadores(infoArrayTresEnRaya, nombreUsuario);
  }
}

/*----------------------------------------------------------------------- FUNCIONES DEL TRES EN RAYA -----------------------------------------------------------------------*/

/*FUNCIONES GENERALES*/

public static void inicializarTresEnRaya(char[][] infoArrayTresEnRaya, String nombreUsuario) {
 
  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
  System.out.println("Hola! Bienvenido al juego de tres en raya. Para jugar, se han de escoger posiciones de un tablero de 3x3 marcadas de la siguiente manera: \n");
  System.out.println("1 | 2 | 3");
  System.out.println("--+---+--");
  System.out.println("4 | 5 | 6");
  System.out.println("--+---+--");
  System.out.println("7 | 8 | 9 \n");
  System.out.println("Empiezan las X, gana quien consiga hacer tres casillas suyas en raya");
  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
  ejecutarTresEnRaya(infoArrayTresEnRaya, nombreUsuario);
}

public static void ejecutarTresEnRaya(char[][] infoArrayTresEnRaya, String nombreUsuario) {
  
  Scanner teclado = new Scanner(System.in);
  
  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
  System.out.println("Elige alguna de las siguientes opciones: \n");
  System.out.println("1. Un jugador");
  System.out.println("2. Dos jugadores");
  System.out.println("3. Imprimir leaderboard");
  System.out.println("4. Volver al menú principal");
  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
  
  char eleccion = teclado.next().charAt(0); // llevo la eleccion con chars para ahorrarme try catch.
  switch (eleccion) {
    case '1': {
      unJugadorTresEnRaya(infoArrayTresEnRaya, nombreUsuario);
      break;
    }
    case '2': {
      dosJugadoresTresEnRaya(infoArrayTresEnRaya, nombreUsuario);
      break;
    }
    case '4': {
      menuEleccion(nombreUsuario);
      break;
    }
    case '3': {
      imprimirEstadisticasTresEnRaya(nombreUsuario);
      break;
    }
    default: {
      System.err.println("ERROR: Introduce la opción válida");
      ejecutarTresEnRaya(infoArrayTresEnRaya, nombreUsuario);
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

public static char[][] rellenarCasillaDosJugadores(char[][] infoArrayTresEnRaya, String nombreUsuario) {
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

    dosJugadoresTresEnRaya(infoArrayTresEnRaya, nombreUsuario);
    
    return infoArrayTresEnRaya;
}

public static char[][] rellenarCasillaUnJugador(char[][] infoArrayTresEnRaya, String nombreUsuario) {
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

    unJugadorTresEnRaya(infoArrayTresEnRaya, nombreUsuario);
    
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

public static void imprimirEstadisticasTresEnRaya(String nombreUsuario) {
    Scanner teclado = new Scanner(System.in);

    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Escoge que estadísticas deseas imprimir: ");
    System.out.println("1. Un jugador");
    System.out.println("2. Dos jugadores");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    char eleccion = teclado.next().charAt(0);
    boolean eleccionCorrecta = false;
    while(!eleccionCorrecta) { 
        switch (eleccion) {
        case '1': {
            imprimirEstadisticasUnJugadorTresEnRaya(nombreUsuario);
            barraDeCarga();
            inicializarTresEnRaya(preinicializacionTresEnRaya(), nombreUsuario);
            eleccionCorrecta = true;
            break;
        }
        case '2': {
            imprimirEstadisticasDosJugadoresTresEnRaya(nombreUsuario);
            barraDeCarga();
            inicializarTresEnRaya(preinicializacionTresEnRaya(), nombreUsuario);
            eleccionCorrecta = true;
            break;
        }
        default: {
            System.err.println("ERROR: la opción seleccionada es inválida.");
        }
        }
    }
}

public static void imprimirEstadisticasUnJugadorTresEnRaya(String nombreUsuario) {
  try {
    FileReader reader = new FileReader("puntuacionTresEnRayaDosJugadores.txt");
    BufferedReader reader2 = new BufferedReader(reader); 
    int puntuacionJ1 = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario 
    int puntuacionJ2 = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
    int puntuacionZ = Integer.parseInt(reader2.readLine()); // la tercera linea es el número de empates.
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("                                                     ESTADÍSTICAS DOS JUGADORES");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Jugador actual: "+nombreUsuario);
    System.out.println("Veces que ganó X: "+puntuacionJ1);
    System.out.println("Veces que ganó O: "+puntuacionJ2);
    System.out.println("Empates: "+puntuacionZ);
    } catch (Exception g) {
        System.err.println("ERROR: "+g);
    } 
}

public static void imprimirEstadisticasDosJugadoresTresEnRaya(String nombreUsuario) {
    try {
    FileReader reader = new FileReader("puntuacionTresEnRayaDosJugadores.txt");
    BufferedReader reader2 = new BufferedReader(reader); 
    int puntuacionJ1 = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario 
    int puntuacionJ2 = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
    int puntuacionZ = Integer.parseInt(reader2.readLine()); // la tercera linea es el número de empates.
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("                                                     ESTADÍSTICAS DOS JUGADORES");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Jugador actual: "+nombreUsuario);
    System.out.println("Veces que ganó X: "+puntuacionJ1);
    System.out.println("Veces que ganó O: "+puntuacionJ2);
    System.out.println("Empates: "+puntuacionZ);
    } catch (Exception g) {
        System.err.println("ERROR: "+g);
    } 
  
}
/*----------------------------------------------------------------------- FUNCIONES CÁMARA -----------------------------------------------------------------------*/
public static void inicializarCamara(String nombre) {
  Scanner teclado = new Scanner(System.in);
  System.out.println("    Pulsa 1 para sacar las fotos, pulsa 2 para volver");
  System.out.println("---------------------------------------------------------");
  System.out.println("|                           |_|                         |");
  System.out.println("---------------------------------------------------------");
  Random random = new Random();

  int seleccion;
  int eleccion = teclado.nextInt();


  while (eleccion == 1) {
      seleccion = random.nextInt(4) + 1; // [1,4]
      switch (seleccion) {
          case 1:
          System.out.println("---------------------------------------------------------");
          System.out.println("|                           |_|                         |");
          System.out.println("---------------------------------------------------------");
          System.out.print(".                                                          .,(%%&@@@@@@@@@@@@@@@&&&&&&&&&&@&&@&&&@&#/,.                               \n                .                                                  .*(%@@@@@@@@@@@@@@@@@&&@@&@@@&&&&&&&&&&&&&&%&&&&&&@@@&%(,                          \n                .                                               ,(@@@@@@@@@@@@@@@@@&@@&&&&&@&@&&%&%&&@&&@&&%&%@@@&&%&&&&&@&@%/.                       \n                .                                           ./&@@&@@&@@@@&@@&&&@@@@@@&&&&&&@@@&&&@%&&&&&%%%&&&&&%&&@&&&&&&&@@&&&&&#/.                 \n                .                                         *&@@@@@@@@@@@@&@@&@@@@@@@@@@@@@@@@@&@@@&@&&&%%%%&&@&%@&&@%&&&@@&&&@@&&&&&&&#,               \n                .                                       .#@&@@&@&@@&&@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&%&&@@&&@@@&&&&@@&&&&&@@%*             \n                .                                      *&&&&&@&@&@@@&@&@@@@@@@@&&&&&&&&&&&&&&&&%%%%%%%%%%%%&&&&&&&%&%%%&&&&@@&&&&&&&&&&@@%*           \n                .                                     *&&&&%&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&&&@@@&&&&&&&&&%%&&&#.         \n                .                                    (&&&%#####%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###########%%%%%&&&&&&&&&&&@@@@@@&&&&@@&&&&&&(.        \n                .                                 ./&&&##########%%%%%%%%%%%%%%%%%%%%%%%%%%%%################%%%&&&&&&@@&&@@@@@@&&&&@@@@@@@@@#.       \n                .                                *&&&%###########%%%%%%%%%%%%%%%%%%%%%%%%%%##################%%%%%&&@&&&&@@@&&&&&&&&&&&&&@@@@@%,      \n                .                               ,%&&####((##%%%%%%%%%%%%%%%%%%%%%%%%%%%%%####################%%%%%&%&&&@@&&&&&&&&&&&&&&&&@@&&&@%.     \n                .                              .(%%#########%%%%%%%%&&&&&&&%%&%%%%%%%%%%%%%###%#############%%%#%%%&&&&&&&&&&&&&&&&&&@&&&&&&&@&&/     \n                .                              *&%(((#((###%%%%%%%%%%%&&&&&%&&&&&&&%%%%%%%%################%%%#%%%&#%&&&&&&&&&&&@&&@@&&&&&&@&&&&#.    \n                .                             .(&(/((#((##%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###############(###%%%#%%%&%%&%%&&&&&&&&&&&@@@&&&&@@&&&*    \n                .                             *%#(((##((#%%%%%%%###%%%%&%%&&%%&%&&&&&%%&&&&%%%##################%%%%&&%%&&&&&&&&&&&@&&@@&&&@&&&&&%.   \n                .                            .(&(/##(####%&&&%######%&&&&&&&&%&&&&&&&&&&&&&&%%%%%##############(####%%%%%&%&&&&&&&&&&&&&&@@&&&&&&&*   \n                .                            ,#%(/(((##(#%%&%#(%%%&%&&&&&&&&&@@@@@@&@@@@@&&&&&&&%%%%%##################%%&&&&&&&&&&&&&&&&@@@@@@@@&/   \n                .                            ,#(//(((#%##(&&&&%&&%&&&&&&@@@@@@@@@@@&&&&&&&%%&%%%%&&&%%%%#################%%&&&&&&&&&&&&&&@@@@@@@@&(.  \n                .                            *#/((#(#%%%%##%&&&&%&&@@@@@@@@@@@@&&&&&&&&&&&&&&%%%%%%%%#%%%##########((####%%%%&&&&&&&&&&&&&@&@@@@@&(.  \n                .                          ./%#(%%%%%&&&&%%&%%&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@&&&%%%%%%####################%%&&&&&&&&&&&&&&&@@&&&@&(.  \n                .                       ./#%%%%&&&&&&@@@@&&%#%%&%%%%%%%&&@@@@@@@@@@@@@@&&&&&@@@@&&&&&&&%%%############(###%%%&&&&&&&&&&&&&&%###&&%,   \n                .                      ,#%%%&&&@@@@@@@@@@&&#/%%%%####%%&&@@@@@@@@@@@&&&&&&&&%%&%%&%&&%%%%###########(######%%&&&&&&%%%#%###((#&&%#*   \n                .                      ,#&&&&&&&&&&@@@@@@@@&(#%%%#####%%&&@@@@@&&&&&&&&&&&&&&&%&&%%%%%%%%###%##############%%%%&%&%####(####((##%&%*  \n                .                      ,#%##(/#&&@@@@@@@@@@(#%%%%#####%%&@@@@@@@@@@@@@&&@&&&&&&&%%%%%%#%%%%#################%%%%&%%##(((((#%%###%%&(. \n                .                       /#%##&@@@@@@@@@&&@(#%%%%######%%%%&&&&@@&&@@&&&&&&&&&&%%%%#%########################%%%%&&%##(#(((((((####&%* \n                .                        .(%%&@@@&&&&&&@@%#%%%%%#######%%%%&&&&&&&&&&&&&&&&&%%%%%%########################%%%%&&&&%#####&&&&&%%%%%#%(.\n                .                          ./(&%###&&@@@%#%%%%############%%&&&&&&&&&&&&&&&%%%%%##########################%%&&&&&&###%#(##%&&&&&&&&%/ \n                .                           ./%#%#%&&@&%#%%%%######(######%&&&&&&&&&&&&&&&&&&%%%%%%#####%###############%#%%&&&&&%######((#%%&&&&&&#, \n                .                           *(#%%&&%&%##%%%%#########%%%%%%%&&&&&&&&&&&&&&&&&&%%%%%%%%%%################%%%%&&&&&%#(##(((((##%&@&&%#, \n                .                          */((##%%%%((%%%%%################%&&&&&&@@&&&%%&%%%%%%%%%%%%%#####%#%###%#%%%#&%&&&&&&&####(####%%%%%##%(. \n                .                          ,*((######/#%%%%%#######%%&%####%&&&&&&&&&@@&&&%%&%%%%%#%&&&%%%%%%%%%#%%%%%%%&%%%&%&&&&&##((%&&%#(#%%%##*  \n                .                         ,,**/(((%%&/((%%&%%%&&&%%%%%%%%&&&&&&&&&&@&&@@@@@&&%%%##%##&&&&&%&&&%&&%%#%&&&&&%#%&&&&&&##(###########(,   \n                .                         .,,**((%&&@@#%&&&%%%%&&&&&&&&&@@@&@&&&&&&&&@@@@@@@@@&%%##%#%&@&&&&&&&%&#%%%%&%&#%%&%&&&&&%#######((((/,     \n                .                          ,,,*/#%&&&@&%#%%%(%&@@&&&@@@@@&@@@@@@&&&@&@@@@@@@@@@@&%##%%&&@&&&&&&&&&&&&&%%%#%&%#&&%&&&%%#####(**.       \n                .                           ,(//(##&@&%%%%&##%&@@&&&&@@@@@@&&&&&&&&&&&&&@@@@@@@@@&#%%&&&@@@@%&&&&&&%%&&#%%#&%&%&&&&%%##/,             \n                .                            (((((%&&%%%&&%%#&&@&&&&&&&&&&%%%%%%%%%%%%&&&@@@@@@@&&%%&&&@@@@@@&&&&&&&%%#&#%%#%&&&%&%&&%/.              \n                .                            ,##((%&&&&%%%#%#%%&&&&&&&&&&&&%&&&%&&&&&&@@@@@@@@@@&%%&%&&@@@@@@@&@&%%%&&&%&%%%%#%%%%%%&%*               \n                .                             /%#(%#%&&%#((#%%%&&&&&&%#(%#((#%#(#%%&&&&&&@@@@@@&&&%&&&@@@@@@@@&%&&&&&&&&%&&#%%&%%%#%&&/               \n                .                             /%&#&%&&&%#%&&%%# (######(#%%%&&&&&&&&&%&&&@@@@@&&&%&&&&@@@@@@@&@&&@&&&&&&&&%%#%%##%%%&&#,              \n                .                             /#&&#%&@@@@@@@(/(.(###%%%%%%&&&&&&%%%&&&&&@@@@@@@@&&&&@@@@@@@@@@&&&&@&&&&&&%%%#%%%%&%#&&%/              \n                .                             ,##&&%&@@@@%((((##%%%%&&&&&%%%%%%%&%&&&&&@@@@@@@@&&&&&&@@@@@@&@@&@&@@@@&&&%%%&%%%#%%%%%&%#,             \n                .                              /#&&&%&&&%/(((/(##%%&%%%&%#%&%%&&&&&&@@@@@@@@@@@&&&&&@@@@@@@@@@&@&&&&&&&&&&%%%%%%%&&&&&&#,             \n                .                               /%&@%%&&%(#/%#%%%&&&@@@@@&&@&@&&@@@@@@@@@@@@@@@&&%&@@@@@@@@@@@@&&&&&&&&&&&&&&%%%&&&&&&%(.             \n                .                               .(&@%%&&%%&%%#%%&&@@@@@@@@&&&@@@&@@@&&@@@@@@@@@&&&&@@@@@@@@@@@@@&@&@&&&&%&%&&&&&&&&&&%*               \n                .                                ,#&%#&&%&%&#%#%&&&&@&@&@&&@&@@@@@@@@@@@@@@@@@@&&&&&&@@@@@@@@@&&&@@&&&&&%&&&&&&&&&&%/.                \n                .                                 *%%%%&&&%%%%##%&&&@@@@&&@@@@@@&@&&@@@@@@@&@&&&&&%&@@@@@@@@@@&@&&&&&@&&&&@@&&&&&#/,                  \n                .                                 ,##%%%&&&%%#%%%&&&@@@@@@@@@@@@@@@&@@@@@@@@&@&@&&&&@@@@@@@@@@@&&@&@&@@@&&&&&%#(/,.                   \n                .                                 ,((%%%@&&&&&&&&&@&&&@@@@@&@@@@@@@@@@@@&&@&@&@&&&&&@@@@@@@@@&&&@@@@@@@&&&#(*,..                      \n                .                                 ,/###%&&&&&&&&@&@@&&@@@@@@@@@@@@@@@@&@@@&&&&%&&&&&@@@@@@@@@@@@@@&&%#(/,..                           \n                .                                 ,#/(#&%%&&&@&&@@@@@@@@@@@@@@@@&@@&@&&&&&%&&&%&&&&&@@@@@@@@@@&&#/*,.                                 \n                .                                 .(##%(%%%&&&&&&&@@@@@@@@@@@@@&&&&&%&%&&#%%&&&&&&@&@@@@@@@&%/.                                       \n                .                                  /(##(%%#%&&&&&&@&@@@@@@&@@&&&&&&&&%&&%&&%&&&@&@@@@@@&&(,                                           \n                .                                  *##%%%&%&&&&&&@@@@&&@&&@&&@&@@&@&&&&&&&&&&@@@&@@@@@%*                                              \n                .                                  ./##%%%%&&&&&&@@@@@@@@&@@@@&&@&&&@&&&&&@@@@@@@@@&#,                                                \n                .                                   ,(##%%%%&&&&&@@@@@@@&@@@&@@@@@@&@@@@@@@@@@@@&%/.                                                  \n                                                     ./#%%&&%&&&@@@&@@@@@@@@@@@@@@@@@@@&@@@&%#(*,                                                     \n                .                                       .*(#&@&@&&@@@@@@@@@@@@@@@@@&&%#/*,..                                                          \n                .                                           .,/#%&&&&&&&&%#(*//,.                                                                     \n               ");
          break;
          case 2:
          System.out.println("---------------------------------------------------------");
          System.out.println("|                           |_|                         |");
          System.out.println("---------------------------------------------------------");
          System.out.println("                                                                           `zWWWWWWWWWWWMWWW@@W@@@@@@@@M+,                  \n                                                                          `nWWWWWWMMMWWWWMWWWWWW@@@@@@@@@W#,                \n                                                                         `#WWWWMMWWMxMWWMMMWWWWW@W@@@@@@@@@Mi.`             \n                                                                       :#MWWWWWWWMWWxxWMWMMM@WWWW@W@@@@@W@@@@x:`            \n                                                                     ,nMWWWWWWMMWWMWMxMWWMWW@@WW@@@WWW@@@@W@@@M+`           \n                                                                    ,xWWWMWWWWWMMWMMMMxMWWWWW@@@@@@W@@@@@@@@@@@W;`          \n                                                                   .xWWWWWWWWWWWWMMWMMMMMWWWWW@W@@@@@@@@@@W@@@@@x.          \n                                                                  `nWWWWW@@WMMMWWWMMMMMMxMMMWWWWWWW@@@@@WWW@WWWWW*          \n                                                                  +WWMMWWWWWWWWMMMMMMMxxxxxxxxMMMMMWWWWWWWWWWWWWWM,         \n                                                                 .WMMMMMWWW@WWWMMMMMxxxnnnnxxxxxxxxMMMMMMMMMWWMMMW;         \n                                                                 +WWWWWWMWWWMMMMMMMxxnnnnnnnxxxxxxxxxMMMMMxxxnnnxWn`        \n                                                                `xWWWWWMMWWWWWWWWMxxnnnnnnnnnxxxxxxxxxxMxxxxxnnnnMW+        \n                                                                i@@@@@WWW@@@WWWWWMxnnnnnnnznnnxxxxxxxMMMxxxxnnnzznMM;       \n                                                                #@@WWWMWWWWWWWWWMxxnnnnznnnznnxxxxxxxxMMMxxxnnnzzznWx       \n                                                               .WWWWWWMMMMMWWWWMMxxnnnnzznnzznxxxxxxxxMxxMxxxnnzzzzMW,      \n                                                              `;WWWWWWWWWWWWWWWMxxxxnnzzznnnnnnxxxxxMMMMMMxxxnnnzzznM+      \n                                                              `;WWWWWWWWWMWWWWWMxxxxnnznnnnnnnnxMMMxMMMMMMMMxxnnnzzzxn      \n                                                               *WWWWMWWWWWWWMWMxxxnxnzzznnnnnnnxxxMMMMMMMMMxxxxnnz##zM`     \n                                                              `xWWWWWWWWWWMMMMMxxxxxnnzzznnnnnxxxxxMMMMMMMMxxxnnnz#+#M:     \n                                                              .WWWWWWWWWWWMMMMMMxxxnzzznnnnnnnxxxxxxMxxMMMxnnxxxnz##+x*     \n                                                              iWWWWWWWWWWMMMMMxMxnzzzzznnnznxxMMMMMMMMMMMMxnnxxxx##z+n+     \n                                                              zWWWWWWWWWWMMMMMxxnzzzzznnnnnxxMMMWWWMMMMMMMxnnnxMxzzz#zn     \n                                                              #WWWWWWWWWMMMMMxxzzzzzznnnnxxxMWWWWWWWWWMMWMxnnzxMxzzz##z     \n                                                              #WW@WWWWWWWMWMMxnzzzznnnznnxMWWWWW@W@@@@WWWMMxMnxMnzn#++n     \n                                                              nWWWWWWWMMWWMMxnzzzzznnnnxxMWMMMWWWW@@@@@@WWMMMxMMznn#+++     \n                                                              #W@@WWWWMWWMMMxzzzzznnnnxxxxxxxxxxMMWW@@@@WWWWMMWxzxn##+*     \n                                                              #WW@WWWWWWWWMxnzzzzznnnnnnnxxxMMMMMWWWW@@@WWWWMWMxnMxnz#*`    \n                                                              #WWWWWWWWWWWMxnzzzzznnznnnxnxMWW@@@@@WW@@WMWWWWWxMxMMMxzz*`   \n                                                              ;WMxWWMWWWWWMxnzzzznnnznxxxMWWW@WW@@@@@@@WMMMMMMxxMWWMMMnn#`  \n                                                              ;MxxnxMxMMWWMxnzzzznzznnxMMMWWMMWW@##@@@@WWxxxxxzxW@@WWWWxM#` \n                                                             `:xMz#znnxMMWMxnzzzzznnznxxMMMMMMMWWW@@@@@@Wxzznx#nWWW@@@WMMM,`\n                                                             `nMn+#zznzxMMxnzzzzznnnnnxxxMMMMMMWWWWW@@@WMnzznx+MWWWWWWWMMM; \n                                                             .Mxzznz##zxMMnnzzzzzzznnnxxxxMMWWWWWWW@@@@WMnzznxzM@@@WWMnzxx,`\n                                                             .Wnnnnz##znxxxnzzzzzzznnnnnxxxMMWWWWWW@@@@Wxnnnnxxn@@@@@WMzzz. \n                                                             :Wznzz##zzxMxxnzzzzzzzzzzznnnxxMMWWWWWWWWWMxnnznxxz@W@#@@@xn+` \n                                                             *xnxxxMnzzxMMxnzzzzzzzzzzznnnxxxMMMWWWWWWMxxnzznxxxM@@@MW@M#:  \n                                                             #xxMMMMzzzxWWMxnznnnnnnzzzznnnxxMMMWWWWWWMxnzzznnxxn@WMxMWni`  \n                                                             zMWWMxnznznWWWxnnnnnnnnznnnnnnxxMMMWWWWWMxnzzzzznxxnW@Wn#x*`   \n                                                             #WWWMnzzzzzMWWxnnnnnnnnnnnnnnxxMMMMWWWWWWMnzzzzznnxxxWWxnz:`   \n                                                             +MWWxn##zzzMWWMxnnnnznnnnnnnxxxMMMMWWWWWWMnnzzzznnxxnMMMxn*    \n                                                             inWWx#z#zznMWWMxnnnnnnnnnnnxxxMMMMMWWWWWMxxxxxnnnnxxnnMMxn+.   \n                                                             ,xnMxxnz#znMMMMMxnnnnnnnnxxxxxxxMMMWWWWWMnzzznnzznxxx#xxn#+,   \n                                                             .nxnzxMx#zxMMxMMxxnxxnnnnxMMxxxMxMWWWWWMMn##zzzzzzxMx#nxn#*;   \n                                                              *nnnznn#zxWMMxMMxxxnnMxxMMxnnxxxWW@WWMMMMnxW@MxnnxMx#nnz+*;   \n                                                              `#zzzznzzMWMMxMMMxMxMMMMWMnnnnMW@@WWWWMMWMxxMxMMxMxn#Mx#+i;`  \n                                                               .nzznnnnMWMxMxMMMMxMMMWWMnnnMW@@@WWWWWWWWWWMMxxxxMMxWMz*;i`  \n                                                                inzzzxxxMMMxnMMMMWMMWWWMnzx@@@@@@WWWW@@@@@WWWWnnnn@WMzi;;`  \n                                                                `nnnnnxMMMxxxxMMMWWWWWWMnnW@@@@@@@WW@@@W@@WWWMnxxxWWMzii:`  \n                                                                `nz##nMMMMxMxxMMWWWWWWWMxnW@@@@WWWWWWWW@@@WW@WnxMxMWxz*+.`  \n                                                                 zz##nWMxMMxxxxMMWWWW@WMxxW@@@WMMxxxxMMMMMMW@WMnMxxWx##*`   \n                                                                 zz##xMxxMMMxMxMMWWW@@@WMxW@@@@@WMMxxxMMMMWMWMxxMMMWx#z,`   \n                                                                 #zzzxMxxxxMMMMMxWWW@@@WMMM@@@@@WMxxxMMMMMMWWMnnnxMMx#n.    \n                                                                 #zzzMMxxxxMMMMMMMWW@@@WMMMW@@@WWMnn#n#nxxMWMMxz#xMxxzx     \n                                                                 #zznMxxMxxxMWMWWWWW@@@WWMMW@@@MMWMxnx#n#zxxnnMxzzMMxnx     \n                                                                 zzznMMxxxxxMMWWWWWW@@@@WMMW@@WWMMMMMMMxnznz*i#WMMWWnMx     \n                                                                `zzznMMxxxnxxMWWWWW@@@@@WMW@@@@WMMxxMMMMMxxn+**@@@@MxWn     \n                                                                .nzznMxxxxxxMMMWWWWW@@@@WMMW@@@WWWMxxxMMMMMxnnzzM@@MMx+     \n                                                                :zzznMMMxxxxxMMWWWW@@@@@WWW@@@@@WWMMxxnxMMMxxn##zWWMWx;     \n                                                                izzznMMMMxxxMMWWWWWW@@@@WWW@@@@@@WWWWMMxMMxxnz*+#WWMWx`     \n                                                                +zzznMMMMxMMMWWWWWWW@@@@WMWW@@@@@@@WWWWWWWWMxnz+#MMMW+      \n                                                                #zzzzMWWWMMMMMWWWW@@@@@@WWW@@@@@W@@W@WWW@@@WMxMxxWMxM:      \n                                                               ,nzzzzxWWWWWMMWWWWWW@@@@@WWWW@@@@@@@WWWWW@@@@WxnxMMxMx       \n                                                               ;zzzzzzxWWWWWMMWWWWW@@@@@WWMW@@@@@@@@@WWWW@WWMxnxxMxM#       \n                                                               ;zzzzzznMMWWWWWWWW@W@@@@@WMMWW@@@@@W@@@@W@WWMMnnxMWxxi       \n                                                               *zzzzzzznxMWWWWWWW@@@@@@@WMWWWW@@@@W@@@@WW@WWMnnxMMxn;       \n                                                               +zzzzzzzznnMWWWW@WWWW@@@@WWWWWW@@@W@@@@@@@WWWMxxMMMxz,       \n                                                               zzzzzzzzzzznxWW@@@@WW@@@@WWMWWW@@@@@@@@@@@WWWMMMMWMnz,       \n                                                              `zzzzzzzzzzzzznxWW@@@@W@@@WWMMWWW@@@@@@@@@@WWWWMWMWxn#;       \n                                                              :zzzzzzzzzzzzzznxMM@@@@@@@WWWMWWWWW@@@@@@@@WW@WWWWWMnz*       \n                                                              izzzzzzzzzzzzzznnnnMW@@@@@@WWMMWWWWW@W@@@@@@@@WWWWMxn#*       \n                                                              #zzzzzzzzzzzznzznnnnMWW@@@@WWMWMMWWWWW@W@@@@WWWWWMMxn#i       \n                                                             ,nzzzzzzzzzzznnnnnnnnxxM@@@@WWWWMMMMMWWWWWW@@@WWMMMxnn#:       \n                                                             +nzzz#zzzzzzznnnnnnnnnxxMW@@@WWWMWMMWWWWWWW@@@@WWMxxnz#`       \n                                                            ,nzzzz##zzzzznnnnnnnnnnnxxx@@@WWWWWWWWWWWWWWWW@@WWMMxxnz`       \n                                                           `znzzzz#zzzzzznnnnnnnnnnxnxxMW@@WWWWWWWWWW@@WW@@@WWMMxnni        \n                                                           +nnzzzz##zzzzznnnnnnnnnxnnnxxMW@@@@WWWWWWWW@WW@@@WWWMxxn:        \n                                                         ,*xnnzzzz##zzzznnnnnnnnnnnnnnnnxMWW@@@@@@@@@W@@W@@@WWMMxn*`        \n                                                        ,zxnnnzzzzz#zzzznnznnnnnnnnnnnnnnxxW@@@@@@@@@W@@@@@@WWMMMx:         \n                                                     ,:+nxnnnzzzzzz#zzzznnnnnnnnnnnnnnnnxxxMMWW@@@@@@@@@@@@@WWMMxi          \n                                                `.i*znxxxxnnnzzzzzzzzzzzzznnnnnnnnnnnnnnnxxMMWWWWWW@@@@@@@@WWWWxi           \n                                             .,i#nxxxxxxxxnnzzzzzzzzzzzzzznnnnnnnnnnnnnnxxxMWWWWWWMMxxWWWWWWWMx#");
          break;
          case 3:
          System.out.println("---------------------------------------------------------");
          System.out.println("|                           |_|                         |");
          System.out.println("---------------------------------------------------------");
          System.out.println("                                                                                    &@@@@@@@@@@@@@@@@@@&&&&@@&.                                    \n                                                                                   &@@@@@@@@@@@@@@@@@@&&@@&&&&&&&&.(.                               \n                                                                                  &@@@@@@@@@@@@@@@@@@@&&&@&&&@&&%&@@&.                              \n                                                                                 (@@@@@@@@@@@@@@@@@@@@@@@@@@&@&&&&&&&&,                             \n                                                                                %@@@@@@@@@@@@@@@@@@@@@@&@@@@&&&&&&&&%%&.                            \n                                                                                @@@@@@@@@@@@@@@@&&&&&&&&&&&@@@@&@@&&&/ .                            \n                                                                               *@@@@@@@@@@&@@@@&&&&&&&&%%&%%#((#%&&&,*                              \n                                                                               *@@@@@@@@@@&@@@&&&&&&&&&&&%%##(/**(%&%                               \n                                                                               *@@@@@@&&&&&&&&&&&&&&&&&&%##((((/***((                               \n                                                                               &&@@@@@@&&&&&&&&@@@@@@&&&&&%/(#(/**.                                 \n                                                                              &@@@%&%@&&&&&&&&@@@@@@@@@@@@&%#%%%#(,                                 \n                                                                              &@@@&&%@&&&&&&@@@@@@@@&&@@@@&(#@@&%&%                                 \n                                                                              (@&@&&&@@&%%%&&@@@&&%#%%&@&&&#*&%%&%                                  \n                                                                               .&@@&@&&&&&&&&&&@@@&&&&@@&&&&//*/*                                   \n                                                                               *%%%&&&@@&@@@@@@@&@@&@@@&&&&&#***/                                   \n                                                                               %%%%@&%&&&&@@@@@@&@@@@@@@@@&%////                                    \n                                                                              %%%%&&&&&@@@@@@@@@@@@@@@@@&&%%%#(                                     \n                                                                              %%%&&&@@@@@&@@@@@@@@@@@@&&#((&@#                                      \n                                                                             %%%%&&&&&&@@@&@@@&@@@@@@@@@@&&&%                                       \n                                                         ,%&&&@@@&@&&&&&&&&&&%%%&&&&&%%&&&@@@@@@@@@@@@@@@@@&/                                       \n                                   (&&&&&&&@@@@@@@@@@@@@@@@@&&&&&&&&&&&@&&&&&%%%&&&&%&&&&&&&@@@@@@@&&&&&&&%%                                        \n                               &&&&&&&&&@@@@&&&&&@@@@@@@@@@@@@@&&&@@@@@@&&&&&&%%&&&&%&&&&@@@@@@@@@@@@@@&&%%(                                        \n                            %&&&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&%%&&&&%%&&&@@&&&&%##((///(((*                                         \n                          %&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@&&@@@@@@@&&&&&&&%%&&&&%&&&&&&&%%%###((/*/(((///*                                      \n                         %%%&&&&&&&&&&&&&@@@&&&@@@@@@@@@@@@@@&&&@@@@@@@@&&&&&&&&&&&&&&&@&&%%%&%%##((//&@&&%%#(///.                                  \n                        %%%%&&&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&@&&@&&&&&&&&%%###(/&@@@@@&&%#((/**                                \n                       %%%%&&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&@@@&&&&&@@@&&%%%#(#@@@@@@@&&&%%#(//*.                              \n                      %%%%&&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&@@@@@&&&@@@@&&&&%##%&@@@&&%&&&&&%%(/***,                            \n                   &&%%%%%&&&&&&&&&&&&&&&&@@&@&&@&@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&@@@@&&@@&&&&%####(###(((#%%%&%%##((//((/*                           \n                ,&&&&%%%%&&&&&&&&&&&&&@@&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&@@@&@@@@&&&&&&&&&&&&&&&%###&&&&&&%%#((////////,                        \n               &&&&&&&&&%&&&&&@&&&&&@&&&&@&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&@@@@@@&@@@@@&@@@@&&&&%%%&&&&&&&&&%%##((((((((//*,                    \n               &&&&&&&&&&&&&&@@@@@@@@@@@@@@&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@&&&&@@@&&&&&&@@@@@@&&&&&&&&&&&&&&&&&&&%%%%%%%##(((/****.                 \n               &&&&&&&&&&&&&&@@@@@@@@@@@@@@&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@&&&@&@&@@@&&&&&@@@@@@@&&&&&&&&&&&&&&&&&%%%%%%%####(//****                \n               &&&&&&&&&%&&@@&@@@@@@@@@@@@@&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&@@@@@@@@@&@@@@@@@@@@&&@&&&&&&&&&&&&%&&&%%##%%#(//****.              \n               &&&&&&&&&&@@@@@@@@@@@@@@@@@@&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&@@@@@@@@@&@@@@@@@@@@@&&&&&&&&&&&&&&&&%%%%%%#(///****              \n               &&&&&&&@@@&@@@@@@@@@@@@@@@@@&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&@@@@@@@@@@@@&@@&&@@@&@&&&&&&&&&&&&&&&&&%%%%%%#((///**,             \n               &@&&&@@@@@@@@@@@@@@@@*@@@@@@&&&&@@&@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&@@@@@@@@@@@@@&@@@@@@&@&&&&&&&&&&&&&&&&&&&&&%%#((///***             \n               &&&@@&@@@@@@@@@@@@@   (@@@@@@&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&&%###(//////             \n               @@@@@@@@@@@@@@@@*      *@@@@@@&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&@&&&&&&&&%%##(((///.             \n               @@@@@@@@@@@@@%           &@@@@@@&@@&@@@@@@@@@@@@@@@@@@@@@@@@&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&%%%#((((/*              \n               @@@@@@@@@@                /&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&%%##(((/(               \n               @@@@(                       #&@@&&@@&&@@@@@@@@@@@@@@@@@@@@@@&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&%##(((/*               \n               @@@.                          &&&&&&&@@@@@@@@@@@@@@@@@@@@@@@&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&%%#((///,              \n               @@@,                          (@&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@&@@@@@@@@@@@@@@@@@@@@@@@@@@@&@&&&&&&&&&&&&&&&&&%%#(((////              \n               @@@&                           @&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&@&&&&&&&&&&%%%%%%%%%##((((////             \n               @@@@                   .@@@&   @@&&&&&&&&&&&&&&&&&@@@@@@&@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&%%&%%&&&&%%%%####%#(((((((//,            \n               @@@@,                  &@@@&   #@@&&&&@&&&&&&&&@@@@@@@@&&&@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&%%%&%%&&&&&&%%%##%%%#((/(((///            \n               @@@@*                  @@@@@@@@&&@@&&&&&&&&&@@@@@@@@@@@&&&&@@@@@@@@@@@@@@@@@@@&&&&&%%%&&&&&%%%%&%&&&&&&&&%%####%%##(#(///            \n               @@@@/                 &@@@@@@@@&&@@@@@&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&@&&&&%%%%%#%%@@@&%%%&&%&&&&&&&%%%###%##%%#(///            \n               @@@@(                 @@@@@@@@@&&&@@@@&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&@@&%%%%%###&@@@@&&&%%&&%&&&&&&&&%#####%%%#(//,            \n               @@@@%                 @@@@@@@@@&&&&@@@&&&&&@@@@@@@@@@@@&&&@@@@@@@@@@@&&&&%%&@&%%%####&@@@@@@&&&&&&&%&&&&&&&%%####%%##(//,            \n               @@@@&                &@@@@@@@@&&&&&@@@@&&&&&@@@@@@@@@@&&@@@@@@@@@@@@@@&&%%%&&%%%%###(#@@@@@@&&&&&&&&&&@&&&&&%####%%%#((//            \n               @@@@@/               @@@@&.  (&&&&&@@@@&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&%%##((((      (&&&&&&&&@&&&&&&%%%%%#%%#(((/            \n               @@@@@@               @@@@&   &&&&&&@@@@&&&@@@@@@@@@@@@@@@@@@@@@@@&&&&&&%%%&@&%#####(((/     #&&&&&&&&&&&&&&&%%%###%%#((/(            \n               @@@@@@@.            %@@@@%   &&&&&&@@@@&&&@@@@@@@@@@@@@@@@@@@@@@@@@&&&%%%%&@&&%%##(((((     .&&&&&&&&&&&&&%%%%##(##%%#(((            \n               @@&@@@@@#           @@@@&,   %&&&&@@@@@&&&@@@@@@@@@@@@@@@@@@@@@@@@@&&&%%%%@@&&%%#(((((.    *&&&%&&&&%%%%%%%%%###((#%%#(((            \n               &&&&@@@@@#         .@@@@@      &&&@@@@@&@@@@@@@@@@@@@@@@@@@@@@@@&&&&&%%%%&&@@&%%#####*&&&&&&&&&&&&&&&&&%%%%%%%#(((#&%#((.            \n               &@&@&&&&&&&*&&&&&&&&@@@@&.    &&&&@@@@@@&&&@@@@@@@@@@@@@@@@@@@@@&&&&&%%%&%&@&&&%%%&&&&&&&&&&&&&&&&&&&&&&&&%%%%%###%&%##(             \n               @&@&&&&&&&&&&&&&&&&&&&&&&%  #&&&&@@@@@@@@@&@@@@@@@@@@@@@@@@@@@@@@@&&&%%&&&&&&%&&&&&&&&&&&&&&&&&&&&&&&&&@@@@&&&&&%%%%%##,             \n               &&&&&&&&&&&&&&&&&&@@&&&&&@&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&@&&&&&&&&&&&&&&&&&&&&&@@@@@@@@@@&&&&&&&&&%%%%#(              \n               &&&&&&%&@&&&&&%&@&&&&%#%%%&&&&&&&&&&%&&@@@@@@@@@@@@@@@@@@@@@@@@@&%%%%%%%&&%&&&&&&&&&&&&@@@@@@@@&&&&@@&&&&&&&&&&&&%%%%#               \n               &&&&&&&&%&@@@@@@@&&&&&@@&&&%%&&&@@&&&%%%%%%%%%%&@@@&&&&&&%%&&&&&&&&&&&%&&&&&&&&&&&&&&&&&&&&@@@@@@@@@@&&&&&%&&&&&&%%%%(               \n               &&&&&@@@@@@@&@@@@@@@&&&%%@@@@@&&%&&&&%%%%%%%%%%&&&&&&&&&&&&&&&@&&&&&&&&&&@@&&&&&&@@@@@@@@@@@@@@@@@&&&&&&&&&@&&&&&%%%(                \n               %%%%%%%%%%%%&@@@@@@@@@@@&&&&&&&&&&&#&%%%%%%&%%&&%%%&&&&&&%&&&%&&&@@@@&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%##########((/                \n               %###############%@@@@@@@@@@@@@@@&&&&%&&%%%%%%%%%&&@&&&&&&@@@&&&&&&&@@&@@@@@@@@@@@@@@@@@@@@@@@@&&&&&%%%%%%%%####((((((((              \n               %##############%%&&@@@@@@@@@@@&&&%%%%&&%%%%&%%%%&&&&@@@&&&&@@@@@@@@@@@@@&&@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&%%%%%###((((//((            \n               #####(((#######%&@@@@@@@@@@@@@@@@@@&&&%%&%&&&&&&%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&%%%%##((((///((((         \n               ((((((((((#####%&@@@@@@@@@@@@@@@@@@&@&&@&&&%%&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&&&&&%%%##(((/((((((*      \n               (((((((((#####%%&@@@@@@@@@@@@@@@@@@@@&&@&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&&&&&&&%%%%##((((((((,    \n");
          break;
          case 4:
          System.out.println("---------------------------------------------------------");
          System.out.println("|                           |_|                         |");
          System.out.println("---------------------------------------------------------");
          System.out.println("                 #n+                             \n               `Mxx`           `nnz`                            \n               `MnW*           :nnn.                            \n               `MnMx`         `*nnn.                            \n               ;MnnM,         `#nnn:                            \n              `*MxnMi         `znnn*`                           \n               #xxxxz.        ,nnnn+`                           \n              `xxnzxM;        ixn++#`                           \n              `nnnn#x#,      `#nn+in,                           \n              `xnnxixx:      .nnni;x:                           \n              `xnnx;zM;`     :xnni:x:                           \n              ,xnnxi+x#,     +nnn;:n;                           \n              iMnnxiixx:    `nnnn::zi                           \n              ;Mnnxi;nx:    ,nnnn::##                           \n              iMnnn*:zx:    :xnnn;:+z                           \n              ixnnn*:#xi    *nnnn::+z`                          \n              ixnnn*:+x#`   #nnnz::*n.                          \n              *xnnn*:inn`  `nnnnz::ix.                          \n              ixnnn*:;nx`  .xnnnn::ix,                          \n              *xnnn+::zx,  ,xnnnz,,;x,                          \n              ixnnn+::zx:  :xnznz,,:x,                          \n              ixnnn+,:#xi  ,xnnnz:::x:                          \n              ;xnnn+::+x*  ,xnnnz::;x:                          \n              ixnnn#:,*xz` *xnnnz::;x:                          \n              :xnnn#::*xz` ixnznz::;x:                          \n              ,xnnn#,:in#  ;xnnnz,:ix,                          \n              ,xnnnz::;x#` :xnnn#,,ix,                          \n              ,xnnnz::inz` .xnzn#:,+x,                          \n              .xnnnz::;nx. .xnnn#:,#x,                          \n              `nnnnz::;nx. .xnnn+::zx,                          \n              `znnnn::;nx. `xnnn*:;nn.                          \n               *xnnn;:;nx. `xnnn*:ixz                           \n               :xnnni,;nx` `xnzni,+x+                           \n               .nnzn*,:nx` `xnnni,#xi                           \n                #nnn#,;nx. `nnnn::zx,                           \n                ixnnn:;nx. .zxnn:;xn,                           \n                :xnnn;inx. `#xnz:*xn`                           \n                `nnnn#*nx:`;#xnz:#x#`                           \n                 ixnnnznx;;zzxnn:nMi`                           \n                 .xnnnxnx+#MnMxnznx:                            \n                 `nnnnnnx#xMxxnnnxn;                            \n                  ixnnnnxnxxnxMMMM#*                            \n                  .xnnnnMnnnnnxnnMz*`                           \n                  ,xnnnnxx@MnnnxnxWx:.                          \n                  .nxnnxnWMnnnnnnnW@M:                          \n                  ,nnnnnxWnnnnnnnnMnxni`                        \n                  ixnnnnxMnnnnnnznnnnx#.                        \n                  znnnnnnxnnnnnnnnnnnnz.                        \n                 .nnnnnnnnnnnnnznnnnnnM:                        \n                 ,xnnnnnnnnxnnnnnnnnnxx#`                       \n                 ,xnnnnznnnxxxnnnnznnxnn.                       \n                 ,xnnnnnnnnxnnxnnzznnnnx;`                      \n                 ,xnznnnnnnxnzznnznnnz+x+.                      \n                 ,xnznnnnnzx#n,znnnznMx#*:                      \n                 ,nzznnnnnnn*W;+nnzzzMM##i,.                    \n                 ,xznnzzzzzn+x*;nnnznnni:+#+:                   \n                 ;nz#i;::::*#+::nnzznn#,,;#M+                   \n                 ;n*:,.,.,,;;,i+nnnnn#;:ii:n*`                  \n                 *n;.,.,,,,,i*;;;;znz*:*ii;+:                   \n                 ##,..,..,,;;;i*i::z#:,+*ii+*`                  \n                .z:......,,,::;+#*,:i.;;,,.*i                   \n                .#:,..,,,,:*nxxM#:;*ii*,.,,*;                   \n                :zi..,.,,.,:,nxxx#:,,.;...:#;                   \n                ;n+;,....,,.,+xxx*`,,,;...:ii                   \n                ;n#+:......,.;zzz#*+ii,....;*                   \n                *nzii,.......,#++++i,.,...,,*                   \n               `#nz+,i,,......,###i,..,....:*                   \n               ,nzz#.,,.....,i.,::.,;......,i                   \n             `:znzz#,.,,.,.,.;i:,,;i,.,..,.:+                   \n            `;nnzzz+,,....,.,,,;i;:,.,.,...:+`                  \n           .+nzzzzz*......,.......,..,,....:+`                  \n          ,znzzzzzzi,,...,...,;...,..;,.,.,;n:                  \n        `*nzzzzzzzz;,,.,...,..;i:.,:i:.....:n#.                 \n       .znzzzzzzzz#,,,.,,,.....,;i;;,.....,;zn*.                \n     `;nnzzzzzzzzz+,,.....,,.,......,....,,,zzn*`               \n     .+nnzzzzzzzzzzi.,....,,..............,,.+zzni`             \n      ,znnzzzzzzzzzzz:,..,....,.......,....,..,;zzzn;            \n       `innzzzznnzzzzzz+,,...,.,.........,...,.,..,#zzzx;`        \n         ;nnzzzzzzzzzzzzz:................,......,,,.;zzzzn:        \n         ;nzzzzzzzzzzzzzz+,,.......,..................,+zzznn:      \n          :nnzzzzzzzzzzzzzz;,...,.,......,.....,.........;nzzznz,    \n           :nzzzzzzzzznznnnn*.,......,......,.,.,...,...,.,,+zzzzn#.  \n            .nnzzzznzzzznnnxn+,,.,...........................,,zzzzzn+`\n             ");
          break;
      }
      eleccion = teclado.nextInt();
  }

  if (eleccion == 2) {
      menuEleccion(nombre);
  }
      
}
/*----------------------------------------------------------------------- FUNCIONES MISCELÁNEAS -----------------------------------------------------------------------*/

public static void barraDeCarga() {
  int longitud=4;
  try {
  for (int n=0; n<longitud; n++) System.out.print("__");
  System.out.println("");
  for (int n=0; n<(2*(longitud-1)); n++) {
    Thread.sleep(250); System.out.print("#");
  }
  Thread.sleep(1000); System.out.print("#");
  Thread.sleep(1000); System.out.println("#");
}
  catch(Exception e) {
    System.out.println(e);
}
}

public static void barraDeCargaCorta() {
  int longitud=4;
  try {
  for (int n=0; n<longitud; n++) System.out.print("__");
  System.out.println("");
  for (int n=0; n<(2*(longitud-1)); n++) {
    Thread.sleep(125); System.out.print("#");
  }
  Thread.sleep(500); System.out.print("#");
  Thread.sleep(1000); System.out.println("#");
}
  catch(Exception e) {
    System.out.println(e);
}
}

/*----------------------------------------------------------------------- FUNCIONES CALCULADORA -----------------------------------------------------------------------*/
  public static void inicializarCalculadora(String nombre) {
    Scanner teclado = new Scanner(System.in);
    System.out.println("Introduce el primer operando (a) número real:");
    double a = teclado.nextDouble();
    System.out.println("Introduce el primer operando (b) número real:");
    double b = teclado.nextDouble();

    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Introduce la operación que deseas realizar:");
    System.out.println("1. Sumar");
    System.out.println("2. Restar");
    System.out.println("3. Multiplicación");
    System.out.println("4. División");
    System.out.println("5. Raíz enésima de a");
    System.out.println("6. Potencia de a");
    System.out.println("7. ln(a)");
    System.out.println("8. Volver al menú principal");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

    int eleccion = teclado.nextInt();
    boolean salioBien = false;
    while(!salioBien) {
      switch (eleccion) {
        case 1: { // suma
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          System.out.println("a + b = "+(a+b));
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          salioBien = true;
          inicializarCalculadora(nombre);
          break;
        }
        case 2: { // resta
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          System.out.println("a - b = "+(a-b));
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          salioBien = true;
          inicializarCalculadora(nombre);
          break;
        }
        case 3: { // multiplicacion
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          System.out.println("a * b = "+(a*b));
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          salioBien = true;
          inicializarCalculadora(nombre);
          break;
        }
        case 4: { // division
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          System.out.println("a / b = "+(a/b));
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          salioBien = true;
          inicializarCalculadora(nombre);
          break;
        }
        case 5: { // raiz de a
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          System.out.println("Introduce el índice de la raíz: (número entero)");
          double indice = teclado.nextDouble();
          if (indice%2 == 0 && a >= 0) {
            System.out.println("Raíz de indice "+indice+" de "+a+" = "+Math.pow(a,(1.0/indice)));
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          }
          else {
            System.out.println("Se ha cambiado el signo de a, ya que es imposible hacer una raíz de indice par de un número negativo en los números reales");
            System.out.println("Raíz de indice "+indice+" de "+a+" = "+Math.pow(-a,(1.0/indice)));
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          }
          salioBien = true;
          inicializarCalculadora(nombre);
          break;
        }
        case 6: { // potencia
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          System.out.println("Introduce el índice de la potencia: ");
          double indice = teclado.nextInt();
          System.out.println(a+" elevado a "+indice+" = "+Math.pow(a,indice));
          System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          salioBien = true;
          inicializarCalculadora(nombre);
          break;
        }
        case 7: { // logaritmo neperiano
          if (a > 0) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(" = "+Math.log(a));
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          }
          else {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            System.err.println("ERROR: Se ha introducido un valor negativo.");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
          } 
          salioBien = true;
          inicializarCalculadora(nombre);
          break;
        }
        case 8: {
          menuEleccion(nombre);
          break;
        }
        default: {
          System.err.println("ERROR: Introduce una opción válida.");
        }
      }
    }
  }
/*----------------------------------------------------------------------- FUNCIONES DE CHAT Y CONTACTOS -----------------------------------------------------------------------*/
public static void conversacion(String nombre){
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Seleccione con quien quiere iniciar una conversacion: ");
    System.out.println("------------------------------------------------------------------------");
    File dir = new File ("contactos/");
    String[] nombres = dir.list();
    if (nombres.length != 0) {
        for (int i = 0 ; i < nombres.length ; i++){
            nombres[i] = nombres[i].substring(0, nombres[i].indexOf("."));
            System.out.println((i+1)+". "+nombres[i]);
        }
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        System.out.println(nombres[e-1]);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1. Llamada\n2. Chat");
        System.out.println("------------------------------------------------------------------------");
        char f = sc.next().charAt(0);
        switch (f) {
            case '1' : llamada(nombres[e-1], nombre); break;
            case '2' : chat(nombres[e-1], nombre); break;
        }
        sc.close();
        inicializarChatYContactos(nombre);
    } else {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("No hay contactos guardados");
        System.out.println("------------------------------------------------------------------------");
        inicializarChatYContactos(nombre);
    }         
}
public static void llamada(String s, String nombre) {
    System.out.println("-------------------------\n");
    System.out.println(s+"...");
    System.out.println("\n\n\n");
    System.out.println("-------------------------\n");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    inicializarChatYContactos(nombre);
}
public static void chat(String s, String nombre) {
  System.out.println("Parece que tus contactos son comediantes...");
    System.out.println("------------------------------------------------------------------------\n");
    System.out.println("Escriba 'salir' para salir\n");
    System.out.println(s);
    Scanner sc = new Scanner (System.in);
    String c = "";
    while (!c.equals("salir")) {
      int k = (int) (Math.random()*(10-0))+1;
      System.out.println("\n\n");
      switch (k) {
        case 0: System.out.println("Un pez le pregunta a otro pez: ¿qué hace tu mamá? Este le contesta: Nada, ¿y la tuya qué hace? Nada también."); break;
        case 1: System.out.println("¿Cuál es el último animal que subió al arca de Noé? El del-fin."); break;
        case 2: System.out.println("¿Por qué las focas miran siempre hacia arriba? ¡Porque ahí están los focos!"); break;
        case 3: System.out.println("Sí los zombies se deshacen con el paso del tiempo ¿zombiodegradables?"); break;
        case 4: System.out.println("¿Qué le dice un techo a otro? Techo de menos."); break;
        case 5: System.out.println("¿Qué es un pez en el cine? Pues un mero espectador..."); break;
        case 6: System.out.println("¿Cómo se queda un mago después de comer? Magordito."); break;
        case 7: System.out.println("Dos tontos en un tren: —¿Ves qué rápido pasan los postes? —Sí, en el viaje de vuelta volvemos en poste."); break;
        case 8: System.out.println("—¿Qué le dice una pared a otra pared? —Nos vemos en la esquina."); break;
        case 9: System.out.println("Van dos ciegos y le dice uno al otro: —Ojalá lloviera. —Ojalá yo también."); break;
        case 10: System.out.println("Van dos y se cae el del medio."); break;
      }
      System.out.println("\n\n\n");
        c = sc.nextLine();
    }
    System.out.println("-------------------------\n");
    inicializarChatYContactos(nombre);
}
public static void agregarContactos(String nombre){
    System.out.println("------------------------------------------------------------------------");
    System.out.println("1. Agregar a contacto existente\n2. Agregar nuevo contacto");
    System.out.println("------------------------------------------------------------------------");
    Scanner sc = new Scanner (System.in);
    char o = sc.nextLine().charAt(0);
    switch (o) {
        case '1': 
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Indique el nombre del contacto existente:");
            System.out.println("------------------------------------------------------------------------");
            String nE = sc.nextLine();
            File dir = new File("contactos/");
            String[] nombresA = dir.list();
            if (nombresA == null) {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("No hay contactos guardados");
                System.out.println("------------------------------------------------------------------------");
            } else {
                for (int i = 0; i < nombresA.length; i++) {
                   String nombreA = nombresA[i];
                   nombreA = nombreA.substring(0, nombreA.indexOf("."));

                   if (nombreA.equals(nE)) {
                       System.out.println("------------------------------------------------------------------------");
                       System.out.println("1. Cambiar nombre\n2. Cambiar numero");
                       System.out.println("------------------------------------------------------------------------");
                       char h = sc.next().charAt(0);
                       switch (h) {
                           case '1':
                                System.out.println("------------------------------------------------------------------------");
                                System.out.println("Escriba el nuevo nombre (Maximo 20 caracteres)");
                                System.out.println("------------------------------------------------------------------------");
                                String nNombre = sc.next(); 
                                while (nNombre.length() > 20) {
                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println("Escriba el nombre correctamente");
                                    System.out.println("------------------------------------------------------------------------");
                                    nNombre = sc.next();
                                }
                                String dirNN = "contactos/"+nNombre+".txt";
                                String dirAN = "contactos/"+nE+".txt";
                                File antiguoNombre = new File (dirAN);
                                try {
                                    File nuevoNombre = new File (dirNN);
                                    FileReader reader = new FileReader (antiguoNombre);
                                    BufferedReader reader2 = new BufferedReader(reader);
                                    reader2.readLine();
                                    String numeroTelf = reader2.readLine();
                                    FileWriter fw = new FileWriter(nuevoNombre);
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    PrintWriter pw = new PrintWriter(fw);
                                    pw.println(nNombre);
                                    pw.println(numeroTelf);
                                    
                                    pw.close();
                                    bw.close();
                                    reader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (antiguoNombre.delete()) {
                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println("Cambio de nombre exitoso");
                                    System.out.println("------------------------------------------------------------------------");
                                } else {
                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println("Cambio no exitoso");
                                    System.out.println("------------------------------------------------------------------------");
                                }  
                            break;
                            case '2': 
                                Scanner sc2 = new Scanner (System.in);
                                System.out.println("------------------------------------------------------------------------");
                                System.out.println("Escriba el nuevo numero");
                                System.out.println("------------------------------------------------------------------------");
                                String nNum = sc2.nextLine();
                                while (nNum.length() != 9) {
                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println("Escriba correctamente el nuevo numero");
                                    System.out.println("------------------------------------------------------------------------");
                                    nNum = sc2.nextLine();
                                }
                                sc2.close();
                                try {
                                    FileReader reader = new FileReader("contactos/"+nE+".txt");
                                    BufferedReader reader2 = new BufferedReader(reader);
                                    String nom = reader2.readLine();
                                    FileWriter fw = new FileWriter("contactos/"+nE+".txt");
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    PrintWriter pw = new PrintWriter(fw);
                                    pw.println(nom);
                                    pw.println(nNum);
                                    bw.close();
                                    pw.close();
                                    reader2.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            break;
                       }
                   }
                }
             }
        break;
        case '2': 
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Escriba el nombre del contacto (Maximo 20 caracteres)");
            System.out.println("------------------------------------------------------------------------");
            String nC = sc.nextLine();
            while (nC.length() > 20){
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Escriba el nombre nuevamente");
                System.out.println("------------------------------------------------------------------------");
                nC = sc.nextLine();
            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Escriba el numero del contacto");
            System.out.println("------------------------------------------------------------------------");
            String numC = sc.nextLine();
            while (numC.length() != 9 ){
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Introduzca correctamente el numero del contacto");
                System.out.println("------------------------------------------------------------------------");
                numC = sc.nextLine();
            }
            try {
                FileWriter fw = new FileWriter("contactos/"+nC+".txt");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(nC);
                pw.println(numC);
                bw.close();
                pw.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        break;
    }
    inicializarChatYContactos(nombre);
    sc.close();
}

public static void inicializarChatYContactos(String nombre) {
  System.out.println("------------------------------------------------------------------------");
  System.out.println("1. Contactos\n2. Conversacion\n3. Volver al menu principal");
  System.out.println("------------------------------------------------------------------------");
  Scanner sc = new Scanner(System.in);
  char op = sc.next().charAt(0);
  switch(op){
      case '1': agregarContactos(nombre);
      break;
      case '2': conversacion(nombre);
      break;
      case '3' : menuEleccion(nombre);
  }
  sc.close();
}

/*----------------------------------------------------------------------- FUNCIONES AGENDA -----------------------------------------------------------------------*/
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Programa Principal
  public static void inicializarAgenda(String nombre){
    String base = "3";
    int eleccion = 0;
    while (base.equals("3")){
        int baseInicial = intro();
        base = subMenu(baseInicial); //el que sería el caso dos
        if (base.equals("1")) eleccion = 1;
        if (base.equals("4")) eleccion = 3;
        if (base!="4" && base!="1" && base!="xxx") eleccion = 2;
        switch(eleccion){
          case 1:{
            leerTodotxt(nombre);
          }break;
          
          case 3:{
            System.out.println("Esperemos que haya sido de su utilidad.");
            base = "5";
          }break;
          
          case 2:{
            int numeroMenuFecha = numMenuFechas(base, nombre);
            int baseMenuFecha = 0;
            while(baseMenuFecha==0){
            switch (numeroMenuFecha){
              case 1: 
                  crearYGuardarCita(base, nombre);
                  baseMenuFecha=1;
                  break;//Crear Cita
              case 2: 
                  eliminarUnaCita(base, nombre);
                  baseMenuFecha=1;
                  break;//Eliminar Cita
              case 3: 
                  eliminarTodasLasCitas(base, nombre);
                  baseMenuFecha=1;
                  break;
              default: 
                  baseMenuFecha=1;

                  //Regreso al principal
        }//Switch menu opciones de la fecha
    }//While MENU FECHA (con el valor 0 se queda dentro)
    baseMenuFecha=0;
    }//Case 2
    }//__________________________________________Switch Menu Principal
    base="3";
    }//__________________________________________While MENU PRINCIPAL (para reiniciar tiene que tener base="3")
    
  }//Final del Main
  
 
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Funciones Auxiliares a trabajar
//___________________________________________________________Funcion para crear cita en una fecha_________________________________________________________________
  public static void crearYGuardarCita(String fecha, String nombre){
    try{
    String direccion = "CitasAgenda/"+fecha+".txt";
    FileWriter fw = new FileWriter(direccion,true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(fw);
    Scanner escribir = new Scanner (System.in);
    System.err.println("Por favor, introduzca la cita que desea guardar el "+fecha+".");
    String nuevaCita = escribir.nextLine();
    pw.println(nuevaCita);
    pw.close();
    bw.close();
    }
    catch (IOException e) {
    e.printStackTrace();
    System.out.println("Fresco mi pana");//Easter Egg
    inicializarAgenda(nombre);
    }
  }
  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Ficheros
//___________________________________________________________Funcion Leer todos los archivos txt de la carpeta______________________________________________________
  public static void leerTodotxt(String nombre){
      File dir = new File ("CitasAgenda/");
      barraDeCargaCorta();
      System.out.println("Citas pendientes:");
      String [] archivos = dir.list();
      if (archivos.length != 0) {
            for (int i = 0 ; i < archivos.length ; i++){
                archivos[i] = archivos[i].substring(0, archivos[i].indexOf("."));
            }
            System.err.println("______________________________________________________________________");
            for(int i = 0; i<(archivos.length)-1; i++){
              System.err.println("Día "+archivos[i]+":");
              leerlineastxt (archivos[i], nombre);
              System.err.println("");
            }
              System.err.println("Día "+archivos[(archivos.length)-1]+":");
              leerlineastxt (archivos[(archivos.length)-1], nombre);
            System.err.println("______________________________________________________________________");
      } else {
        System.err.println("No tiene citas guardadas.");
      }
  }
//___________________________________________________________Funcion Leer un único txt___________________________________________________________________________
    public static void leerlineastxt(String base, String nombre) {
    try {
      FileReader leer = new FileReader("CitasAgenda/"+base+".txt");
      BufferedReader leedor = new BufferedReader (leer);
      Scanner file  = new Scanner(new File("CitasAgenda/"+base+".txt"));
      int n = 0;
        while(file.hasNextLine()) {
            file.nextLine();
            n++;
        }
        int i = 0;
        while (i<n){
          System.err.print("Cita "+(i+1)+": ");
          System.out.println(leedor.readLine());
            i++;
        }
      leedor.close();
    }
    catch (IOException e){
      System.out.println("No tiene citas guardadas.");
      System.out.println("______________________________________________________________________");
    } 
  }
//______________________________________________________________________Eliminar todas las citas______________________________________________________________________
    public static void eliminarTodasLasCitas(String fecha, String nombre){
      try{
        File citasDia = new File ("CitasAgenda/"+fecha+".txt");
        if (citasDia.delete()) {
          System.out.println("Sus citas para el día "+fecha+" han sido eliminadas.");
        } 
        else System.out.println ("Ha habido un error eliminando sus citas");
        System.out.println ("");
      }
      catch(Exception e){  
        e.printStackTrace();  
      }
      inicializarAgenda(nombre);
    }
//______________________________________________________________________Eliminar una cita___________________________________________________________________________ 
    public static void eliminarUnaCita(String fecha, String nombre){
      System.out.println("¿Qué cita desea eliminar?");
      Scanner sc = new Scanner(System.in);
      String linea = sc.nextLine();
      File citasDia = new File("CitasAgenda/"+fecha+".txt");
      File tempCitasDia = new File("CitasAgenda/temp"+fecha+".txt");
      try{
        FileReader leer = new FileReader(citasDia);
        BufferedReader leedor = new BufferedReader(leer);
        FileWriter escribir = new FileWriter(tempCitasDia);
        BufferedWriter escribir2 = new BufferedWriter(escribir);
        Scanner file  = new Scanner(citasDia);
        int n = 0;
        while(file.hasNextLine()) {
            file.nextLine();
            n++;
        }
        String lineaBorrada = linea;
        String lineaActual;

        while((lineaActual = leedor.readLine()) != null) {
   
          String lineaSinEspacios = lineaActual.trim();
          if(lineaSinEspacios.equals(lineaBorrada)) continue;
          escribir2.write(lineaActual + System.getProperty("line.separator"));
        }
        escribir2.close(); 
        leedor.close(); 
      }catch (IOException e) {
        e.printStackTrace();
      }
      cambiarNombre(fecha, nombre);
      inicializarAgenda(nombre);
    }
    public static void cambiarNombre(String fecha, String nombre){
      File citasDia = new File("CitasAgenda/"+fecha+".txt");
      File nuevoCitasDia = new File("CitasAgenda/temp"+fecha+".txt");
      eliminarTodasLasCitas(fecha, nombre);
      nuevoCitasDia.renameTo(citasDia);
    }
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Funciones de Menu Fecha
//______________________________________________________________________Menu Opciones de la Fecha___________________________________________________________________
  public static int numMenuFechas(String base, String nombre){
    System.err.println("Sus citas para el día "+base+" son:");
    leerlineastxt(base, nombre);
    System.out.println("Viendo sus citas, ¿que desea realizar?");
    System.out.println("1. Crear una cita.");
    System.out.println("2. Eliminar una cita.");
    System.out.println("3. Eliminar todas las citas.");
    System.out.println("4. Cancelar.");
    Scanner leer = new Scanner(System.in);
    int opcion = leer.nextInt();
      while (opcion<1 || opcion>4){
        System.out.println("Su número no es válido, por favor, introduzca 1, 2, 3 o 4.");
        opcion = leer.nextInt();
      }
    return opcion;
  }
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\Funciones comienzo programa
//___________________________________________________________________________Introducción al Programa___________________________________________________________
  public static int intro(){
   System.out.println("¡Bienvenido a su agenda personal! A continuación tiene a su alcance una herramienta para organizar sus horarios y reuniones.");
   System.err.println("¿Qué desea realizar? Por favor introduzca el número correspondiente a su elección.");
   System.out.println("1. Comprobar mis citas pendientes");
   System.out.println("2. Modificar las citas de una fecha");
   System.out.println("3. Regresar al inicio");
      Scanner leer = new Scanner(System.in);
      int opcion = leer.nextInt();
      while (opcion!=1 && opcion!=2 && opcion!=3){
         System.out.println("Su número no es válido, por favor, introduzca 1, 2 o 3");
         opcion = leer.nextInt();}
      return opcion;
  }
  //________________________________________________________________________Menu switch con Strings para redirigir al menu principal_______________________________
  public static String subMenu (int baseInicial){
    String res = "";
  switch (baseInicial){
      case 1: res= "1"; break;
      case 2:{
        String fecha = fechaNueva(); 
        if (fecha.equals("xxx")){ res = "3";
          System.err.println("La fecha que ha introducido no es correcta, se le regresará al menú principal de su agenda.");}
        else res = fecha;} break;
      case 3: res = "4"; break;
    }
    return res;
  }
//_________________________________________________________________________Introducir fecha y en caso de que sea incorrecta, devolver "xxx"________________________
  public static String fechaNueva(){
    System.out.println("Por favor introduzca en que fecha desea modificar sus citas de la forma dd-mm-aaaa");
    Scanner leer = new Scanner (System.in);
    String fecha = leer.next();
    if (!(comprobarFecha(fecha))){
    return "xxx";
      }
    return fecha;
  }  
//_________________________________________________________________________Pasar elementos de la fecha a su correspondiente numérico____________________________
  public static int diaANum(String fecha){
    int dia = Integer.parseInt (fecha.substring(0, fecha.indexOf("-")));
    return dia;
  }
  public static int mesANum(String fecha){
    int mes = Integer.parseInt (fecha.substring(fecha.indexOf("-")+1, fecha.lastIndexOf("-")));
    return mes;
  }
  public static int anioANum(String fecha){
    int anio = Integer.parseInt (fecha.substring(fecha.lastIndexOf("-")+1));
    return anio;
  }
//_________________________________________________________________________Funciones Calendario, para comprobar año, día, mes y todo junto______________________
//__________________________________________________________________________________________________________________________________________________________
  public static boolean esBisiesto (int anyo) {
    return ((anyo%4==0)&&(anyo%100!=0)||(anyo%400==0));
  }
  
  public static boolean comprobarAnyo (int anyo) {
    return (anyo>=0);
  }
  
  public static boolean comprobarMes (int mes) {
    return (mes>=1) && (mes<=12);
  }
  
  public static boolean comprobarDia (int dia, int mes, int anyo) {
    boolean res = false;
    switch (mes) {
      case 2:
        if (esBisiesto(anyo))
        res = (dia>0)&&(dia<=29);
        else
        res = (dia>0)&&(dia<=28); break;
      case 4:
      case 6:
      case 9:
      case 11: res = (dia>0)&&(dia<=30); break;
      default: res = (dia>0)&&(dia<=31); break;
    }
    return res;
  }
  
  public static boolean comprobarFecha (String fecha) {
    boolean res = false;
    String diaT = fecha.substring(0, fecha.indexOf("-"));
    int dia = Integer.parseInt(diaT);
    String mesT= fecha.substring(fecha.indexOf("-")+1, fecha.lastIndexOf("-"));
    int mes = Integer.parseInt(mesT);
    String anyoT = fecha.substring(fecha.lastIndexOf("-")+1);
    int anyo = Integer.parseInt(anyoT);
    res = comprobarAnyo(anyo) && comprobarMes(mes) && comprobarDia(dia, mes, anyo);
    return res;
  }
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Final del Proyecto
}




