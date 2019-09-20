package es.unileon.prg.tema7;
/**
 * Clase que representa un banco
 *
 * @author PRG
 * @version 3.0
 */
public class Banco{

	/**
	 * Numero maximo de titulares de la cuenta
	 */
	private static int NUM_MAX_CUENTAS = 50;

    /**
     * Nombre del banco
     */
    private String nombre;
    /**
     * Cuentas bancaria del banco
     */
    private CuentaBancaria[] cuentas;

    /**
     * Constructor que recibe por parametro el nombre del banco
     *
     * @param nombre Nomre del banco
     */
    public Banco(String nombre){
		// Inicio modificacion
		// Fin modificacion
    }

    /**
     * Se aniade una cuenta al banco
     *
     * @param cuenta cuenta que se desea incluir en el banco
     * @return <code> true </code> Proceso correcto <code> false </code> En caso contrario
     */
    public boolean anyadir(CuentaBancaria cuenta) {
		// Inicio modificacion
    	return false;
		// Fin modificacion
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
	public String toString(){
		// Inicio modificacion
    	return null;
		// Fin modificacion
    }
}
