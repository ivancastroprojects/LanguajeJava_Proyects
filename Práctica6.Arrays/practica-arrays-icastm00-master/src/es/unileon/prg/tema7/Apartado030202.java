package es.unileon.prg.tema7;
/**
 * Clase con los ejercicios correspondientes al manejo de arrays.
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030202 extends Apartado {

	@Override
	protected String obtenerPractica(){
		return "P-ARR";
	}

	@Override
	protected String obtenerBloque() {
		return "Manejo de arrays";
	}

	/**
	 * Manejo de arrays - Ejercicio1.
	 *
	 * La copia por referencia implica trabajar sobre las mismas posiciones
	 * de memoria, de tal forma que los cambios realizados en la copia afectan
	 * a la array original.
	 *
	 * Se pide:
	 *
	 * <ul>
	 * <li> Compilar y ejecutar el metodo
	 * <li> Analizar los resultados obtenidos
	 * <li> Explicar en el fichero LEEME.txt el porque de los resultados
	 * </ul>
	 */
	public void ejercicio01() {
		cabecera("01", "Copia por referencia");

		// Inicio modificacion
		EjemploCodigo objeto = new EjemploCodigo();
		objeto.copiarOpcion1();
        // Fin modificacion
	}

	/**
	 * Manejo de arrays - Ejercicio2.
	 *
	 * La copia por valor implica duplicar la informacion en posiciones de
	 * memoria distintas. En este caso, los cambios realizados en la copia no
	 * afectan a la array original.
	 *
	 * Se pide:
	 *
	 * <ul>
	 * <li> Compilar y ejecutar el metodo
	 * <li> Analizar los resultados obtenidos
	 * <li> Explicar en el fichero LEEME.txt el porque de los resultados
	 * </ul>
	 */
	public void ejercicio02() {
		cabecera("02","Copia por valor");

		// Inicio modificacion
		EjemploCodigo objeto = new EjemploCodigo();
		objeto.copiarOpcion2();
        // Fin modificacion
	}

	/**
	 * Manejo de arrays - Ejercicio3.
	 *
	 * El paso de parametros en Java es siempre por valor; es decir, se realiza
	 * una copia de la variable al argumento recibido, de manera que se trabaja
	 * sobre posiciones de memoria distintas. Dados los metodos pasarParametros()
	 * y recibirParametros() de la clase PruebaCodigo, se pide:
	 *
	 * <ul>
	 * <li> Compilar y ejecutar el metodo
	 * <li> Analizar los resultados obtenidos
	 * <li> Explicar en el fichero LEEME.txt el porque de los resultados
	 * </ul>
	 */
	public void ejercicio03() {
		cabecera("03", "Paso de parametros");

		// Inicio modificacion
		EjemploCodigo objeto = new EjemploCodigo();
		objeto.pasarParametros();
        // Fin modificacion
	}

	/**
	 * Manejo de arrays - Ejercicio4.
	 *
	 * El paso de parametros en Java es siempre por valor; es decir, se realiza
	 * una copia de la variable al argumento recibido, de manera que se trabaja
	 * sobre posiciones de memoria distintas. Dados los metodos pasarParametrosErroneo()
	 * y recibirParametrosErroneo() de la clase PruebaCodigo, se pide:
	 *
	 * <ul>
	 * <li> Compilar y ejecutar el metodo
	 * <li> Analizar los resultados obtenidos
	 * <li> Explicar en el fichero LEEME.txt el porque de los resultados
	 * </ul>
	 */
	public void ejercicio04() {
		cabecera("04", "Paso de parametros erroneo");

		// Inicio modificacion
		EjemploCodigo objeto = new EjemploCodigo();
		objeto.pasarParametrosErroneo();
		// Fin modificacion
	}

	/**
	 * Manejo de arrays - Ejercicio5.
	 *
	 * Modificar las clases Banco, CuentaBancaria y Titular de acuerdo al siguiente
	 * enunciado:
	 *
	 * El banco "ADA Money S.A." gestiona 50 cuentas bancarias, cada una de las cuales
	 * tendra como minimo un titular, considerado como titular principal. Al mismo tiempo,
	 * la cuenta puede tener varios titulares hasta un maximo de 5. Un titular viene
	 * identificado por su nombre, edad, NIF y credito.
     * Para sacar dinero de la cuenta el titular principal debe ser mayor de edad, y la
     * cuenta debe tener credito suficiente para cubrir la cantidad deseada.
	 */
	public void ejercicio05() {
		cabecera("05", "Problema");

		// Inicio modificacion
		// DESCOMENTAR
//		Banco miBanco = new Banco("ADA Money S.A");
//
//		CuentaBancaria cuenta1 = new CuentaBancaria(1000);
//		cuenta1.anyadir(new Titular("Pedro",35,"115458222D"));
//		cuenta1.anyadir(new Titular("Ana",34,"577225588G"));
//		miBanco.anyadir(cuenta1);
//
//		CuentaBancaria cuenta2 = new CuentaBancaria(0);
//		cuenta2.anyadir(new Titular("Carlos",18,"74992586Y"));
//		miBanco.anyadir(cuenta2);
//
//		System.out.println(miBanco);
		// Fin modificacion
	}
}
