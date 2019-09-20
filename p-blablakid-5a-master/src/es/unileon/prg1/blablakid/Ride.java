package es.unileon.prg1.blablakid;

/**
 * @author 5A 
 * @version 1.0
 */

public class Ride{
	
	/**
	 * Atributos del objeto ride
	 */
	private String whereStartRide;
	private String whereEndRide;
	private Time startRide;
	private Time endRide;
	private String nameAct;

	/**
	 * Constructor del objeto ride
	 * @param wsr
	 * @param wer
	 * @param sr
	 * @param er
	 * @param name
	 */
	public Ride(String wsr, String wer, Time sr, Time er, String name) {
		this.whereStartRide=wsr;
		this.whereEndRide=wer;
		this.startRide=sr;
		this.endRide=er;
		this.nameAct=name;
	}

	/**
	 * Devuelve el lugar de salida del ride
	 * @return whereStartRide
	 */
	public String getWhereStartRide() {
		return this.whereStartRide;
	}

	/**
	 * Setea el lugar de salida del ride
	 * @param lugar
	 */
	public void setWhereStartRide(String lugar) {
		this.whereStartRide = lugar;
	}
	
	/**
	 * Devuelve el lugar de llegada del ride
	 * @return
	 */
	public String getWhereEndRide() {
		return this.whereEndRide;
	}

	/**
	 * Setea el lugar de llegada del ride
	 * @param lugar
	 */
	public void setWhereEndRide(String lugar) {
		this.whereEndRide = lugar;
	}

	/**
	 * Devuelve la hora de salida del ride
	 * @return
	 */
	public Time getStartRide() {
		return this.startRide;
	}

	/**
	 * Setea la hora de salida del ride
	 * @param h
	 */
	public void setStartRide(Time h) {
		this.startRide = h;
	}

	/**
	 * Devuelve la hora de llegada del ride
	 * @return
	 */
	public Time getEndRide() {
		return this.endRide;
	}

	/**
	 * Setea la hora de llegada del ride
	 * @param h
	 */
	public void setEndRide(Time h) {
		this.endRide = h;
	}

	/**
	 * Devuelve el nombre de la actividad que cubre el ride
	 * @return
	 */
	public String getNameAct() {
		return nameAct;
	}

	/**
	 * Setea el nombre de la actividad que cubre el ride
	 * @param name
	 */
	public void setNameAct(String name) {
		this.nameAct = name;
	}
	
}