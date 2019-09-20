package es.unileon.prg1.blablakid;

/**
 * @author SantiagoDiez
 * @version 1.01
 */
public class Activity{

	private String name;
	private String place;
	private String kid;
	private int day;
	private Time startActivity;
	private Time endActivity;
	
	/**
	 * @param name
	 * @param place
	 * @param day
	 * @param kid
	 * @param startActivity
	 * @param endActivity
	 * @throws BlablakidException
	 */
	public Activity(String name, String place, int day, String kid, Time startActivity, Time endActivity) throws BlablakidException {
		this.name = name;
		this.place = place;
		
		if (day < 0 || day > 4) {
			throw new BlablakidException("Dia de la semana no valido. Valores posibles entre 0 y 4");
		} else {
			this.day = day;
		}		
		
		this.kid = kid;
		this.startActivity = startActivity;
		this.endActivity = endActivity;
	}
	
	/**
	 * Devuelve el nombre de la actividad
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Modifica el nombre de la actividad
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Devuelve el lugar de la actividad
	 * @return place
	 */
	public String getPlace() {
		return place;
	}
	
	/**
	 * Modifica el lugar de la actividad
	 * @param place
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	/**
	 * Devuelve el dia de la actividad
	 * @return day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Devuelve el dia (en nombre) de la actividad
	 * @return dayName
	 */
	public String getDayName() {
		String dayName = null;
		
		switch (this.day) {
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
		}
		return dayName;
	}
	
	/**
	 * Modifica el dia de la actividad
	 * @param day
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * Devuelve el ninho que hace la actividad
	 * @return kid
	 */
	public String getKid() {
		return kid;
	}
	
	/**
	 * Modifica el nibho de la actividad
	 * @param kid
	 */
	public void setKid(String kid) {
		this.kid = kid;
	}
	
	/**
	 * Devuelve la hora de comienzo de la actividad
	 * @return startActivity
	 */
	public Time getStartActivity() {
		return startActivity;
	}
	
	/**
	 * Modifica la hora de inicio de la actividad
	 * @param startActivity
	 */
	public void setStartActivity(Time startActivity) {
		this.startActivity = startActivity;
	}
	
	/**
	 * Devuelve la hora de fin de la actividad
	 * @return endActivity
	 */
	public Time getEndActivity() {
		return endActivity;
	}
	
	/**
	 * Modifica la hora de fin de la actividad
	 * @param endActivity
	 */
	public void setEndActivity(Time endActivity) {
		this.endActivity = endActivity;
	}
	
}