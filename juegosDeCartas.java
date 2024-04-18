import java.io.*;
import java.util.Scanner;
public class juegosDeCartas
{
  public static void main (String[]args){
    barraDeCarga();
    String usuario = iniciarSesion();
    barraDeCarga();
    int comienzoSecciones = 0;
    int base=0;
    while(base==0){  
    while (comienzoSecciones==0){
    comienzoSecciones = elegirSubmenu(menuPrincipal(usuario));
  
    }                                                                                            //A partir de aqu� ya comienza el programa de los juegos y del ranking
    switch (comienzoSecciones){
      case 1: //Mus
        mus();
        base=volverAJugar();
        break;
      case 2: //BJ
        blackJack();
        base=volverAJugar();
        break;
      case 3: //Ranking
        leaderboard(usuario);
    }
    comienzoSecciones=0;
   }
   System.err.println("Esperemos que regrese pronto "+usuario); 
  }
  
//_________________________________________________________________________________________________Funciones Auxiliares
  public static int volverAJugar(){  //Esta funcion nos permite volver a ejecutar los juegos o salir cambiando la base
  System.out.println("�Desea volver a jugar y volver al menu principal?");
  System.out.println("1. Si");
  System.out.println("2. No, salir del programa");
  Scanner leer = new Scanner (System.in);
  int opcion = leer.nextInt();
      while (opcion!=1 && opcion!=2){
         System.out.println("Su n�mero no es v�lido, por favor, introduzca 1 o 2");
         opcion = leer.nextInt();}
  if (opcion==1) opcion=0;
  else opcion=1;
  return opcion;
}
  public static String iniciarSesion(){
    System.out.println("Bienvenido nuevo jugador, �con que nombre quieres registrarte? Ten en cuenta que este ser� tu nombre en el ranking");
    Scanner leer = new Scanner (System.in);
    String nombre = leer.nextLine();
    System.out.print("Ha quedado registrado como: "); System.err.print(nombre); System.out.println(". Disfrute su sesi�n.");
    return nombre;
  }
  
//_________________________________________________________________________________________________Menu
    public static int menuPrincipal (String usuario){
  int opcion = 0;
  Scanner leer = new Scanner (System.in);
  while(opcion<1){
    System.out.print("Introduzca el n�mero de la opci�n del men� a la que desea acceder, "); System.err.println(usuario); System.out.print(".");
    System.out.println("1. Jugar al mus");
    System.out.println("2. Jugar al BlackJack");
    System.out.println("3. Acceder al sistema de Ranking");
    opcion = leer.nextInt();
    }
  return opcion;
  }
  
    public static int elegirSubmenu(int n){
      int opcionFinal=0;
          switch(n){
          case 1: opcionFinal = subMenuMus(); break;
          case 2: opcionFinal = subMenuBlackJack(); break;
          case 3: opcionFinal = subMenuRanking();
          }
       return opcionFinal;
    }
    
    
    //________________________________________Submenus
    
  public static int subMenuMus(){
      Scanner leer = new Scanner (System.in);
      System.out.println("�Desea comenzar una partida de mus?"+"\n"+"1. Si \n"+"2. No, volver al menu principal");
      int miniopcion = leer.nextInt();
      while (miniopcion!=1 && miniopcion!=2){
         System.out.println("Su n�mero no es v�lido, por favor, introduzca 1 o 2.");
         miniopcion = leer.nextInt();
         }
      if (miniopcion==2) miniopcion=0;
      return miniopcion;
      }
  
  public static int subMenuBlackJack(){
      Scanner leer = new Scanner (System.in);
      System.out.println("�Desea comenzar una partida de BlackJack?"+"\n"+"1. Si \n"+"2. No, volver al menu principal");
      int miniopcion = leer.nextInt();
      while (miniopcion!=1 && miniopcion!=2){
         System.out.println("Su n�mero no es v�lido, por favor, introduzca 1 o 2.");
         miniopcion = leer.nextInt();
         }
      if (miniopcion==2) miniopcion=0;
      else miniopcion=2;
      return miniopcion;
      }
  
  public static int subMenuRanking(){
      Scanner leer = new Scanner (System.in);
      System.out.println("�Quiere consultar los Rankings?"+"\n"+"1. Si \n"+"2. No, volver al menu principal");
      int miniopcion = leer.nextInt();
      while (miniopcion!=1 && miniopcion!=2){
         System.out.println("Su n�mero no es v�lido, por favor, introduzca 1 o 2.");
         miniopcion = leer.nextInt();
         }
      if (miniopcion==2) miniopcion=0;
      else miniopcion=3;
      return miniopcion;
      }
    
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
//__________________________________________________________________________________________________________________________________________________________________
  public static void leaderboard(String usuario)
  {
        System.out.println("                LEADERBOARD");
        System.out.println("MUS: ");
        System.out.println("Usuario: " +usuario+" " + leerPuntuacion(puntuacionMus(),0)+   "  "+"Maquina: "+leerPuntuacion(puntuacionMus(),1)+"");
        System.out.println("BLACKJACK: ");
        System.out.println("Usuario: "+usuario +" " + leerPuntuacion(puntuacionBlackJack(),0)+"     "+"Maquina: "+leerPuntuacion(puntuacionBlackJack(),1)+"");
  }
   public static int leerPuntuacion(int[] puntuacion, int p){
        int puntos = puntuacion[p];
        return puntos;
    }
    public static int[] puntuacionBlackJack(){//la posicion 0 es el usuario y la 1 la maquina
        int[] puntuacionU = new int[2];
        try {
            FileReader leer = new FileReader("puntuacionBlackJack.txt");
            BufferedReader archivo = new BufferedReader(leer);
            puntuacionU[0] = Integer.parseInt(archivo.readLine());
            puntuacionU[1] = Integer.parseInt(archivo.readLine());
        } catch (Exception e) {
            System.out.println("error");
        }
        return puntuacionU;
    }
    public static int[] puntuacionMus(){//la posicion 0 es el usuario y el 1 la maquina
        int[] puntuacionM = new int[2];
        try {
            FileReader leer = new FileReader("puntuacionMus.txt");
            BufferedReader archivo = new BufferedReader(leer);
            puntuacionM[0] = Integer.parseInt(archivo.readLine());
            puntuacionM[1] = Integer.parseInt(archivo.readLine());
        } catch (Exception e) {
            System.out.println("error");
        }
        return puntuacionM;
    }
    
   public static void blackJack()
  {
   System.out.println("Bienvenido a BlackJack:");
        System.out.println("�En qu� dificultad quieres jugar?\n"+"1. Normal\n"+"2. Dif�cil\n"+"3. Imposible\n");
        Scanner sc = new Scanner(System.in);
        char e = sc.next().charAt(0);
        int[] jugador1 = new int[4]; // crea mano del jugador vacio
        int[] maquina = new int [4]; // crea mano de la maquina vacia
        int [][] baraja = crearBaraja(); // crea la baraja de poker
        jugador1 = repartirCartasInicio(baraja, jugador1); // asigna dos cartas aleatorias de la baraja al jugador
        maquina = repartirCartasMaquina(baraja, maquina); // asigna dos cartas aleatorias de la baraja a la maquina
        switch (e) { // escoges en que dificultad quieres jugar
            case '1': maquina = normal(baraja, maquina); break;
            case '2': maquina = dificil(baraja, maquina); break;
            case '3': maquina = imposible(baraja, maquina); break;
        }
        System.out.println("\nSus cartas son: ");
        verCartas(jugador1); // imprime por pantalla las cartas
        System.out.println("");
        System.out.println("Las cartas de la maquina son: ");
        nombrarCartas(maquina[0]); // imprime por pantalla solo una carta de la maquina
        jugador1 = jugada(baraja, jugador1); //el jugador decide las jugadas
        int[] puntuacion = ganador(baraja, jugador1, maquina);
        try {
            FileReader reader = new FileReader("puntuacionBlackJack.txt");
            BufferedReader reader2 = new BufferedReader(reader);
            int pJ = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario
            int pM = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
            pJ += puntuacion[1];
            pM += puntuacion[0];
            FileWriter fw = new FileWriter("puntuacionBlackJack.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(pJ); 
            pw.println(pM);
            reader2.close();
            bw.close();
        } catch (Exception f) {
            System.out.println("error");
        } 
  }
  public static int[] normal(int [][] baraja, int[] mano){
        boolean nuevo = true;
        int i = 2;
        while (nuevo && i<4) {
            int r = (int) (Math.random() * (2-1))+1;
            switch(r) { // elige de forma aleatoria si quiere coger una nueva carta
                case 1 : 
                mano = nuevaCartaMaquina(baraja, mano, i);
                for (int j = 0; j < mano.length; j++) {
                    if(mano[j] == 1) {
                        r = (int) (Math.random() * (2-1))+1;
                        switch(r) {
                            case 1 : mano[j] = 14;
                            break;
                            default: break;
                        }
                    }
                }
                break;
                default: 
                nuevo = false;
                break;
            }  
            i++;
        }
        return mano;
    }
    public static int sumaAs(int [][] baraja, int [] mano) { // cambia el valor del As de 1 a 11 si est� en las dos primeras cartas y luego suma el valor de todas las cartas
        int resMaquina = 0;
        boolean doble = false;
            for (int i = 0; i < 2 && !doble; i++) {
                if (mano[i] == 1) {
                    mano[i] = 14;
                    doble = true;
                }
            }
            for (int i = 0; i < mano.length; i++) { // suma teniendo en cuenta que la Sota, Reina y Rey valen 10 y el As cambiado a 11 o a 1
                if ((mano[i] == 11) || (mano[i] == 12) || (mano[i] == 13)) {
                    resMaquina += 10;
                } else if (mano[i] == 14) {
                    resMaquina += 11;
                } else {
                    resMaquina += mano[i];
                }
            }
        return resMaquina;
    }
    public static int[] dificil(int [][] baraja, int [] mano){ 
        int j = 2; 
        while (j < 4) {
            int suma = sumaAs(baraja, mano);
            if (suma <= 19) { // evalua si quiere coger una nueva carta en base a si es arriesgado. En este caso mas de 19 es arriesgado al estar a 2 de 21
                mano = nuevaCartaMaquina(baraja, mano, j);
            } 
            j++;
        }
        return mano;
    }
    public static int[] imposible(int [][] baraja, int[] mano){
        int j = 2;
        while (j < 4) {
            int suma = sumaAs(baraja, mano);
            if (suma < 21) { // busca en el array las cartas que le faltan para llegar a 21
                int falta = 21-suma;
                if (falta <= 10) { // busca la carta exacta si lo que le falta es menor o igual a 10
                    int i = 0;
                    while (baraja[i][falta-1] == 0 && i<4) {i++;} // verifica que la carta que quiera coger ya este repartida
                    mano[j] = baraja[i][falta-1];
                    j++;
                } else if (falta<21 && falta>10) { // si la diferencia es mayor a 10, coge una que vale 10 y luego lo que falta para llegar a 21 teniendo ya un 10 cogido
                    int i = 0;
                    while (baraja[i][10] == 0 && i<4) {i++;} // verifica que la carta que quiera coger ya este repartida
                    mano[j] = baraja[i][10];
                    i = 0;
                    j++;
                    while (baraja[i][falta-10-1] == 0 && i<4) {i++;} // verifica que la carta que quiera coger ya este repartida
                    mano[j] = baraja[i][falta-10-1];
                } 
            }
            j++;
        }
        return mano;
    }
    public static void verCartas(int [] mano) { //recorre la mano y las imprime por pantalla
        boolean vacio = false;
        for (int i = 0; (i < mano.length) && (!vacio); i++) {
            if (mano[i] == 0) {
                vacio = true; // en el caso de llamarse al principio tendra solo dos cartas por lo que se pone otra condicion para que salga del bucle antes
            } else {
                nombrarCartas(mano[i]);
            }
        }
    }
    public static void nombrarCartas (int c) { //imprime por pantalla el numero en letras para facilitar la lectura del jugador
        switch (c){
            case 1: System.out.println("As"); break;
            case 2: System.out.println("Dos"); break;
            case 3: System.out.println("Tres"); break;
            case 4: System.out.println("Cuatro"); break;
            case 5: System.out.println("Cinco"); break;
            case 6: System.out.println("Seis"); break;
            case 7: System.out.println("Siete"); break;
            case 8: System.out.println("Ocho"); break;
            case 9: System.out.println("Nueve"); break;
            case 10: System.out.println("Diez"); break;
            case 11: System.out.println("Sota"); break;
            case 12: System.out.println("Reina"); break;
            case 13: System.out.println("Rey"); break;
        }
    }
    public static int[] jugada(int [][] baraja, int[] mano){ //pregunta al jugador lo que quiere hacer
        Scanner sc = new Scanner(System.in);
        boolean nuevo = true;
        int i = 2;
        while (nuevo && i<4) {
            System.out.println("Pulse 1 si quiere coger una nueva carta o 0 si quiere plantarse");
            char e = sc.next().charAt(0);
            switch(e) {
                case '1' : 
                mano = nuevaCarta(baraja, mano, i);
                System.out.println("");
                verCartas(mano);
                break;
                default: 
                nuevo = false;
                System.out.println("");
                verCartas(mano);
                break;
            }  
            i++;
        }
        return mano;
    }
    public static int[][] crearBaraja(){ // crea un array bidimensional recorriendo todo el array y asignando valores del 1 al 13
        int[][] baraja = new int [4][13];
        for (int i = 0; i< baraja.length; i++) {
            for (int j = 0; j< baraja[i].length; j++) {
                baraja[i][j] = j+1;
            }
        }
        return baraja;
    }
    public static int[] repartirCartasInicio(int[][] baraja, int[] mano) { // reparte las primeras dos cartas al jugador
        int i = 0;
        Scanner sc = new Scanner (System.in);
        while (i<2) {
            int fila = (int) (Math.random() * (3-0))+1;
            int columna = (int) (Math.random() * (12-0))+1;
            mano[i] = baraja[fila][columna];
            baraja[fila][columna] = 0; // indica que ya esta cogida la carta
            if (mano[i] == 1) { // pregunta si quiere cambiar el valor del As
                System.out.println("Le ha tocado un As.\nSeleccione 1. si quiere que valga 11 o cualquier otra tecla si no quiere cambiar el valor");
                char j = sc.next().charAt(0);
                switch (j) {
                    case '1' : mano[i] = 11; break;
                    default: break;
                }
            }
            i++;
        }
        return mano;
    }
    public static int[] repartirCartasMaquina(int[][] baraja, int[] mano) { // reparte las primeras dos cartas a la maquina y cambia el valor del As a 11
        int i = 0;
        Scanner sc = new Scanner (System.in);
        while (i<2) {
            int fila = (int) (Math.random() * (3-0))+1;
            int columna = (int) (Math.random() * (12-0))+1;
            mano[i] = baraja[fila][columna];
            baraja[fila][columna] = 0; // indica que ya esta cogida la carta
            if (mano[i] == 1) {
                mano[i] = 11; 
            }
            i++;
        }
        return mano;
    }
    public static int[] nuevaCarta(int[][] baraja, int[] mano, int i) { 
            Scanner sc = new Scanner(System.in);
            int fila = (int) (Math.random() * (3-0))+1;
            int columna = (int) (Math.random() * (12-0))+1;
            while (baraja[fila][columna] == 0) { // comprueba que la carta no este cogida
                fila = (int) (Math.random() * (3-0))+1;
                columna = (int) (Math.random() * (12-0))+1;
            }
            mano[i] = baraja[fila][columna];   
            baraja[fila][columna] = 0; // con un 0 indica que ya est� cogida
            if (mano[i] == 1) {
                System.out.println("Le ha tocado un As.\nSeleccione 1. si quiere que valga 11 o cualquier otra tecla si no quiere cambiar el valor");
                char j = sc.next().charAt(0);
                switch (j) {
                    case '1' : mano[i] = 11; break;
                    default: break;
                }
            }
            return mano;          
    }
    public static int[] nuevaCartaMaquina(int[][] baraja, int[] mano, int i) {
        Scanner sc = new Scanner(System.in);
        int fila = (int) (Math.random() * (3-0))+1;
        int columna = (int) (Math.random() * (12-0))+1;
        while (baraja[fila][columna] == 0) { // verifica que no este cogida y si es asi elige otra aleatoria
            fila = (int) (Math.random() * (3-0))+1;
            columna = (int) (Math.random() * (12-0))+1;
        }
        mano[i] = baraja[fila][columna];   
        baraja[fila][columna] = 0; // indica que ya esta cogida
        return mano;
    }          
    public static int[] ganador(int[][] baraja, int[] mano1, int [] mano2) {//la posicion 0 es la maquina y la 1 el jugador
        int jugador = sumaAs(baraja, mano1);
        int maquina = sumaAs(baraja, mano2);
        int[] res = new int[2];
        // analiza cada caso de ganador de partida
        if (((jugador < maquina) && (maquina <= 21)) || ((jugador > 21) && (maquina <= 21))) {
            System.out.println("Has perdido\n");
            verCartas(mano1);
            System.out.println("");
            verCartas(mano2);
            res[0] = 1;
            res[1] = 0;
            return res;
        } else if ((jugador > maquina) && (jugador <= 21) || ((maquina > 21) && (jugador <= 21))) {
            System.out.println("Has ganado\n");
            verCartas(mano1);
            System.out.println("");
            verCartas(mano2);
            res[0] = 0;
            res[1] = 1;
            return res;
        } else {
            if (mano1.length > mano2.length) {
                System.out.println("Has perdido\n");
                verCartas(mano1);
                System.out.println("");
                verCartas(mano2);
                res[0] = 1;
                res[1] = 0;
                return res;
            } else if (mano1.length < mano2.length) {
                System.out.println("Has ganado\n");
                verCartas(mano1);
                System.out.println("");
                verCartas(mano2);
                res[0] = 0;
                res[1] = 1;
                return res;
            } else if (mano1.length == mano2.length) {}
                System.out.println("No hay ganador\n");
                verCartas(mano1);
                System.out.println("");
                verCartas(mano2);
                res[0] = 0;
                res[1] = 0;
                return res;
        }
    }
  public static void mus()
  {
   int[] baraja ={4,4,4,4,4,4,4,0,0,4,4,4}; //La baraja al principio tenemos 4 cartas de cada tipo
   boolean volverApreguntar=true; //definimos un avariable que nos ayudar� con el descarte
   int[][] arrayAux={{0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0}}; //Este array nos ayudar� a actualizar la baraja
   Scanner teclado;
   boolean dificultad=dificultad(); //Vemos que dificultad quiere el usuario, 0 ser� Normal y 1 ser� Dificil
   int[] puntuacion=new int[2]; //La posicion 0 ser� la puntuacion del jugador y la 1 la del programa
   int[] cartasJugador=cartas(baraja); //Ahora debemos actualizar que cartas hay en la baraja
   baraja=actualizadorBaraja(baraja, cartasJugador);
   int[] cartasPrograma=cartas(baraja);
   baraja=actualizadorBaraja(baraja, cartasPrograma);
   int[][] puntuacionGrande=  {{0,0},{0}};
   int[][]  puntuacionChica=  {{0,0},{0}};
   int[][]  puntuacionPares=  {{0,0},{0}};
   int[][]  puntuacionJuego = {{0,0},{0}};
   System.out.print("Sus cartas son; | "+cartasJugador[0]+" | "+cartasJugador[1]+" | "+cartasJugador[2]+" | "+cartasJugador[3]+" | ");
   do { //utilizamos do while ya que queremos que se ejecute al menos una vez
   if(quererMusPrograma(dificultad,cartasPrograma)){
      System.out.println("El programa ha querido mus");
     if(quererMusJugador())
     {
      arrayAux=descartarseCartas(cartasJugador,baraja); //Esta funcion nos devuelva una matriz en la que la posici�n 0 est�n las cartas del jugador y en la 1 la baraja, la cual se actualiza seg�n el jugador se quita cartas
      cartasJugador=arrayAux[0]; //pasamos las cartas del jugador
      baraja=arrayAux[1]; //Actualizamos la baraja
      arrayAux=descartarseCartasPrograma(cartasPrograma,dificultad, baraja); //Hace lo mismo que descartarseCartas pero con las del programa
      cartasPrograma=arrayAux[0]; //pasamos las nuevas cartas del programa
      baraja=arrayAux[1]; //Actualizamos la baraja
     }
     else{
     System.out.println("Se empieza a hablar de grande");
     volverApreguntar=false; //Ya no hace falta volver a preguntar, se hace false para salir del bucle
     }
   }
   else{
   System.out.println("El programa no ha querido mus, se empieza a hablar de grande");//Se empieza a hablar de grande
   volverApreguntar=false;//Ya no hace falta volver a preguntar, se hace false para salir del bucle
   }
   }while(volverApreguntar);
    puntuacionGrande=grande(cartasJugador, cartasPrograma, dificultad); //Invocamos a las funciones y guardamos la puntuaci�n
  if(puntuacionGrande[1][0]!=1){
    puntuacionChica=chica(cartasJugador, cartasPrograma, dificultad);
  if(puntuacionChica[1][0]!=1){
    puntuacionPares=pares2(cartasJugador,cartasPrograma,dificultad);
  if(puntuacionPares[1][0]!=1){
  barraDeCarga();
    puntuacionJuego=juego2(cartasJugador,cartasPrograma,dificultad);
  if(puntuacionJuego[1][0]!=1){
  for(int i=0;i<2;i++)
   puntuacion[i]= puntuacionGrande[0][i]+puntuacionChica[0][i]+puntuacionPares[0][i]+puntuacionJuego[0][i];
  if(puntuacion[0]>puntuacion[1])
  {
   System.out.println("Felicidades usted ha ganado al programa con una puntuaci�n de "+puntuacion[0]);
   System.out.println("Las cartas del programa eran: " +" | "+cartasPrograma[0]+" | "+cartasPrograma[1]+" | "+cartasPrograma[2]+" | "+cartasPrograma[3]+" | ");
  }
  else if(puntuacion[0]<puntuacion[1])
  {
   System.out.println("El programa ha ganado, mejor suerte la pr�xima vez, usted tuvo una puntuaci�n de "+puntuacion[0]+ " y el programa una de "+puntuacion[1]); 
   System.out.println("Las cartas del programa eran: " +" | "+cartasPrograma[0]+" | "+cartasPrograma[1]+" | "+cartasPrograma[2]+" | "+cartasPrograma[3]+" | ");
  }
  else
  {
   System.out.println("Han empatado con una puntuacion de "+puntuacion[1]); 
   System.out.println("Las cartas del programa eran: " +" | "+cartasPrograma[0]+" | "+cartasPrograma[1]+" | "+cartasPrograma[2]+" | "+cartasPrograma[3]+" | "); 
  }
  System.out.println("Puntuaciones usuario Grande:"+puntuacionGrande[0][0]+" Chica: "+puntuacionChica[0][0]+ "  puntuacionPares: "+puntuacionPares[0][0]+" puntuacionJuego:"+puntuacionJuego[0][0]);
    System.out.println("Puntuaciones Programa Grande:"+puntuacionGrande[0][1]+" Chica: "+puntuacionChica[0][1]+ "  puntuacionPares: "+puntuacionPares[0][1]+" puntuacionJuego:"+puntuacionJuego[0][1]);
  }
  }
  }
  }
  else if(puntuacionGrande[1][0]==1 || puntuacionChica[1][0]==1 || puntuacionPares[1][0]==1 || puntuacionJuego[1][0]==1)
  {
    System.out.println("Como ha ganado el ordago se le sumar�n los 4 puntos de la partida");    
    puntuacion[0]=4;
  }
   try {
            FileReader reader = new FileReader("puntuacionMus.txt");
            BufferedReader reader2 = new BufferedReader(reader);
            int pJ = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario
            int pM = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
            pJ += puntuacion[0];
            pM += puntuacion[1];
            FileWriter fw = new FileWriter("puntuacionMus.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(pJ); 
            pw.println(pM);
            reader2.close();
            bw.close();
        } catch (Exception f) {
            System.out.println("error");
        } 
  }
  public static int[][] grande(int[] cartasJugador, int [] cartasPrograma, boolean dificultad) //Lo definimos como int[] ya que queremos que nos devuelva la puntuaci�n del programa y del jugador, la posici�n 0 ser� para el jugador y 1 para el programa
 {
    int[][] resultado={{0,0},{0}};
   if(!dificultad) //Si la dificultad est� en normal el programa envida o pasa aleatoriamente 
   {
    if(randomizador()==0){  //El programa envida
      System.out.println("El programa envida a grande, �pasas, quieres o desea hacer �rdago?");
      resultado=discutirGrande(cartasJugador,cartasPrograma,0,dificultad);   
    }
     else{ //El programa pasa 
      System.out.println("El programa pasa, �pasas,envidas o desea hacer �rdago?");
      resultado=discutirGrande(cartasJugador,cartasPrograma,1, dificultad);
    }
   }
   else{ //Si el programa tiene buenas cartas envidar�, si no pasar�
    if(sumaCartas(cartasPrograma)>30){
     System.out.println("El programa envida a grande, �pasas, quieres o desea hacer �rdago?");
     resultado=discutirGrande(cartasJugador,cartasPrograma,0,dificultad);   
    }
    else{
      System.out.println("El programa pasa, �pasas,envidas o desea hacer �rdago?");
      resultado=discutirGrande(cartasJugador,cartasPrograma,1, dificultad);
    }
   }
   return resultado;
 }
 public static int[][] discutirGrande (int[] cartasJugador, int[] cartasPrograma, int n, boolean dificultad) //Esta n nos permitir� diferenciar entre si el programa ha envidado o pasado
 {
   int[][] resultado={{0,0},{0}};//la posici�n 0 ser� para el jugador y 1 para el programa
   Scanner teclado=new Scanner(System.in);
   String respuesta=teclado.nextLine();
   if(respuesta.equalsIgnoreCase("Paso")&&n==1){ //Programamos que pasa si el usuario "pasa" y el programa pasa
       System.out.println("Ambos habeis pasado, se empieza a hablar de chica");
         if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
         else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0][0]+=1;  
     }
   else if (respuesta.equalsIgnoreCase("Paso")&&n==0){ //Si el programa envida y el usuario pasa se lleva el punto el programa
       resultado[0][1]+=1; //El programa se lleva el punto de envite 
       if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Vemos quien se lleva el punto de grande
         resultado[0][1]+=1;
       else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma))
         resultado[0][0]+=1;   
     }
   if(respuesta.equalsIgnoreCase("Envido") && n==1 ){ //n deber� ser 1 ya que solo puede envidar si el programa pasa
     if(!dificultad){ //Si estamos en facil ser� random
       if(randomizador()==0){
        System.out.println("El programa las quiere");
         if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
         else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0][0]+=1;  
       }
       else {
        System.out.println("El programa no las quiere, se pasa a hablar de chica"); //Si no las quiere la �nica opci�n es que pase
        resultado[0][0]+=1;
        if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
        else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0][0]+=1;  
       }
     }
     else //Si estamos en dificil tendr� en cuenta la suma de sus cartas
     {
       if(sumaCartas(cartasPrograma)>30){ //Si sus cartas son buenas para grandes, el programa querra el envite
         System.out.println("El programa las quiere");
         if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
         else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0][0]+=1;   
       }
       else{
         System.out.println("El programa no las quiere");
         resultado[0][0]+=1;
         if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Vemos quien se lleva el punto de grande
         resultado[0][1]+=1;
         else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) 
         resultado[0][0]+=1;  
       }
      }
     } //Acaba la opci�n de envidar
    if(respuesta.equalsIgnoreCase("Quiero")&&n==0){ //n debe ser 0 ya que el usuario solo puede querer si el programa envita
     if(!dificultad){
        System.out.println("El programa ha envidado y el usuario las quiere, se pasa a habalr de chica");//Programamos que hace si est� en normal
       if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
       else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0][0]+=1;   
     }
     else{ //Programamos que hace si la dificultad es dificil, en este caso como ha envitado y el jugador ha querido, no debe hacer nada
       if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
       else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0][0]+=1;   
     }
    }
    if(respuesta.equalsIgnoreCase("Ordago")){ //En cualquier momento se puede dar Ordago
      if(ordago(cartasPrograma, cartasJugador, dificultad,1)){ //Si el jugador ganase el Ordago se acaba la partida
       System.out.println("ENHORABUENA USTED HA GANADO");
       resultado[1][0]=1;
      }
      else
      {
       if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
       else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0][0]+=1;   
        
      }
    }
    System.out.println("Grande ha terminado, se pasa a hablar de chica, se le dir� su puntuaci�n de grande al terminar la partida, si ha querido ordago saldr� al menu");
    return resultado;   
  }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Parte del programa para chica
 public static int[][] chica(int[] cartasJugador, int [] cartasPrograma, boolean dificultad) //Lo definimos como int[] ya que queremos que nos devuelva la puntuaci�n del programa y del jugador, la posici�n 0 ser� para el jugador y 1 para el programa
 {
   int[][] resultado={{0,0},{0}};
   if(!dificultad) //Si la dificultad est� en normal el programa envida o pasa aleatoriamente 
   {
    if(randomizador()==0){  //El programa envida
      System.out.println("El programa envida a chica, �pasas, quieres o desea hacer �rdago?");
      resultado=discutirChica(cartasJugador,cartasPrograma,0,dificultad);   
    }
     else{ //El programa pasa 
      System.out.println("El programa pasa, �pasas,envidas o desea hacer �rdago?");
      resultado=discutirChica(cartasJugador,cartasPrograma,1, dificultad);
    }
   }
   else{ //Si el programa tiene buenas cartas envidar�, si no pasar�
    if(sumaCartas(cartasPrograma)<15){
     System.out.println("El programa envida a chica, �pasas, quieres o desea hacer �rdago?"); 
     resultado=discutirChica(cartasJugador,cartasPrograma,0,dificultad);   
    }
    else{
      System.out.println("El programa pasa, �pasas,envidas o desea hacer �rdago?");
      resultado=discutirChica(cartasJugador,cartasPrograma,1, dificultad);
    }
   }
   return resultado;
 }
 public static int[][] discutirChica (int[] cartasJugador, int[] cartasPrograma, int n, boolean dificultad) //Esta n nos permitir� diferenciar entre si el programa ha envidado o pasado
 {
   int[][] resultado={{0,0},{0}};//la posici�n 0 ser� para el jugador y 1 para el programa
   Scanner teclado=new Scanner(System.in);
   String respuesta=teclado.nextLine();
   if(respuesta.equalsIgnoreCase("Paso")&&n==1){ //Programamos que pasa si el usuario "pasa" y el programa pasa
       System.out.println("Ambos habeis pasado, se empieza a hablar de pares");
         if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
         else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0][0]+=1;  
     }
   else if (respuesta.equalsIgnoreCase("Paso")&&n==0){ //Si el programa envida y el usuario pasa se lleva el punto el programa
       resultado[0][1]+=1; //El programa se lleva el punto de envite 
       if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Vemos quien se lleva el punto de grande
         resultado[0][1]+=1;
       else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma))
         resultado[0][0]+=1;   
     }
   if(respuesta.equalsIgnoreCase("Envido") && n==1 ){ //n deber� ser 1 ya que solo puede envidar si el programa pasa
     if(!dificultad){ //Si estamos en facil ser� random
       if(randomizador()==0){
        System.out.println("El programa las quiere");
         if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Vemos quien se lleva el punto de chica
         resultado[0][1]+=1;
         else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) 
         resultado[0][0]+=1;  
       }
       else {
        System.out.println("El programa pasa"); //Si no las quiere la �nica opci�n es que pase
        resultado[0][0]+=1;
        if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Se da la puntuaci�n de chica
         resultado[0][1]+=1;
        else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) 
         resultado[0][0]+=1;  
       }
     }
     else //Si estamos en dificil tendr� en cuenta la suma de sus cartas
     {
       if(sumaCartas(cartasPrograma)<15){ //Si sus cartas son buenas para chica, el programa querra el envite
         System.out.println("El programa las quiere");
         if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de chica
         resultado[0][1]+=1;
         else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0][0]+=1;   
       }
       else{
         System.out.println("El programa no las quiere");
         resultado[0][0]+=1;   
         if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Vemos quien se lleva el punto de chica
         resultado[0][1]+=1;
         else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) 
         resultado[0][0]+=1;   
       }
      }
     } //Acaba la opci�n de envidar
    if(respuesta.equalsIgnoreCase("Quiero")&&n==0){ //n debe ser 0 ya que el usuario solo puede querer si el programa envita
     if(!dificultad){ //Programamos que hace si est� en normal
       if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de chica
         resultado[0][1]+=1;
       else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0][0]+=1;   
     }
     else{ //Programamos que hace si la dificultad es dificil, en este caso como ha envitado y el jugador ha querido, no debe hacer nada
       if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
       else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0][0]+=1;   
     }
    }
    if(respuesta.equalsIgnoreCase("Ordago")){ //En cualquier momento se puede dar Ordago
      if(ordago(cartasPrograma, cartasJugador, dificultad,2)){ //Si el jugador ganase el Ordago se acaba la partida
       System.out.println("ENHORABUENA USTED HA GANADO");
       resultado[1][0]=1;
      }
      else
      {
        if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevar� el punto de grande
         resultado[0][1]+=1;
       else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0][0]+=1;
      }
    }
     System.out.println("Chica ha terminado, se pasa a hablar de pares, se le dir� su puntuaci�n de chica al terminar la partida, si ha querido ordago saldr� al men�");
     return resultado;  
 }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Parte del programa para Pares
 public static int[][] pares2 (int[] cartasJugador, int[] cartasPrograma, boolean dificultad)
 {
   System.out.println("Sus cartas son; | "+cartasJugador[0]+" | "+cartasJugador[1]+" | "+cartasJugador[2]+" | "+cartasJugador[3]+" | ");
   int[][] resultado={{0,0},{0}};
   int k=0; //Esto nos permitir� distinguir entre si el usuario puede envidar o querer
   Scanner teclado=new Scanner(System.in);
   String respuesta="";
   if(pares(cartasPrograma)>1)
     System.out.println("El programa tiene pares"); //Se debe decir si el programa tiene o no tiene pares, como en el mus
   else
     System.out.println("El programa no tiene pares"); //Si el programa no tiene pares pueden pasar dos cosas
   if(pares(cartasPrograma)==1&&pares(cartasJugador)==1) //Que nadie tenga pares y ya no se hace nada
     System.out.println("Nadie tiene pares, se pasa a hablar de juego");
   if(pares(cartasPrograma)==1&&pares(cartasJugador)>1){ //Que el jugador tenga pares y que por ende gane pares
     System.out.println("Usted tiene pares pero el programa no, se lleva el punto de pares");
     resultado[0][0]=1;
   }
   if(pares(cartasPrograma)>1&&pares(cartasJugador)==1) //Si el programa tiene pero el jugeador no gana el programa
   {
    System.out.println("Usted no tiene pares pero el programa s�, el programa se lleva el punto de pares"); 
    resultado[0][1]=1;
   }
   if(pares(cartasPrograma)>1&&pares(cartasJugador)>1) //Si ambos tienen pares se discute que pasa
   {
    if(!dificultad) //En caso de que sea normal
    {
     if(randomizador()==0)  //randomizamos si el programa envida o pasa
     {
       System.out.println("El programa envida, �quiere, pasa u �rdago?");
       respuesta=teclado.nextLine();
     }
     else 
     {
      System.out.println("El programa pasa,�envida, pasa u �rdago?");
      respuesta=teclado.nextLine();
       k=2;
     }
    }
    else //En caso de que sea dificil
    {
     if(pares(cartasPrograma)>2) 
     {
      System.out.println("El programa envida,�quiere, pasa u �rdago?");   //Si el programa tiene medias o m�s envidar� 
      respuesta=teclado.nextLine();
     }
      else
      {
       System.out.println("El programa pasa, envida, pasa u �rdago?"); //Si no tiene buenos pares pasa
       respuesta=teclado.nextLine();
       k=2; 
      }
    }
   }
   if(respuesta.equalsIgnoreCase("Paso")&& k!=2){ //El programa envida y el usuario pasa
     resultado[0]=discutirPares(cartasJugador, cartasPrograma);
     resultado[0][1]+=1; 
   }
   else if(respuesta.equalsIgnoreCase("Paso")&& k==2) //El programa pasa y el usuario pasa
       resultado[0]=discutirPares(cartasJugador, cartasPrograma);
   if(respuesta.equalsIgnoreCase("Envido")) //Envidar
   {
     if(!dificultad) //Programamos que pasa si la dificultad es facil
     {
       if(randomizador()==0)
       {
        System.out.println("El programa las quiere");
        resultado[0]=discutirPares(cartasJugador, cartasPrograma); //Se ve quien gana
       }
       else
       {
        System.out.println("El programa pasa");
        resultado[0]=discutirPares(cartasJugador, cartasPrograma);
        resultado[0][0]+=1; //Sumamos un punto ya que el jugador ha envidado y el programa no ha querido 
       }
     }
     else
     {
       if(pares(cartasPrograma)>2)
       {
        System.out.println("El programa las quiere");
        resultado[0]=discutirPares(cartasJugador, cartasPrograma); //Se ve quien gana 
       }
       else
       {
        System.out.println("El programa pasa");
        resultado[0]=discutirPares(cartasJugador, cartasPrograma);
        resultado[0][0]+=1; //Sumamos un punto ya que el jugador ha envidado y el programa no ha querido   
       }
     }
   }
   if(respuesta.equalsIgnoreCase("Quiero")&& k==1) //Querer
   {
    resultado[0]=discutirPares(cartasJugador, cartasPrograma); //Si el programa envida y el usuario las quiere, se ve quien gana
   }
   if(respuesta.equalsIgnoreCase("Ordago")) //Ordago
   {
     if(ordago(cartasPrograma, cartasJugador, dificultad,3)==true){ //Si el jugador ganase el Ordago se acaba la partida
       System.out.println("ENHORABUENA USTED HA GANADO");
       resultado[1][0]=1;
     }
     else
     {
      resultado[0]=discutirPares(cartasJugador, cartasPrograma); 
     }
     System.out.println("Pares ha terminado, se pasa a hablar de juego, se le dir� su puntuaci�n de pares al terminar la partida, si ha querido �rdago saldr� al men�");
   }
   return resultado;
 }
 public static int[] discutirPares (int[] cartasJugador, int[] cartasPrograma) //Esta funcion nos devuelve quien ganar�a 
 {
  int[] resultado= new int[2];
  if(pares(cartasJugador)>pares(cartasPrograma)) //Si los pares del jugador son mejores que los del programa gana el jugador
     resultado[0]+=1;
   else if (pares(cartasJugador)<pares(cartasPrograma)) //Si los pares del programa son mejores que los del jugador gana el programa
     resultado[1]+=1;
   else if(pares(cartasJugador)==pares(cartasPrograma)) //Si tienen los mismos pares vemos cual es su suma 
   {
    if(sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si la suma del jugador es mayor 
      resultado[0]+=1;
    else if(sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si la suma del Programa es mayor
      resultado[1]+=1;
   }
   resultado[0]+=pares(cartasJugador)-1; //Sumamos a cada uno los puntos que les corresponde por su tipo de pares
   resultado[1]+=pares(cartasPrograma)-1;
   return resultado; 
 }
 
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Parte del programa para Ordago
 public static boolean ordago(int[] cartasPrograma, int[] cartasJugador, boolean dificultad, int parteDelJuego) //Como se puede hacer ordago durante toda la partida, hacemos una funcion para ello 
 {
   boolean resultado=false; 
   if(!dificultad) //Si la dificultad es facil ser� random
   {
    if(randomizador()==0)
    {
      System.out.println("El programa ha querido el ordago");
      resultado=true;
    }
    else
      System.out.println("El programa no ha querido ordago");
   }
   else //Si la dificultad est� en dificil
    {
     if(sumaCartas(cartasPrograma)>30 && parteDelJuego==1) //Solo querra el ordago en grande si tiene una buena suma
     {
      System.out.println("El programa ha querido el ordago");
      resultado= switchOrdago(cartasPrograma, cartasJugador, 1);
    }
     else if(sumaCartas(cartasPrograma)<10 && parteDelJuego==2) //Solo querra el ordago en chica si tiene una buena suma
     {
      System.out.println("El programa ha querido el ordago");
      resultado= switchOrdago(cartasPrograma, cartasJugador, 2);
       
     }
     else if(pares(cartasPrograma)==4 && parteDelJuego==3) //Solo querra el ordago en pares si tiene 4 pares
     {
      System.out.println("El programa ha querido el ordago");
      resultado= switchOrdago(cartasPrograma, cartasJugador, 3);
       
     }
     else if(sumaCartas(cartasPrograma)==31 && parteDelJuego==4) //Solo querra ordago en el juego si tiene el mejor juego
     {
      System.out.println("El programa ha querido el ordago");
      resultado= switchOrdago(cartasPrograma, cartasJugador, 4) ;
     }
     else 
       System.out.println("El programa no ha querido ordago");
    }
   return resultado;
 }
 public static boolean switchOrdago (int[] cartasPrograma, int[] cartasJugador, int parteDelJuego) //Esta funcion dice si el jugador ganar�a el ordago
 {
    boolean resultado=false; 
    switch (parteDelJuego) //esta parte distinguir� en que parte del juego nos encontramos
   {
     case 1: //Grande
       if(sumaCartas(cartasJugador)>sumaCartas(cartasPrograma))
         resultado=true;
       break;
     case 2: //Chica
       if(sumaCartas(cartasJugador)<sumaCartas(cartasPrograma))
         resultado=true;
       break;
     case 3: //Pares
        if(pares(cartasJugador)>pares(cartasPrograma))
         resultado=true;
       break;
     case 4: //Juego
       if(juego(cartasJugador,cartasPrograma))
         resultado=true;
       break;
   }
   return resultado;
 }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Parte del programa para juego
 public static int[][] juego2 (int[] cartasJugador, int[] cartasPrograma,boolean dificultad)
 {
   Scanner teclado = new Scanner(System.in);
   String respuesta;
   int[][] resultado={{0,0},{0}};
   int k=0;
   if(sumaCartas(cartasJugador)>30) //Si el jugador tiene juego se debe decir
     System.out.println("Usted tiene juego");
   else
     System.out.println("Usted no tiene juego"); //Si no lo tiene tambi�n
   if(sumaCartas(cartasPrograma)<31){ //Si el programa no tiene juego se dice
     System.out.println("El programa no tiene juego");
     if(sumaCartas(cartasJugador)<31) //Si ninguno tiene juego se juega a punto, gana el que tenga la mayor suma
     {
      System.out.println("Se juega a juego al punto") ; 
        if(sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)){//Gana el jugador
        System.out.println("Usted gana el juego al punto");
       resultado[0][0]=1;   
      }
      else if(sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) { //Gana el programa
        System.out.println("El programa gana el juego al punto");
        resultado[0][1]=1;   
      }
     }
   }
   if(sumaCartas(cartasJugador)>30 && sumaCartas(cartasPrograma)<31)
   {
     resultado[0][0]=1;   
   }
   if(sumaCartas(cartasJugador)<31 && sumaCartas(cartasPrograma)>30)
   {
     resultado[0][1]=1;   
   }
   if(sumaCartas(cartasPrograma)>30 && sumaCartas(cartasJugador)>30) //Si ambos tienen juego se discute que pasa
   {
    System.out.println("Ambos tienen juego"); 
     if(!dificultad) //Si estamos en normal 
    {
      if(randomizador()==0) //Envida de forma aleatoria 
      {
       System.out.println("El programa envida a Juego,�las quiere, pasa u ordago?");
       respuesta= teclado.nextLine();
       k=1; //Nos sirve para diferenciar entre si el programa envida o pasa
      }
      System.out.println("El programa pasa �envida, pasa u ordago?");
       respuesta= teclado.nextLine();
    }
     else //Si estamos en dificil
     {
       if(sumaCartas(cartasPrograma)==31 || sumaCartas(cartasPrograma)==40 ||sumaCartas(cartasPrograma)==32 ) //Solo envida si tiene buenos juegos
       {
       System.out.println("El programa envida a Juego,�las quiere, pasa u ordago?");
       respuesta= teclado.nextLine();
       k=1; //Nos sirve para diferenciar entre si el programa envida o pasa
       }
       else
       {
        System.out.println("El programa pasa �envida, pasa u ordago?");
        respuesta= teclado.nextLine(); 
       }
     }
     if(respuesta.equalsIgnoreCase("Paso")&& k==1) //Si el jugador pasa y el programa ha envidado
     {
      System.out.println("El programa se lleva un punto ya que invid� y usted no quiso") ; //El programa se lleva el punto
      resultado[0][1]=1; 
     }
     else if(respuesta.equalsIgnoreCase("Paso")&& k==0) //Si ambos pasan 
      System.out.println("Ambos han pasado, se pasa a ver la puntuaci�n");
     else if(respuesta.equalsIgnoreCase("Quiero")&& k==1) //Si el programa envida y el jugador quiere, pasamos a la puntuaci�n para ver quien gana juego
      System.out.println("Se pasa a hablar de la puntuaci�n");
     else if(respuesta.equalsIgnoreCase("Invido")&&k==0) //Si el programa pasa y el jugador envida el programa decide si quiere o no 
     {
      if(!dificultad) //En normal 
      {
       if(randomizador()==0){ //Ser� aleatorio 
        System.out.println("El programa las quiere");
       } 
       else{
         System.out.println("El programa pasa");
         resultado[0][0]=1;
       }
      }
      else //En dificil
      {
       if(sumaCartas(cartasPrograma)==31 || sumaCartas(cartasPrograma)==40 ||sumaCartas(cartasPrograma)==32 )// Solo las querr� si tiene buenos juegos
       {
        System.out.println("El programa las quiere");
        //Su puntuaci�n ser� discutida al hablar de la puntuaci�n, es equivalente a que si el programa envida y el usuario quiere 
       }
       else
       {
        System.out.println("El programa pasa");
        resultado[0][0]+=1; //Se lleva un punto el jugador ya que envida
       } 
      }
     }
     else if(respuesta.equalsIgnoreCase("Ordago")){
      if(ordago(cartasPrograma, cartasJugador, dificultad,4)){ //Si el jugador ganase el Ordago se acaba la partida
       System.out.println("ENHORABUENA USTED HA GANADO");
       resultado[1][0]=1;
     }
     }
     if(juego(cartasJugador, cartasPrograma))  //Sumamos el punto de juego a quien tenga el mejor juego
       resultado[0][0]+=1;
     else
       resultado[0][1]+=1;
   }
       return resultado;
 }
 public static boolean juego(int[] cartasJugador, int[] cartasPrograma) //Esta funcion dice si las cartas del jugador ganar�an a las cartas del programa en Juego
 {
   boolean resultado=false;
   if(sumaCartas(cartasJugador)==31 && sumaCartas(cartasPrograma)!=31) //Si el jugador tiene 31 y el programa no tiene, gana el jugador
     resultado=true;
   else if(sumaCartas(cartasJugador)>31 && sumaCartas(cartasPrograma)<31) //Si el jugador no tiene 31 pero el programa no tiene juego, gana el jugador
     resultado=true;
   else if(sumaCartas(cartasJugador)>31 && sumaCartas(cartasPrograma)>31) //Miramos que pasa si ambos tienen juego
   {
     if(sumaCartas(cartasJugador)==32 && sumaCartas(cartasPrograma)!=32) //El siguiente mejor juego es 32, si el jugador tiene 32 y el programa no, el jugador gana
       resultado=true;
     else if(sumaCartas(cartasJugador)==40 && sumaCartas(cartasPrograma)!=40) //El siguiente mejor juego es 40, si el jugador tiene 40 y el programa no, el jugador gana
       resultado=true;
     else if(sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)&& sumaCartas(cartasPrograma)!=32 && sumaCartas(cartasPrograma)!=40 ) //Los siguientes juegos van de manera descendente, entonces ganar� quien tenga la mayor suma
       resultado=true;
   }
   else if(sumaCartas(cartasJugador)<31 && sumaCartas(cartasPrograma)<31) //Si ninguno tiene juego se juega a punto, el que tenga la mayor suma gana
   {
     if(sumaCartas(cartasJugador)>sumaCartas(cartasPrograma))
       resultado=true;
   }                                                                  //Su tuviesen la misma suma, no gana ninguno
   return resultado;
 }
 
 
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Funciones varias
 public static int pares(int[] cartas) //Esta funcion nos devolver� 1 si no tenemos pares, 2 si tenemos pares, 3 si tenemos medias, 4 si tenemos duples
 {
   //Si no se tiene nada devolver� 1 
   //Si se tiene pares se devolver� 2 
   //Si se tiene medias se devolver� 3
   //Si se tiene duples se devolver� 4
   int resultado=1;
   boolean noSeHaVistoAntes=true;
   int[] cartasAux={cartas[0],cartas[1],cartas[2],cartas[3]}; //Creamos una baraja auxiliar ya que 3 y 12 son iguales y 1 y 2 tambi�n
     for(int i=0;i<4;i++)
     {
      if(cartas[i]==3) 
        cartasAux[i]=12;
      if(cartas[i]==2)
        cartasAux[i]=1;
     }
   for(int i=0;i<4;i++) 
   {
     if(i!=0){ //si i no es 0 har� esto
       for(int k=i-1;k>-1;k--)
       {
         if(cartasAux[i]==cartasAux[k]){ //Debemos tener en cuenta que si la carta que estamos mirando ya ha sido mirada antes, no debemos volverla a comprobar
         noSeHaVistoAntes=false;
         }
       }
     for(int j=1+i;j<4&&noSeHaVistoAntes;j++) //Si no se ha visto antes mira en sus posiciones siguientes
     {
       if(cartasAux[i]==cartasAux[j]){
       resultado+=1;
       }
     }
     
     }
     else //Si i es 0 mira si est� m�s veces en todas sus posiciones siguientes
       for(int j=1;j<4;j++)
     {
       if(cartasAux[i]==cartasAux[j])
       resultado+=1;
    }
    noSeHaVistoAntes=true; 
   }
   if(resultado==3) //en el mus no solo{1,1,1,1} es duples si no que {1,1,0,0} tambi�n, el anterior algoritmo reconoce {1,1,0,0} como 3, pues suma un 1 de los dos 1 y un 1 de los dos 0, en este caso debemos sumar otro 1 
   {
     if((cartasAux[0]!=cartasAux[1] && cartasAux[0]!=cartasAux[2]) || (cartasAux[0]!=cartasAux[1] && cartasAux[0]!=cartasAux[3]) || (cartasAux[0]!=cartasAux[2] && cartasAux[0]!=cartasAux[3])) 
       resultado+=1; //Si la primera carta es distinta a la primera y a la segunda, o distinta a la segunda y la tecera o distinta a la primera y la tercera, nos encontramos en el caso que nos interesa
   }
   return resultado;
 }
 public static boolean dificultad() //Funcion que pregunta la dificultad
 {
  Scanner teclado = new Scanner(System.in);
  boolean resultado;
  System.out.println("Elija la dificultad: Normal/Dificil"); //Preguntamos que dificultad quiere
  String dif=teclado.nextLine();
  if(dif.equalsIgnoreCase("Normal"))
    resultado=false;  //Si dice normal, asignamos el valor 0 
  else if(dif.equalsIgnoreCase("Dificil"))
    resultado=true; //Si quiere dificil, asignamos el valor 1
    else 
    resultado=dificultad(); //Si no ha dicho ni Normal ni Dificil, volvemos a llamar a la funci�n para preguntar de nuevo
  return resultado;
 }
 public static int[] cartas(int[] baraja) //Generador aleatorio de un array de cuatro posiciones con las cartas
 {
   int[] cartas= new int[4];
   for (int i=0;i<4;i++){
     int j=(int) (Math.random() * (13 -1)) + 1;
     while((j==8 || j==9) ) { //Si salen los valores 8 o 9, lo volvemos a randomizar hasta que j no sea ni 8 ni 9
       j=(int) (Math.random() * (13 -1)) + 1;
     }
      while(baraja[j-1]<1){
       j=(int) (Math.random() * (13 -1)) + 1; 
       while((j==8 || j==9) ){
         j=(int) (Math.random() * (13 -1)) + 1;
        }
       }
     baraja[j-1]-=1;
     cartas[i]=j;
   }
   return cartas;
  }
 public static boolean quererMusPrograma(boolean dificultad,int[] cartasPrograma) //Funcion que decide si el programa quiere o no quiere mus dependiendo de la dificultad
 {
   boolean quererMus;
   if(!dificultad){ //En esta parte el programa da o no da mus de manera aleatoria, ya que la dificultad es normal
     if(randomizador()==0)
       quererMus=true; 
     else
       quererMus=false;
   }
     else //Si la dificultad es dificil
     {
      if(pares(cartasPrograma)>2==true||sumaCartas(cartasPrograma)>35|| sumaCartas(cartasPrograma)<15 || sumaCartas(cartasPrograma)==31) //Vemos si tenemos Pares,Grande,Chica o Juego
       quererMus=false; //Si tiene buenas cartas no querra mus 
      else
       quererMus=true; //Si tiene malas cartas querra mus
     }
   return quererMus;
 }
 public static int sumaCartas(int[] cartas) //Esta funcion sumara las cartas
 {
   int k;
   int resultado=0;
   for(int i=0;i<4;i++){
     if(cartas[i]==11 || cartas[i]==12 || cartas[i]==3) //Si las cartas son figuras valen 10 
       k=10;
     else if (cartas[i]==2) //los doses valen como ases
       k=1;
     else
       k=cartas[i];
    resultado+=k;
   }
   return resultado;
 }
 public static boolean quererMusJugador() //Preguntamos si el jugador quiere mus 
 {
   System.out.println("�Quieres Mus?");
   boolean resultado;
   Scanner teclado=new Scanner (System.in);
   String respuesta=teclado.nextLine();
   if(respuesta.equalsIgnoreCase("Si"))
     resultado=true;
   else if(respuesta.equalsIgnoreCase("No"))
     resultado=false;
   else //Si no ha dicho ni si ni no, le volvemos a preguntar
       resultado=quererMusJugador();
   return resultado;
 }
 public static int[][] descartarseCartas(int[] cartasJugador, int[] baraja) //Esta funcion permite al jugador descartarse las cartas que quiera
 {            //Creamos que tenga dos arrays de 4 posiciones ya que debemos actualizar la baraja cada vez que se quita una carta, la baraja ser� la posici�n [1] y las cartas del jugador la [0]
  int[][] resultado= new int[2][4];
  resultado [0]=cartasJugador;
  resultado[1]=baraja;
  Scanner teclado=new Scanner (System.in);
  System.out.println("Carta 1: "+cartasJugador[0]+" Carta 2: "+ cartasJugador[1]+" Carta 3: "+cartasJugador[2]+" Carta 4: "+ cartasJugador[3]);
  System.out.println("�Cuantas cartas se quiere descartar?"); //Preguntamos cuantas cartas se va a querer descartar para poder reiterar el algoritmo de descarte esas veces
  int cuantasCartas=teclado.nextInt();
  if(cuantasCartas<5 && cuantasCartas>0){ //Si introduce un numero valido se ejecuta el for 
  for(int i=0;i<cuantasCartas;i++)
  {
   System.out.println("�Que carta se quiere descartar?") ; 
   int cartaX=teclado.nextInt();
   int cartaSustituta=nuevaCarta(resultado[1]);
   resultado[0][cartaX-1]=cartaSustituta; //Restamos 1 ya que el usuario responder� el lenguje natural, su primera carta es nuestra carta 0
   resultado[1][cartaSustituta-1]-=1; //Quitamos la carta dada a la baraja
  }}
  else{ //Si introduce un numero no valido se le vuelve a preguntar
    System.out.println("Introduzca un numero v�lido");
    descartarseCartas(cartasJugador, baraja);}
  System.out.println("Carta 1: "+cartasJugador[0]+" Carta 2: "+ cartasJugador[1]+" Carta 3: "+cartasJugador[2]+" Carta 4: "+ cartasJugador[3]);
  return resultado;
 }
 public static int randomizador() //dar� un valor aleatorio entre 0 y 1 
 {
   return (int)(Math.random() * (2 -0)) + 0;
 }
 public static int nuevaCarta(int[] baraja) //Esta funcion nos dara una nueva carta 
 {
  int resultado=(int) (Math.random() * (13 -1)) + 1;
     while(resultado==8 || resultado==9) //Si salen los valores 8 o 9, lo volvemos a randomizar hasta que resultado no sea ni 8 ni 9
       resultado=(int) (Math.random() * (13 -1)) + 1;
     if(baraja[resultado-1]<1){
       do
       {
        resultado=(int) (Math.random() * (13 -1)) + 1;
       while(resultado==8 || resultado==9) //Si salen los valores 8 o 9, lo volvemos a randomizar hasta que resultado no sea ni 8 ni 9
       resultado=(int) (Math.random() * (13 -1)) + 1; 
       }while(baraja[resultado-1]<1);
     }
  return resultado;  
 }
 public static int[] actualizadorBaraja(int[] baraja, int[] cartas) //Esta funcion nos quita de la baraja las cartas que le pasemos 
 {
   int[] resultado= baraja;
   for(int i=0;i<12;i++) {
    for(int k=0;k<4;k++){
     if(baraja[i]==cartas[k])
       resultado[i]-=1;
    }
   }
   return resultado;
 }
 public static int[][] descartarseCartasPrograma(int[] cartasPrograma,boolean dificultad, int[] baraja)
 {
   int[][] resultado= new int[2][4];
   int cartaAux;
   resultado[0]=cartasPrograma;
   resultado[1]=baraja;
   if(!dificultad){ //Si estamos en facil el descarte ser� aleatorio y se descarta todas
     resultado[0]=cartas(baraja);
     resultado[1]=actualizadorBaraja(resultado[1],resultado[0]);
   }
   else //Si la dificultad es dificil no se quitar� figuras ni si tienes duples
   {
     for(int i=0;i<4;i++){
       if(cartasPrograma[i]!= 10 && cartasPrograma[i]!= 11 &&cartasPrograma[i]!= 12 && pares(cartasPrograma)!=4){
     cartaAux=nuevaCarta(baraja);
     resultado[0][i]=cartaAux; //Le damos una nueva carta
     resultado[1][cartaAux-1]-=1; //La quitamos de la baraja
     }
   }
 }
  return resultado;
}
}