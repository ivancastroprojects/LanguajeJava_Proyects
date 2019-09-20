package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlablakidTest {

	Blablakid blablakid;
	
	String[] sons;
	
	@Before
	public void setUp() throws BlablakidException {
		this.blablakid = new Blablakid(3);
		
		sons = new String[2];
		
		sons[0] = "Manuel";
		sons[1] = "Santiago";
		
		this.blablakid.addKid(sons[0]);
		this.blablakid.addKid(sons[1]);
	}
	
	@Test
	public void testKid() throws BlablakidException {		
		this.blablakid.addActivity("Baloncesto", "Palomera", 3, "Santiago", "18", "30", "19", "50");
		
		this.blablakid.removeKid("Santiago");
	}
	
	@Test
	public void testParent() throws BlablakidException {		
		this.blablakid.addParent("Ivan", 2, 4, sons);
		
		this.blablakid.removeParent("Ivan");
	}
	
	@Test
	public void testActivity() throws BlablakidException {		
		this.blablakid.addActivity("Baloncesto", "Palomera", 3, "Santiago", "18", "30", "19", "50");
		
		this.blablakid.removeActivity("Santiago", "Baloncesto");
	}
	
	@Test
	public void testRide() throws BlablakidException {
		this.blablakid.addParent("Ivan", 2, 4, sons);
		this.blablakid.addActivity("Baloncesto", "Palomera", 3, "Santiago", "18", "30", "19", "50");
		
		this.blablakid.addRide("Ivan", "Baloncesto", "Santiago", "Casa", "Palomera", "19", "50", "20", "00", 3);
		
		this.blablakid.removeRide("Ivan", 3, "Casa", "Palomera");
	}
	@Test
	public void testToString() throws BlablakidException {
		this.blablakid.addParent("Ivan", 2, 4, sons);
		this.blablakid.addActivity("Baloncesto", "Palomera", 3, "Santiago", "18", "30", "19", "50");
		this.blablakid.addRide("Ivan", "Baloncesto", "Santiago", "Casa", "Palomera", "19", "50", "20", "00", 3);
		
		assertEquals(this.blablakid.summary(),"////////////////////////\n\nKIDS:\n\n****** Manuel ******\n****** Santiago ******\nBaloncesto (Palomera - THURSDAY)18:30 > 19:50\n\nPARENTS:\n\n###### Ivan ######\nKids:\nManuel\nSantiago\nRides:\nTHURSDAY\nCasa > Palomera : 19:50/20:00\n////////////////////////");
	}
	
	@Test
	public void testStatus() throws BlablakidException {
		assertEquals(this.blablakid.status(), null);
	}
	
}
