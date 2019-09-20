package es.unileon.prg.tema7;
/**
 * Clase que representa una cuenta bancaria
 *
 * @author PRG
 * @version 3.0
 */
public class CuentaBancaria{

	/**
	 * Numero maximo de titulares de la cuenta
	 */
	private static int NUM_MAX_TITULARES = 5;

    /**
     * Saldo de la cuenta
     */
    private int saldo;
    /**
     * Titulares de la cuenta
     *
     * @see Titular
     */
    private Titular[] titulares;

    /**
     * Constructor que recibe por parametro todos los datos necesarios
     * para crear un objeto CuentaBancaria
     *
     * @param saldo Saldo inicial de la cuenta
     * @param titular Titular principal de la cuenta
     */
    public CuentaBancaria (int saldo, Titular titular){
        this.saldo = saldo;
        this.titulares = new Titular[NUM_MAX_TITULARES];
        this.titulares[0] = titular;
    }

    /**
     * Devuelve el saldo de la cuenta
     *
     * @return valor del saldo de la cuenta
     */
    public int obtenerSaldo (){
        return saldo;
    }

    /**
     * Devuelve el titular principal de la cuenta. Se toma como
     * titular principal el primero de la lista.
     *
     * @return Titular principal de la cuenta
     */
    public Titular obtenerTitularPrincipal() {
		// Inicio modificacion
    	return titulares[0];
		// Fin modificacion
	}

    /**
     * Devuelve el credito del titular principal
     *
     * @return valor del credito del titular principal
     */
    int obtenerCredito (){
		// Inicio modificacion
    	return titulares[0].obtenerCredito();
		// Fin modificacion
    }

    /**
     * Se aniade un titular a la cuenta
     *
     * @param titular nuevo titular de la cuenta bancaria
     * @return <code> true </code> Proceso correcto <code> false </code> En caso contrario
     */
    public boolean anyadir(Titular titular) {
		// Inicio modificacion
    	for(int i=0; i<titulares.length; i++) {
    		if (titulares[i] == null) 
    			titulares[i] = titular;
    			return true;
    	}
    	return false;
		// Fin modificacion
	}

    /**
     * Permite ingresar una determinada cantidad en la cuenta
     *
     * @param cantidad dinero a ingresar
     */
    public void ingresar (int cantidad){
		System.out.println("Vamos a ingresar interes por valor " + cantidad);
        System.out.println("Vamos a ingresar " + cantidad + " ?...");
        saldo = saldo + cantidad;
        System.out.println("...ya hemos ingresado " + cantidad + " ?"+ saldo);
    }

    /**
     * Permite sacar una determinada cantidad de la cuenta, siempre y
     * cuando el titular principal de la cuenta sea mayor de edad y el saldo
     * mas el credito del titular principal sea suficiente para esa cantidad
     *
     * @param cantidad dinero a sacar
     */
    public void sacar (int cantidad){
		// Inicio modificacion
    	for(int i=0; i<titulares.length; i++) {
        	if(titulares[i].esMayorEdad() == true)
        		if((saldo + titulares[0].obtenerCredito()) > cantidad)
        			saldo -= cantidad;
    	}
		// Fin modificacion
    }

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
	public String toString(){
		StringBuffer salida = new StringBuffer();

		salida.append("\n");
		salida.append("Saldo  : " + saldo + "\n");

		int contador = 0;
		while ((contador < titulares.length) && (titulares[contador] != null)) {
			salida.append(titulares[contador]);
			contador++;
		}

		return salida.toString();
    }
}

