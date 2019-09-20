package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Team 5A
 * @version 1.04
 */

public class Interfaz {
	
	/**
	 * Objeto blablakid que contendra los arrays y las llamadas a los metodos de cada clase
	 */
	private Blablakid blablakid;

	/**
	 * Variables locales que almacenaran los parametros leidos por teclado
	 */
	private String kid;
	private String parent;
	private int totalSons;
	private int totalRidesDay;
	private String[] sons;
	private String activity;
	private String place;
	private int day;
	private String startHours;
	private String startMinutes;
	private String endHours;
	private String endMinutes;
	private String rideStart;
	private String rideEnd;
	
	/**
	 * A logger is created for the Menu class.
	 * 
	 */
	private final static Logger log = LogManager.getLogger(Interfaz.class);
	
	/**
	 * Se inicializa el objeto blablakid
	 * 
	 */
	public Interfaz (Blablakid blablakid) {
		this.blablakid = blablakid;
	}	
	
	/**
	 * Metodo que una vez llamado se repite hasta que el usuario
	 * introduce por pantalla un 0
	 * que corresponde a la opcion 'Salir de la aplicacion'
	 * @throws BlablakidException
	 */
	public void start() throws BlablakidException {
				
		int option = 11;
		
		do {
			System.out.println(blablakid.summary());			
			
			System.out.println("---------");
			System.out.println("Blablakid");
			System.out.println("---------");
			System.out.println("Select an option:");
			System.out.println(" 1 - Add kid");
			System.out.println(" 2 - Remove kid");
			System.out.println(" 3 - Add parent");
			System.out.println(" 4 - Remove parent");
			System.out.println(" 5 - Add activity");
			System.out.println(" 6 - Remove activity");
			System.out.println(" 7 - Add ride");
			System.out.println(" 8 - Remove ride");
			System.out.println(" 9 - Show summary");
			System.out.println(" 10 - Check status");
			System.out.println(" 0 - Exit");
						
			try {
				option = Integer.parseInt(TecladoBasico.leerLinea());
			} catch (Exception e) {
				System.out.println("Error: El comando introducido debe ser un numero comprendido entre 0 y 10");
				log.error("Opcion elegida, " + option + ", no valida");
				option = 11;
			}
			
			switch (option) {
			case 1:
				option1();
				
				break;
			case 2:
				option2();
				
				break;
			case 3:
				option3();
				
				break;
			case 4:
				option4();
				
				break;
			case 5:
				option5();
				
				break;
			case 6:
				option6();
				
				break;
			case 7:
				option7();
				
				break;
			case 8:
				option8();
				
				break;
			case 9:
				option9();
				
				break;
			case 10:
				option10();
				
				break;
			case 0:
				option0();
				
				break;
			default:
				
			}
			
		} while (option != 0);
		
		log.info("Saliendo de la aplicacion...");
	}
	
	/**
	 * Opcion 0: salir de la aplicacion
	 */
	public void option0() {
		log.info("Se ha elegido la opcion: salir de la aplicacion");
		
		System.out.println("Exiting application...");
		System.out.println("Thanks for using Blablakid");
	}
	
	/**
	 * Opcion 1: anhadir un ninho
	 * @throws BlablakidException
	 */
	public void option1() throws BlablakidException {
		System.out.println("Name of the kid to add:");
		kid = TecladoBasico.leerLinea().trim();
						
		log.info("Se ha elegido la opcion: anhadir kid");		
        
        try {
        	this.blablakid.addKid(kid);
		} catch (BlablakidException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Opcion 2: eliminar un ninho
	 * @throws BlablakidException
	 */
	public void option2() throws BlablakidException {
		System.out.println("Name of the kid to remove:");
		kid = TecladoBasico.leerLinea().trim();
		
		log.info("Se ha elegido la opcion: eliminar kid");		
		
		try {
			this.blablakid.removeKid(kid);
		} catch (BlablakidException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Opcion 3: anhadir un padre
	 * @throws BlablakidException
	 */
	public void option3() throws BlablakidException {
		System.out.println("Name of the parent to add:");
		parent = TecladoBasico.leerLinea().trim();
		
		System.out.println("How many kids does " + parent + " have?");
		try {
			totalSons = Integer.parseInt(TecladoBasico.leerLinea());
		} catch (Exception e) {
			System.out.println("El numero de hijos debe ser un entero");
			log.error("El numero de hijos debe ser un entero");
		}
		
		System.out.println("How many rides can " + parent + " make per day?");
		try {
			totalRidesDay = Integer.parseInt(TecladoBasico.leerLinea());
		} catch (Exception e) {
			System.out.println("El numero de rides por dia debe ser un entero");
			log.error("El numero de rides por dia debe ser un entero");
		}
		
		sons = new String[totalSons];
		
		int i = 0;
		while (i != totalSons) {
			System.out.println("Who is " + parent + "'s kid number 0" + i + "?");
			sons[i] = TecladoBasico.leerLinea().trim();
			
			i++;
		}
		
		log.info("Se ha elegido la opcion: aÃ±adir parent");		
		
		try {
			this.blablakid.addParent(parent, totalSons, totalRidesDay, sons);
		} catch (BlablakidException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Opcion 4: eliminar un padre
	 * @throws BlablakidException
	 */
	public void option4() throws BlablakidException {
		System.out.println("Name of the parent to remove:");
		parent = TecladoBasico.leerLinea().trim();
		
		log.info("Se ha elegido la opcion: eliminar parent");		
		
		try {
			this.blablakid.removeParent(parent);
		} catch (BlablakidException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Opcion 5: anhadir una actividad
	 * @throws BlablakidException
	 */
	public void option5() throws BlablakidException {
		System.out.println("Name of the activity:");
		activity = TecladoBasico.leerLinea().trim();
		
		System.out.println("Where does the activity " + activity + " takes place?");
		place = TecladoBasico.leerLinea().trim();
		
		System.out.println("Day of the week for the activity:");
		System.out.println("Insert the number of the day of the week:");
		System.out.println("0 - Monday / 1- Tuesday / 2 - Wednesday / 3 - Thursday / 4 - Friday");
		try {
			day = Integer.parseInt(TecladoBasico.leerLinea());
		} catch (Exception e) {
			System.out.println("El dia de la semana debe ser un entero");
			log.error("El dia de la semana debe ser un entero");
		}		
		
		System.out.println("Name of the kid taking the activity:");
		kid = TecladoBasico.leerLinea().trim();
		
		System.out.println("When does the activity start?");
		System.out.println("Insert hour:");
		startHours = TecladoBasico.leerLinea().trim();
		
		System.out.println("Insert minute:");
		startMinutes = TecladoBasico.leerLinea().trim();
		
		System.out.println("When does the activity end?");
		System.out.println("Insert hour:");
		endHours = TecladoBasico.leerLinea().trim();
		
		System.out.println("Insert minute:");
		endMinutes = TecladoBasico.leerLinea().trim();
		
		log.info("Se ha elegido la opcion: aÃ±adir activity");
		
		try {
			this.blablakid.addActivity(activity, place, day, kid, startHours, startMinutes, endHours, endMinutes);
		} catch (BlablakidException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Opcion 6: eliminar una actividad
	 * @throws BlablakidException
	 */
	public void option6() throws BlablakidException {
		System.out.println("Name of the kid taking the activity to remove:");
		kid = TecladoBasico.leerLinea().trim();
		
		System.out.println("Name of the activity to remove:");
		activity = TecladoBasico.leerLinea().trim();
		
		log.info("Se ha elegido la opcion: eliminar activity");
		
		try {
			this.blablakid.removeActivity(kid, activity);
		} catch (BlablakidException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Opcion 7: anhadir un ride
	 * @throws BlablakidException
	 */
	public void option7() throws BlablakidException {
		System.out.println("Name of the parent in charge of the ride:");
		parent = TecladoBasico.leerLinea().trim();
		
		System.out.println("Name of the activity of the ride:");
		activity = TecladoBasico.leerLinea().trim();
		
		System.out.println("Name of the kid taking the activity:");
		kid = TecladoBasico.leerLinea().trim();
		
		System.out.println("Where does the ride start?");
		rideStart = TecladoBasico.leerLinea().trim();
		
		System.out.println("Where does the ride end?");
		rideEnd= TecladoBasico.leerLinea().trim();
		
		System.out.println("When does the ride start?");
		System.out.println("Insert hour:");
		startHours = TecladoBasico.leerLinea().trim();
		
		System.out.println("Insert minute:");
		startMinutes = TecladoBasico.leerLinea().trim();
		
		System.out.println("When does the ride end?");
		System.out.println("Insert hour:");
		endHours = TecladoBasico.leerLinea().trim();
		
		System.out.println("Insert minute:");
		endMinutes = TecladoBasico.leerLinea().trim();
		
		System.out.println("Day of the week for the activity:");
		System.out.println("Insert the number of the day of the week:");
		System.out.println("0 - Monday / 1- Tuesday / 2 - Wednesday / 3 - Thursday / 4 - Friday");
		try {
			day = Integer.parseInt(TecladoBasico.leerLinea());
		} catch (Exception e) {
			System.out.println("El dia de la semana debe ser un entero");
			log.error("El dia de la semana debe ser un entero");
		}
		
		log.info("Se ha elegido la opcion: aÃ±adir ride");
		
		try {
			this.blablakid.addRide(parent, activity, kid, rideStart, rideEnd, startHours, startMinutes, endHours, endMinutes, day);
		} catch (BlablakidException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Opcion 8: eliminar un ride
	 * @throws BlablakidException
	 */
	public void option8() throws BlablakidException {
		System.out.println("Name of the parent in charge of the ride:");
		parent = TecladoBasico.leerLinea().trim();
		
		System.out.println("Day of the week for the activity:");
		System.out.println("Insert the number of the day of the week:");
		System.out.println("0 - Monday / 1- Tuesday / 2 - Wednesday / 3 - Thursday / 4 - Friday");
		day = Integer.parseInt(TecladoBasico.leerLinea());
		
		System.out.println("Where does the ride start?");
		rideStart = TecladoBasico.leerLinea().trim();
		
		System.out.println("Where does the ride end?");
		rideEnd= TecladoBasico.leerLinea().trim();
		
		log.info("Se ha elegido la opcion: eliminar ride");
		
		try {
			this.blablakid.removeRide(parent, day, rideStart, rideEnd);
		} catch (BlablakidException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Opcion 9: mostrar informacion de ninhos, padres, actividades y rides
	 * @throws BlablakidException
	 */
	public void option9() throws BlablakidException {
		log.info("Se ha elegido la opcion: mostrar sumario");
		
		System.out.println(this.blablakid.summary());
	}
	
	/**
	 * Opcion 10: mostrar informacion de rides sin cubrir
	 * @throws BlablakidException
	 */
	public void option10() throws BlablakidException {
		log.info("Se ha elegido la opcion: comprobar estado de los rides");
		
		this.blablakid.status();
	}
	
}
