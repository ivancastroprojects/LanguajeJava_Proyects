package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author SantiagoDiez
 * @version 1.01
 */

public class Activities{

	private Activity[] arrayActivities;
	private int next;
	private static final Logger logAct = LogManager.getLogger(Activities.class);
	
   /**
	*
	* Constructor de la clase Kids
	*
	*/
	public Activities() {
		arrayActivities = new Activity[3];
		this.next = 0;
		logAct.info("El maximo de actividades por kid es 3");
	}
	
   /**
	*
	* Devuelve una Activity dada su posicion
	* @param n (posicion del array)
	* @return Activity[n]
	*
	*/
	public Activity showActivity(int n) {
		return arrayActivities[n];
    }
	
   /**
	*
	* Anhade una actividad
	* @param activity
	* @return full (true si se ha anhadido, false si no)
	*
	*/
	public boolean add(Activity activity) throws BlablakidException {
		if (exists(activity.getName()) == -1) {
    		
    		if (arrayActivities[arrayActivities.length-1] == null) {
    			arrayActivities[next] = activity;
        		next++;
        		
    			logAct.info("Se ha aniadido la actividad");
    		} else {
    			logAct.info("La lista de actividades esta llena");
    			throw new BlablakidException("La lista de actividades esta llena");
    		}
    		
    	} else {
    		logAct.info("La actividad ya existe");
    		throw new BlablakidException("La actividad ya existe");
    	}
    	return true;
	}
	
   /**
	*
	* Elimina una actividad
	* @param name
	* @return full (true si se ha borrado, false si no)
	*
	*/
	public boolean remove(String name) throws BlablakidException {
    	int i = 0;
    	int j = 0;
    	
    	if (exists(name) != -1) {
    		
    		while (i < arrayActivities.length) {
        		if (arrayActivities[i] != null) {    			
        			if (arrayActivities[i].getName().equals(name)) {
        				arrayActivities[i] = null;
        				next--;
        				
        				i = arrayActivities.length;
        				logAct.info("Se ha eliminado la actividad");
            		}    			
        		}
        		
        		i++;
        	}
    		
    		//Ordeno el array para quitar nulls de por medio
    		while (j < arrayActivities.length) {
    			if (arrayActivities[j] == null && j != arrayActivities.length-1) {
    				arrayActivities[j] = arrayActivities[j+1];
    				arrayActivities[j+1] = null;
    			}
    			j++;
    		}
    		
    	} else {
    		logAct.info("La actividad no existe");
    		throw new BlablakidException("La actividad no existe");
    	}
    	return true;
    }
	
   /**
	*
	* Comprueba si una actividad existe
	* @param name
	* @return salida (-1 si no existe en el array, sino la posicion que ocupa la actividad)
	*
	*/
	public int exists(String name) {
    	int salida = -1;
    	int i = 0;
    	
    	while (i < arrayActivities.length) {
    		if (arrayActivities[i] != null) {
    			if (arrayActivities[i].getName().equals(name)) {
    				salida = i;
    				logAct.info("La actividad que se ha buscado existe");
    			}
    		}
    		i++;
    	}
    	
    	return salida;
    }
	
   /**
	*
	* Devuelve una actividad buscandola por su nombre
	* @param name (nombre de la actividad)
	* @return Activity
	* @throws BlablakidException 
	*
	*/
	public Activity search(String name) throws BlablakidException {
    	Activity r=null;
		if (exists(name) != -1) {
			r = arrayActivities[exists(name)];
		} else {
			logAct.info("La actividad que se ha buscado no existe");
			throw new BlablakidException("La actividad no existe");
		}
		return r;
    }
	
   /**
	*
	* Devuelve la lista de actividades de un ninho en formato String
	* @return salida
	*
	*/
	public String toString() {
		StringBuffer salida = new StringBuffer();
		
		int i = 0;
		
		while (i < arrayActivities.length ) {
			if (arrayActivities[i] != null) {
				salida.append(arrayActivities[i].getName() + " (" + arrayActivities[i].getPlace() + " - " + arrayActivities[i].getDayName() + 
						")" + arrayActivities[i].getStartActivity().toString() + " > " + arrayActivities[i].getEndActivity().toString() + "\n");
				logAct.info("Mostrando informacion para la actividad " + arrayActivities[i].getName());
			}
			i++;
		}
		
		return salida.toString();
    }
	
}