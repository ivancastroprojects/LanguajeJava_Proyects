package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Team 5A
 *
 */
public class WeekTest {

	Week week;
	
	Time time1;
	Time time2;
			
	@Before
	public void setUp() throws BlablakidException {
		this.week = new Week(8);
	}
	
	
	@Test
	public void testSearchDayOfWeek() {
		Day day = new Day(3);
		assertEquals(day.toString(), this.week.search(3).toString());
	}
	
	@Test
	public void getNumDays() {
		assertEquals(5, week.getNumDays());
	}
	
	@Test
	public void testRemoveRide() throws BlablakidException {
		this.time1 = new Time("08", "00");
		this.time2 = new Time("12", "30");
		
		Ride ride1 = new Ride("Ordonho", "Burgos", time1, time2, "Balonmano");
		
		this.week.addRide(0, ride1);
		
		this.week.removeRide(0, "Ordonho", "Burgos");
	}
	
	@Test
	public void testGetDayName() throws BlablakidException {
		assertEquals("MONDAY", this.week.getDayName(0));
		assertEquals("TUESDAY", this.week.getDayName(1));
		assertEquals("WEDNESDAY", this.week.getDayName(2));
		assertEquals("THURSDAY", this.week.getDayName(3));
		assertEquals("FRIDAY", this.week.getDayName(4));
	}
	
	@Test
	public void testToString() throws BlablakidException {
		this.time1 = new Time("08", "00");
		this.time2 = new Time("12", "30");
		
		Ride ride1 = new Ride("Ordonho", "Burgos", time1, time2, "Balonmano");
		
		this.week.addRide(0, ride1);
		
		assertEquals(this.week.toString(),"MONDAY\nOrdonho > Burgos : 08:00/12:30\n");
	}
		
}
