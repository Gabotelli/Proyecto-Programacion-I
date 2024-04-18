import java.util.Scanner;

public class calculadoraperomaspro {

    public static void inicializarCalculadora() { //puede parecer inutil pero cuando tengamos 34r3845348732487528953294857239 funciones pos esto simplifica xd
        Scanner teclado =  new Scanner(System.in);
        System.out.println("Introduce los dos valores con los que quieres operar:");
        double a = teclado.nextDouble();
        double b = teclado.nextDouble();
        menuCalculadora(a, b);
    }

    public static void menuCalculadora(double a, double b) {
        System.out.println("|-----------------------------------");
        System.out.println("|  |x|          CALCULADORA         ");
        System.out.println("|-----------------------------------");

        int i=0;
        do {
            i++;
            System.out.println("|                                  ");
        }
        while (i<13);
        System.out.println("|----------------------------------");

    }


    public static void main (String[]args) {
        inicializarCalculadora();
    }
    
}
