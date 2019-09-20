package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author KevinSanchez
 * @version 1.0
 */

public class Kids{
	
	/**
	 * Contiene todos los Kids
	 */
	private Kid[] arrayKids;
	
	/**
	 * Apunta al primer null
	 */
	private int next;
	
	/**
	 * Logger de la clase Kids
	 */
	private static final Logger logKids = LogManager.getLogger(Kids.class);	
	
   /**
	*
	* Constructor de la clase Kids
	* @param maxKids
	* 
	*/
	public Kids(int maxKids) {	  
		arrayKids = new Kid[maxKids];
		this.next=0;
	}
	
   /**
	*
	* Devuelve un Kid dada su posicion si esta dentro de los limites
	* @param n (int)
	* @return Kid
	* 
	*/
	public Kid showKid(int n) {
		return arrayKids[n];	
	}
	
	/**
	 * Devuelve el maximo de ninhos de la aplicacion
	 * @return arrayKids.length
	 */
	public int getMaxKids() {
		return arrayKids.length;
	}
	

	/**
	 * Devuelve la posicion de un ninho en el array buscandolo por su nombre
	 * @param name
	 * @return r (posicion)
	 * @throws BlablakidException
	 */
	public Kid search(String name) throws BlablakidException {
		Kid r=null;
		if (exists(name) != -1) {
			r = arrayKids[exists(name) ];
		} else {
			logKids.info("El ninho no existe");
			throw new BlablakidException("El ninho no existe");
		}
		return r;
	}
	
   /**
	* Busca el ninho por nombre y devuelve su posicion en el array
	* @param name (String)
	* @return r (posicion del niño a buscar en el array, -1 si no existe)
	*/
	public int exists(String name) {
		int n=0, r=-1;
		while (n < arrayKids.length) {
    		if (arrayKids[n] != null) {
    			if (arrayKids[n].getName().equals(name)) {
    				r = n;
    			}
    		}
    		n++;
    	}
		return r;
	}
	
   /**
	* Anhade un ninho. Puede ocurrir
	* @param name (String)
	* @return true si lo ha añadido
	*/
	public boolean add(Kid kid) throws BlablakidException {		
		
    	if (exists(kid.getName()) == -1) {
    		if (arrayKids[arrayKids.length-1] == null) {
    			arrayKids[next] = kid;
        		next++;
        		
    			logKids.info("Se ha anhadido el ninho");
    		} else {
    			logKids.info("La lista de ninhos esta llena");
    			throw new BlablakidException("La lista de ninhos esta llena");
    		}
    	} else {
    		logKids.info("El ninho ya existe");
    		throw new BlablakidException("El ninho ya existe");
    	}
    	return true;
	}
	
   /**
	* Elimina un ninho
	* @param name (String)
	* @return true si se ha borrado
	*/
	public boolean remove(String name) throws BlablakidException{
		int i = 0;
    	int j = 0;
    	
    	if (exists(name) != -1) {
    		
    		while (i < arrayKids.length) {
        		if (arrayKids[i] != null) {    			
        			if (arrayKids[i].getName().equals(name)) {
        				arrayKids[i] = null;
        				next--;
        				
        				i = arrayKids.length;
        				logKids.info("Se ha eliminado el ninho");
            		}
        		}
        		i++;
        	}
    		
    		//Ordeno el array para quitar nulls de por medio
    		while (j < arrayKids.length) {
    			if (arrayKids[j] == null && j != arrayKids.length-1) {
    				arrayKids[j] = arrayKids[j+1];
    				arrayKids[j+1] = null;
    			}
    			j++;
    		}
    	} else {
    		logKids.info("El ninho no existe");
    		throw new BlablakidException("El ninho no existe");
    	}
    	return true;
	}
	
   /**
	* Devuelve la lista de hijos con sus actividades
	* @return salida (String)
	*/
	public String toString() {
		StringBuffer salida = new StringBuffer();
		int i = 0;
		
		while (i < arrayKids.length) {
			if (arrayKids[i] != null) {
				salida.append("****** " + arrayKids[i].getName() + " ******\n");
				salida.append(arrayKids[i].getActivitiesOfKid().toString());
				logKids.info("Mostrando informacion para el ninho " + arrayKids[i].getName());
			}
			i++;
		}
		return salida.toString();
	}
	
}
