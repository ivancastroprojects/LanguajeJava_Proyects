package es.unileon.prg1.blablakid;

/**
 * Clase que almacena los dias de la semana
 * 
 * @author 5A
 * @version 1.0
 *
 */

public class Week {
	
	/**
	 * Lista de days que contiene Week
	 */
	private Day[] days;
	
	/**
	 * Total days
	 */
	private static int numDays = 5;
	
	/**
	 * Constructor de week
	 * @param maxRides
	 */
	public Week(int maxRides) {
		this.days = new Day[numDays];
		int i=0;
		while(i < numDays) {
			this.days[i]=new Day(maxRides);
			i++;
		}
	}

	/**
	 * Metodo que busca un dia de la semana segun la posicion
	 * @param n
	 * @return Day
	 */
	public Day search(int n) {
		return days[n]; 
	}
	
	/**
	 * Devuelve el numero de dias del objeto semana
	 * @return numDays
	 */
	public int getNumDays() {
		return Week.numDays;
	}

	/**
	 * Anhade un Ride segun el dia
	 * @param day, ride
	 */
	public boolean addRide(int day, Ride ride) throws BlablakidException {
		return days[day].addRide(ride);
	}
	
	/**
	 * Borra un Ride segun el dia
	 * @param day, ride
	 */
	public boolean removeRide(int day, String rideStart, String rideEnd) throws BlablakidException {
		return days[day].removeRide(rideStart, rideEnd);
	}	
	
	/**
	 * Devuelve el nombre del dia de la semana en funcion del parametro i [0-4]
	 * @param i
	 * @return
	 */
	public String getDayName(int i) {
		String dayName = null;
		
		switch (i) {
		case 0:
			dayName = "MONDAY";
			break;
		case 1:
			dayName = "TUESDAY";
			break;
		case 2:
			dayName = "WEDNESDAY";
			break;
		case 3:
			dayName = "THURSDAY";
			break;
		case 4:
			dayName = "FRIDAY";
			break;
		}
		return dayName;
	}
	
	/**
	 * Devuelve los rides que tiene cada dia de la semana
	 * @return salida
	 */
	public String toString() {
		StringBuffer salida = new StringBuffer();
		
		int i = 0;

		while (i < days.length) {
			if (!days[i].getRides().toString().equals("")) {
				
				salida.append(getDayName(i));
				salida.append("\n");
				
				salida.append(days[i].getRides().toString());
				
			}
			i++;
		}
		
		return salida.toString();
	}

}
