package es.unileon.prg.tema6;
/**
 * Clase con los ejercicios correspondientes a sentencias de repeticion:
 * sentencias con la instruccion "do-while".
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030203 extends Apartado {

	protected String obtenerPractica(){
		return "P-CTL";
	}

	protected String obtenerBloque() {
		return "Instruccion do-while";
	}

	/**
	 * Instruccion do-while - Ejercicio1.
	 *
	 * Programar el codigo que ofrezca un menu de opciones al usuario  hasta que seleccione la opcion salir.
	 * 
	 */
	public void ejercicio01() {
		cabecera("01","");

		// Inicio modificacion
		int eleccion=0;
		do{
			System.out.println("1.-Opcion1  2.-Opcion2  3.-Opcion3  4.-Salir");
			eleccion=Teclado.readInteger();
		}while(eleccion!=4);
        // Fin modificacion
	}

	/**
	 * Instruccion do-while - Ejercicio2.
	 *
	 * Programar el  codigo que lea numeros enteros hasta que el usuario introduzca un valor igual a cero 
	 * o hasta que el usuario introduzca dos veces seguidas el mismo numero.
	 * 
	 * Similar al  ejercicio02() de la clase Apartado030202 pero empleando la sentencia do-while).
	 *
	 */
	public void ejercicio02() {
		cabecera("02", "");

		// Inicio modificacion
		boolean repetido=false;
		int actual, anterior=0;
		
		do{
			System.out.println("Introduce un numero:");
			actual=Teclado.readInteger();
			if (actual==anterior)
				repetido=true;
			anterior=actual;
		}while ((actual!=0) && !repetido);		
		// Fin modificacion
	}

	/**
	 * Instruccion do-while - Ejercicio3.
	 *
	 * Programar el codigo que lea la base y la altura de un numero indeterminado de rectangulos y
	 * cree los correspondientes objetos de tipo Rectangulo. Para cada rectangulo el programa mostrara 
	 * por pantalla su area y si es un cuadrado o un rectangulo. El programa terminara cuando alguno 
	 * de los lados del cuadrilatero sea menor o igual que  0.
	 * 
	 */
	public void ejercicio03() {
		cabecera("03", "");

		// Inicio modificacion
		Rectangulo rectangulo=null;
		int base, altura;
				
		do{
			System.out.print("Introduce la base del rectangulo :");
			base=Teclado.readInteger();
			System.out.print("Introduce la altura del rectangulo :");
			altura=Teclado.readInteger();
			rectangulo=new Rectangulo(base,altura);
			
			System.out.println(rectangulo);
			System.out.println("Area: "+rectangulo.getArea());
			System.out.println();
		}while (base>0 && altura>0);		
		// Fin modificacion
	}

	/**
	 * Instruccion do-while - Ejercicio4.
	 *
	 * Programar el codigo que dado un numero entero introducido por teclado indique si es o no perfecto.
	 * Un numero entero es perfecto si es igual a la suma de los sus divisores positivos menores que el.
	 * Ejemplos
	 * <ul>
	 * <li>6 es perfecto porque
	 * <ul>
	 * <li>	Sus divisores menores que el  son 1, 2, 3  y
	 * <li> 1 + 2 + 3 = 6;
	 * </ul>
	 * <li> 8 no es perfecto porque
	 * <ul>
	 * <li>	Sus divisores menores que el son 1, 2,4  y
	 * <li> 1+2+4  !=  8
	 * </ul>
	 * </ul>
	 * 
	 */
	public void ejercicio04() {
		cabecera("04", "");

		// Inicio modificacion
		int numero;
		int sumaDivisores,divisor;
		
		
		System.out.print("Introduce un numero:");
		numero=Teclado.readInteger();
		
		
		System.out.print("\nDivisores: ");
		sumaDivisores=0;
		divisor=1;
		do{
			
			if(numero % divisor==0){
				sumaDivisores=sumaDivisores+divisor;
				System.out.print(divisor+" ");
			}
			divisor++;
			
		
		}while (divisor<numero);
		
		
		System.out.println("\nSumaDivisores = "+sumaDivisores);
		
		if (numero==sumaDivisores){
			System.out.println("El numero "+numero+ " es perfecto");
		}else{
			System.out.println("El numero "+numero+ " no es perfecto");	
		}	
		// Fin modificacion
	}
}
