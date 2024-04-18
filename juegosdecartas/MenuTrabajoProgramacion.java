import java.util.Scanner;
//_______________________________________________________________//Menu Principal
public class MenuTrabajoProgramacion {
  public static void main (String[]args){
    inicializarMenu();
  }
//_________________________________________________________________________________________________Funcion de inicialización para simplificar el main -Sanz
  public static void inicializarMenu() {
    barraDeCarga();
    String usuario = iniciarSesion();
    barraDeCarga();

    int controlFunciones = 0; // variable que es modificada en caso de que miniopcion valga distinto de cero abriendo otro menu.
    while (controlFunciones==0) {  // si esta variable es cero me devuelve al menu principal
      controlFunciones = elegirSubmenu(menuPrincipalConEleccion(usuario));
    }                                                                                                                           //A partir de aqu� ya comienza el programa de los juegos y del ranking
    System.out.print("comienzoSecciones");//da error... arreglarlo plox Att.Gabo
  }
//_________________________________________________________________________________________________Funciones Auxiliares
  public static String iniciarSesion(){  // te pide el nombre con mensajitos reflama
    System.out.println("Bienvenido nuevo jugador, con que nombre quieres registrarte? Ten en cuenta que este será tu nombre en el ranking");
    Scanner leer = new Scanner (System.in);
    String nombre = leer.nextLine();
    System.out.print("Ha quedado registrado como: "); System.err.print(nombre); System.out.println(". Disfrute su sesión.");
    return nombre;
  }
  
//_________________________________________________________________________________________________Menu
    public static int menuPrincipalConEleccion (String usuario){ // devuelve eleccion
  int opcion = 0;
  Scanner leer = new Scanner (System.in);
  while(opcion<1){
    System.out.print("Introduzca el número de la opción del menú a la que desea acceder, "); System.err.print(usuario); System.out.println(".");
    System.out.println("1. Jugar al mus");
    System.out.println("2. Jugar al blackjack");
    System.out.println("3. Acceder al sistema de ranking");
    opcion = leer.nextInt();
    }
  return opcion;
  }
  
    public static int elegirSubmenu(int n){ // coge la elección de antes y busca el submenu correspondiente.
      int opcionFinal=0;
          switch(n){
          case 1: opcionFinal = subMenuMus(); break; // opcion final tendra un valor u otro dependiendo de lo que elijas
          case 2: opcionFinal = subMenuBlackJack(); break;
          case 3: opcionFinal = subMenuRanking(); break;
          }
       return opcionFinal;
    }
    
    
    //________________________________________Submenus
    
  public static int subMenuMus(){
      Scanner leer = new Scanner (System.in);
      System.out.println("¿Desea comenzar una partida de mus?"+"\n"+"1. Si \n"+"2. No, volver al menu principal");
      int miniopcion = leer.nextInt();
      while (miniopcion!=1 && miniopcion!=2){
         System.out.println("Su número no es válido, por favor, introduzca 1 o 2.");
         miniopcion = leer.nextInt();
         }
      if (miniopcion==2) {
        miniopcion=0;
      }
      return miniopcion;
      }
  
  public static int subMenuBlackJack(){
      Scanner leer = new Scanner (System.in);
      System.out.println("¿Desea comenzar una partida de Blackjack?"+"\n"+"1. Si \n"+"2. No, volver al menu principal");
      int miniopcion = leer.nextInt();
      while (miniopcion!=1 && miniopcion!=2){ // si no es un while si metes de nuevo algo que no es acaba el programa
         System.out.println("Su número no es válido, por favor, introduzca 1 o 2.");
         miniopcion = leer.nextInt();
         }
      if (miniopcion==2) {
        miniopcion=0;
      }
      return miniopcion;
      }
  
  public static int subMenuRanking(){
      Scanner leer = new Scanner (System.in);
      System.out.println("¿Quiere consultar los Rankings?"+"\n"+"1. Si \n"+"2. No, volver al menu principal");
      int miniopcion = leer.nextInt();
      while (miniopcion!=1 && miniopcion!=2){
         System.out.println("Su número no es válido, por favor, introduzca 1 o 2.");
         miniopcion = leer.nextInt();
         }
      if (miniopcion==2) 
        miniopcion=0;
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
}
