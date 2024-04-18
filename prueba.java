import java.io.*;
import java.util.*;

public class prueba {
    public static void main (String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
        String s = sc.next();
        FileReader leer = new FileReader(s+".txt");
        BufferedReader leedor = new BufferedReader (leer);
        Scanner file  = new Scanner(new File(s+".txt"));
        int n = 0;
        while(file.hasNextLine()) {
            file.nextLine();
            n++;
 }
        int i = 0;
        while (i<n){
            System.out.println(leedor.readLine());
            i++;
        }
        }catch (IOException e){
        System.out.println("error");
        }
        
        
    }
}