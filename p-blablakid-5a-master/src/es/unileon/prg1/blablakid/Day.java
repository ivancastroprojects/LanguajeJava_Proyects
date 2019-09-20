package es.unileon.prg1.blablakid;

public class Day {
	
	/**
	 * Lista de Rides
	 * 
	 **/
	private Rides rides;
	
	/**
	 * Constructor de Day
	 * @param maxRides
	 **/
	public Day(int maxRides) {
		this.rides = new Rides(maxRides);
	}
	
	
	/**
	 * Metodo que anhade un trayecto delegado a la clase Rides
	 * @param ride
	 * @return boolean
	 **/
	public boolean addRide(Ride ride) throws BlablakidException {
		return rides.add(ride);
	}
	
	/**
	 * Metodo que elimina un trayecto delegado a la clase Rides
	 * @param ride
	 * @return boolean
	 **/
	public boolean removeRide(String rideStart, String rideEnd) throws BlablakidException {
		return rides.remove(rideStart, rideEnd);
	}
	
	/**
	 * Metodo que devuelve el array de rides para este dia
	 * @return rides
	 */
	public Rides getRides() {
		return rides;
	}
	
}
