package ule.edi.doubleList;


import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;


public class DoubleLinkedListImplTests {

	private DoubleLinkedListImpl<String> lista;
	private DoubleLinkedListImpl<String> lista2;
	private DoubleLinkedListImpl<String> lista3;
	private DoubleLinkedListImpl<String> listaABC;
	private DoubleLinkedListImpl<String> listaABCDE;


	@Before
	public void setup() {
		this.lista = new DoubleLinkedListImpl<String>();
		this.lista2 = new DoubleLinkedListImpl<String>();
		this.lista3 = new DoubleLinkedListImpl<String>();
	    this.listaABC=new DoubleLinkedListImpl<String>("A", "B", "C");
	    this.listaABCDE=new DoubleLinkedListImpl<String>("A", "B", "C", "D", "E");
	}
	
	@Test
	public void testIsEmpty() {
		Assert.assertEquals(true, lista.isEmpty());
		lista.addFirst("1");
		Assert.assertEquals(false, lista.isEmpty());
	}
	@Test
	public void testAddFirst() {
		Assert.assertEquals("[]", lista.toString());
		lista.addFirst("1");
		Assert.assertEquals(false, lista.isEmpty());
		Assert.assertEquals("[1]", lista.toString());
		lista.addFirst("2");
		Assert.assertEquals("[2, 1]", lista.toString());
		lista.addFirst("3");
		Assert.assertEquals("[3, 2, 1]", lista.toString());
		lista.addFirst("4");
		Assert.assertEquals("[4, 3, 2, 1]", lista.toString());
		lista.addFirst("5");
		Assert.assertEquals("[5, 4, 3, 2, 1]", lista.toString());
	}
	@Test
	public void testAddLast() {
		Assert.assertEquals("[]", lista.toString());
		lista.addLast("1");
		Assert.assertEquals(false, lista.isEmpty());
		Assert.assertEquals("[1]", lista.toString());
		lista.addLast("2");
		Assert.assertEquals("[1, 2]", lista.toString());
		lista.addLast("3");
		Assert.assertEquals("[1, 2, 3]", lista.toString());
		lista.addLast("4");
		Assert.assertEquals("[1, 2, 3, 4]", lista.toString());
		lista.addLast("5");
		Assert.assertEquals("[1, 2, 3, 4, 5]", lista.toString());
	}
	@Test
	public void testAddAtPos() {
		Assert.assertEquals("[]", lista.toString());
		lista.addAtPos("1", 5);
		Assert.assertEquals(false, lista.isEmpty());
		Assert.assertEquals("[1]", lista.toString());
		lista.addAtPos("2", 1);
		Assert.assertEquals("[2, 1]", lista.toString());
		lista.addAtPos("3", 2);
		Assert.assertEquals("[2, 3, 1]", lista.toString());
		lista.addAtPos("4", 3);
		Assert.assertEquals("[2, 3, 4, 1]", lista.toString());
		lista.addAtPos("5", 20);
		Assert.assertEquals("[2, 3, 4, 1, 5]", lista.toString());
		lista.addAtPos("6", 6);
		Assert.assertEquals("[2, 3, 4, 1, 5, 6]", lista.toString());
	}
	@Test
	public void testGetElement() {
		lista.addFirst("7");
		lista.addFirst("6");
		lista.addFirst("5");
		lista.addFirst("4");
		lista.addFirst("3");
		lista.addFirst("2");
		lista.addFirst("1");
		Assert.assertEquals("2", lista.getElem(2));
		Assert.assertEquals("5", lista.getElem(5));
		Assert.assertEquals("7", lista.getElem(7));
		Assert.assertEquals("1", lista.getElem(1));
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementPinvalid() throws IndexOutOfBoundsException {
		lista.getElem(-1);	
	}
	
	@Test
	public void testSetElement() {
		lista.addFirst("7");
		lista.addFirst("6");
		lista.addFirst("5");
		lista.addFirst("4");
		lista.addFirst("3");
		lista.addFirst("2");
		lista.addFirst("1");
		
		lista.setElem("1.1", 3);
		lista.setElem("1.2", 5);
		lista.setElem("1.3", 7);
		lista.setElem("1.4", 1);
		
		Assert.assertEquals("[1.4, 2, 1.1, 4, 1.2, 6, 1.3]", lista.toString());
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetElementPinvalid() throws IndexOutOfBoundsException {
		lista.setElem("2", 8);
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetElementPinvalid1() throws IndexOutOfBoundsException {
		lista.setElem("2", -1);
		
	}
	
	@Test
	public void testAddNTimes() {
		Assert.assertEquals("[]", lista.toString());
		lista.addAtPos("3", 4);
		lista.addNTimes("1", 5);
		Assert.assertEquals("[3, 1, 1, 1, 1, 1]", lista.toString());
	}
	
	@Test
	public void testSize(){
		Assert.assertEquals(0, lista.size());
		lista.addLast("4");
		Assert.assertEquals(1, lista.size());
		lista.addLast("4");
		Assert.assertEquals(2, lista.size());
	}
	@Test
	public void testIdexOf() {
		lista.addFirst("7");
		lista.addFirst("6");
		lista.addFirst("5");
		lista.addFirst("4");
		lista.addFirst("3");
		lista.addFirst("2");
		lista.addFirst("1");
		
		Assert.assertEquals(2, lista.indexOf("2"));
		Assert.assertEquals(1, lista.indexOf("1"));
		Assert.assertEquals(7, lista.indexOf("7"));
	}
	@Test(expected = NoSuchElementException.class)
	public void testIndexOfNO() throws NoSuchElementException {
		lista.addFirst("7");
		lista.addFirst("6");
		lista.addFirst("5");
		lista.addFirst("4");
		
		lista.indexOf("8");		
	}
	@Test
	public void testIdexOfElement() {
		lista.addFirst("7");
		lista.addFirst("6");
		lista.addFirst("5");
		lista.addFirst("4");
		lista.addFirst("3");
		lista.addFirst("2");
		lista.addFirst("1");
		
		Assert.assertEquals(2, lista.indexOf("2",2));
		Assert.assertEquals(1, lista.indexOf("1",1));
		Assert.assertEquals(7, lista.indexOf("7",7));
	}
	@Test(expected = NoSuchElementException.class)
	public void testIndexOfNO1() throws NoSuchElementException {
		lista.addFirst("7");
		lista.addFirst("6");
		lista.addFirst("5");
		lista.addFirst("4");
		
		lista.indexOf("4",2);		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOfNO2() throws IndexOutOfBoundsException {
		lista.addFirst("7");
		lista.addFirst("6");
		lista.addFirst("5");
		lista.addFirst("4");
		
		lista.indexOf("12",23);		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIdexOfNo3() throws IndexOutOfBoundsException {
		lista.indexOf("2", 8);
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIdexOfNo4() throws IndexOutOfBoundsException {
		lista.indexOf("2", -1);
		
	}
	@Test
	public void testRemoveFirst() throws EmptyCollectionException {
		lista.addFirst("4");
		lista.addFirst("2");
		lista.addFirst("3");
		lista.addFirst("4");
		lista.addFirst("5");
		lista.addFirst("1");
		lista.addFirst("2");
		
		lista.removeFirst("1");
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveFirstExc() throws EmptyCollectionException {
		lista.removeFirst("1");
		
	}
	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstExc1() throws NoSuchElementException, EmptyCollectionException {
		lista.addFirst("4");
		lista.addFirst("2");
		lista.addFirst("3");
		lista.addFirst("4");
		lista.addFirst("5");
		lista.addFirst("1");
		lista.addFirst("2");
		
		lista.removeFirst("12");
	}
	
	@Test
	public void testRemoveAll() throws EmptyCollectionException {
		lista.addFirst("1");
		lista.addFirst("3");
		lista.addFirst("1");
		lista.addFirst("3");
		lista.addFirst("1");
		lista.addFirst("5");
		lista.addFirst("1");
		lista.addFirst("1");
		Assert.assertEquals("[1, 1, 5, 1, 3, 1, 3, 1]", lista.toString());
		Assert.assertEquals("1", lista.removeAll("1"));
		Assert.assertEquals("[5, 3, 3]", lista.toString());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveAllExc() throws EmptyCollectionException {
		lista.removeAll("1");
		
	}
	@Test(expected = NoSuchElementException.class)
	public void testRemoveAllExc1() throws NoSuchElementException, EmptyCollectionException {
		lista.addFirst("4");
		lista.addFirst("2");
		lista.addFirst("3");
		lista.addFirst("4");
		lista.addFirst("5");
		lista.addFirst("1");
		lista.addFirst("2");
		
		lista.removeAll("12");
	}
	
	@Test
	public void testRemoveLast() throws EmptyCollectionException {
		lista.addFirst("4");
		lista.addFirst("2");
		lista.addFirst("3");
		lista.addFirst("4");
		lista.addFirst("5");
		lista.addFirst("1");
		lista.addFirst("2");
		
		Assert.assertEquals("[2, 1, 5, 4, 3, 2, 4]", lista.toString());
		Assert.assertEquals("4", lista.removeLast());
		Assert.assertEquals("[2, 1, 5, 4, 3, 2]", lista.toString());
		lista.removeLast();
		lista.removeLast();
		Assert.assertEquals("4", lista.removeLast());
		Assert.assertEquals("[2, 1, 5]", lista.toString());
		lista.removeLast();
		lista.removeLast();
		Assert.assertEquals("2", lista.removeLast());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveLastExc() throws EmptyCollectionException {
		lista.removeLast();
		
	}
	@Test
	public void testReverse() {
		lista.addFirst("4");
		lista.addFirst("2");
		lista.addFirst("3");
		lista.addFirst("4");
		lista.addFirst("5");
		lista.addFirst("1");
		lista.addFirst("2");
		Assert.assertEquals("[2, 1, 5, 4, 3, 2, 4]", lista.toString());
		lista.reverse();
		Assert.assertEquals("[4, 2, 3, 4, 5, 1, 2]", lista.toString());
	}
	@Test
	public void testInterlace() {
		lista.interlace(lista2);
		Assert.assertEquals("[]", lista.toString());
		
		lista.addFirst("1");
		lista.addFirst("1");
		lista.addFirst("1");
		lista.addFirst("1");
		lista.addFirst("1");
		lista.addFirst("1");
		lista.addFirst("1");
		lista.addFirst("1");
		lista.addFirst("1");
		lista.addFirst("1");
		Assert.assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]", lista.toString());
		
		lista2.addFirst("2");
		lista2.addFirst("2");
		lista2.addFirst("2");
		lista2.addFirst("2");
		lista2.addFirst("2");
		lista2.addFirst("2");
		lista2.addFirst("2");
		Assert.assertEquals("[2, 2, 2, 2, 2, 2, 2]", lista2.toString());
		
		
		lista.interlace(lista2);
		Assert.assertEquals("[1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1]", lista.toString());
		
	}
	@Test
	public void testSubList() {
		
		lista.addFirst("7");
		lista.addFirst("6");
		lista.addFirst("5");
		lista.addFirst("4");
		lista.addFirst("3");
		lista.addFirst("2");
		lista.addFirst("1");
		
		lista2.addFirst("7");
		lista2.addFirst("5");
		lista2.addFirst("4");
		lista2.addFirst("2");
		
		Assert.assertEquals(-1, lista.isSubList(lista2));
		
		Assert.assertEquals(1, lista.isSubList(lista3));
		
		lista3.addFirst("7");
		lista3.addFirst("6");
		lista3.addFirst("5");
		lista3.addFirst("4");
		
		Assert.assertEquals(4, lista.isSubList(lista3));
	}
	@Test
	public void testForewardIterator() {
		Iterator<String> iteratorE = lista.iterator();
		Assert.assertEquals(false, iteratorE.hasNext());
		
		lista.addFirst("4");
		lista.addFirst("2");
		lista.addFirst("3");
		Iterator<String> iteratorF = lista.iterator();
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("3", iteratorF.next());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("2", iteratorF.next());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("4", iteratorF.next());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals(false, iteratorF.hasNext());
		
	}
	@Test
	public void testReverseIterator() {
		Iterator<String> iteratorE = lista.reverseIterator();
		Assert.assertEquals(false, iteratorE.hasNext());
		
		lista.addFirst("4");
		lista.addFirst("2");
		lista.addFirst("3");
		Iterator<String> iteratorF = lista.reverseIterator();
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("4", iteratorF.next());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("2", iteratorF.next());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("3", iteratorF.next());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals(false, iteratorF.hasNext());
		
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testReverseItException() {
		Iterator<String> i = lista.reverseIterator();
		Assert.assertFalse(i.hasNext());
		i.next();
	}
	
	@Test
	public void testConstructorWithElements() {
		Assert.assertEquals("[A, B, C]", listaABC.toString());
	}
	
	@Test
	public void testToStringEmpty(){
		Assert.assertEquals(lista.toString(),"[]");		
	}
	
	@Test
	public void testToStringNotEmpty(){
		Assert.assertEquals(listaABC.toString(),"[A, B, C]");		
	}
	
	@Test
	public void testConstructorWithList(){
		DoubleLinkedListImpl<String> nueva= new DoubleLinkedListImpl<String>(listaABCDE);
		Assert.assertEquals("[A, B, C, D, E]", nueva.toString());
	}
	
	@Test
	public void testForwardIt() {
		lista = new DoubleLinkedListImpl<String>("A", "B", "C", "D");
		Iterator<String> i = lista.iterator();
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("A", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("B", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("C", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("D", i.next());
		Assert.assertFalse(i.hasNext());
	    Assert.assertEquals("[A, B, C, D]", lista.toString());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testForwardItException() {
		Iterator<String> i = lista.iterator();
		Assert.assertFalse(i.hasNext());
		i.next();
	}
	@Test
	public void testOddAndEvenItMIO1() {
		lista = new DoubleLinkedListImpl<>("A", "B", "C", "D", "E");
		Iterator<String> i = lista.oddAndEvenIterator();
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("B", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("D", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("A", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("C", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("E", i.next());
		Assert.assertFalse(i.hasNext());
	}
	@Test
	public void testOddAndEvenItMIO() {
		lista = new DoubleLinkedListImpl<>("A", "B", "C", "D", "E", "F");
		Iterator<String> i = lista.oddAndEvenIterator();
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("B", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("D", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("F", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("A", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("C", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("E", i.next());
		Assert.assertFalse(i.hasNext());
	}
	@Test
	public void testOddAndEvenIt() {
		lista = new DoubleLinkedListImpl<>("A", "B", "C", "D", "E");
		Iterator<String> i = lista.oddAndEvenIterator();
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("B", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("D", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("A", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("C", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("E", i.next());
		Assert.assertFalse(i.hasNext());
	    Assert.assertEquals("[A, B, C, D, E]", lista.toString());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testOddAndEvenException() {
		Iterator<String> i = lista.oddAndEvenIterator();
		Assert.assertFalse(i.hasNext());
		i.next();
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testReverseIteratorException() {
		Iterator<String> i = lista.reverseIterator();
		i.remove();
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testForewardIteratorException() {
		Iterator<String> i = lista.iterator();
		i.remove();
	}
	@Test(expected = UnsupportedOperationException.class)
	public void testOddIteratorExceptionException() {
		Iterator<String> i = lista.oddAndEvenIterator();
		i.remove();
	}
	
}
