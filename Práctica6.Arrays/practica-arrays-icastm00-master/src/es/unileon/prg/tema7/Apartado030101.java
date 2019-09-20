package es.unileon.prg.tema7;
/**
 * Clase con los ejercicios correspondientes a arrays: gestion de memoria.
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030101 extends Apartado {

	@Override
	protected String obtenerPractica(){
		return "P-ARR";
	}

	@Override
	protected String obtenerBloque() {
		return "Gestion de memoria";
	}

    private String[] matrizCadenas;;
	private String[] otraMatriz;
	private String[][] tablaCadenas;

	/**
	 * Gestion de memoria - Ejercicio1.
	 *
	 * Se pide completar el metodo para que, una vez ejecutado, la situacion
	 * en memoria sea igual a la representada en la figura.
	 */
	public void ejercicio01() {
		// Inicio modificacion
		matrizCadenas = new String [1];
        // Fin modificacion

        System.out.println("matrizCadenas => "+matrizCadenas);
		System.out.println("matrizCadenas[0] => "+matrizCadenas[0]);
	}

	/**
	 * Gestion de memoria - Ejercicio2.
	 *
	 * Se pide completar el metodo para que, una vez ejecutado, la situacion
	 * en memoria sea igual a la representada en la figura.
	 */
	public void ejercicio02() {
		ejercicio01();

		// Inicio modificacion
		matrizCadenas = new String [4];
		matrizCadenas[0] = "HOLA";
        // Fin modificacion

        System.out.println("matrizCadenas => "+matrizCadenas);
		System.out.println("matrizCadenas[0] => "+matrizCadenas[0]);
		System.out.println("matrizCadenas[1] => "+matrizCadenas[1]);
		System.out.println("matrizCadenas[2] => "+matrizCadenas[2]);
		System.out.println("matrizCadenas[3] => "+matrizCadenas[3]);
	}

	/**
	 * Gestion de memoria - Ejercicio3.
	 *
	 * Se pide completar el metodo para que, una vez ejecutado, la situacion
	 * en memoria sea igual a la representada en la figura.
	 */
	public void ejercicio03() {
		ejercicio02();

		// Inicio modificacion
		otraMatriz = new String [3];
		otraMatriz[0] ="PRACTICA ";
		otraMatriz[1] ="DE ";
		otraMatriz[2] ="MATRICES";

		// Fin modificacion

		System.out.println("otraMatriz => "+otraMatriz);
		System.out.println("otraMatriz[0] =>"+otraMatriz[0]);
		System.out.println("otraMatriz[1] =>"+otraMatriz[1]);
		System.out.println("otraMatriz[2] =>"+otraMatriz[2]);
		// DESCOMENTAR
		//		System.out.println("temporal => " + temporal);
	}

	/**
	 * Gestion de memoria - Ejercicio4.
	 *
	 * Se pide completar el metodo para que, una vez ejecutado, la situacion
	 * en memoria sea igual a la representada en la figura.
	 */
	public void ejercicio04() {
		ejercicio03();

		// Inicio modificacion
		tablaCadenas = new String [3][];
		tablaCadenas[0] = matrizCadenas;
		tablaCadenas[1] = otraMatriz;
		tablaCadenas[2] = null;
		// Fin modificacion

        System.out.println("tablaCadenas    => "+tablaCadenas);
        System.out.println("tablaCadenas[0] => "+tablaCadenas[0]);
        System.out.println("tablaCadenas[1] => "+tablaCadenas[1]);
        System.out.println("tablaCadenas[2] => "+tablaCadenas[2]);
	}

	/**
	 * Gestion de memoria - Ejercicio5.
	 *
	 * Se pide completar el metodo para que, una vez ejecutado, la situacion
	 * en memoria sea igual a la representada en la figura.
	 */
	public void ejercicio05() {
		ejercicio04();

		// Inicio modificacion
		tablaCadenas[0][0] = "ADIOS";
		tablaCadenas[1][0] = "PRUEBA";
		tablaCadenas[1][1] = "DE ";
		tablaCadenas[1][2] = "MATRICES ";
        // Fin modificacion

        System.out.println("tablaCadenas[0][0] => "+tablaCadenas[0][0]);
        System.out.println("tablaCadenas[0][1] => "+tablaCadenas[0][1]);
        System.out.println("tablaCadenas[1][0] => "+tablaCadenas[1][0]);
        System.out.println("tablaCadenas[1][1] => "+tablaCadenas[1][1]);
        System.out.println("tablaCadenas[1][2] => "+tablaCadenas[1][2]);
	}
}
