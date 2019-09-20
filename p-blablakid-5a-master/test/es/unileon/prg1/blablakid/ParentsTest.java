package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ParentsTest {

	Parents arrayParents = new Parents(2);
	
	Kid kid1 = new Kid("Andrea");
	Kid kid2 = new Kid("Roberto");
	Kid kid3 = new Kid("Maria");
	Parent parent1;
	
	Parent parent2;
	Kid kid1Parent2 = new Kid("Javi");
	Kid kid2Parent2 = new Kid("Fernando");
	
	@Before
	public void setUp() throws BlablakidException{
		
		String [] kidsNames = {this.kid1.getName(), this.kid2.getName(), this.kid3.getName()};		
		
		this.parent1 = new Parent("Juan", 3, 2, kidsNames);
		this.arrayParents.add(parent1);
		
		String[] kidsNameParents2 = {this.kid1Parent2.getName(), this.kid2Parent2.getName()};
		this.parent2 = new Parent("Mariano", 2, 2, kidsNameParents2);
		
		this.arrayParents.add(parent2);
		
	}
	
	@Test
	public void testGetMaxParents() {		
		assertEquals(this.arrayParents.getMaxParents(), 2);		
	}
	
	@Test
	public void testShowParent() throws BlablakidException {		
		assertEquals(this.arrayParents.showParent(0).toString(),this.parent1.toString());
		assertEquals(this.arrayParents.showParent(1).toString(), this.parent2.toString());
		
	}
	
	@Test(expected = BlablakidException.class)
	public void testShowParentError() throws BlablakidException{		
		assertEquals(this.arrayParents.showParent(3).toString(), "3 excede los limites del array");		
	}
	
	@Test(expected = BlablakidException.class)
	public void testAddParentRepeatParent() throws BlablakidException {		
		Kid kidParent3 = new Kid("Clara");
		String[] nameK = {kidParent3.getName()};
		
		Parent parent3 = new Parent("Mariano", 1, 1, nameK);
		
		assertEquals(this.arrayParents.add(parent3), "El padre ya existe");		
	}
	
	@Test(expected = BlablakidException.class)
	public void testAddParentFull() throws BlablakidException {
		Kid kidParent3 = new Kid("Clara");
		String[] nameK = {kidParent3.getName()};
		
		Parent parent3 = new Parent("Marco", 1, 1, nameK);
		assertEquals(this.arrayParents.add(parent3), "La lista de padres esta llena");		
	}
	
	@Test(expected = BlablakidException.class)
	public void testParentExistError() {		
		assertEquals(this.arrayParents.exists("Josue"), -1);	
	}
	
	
	@Test
	public void testParentExist() {		
		assertEquals(this.arrayParents.exists("Mariano"), 1);	
	}
	
	@Test
	public void searchParent() throws BlablakidException {	
		assertEquals(this.arrayParents.search("Juan").toString(), this.parent1.toString());
	}
	
	@Test(expected = BlablakidException.class)
	public void searchParentError() throws BlablakidException {	
		assertEquals(this.arrayParents.search("Miguel"), "El padre no existe");
	}
	
	@Test
	public void testRemoveParent() throws BlablakidException {		
		assertTrue(this.arrayParents.remove("Juan"));
		
		assertEquals(this.arrayParents.showParent(1), null);		
	}
	
	@Test(expected = BlablakidException.class)
	public void testRemoveParentError() throws BlablakidException {		
		assertEquals(this.arrayParents.remove("Martin"), "El padre no existe");
	}
	
	@Test
	public void testRemoveKid() {
		this.arrayParents.removeKid("Maria");		
	}
	
	@Test
	public void testToString() {		
		assertEquals(this.arrayParents.toString(),"###### Juan ######\nKids:\nAndrea\nRoberto\nMaria\nRides:\n###### Mariano ######\nKids:\nJavi\nFernando\nRides:\n");		
	}
	
	@Test
	public void testSearchRideByAct() throws BlablakidException {
		Time timeEmp = new Time("17", "00");
		Time timeFin = new Time("18", "30");
		Activity act = new Activity("Balonmano", "Palomera",0, "Andrea", timeEmp, timeFin);
		
		Time timeRide = new Time("16", "45");
		Time timeRide2 = new Time("19", "00");		
		Ride ride1 = new Ride("Casa", "Palomera", timeRide, timeRide2, act.getName());
		
		this.parent1.addRide(0, ride1);

		this.arrayParents.searchRideByAct(act.getName());
	}
	
}
