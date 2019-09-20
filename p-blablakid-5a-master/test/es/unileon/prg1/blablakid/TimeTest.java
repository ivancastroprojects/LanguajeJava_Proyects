package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	
	Time time1; 
	Time time2;
	
	@Before
	public void setUp() throws BlablakidException {
		
		time1 = new Time("18", "30");
		time2 = new Time("19", "00");
	}
	
	@Test
	public void testTimeCorrect() {
		
		assertEquals(this.time1.toString(),"18:30");
		assertEquals(this.time2.toString(), "19:00");
		
	}
	
	@Test(expected = BlablakidException.class)
	public void testTimeIncorrectHour() throws BlablakidException {
		
		time1 = new Time("25", "00");
		
		time2 = new Time("-22", "00");
		
	}
	
	@Test(expected = BlablakidException.class)
	public void testTimeIncorrectMinutes()throws BlablakidException {
		
		time1 = new Time("17", "76");
		
		time2 = new Time("17", "-20");
	}
	
	@Test
	public void testToStringTime() throws BlablakidException {
		
		time1 = new Time("18", "45");
		assertEquals(time1.toString(), "18:45");
	}

}
