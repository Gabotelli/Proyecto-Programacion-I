import java.io.*;
import java.util.*;
public class Agenda{
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Programa Principal
  public static void main(String[]Args){
    String base ="3";
    int eleccion = 0;
    while (base.equals("3")){
    int baseInicial = intro();
    base = subMenu(baseInicial); //el que sería el caso dos
    if (base.equals("1")) eleccion = 1;
    if (base.equals("4")) eleccion = 3;
    if (base!="3" && base!="1" && base!="xxx") eleccion = 2;
    switch(eleccion){
      case 1:{
        leerTodotxt();
      }break;
      
      case 3:{
        System.out.println("Esperemos que haya sido de su utilidad.");
        //Actualizar valor para salir del switch
      }break;
      
    case 2:{
              int numeroMenuFecha = numMenuFechas(base);
              int baseMenuFecha = 0;
              while(baseMenuFecha==0){
                switch (numeroMenuFecha){
                  case 1: crearYGuardarCita(base);
                    baseMenuFecha=1;break;//Crear Cita
                  case 2: eliminarUnaCita(base);break;//Eliminar Cita
                  case 3: eliminarTodasLasCitas(base);
                  case 4: baseMenuFecha=1;//Regreso al principal
    } break;//Switch menu opciones de la fecha
    }//While MENU FECHA (con el valor 0 se queda dentro)
    baseMenuFecha=0;
    }//Case 2
    }//__________________________________________Switch Menu Principal
    base="3";
    }//__________________________________________While MENU PRINCIPAL (para reiniciar tiene que tener base="3")
    
  }//Final del Main
  
 
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Funciones Auxiliares a trabajar
//___________________________________________________________Funcion para crear cita en una fecha_________________________________________________________________
  public static void crearYGuardarCita(String fecha){
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
    }
  }
  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Ficheros
//___________________________________________________________Funcion Leer todos los archivos txt de la carpeta______________________________________________________
  public static void leerTodotxt(){
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
              leerlineastxt (archivos[i]);
              System.err.println("");
            }
              System.err.println("Día "+archivos[(archivos.length)-1]+":");
              leerlineastxt (archivos[(archivos.length)-1]);
            System.err.println("______________________________________________________________________");
      } else {
        System.err.println("No tiene citas guardadas.");
      }
  }
//___________________________________________________________Funcion Leer un único txt___________________________________________________________________________
    public static void leerlineastxt(String base) {
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
    public static void eliminarTodasLasCitas(String fecha){
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
    }
//______________________________________________________________________Eliminar una cita___________________________________________________________________________ 
    public static void eliminarUnaCita(String fecha){
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
        String lineToRemove = linea;
        String currentLine;

        while((currentLine = leedor.readLine()) != null) {
   
          String trimmedLine = currentLine.trim();
          if(trimmedLine.equals(lineToRemove)) continue;
          escribir2.write(currentLine + System.getProperty("line.separator"));
        }
        escribir2.close(); 
        leedor.close(); 
      }catch (IOException e) {
        e.printStackTrace();
      }
      cambiarNombre(fecha);
    }
    public static void cambiarNombre(String fecha){
      File citasDia = new File("CitasAgenda/"+fecha+".txt");
      File nuevoCitasDia = new File("CitasAgenda/temp"+fecha+".txt");
      eliminarTodasLasCitas(fecha);
      nuevoCitasDia.renameTo(citasDia);
    }
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Funciones de Menu Fecha
//______________________________________________________________________Menu Opciones de la Fecha___________________________________________________________________
  public static int numMenuFechas(String base){
    System.err.println("Sus citas para el día "+base+" son:");
    leerlineastxt(base);
    System.out.println("Viendo sus citas, ¿que desea realizar?");
    System.out.println("1. Crear o modificar una cita.");
    System.out.println("2. Eliminar una cita.");
    System.out.println("3. Eliminar todas las citas.");
    System.out.println("4. Cancelar, regresar al menu principal del móvil.");
    Scanner leer = new Scanner(System.in);
    int opcion = leer.nextInt();
      while (opcion<1 || opcion>4){
      System.out.println("Su número no es válido, por favor, introduzca 1, 2, 3 o 4.");
      opcion = leer.nextInt();}
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
  //_____________________________Barra de Carga y Barra Corta________________________________________________________
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
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\ Final del Proyecto
}
