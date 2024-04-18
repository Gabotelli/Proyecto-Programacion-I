import java.util.*;
import java.io.*;
public class chatYContactos {
    public static void main(String[] args){
        System.out.println("1. Contactos\n2. Conversacion");
        Scanner sc = new Scanner(System.in);
        char op = sc.next().charAt(0);
        switch(op){
            case '1': agregarContactos();
            break;
            case '2': conversacion();
            break;
        }
        sc.close();
    }
    public static void conversacion(){
        System.out.println("Seleccione con quien quiere iniciar una conversacion: ");
        File dir = new File ("/contactos/");
        String[] nombres = dir.list();
        if (nombres.length != 0) {
            for (int i = 0 ; i < nombres.length ; i++){
                nombres[i] = nombres[i].substring(0, nombres[i].indexOf("."));
                System.out.println((i+1)+". "+nombres[i]);
            }
            Scanner sc = new Scanner(System.in);
            int e = sc.nextInt();
            System.out.println(nombres[e-1]);
            System.out.println("1. Llamada\n2. Chat");
            char f = sc.next().charAt(0);
            switch (f) {
                case '1' : llamada(nombres[e-1]); break;
                case '2' : chat(nombres[e-1]); break;
            }
            sc.close();
        } else {
            System.out.println("No hay contactos guardados");
        }         
    }
    public static void llamada(String s) {
        System.out.println("-------------------------\n");
        System.out.println(s+"...");
        System.out.println("\n\n\n");
        System.out.println("-------------------------\n");
    }
    public static void chat(String s) {
        System.out.println("-------------------------\n");
        System.out.println(s);
        System.out.println("\n\n\n");
        Scanner sc = new Scanner (System.in);
        String c = "";
        while (!c.equals("salir")) {
            c = sc.next();
        }
        sc.close();
        System.out.println("-------------------------\n");
    }
    public static void agregarContactos(){
        System.out.println("1. Agregar a contacto existente\n2. Agregar nuevo contacto");
        Scanner sc = new Scanner (System.in);
        char o = sc.nextLine().charAt(0);
        switch (o) {
            case '1': 
                System.out.println("Indique el nombre del contacto existente:");
                String nE = sc.nextLine();
                File dir = new File("/contactos/");
                String[] nombresA = dir.list();
                if (nombresA == null) {
                    System.out.println("No hay contactos guardados");
                } else {
                    for (int i = 0; i < nombresA.length; i++) {
                       String nombreA = nombresA[i];
                       nombreA = nombreA.substring(0, nombreA.indexOf("."));

                       if (nombreA.equals(nE)) {
                           System.out.println("1. Cambiar nombre\n2. Cambiar numero");
                           char h = sc.next().charAt(0);
                           switch (h) {
                               case '1':
                                    System.out.println("Escriba el nuevo nombre (Maximo 20 caracteres)");
                                    String nNombre = sc.next(); 
                                    while (nNombre.length() > 20) {
                                        System.out.println("Escriba el nombre correctamente");
                                        nNombre = sc.next();
                                    }
                                    String dirNN = "/contactos/"+nNombre+".txt";
                                    String dirAN = "/contactos/"+nE+".txt";
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
                                        System.out.println("Cambio de nombre exitoso");
                                    } else {
                                        System.out.println("Cambio no exitoso");
                                    }  
                                break;
                                case '2': 
                                    Scanner sc2 = new Scanner (System.in);
                                    System.out.println("Escriba el nuevo numero");
                                    String nNum = sc2.nextLine();
                                    while (nNum.length() != 9) {
                                        System.out.println("Escriba correctamente el nuevo numero");
                                        nNum = sc2.nextLine();
                                    }
                                    sc2.close();
                                    try {
                                        FileReader reader = new FileReader("/contactos/"+nE+".txt");
                                        BufferedReader reader2 = new BufferedReader(reader);
                                        String nom = reader2.readLine();
                                        FileWriter fw = new FileWriter("/contactos/"+nE+".txt");
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
                System.out.println("Escriba el nombre del contacto (Maximo 20 caracteres)");
                String nC = sc.nextLine();
                while (nC.length() > 20){
                    System.out.println("Escriba el nombre nuevamente");
                    nC = sc.nextLine();
                }
                System.out.println("Escriba el numero del contacto");
                String numC = sc.nextLine();
                while (numC.length() != 9 ){
                    System.out.println("Introduzca correctamente el numero del contacto");
                    numC = sc.nextLine();
                }
                try {
                    FileWriter fw = new FileWriter("/contactos/"+nC+".txt");
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
        sc.close();
    }
}