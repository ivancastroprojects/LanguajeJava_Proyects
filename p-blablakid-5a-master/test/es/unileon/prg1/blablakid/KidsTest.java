package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;
import es.unileon.prg1.blablakid.BlablakidException;
import es.unileon.prg1.blablakid.Kids;
import org.junit.Before;
import org.junit.Test;

public class KidsTest {
	
	Kid kid1;
	Kid kid2;
	Kid kid3;
	Kid kid4;
	
	Kids kids;
	
	@Before
	public void setUp() throws BlablakidException {
		this.kids = new Kids(3);
		this.kid1 = new Kid("Paco");
	}
	
	@Test
	public void testMaxKids() throws BlablakidException {
		assertEquals(this.kids.getMaxKids(), 3);		
	}
	
	@Test
	public void testShowKid() throws BlablakidException {
		this.kid1 = new Kid("Paco");
		
		assertTrue(this.kids.add(this.kid1));
		
		assertEquals(this.kids.showKid(0).toString(), this.kid1.toString()); 
	}
	
	@Test (expected = BlablakidException.class)
	public void testAddKidRepeated() throws BlablakidException {
		this.kid1 = new Kid("Paco");
		
		this.kids.add(this.kid1);
		this.kids.add(this.kid1);
	}
	
	@Test (expected = BlablakidException.class)
	public void testAddKidListFull() throws BlablakidException {
		this.kid1 = new Kid("Paco");
		this.kid2 = new Kid("Pepa");
		this.kid3 = new Kid("Flora");
		this.kid4 = new Kid("Eutiquio");
		
		this.kids.add(this.kid1);
		this.kids.add(this.kid2);
		this.kids.add(this.kid3);
		this.kids.add(this.kid4);
	}
	
	@Test 
	public void testSearchOk() throws BlablakidException {
		this.kid1 = new Kid("Paco");
		
		this.kids.add(kid1);
		
		assertEquals(this.kids.search("Paco").toString(), this.kid1.toString());
	}
	
	@Test (expected = BlablakidException.class)
	public void testSearchFail() throws BlablakidException {
		assertEquals(this.kids.search("Paco"), null);
	}
	
	@Test
	public void testRemoveKidOk() throws BlablakidException {
		this.kid1 = new Kid("Paco");
		
		this.kids.add(this.kid1);
		assertTrue(this.kids.remove("Paco"));
	}
	
	@Test (expected = BlablakidException.class)
	public void testRemoveKidNotExists() throws BlablakidException {
		this.kids.remove("Rosa");
	}
	
	@Test
	public void testToString() throws BlablakidException {
		this.kid1 = new Kid("Paco");
		this.kid2 = new Kid("Pepa");
		this.kid3 = new Kid("Flora");
		
		this.kids.add(this.kid1);
		this.kids.add(this.kid2);
		this.kids.add(this.kid3);
		
		assertEquals(this.kids.toString(),"****** Paco ******\n****** Pepa ******\n****** Flora ******\n");
	}

}
