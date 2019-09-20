package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RideTest {
	
	Ride ride1;
	Ride ride2;
	Ride ride3;
	
	@Before
	public void setUp() throws Exception{
		
		Time time1 = new Time("16", "30");
		
		Time time2 = new Time ("17", "20");
		
		this.ride1 = new Ride("Casa", "Palomera", time1, time2, "Juan");
		
		
		Time time1Sec = new Time("17", "30");
		Time time2Sec = new Time("18", "00");
		this.ride2 = new Ride("Palomera", "Casa", time1Sec, time2Sec, "Juan");
		
		Time time1Salida = new Time("19", "15");
		Time time2Llegada = new Time("19", "30");
		
		this.ride2 = new Ride("Casa", "Campus", time1Salida, time2Llegada, "Jesús");
	}

	@Test
	
	public void testGetWhereStartRide() {
		
		assertEquals(this.ride1.getWhereStartRide(),"Casa");
		assertEquals(this.ride2.getWhereStartRide(),"Casa");
		
	}
	
	@Test
	public void testGetWhereEndsRide() {
		
		assertEquals(this.ride1.getWhereEndRide(),"Palomera");
		assertEquals(this.ride2.getWhereEndRide(), "Campus");
		
	}
	
	
	@Test
	public void testSetWhereStartRide() {
		
		this.ride1.setWhereStartRide("Casa");
		assertEquals(this.ride1.getWhereStartRide(), "Casa");
	}
	
	@Test
	public void testSetWhereEndeRide() {
		
		this.ride1.setWhereEndRide("Palomera");
		assertEquals(this.ride1.getWhereEndRide(), "Palomera");
	}
	
	@Test
	public void testGetStartRide() {
		
		assertEquals(this.ride1.getStartRide().toString(), "16:30");
		assertEquals(this.ride2.getStartRide().toString(), "19:15");
		
	}
	
	@Test
	public void testGetEndRide() {
		
		assertEquals(this.ride1.getEndRide().toString(), "17:20");
		assertEquals(this.ride2.getEndRide().toString(), "19:30");
		
	}
	
	@Test
	public void testSetStartRide() {
	
		this.ride1.setStartRide(this.ride1.getStartRide());
		this.ride2.setStartRide(this.ride2.getStartRide());
	
	}
	
	@Test
	public void tesSetEndRide() {
		this.ride1.setEndRide(this.ride1.getEndRide());
		this.ride2.setEndRide(this.ride2.getEndRide());
	
		
	}
	
	@Test
	public void testSetNameAct() {
		
		this.ride1.setNameAct(this.ride1.getNameAct());
		this.ride2.setNameAct(this.ride2.getNameAct());
	
	}
	@Test
	public void testGetNameAct() {
		
		this.ride1.setNameAct("Baloncesto");
		assertEquals(this.ride1.getNameAct(), "Baloncesto");
		
	}
	
	@Test
	public void testRideToString() {
		
		assertEquals(this.ride1.toString(), "Ride [whereStartRide=Casa, whereEndRide=Palomera, startRide=16:30, endRide=17:20, nombreActividad=Juan]");
	}
}
