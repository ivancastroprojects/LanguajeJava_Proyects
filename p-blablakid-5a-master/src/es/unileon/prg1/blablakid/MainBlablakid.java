package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main Blablakid
 * 
 * @author Team 5A.
 * @version 1.0
 *
 */
public class MainBlablakid {

	/**
	 * A logger is created for the Menu class.
	 * 
	 */
	private final static Logger log = LogManager.getLogger(MainBlablakid.class);
	
	/**
	 * 
	 * @param args String array with the data of the aplication.
	 * @throws BlablakidException 
	 */
	public static void main(String args[]) throws BlablakidException {
		
		log.info("Entrando en la aplicacion...");
		
		int maxKids = 0;
		if(args.length != 1) {
			log.error("Numero de argumentos no valido");
			log.info("Saliendo de la aplicacion...");
			
			throw new BlablakidException("Numero de  argumentos no valido\nSintaxis del programa:\n" + 
					"maxKids");
		} else {	
			try {				
				maxKids = Integer.parseInt(args[0]);
				log.info("Argumento introducido satisfactoriamente");
				
			} catch (Exception e) {
				
				log.error("Argumento de tipo no valido");
				log.info("Saliendo de la aplicacion...");
				
				throw new BlablakidException("El argumento introducido debe ser de tipo int");
				
			}
		}
		
		if (maxKids <= 0) {
			log.error("El numero maximo de ninhos debe ser mayor que 0");
			log.info("Saliendo de la aplicacion...");
			
			throw new BlablakidException("Numero de  argumentos no valido\nSintaxis del programa:\n" + 
					"maxKids");
		} else {
			log.info("Se crea Blablakid y la interfaz");
			Blablakid blablakid = new Blablakid(maxKids);
			Interfaz textUI = new Interfaz(blablakid);
			
			log.info("Arranca la aplicacion...");
			textUI.start();
		}
		
	}

}
