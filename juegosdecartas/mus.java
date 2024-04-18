import java.util.Scanner;
public class mus 
{
 public static void main(String[]args)
 {
   int[] baraja ={4,4,4,4,4,4,4,0,0,4,4,4}; //La baraja al principio tenemos 4 cartas de cada tipo
   boolean volverApreguntar=true; //definimos un avariable que nos ayudará con el descarte
   int[][] arrayAux={{0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0}}; //Este array nos ayudará a actualizar la baraja
   Scanner teclado;
   boolean dificultad=dificultad(); //Vemos que dificultad quiere el usuario, 0 será Normal y 1 será Dificil
   int[] puntuacion=new int[2]; //La posicion 0 será la puntuacion del jugador y la 1 la del programa
   int[] cartasJugador=cartas(baraja); //Ahora debemos actualizar que cartas hay en la baraja
   baraja=actualizadorBaraja(baraja, cartasJugador);
   int[] cartasPrograma=cartas(baraja);
   baraja=actualizadorBaraja(baraja, cartasPrograma);
   System.out.println("Sus cartas son; | "+cartasJugador[0]+" | "+cartasJugador[1]+" | "+cartasJugador[2]+" | "+cartasJugador[3]+" | ");
   do { //utilizamos do while ya que queremos que se ejecute al menos una vez
   if(quererMusPrograma(dificultad,cartasPrograma)){
      System.out.println("El programa ha querido mus");
     if(quererMusJugador())
     {
      arrayAux=descartarseCartas(cartasJugador,baraja); //Esta funcion nos devuelva una matriz en la que la posición 0 están las cartas del jugador y en la 1 la baraja, la cual se actualiza según el jugador se quita cartas
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
   }while(volverApreguntar==true);
  int[] puntuacionGrande=grande(cartasJugador, cartasPrograma, dificultad); //Invocamos a las funciones y guardamos la puntuación
  int[] puntuacionChica=chica(cartasJugador, cartasPrograma, dificultad);
  int[] puntuacionPares=pares2(cartasJugador,cartasPrograma,dificultad);
  int[] puntuacionJuego=juego2(cartasJugador,cartasPrograma,dificultad);
  for(int i=0;i<2;i++)
   puntuacion[i]= puntuacionGrande[i]+puntuacionChica[i]+puntuacionPares[i]+puntuacionJuego[i];
  if(puntuacion[0]>puntuacion[1])
  {
   System.out.println("Felicidades usted ha ganado al programa con una puntuación de "+puntuacion[0]);
   System.out.println("Las cartas del programa eran: " +" | "+cartasPrograma[0]+" | "+cartasPrograma[1]+" | "+cartasPrograma[2]+" | "+cartasPrograma[3]+" | ");
  }
  else if(puntuacion[0]<puntuacion[1])
  {
   System.out.println("El programa ha ganado, mejor suerte la próxima vez, usted tuvo una puntuación de "+puntuacion[0]+ " y el programa una de "+puntuacion[1]); 
   System.out.println("Las cartas del programa eran: " +" | "+cartasPrograma[0]+" | "+cartasPrograma[1]+" | "+cartasPrograma[2]+" | "+cartasPrograma[3]+" | ");
  }
  else
  {
   System.out.println("Han empatado con una puntuacion de "+puntuacion[1]); 
   System.out.println("Las cartas del programa eran: " +" | "+cartasPrograma[0]+" | "+cartasPrograma[1]+" | "+cartasPrograma[2]+" | "+cartasPrograma[3]+" | "); 
  }
  for(int i=0;i<12;i++)
    System.out.println(" | "+baraja[i]+ " | ");
 }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Parte del programa para grande
 public static int[] grande(int[] cartasJugador, int [] cartasPrograma, boolean dificultad) //Lo definimos como int[] ya que queremos que nos devuelva la puntuación del programa y del jugador, la posición 0 será para el jugador y 1 para el programa
 {
   int[] resultado=new int[2];
   if(dificultad==false) //Si la dificultad está en normal el programa envida o pasa aleatoriamente 
   {
    if(randomizador()==0){  //El programa envida
      System.out.println("El programa envida a grande, ¿pasas, quieres o desea hacer órdago?");
      resultado=discutirGrande(cartasJugador,cartasPrograma,0,dificultad);   
    }
     else{ //El programa pasa 
      System.out.println("El programa pasa, ¿pasas,envidas o desea hacer órdago?");
      resultado=discutirGrande(cartasJugador,cartasPrograma,1, dificultad);
    }
   }
   else{ //Si el programa tiene buenas cartas envidará, si no pasará
    if(sumaCartas(cartasPrograma)>30){
     System.out.println("El programa envida a grande, ¿pasas, quieres o desea hacer órdago?");
     resultado=discutirGrande(cartasJugador,cartasPrograma,0,dificultad);   
    }
    else{
      System.out.println("El programa pasa, ¿pasas,envidas o desea hacer órdago?");
      resultado=discutirGrande(cartasJugador,cartasPrograma,1, dificultad);
    }
   }
   return resultado;
 }
 public static int[] discutirGrande (int[] cartasPrograma, int[] cartasJugador, int n, boolean dificultad) //Esta n nos permitirá diferenciar entre si el programa ha envidado o pasado
 {
   int[] resultado= new int[2];//la posición 0 será para el jugador y 1 para el programa
   Scanner teclado=new Scanner(System.in);
   String respuesta=teclado.nextLine();
   if(respuesta.equalsIgnoreCase("Paso")&&n==1){ //Programamos que pasa si el usuario "pasa", n no interfiere pues en ambas opciones puede pasar
     if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)){ //Si ganase el programa se llevará el punto de grande
       resultado[1]=2; //En este caso se lleva el punto de grande y el punto del envite 
       System.out.println("El programa se lleva un punto ya que ha envidado");
     }
     else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)&&n==0){ //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
       resultado[0]=1; //El jugador se lleva el punto de  grande
       resultado[1]=1; //El programa se lleva el punto de envite 
     }
   }
   if(respuesta.equalsIgnoreCase("Envido") && n==1 ){ //n deberá ser 1 ya que solo puede envidar si el programa pasa
     if(dificultad==false){ //Si estamos en facil será random
       if(randomizador()==0){
        System.out.println("El programa las quiere");
         if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de grande
         resultado[1]=1;
         else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0]=1;  
       }
       else {
        System.out.println("El programa no las quiere, se pasa a hablar de chica"); //Si no las quiere la única opción es que pase
        resultado[0]=1;
       }
     }
     else //Si estamos en dificil tendrá en cuenta la suma de sus cartas
     {
       if(sumaCartas(cartasPrograma)>30){ //Si sus cartas son buenas para grandes, el programa querra el envite
         System.out.println("El programa las quiere");
         if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de grande
         resultado[1]=1;
         else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0]=1;   
       }
       else{
         System.out.println("El programa no las quiere");
         resultado[0]=1;   
       }
      }
     } //Acaba la opción de envidar
    if(respuesta.equalsIgnoreCase("Quiero")&&n==0){ //n debe ser 0 ya que el usuario solo puede querer si el programa envita
     if(dificultad==false){ //Programamos que hace si está en normal
       if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de grande
         resultado[1]=1;
       else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0]=1;   
     }
     else{ //Programamos que hace si la dificultad es dificil, en este caso como ha envitado y el jugador ha querido, no debe hacer nada
       if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de grande
         resultado[1]=1;
       else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0]=1;   
     }
    }
    if(respuesta.equalsIgnoreCase("Ordago")){ //En cualquier momento se puede dar Ordago
     if(ordago(cartasPrograma, cartasJugador, dificultad,1)==true) //Si el jugador ganase el Ordago se acaba la partida
       System.out.println("ENHORABUENA USTED HA GANADO");
    }
    System.out.println("Grande ha terminado, se pasa a hablar de chica, se le dirá su puntuación de grande al terminar la partida");
    return resultado;   
  }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Parte del programa para chica
 public static int[] chica(int[] cartasJugador, int [] cartasPrograma, boolean dificultad) //Lo definimos como int[] ya que queremos que nos devuelva la puntuación del programa y del jugador, la posición 0 será para el jugador y 1 para el programa
 {
   int[] resultado=new int[2];
   if(dificultad==false) //Si la dificultad está en normal el programa envida o pasa aleatoriamente 
   {
    if(randomizador()==0){  //El programa envida
      System.out.println("El programa envida a chica, ¿pasas, quieres o desea hacer órdago?");
      resultado=discutirChica(cartasJugador,cartasPrograma,0,dificultad);   
    }
     else{ //El programa pasa 
      System.out.println("El programa pasa, ¿pasas,envidas o desea hacer órdago?");
      resultado=discutirChica(cartasJugador,cartasPrograma,1, dificultad);
    }
   }
   else{ //Si el programa tiene buenas cartas envidará, si no pasará
    if(sumaCartas(cartasPrograma)>30){
     System.out.println("El programa envida a chica, ¿pasas, quieres o desea hacer órdago?"); 
     resultado=discutirChica(cartasJugador,cartasPrograma,0,dificultad);   
    }
    else{
      System.out.println("El programa pasa, ¿pasas,envidas o desea hacer órdago?");
      resultado=discutirChica(cartasJugador,cartasPrograma,1, dificultad);
    }
   }
   return resultado;
 }
 public static int[] discutirChica (int[] cartasPrograma, int[] cartasJugador, int n, boolean dificultad) //Esta n nos permitirá diferenciar entre si el programa ha envidado o pasado
 {
   int[] resultado= new int[2];//la posición 0 será para el jugador y 1 para el programa
   Scanner teclado=new Scanner(System.in);
   String respuesta=teclado.nextLine();
   if(respuesta.equalsIgnoreCase("Paso")){ //Programamos que pasa si el usuario "pasa", n no interfiere pues en ambas opciones puede pasar
     if(sumaCartas(cartasPrograma)>sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de grande
       resultado[1]=1;
     else if (sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
       resultado[0]=1;
   }
   if(respuesta.equalsIgnoreCase("Envido") && n==1 ){ //n deberá ser 1 ya que solo puede envidar si el programa pasa
     if(dificultad==false){ //Si estamos en facil será random
       if(randomizador()==0){
        System.out.println("El programa las quiere");
         if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de grande
         resultado[1]=1;
         else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0]=1;  
       }
       else {
        System.out.println("El programa pasa"); //Si no las quiere la única opción es que pase
        resultado[0]=1;
       }
     }
     else //Si estamos en dificil tendrá en cuenta la suma de sus cartas
     {
       if(sumaCartas(cartasPrograma)<15){ //Si sus cartas son buenas para chica, el programa querra el envite
         System.out.println("El programa las quiere");
         if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de chica
         resultado[1]=1;
         else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
         resultado[0]=1;   
       }
       else{
         System.out.println("El programa no las quiere");
         resultado[0]=1;   
       }
      }
     } //Acaba la opción de envidar
    if(respuesta.equalsIgnoreCase("Quiero")&&n==0){ //n debe ser 0 ya que el usuario solo puede querer si el programa envita
     if(dificultad==false){ //Programamos que hace si está en normal
       if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de chica
         resultado[1]=1;
       else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0]=1;   
     }
     else{ //Programamos que hace si la dificultad es dificil, en este caso como ha envitado y el jugador ha querido, no debe hacer nada
       if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Si ganase el programa se llevará el punto de grande
         resultado[1]=1;
       else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si gana el jugador se lleva el punto el jugador, usamos else if ya que si empatan queremos que el programa no haga nada
        resultado[0]=1;   
     }
    }
    if(respuesta.equalsIgnoreCase("Ordago")){ //En cualquier momento se puede dar Ordago
      if(ordago(cartasPrograma, cartasJugador, dificultad,2)) //Si el jugador ganase el Ordago se acaba la partida
       System.out.println("ENHORABUENA USTED HA GANADO");
    }
    if(sumaCartas(cartasPrograma)<sumaCartas(cartasJugador)) //Por ultimo sumamos un punto a quien tenga mejor mano
         resultado[1]+=1;
    else if (sumaCartas(cartasJugador)<sumaCartas(cartasPrograma))
         resultado[0]+=1;
    System.out.println("Chica ha terminado, se pasa a hablar de pares, se le dirá su puntuación de chica al terminar la partida");
    return resultado;   
  }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Parte del programa para Pares
 public static int[] pares2 (int[] cartasJugador, int[] cartasPrograma, boolean dificultad)
 {
   System.out.println("Sus cartas son; | "+cartasJugador[0]+" | "+cartasJugador[1]+" | "+cartasJugador[2]+" | "+cartasJugador[3]+" | ");
   int[] resultado= new int[2];
   int k=0; //Esto nos permitirá distinguir entre si el usuario puede envidar o querer
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
     resultado[0]=1;
   }
   if(pares(cartasPrograma)>1&&pares(cartasJugador)==1) //Si el programa tiene pero el jugeador no gana el programa
   {
    System.out.println("Usted no tiene pares pero el programa sí, el programa se lleva el punto de pares"); 
    resultado[1]=1;
   }
   if(pares(cartasPrograma)>1&&pares(cartasJugador)>1) //Si ambos tienen pares se discute que pasa
   {
    if(dificultad==false) //En caso de que sea normal
    {
     if(randomizador()==0)  //randomizamos si el programa envida o pasa
     {
       System.out.println("El programa envida, ¿quiere, pasa u órdago?");
       respuesta=teclado.nextLine();
     }
     else 
     {
      System.out.println("El programa pasa,¿envida, pasa u órdago?");
      respuesta=teclado.nextLine();
       k=2;
     }
    }
    else //En caso de que sea dificil
    {
     if(pares(cartasPrograma)>2) 
     {
      System.out.println("El programa envida,¿quiere, pasa u órdago?");   //Si el programa tiene medias o más envidará 
      respuesta=teclado.nextLine();
     }
      else
      {
       System.out.println("El programa pasa, envida, pasa u órdago?"); //Si no tiene buenos pares pasa
       respuesta=teclado.nextLine();
       k=2; 
      }
    }
   }
   if(respuesta.equalsIgnoreCase("Paso")&& k!=2){ //El programa envida y el usuario pasa
     resultado=discutirPares(cartasJugador, cartasPrograma);
     resultado[1]+=1; 
   }
   else if(respuesta.equalsIgnoreCase("Paso")&& k==2) //El programa pasa y el usuario pasa
       resultado=discutirPares(cartasJugador, cartasPrograma);
   if(respuesta.equalsIgnoreCase("Envido")) //Envidar
   {
     if(dificultad==false) //Programamos que pasa si la dificultad es facil
     {
       if(randomizador()==0)
       {
        System.out.println("El programa las quiere");
        resultado=discutirPares(cartasJugador, cartasPrograma); //Se ve quien gana
       }
       else
       {
        System.out.println("El programa pasa");
        resultado=discutirPares(cartasJugador, cartasPrograma);
        resultado[0]+=1; //Sumamos un punto ya que el jugador ha envidado y el programa no ha querido 
       }
     }
     else
     {
       if(pares(cartasPrograma)>2)
       {
        System.out.println("El programa las quiere");
        resultado=discutirPares(cartasJugador, cartasPrograma); //Se ve quien gana 
       }
       else
       {
        System.out.println("El programa pasa");
        resultado=discutirPares(cartasJugador, cartasPrograma);
        resultado[0]+=1; //Sumamos un punto ya que el jugador ha envidado y el programa no ha querido   
       }
     }
   }
   if(respuesta.equalsIgnoreCase("Quiero")&& k==1) //Querer
   {
    resultado=discutirPares(cartasJugador, cartasPrograma); //Si el programa envida y el usuario las quiere, se ve quien gana
   }
   if(respuesta.equalsIgnoreCase("Ordago")) //Ordago
   {
     if(ordago(cartasPrograma, cartasJugador, dificultad,3)==true) //Si el jugador ganase el Ordago se acaba la partida
       System.out.println("ENHORABUENA USTED HA GANADO");
   }
   return resultado;
 }
 public static int[] discutirPares (int[] cartasJugador, int[] cartasPrograma) //Esta funcion nos devuelve quien ganaría 
 {
  int[] resultado= new int[2];
  if(pares(cartasJugador)>pares(cartasPrograma)) //Si los pares del jugador son mejores que los del programa gana el jugador
     resultado[0]=1;
   else if (pares(cartasJugador)<pares(cartasPrograma)) //Si los pares del programa son mejores que los del jugador gana el programa
     resultado[1]=1;
   else if(pares(cartasJugador)==pares(cartasPrograma)) //Si tienen los mismos pares vemos cual es su suma 
   {
    if(sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Si la suma del jugador es mayor 
      resultado[0]=1;
    else if(sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) //Si la suma del Programa es mayor
      resultado[1]=1;
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
   if(dificultad==false) //Si la dificultad es facil será random
   {
    if(randomizador()==0)
    {
      System.out.println("El programa ha querido el ordago");
      resultado= switchOrdago(cartasPrograma, cartasJugador, parteDelJuego);
    }
    else
      System.out.println("El programa no ha querido ordago");
   }
   else //Si la dificultad está en dificil
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
 public static boolean switchOrdago (int[] cartasPrograma, int[] cartasJugador, int parteDelJuego) //Esta funcion dice si el jugador ganaría el ordago
 {
    boolean resultado=false; 
    switch (parteDelJuego) //esta parte distinguirá en que parte del juego nos encontramos
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
 public static int[] juego2 (int[] cartasJugador, int[] cartasPrograma,boolean dificultad)
 {
   Scanner teclado = new Scanner(System.in);
   String respuesta;
   int[] resultado= new int[2];
   int k=0;
   if(sumaCartas(cartasJugador)>30) //Si el jugador tiene juego se debe decir
     System.out.println("Usted tiene juego");
   else
     System.out.println("Usted no tiene juego"); //Si no lo tiene también
   if(sumaCartas(cartasPrograma)<31){ //Si el programa no tiene juego se dice
     System.out.println("El programa no tiene juego");
     if(sumaCartas(cartasJugador)<31) //Si ninguno tiene juego se juega a punto, gana el que tenga la mayor suma
     {
      System.out.println("Se juega a juego al punto") ; 
        if(sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)){//Gana el jugador
        System.out.println("Usted gana el juego al punto");
       resultado[0]=1;   
      }
      else if(sumaCartas(cartasJugador)<sumaCartas(cartasPrograma)) { //Gana el programa
        System.out.println("El programa gana el juego al punto");
        resultado[1]=1;   
      }
     }
   }
   if(sumaCartas(cartasPrograma)>31 && sumaCartas(cartasJugador)>31) //Si ambos tienen juego se discute que pasa
   {
    System.out.println("Ambos tienen juego"); 
     if(dificultad==false) //Si estamos en normal 
    {
      if(randomizador()==0) //Envida de forma aleatoria 
      {
       System.out.println("El programa envida a Juego,¿las quiere, pasa u ordago?");
       respuesta= teclado.nextLine();
       k=1; //Nos sirve para diferenciar entre si el programa envida o pasa
      }
      System.out.println("El programa pasa ¿envida, pasa u ordago?");
       respuesta= teclado.nextLine();
    }
     else //Si estamos en dificil
     {
       if(sumaCartas(cartasPrograma)==31 || sumaCartas(cartasPrograma)==40 ||sumaCartas(cartasPrograma)==32 ) //Solo envida si tiene buenos juegos
       {
       System.out.println("El programa envida a Juego,¿las quiere, pasa u ordago?");
       respuesta= teclado.nextLine();
       k=1; //Nos sirve para diferenciar entre si el programa envida o pasa
       }
       else
       {
        System.out.println("El programa pasa ¿envida, pasa u ordago?");
        respuesta= teclado.nextLine(); 
       }
     }
     if(respuesta.equalsIgnoreCase("Paso")&& k==1) //Si el jugador pasa y el programa ha envidado
     {
      System.out.println("El programa se lleva un punto ya que invidó y usted no quiso") ; //El programa se lleva el punto
      resultado[1]=1; 
     }
     else if(respuesta.equalsIgnoreCase("Paso")&& k==0) //Si ambos pasan 
      System.out.println("Ambos han pasado, se pasa a ver la puntuación");
     else if(respuesta.equalsIgnoreCase("Quiero")&& k==1) //Si el programa envida y el jugador quiere, pasamos a la puntuación para ver quien gana juego
      System.out.println("Se pasa a hablar de la puntuación");
     else if(respuesta.equalsIgnoreCase("Invido")&&k==0) //Si el programa pasa y el jugador envida el programa decide si quiere o no 
     {
      if(dificultad==false) //En normal 
      {
       if(randomizador()==0){ //Será aleatorio 
        System.out.println("El programa las quiere");
       } 
       else{
         System.out.println("El programa pasa");
         resultado[0]=1;
       }
      }
      else //En dificil
      {
       if(sumaCartas(cartasPrograma)==31 || sumaCartas(cartasPrograma)==40 ||sumaCartas(cartasPrograma)==32 )// Solo las querrá si tiene buenos juegos
       {
        System.out.println("El programa las quiere");
        //Su puntuación será discutida al hablar de la puntuación, es equivalente a que si el programa envida y el usuario quiere 
       }
       else
       {
        System.out.println("El programa pasa");
        resultado[0]=1; //Se lleva un punto el jugador ya que envida
       } 
      }
     }
     else if(ordago(cartasPrograma, cartasJugador, dificultad,4)) //Si el jugador ganase el Ordago se acaba la partida
       System.out.println("ENHORABUENA USTED HA GANADO");
     }
     if(juego(cartasJugador, cartasPrograma))  //Sumamos el punto de juego a quien tenga el mejor juego
       resultado[0]+=1;
     else if(sumaCartas(cartasJugador)!=sumaCartas(cartasPrograma))
       resultado[1]+=1;
     return resultado;
   }
 public static boolean juego(int[] cartasJugador, int[] cartasPrograma) //Esta funcion dice si las cartas del jugador ganarían a las cartas del programa en Juego
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
     else if(sumaCartas(cartasJugador)>sumaCartas(cartasPrograma)) //Los siguientes juegos van de manera descendente, entonces ganará quien tenga la mayor suma
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
 public static int pares(int[] cartas) //Esta funcion nos devolverá 1 si no tenemos pares, 2 si tenemos pares, 3 si tenemos medias, 4 si tenemos duples
 {
   //Si no se tiene nada devolverá 1 
   //Si se tiene pares se devolverá 2 
   //Si se tiene medias se devolverá 3
   //Si se tiene duples se devolverá 4
   int resultado=1;
   boolean noSeHaVistoAntes=true;
   int[] cartasAux={cartas[0],cartas[1],cartas[2],cartas[3]}; //Creamos una baraja auxiliar ya que 3 y 12 son iguales y 1 y 2 también
     for(int i=0;i<4;i++)
     {
      if(cartas[i]==3) 
        cartasAux[i]=12;
      if(cartas[i]==2)
        cartasAux[i]=1;
     }
   for(int i=0;i<4;i++) 
   {
     if(i!=0){ //si i no es 0 hará esto
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
     else //Si i es 0 mira si está más veces en todas sus posiciones siguientes
       for(int j=1;j<4;j++)
     {
       if(cartasAux[i]==cartasAux[j])
       resultado+=1;
    }
    noSeHaVistoAntes=true; 
   }
   if(resultado==3) //en el mus no solo{1,1,1,1} es duples si no que {1,1,0,0} también, el anterior algoritmo reconoce {1,1,0,0} como 3, pues suma un 1 de los dos 1 y un 1 de los dos 0, en este caso debemos sumar otro 1 
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
    resultado=dificultad(); //Si no ha dicho ni Normal ni Dificil, volvemos a llamar a la función para preguntar de nuevo
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
   if(dificultad==false){ //En esta parte el programa da o no da mus de manera aleatoria, ya que la dificultad es normal
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
   System.out.println("¿Quieres Mus?");
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
 {            //Creamos que tenga dos arrays de 4 posiciones ya que debemos actualizar la baraja cada vez que se quita una carta, la baraja será la posición [1] y las cartas del jugador la [0]
  int[][] resultado= new int[2][4];
  resultado [0]=cartasJugador;
  resultado[1]=baraja;
  Scanner teclado=new Scanner (System.in);
  System.out.println("Carta 1: "+cartasJugador[0]+" Carta 2: "+ cartasJugador[1]+" Carta 3: "+cartasJugador[2]+" Carta 4: "+ cartasJugador[3]);
  System.out.println("¿Cuantas cartas se quiere descartar?"); //Preguntamos cuantas cartas se va a querer descartar para poder reiterar el algoritmo de descarte esas veces
  int cuantasCartas=teclado.nextInt();
  if(cuantasCartas<5 && cuantasCartas>0){ //Si introduce un numero valido se ejecuta el for 
  for(int i=0;i<cuantasCartas;i++)
  {
   System.out.println("¿Que carta se quiere descartar?") ; 
   int cartaX=teclado.nextInt();
   int cartaSustituta=nuevaCarta(resultado[1]);
   resultado[0][cartaX-1]=cartaSustituta; //Restamos 1 ya que el usuario responderá el lenguje natural, su primera carta es nuestra carta 0
   resultado[1][cartaSustituta-1]-=1; //Quitamos la carta dada a la baraja
  }}
  else{ //Si introduce un numero no valido se le vuelve a preguntar
    System.out.println("Introduzca un numero válido");
    descartarseCartas(cartasJugador, baraja);}
  System.out.println("Carta 1: "+cartasJugador[0]+" Carta 2: "+ cartasJugador[1]+" Carta 3: "+cartasJugador[2]+" Carta 4: "+ cartasJugador[3]);
  return resultado;
 }
 public static int randomizador() //dará un valor aleatorio entre 0 y 1 
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
   if(dificultad==false){ //Si estamos en facil el descarte será aleatorio y se descarta todas
     resultado[0]=cartas(baraja);
     resultado[1]=actualizadorBaraja(resultado[1],resultado[0]);
   }
   else //Si la dificultad es dificil no se quitará figuras ni si tienes duples
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