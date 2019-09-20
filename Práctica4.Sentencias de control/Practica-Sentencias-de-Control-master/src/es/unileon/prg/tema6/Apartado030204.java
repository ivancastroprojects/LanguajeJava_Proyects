package es.unileon.prg.tema6;
/**
 * Clase con los ejercicios correspondientes a sentencias condicionales
 * y de repeticion anidadas.
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030204 extends Apartado {

	protected String obtenerPractica(){
		return "P-CTL";
	}

	protected String obtenerBloque() {
		return "Sentencias anidadas";
	}

	/**
	 * Sentencias anidadas - Ejercicio1.
	 *
	 * Programar el codigo que muestre todos los numeros perfectos comprendidos 
	 * entre dos numeros n1 y n2 introducidos por teclado
	 */
	public void ejercicio01() {
		cabecera("01","");

		// Inicio modificacion
		int n1, n2;
		
		int numero;
		int sumaDivisores,divisor;
		
		System.out.print("Introduce el numero 1:");
		n1=Teclado.readInteger();

		System.out.print("Introduce el numero 2:");
		n2=Teclado.readInteger();
		
		System.out.println();
		for(numero=n1;numero<=n2;numero++){
			
			sumaDivisores=0;
			divisor=1;
			do{
				
				if(numero % divisor==0)
					sumaDivisores=sumaDivisores+divisor;
					
				divisor++;
				
			
			}while (divisor<numero);
			
			if (numero==sumaDivisores){
				System.out.println("El numero "+numero+ " es perfecto");
			}
			
}		
        // Fin modificacion
	}

	/**
	 * Sentencias anidadas  - Ejercicio2.
	 *
	 * Un banco quiere implementar una aplicacion para detectar cheques falsificados. 
	 * Un cheque es falso si en su numero (compuesto por 10 digitos) hay: 3 o mas ceros seguidos 
	 * y/o cuatro o mas numeros distintos de cero seguidos.
	 * 
	 * Completar la clase Cheque para que detecte los cheques falsos.
	 * 
	 * Probar la clase Cheque  sobre el metodo ejercicio02() de la clase Apartado030204.
	 * 
	 */
	public void ejercicio02() {
		cabecera("02", "");

		Cheque cheque=null;
		
		//Modificar el numero de cheque para probar
		//cheque=new Cheque("1000988887");    
        //cheque=new Cheque("1010098888");
        cheque=new Cheque("1009808880");   
        
       
         if (cheque.esFalso()== true)
        	 System.out.println("El cheque es falso");
         else
             System.out.println("Elche no es falso");
	}

	/**
	 * Sentencias anidadas  - Ejercicio3.
	 *
	 * Programar el codigo que genere dado un tamanio (entero) introducido por teclado los siguientes dibujos:
	 * 
	 * Ejemplo de ejecucion  
	 * 
	 * Introduce el tamanio: 4
	 * 	Triangulo
	 * 	*
	 * 	**
	 * 	***
	 * 	****
	 * 	Cuadrado Relleno
	 * 	****
	 * 	****
	 * 	****
	 *  ****
	 *  
	 *  Cuadrado vacio
	 *  ****
	 *  *  *
	 *  *  *
	 *  ****
	 * 
	 * 
	 */
	public void ejercicio03() {
		cabecera("03", "");

		// Inicio modificacion
		int tam;
		
		System.out.print("Introduce el tamanio:");
		tam=Teclado.readInteger();
		
			
		System.out.print("\nTriangulo:\n");
		
		for (int i=0;i<tam;i++){
			for(int j=0;j<i+1;j++)
				System.out.print('*');
			System.out.println();
		}
		
		System.out.print("\nCuadrado relleno:\n");
		
		for (int i =0;i<tam;i++){
			for(int j=0;j<tam;j++)
				System.out.print('*');
			System.out.println();
		}
		
		
		System.out.print("\nCuadrado vacio:\n");
		
		for (int i =0;i<tam;i++){
			for(int j=0;j<tam;j++){
				if ((i==0) || (j==0))
					System.out.print('*');
				else if ((i==tam-1) || (j==tam-1))
					System.out.print('*');
				else
					System.out.print(' ');
			}
			
			System.out.println();
		}		
		// Fin modificacion
	}

	/**
	 * Sentencias anidadas  - Ejercicio4.
	 *
	 * 
	 * Programar el codigo que plantee un pequenio juego al usuario.
	 * <ul>
	 * <li>	El ordenador pensara un numero entre 1 y 100 (generar un numero aleatorio)
	 * <li>	El usuario dispondra de 5 intentos para acertar el numero.
	 * <li>	Por cada intento el ordenador indicara si el numero buscado es menor o mayor 
	 * 		 al introducido y se el usuario ha acertado.
	 * <li> Cuando se acierte el numero correcto debera mostrarse cuantos ensayos han sido 
	 * 		necesarios hasta llegar a la solucion.
	 * <li>	Una vez hecho esto debera preguntar si se desea empezar de nuevo con otro numero o 
	 * 		si desea terminar el juego.
	 *</ul>
	 * 
	 */
	public void ejercicio04() {
		cabecera("04", "");

		// Inicio modificacion
		int numero,numeroSecreto;
		int N_MAXIMO_INTENTOS=5;
		int intentos=0;
		boolean acierto,jugar;
		int opcion;
		
		jugar=true;
		
		do{
			//Ordenador piensa el numero
			numeroSecreto=(int)(Math.random()*100);
			System.out.println("\nHe pensado en numero entre 1 y 100 .....");
			System.out.println("Vamos a jugar ...\n");			
			acierto=false;
			intentos=0;
			
			do
			{
				System.out.print("Cual es el numero (del 1 al 100)): ");
				numero=Teclado.readInteger();
				intentos++;
				if (numero==numeroSecreto)
					acierto=true;
				else if (numero <numeroSecreto)
					System.out.println("El numero secreto es mayor que el que has introducido");
				else
					System.out.println("El numero secreto es menor que el que has introducido");
				
			}while ((!acierto) && (intentos<N_MAXIMO_INTENTOS));
			
			System.out.println();
			
			if (acierto){
				System.out.println("Has acertado el numero es "+numeroSecreto);
				System.out.println("Numero de intentos "+intentos);
			}
			else{
				System.out.println("Has agotado los intentos");
				System.out.println("El numero secreto es "+numeroSecreto);
			}
			
			
			System.out.print("\n\nQuieres volver a jugar (1 - SI, 2- NO): ");
			opcion=Teclado.readInteger();
			if (opcion!=1)
				jugar=false;
	
		}while(jugar);
		// Fin modificacion
	}
}
