package es.unileon.prg.tema5;

/**
 * Clase con los ejercicios correspondientes a cadenas de caracteres.
 * La clase "String"
 *
 * @author PRG
 * @version 1.0
 */
    public class Apartado030201 extends Apartado {
   
       protected String obtenerPractica(){
         return "P-VAR";
      }
   
       protected String obtenerBloque() {
         return "Cadenas de caracteres - Clase <<String>>";
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio1.
    *
    * </br>
    *
    * Se pide anyadir el codigo necesario para realizar las siguientes tareas:
    *	Obtener el numero de caracteres de la cadena.
    *	Calcular la posicion intermedia de la cadena.
    *	Extraer el caracter que ocupa dicha posicion.
    *	Mostrar por pantalla dicho caracter y el codigo que lo representa.
    */
       public void ejercicio01() {
         cabecera("01","");
         String cadena = "En un lugar de la Mancha";
        // Inicio modificacion
	int tamanyo=cadena.length();
	int tamanyoMedio=tamanyo/2;
	System.out.println("El numero de caracteres es= "+tamanyo); 
	System.out.println("La posicion intermedia es= "+tamanyoMedio); 
	System.out.println("El caracter intermedio es= "+cadena.charAt(tamanyoMedio)); 
        // Fin modificacion
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio2.
    *
    * </br>
    *
    *	Comparar las dos cadenas para ver si son iguales y mostrar por pantalla el resultado de la comparacion.
    * Volver a compararlas pero ahora sin tener en cuenta si estan en mayusculas o minusculas y mostrar por pantalla el resultado de la comparacion.
    *	Convertir las dos cadenas a minusculas, volver a compararlas y mostrar por pantalla el resultado de la comparacion.
    *
    */
       public void ejercicio02() {
         cabecera("02", "");
         String cadena = "Viaje al Parnaso";
         String otraCadena = "ViAje al pArnaso";
      // Inicio modificacion
	boolean comparar=cadena.equals(otraCadena);
	if(comparar==true){	
		System.out.println("Las cadenas son iguales");
	}else{
		System.out.println("Las cadenas no son iguales");
	}

	boolean compararSinMayus=cadena.equalsIgnoreCase(otraCadena);
	if(compararSinMayus==true){	
		System.out.println("Las cadenas son iguales");
	}else{
		System.out.println("Las cadenas no son iguales");
	}

	String cadenaMinusculas=cadena.toLowerCase();
	String otraCadenaMinusculas=otraCadena.toLowerCase();
	boolean compararMinusculas=cadenaMinusculas.equals(otraCadenaMinusculas);

	if(compararMinusculas==true){	
		System.out.println("Las cadenas en minuscula son iguales");
	}else{
		System.out.println("Las cadenas en minuscula no son iguales");
	}
      // Fin modificacion
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio3.
    *
    * </br>
    * Se pide anyadir el codigo necesario para realizar las siguientes tareas:
    *	Concatenar las dos cadenas formando una tercera usando el operador +
    * Concatenar las dos cadenas formando una tercera usando el metodo concat
    * Mostrar los resultados por pantalla.
    */
       public void ejercicio03() {
         cabecera("03", "");
      
         String cadena = "Viaje al Parnaso";
         String otraCadena = "Persiles y Segismunda";
      	//Inicio modificacion
	String terceraCadena=cadena+otraCadena;
	System.out.println(terceraCadena);

	String cuartaCadena=cadena.concat(otraCadena);
	System.out.println(cuartaCadena);
        // Fin modificacion
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio4.
    *
    * </br>
    *
    * Se pide anyadir el codigo necesario para realizar las siguientes tareas:
    * Comprobar si la cadena termina con la palabra Parnaso utilizando endsWith.
    * Comprobar si la cadena empieza con la palabra Viaje utilizando startsWith.
    * Mostrar los resultados por pantalla.
    */
       public void ejercicio04() {
         cabecera("04", "");
         String cadena = "Viaje al Parnaso";
        // Inicio modificacion
	boolean comprobar;
	comprobar=cadena.endsWith("Parnaso");
	System.out.println(comprobar);
	comprobar=cadena.startsWith("Viaje");
	System.out.println(comprobar);
        // Fin modificacion
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio5.
    *
    * </br>
    *
    * Se pide anyadir el codigo necesario para realizar las siguientes busquedas en cadena utilizando indexOf:
    * Buscar si el caracter p esta en la cadena y mostrar el resultado por pantalla.
    * Buscar si la cadena Par esta en la cadena y mostrar el resultado por pantalla.
    * Buscar la ultima ocurrencia de la letra a en la cadena y mostrar el resultado por pantalla.
    * Buscar la letra a empezando por la posicion 3 y mostrar el resultado por pantalla.
    */
       public void ejercicio05() {
         cabecera("05","");
         String cadena = "Viaje al Parnaso";
      // Inicio modificacion
	if(cadena.indexOf("p")==-1){
		System.out.println("El caracter p no se encuentra en la cadena");
	}else{
		System.out.println("El caracter p se encuentra en la posicion= "+cadena.indexOf("p"));	
	}

	if(cadena.indexOf("Par")==-1){
		System.out.println("La cadena Par no se encuentra en la cadena");
	}else{
		System.out.println("La cadena Par se encuentra en la posicion= "+cadena.indexOf("Par"));	
	}

	if(cadena.lastIndexOf("a")==-1){
		System.out.println("El caracter a empezando por el final no se encuentra en la cadena");
	}else{
		System.out.println("El ultimo caracter a se encuentra en la posicion= "+cadena.lastIndexOf("a"));
	}

	if(cadena.indexOf("a",3)==-1){
		System.out.println("La letra a no se encuentra en la cadena");
	}else{
		System.out.println("La letra a se encuentra en la posicion= "+cadena.indexOf("a"));	
	}

	
        // Fin modificacion  
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio6.
    *
    * </br>
    *
    * Se pide anyadir el codigo necesario para realizar las siguientes tareas:
    *	Reemplazar las ocurrencias de la letra a por * y mostrar el resultado por pantalla.
    * Reemplazar las ocurrencias de la palabra Parnaso por Olimpo y mostrar en resultado por pantalla
    */
       public void ejercicio06() {
         cabecera("06", "");
      
         String cadena = "Viaje al Parnaso";
      // Inicio modificacion
	String cadena2=cadena.replace("a","*");
	System.out.println(cadena2);
	String cadena3=cadena.replace("Parnaso","Olimpo");
	System.out.println(cadena3);
      // Fin modificacion
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio7.
    *
    * </br>
    *
    * Se pide anyadir el codigo necesario para realizar las siguientes tareas:
    * Obtener la subcadena que va desde la mitad al final.
    * Obtener la subcadena que empieza en la primera j y termina antes de la primera s
    */
       public void ejercicio07() {
         cabecera("07", "");
         String cadena = "Viaje al Parnaso";
      // Inicio modificacion
	String cadena2=cadena.substring(cadena.length()/2);
	System.out.println(cadena2);
	String cadena3=cadena.substring(cadena.indexOf("j"),cadena.indexOf("s"));
	System.out.println(cadena3);
        // Fin modificacion
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio8.
    *
    * </br>
    *
    * Se pide anyadir el codigo necesario quitar los espacios sobrantes al principio y al final.
    */
       public void ejercicio08() {
         cabecera("08", "");
         String cadena = "       La Galatea   ";
      // Inicio modificacion
	String cadena2=cadena.replace(" ","");
	System.out.println(cadena2);
        // Fin modificacion
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio9.
    *
    * </br>
    *
    * Se pide anyadir el codigo necesario convertir las variables a String utilizando el metodo valueOf. Mostrar el resultado por pantalla.
    */
       public void ejercicio09() {
         cabecera("09", "");
         double numero = 1.12e12;
         boolean expresion = true;
         long enteroGrande = 1231231L;
      // Inicio modificacion
	System.out.println(String.valueOf(numero));
	System.out.println(String.valueOf(expresion));
	System.out.println(String.valueOf(enteroGrande));
        // Fin modificacion
      }
   
   /**
    * Cadenas de caracteres - Clase <<String>> - Ejercicio10.
    *
    * </br>
    *
    * Se pide compara las dos cadenas lexicograficamente y mostrar el resultado por pantalla.
    */
       public void ejercicio10() {
         cabecera("10", "");
         String cadena = "Viaje al Parnaso";
         String otraCadena = "Viaje al Olimpo";
      // Inicio modificacion
	System.out.println(cadena.compareTo(otraCadena));
        // Fin modificacion
      }
   }
