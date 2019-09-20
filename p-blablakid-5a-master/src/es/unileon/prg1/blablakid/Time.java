package es.unileon.prg1.blablakid;

/**
 * Clase Time gestiona las horas y minutos
 * 
 * @author Team 5A
 * @version 1.01
 *
 */

public class Time {

	private String hour;
	private String minute;
	
	/**
	 ** Constructor de la clase Time, recibe como parámetros dos String con las horas y minutos.
	 ** Hace las comprobaciones para que sean tanto la hora como los minutos válidos y si lo son se crea, si no, lanza excepción.
	 **/
	public Time(String hour, String minute) throws BlablakidException {
		int intHora = Integer.parseInt(hour);
		int intMinuto = Integer.parseInt(minute);
		
		if (intHora > 23 || intHora < 00) {
			throw new BlablakidException("Hora no valida, valores posibles entre 00 y 23");
		} else {
			this.hour = hour;
		}
		
		if (intMinuto > 59 || intMinuto < 00) {
			throw new BlablakidException("Minuto no valido, valores posibles entre 00 y 59");
		} else {
			this.minute = minute;
		}
	}
	/**
	 ** Método toString de la clase Time, retorna la hora en forma de String. 
	 **/
	public String toString() {
		String buffer = String.valueOf(hour) + ":" + String.valueOf(minute);
		return buffer;
	}
}
