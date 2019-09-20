package es.unileon.prg.tema7;
/**
 * Clase que representa un titular de una cuenta bancaria
 *
 * @author PRG
 * @version 3.0
 */
public class Titular{
    /**
     * Nif del titular
     */
    private String nif;
    /**
     * Nombre del titular
     */
    private String nombre;
    /**
     * Edad del titular
     */
    private int edad;
    /**
     * Cantidad que le permite el banco tener al descubierto
     */
    private int credito;

    /**
     * Constructor que recibe todos los datos necesarios de una persona
     * @param nif Nif del titular
     * @param nombre Nombre del titular
     * @param edad Edad del titular
     * @param credito Cantidad que le permite el banco tener al descubierto
     */
    public Titular (String nif,
	     String nombre,
	     int edad,
	     int credito){
		// Inicio modificacion
    	this.nif = nif;
    	this.nombre = nombre;
    	this.edad = edad;
    	this.credito = credito;
		// Fin modificacion
    }

    /**
     * Devuelve el nif del titular
     *
     * @return el nif del titular
     */
    public String obtenerNif (){
		// Inicio modificacion
    	return this.nif;
		// Fin modificacion
    }

    /**
     * Devuelve el nombre del titular
     *
     * @return el nombre del titular
     */
    public String obtenerNombre (){
		// Inicio modificacion
    	return this.nombre;
		// Fin modificacion
    }

    /**
     * Devuelve la edad del titular
     *
     * @return la edad del titular
     */
    public int obtenerEdad (){
		// Inicio modificacion
    	return this.edad;
		// Fin modificacion
    }

    /**
     * Devuelve la credito del titular
     *
     * @return la credito del titular
     */
    public int obtenerCredito (){
		// Inicio modificacion
        	return credito;
		// Fin modificacion
    }

    /**
     * Comprueba si el titular es mayor de edad
     * @return verdadero si el titular es mayor de edad y falso en
     * caso contrario
     */
    public boolean esMayorEdad(){
		// Inicio modificacion
    	if(this.edad>18)
    		return true;
		else return false;
		// Fin modificacion

    }

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
	public String toString(){
		// Inicio modificacion
    	System.out.println("Titular: " + this.nombre + "," + this.credito);
		// Fin modificacion
    	return null;
    }
}
