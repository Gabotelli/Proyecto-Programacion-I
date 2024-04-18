import java.io.*;
public class leaderboard {
    public static void main(String[] args) {
        System.out.println("                LEADERBOARD");
        System.out.println("MUS: ");
        System.out.println("Usuario: "+leerPuntuacion(puntuacionMus(),0)+"     "+"Maquina: "+leerPuntuacion(puntuacionMus(),1)+"");
        System.out.println("BLACKJACK: ");
        System.out.println("Usuario: "+leerPuntuacion(puntuacionBlackJack(),0)+"     "+"Maquina: "+leerPuntuacion(puntuacionBlackJack(),1)+"");
    }
    public static int leerPuntuacion(int[] puntuacion, int p){
        int puntos = puntuacion[p];
        return puntos;
    }
    public static int[] puntuacionBlackJack(){//la posicion 0 es el usuario y la 1 la maquina
        int[] puntuacionU = new int[2];
        try {
            FileReader leer = new FileReader("C:/Users/Gabo/Documents/GitHub/ProyectoProgramacion/juegosdecartas/puntuacionBlackJack.txt");
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
            FileReader leer = new FileReader("C:/Users/Gabo/Documents/GitHub/ProyectoProgramacion/juegosdecartas/puntuacionMus.txt");
            BufferedReader archivo = new BufferedReader(leer);
            puntuacionM[0] = Integer.parseInt(archivo.readLine());
            puntuacionM[1] = Integer.parseInt(archivo.readLine());
        } catch (Exception e) {
            System.out.println("error");
        }
        return puntuacionM;
    }
    
}
