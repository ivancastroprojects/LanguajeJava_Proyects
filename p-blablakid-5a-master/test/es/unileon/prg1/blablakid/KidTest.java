package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;
//import es.unileon.prg1.blablakid.BlablakidException;
import es.unileon.prg1.blablakid.Kid;
import org.junit.Before;
import org.junit.Test;

public class KidTest {
	Kid kid1;
	Kid kid2;
	Kid kid3;
	
	Activities arrayActivities;
	
	Activity activity1;
	@Before
	public void setUp() throws Exception{
		this.kid1 = new Kid("Sergio");
		this.kid2 = new Kid("Paco");
		this.kid3 = new Kid("Manu");
	}
	
	@Test
	public void testKid() throws Exception{
		assertEquals("Sergio", this.kid1.getName());
	}
	
	@Test
	public void testActivitiesOfKid() throws Exception{
		Time time1 = new Time("18", "30");
		Time time2 = new Time("19", "50");
		this.activity1 = new Activity("Baloncesto", "Palomera", 3, "Manu", time1, time2);
		this.arrayActivities = new Activities();
		
		this.arrayActivities.add(activity1);
		
		assertTrue(this.kid1.addActivityToKid(this.activity1));
		
		assertEquals(this.kid1.showActivityOfKid(0), this.activity1);
		
		assertEquals(this.kid1.getActivitiesOfKid().toString(), this.arrayActivities.toString());
		
		assertTrue(this.kid1.removeActivityOfKid("Baloncesto"));		
	}
}
