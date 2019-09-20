package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DayTest {
	
	Day day1;
	Time timeSalida;  
	Time timeVuelta; 
	
	Ride ride; 
	@Before
	public void setUp() throws BlablakidException {
		
		this.timeSalida = new Time("16", "45");
		this.timeVuelta = new Time("18", "30");
		
		ride = new Ride("Casa", "Palomera", timeSalida, timeVuelta, "Baloncesto");
		
		this.day1 = new Day(2);
		
		
	}
	
	@Test
	public void testRemoveRide() throws BlablakidException {
		
		this.day1.addRide(ride);
		assertTrue(this.day1.removeRide("Casa", "Palomera"));
		
		
	}
	
	@Test
	public void testGetRides() throws BlablakidException {
		this.day1.addRide(this.ride);
		assertEquals(this.day1.getRides().toString(), "Casa > Palomera : 16:45/18:30\n");
		
		
	}
	
}
