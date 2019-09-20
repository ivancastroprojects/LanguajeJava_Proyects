package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 5A
 * @version 1.0
 */
public class Rides{
	/**
	 * Lista de Ride que contiene Rides
	 */
	private Ride[] arrayRides;
	
	/**
	 * Indica el primer null
	 */
	private int next; 
	
	/**
	 * Logger de la clase Rides
	 */
	private static final Logger logRides = LogManager.getLogger(Rides.class);
	
	
	public Rides(int max_Rides_For_Parent) {
		arrayRides = new Ride[max_Rides_For_Parent];
		this.next = 0;
	}

	/**
	 * Devuelve un ride, pasandole como parametro su indice en el array
	 * @param i
	 * @return Ride
	 */
	public Ride getRide(int i) {
		return this.arrayRides[i];
	}
	
	/**
	 ** Metodo para anhadir un Ride a la lista de Rides, la lista es un array de objetos Ride. 
	 ** Se comprueba que exista, si existe, se dispara una excepcion que indica que el Ride ya existe.
	 ** Si no existe lo anhade.
	 ** Tanto para comprobar si existe como si no, se hace mediante un if que comprueba que los parametros del lugar de comienzo
	 ** del Ride y el lugar donde termina el Ride.
	 **/
	public boolean add(Ride ride) throws BlablakidException {
		
		
    	if (exists(ride.getWhereStartRide(), ride.getWhereEndRide()) == -1) {
    		
    		if (arrayRides[arrayRides.length-1] == null) {
    			arrayRides[next] = ride;
        		next++;
        		
    			logRides.info("Se ha anhadido el ride");
    		} else {
    			logRides.info("La lista de rides esta llena");
    			throw new BlablakidException("La lista de rides esta llena");
    		}
    		
    	} else {
    		logRides.info("El ride ya existe");
    		throw new BlablakidException("El ride ya existe");
    	}
    	return true;
	}

	
	/**
	 ** Metodo para borrar un Ride del array de Rides. Este metodo recibe como parametro un objeto de la clase Ride el cual se quiere
	 ** eliminar. 
	 **/
	
	public boolean remove(String rideStart, String rideEnd) throws BlablakidException{
		int i = 0;
    	int j = 0;    	
    	
    	
    	if (exists(rideStart, rideEnd) != -1) {
    		
    		while (i < arrayRides.length) {
        		if (arrayRides[i] != null) {    			
        			if (arrayRides[i].getWhereStartRide().equals(rideStart) && arrayRides[i].getWhereEndRide().equals(rideEnd)) {
        				arrayRides[i] = null;
        				next--;
        				
        				i = arrayRides.length;
        				logRides.info("Se ha eliminado el ride");
        			
            		}
        		}
        		
        		i++;
        	}
    		
    		//Ordeno el array para quitar nulls de por medio
    		/*Mediante un bucle while se recorre el array y cada vez que encuentra una posicion con un valor null*/
    		/*Lo desplazaria el fin de esto es dejar los null al final.*/
    		while (j < arrayRides.length) {
    			if (arrayRides[j] == null && j != arrayRides.length-1) {
    				arrayRides[j] = arrayRides[j+1];
    				arrayRides[j+1] = null;
    			}
    			j++;
    		}
    		
    	} else {
    		logRides.info("El ride no existe");
    		throw new BlablakidException("El ride no existe");
    	}
    	return true;
	}
	

	/**
	 ** Metodo search para buscar un Ride en el array de Rides. 
	 ** Busca el ride en Rides, se le pasa como parametros el lugar donde empieza y donde termina el trayecto.
	 ** Si lo encuentra retorna ese ride, si no lo encuentra se retorna un null.
	 **/
	
	
	public Ride search(String whereStartRide, String whereEndRide) throws BlablakidException {
		Ride r = null;
		
		if (exists(whereStartRide, whereEndRide) != -1) {
			r = arrayRides[exists(whereStartRide, whereEndRide)];
		} else {
			r = null;
		}
		
		return r;
	}
	
	/**
	 ** Metodo int. Este metodo busca dentro del array de Rides si el ridPasado como parametro existe
	 ** Si existe, devuelve la posicion en la que esta.
	 **/
	public int exists(String whereStartRide, String whereEndRide) {
		int i = 0, salida = -1;

        while(i < arrayRides.length) {
            if(arrayRides[i] != null) {
                if(arrayRides[i].getWhereStartRide().equals(whereStartRide) && arrayRides[i].getWhereEndRide().equals(whereEndRide)) {
                    salida = i;
                }
            }
            i++;
        }
        return salida;
	}
	
	/**
	*
	* Devuelve la lista de rides de un dia.
	* Retorna un String.
	*/
	public String toString() {
		StringBuffer salida = new StringBuffer();
		
		int i = 0;
		
		while (i < arrayRides.length ) {
			if (arrayRides[i] != null) {
				salida.append(arrayRides[i].getWhereStartRide() + " > " + arrayRides[i].getWhereEndRide() + " : " + arrayRides[i].getStartRide().toString() + 
						"/" + arrayRides[i].getEndRide().toString() + "\n");
				logRides.info("Mostrando informacion para el ride " +i);
			}
			i++;
		}
		
		return salida.toString();
    }
	
}