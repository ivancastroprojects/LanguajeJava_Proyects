package es.unileon.prg.tema6;
/**
 * Clase con los ejercicios correspondientes a sentencias de repeticion:
 * sentencias con la instruccion "while".
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030202 extends Apartado {

	protected String obtenerPractica(){
		return "P-CTL";
	}

	protected String obtenerBloque() {
		return "Instruccion while";
	}

	/**
	 * Instruccion while - Ejercicio1.
	 *
	 * Programar el codigo que lea 10 numeros enteros por teclado y diga cual es el mayor 
	 * y el menor de todos ellos (similar al ejercicio05() de la clase Apartado030201 pero 
	 * utilizando la sentencia while)
	 *
	 */
	public void ejercicio01() {
		cabecera("01","");

		// Inicio modificacion
		int mayor=0,menor=999999;
		int[] numeros=new int[10];
		int i=0;
		
		System.out.println("Introduce 10 numeros");
		while(i<10){
			numeros[i]=Teclado.readInteger();
			i++;
		}
		
		for(i=0;i<10;i++){
			if(mayor<numeros[i]){
				mayor=numeros[i];
			}
			if(menor>numeros[i]){
				menor=numeros[i];
			}
		}
		
		System.out.println("El mayor es = "+mayor+" y el menor es = "+menor);		
		
		
					
        // Fin modificacion
	}

	/**
	 * Instruccion while - Ejercicio2.
	 *
	 * Programar el  codigo que lea numeros enteros hasta que el usuario introduzca un valor igual 
	 * a cero  o hasta que el usuario introduzca dos veces seguidas el mismo numero.
	 */
	public void ejercicio02() {
		cabecera("02", "");

		// Inicio modificacion
		int actual, anterior;
		boolean repetido=false;
		
		System.out.println("Introduce numeros hasta que introduzcas dos iguales o un 0: ");
		actual=Teclado.readInteger();
		anterior=actual;
		
		while((actual!=0 && !repetido)){
			System.out.println("Introduce numeros hasta que introduzcas dos iguales o un 0: ");
			actual=Teclado.readInteger();
			if(actual==anterior){
				repetido=true;
			}
			anterior=actual;
		}
		// Fin modificacion
	}

	/**
	 * Instruccion while - Ejercicio3.
	 *
	 * Programar el codigo  que sume los numeros pares por un lado y los impares por otro  entre
	 * dos numeros enteros introducidos por el usuario.
	 * 
	 * Nota: similar al ejercicio06() de la clase Apartado030201 pero utilizando la sentencia while
	 * y sin suponer que el primer numero es siempre par)
	 * 
	 * Nota : Los numeros enteros se manejaran como objetos la clase NumeroEntero
	 * 
	 */
	public void ejercicio03() {
		cabecera("03", "");

		// Inicio modificacion
		int n1=0, n2=0;
		int sumaPares=0, sumaImpares=0;
		int par, impar;
		
		System.out.println("Introduce un numero:");
		n1=Teclado.readInteger();

		System.out.println("Introduce otro numero:");
		n2=Teclado.readInteger();
		
		if (n1%2==0){
			par=n1;
			impar=n1+1;
		}
		else{
			impar=n1;
			par=n1+1;
		}
		
		while ((par<=n2) || (impar<=n2)) {
			if (par<=n2)
				sumaPares=sumaPares+par;
			if (impar<=n2)
				sumaImpares=sumaImpares+impar;
			
			par=par+2;
			impar=impar+2;
		}
		
		System.out.println("La suma es de los pares es-> "+sumaPares);
	System.out.println("La suma es de los impares es-> "+sumaImpares);		
		
		// Fin modificacion
	}

	/**
	 * Instruccion while - Ejercicio4.
	 *
	 * Programar el codigo  que calcule la media, de una serie de numeros introducidos por teclado. 
	 * La serie acaba cuando se introduce el tercer 5. Los 5 introducidos se procesaran como numeros 
	 * de la serie, es decir, intervendran a la hora de calcular los valores pedidos.
	 * 
	 */
	public void ejercicio04() {
		cabecera("04", "");

		// Inicio modificacion
		// Fin modificacion
	}

	/**
	 * Instruccion while - Ejercicio5.
	 *
	 * Modificar la clase NumeroEntero definiendo e implementando los siguientes metodos
	 * <ul>
	 * <li> int numeroDigitos():  retornara el numero de digitos del  numero.
	 * <li>	int inverso(): retornara el inverso del numero (Ej.: 23 -> 32)
	 * <li>	booleam  esCapicua(): retorna si el numero es o no capicua.
	 * </ul>
	 * 
	 * Probar los nuevos metodos de la clase numero en el metodo ejercicio05.
	 *
	 */
	public void ejercicio05() {
		cabecera("05","");

		// Inicio modificacion
		int n;
		NumeroEntero numeroEntero;
		
		System.out.println("Introduce un numero entero:");
		n=Teclado.readInteger();
		
		numeroEntero=new NumeroEntero(n);
		
		System.out.println();
		System.out.println("Numero de digitos de "+numeroEntero+" -> "+numeroEntero.numeroDigitos());
		System.out.println("El inverso de "+numeroEntero+" -> "+numeroEntero.inverso());
		if (numeroEntero.esCapicua())
			System.out.println(numeroEntero+" es capicua");
		else
System.out.println(numeroEntero+" no es capicua");		
        // Fin modificacion
	}

	/**
	 * Instruccion while - Ejercicio6.
	 * 
	 * Teniendo en cuenta el siguiente diagrama de clases del enunciado de la practica
	 * 
	 * <ul>
	 * <li> La clase Partido representa partidos de tenis en los que intervienen dos jugadores
	 * <li> Cada jugador tiene un nombre y una puntuacion en el ranking de la ATP
	 * </ul>
	 * 
	 * Se pide:
	 * 
	 * <ul>
	 * <li>	Consultar el codigo de las clase Partido y Jugador
	 * <li>	Implementar el metodo jugar de la clase Partido
	 * <li>	Simulara que se juega el partido entre los dos jugadores generando el ganador de forma aleatoria
	 * <li>	El jugador con mayor puntuacion en la ATP tendra mayor posibilidad de ganar.
	 * <li> El ganador del partido aumentara en 1 punto su puntuacion en el ranking.
	 * <li>	Nota 1:
	 * <ul>	Una  forma de generar el ganador puede ser:
	 * <li>	
	 * <li>	resultado1= Math.random() * puntos_jugador1;
	 * <li> resultado2= Math.random() * puntos_jugador2;
	 * <li>  el que tenga mayor resultado ganara el partido
	 * </ul>
	 * <li>Nota 2:
	 * <ul>
	 * <li>Hay que tener en cuenta que el resultado puede ser empate, en este caso se volveran a generar resultados hasta que exista un ganador.
	 * <li>
	 * </ul>
	 * </ul>
	 *
	 */
	
	public void ejercicio06() {
		cabecera("06", "");
		
		Jugador j1=new Jugador("Federer",5);
        Jugador j2=new Jugador("Nadal",4);
        
        
        System.out.println("Los Jugadores del Partido son " + j1.getNombre() + " y "+j2.getNombre());
        
        Partido partido=new Partido(j1,j2);
        partido.jugar();
        
        System.out.println("El ganador es: "+ partido.ganador().getNombre());
	}
}
