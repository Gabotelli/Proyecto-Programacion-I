import java.util.Scanner;
// La modificaré cuando sepamos sacar datos de un .txt para el tema del nombre.
// Corresponde a las funcionalidades de menú principal y configuración de usuario
public class menu {
    public static String configInicial() { // Función que recoge datos del usuario.
        Scanner teclado = new Scanner (System.in);
        System.out.println("Bienvenido a tu ordenador personal. Por favor introduce tu nombre:");
        String nombre = teclado.nextLine(); // nos tienen que enseñar a almacenarlos en un archivo de texto.
        System.out.print("Ha quedado registrado como: "); System.err.print(nombre); System.out.print(". Disfrute su sesión. \n");
        return nombre;
    }

    public static void menuEleccion(String nombre) {
        Scanner teclado = new Scanner (System.in);
        int eleccion;

        System.out.println("-------------------------------------------------------------------");
        System.out.print("Hola "); System.err.print(nombre); System.out.println(", elija la opción que desee introduciendo el número asociado a ella: \n");
        System.out.println("1. Abrir calculadora");
        System.out.println("2. Abrir chat");
        System.out.println("3. Abrir cámara");
        System.out.println("4. Abrir agenda");
        System.out.println("5. Abrir tres en raya");
        System.out.println("-------------------------------------------------------------------");

        eleccion = teclado.nextInt();
        confirmarEleccion(eleccion, nombre);
    }

    public static void confirmarEleccion(int eleccion, String nombre) {
        Scanner teclado = new Scanner (System.in);
        
        switch (eleccion) {
           case 1: {
                int subEleccion = 0;
                System.out.println("-------------------------------------------------------------------");
                System.out.println("¿Estás seguro de que quieres abrir la calculadora? \n");
                System.out.println("1. Si");
                System.out.println("2. Volver al menú principal");
                System.out.println("-------------------------------------------------------------------");

                boolean salioBien = false; // Manera de reintentar try catch
                while(salioBien == false) {
                    try { // mediante try catch contemplo la opcion de que difiera de las opciones numericas o de que si pongo string pues en vez de petar el programa me salga
                        subEleccion = teclado.nextInt();

                        if (subEleccion == 1) {
                            //inicializarCalculadora();//
                            salioBien = true;
                        }
                        else if (subEleccion == 2) {
                            menuEleccion(nombre);
                            salioBien = true;
                        }
                        else {
                            System.err.println("ERROR: Introduce una opción válida");
                        }
                    } 
                    catch (Exception e) { // Exception que llamo e para referenciarla.
                        System.err.println("ERROR: Introduce una opción válida"); // cubro el caso de que metamos un string para que no salga error.
                        teclado.next(); // salgo de un bucle infinito causado por la excepción mismatch
                                        // QUEDA POR ENTENDER ESTA PARTE PARA PODER EXPLICARLA EN EL PROYECTO
                    }
                }
                
           }
           case 2: {
            int subEleccion = 0;
            System.out.println("-------------------------------------------------------------------");
            System.out.println("¿Estás seguro de que quieres abrir el chat? \n");
            System.out.println("1. Si");
            System.out.println("2. Volver al menú principal");
            System.out.println("-------------------------------------------------------------------");

            boolean salioBien = false; // Manera de reintentar try catch
            while(salioBien == false) {
                try { // mediante try catch contemplo la opcion de que difiera de las opciones numericas o de que si pongo string pues en vez de petar el programa me salga
                    subEleccion = teclado.nextInt();

                    if (subEleccion == 1) {
                        //inicializarChat();//
                        salioBien = true;
                    }
                    else if (subEleccion == 2) {
                        menuEleccion(nombre);
                        salioBien = true;
                    }
                    else {
                        System.err.println("ERROR: Introduce una opción válida");
                    }
                } 
                catch (Exception e) { // Exception que llamo e para referenciarla.
                    System.err.println("ERROR: Introduce una opción válida"); // cubro el caso de que metamos un string para que no salga error.
                    teclado.next(); // salgo de un bucle infinito causado por la excepción mismatch
                                    // QUEDA POR ENTENDER ESTA PARTE PARA PODER EXPLICARLA EN EL PROYECTO
                }
            }
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

                    if (subEleccion == 1) {
                        //inicializarCamara();
                        salioBien = true;
                    }
                    else if (subEleccion == 2) {
                        menuEleccion(nombre);
                        salioBien = true;
                    }
                    else {
                        System.err.println("ERROR: Introduce una opción válida");
                    }
                } 
                catch (Exception e) { // Exception que llamo e para referenciarla.
                    System.err.println("ERROR: Introduce una opción válida"); // cubro el caso de que metamos un string para que no salga error.
                    teclado.next(); // salgo de un bucle infinito causado por la excepción mismatch
                                    // QUEDA POR ENTENDER ESTA PARTE PARA PODER EXPLICARLA EN EL PROYECTO
                }
            }
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

                    if (subEleccion == 1) {
                        //inicializarAgenda());
                        salioBien = true;
                    }
                    else if (subEleccion == 2) {
                        menuEleccion(nombre);
                        salioBien = true;
                    }
                    else {
                        System.err.println("ERROR: Introduce una opción válida");
                    }
                } 
                catch (Exception e) { // Exception que llamo e para referenciarla.
                    System.err.println("ERROR: Introduce una opción válida"); // cubro el caso de que metamos un string para que no salga error.
                    teclado.next(); // salgo de un bucle infinito causado por la excepción mismatch
                                    // QUEDA POR ENTENDER ESTA PARTE PARA PODER EXPLICARLA EN EL PROYECTO
                }
            }
           }
           case 5: {
            int subEleccion = 0;
            System.out.println("-------------------------------------------------------------------");
            System.out.println("¿Estás seguro de que quieres jugar a las tres en raya? \n (se necesitan dos jugadores)\n");
            System.out.println("1. Si");
            System.out.println("2. Volver al menú principal");
            System.out.println("-------------------------------------------------------------------");

            boolean salioBien = false; // Manera de reintentar try catch
            while(salioBien == false) {
                try { // mediante try catch contemplo la opcion de que difiera de las opciones numericas o de que si pongo string pues en vez de petar el programa me salga
                    subEleccion = teclado.nextInt();

                    if (subEleccion == 1) {
                        //inicializarTresEnRaya();
                        salioBien = true;
                    }
                    else if (subEleccion == 2) {
                        menuEleccion(nombre);
                        salioBien = true;
                    }
                    else {
                        System.err.println("ERROR: Introduce una opción válida");
                    }
                } 
                catch (Exception e) { // Exception que llamo e para referenciarla.
                    System.err.println("ERROR: Introduce una opción válida"); // cubro el caso de que metamos un string para que no salga error.
                    teclado.next(); // salgo de un bucle infinito causado por la excepción mismatch
                                    // QUEDA POR ENTENDER ESTA PARTE PARA PODER EXPLICARLA EN EL PROYECTO
                }
            }
           }
        
        }
    }

}