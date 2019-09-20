package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 5A
 * @version 1.01
 */

public class Blablakid {
	
	/**
	 * Array de ninhos
	 */
	private Kids kids;
	
	/**
	 * Array de padres
	 */
	private Parents parents;
	
	/**
	 * Log para la clase Blablakid
	 */
	private static final Logger logBlablakid = LogManager.getLogger(Blablakid.class);
	
	/**
	 * Constructor de blablakid
	 * Crea dos objetos kids y parents que seran los que se manejen en el programa
	 * @param maxKids
	 */
	public Blablakid(int maxKids) {
		this.kids = new Kids(maxKids);
		this.parents = new Parents(maxKids*2);
		
		logBlablakid.info("Se ha creado un objeto Blablakid");
	}	
	
	/**
	 * Crea un objeto ninho
	 * Anhade un ninho pasandole como parametro su nombre
	 * @param name
	 * @throws BlablakidException
	 */
	public void addKid(String name) throws BlablakidException {
		Kid ninho = new Kid(name);
		kids.add(ninho);
		
		logBlablakid.info("Se ha anhadido un nuevo ninho satisfactoriamente");
	}
	
	/**
	 * Elimina un ninho del array de ninhos
	 * Se elimina tambien del array de ninhos de su/s padres
	 * @param name
	 * @throws BlablakidException
	 */
	public void removeKid(String name) throws BlablakidException {
		int i = 0;
		while (i < 3 && kids.search(name).getActivitiesOfKid().showActivity(i) != null) {
			parents.searchRideByAct(kids.search(name).getActivitiesOfKid().showActivity(i).getName());
			i++;
		}
		
		kids.remove(name);
				
		parents.removeKid(name);
		
		logBlablakid.info("Se ha eliminado un ninho satisfactoriamente");
	}
	
	/**
	 * Crea un objeto padre
	 * Anhade un padre pasandole varios parametros
	 * Comprueba que los hijos introducidos existen
	 * @param name
	 * @param totalSons
	 * @param totalRidesDay
	 * @param sons
	 * @throws BlablakidException
	 */
	public void addParent(String name, int totalSons, int totalRidesDay, String[] sons) throws BlablakidException {
		Parent padre = new Parent(name, totalSons, totalRidesDay, sons);
		
		int i = 0;
		while (i < totalSons) {
			kids.search(sons[i]);
			i++;
		}
		
		parents.add(padre);
		
		logBlablakid.info("Se ha anhadido un nuevo padre satisfactoriamente");
	}
	
	/**
	 * Elimina un padre del array de padres
	 * @param name
	 * @throws BlablakidException
	 */
	public void removeParent(String name) throws BlablakidException {
		parents.remove(name);
		
		logBlablakid.info("Se ha eliminado un padre satisfactoriamente");
	}
	
	/**
	 * Crea dos objetos time con las horas de comienzo y fin
	 * Crea un objeto actividad
	 * Anhade una actividad al ninho pasado como parametro
	 * @param activity
	 * @param place
	 * @param day
	 * @param kid
	 * @param startHours
	 * @param startMinutes
	 * @param endHours
	 * @param endMinutes
	 * @throws BlablakidException
	 */
	public void addActivity(String activity, String place, int day, String kid, String startHours, String startMinutes, String endHours, String endMinutes) throws BlablakidException {
		Time inicioActividad = new Time(startHours, startMinutes);
		Time finActividad = new Time(endHours, endMinutes);
		Activity actividad = new Activity(activity, place, day, kid, inicioActividad, finActividad);
		kids.search(kid).addActivityToKid(actividad);
		
		logBlablakid.info("Se ha anhadido una nueva actividad satisfactoriamente");
	}
	
	/**
	 * Elimina una actividad del array de actividades del ninho pasado como parametro
	 * Elimina los rides relacionados con esa actividad
	 * @param kid
	 * @param activity
	 * @throws BlablakidException
	 */
	public void removeActivity(String kid, String activity) throws BlablakidException {
		kids.search(kid).removeActivityOfKid(activity);
		
		parents.searchRideByAct(activity);
		
		logBlablakid.info("Se ha eliminado una actividad satisfactoriamente");
	}
	
	/**
	 * Crea dos objetos time con las horas de comienzo y fin
	 * Crea un objeto ride
	 * Crea un objeto ride en base a la actividad, como lugar de llegada el de la actividad y hora de llegada la hora de inicio de la actividad
	 * Crea un objeto ride en base a la actividad, como lugar de salida el de la actividad y hora de salida la hora de fin de la actividad
	 * Comprueba que el ninho y la actividad existen
	 * Anhade el ride al dia pasado como parametro del padre
	 * @param parent
	 * @param activity
	 * @param kid
	 * @param rideStart
	 * @param rideEnd
	 * @param startHours
	 * @param startMinutes
	 * @param endHours
	 * @param endMinutes
	 * @param day
	 * @throws BlablakidException
	 */
	public void addRide(String parent, String activity, String kid, String rideStart, String rideEnd, String startHours, String startMinutes, String endHours, String endMinutes, int day) throws BlablakidException {
		Time inicioRide = new Time(startHours, startMinutes);
		Time finRide = new Time(endHours, endMinutes);
		
		kids.search(kid).getActivitiesOfKid().search(activity);
		
		Ride viaje = new Ride(rideStart, rideEnd, inicioRide, finRide, activity);
		
		parents.search(parent).addRide(day, viaje);
		
		logBlablakid.info("Se ha anhadido un nuevo ride satisfactoriamente");
	}
	
	/**
	 * Elimina un ride del padre pasado como parametro
	 * @param parent
	 * @param day
	 * @param rideStart
	 * @param rideEnd
	 * @throws BlablakidException
	 */
	public void removeRide(String parent, int day, String rideStart, String rideEnd) throws BlablakidException {
		parents.search(parent).removeRide(day, rideStart, rideEnd);
		
		logBlablakid.info("Se ha eliminado un ride satisfactoriamente");
	}
	
	/**
	 * Devuelve un sumario con la informacion de ninhos
	 * Las actividades asociadas a cada ninho
	 * Los rides asociados a cada actividad
	 * Los padres
	 * Los hijos de cada padre
	 * Los rides asociados a un padre
	 * @return salida
	 * @throws BlablakidException
	 */
	public String summary() throws BlablakidException {
		StringBuffer salida = new StringBuffer();
		
		salida.append("////////////////////////\n");
		salida.append("\n");
		salida.append("KIDS:\n");
		salida.append("\n");
		
		salida.append(kids.toString());
		
		salida.append("\n");
		salida.append("PARENTS:\n");
		salida.append("\n");
		
		salida.append(parents.toString());
		
		salida.append("////////////////////////");	
		return salida.toString();
	}
	
	/**
	 * Devuelve un sumario con los rides que quedan por cubrir
	 * @return salida
	 * @throws BlablakidException
	 */
	public String status() throws BlablakidException {
		return null;
	}
	
}
