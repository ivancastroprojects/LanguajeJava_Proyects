package ule.edi.tree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;





public class BinarySearchTreeADTTests {

    /*
	* ∅
    */
	private BinarySearchTreeADTImpl<Integer> TE = null;
	
	/*
	* 1
	* |  ∅
	* |  2
	* |  |  ∅
	* |  |  3
	* |  |  |  ∅
	* |  |  |  4
	* |  |  |  |  ∅
	* |  |  |  |  ∅
    */	
	private BinarySearchTreeADTImpl<Integer> T1234 = null;
	
	/*
	* 4
	* |  3
	* |  |  2
	* |  |  |  1
	* |  |  |  |  ∅
	* |  |  |  |  ∅
	* |  |  |  ∅
	* |  |  ∅
	* |  ∅
    */	
	private BinarySearchTreeADTImpl<Integer> T4321 = null;

	/*
	* 50
	* |  20
	* |  |  10
	* |  |  |  ∅
	* |  |  |  ∅
	* |  |  30
	* |  |  |  ∅
	* |  |  |  ∅
	* |  80
	* |  |  70
	* |  |  |  ∅
	* |  |  |  ∅
	* |  |  90
	* |  |  |  ∅
	* |  |  |  ∅
    */	
	private BinarySearchTreeADTImpl<Integer> TC3 = null;

	/*
	* 10
	* |  5
	* |  |  ∅
	* |  |  ∅
	* |  20
	* |  |  ∅
	* |  |  30
	* |  |  |  ∅
	* |  |  |  ∅
	*/
	private BinarySearchTreeADTImpl<Integer> TEx = null;

	/*
	 * 10
	 * |  5
	 * |  |  ∅
	 * |  |  7
	 * |  |  |  6
	 * |  |  |  |  ∅
	 * |  |  |  |  ∅
	 * |  |  |  ∅
	 * |  15
	 * |  |  ∅
	 * |  |  ∅
	 * 
	 */
	private BinarySearchTreeADTImpl<Integer> TV1 = null;

	@Before
	public void setupBSTs() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(40);
		numbers.add(60);
		numbers.add(80); 
		
		TE = new BinarySearchTreeADTImpl<Integer>();
		TE.insert(numbers);
		Assert.assertEquals(TE.toString(), "{40, ∅, {60, ∅, {80, ∅, ∅}}}");
		
		T1234 = new BinarySearchTreeADTImpl<Integer>();
		T1234.insert(1,2,3,4,4); 
		Assert.assertEquals(T1234.toString(), "{1, ∅, {2, ∅, {3, ∅, {4, ∅, ∅}}}}");
		
		T4321 = new BinarySearchTreeADTImpl<Integer>();
		T4321.insert(4, 3, 2, 1);
		Assert.assertEquals(T4321.toString(), "{4, {3, {2, {1, ∅, ∅}, ∅}, ∅}, ∅}");
		
		TC3 = new BinarySearchTreeADTImpl<Integer>();
		TC3.insert(50, 20, 80, 10, 30, 70, 90);
		Assert.assertEquals(TC3.toString(), "{50, {20, {10, ∅, ∅}, {30, ∅, ∅}}, {80, {70, ∅, ∅}, {90, ∅, ∅}}}");
		
		TEx = new BinarySearchTreeADTImpl<Integer>();
		TEx.insert(10, 20, 30, 5);
		Assert.assertEquals(TEx.toString(), "{10, {5, ∅, ∅}, {20, ∅, {30, ∅, ∅}}}");
		
		TV1 = new BinarySearchTreeADTImpl<Integer>();
		TV1.insert(10, 5, 7, 6, 15);		
		Assert.assertEquals(TV1.toString(), "{10, {5, ∅, {7, {6, ∅, ∅}, ∅}}, {15, ∅, ∅}}");
		
		
	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void testinsertException() {
	  
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(null);
		numbers.add(null);
		numbers.add(null); 
		
		TE = new BinarySearchTreeADTImpl<Integer>();
		TE.insert(numbers);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testinsertException2() {
	  
		TC3 = new BinarySearchTreeADTImpl<Integer>();
		TC3.insert(null,60,70);
		
	}
	
	@Test
	public void testwithdrawBSTs() {
		TC3.withdraw(70,30,20);
		Assert.assertEquals(TC3.toString(), "{50, {10, ∅, ∅}, {80, ∅, {90, ∅, ∅}}}");
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(null);
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(5);  
		
		TEx.withdraw(numbers);;
		Assert.assertEquals(TEx.toString(), "∅");
	}
	
	@Test
	public void getSubtreeWithPathTreeTest() {
		BinarySearchTreeADTImpl<Integer> TES = new BinarySearchTreeADTImpl<Integer>();
		TES.insert(60,80);
		Assert.assertEquals(TE.getSubtreeWithPath("11").toString(),TES.toString());
		
		BinarySearchTreeADTImpl<Integer> TC3S = new BinarySearchTreeADTImpl<Integer>();
		TC3S.insert(20,30);
		Assert.assertEquals(TC3.getSubtreeWithPath("01").toString(),TC3S.toString());
	}

  
	@Test(expected = NoSuchElementException.class)
	public void testgetSubtreeWithPathTreeException() {
	
		TC3.getSubtreeWithPath("1110");
		
	}
	

	@Test(expected = NoSuchElementException.class)
	public void testgetSubtreeWithPathException2() {
	
		BinarySearchTreeADTImpl<Integer> TV2 =  new BinarySearchTreeADTImpl<Integer>();; 
		TV2.getSubtreeWithPath("1110");
		
	} 

	@Test(expected = NoSuchElementException.class)
	public void testwithdrawException() {
	    
		TC3 = new BinarySearchTreeADTImpl<Integer>();
		TC3.withdraw(130);
		
	}
	 
	@Test 
	public void testInordenIterator() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		lista.add(10);
		lista.add(20); 
		lista.add(30);
		lista.add(50);
		lista.add(70);
		lista.add(80);
		lista.add(90);
		
		Iterator<Integer> i = TC3.iteratorInorden(); 
		Assert.assertTrue(i.hasNext()); 
		Assert.assertEquals(10, (int)i.next());
		Assert.assertTrue(i.hasNext()); 
		Assert.assertEquals(20, (int)i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals(30,(int) i.next());
		Assert.assertTrue(i.hasNext()); 
		Assert.assertEquals(50,(int) i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals(70,(int) i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals(80,(int) i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals(90,(int) i.next());
		Assert.assertFalse(i.hasNext());
		
	    Assert.assertEquals("[10, 20, 30, 50, 70, 80, 90]", lista .toString());
	}
	@Test
	public void testInPath() {
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(40);
		lista.add(60);
		lista.add(80);
		
		Assert.assertEquals(lista.toString(), "[40, 60, 80]");
		TE.isPathIn(lista);
		
		Assert.assertEquals(TE.toString(),"{40 [(path, 1)], ∅, {60 [(path, 2)], ∅, {80 [(path, 3)], ∅, ∅}}}");
		Assert.assertTrue(TE.isPathIn(lista));
		
		BinarySearchTreeADTImpl<Integer> TES = new BinarySearchTreeADTImpl<Integer>();
		TES.insert(30,20,25,10,1,50,70,60,45);
		Assert.assertEquals(TES.toString(),"{30, {20, {10, {1, ∅, ∅}, ∅}, {25, ∅, ∅}}, {50, {45, ∅, ∅}, {70, {60, ∅, ∅}, ∅}}}");
	
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		lista2.add(30);
		lista2.add(20);
		lista2.add(25);
		
		ArrayList<Integer> lista3 = new ArrayList<Integer>();
		lista3.add(30);
		lista3.add(10);
		lista3.add(1);
		
		TES.isPathIn(lista3);
		
		Assert.assertEquals(TES.toString(),"{30, {20, {10, {1, ∅, ∅}, ∅}, {25, ∅, ∅}}, {50, {45, ∅, ∅}, {70, {60, ∅, ∅}, ∅}}}");
		Assert.assertFalse(TES.isPathIn(lista3)); 
		
	} 
	
	@Test
	public void testTagWidth() {
		TC3.tagWidth();
		Assert.assertEquals(TC3.toString(),"{50 [(width, 1)], {20 [(width, 2)], {10 [(width, 4)], ∅, ∅}, {30 [(width, 5)], ∅, ∅}}, {80 [(width, 3)], {70 [(width, 6)], ∅, ∅}, {90 [(width, 7)], ∅, ∅}}}");
		TE.tagWidth();
		Assert.assertEquals(TE.toString(),"{40 [(width, 1)], ∅, {60 [(width, 2)], ∅, {80 [(width, 3)], ∅, ∅}}}");
	}

		@Test
		public void testTagDescendTC4() {
			List<String> lista= new LinkedList<String>();
			TC3.parentChildPairsTagDescend(lista);
			Assert.assertEquals(lista.toString(), "[(80, 90), (80, 70), (50, 80), (50, 20), (20, 30), (20, 10)]");
			TC3.filterTags("descend");
			Assert.assertEquals("{50 [(descend, 4)], {20 [(descend, 6)], {10 [(descend, 7)], ∅, ∅}, {30 [(descend, 5)], ∅, ∅}}, {80 [(descend, 2)], {70 [(descend, 3)], ∅, ∅}, {90 [(descend, 1)], ∅, ∅}}}", TC3.toString());
			
		}
	
	}
 

