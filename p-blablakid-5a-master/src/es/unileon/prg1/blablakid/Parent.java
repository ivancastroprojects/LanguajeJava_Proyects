package es.unileon.prg1.blablakid;

/**
 * Clase Parent
 * @author 5A
 * @version 1.0
 */

public class Parent {
	
	/**
	 * Nombre del padre
	 */
	private String name;
	
	/**
	 * Cantidad de hijos del padre 
	 */
	private int totalSons;
	
	/**
	 * Cantidad de trayectos por día del padre
	 */
	private int totalRidesDay;
	
	/**
	 * Hijos del padre 
	 */

	private String[] sons;

	/**
	 * Trayectos del padre
	 */
	private Week week;
		       
	/**
	 * Constructor de un Padre a partir de sus datos
	 * @param name
	 * @param totalSons
	 * @param totalRidesDay
	 * @param sons 
	 */
	Parent(String name, int totalSons, int totalRidesDay, String[] sons) {
		this.name = name;	
		this.totalSons = totalSons;	
		this.totalRidesDay = totalRidesDay;
		this.sons = sons;
		this.week = new Week(totalRidesDay);
	}
	
	/**
	 * Devuelve el nombre del padre
	 * @return String
	 */
	public String getName() {
		return name;
    }
	
	/**
	 * Se elimina (null) el ninho de la posicion pasada como parametro
	 * @param i
	 * El metodo setSonNull pone el hijo recibido como parametro (posicion en el array) a null 
	 */
	public void setSonNull(int i) {
		sons[i] = null;
		this.totalSons--;
		
		//Ordeno el array para quitar nulls de por medio
		int j = 0;		
		while (j < this.totalSons) {
			if (sons[j] == null && j != this.totalSons-1) {
				sons[j] = sons[j+1];
				sons[j+1] = null;
			}
			j++;
		}
	}
	
	/**
	 * Devuelve un hijo del padre, pasandole como parametro su indice en el array
	 * @param i
	 * @return Kids
	 * @throws BlablakidException 
	 */
	public String getSon(int i) {
		return this.sons[i];
	}
	
	/**
	 * Devuelve los trayectos de uno en uno que tiene asignados el padre
	 * @param day, ride
	 * @return boolean
	 *
	 */
	public boolean addRide(int day, Ride ride) throws BlablakidException {
		return week.addRide(day, ride);
	}
	
	/**
	 * El metodo remove Ride, recibe como parámetros el número que indida el día, y el lugar donde empiza y donde termina el Ride
	 * Retorna el valor boolean.
	 * @param day, ride
	 * @return boolean
	 *  
	 */
	public boolean removeRide(int day, String rideStart, String rideEnd) throws BlablakidException{
		return week.removeRide(day, rideStart, rideEnd);
	}
	
	/**
	 * Devuelve la cantidad de hijos del padre
	 * @return totalSons
	 * El metodo getTotalSons retorna un entero que es la longitud del array de hijos que tiene el padre. 
	 */
	public int getTotalSons() {
		return this.sons.length;
	}
	
	/**
	 * El metodo getTotalRides, retorna la cantidad total de Rides que tiene el Parent.
	 * @return totalSons
	 */
	public int getTotalRides() {
		return totalRidesDay;
	}
	
	/**
	 * El metodo getWeek retorna la semana. 
	 **/
	public Week getWeek() {
		return week;
	}
}
