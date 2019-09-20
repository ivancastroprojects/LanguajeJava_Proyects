package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RidesTest {
	
	Rides rides;
	Rides ridesRepe;
	Ride ride1;
	Ride ride2;
	Ride repeatRide;
	
	Time timeSalida;
	Time timeVuelta;
	Time timeStaActivity;
	Time timeEndActivity;
	Activity activity;
	
	
	Activity act2;
	Time timeSalida2;
	Time timeVuelta2;
	
	Time timeStActivity2;
	Time timeVActivity2;
	
	Day day;
	
	Kid kid1;
	
	@Before
	public void setUp() throws BlablakidException {
		
		this.rides = new Rides(1);
		this.timeSalida = new Time("16", "45");
		this.timeVuelta = new Time("18", "45");
		
		this.timeStaActivity = new Time("17", "00");
		this.timeEndActivity = new Time("18", "30");
		
		this.day = new Day(1);
		
		this.kid1 = new Kid("Susana");
		this.activity = new Activity("Baloncesto", "Palomera", 0, this.kid1.getName(), this.timeStaActivity, this.timeEndActivity);
	
		
		this.timeStActivity2 = new Time("17", "30");
		this.timeVActivity2 = new Time("18", "45");
		
		this.act2 = new Activity("Futbol", "Palomera", 0, this.kid1.getName(), this.timeStaActivity, this.timeEndActivity);
		
		this.ride1 = new Ride("Casa", "Palomera", timeSalida, timeVuelta, "Baloncesto");
		this.ride2 = new Ride("Campus", "Palomera", timeStActivity2, timeVActivity2,"Futbol");
		
		this.ridesRepe = new Rides(2);
		
	}
	
	@Test
	public void testAddRide() throws BlablakidException {
		assertTrue(this.rides.add(this.ride1));		
	}
	@Test(expected = BlablakidException.class)
	public void testAddRideFull() throws BlablakidException{		
		this.rides.add(this.ride1);
		assertEquals(this.rides.add(this.ride2), "La lista de rides esta llena");		
	}
	
	@Test(expected = BlablakidException.class)
	public void testAddRideExist() throws BlablakidException {		
		this.rides.add(this.ride1);
		this.repeatRide = this.ride1;
		this.ridesRepe.add(ride1);
		assertEquals(this.ridesRepe.add(this.repeatRide), "El ride ya existe");		
	}
	
	@Test
	public void testGetRide() throws BlablakidException {
		
		this.rides.add(this.ride1);
		assertEquals(this.rides.getRide(0).toString(),"Ride [whereStartRide=Casa, whereEndRide=Palomera, startRide=16:45, endRide=18:45, nombreActividad=Baloncesto]");
	}

	
	@Test
	public void testRemoveRideCorrect() throws BlablakidException {
		
		this.ridesRepe.add(this.ride1);
		this.ridesRepe.add(this.ride2);
		assertTrue(this.ridesRepe.remove("Campus", "Palomera"));
	}
	
	@Test(expected = BlablakidException.class)
	public void testRemoveRideError() throws BlablakidException{
		
		this.ridesRepe.add(this.ride1);
		assertEquals(this.ridesRepe.remove("Campus", "Palomera"), "El ride no existe");
	}
	
	@Test
	public void testSearchRide() throws BlablakidException {
		this.rides.add(this.ride1);
		assertEquals(this.rides.search("Casa", "Palomera"), this.ride1);
		
	}
	
	@Test
	public void testSearchRideError()throws BlablakidException{		
		assertEquals(this.rides.search("Casa", "Palomera"), null);
	}
	
	@Test
	public void testToString() throws BlablakidException {
		this.ridesRepe.add(this.ride1);
		this.ridesRepe.add(this.ride2);
	
		assertEquals(this.ridesRepe.toString(),"Casa > Palomera : 16:45/18:45\n"+"Campus > Palomera : 17:30/18:45\n");
	}
}
