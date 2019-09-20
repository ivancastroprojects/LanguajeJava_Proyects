package es.unileon.prg1.blablakid;

/**
 * @author KevinSanchez
 * @version 1.0
 */
public class Kid{
	
	/**
	 * Nombre del Kid
	 */
	private String name;
	
	/**
	 * Array de actividades del ninho
	 */
	private Activities ActivitiesOfKid;

	
	/**
	*
	* Constructor de la clase Kid
	* @param name (String)
	*
	*/
	public Kid(String name) {
		this.name = name;
		this.ActivitiesOfKid = new Activities();
	}
	
	/**
	*
	* Anhade una actividad al ninho
	* @param A (Activity)
	* @return boolean
	*/
	public boolean addActivityToKid(Activity A) throws BlablakidException{
		return ActivitiesOfKid.add(A);
	}
	
	/**
	*
	* Elimina una actividad del ninho
	* @param nombre
	* @return boolean
	*/
	public boolean removeActivityOfKid(String nombre) throws BlablakidException{
		return ActivitiesOfKid.remove(nombre);
	}
	
	/**
	*
	* Muestra la actividad del ninho dada su posicion en el array de sus actividades
	* @param n (int)
	* @return Activity
	*
	*/
	public Activity showActivityOfKid(int n) {
		return ActivitiesOfKid.showActivity(n);
	}
	
	/**
	*
	* Devuelve el nombre del ninho
	* @return String
	*/
	public String getName() {
		return name;
	}
	
	/**
	*
	* Devuelve el array de actividades del ninho
	* @return Activities
	*/
	public Activities getActivitiesOfKid() {
		return ActivitiesOfKid;
	}
	
}
