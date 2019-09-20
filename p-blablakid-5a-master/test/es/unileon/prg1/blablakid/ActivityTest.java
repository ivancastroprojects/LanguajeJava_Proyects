package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ActivityTest {
	
	Activity activity1;
	Activity activity2;
	Activity activity3;
	
	@Before
	//String name, String place, int day, String kid, int startHours, int startMinutes, int endHours, int endMinutes
	public void setUp() throws BlablakidException {
		Time timeStart_activity1 = new Time("18", "40");
		Time timeEnd_activity1 = new Time("20", "00");
		this.activity1 = new Activity("Baloncesto", "Palomera",0, "Paco", timeStart_activity1, timeEnd_activity1);
		
		Time timeStart_activity2 = new Time("17", "00");
		Time timeEnd_activity2 = new Time("18", "00");
		this.activity2 = new Activity("Balonmano", "Palomera", 1, "Manu", timeStart_activity2, timeEnd_activity2);
		
		Time timeStart_activity3 = new Time("17", "30");
		Time timeEnd_activity3 = new Time("19", "00");
		
		this.activity3 = new Activity("Fútbol", "Campus", 2, "Sergio",timeStart_activity3,  timeEnd_activity3);
		
	}
	
	@Test
	public void testActivity() throws Exception {
		assertEquals("Baloncesto", this.activity1.getName());
		assertEquals("Balonmano", this.activity2.getName());
		assertEquals("Fútbol", this.activity3.getName());
	}
	
	@Test (expected = BlablakidException.class)
	public void testWrongDay() throws Exception {
		Time timeStart_activity1 = new Time("18", "40");
		Time timeEnd_activity1 = new Time("20", "00");
		
		new Activity("Baloncesto", "Palomera",-1, "Paco", timeStart_activity1, timeEnd_activity1);
		new Activity("Baloncesto", "Palomera",8, "Paco", timeStart_activity1, timeEnd_activity1);
	}
	
	@Test
	public void testActivityGetPlace() {
		assertEquals(this.activity1.getPlace(), "Palomera");
		assertEquals(this.activity2.getPlace(), "Palomera");
		assertEquals(this.activity3.getPlace(), "Campus");
		
	}
	
	@Test
	public void testActivitySetPlace() {
		this.activity1.setName("Palomera");
		assertEquals(this.activity1.getPlace().toString(), "Palomera");
		this.activity2.setPlace("Palomera");
		assertEquals(this.activity2.getPlace().toString(), "Palomera");
		this.activity3.setPlace("Campus");
		assertEquals(this.activity3.getPlace().toString(), "Campus");
		
	}
	@Test
	public void testActivityGetDay() {
		assertEquals(this.activity1.getDay(), 0);
		assertEquals(this.activity2.getDay(), 1);
		assertEquals(this.activity3.getDay(), 2);
		
	}
	
	@Test
	public void testActivitySetDay() {
		this.activity1.setDay(1);
		this.activity2.setDay(1);
		this.activity3.setDay(3);
		
	}
	
	@Test
	public void testActivityGetKid() {
		assertEquals(this.activity1.getKid(), "Paco");
		assertEquals(this.activity2.getKid(), "Manu");
		assertEquals(this.activity3.getKid(), "Sergio");
		
	}
	
	@Test
	public void testActivitySetKid() {
		
		this.activity1.setKid("Paco");
		
		this.activity2.setKid("Manu");
		
		this.activity3.setKid("Sergio");
		
		assertEquals(this.activity1.getKid(), "Paco");
		assertEquals(this.activity2.getKid(), "Manu");
		assertEquals(this.activity3.getKid(), "Sergio");
	}
	

	@Test
	public void testGetStartTimeOk() {
		//System.out.println("A ver que hago... "+ this.activity1.getStartActivity());
		assertEquals(this.activity1.getStartActivity().toString(), "18:40");
		assertEquals(this.activity2.getStartActivity().toString(), "17:00");
		assertEquals(this.activity3.getStartActivity().toString(), "17:30");
		
	}
	
	@Test
	public void testSetStartTimeOk() {
		
		this.activity1.setStartActivity(this.activity1.getStartActivity());
		this.activity2.setStartActivity(this.activity2.getStartActivity());
		this.activity3.setStartActivity(this.activity3.getStartActivity());
		
	}
	
	@Test
	public void testGetEndActivity() {
		
		assertEquals(this.activity1.getEndActivity().toString(), "20:00");
		assertEquals(this.activity2.getEndActivity().toString(), "18:00");
		assertEquals(this.activity3.getEndActivity().toString(), "19:00");
		
	}
	
	@Test
	public void testSetEndActivity() {
		
		this.activity1.setEndActivity(this.activity1.getEndActivity());
		this.activity2.setEndActivity(this.activity2.getEndActivity());
		this.activity3.setEndActivity(this.activity3.getEndActivity());
	}
	
	@Test
	public void testGetDay() throws BlablakidException {
		
		assertEquals(this.activity1.getDayName(), "MONDAY");
		assertEquals(this.activity2.getDayName(), "TUESDAY");
		assertEquals(this.activity3.getDayName(), "WEDNESDAY");
		
		Time timeStart_activity4 = new Time("18","30");
		Time timeEnd_activity4 = new Time("19","30");
		Activity activity4 = new Activity("Baloncesto", "Palomera",4, "Paco", timeStart_activity4, timeEnd_activity4);
		assertEquals(activity4.getDayName(), "FRIDAY");
		Activity activity5 = new Activity("Baloncesto", "Palomera",3, "Paco", timeStart_activity4, timeEnd_activity4);
		assertEquals(activity5.getDayName(), "THURSDAY");
	
	}
	
}
