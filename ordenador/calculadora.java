public class calculadora {
    public static void menuCalculadora(int a, int b) {
        System.out.println("|-----------------------------------|\n"+
                            "|            CALCULADORA         |x|| " );
        System.out.println("                                                      ");
    }
    public String menuLineaValorVariables(int a, int b) {
        String resultado = "";
        String resultadoAEncajar = ("a = "+a+", b = "+b);
        String substringResultado = "";

        for (int i = 0; i == 36-resultadoAEncajar.length(); i++) {
            substringResultado = substringResultado + " ";
        }

        if(resultadoAEncajar.length() < 35) {
            resultado = "| " + resultadoAEncajar + substringResultado + "|";
        }

        for (int i = 0; i==37; i++) {
            
        }
        return resultado;
    }
    public static void main (String[]args) {
        int a = 24;
        int b = 444;
        menuCalculadora(a,b);



    }
}
