import java.io.*;
import java.util.Scanner;

public class blackjack {
    public static void main(String[] args) {
        System.out.println("Bienvenido a BlackJack:");
        System.out.println("¿En qué dificultad quieres jugar?\n"+"1. Normal\n"+"2. Difícil\n"+"3. Imposible\n");
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
            FileReader reader = new FileReader("C:/Users/Usuario/Documents/GitHub/juegosdecartas/juegosdecartas/puntuacionBlackjack.txt");
            BufferedReader reader2 = new BufferedReader(reader);
            int pJ = Integer.parseInt(reader2.readLine()); // la primera linea es la puntuacion del usuario
            int pM = Integer.parseInt(reader2.readLine()); // la segunda linea es la puntuacion de la maquina
            pJ += puntuacion[1];
            pM += puntuacion[0];
            FileWriter fw = new FileWriter("C:/Users/Usuario/Documents/GitHub/juegosdecartas/juegosdecartas/puntuacionBlackJack.txt");
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
    public static int sumaAs(int [][] baraja, int [] mano) { // cambia el valor del As de 1 a 11 si está en las dos primeras cartas y luego suma el valor de todas las cartas
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
            System.out.println("Pulse 1 si quiere coger una nueva carta");
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
            baraja[fila][columna] = 0; // con un 0 indica que ya está cogida
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
}
