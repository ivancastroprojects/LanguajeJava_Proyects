package es.unileon.prg.tema6;
/**
 * Clase con los ejercicios correspondientes a sentencias condicionales:
 * sentencias con la instrucciin "switch".
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030103 extends Apartado {

	protected String obtenerPractica(){
		return "P-CTL";
	}

	protected String obtenerBloque() {
		return "Instruccion switch";
	}

	/**
	 * Instruccion switch - Ejercicio1.
	 *
	 * Modificar el metodo  para que al introducir un calificacion numerica  por teclado(1-10) se muestre 
	 * la calificacion de forma textual (1-4 -> Insuficiente , 5 -> Suficiente, 6 -> Bien, 
	 * 7-8 -> Notable, 9 -> Sobresaliente, 10 -> Matricula)
	 *
	 */
	public void ejercicio01() {
		cabecera("01","");

		// Inicio modificacion
		int nota=0;
		System.out.println("Introduce una nota del 1 al 10");
		nota=Teclado.readInteger();
		
		switch(nota){
			case 1:

			case 2:

			case 3:

			case 4:
				System.out.println("Insuficiente");
				break;
			case 5:
				System.out.println("Suficiente");
				break;
			case 6:
				System.out.println("Bien");
				break;
			case 7:
			case 8:
				System.out.println("Notable");
				break;
			case 9:
				System.out.println("Sobresaliente");
				break;
			case 10:
				System.out.println("Matricula");
				break;
			default:
				System.out.println("nota incorrecta");
				break;
			
		}
        // Fin modificacion
	}

	/**
	 * Instruccion switch - Ejercicio2.
	 *
	 * Modificar el metodo  para que retorne el numero de anillos que tiene un digito entero 
	 * introducido por el teclado. Se definen los anillos de un digito como el numero de circulos
	 * que tiene un digito. Ej.: 0 -> 1 anillo, 2 -> 0 anillos, 8 -> 2 anillos, etc.).
	 *
	 */
	public void ejercicio02() {
		cabecera("02", "");

		// Inicio modificacion
		int n=0,ultimoDigito;
		System.out.println("Introduce un numero");
		n=Teclado.readInteger();
		ultimoDigito=n%10;
		switch(ultimoDigito){
			case 0:
				System.out.println("Un anillo");
				break;
			case 8:
				System.out.println("Dos anillos");
				break;			
			default:
				System.out.println("Cero anillos");
		}
		// Fin modificacion
	}

	/**
	 * Instruccion switch - Ejercicio3.
	 *
	 * Modificar el metodo ejercicio3() del Apartado030103, utilizando una sentencia switch, 
	 * para que realice la misma funcionalidad que el metodo ejercicio4() del Apartado030102.
	 *
	 */
	public void ejercicio03() {
		cabecera("03", "");

		// Inicio modificacion
		int n1=0,n2=0,eleccion=0,n3=0;
		boolean aux=true;
		System.out.println("Introduzca un numero");
		n1=Teclado.readInteger();
		System.out.println("Introduzca otro numero");
		n2=Teclado.readInteger();
		
		System.out.println("Que desea hacer: \n1 - Sumar \n2 - Multiplicar \n3 - Divisores");
		eleccion=Teclado.readInteger();
		switch(eleccion){
			case 1:
				n3=n1+n2;
				System.out.println("n1+n2= "+n3);
				break;
			case 2:
				n3=n1*n2;
				System.out.println("n1*n2= "+n3);
				break;
			case 3:
				if(n1%n2==0){
					System.out.println("n1 es divisor de n2");
					aux=false;
				}
				if(n2%n1==0){
					System.out.println("n2 es divisor de n1");
					aux=false;
				}
				if(aux==true){
					System.out.println("No son divisores");
				}
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			
		}
		
		// Fin modificacion
	}

	/**
	 * Instruccion switch - Ejercicio4.
	 *
	 * Modificar el metodo ejercicio4() del Apartado030103  para que al introducir una cadena de caracteres 
	 * por teclado  se indique si el primer caracter de la cadena es una vocal escrita en minusculas, 
	 * si es una vocal escrita en mayusculas o si es otro tipo de caracter.
	 * 
	 */
	public void ejercicio04() {
		cabecera("04", "");

		// Inicio modificacion
		String cadena;
		System.out.println("Introduzca una cadena");
		cadena=Teclado.readString();
		switch(cadena.charAt(0)){
			case 'a': case 'e': case 'i': case 'o': case 'u':
				System.out.println("Vocal minuscula");
				break;
			case 'A': case 'E': case 'I': case 'O': case 'U':
				System.out.println("Vocal mayuscula");
				break;
			default:
				System.out.println("Otro caracter");
				break;
		}
		
		// Fin modificacion
	}
}
