package ule.edi.SimpleList;


import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ule.edi.model.Person;


public class SingleLinkedListImplTests {

	

	private SingleLinkedListImpl<String> lS;
	private SingleLinkedListImpl<String> lSABC;
	

	@Before
	public void setUp() {
		this.lS = new SingleLinkedListImpl<String>();
		this.lSABC = new SingleLinkedListImpl<String>("A", "B", "C");

	}
	
   @Test
   public void constructorElemens(){
	   lS=new SingleLinkedListImpl<String>("A", "B", "C", "D");
	   Assert.assertEquals("[A, B, C, D]", lS.toString());
	   Assert.assertEquals("[A, B, C]", lSABC.toString());
   }
   
   @Test
   public void isEmptyTest(){
	   Assert.assertEquals(true, lS.isEmpty());
	   Assert.assertEquals(false, lSABC.isEmpty());
   }
   
   @Test
   public void sizeTest(){
	   Assert.assertEquals(0, lS.size());
	   Assert.assertEquals(3, lSABC.size());
   }
   
   @Test
   public void addFirstTest(){
	   lS.addFirst("Q");
	   lS.addFirst("A");
	   Assert.assertEquals("[A, Q]", lS.toString());
   }
   
   @Test
   public void addLastTest(){
	   lS.addLast("O");
	   Assert.assertEquals("[O]", lS.toString());
	   lS.addLast("R");
	   lS.addLast("P");
	   Assert.assertEquals("[O, R, P]", lS.toString());
   }
   
   @Test
   public void addAtPos(){
	   
	   lS.addAtPos("A", 1);
	   Assert.assertEquals("[A]", lS.toString());
	   lS.addAtPos("C", 1);
	   Assert.assertEquals("[C, A]", lS.toString());
	   lS.addAtPos("B", 2);
	   Assert.assertEquals("[C, B, A]", lS.toString());
	   lS.addAtPos("D", 5);
	   Assert.assertEquals("[C, B, A, D]", lS.toString());
   }
   
   @Test
   public void addNTimes(){
	   
	   lS.addNTimes("A", 3);
	   Assert.assertEquals("[A, A, A]", lS.toString());
	   lS.addNTimes("B", 2);
	   Assert.assertEquals("[A, A, A, B, B]", lS.toString());
	   
   }
   
   @Test
   public void testIndexOf(){
	   Assert.assertEquals(2, lSABC.indexOf("B"));
	   Assert.assertEquals(1, lSABC.indexOf("A"));
	   Assert.assertEquals(3, lSABC.indexOf("C"));
   }
   
   @Test(expected = NoSuchElementException.class)
  	public void testIdexOfException() {
  		lSABC.indexOf("D");
  	}
   
   @Test
   public void testRemoveLast() throws EmptyCollectionException{
	   Assert.assertEquals("C", lSABC.removeLast());
	   Assert.assertEquals("[A, B]", lSABC.toString());
	   Assert.assertEquals("B", lSABC.removeLast());
	   Assert.assertEquals("[A]", lSABC.toString());
	   Assert.assertEquals("A", lSABC.removeLast());
	   Assert.assertEquals("[]", lSABC.toString());
   }
   

   
   @Test
   public void testRemoveLastElem() throws EmptyCollectionException {
	   lS.addFirst("C");
	   lS.addFirst("A");
	   lS.addFirst("B");
	   Assert.assertEquals("A", lS.removeLast("A"));
	   lSABC.addLast("B");
	   lSABC.addLast("O");
	   lSABC.addLast("A");
	   Assert.assertEquals("A", lSABC.removeLast("A"));
	   Assert.assertEquals("A", lSABC.removeLast("A"));
   }
   
   @Test(expected = EmptyCollectionException.class)
 	public void testRemoveLastException() throws EmptyCollectionException {
 		lS.removeLast("M");
 	}
   
   @Test(expected = NoSuchElementException.class)
	public void testRemoveLastElemenException() throws EmptyCollectionException{
		lSABC.removeLast("G");
	}
   
	@Test 
	public void testReverse()
	{
		 Assert.assertEquals("[]", lS.reverse().toString());
		 Assert.assertEquals("[C, B, A]", lSABC.reverse().toString());

	}
   
// TEST DE SUBLIST
	@Test
	public void tesSubListEnListaVacia() {
	
		Assert.assertEquals(-1, lS.isSubList(lSABC));		
	}

		@Test
		public void tesSubListConSubListaVacia() {
			Assert.assertEquals(1, lSABC.isSubList(lS));		
		}
		
		
		@Test
		public void subListVarios() {
			lS = new SingleLinkedListImpl<String>("A", "B", "C", "D", "E");
			Assert.assertEquals(1, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("Z", "X", "A", "B", "C", "D", "E");
			Assert.assertEquals(3, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("Z", "X", "A", "B", "C");
			Assert.assertEquals(3, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("A", "B", "C");
			Assert.assertEquals(1, lS.isSubList(lSABC));	
		}
	 
		   @Test
		   public void testForwardIterator() {
			   Iterator<String> iteratorE = lS.iterator();
			   
			   Iterator<String> iteratorF = lSABC.iterator();
			   
			  Assert.assertEquals(false, iteratorE.hasNext());
			  
			  Assert.assertEquals(true, iteratorF.hasNext());
			  Assert.assertEquals("B", iteratorF.next());
			  Assert.assertEquals(true, iteratorF.hasNext());
			  Assert.assertEquals("C", iteratorF.next());
			  Assert.assertEquals(false, iteratorF.hasNext());
		   }
		   
		   @Test(expected = NoSuchElementException.class)
			public void testForwardIteratorException() {
				Iterator<String> i = lS.iterator();
				i.next();
			}

}
