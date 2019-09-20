package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ActivitiesTest {
	
	Activity activity1;
	Activity activity2;
	Activity activity3;
	Activity activity4;
	
	Activities activities;
	
	Time time1;
	Time time2;
	
	@Before
	public void setUp() throws BlablakidException {
		this.activities = new Activities();
		
		time1 = new Time("18", "30");
		time2 = new Time("19", "50");
		this.activity1 = new Activity("Baloncesto", "Palomera", 3, "Manu", time1, time2);
		
		this.activities.add(activity1);
	}
	
	@Test
	public void testAddOk() throws BlablakidException {
		this.activity2 = new Activity("Natacion", "Centro", 4, "Manu", time1, time2);
		
		this.activities.add(activity2);
	}
	
	@Test
	public void testShowActivity() throws BlablakidException {
		assertEquals(this.activities.showActivity(0).toString(), activity1.toString()); 
	}
	
	@Test (expected = BlablakidException.class)
	public void testAddActivityRepeated() throws BlablakidException {
		this.activity2 = new Activity("Baloncesto", "Palomera", 3, "Manu", time1, time2);
		
		this.activities.add(activity2);
	}
	
	@Test (expected = BlablakidException.class)
	public void testAddActivityFull() throws BlablakidException {
		this.activity2 = new Activity("Natacion", "Centro", 4, "Manu", time1, time2);
		this.activity3 = new Activity("Tenis", "Badalona", 2, "Manu", time1, time2);
		this.activity4 = new Activity("Futbol", "Vallecas", 0, "Manu", time1, time2);
		
		this.activities.add(activity2);
		this.activities.add(activity3);
		this.activities.add(activity4);
	}
	
	@Test 
	public void testSearchOk() throws BlablakidException {		
		assertEquals(this.activities.search("Baloncesto").toString(), this.activity1.toString());
	}
	
	@Test (expected = BlablakidException.class)
	public void testSearchFail() throws BlablakidException {
		assertEquals(this.activities.search("Tenis"), null);
	}
	
	@Test
	public void testRemoveActivityOk() throws BlablakidException {
		assertTrue(this.activities.remove("Baloncesto"));
	}
	
	@Test (expected = BlablakidException.class)
	public void testRemoveActivitiesNotExists() throws BlablakidException {
		this.activities.remove("Capoeira");
	}
	
	@Test
	public void testToString() throws BlablakidException {
		assertEquals(this.activities.toString(),"Baloncesto (Palomera - THURSDAY)18:30 > 19:50\n");
	}

}
