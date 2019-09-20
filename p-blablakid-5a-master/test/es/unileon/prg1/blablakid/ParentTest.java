package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;
import es.unileon.prg1.blablakid.BlablakidException;
import es.unileon.prg1.blablakid.Parent;
import org.junit.Before;
import org.junit.Test;

public class ParentTest {
	Parent padre1;
  	Parent padre2;
  	Parent padre3;
	
  	Ride ride1;
  	Ride ride2;
  	Ride ride3;
  	
  	Time timeIda2;
	Time timeVuelta2;
	
	Time timeIda3;
	Time timeVuelta3;
	
	Week week;
  	
	@Before
	public void setUp() throws BlablakidException {		
		Kid kid1 = new Kid("Lucas");
		Kid kid2 = new Kid("Alberto");
		Kid kid3 = new Kid("Ronaldo");
		
		Kids sons1 = new Kids(3);
		
		sons1.add(kid1);
		sons1.add(kid2);
		sons1.add(kid3);
		
		String[] namesKids = {kid1.getName(), kid2.getName()};
		
		this.padre1 = new Parent("Carlos", 3, 2, namesKids);
		
		Kid kid4 = new Kid("Andrea");
		Kid kid5 = new Kid("Juanra");
		Kid kid6 = new Kid("Ivan");
		
		String[] nameKids2 = {kid4.getName(), kid5.getName(), kid6.getName()};
		
		this.padre2 = new Parent("Mario", 3, 4, nameKids2);
		
		Time timeIda = new Time("16", "30");
		Time timeVuelta = new Time ("17", "00");
		
		this.ride1 = new Ride("Casa", "Palomera", timeIda, timeVuelta, this.padre1.getName());
		this.week = new Week(0);
	}
	
	@Test 
	public void testParent() throws BlablakidException {		
		assertEquals(this.padre1.getName().toString(),"Carlos");		
	}
	
	@Test
	public void testGetName() throws BlablakidException {
		assertEquals("Carlos", this.padre1.getName());
		assertEquals("Mario", this.padre2.getName());		
	}
	
	@Test
	public void testGetKids() throws BlablakidException {
		assertEquals(3, this.padre1.getTotalSons(), 2);		
	}
	
	@Test
	public void testSetSonNull() throws BlablakidException {
		this.padre1.setSonNull(0);	
	}
	
	@Test
	public void testGetSonsCorrect() {
		assertEquals(this.padre1.getSon(0).toString(), "Lucas");
		assertEquals(this.padre1.getSon(1).toString(), "Alberto");
		assertEquals(this.padre2.getSon(0).toString(), "Andrea");
		assertEquals(this.padre2.getSon(1).toString(), "Juanra");
		assertEquals(this.padre2.getSon(2).toString(), "Ivan");
		
	}
	
	@Test
	public void testGetTotalRides() {		
		assertEquals(this.padre1.getTotalRides(), 2);
		assertEquals(this.padre2.getTotalRides(), 4);		
	}
	
	@Test
	public void testAddRide() throws BlablakidException {		
		this.padre1.addRide(0, this.ride1);
		
		this.ride2 = new Ride("Palomera", "Casa", timeIda2, timeVuelta2, this.padre1.getName());
		
		this.padre1.addRide(1, this.ride2);
		
	}
	@Test(expected = Exception.class)
	public void testAddRideError() throws BlablakidException {
		this.padre1.addRide(0, this.ride1);
		this.padre1.addRide(1, this.ride2);
		this.ride3 = new Ride("Casa","Sto Domingo", this.timeIda3, this.timeVuelta3, this.padre1.getName());
		assertEquals(this.padre1.addRide(2, ride3), "La lista de rides esta llena");
		
		
	}
	
	@Test
	public void testRemoveRide() throws BlablakidException {		
		Time timeIda = new Time("16", "30");
		Time timeVuelta = new Time ("17", "50");
		Ride ride1 = new Ride("Casa", "Palomera", timeIda, timeVuelta, this.padre1.getName());
		this.padre1.addRide(0, ride1);
		this.padre1.removeRide(0, "Casa", "Palomera");
	}
	
	@Test
	public void testGetWeek() {
		this.padre1.getWeek();
	}

}
