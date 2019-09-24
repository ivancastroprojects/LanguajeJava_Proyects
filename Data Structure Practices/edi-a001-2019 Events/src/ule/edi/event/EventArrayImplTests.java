package ule.edi.event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

import ule.edi.model.*;
import ule.edi.model.Configuration.Type;

public class EventArrayImplTests {

	private DateFormat dformat = null;
	private EventArrayImpl e;
	
	private Date parseLocalDate(String spec) throws ParseException {
        return dformat.parse(spec);
	}

	public EventArrayImplTests() {
		
		dformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	@Before
	public void testBefore() throws Exception{
	    e = new EventArrayImpl("The Fabulous Five", parseLocalDate("24/02/2018 17:00:00"), 10, 100);

	}
	
	@Test
	public void testSomething() throws Exception {
		
	    Assert.assertTrue(e.getNumberOfAvailableSeats()==110);
	    Assert.assertEquals(e.getNumberOfSilverSeats(), 100);
	    Assert.assertEquals(e.getNumberOfAttendingAdults(), 0);
	}
	
	@Test
	public void testSellSeat1Adult() throws Exception{	
		Event ep = new EventArrayImpl("The Fabulous Five", parseLocalDate("24/02/2018 17:00:00"), 2, 2);
	    Assert.assertEquals(e.getNumberOfAttendingAdults(), 0);
	    
		ep.sellSeat(1, new Person("Alice","10203040A", 34),Type.GOLD);
		ep.sellSeat(1, new Person("Alice","10203040A", 34),Type.SILVER);
		ep.sellSeat(2, new Person("Juan","9903040A", 10),Type.SILVER);
	    Assert.assertEquals(ep.getNumberOfAttendingAdults(), 1);
	}
	
	@Test
	public void testGetAvailableSilverSeatsListBasic() throws Exception{
		Event ep = new EventArrayImpl("The Fabulous Five", parseLocalDate("24/02/2018 17:00:00"), 2, 2);
		Assert.assertEquals(ep.sellSeat(1, new Person("1010", "AA", 10), Configuration.Type.SILVER),true);
		Assert.assertEquals(ep.sellSeat(1, new Person("1010", "AA", 10), Configuration.Type.SILVER),false);
		Assert.assertEquals(ep.getAvailableSilverSeatsList().toString(), "[1]");					
	}
	
	
	// 	Tests unitarios
	@Test
	public void testGetNumberOfAttendingChildren() throws Exception {
		Assert.assertEquals(e.getNumberOfAttendingChildren(), 0);
		Assert.assertEquals(e.sellSeat(1, new Person("Alice","10203040A", 0),Type.GOLD),true);
		Assert.assertEquals(e.getNumberOfAttendingChildren(), 1);
		Assert.assertEquals(e.sellSeat(10, new Person("Pablo","101010B", 14),Type.GOLD),true);
		Assert.assertEquals(e.getNumberOfAttendingChildren(), 1);
		Assert.assertEquals(e.sellSeat(100, new Person("Alice","4444A", 10),Type.SILVER),true);
		Assert.assertEquals(e.getNumberOfAttendingChildren(), 2);
	} 
	
	@Test
	public void testGetNumberOfAttendingAdults() throws Exception {
		Assert.assertEquals(e.getNumberOfAttendingAdults(), 0);
		Assert.assertEquals(e.sellSeat(1, new Person("Alice","10203040A", 20),Type.GOLD),true);
		Assert.assertEquals(e.getNumberOfAttendingAdults(), 1);
		Assert.assertEquals(e.sellSeat(10, new Person("Pablo","101010B", 14),Type.GOLD),true);
		Assert.assertEquals(e.getNumberOfAttendingAdults(), 2);
		Assert.assertEquals(e.sellSeat(100, new Person("Alice","4444A", 10),Type.SILVER),true);
		Assert.assertEquals(e.getNumberOfAttendingAdults(), 2);
	}
	
	@Test
	public void testGetNumberOfAttendingElderlyPeople() throws Exception {
		
		Assert.assertEquals(e.getNumberOfAttendingElderlyPeople(),0);
		Assert.assertEquals(e.sellSeat(1, new Person("Alice","10203040A", 68),Type.GOLD),true);
		Assert.assertEquals(e.getNumberOfAttendingElderlyPeople(),1);
		Assert.assertEquals(e.sellSeat(10, new Person("Pablo","101010B", 14),Type.GOLD),true);
		Assert.assertEquals(e.getNumberOfAttendingElderlyPeople(),1);
		Assert.assertEquals(e.sellSeat(100, new Person("Alice","4444A", 70),Type.SILVER),true);

		Assert.assertEquals(e.getNumberOfAttendingElderlyPeople(),2 );
	}
	
	@Test
	public void testGetNumberOfSoldSeats() throws Exception {
		Assert.assertEquals(e.getNumberOfSoldSeats(), 0);
		Assert.assertEquals(e.sellSeat(1, new Person("Alice","10203040A", 68),Type.GOLD),true);
		Assert.assertEquals(e.getNumberOfSoldSeats(), 1);
		Assert.assertEquals(e.sellSeat(100, new Person("Alice","4444A", 70),Type.SILVER),true);
		Assert.assertEquals(e.getNumberOfSoldSeats(), 2);
	}
	
	@Test
	public void testGetNumberOfSoldSilverSeats() throws Exception {
		Assert.assertEquals(e.getNumberOfSoldSilverSeats(), 0);
	}
	
	@Test
	public void testGetNumberOfSeats() throws Exception {
		Assert.assertEquals(e.getNumberOfSeats(), 110);
	}
	
	@Test
	public void testGetNumberOfGoldSeats() throws Exception {
		Assert.assertEquals(e.getNumberOfGoldSeats(), 10);
	}
	
	@Test
	public void testGetNumberOfSilverSeats() throws Exception {
		Assert.assertEquals(e.getNumberOfSilverSeats(),100 );
	}
	
	@Test
	public void testGetNumberOfAvailableSeats() throws Exception {
		Assert.assertEquals(e.getNumberOfAvailableSeats(), 110);
		Assert.assertEquals(e.sellSeat(4, new Person("Pedro","1020040A", 78),Type.GOLD),true);
		Assert.assertEquals(e.sellSeat(4, new Person("Pedro","10230040A", 78),Type.SILVER),true);
		Assert.assertEquals(e.getNumberOfSoldGoldSeats(),1);
		Assert.assertEquals(e.getNumberOfSoldSilverSeats(),1);
		Assert.assertEquals(e.getNumberOfAvailableSeats(), 108);
		Assert.assertEquals(e.getNumberOfSeats(), 110);
	}
	
	@Test
	public void testGetSeat() throws Exception {
		Assert.assertEquals(e.getSeat(0,Type.SILVER), null);
		Assert.assertEquals(e.getSeat(20,Type.GOLD), null);
		Assert.assertEquals(e.getSeat(-1,Type.SILVER), null);
		Assert.assertEquals(e.sellSeat(4, new Person("Pedro","1020040A", 78),Type.GOLD),true);
		Assert.assertEquals(e.getSeat(4,Type.SILVER), null);
		
		Assert.assertEquals(e.getSeat(4,Type.GOLD).getPosition(), 4);
		Assert.assertEquals(e.getSeat(4,Type.GOLD).getHolder().getName(),"Pedro");
	}
	
	@Test
	public void testRefundSeat() throws Exception {
		Event  ev = new EventArrayImpl("The Fabulous Five", parseLocalDate("24/02/2018 17:00:00"), 2, 2);
		Person p = new Person("Carlos", "0392738J", 25);
		Person p2 = new Person("Perdo","111111",24);
		
		Assert.assertEquals(ev.refundSeat(0, null), null);
		Assert.assertEquals(ev.refundSeat(-1, Configuration.Type.SILVER), null);
		Assert.assertEquals(ev.refundSeat(-1, Configuration.Type.GOLD), null);
		Assert.assertEquals(ev.refundSeat(20, Configuration.Type.GOLD), null);
		Assert.assertEquals(ev.refundSeat(20, Configuration.Type.SILVER), null);
		Assert.assertEquals(ev.sellSeat(1, p, Configuration.Type.SILVER),true);
		
		Assert.assertEquals(ev.sellSeat(2, p2, Configuration.Type.SILVER),true);
		Assert.assertEquals(ev.sellSeat(2, p2, Configuration.Type.GOLD),false);
		
		Assert.assertEquals(ev.getNumberOfSilverSeats(),0);
		
		Person p1 = ev.refundSeat(1, Configuration.Type.SILVER);
		Assert.assertEquals(p, p1);
		
		Person p3 = ev.refundSeat(2, Configuration.Type.SILVER);
		Assert.assertEquals(p3.getName(), "Perdo");
		Assert.assertEquals(p3,p2);
		Assert.assertEquals(ev.refundSeat(2, Configuration.Type.SILVER), null);
	}
	
	@Test
	public void testSellSeat() throws Exception {
		//Comprueba que la misma persona no puede estar en la misma butaca
		Assert.assertEquals(e.sellSeat(1,new Person("Juan","1919",30),Configuration.Type.SILVER),true );
		Assert.assertEquals(e.sellSeat(1,new Person("Pedro","1919",30),Configuration.Type.GOLD),false );
	}
	
	@Test
	public void testGetAvailableGoldSeatsList() throws Exception {
	Assert.assertEquals(e.getAvailableGoldSeatsList().toString(),"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
	Assert.assertEquals(e.sellSeat(1, new Person("Mario","1020340A", 38),Type.GOLD),true);
	Assert.assertEquals(e.getAvailableGoldSeatsList().toString(),"[1, 2, 3, 4, 5, 6, 7, 8, 9]");
	Assert.assertEquals(e.sellSeat(2, new Person("Alberto","1003040A", 88),Type.GOLD),true);
	Assert.assertEquals(e.getAvailableGoldSeatsList().toString(),"[2, 3, 4, 5, 6, 7, 8, 9]");
	Assert.assertEquals(e.sellSeat(4, new Person("Pedro","1020040A", 78),Type.GOLD),true);
	Assert.assertEquals(e.getAvailableGoldSeatsList().toString(),"[2, 4, 5, 6, 7, 8, 9]");
	Assert.assertEquals(e.sellSeat(5, new Person("Juan","100340A", 8),Type.GOLD),true);
	Assert.assertEquals(e.getAvailableGoldSeatsList().toString(),"[2, 5, 6, 7, 8, 9]");
	
	
	}
	
	@Test
	public void testGetAvailableSilverSeatsList() throws Exception {
			Assert.assertEquals(e.getAvailableSilverSeatsList().toString(),"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]");
			Assert.assertEquals(e.sellSeat(1, new Person("Roberto","1021240Z", 37),Type.SILVER),true);
			Assert.assertEquals(e.getAvailableSilverSeatsList().toString(),"[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]");
			Assert.assertEquals(e.sellSeat(2, new Person("Alberto","1003040X", 85),Type.SILVER),true);
			Assert.assertEquals(e.getAvailableSilverSeatsList().toString(),"[2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]");
			Assert.assertEquals(e.sellSeat(4, new Person("Pedro","1020040F", 77),Type.SILVER),true);
			Assert.assertEquals(e.getAvailableSilverSeatsList().toString(),"[2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]");
			Assert.assertEquals(e.sellSeat(5, new Person("Evaristo","9138840L", 6),Type.SILVER),true);
			Assert.assertEquals(e.getAvailableSilverSeatsList().toString(),"[2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]");
	}
	
	@Test
	public void testGetPrice() throws Exception {
		Assert.assertEquals(e.sellSeat(5, new Person("Juan","100340A", 8),Type.GOLD),true);
		Assert.assertEquals(e.getPrice(e.getSeat(5, Type.GOLD)),100,0);
		Assert.assertEquals(e.sellSeat(5, new Person("Juan","1003403A", 8),Type.SILVER),true);
		
		Assert.assertEquals(e.getPrice(e.getSeat(5, Type.SILVER)),50,0);
	}
	

	@Test
	public void testGetCollectionEvent() throws Exception {
		
		Assert.assertEquals(e.sellSeat(5, new Person("Juan","100340A", 8),Type.GOLD),true);
		Assert.assertEquals(e.getPrice(e.getSeat(5, Type.GOLD)),100,0);
		
		Assert.assertEquals(e.sellSeat(5, new Person("Juan","1003403A", 8),Type.SILVER),true);
		double i = e.getCollectionEvent();
	}
	
	@Test
	public void testGetPosPersonGold() throws Exception {
		Person p = new Person("11111111B","Pascual",10);
		e.sellSeat(2, p,Type.GOLD);
		Assert.assertEquals(e.getPosPersonGold(p),2 );
	}
	
	@Test
	public void testIsGold() throws Exception {
		Person p = new Person("Pascual","2020202",10);
		Person p2= new Person("Pedro","090909",12);
		e.sellSeat(2, p,Type.SILVER);
		e.sellSeat(1, p2,Type.GOLD);
		Assert.assertEquals(e.isGold(p2),true );
		Assert.assertEquals(e.isGold(p),false );

	}
	
	@Test
	public void testIsSilver() throws Exception {
		Person p = new Person("Pascual","2020202",10);
		Person p2= new Person("Pedro","090909",12);
		e.sellSeat(2, p,Type.SILVER);
		e.sellSeat(1, p2,Type.GOLD);
		Assert.assertEquals(e.isSilver(p2),false );
		Assert.assertEquals(e.isSilver(p),true );
	}
	
	
}
