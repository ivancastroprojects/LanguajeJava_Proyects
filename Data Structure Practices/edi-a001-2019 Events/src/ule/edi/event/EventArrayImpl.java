package ule.edi.event;

import java.util.*;

import ule.edi.model.Configuration.Type;
import ule.edi.model.*;

public class EventArrayImpl implements Event {

	private String name;
	private Date date;

	private Double priceGold; // precio de entradas tipo GOLD
	private Double priceSilver; // precio de entradas tipo SILVER

	private int nGold; // Nº de butacas de tipo GOLD
	private int nSilver; // Nº de butacas de tipo SILVER

	private Seat[] gold;
	private Seat[] silver;

	public Double getPriceGold() {
		return priceGold;
	}

	public void setPriceGold(Double priceGold) {
		this.priceGold = priceGold;
	}

	public Double getPriceSilver() {
		return priceSilver;
	}

	public void setPriceSilver(Double priceSilver) {
		this.priceSilver = priceSilver;
	}

	public EventArrayImpl(String name, Date date, int nGold, int nSilver) {
		// TODO
		// utiliza los precios por defecto: DEFAULT_PRICE_GOLD y
		// DEFAULT_PRICE_SILVER definidos en Configuration.java

		// Debe crear los arrays de butacas gold y silver
		this.name = name;
		this.nGold = nGold;
		this.nSilver = nSilver;

		priceGold = Configuration.DEFAULT_PRICE_GOLD;
		priceSilver = Configuration.DEFAULT_PRICE_SILVER;

		gold = new Seat[nGold];
		silver = new Seat[nSilver];
	}

	public EventArrayImpl(String name, Date date, int nGold, int nSilver, Double priceGold, Double priceSilver) {
		// TODO
		// Debe crear los arrays de butacas gold y silver
		this.name = name;
		this.nGold = nGold;
		this.nSilver = nSilver;

		this.priceGold = priceGold;
		this.priceSilver = priceSilver;

		gold = new Seat[nGold];
		silver = new Seat[nSilver];
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public int getNumberOfAttendingChildren() {

		int child = 0;
		
		for (int i = 0; i < silver.length; i++) {
			if(silver[i]!=null){
				if (silver[i].getHolder().getAge() >=0 && silver[i].getHolder().getAge() < Configuration.CHILDREN_EXMAX_AGE)
					child++;
			}
			
		}
		for (int i = 0; i < gold.length; i++) {
			if(gold[i]!=null){
				if (gold[i].getHolder().getAge() >=0 && gold[i].getHolder().getAge() < Configuration.CHILDREN_EXMAX_AGE)
					child++;
			}
			
		}
		return child;
	}

	@Override
	public int getNumberOfAttendingAdults() {

		int adultSilver = 0;
		int adultGold = 0;

		for(int i=0; i < silver.length; i++) {
			 if(silver[i]!=null){
				 if(silver[i].getHolder().getAge() >= Configuration.CHILDREN_EXMAX_AGE && silver[i].getHolder().getAge() < Configuration.ELDERLY_PERSON_INMIN_AGE)
					adultSilver++;
			 }		
		}
	
		for(int i=0; i < gold.length; i++) {
			if(gold[i]!=null){
				if(gold[i].getHolder().getAge() >= Configuration.CHILDREN_EXMAX_AGE && gold[i].getHolder().getAge() < Configuration.ELDERLY_PERSON_INMIN_AGE)
					adultGold++;
			}
		}
		return adultSilver + adultGold;
	}

	@Override
	public int getNumberOfAttendingElderlyPeople() {

		int elder = 0;

		for (int i = 0; i < silver.length; i++) {
			if (silver[i] != null) {
				if (silver[i].getHolder().getAge() >= Configuration.ELDERLY_PERSON_INMIN_AGE)
					elder++;
			}

		}
		for (int i = 0; i < gold.length; i++) {
			if(gold[i]!=null){
				if (gold[i].getHolder().getAge() >= Configuration.ELDERLY_PERSON_INMIN_AGE)
					elder++;
			}
			
		}
		return elder;
	}

	@Override
	public int getNumberOfSoldSeats() {

		return getNumberOfSoldGoldSeats() + getNumberOfSoldSilverSeats();
	}

	@Override
	public int getNumberOfSoldGoldSeats() {
		// TODO Auto-generated method stub
		int soldG = 0;

		for (int i = 0; i < gold.length; i++) {
			if (gold[i] != null)
				soldG++;
		}
		return soldG;
	}

	@Override
	public int getNumberOfSoldSilverSeats() {
		// TODO Auto-generated method stub
		int soldS = 0;

		for (int i = 0; i < silver.length; i++) {
			if (silver[i] != null)
				soldS++;
		}
		return soldS;
	}

	@Override
	public int getNumberOfSeats() {
		// TODO Auto-generated method stub
		return getNumberOfGoldSeats() + getNumberOfSilverSeats()+getNumberOfSoldGoldSeats() + getNumberOfSoldSilverSeats();
	}

	@Override
	public int getNumberOfGoldSeats() {
		// TODO Auto-generated method stub
		return nGold - getNumberOfSoldGoldSeats();
	}

	@Override
	public int getNumberOfSilverSeats() {
		
		return nSilver - getNumberOfSoldSilverSeats();
	}

	@Override
	public int getNumberOfAvailableSeats() {

		return getNumberOfSeats() - (getNumberOfSoldGoldSeats() + getNumberOfSoldSilverSeats());
	}

	@Override
	public Seat getSeat(int pos, Type type) {
		// TODO Auto-generated method stub
		if(pos<=0 || pos>gold.length || pos > silver.length)
			return null;
		if (type == Type.GOLD && gold[pos - 1]!= null) // Si es de
																	// tipo oro
																	// y el
																	// asiento
																	// está
																	// ocupado
			return gold[pos - 1]; // Devolvemos el asiento oro
		else if (type == Type.SILVER && silver[pos - 1]!= null) // Si
																				// es
																				// de
																				// tipo
																				// plata
																				// y
																				// el
																				// asiento
																				// está
																				// ocupado
			return silver[pos - 1]; // Devolvemos el asiento plata

		else
			return null; // Si no está ocupada, retornamos null
	}

	@Override
	public Person refundSeat(int pos, Type type) {

		// Comprobacion inicial si la posicion no existe o se sale del array
		// devuelve null
		if (pos <= 0 || pos > gold.length || pos > silver.length)
			return null;
		if (getSeat(pos, type) == null)
			return null;
		// Obtenemos la cual queremos dejar el asiento vacio
		Person p = getSeat(pos, type).getHolder();
		// Comprobamos si es tipo GOLD y la persona ocupa esa butaca en esa posi
		// Ponemos esa posicion a null
		// Y devolvemos la persona
		if (type == Type.GOLD && gold[pos - 1].getHolder().equals(p)) {
			gold[pos - 1] = null;
			return p;
			// Comprobamos si es tipo Silver y la persona en esa posicion es
			// igual a la persona que
			// hemos obtenido.
			// Ponemos esa posicion a null
			// Y devolvemos la persona
		} else if (type == Type.SILVER && silver[pos - 1].getHolder().equals(p)) {
			silver[pos - 1] = null;
			return p;
		}

		return null;
	}

	@Override
	public boolean sellSeat(int pos, Person p, Type type) {
		// TODO Auto-generated method stub
		if (type == type.GOLD) { 								// Si la persona quiere asiento GOLD
			Seat seat = new Seat(this, pos, Type.GOLD, p); // Creamos
 
			// asiento GOLD
			if(!isSilver(p) && gold[pos-1]==null && pos-1 < gold.length){
				gold[pos-1] = seat;
				return true;
			}
			
		} else { // Si la persona quiere asiento SILVER
			Seat seat = new Seat(this, pos, Type.SILVER, p);
			// Creamos

			if(!isGold(p) && silver[pos-1]==null && pos-1 < silver.length){
				silver[pos-1] = seat;
				return true;
			}										
		}
		return false; // ¿Ninguna opcion? Pues false
	}

	@Override
	public List<Integer> getAvailableGoldSeatsList() {
		// TODO Auto-generated method stub
		List<Integer> listGold = new ArrayList<Integer>();

		for (int i = 0; i < gold.length; i++) {
			if (gold[i] == null)
				listGold.add(i);
		}
		return listGold;
	}

	@Override
	public List<Integer> getAvailableSilverSeatsList() {
		// TODO Auto-generated method stub
		List<Integer> listSilver = new ArrayList<Integer>();

		for (int i = 0; i < silver.length; i++) {
			if (silver[i] == null)
				listSilver.add(i);
		}

		return listSilver;
	}

	@Override
	public Double getPrice(Seat seat) {

		if (seat.getType() == Type.GOLD) {
			return priceGold;
		} else {
			return priceSilver;
		}
	}

	@Override
	public Double getCollectionEvent() {
		// TODO Auto-generated method stub
		double total = 0;
		int countG = 0;
		int countS = 0;

		for (int i = 0; i < getNumberOfSoldSeats(); i++) { // Mientras no
															// hayamos recorrido
															// TODAS las butacas
															// vendidas,
															// seguimos sumando
			if (countG < getNumberOfSoldGoldSeats()) // Si contador de gold es
														// menor que el número
														// de butacas gold
				countG ++;										// vendidas
				total += this.priceGold;
											// Que vaya sumando el precio de las
											// butacas gold al total
			if (countS < getNumberOfSoldSilverSeats()) // Si contador de silver
														// es menor que el
														// número de butacas
				countS++;										// silver vendidas
				total += this.priceSilver; // Que vaya sumando el precio de las
											// butacas silver al total
		}
		return total; // Devolvemos la suma de dinero total
	}

	@Override
	public int getPosPersonGold(Person p) {

		int posGold = 0;
		for (int i = 0; i < gold.length; i++) {
			if(gold[i]!=null && gold[i].getHolder().equals(p)) {
				posGold = gold[i].getPosition();
				return posGold;
			}
		}
		return -1;
	}

	@Override
	public int getPosPersonSilver(Person p) {

		int posSilver = 0;
		for (int i = 0; i < silver.length; i++) {
			if(silver[i]!=null && silver[i].getHolder().equals(p)) {
				posSilver = silver[i].getPosition();
				return posSilver;
			}
		}
		return -1;
	}

	@Override
	public boolean isGold(Person p) {

		for (int i = 0; i < gold.length; i++) {
			if (gold[i]!=null && gold[i].getHolder().equals(p))
				return true;
		}
		return false;
	}

	@Override
	public boolean isSilver(Person p) {

		for (int i = 0; i < silver.length; i++) {
			if (silver[i]!=null && silver[i].getHolder().equals(p))
				return true;
		}
		return false;
	}

}