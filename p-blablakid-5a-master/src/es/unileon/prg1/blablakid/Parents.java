package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Clase Parents representa la agrupacion de los padres
 * con agregado en Parent
 * @author 5A
 *
 */
public class Parents {
	
	/**
	 * Lista de Parent que contiene Parents
	 */
	private Parent[] arrayParents;
	
	/**
	 * Logger de la clase Parents
	 */
	private static final Logger logParents=LogManager.getLogger(Parents.class);
	
	/**
	 * Numero de personas almacenadas en cada momento en Parents
	 * (o primera posicion libre de la lista de Parents)
	 */
	private int next;
	
	/**
	 * Constructor de la clase que inicializa sus atributos
	 * Recibe como parametro el numero maximo de Parents que habra.
	 * se inicializan los atributos
	 */
	public Parents(int maxParents) {
		arrayParents = new Parent[maxParents];
		this.next=0;
	}
	
	/**
	 * El metodo getMaxParents, retorna una variable de tipo int que sera la longitud del array de parents
	 * en nuestro caso, ese array de parents es arrayParents. 
	 */
	public int getMaxParents() {
		return arrayParents.length;
	}
	/**
	 * El metodo showParent retorna un objeto Parent que esta dentro del array de Parents, si n
	 * esta fuera de los limites del array se lanzara una excepcion.
	 * @param n
	 * @return Parent
	 */
	public Parent showParent(int n) throws BlablakidException{
		try{
			return arrayParents[n];
		}catch(Exception e){
			throw new BlablakidException(n+"excede los limites del array");
		}
	}
	
	/**
	 * Agregar un padre a Parents
	 * @param name, totalSons, sons, rides
	 * @return boolean
     * El metodo add, recibe como parametro un objeto Parent.
     * Primero se comprueba si existe, el identificador del padre es su nombre, si no coincide, se comprueba que la posicion ultima
     * que puede tener el array esta vacia, ya que si esa posicion esta vacia se puede anhadir, si lo esta, se anhade el Parent al array.
     * Si no lo esta se lanza una excepcion.
     * En caso de que el padre ya existiese, se lanzara una excepcion. 
	 */
	public boolean add(Parent parent) throws BlablakidException {		
    	if (exists(parent.getName()) == -1) {
    		
    		if (arrayParents[arrayParents.length-1] == null) {
    			arrayParents[next] = parent;
        		next++;
        		
    			logParents.info("Se ha anhadido el padre");
    		} else {
    			logParents.info("La lista de padres esta llena");
    			throw new BlablakidException("La lista de padres esta llena");
    		}
    		
    	} else {
    		logParents.info("El padre ya existe");
    		throw new BlablakidException("El padre ya existe");
    	}
    	return true;
	}

	/**
     * 
	 * Eliminar un padre de Parents
	 * siempre y cuando haya padres y esta el padre a eliminar
	 * @param name (String))
	 * @return boolean
     * El metodo remove, recibe como parametro un String que es el nombre del padre.
     * Este metodo comprueba que exista el padre con ese nombre, si existe, busca en el array la posicion en la que esta ese padre
     * una vez que llega a esa posicion elimina a ese Parent poniendo el contenido de la posicion en la que estaba a null.
     * Si el Parent buscado no existe, se dispara una excepcion. 
	 */
	public boolean remove(String name) throws BlablakidException {
		int i = 0;
    	int j = 0;    	
    	boolean ok = false;
    	
    	if (exists(name) != -1) {
    		/* Mediante un bucle while se recorre la lista.*/
    		while (i < arrayParents.length) {
        		if (arrayParents[i] != null) {    
        			/*Cuando se llega al padre deseado se elimina, se pone la posición que ocupa a null.*/
        			if (arrayParents[i].getName().equals(name)) {
        				arrayParents[i] = null;
        				/* Se decrementa el next.*/
        				next--;
        				
        				i = arrayParents.length;
        				logParents.info("Se ha eliminado el padre");
        				ok=true;
            		}
        		}
        		
        		i++;
        	}
    		
    		//Ordeno el array para quitar nulls de por medio
    		while (j < arrayParents.length) {
    			/*Se recorre el array mediante un bucle while para dejar los null al final*/
    			if (arrayParents[j] == null && j != arrayParents.length-1) {
    				arrayParents[j] = arrayParents[j+1];
    				arrayParents[j+1] = null;
    			}
    			j++;
    		}
    		
    	} else {
    		logParents.info("El padre no existe");
    		throw new BlablakidException("El padre no existe");
    	}
    	return ok;
    }
	
   /**
	* Comprueba si un padre existe
	* Retorna el indice en el array si el padre existe
	* Retorna -1 si el padre NO existe
    * @param name
   	* @return int
    * El metodo existsParent recibe como parametro el nombre de un padre.
    * Este metodo retorna un valor int, un -1 si el padre que recibe como parametro si no existe, devolvera la posicion en la que esta
    * en el array el Paren en caso de que si exista.
	*/
   public int exists(String name) {
       int i = 0, salida = -1;

       while(i < arrayParents.length) {
           if(arrayParents[i] != null) {
               if(arrayParents[i].getName().equals(name)) {
                   salida = i;
               }
           }
           i++;
       }
       return salida;
   }

   /**
	* Busca un padre concreto
	* Retorna el objeto Parent si se encontro el padre
	* Retorna null si NO se encontro el padre
    * @param name
    * @return Parent
	* @throws BlablakidException
	* Este metodo searchParent, recibe como parametro el nombre del Parent que desea buscar.
	* Hace una llamada al metodo existsParent pasandole el nombre como argumento para comprobar que exista, si existe, retorna
	* el objeto Parent que esta localizado en la posicion retornada por el metodo existsParent.
	* Si ese Parent no existe se dispara una excepcion.
	*/
   public Parent search(String name) throws BlablakidException {
       if(exists(name) != -1) {
           return arrayParents[exists(name)];
       } else {
    	   logParents.info("El padre buscado no existe");
    	   throw new BlablakidException("El padre no existe");
       }
   }
	
   /**
	* Cuando se elimina un ninho, se busca si tiene padres, y si los tiene, a estos se les borra ese ninho
	* Se recorre el array de parents
	* Por cada parent se recorre su array de ninhos
	* Si hay coincidencia con el nombre pasado como parametro, se elimina (null)
	*/
	public void removeKid(String name) {
		int i = 0;
		int j = 0;
		
		while (i < arrayParents.length && arrayParents[i] != null) {
			j=0;
			while (j < arrayParents[i].getTotalSons()) {
				if (arrayParents[i].getSon(j).equals(name)) {
					arrayParents[i].setSonNull(j);
				}
				j++;
			}
			i++;
		}
	}
	
   /**
	* Se le pasa el nombre de una actividad y devuelve el padre con un ride asociado
	* a dicha actividad
	* @param nombreActividad
	* @return Parent
	* @throws BlablakidException
	*/
	public void searchRideByAct(String nombreActiviad) throws BlablakidException {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < arrayParents.length && arrayParents[i] != null) {	
			//Miro sus 5 dias
			j = 0;
			while (j < arrayParents[i].getWeek().getNumDays()) {
				//Miro los rides de su dia
				k = 0;
				while (k < arrayParents[i].getTotalRides() && arrayParents[i].getWeek().search(j).getRides().getRide(k) != null) {
					
					if (arrayParents[i].getWeek().search(j).getRides().getRide(k).getNameAct().equals(nombreActiviad)) {
						arrayParents[i].removeRide(j, arrayParents[i].getWeek().search(j).getRides().getRide(k).getWhereStartRide(), 
								arrayParents[i].getWeek().search(j).getRides().getRide(k).getWhereEndRide());
					}
					
					k++;
				}
				j++;
			}
			i++;
		}
	}
	   
   /**
	* Devuelve la lista de padres con sus hijos y rides
	* @return String
	*  El metodo toString de la clase Parents retorna en forma de String los objetos del array de Parents.
	*/
	public String toString() {
		StringBuffer salida = new StringBuffer();
		
		int i = 0;
		int j = 0;

		while (i < arrayParents.length) {
			j=0;
			if (arrayParents[i] != null) {

				salida.append("###### " + arrayParents[i].getName() + " ######\n");
				salida.append("Kids:\n");
				
				while (j < arrayParents[i].getTotalSons()) {
					if (arrayParents[i].getSon(j) != null) {
						salida.append(arrayParents[i].getSon(j) + "\n");
					}
					j++;
				}
				
				salida.append("Rides:\n");
				
				salida.append(arrayParents[i].getWeek().toString());
				
			}
			i++;
		}
		
		return salida.toString();
	}

}
