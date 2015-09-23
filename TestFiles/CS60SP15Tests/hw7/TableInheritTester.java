import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;


public class TableInheritTester {
	
	@Test 
	// Constructor tests with acceptable input
	public void test_ConstructorDesk() {
		Table t1 = new Desk();
		assertEquals(3, t1.chairCount);
		assertEquals(0, t1.personCount);
		assertEquals(0, t1.people.size());
		
		Table t2 = new Desk(100);
		assertEquals(100, t2.chairCount);
		assertEquals(0, t2.personCount);
		assertEquals(0, t2.people.size());
	}
	
	@Test 
	// Constructor tests with acceptable input
	public void test_ConstructorHochTable() {
		Table t1 = new HochTable();
		assertEquals(6, t1.chairCount);
		assertEquals(0, t1.personCount);
		assertEquals(0, t1.people.size());
		
		Table t2 = new HochTable(100);
		assertEquals(100, t2.chairCount);
		assertEquals(0, t2.personCount);
		assertEquals(0, t2.people.size());
	}
	
	@Test 
	// Constructor tests with acceptable input
	public void test_ConstructorSuperFriendlyHochTable() {
		Table t1 = new SuperFriendlyHochTable();
		assertEquals(10, t1.chairCount);
		assertEquals(0, t1.personCount);
		assertEquals(0, t1.people.size());
		
		Table t2 = new SuperFriendlyHochTable(100);
		assertEquals(100, t2.chairCount);
		assertEquals(0, t2.personCount);
		assertEquals(0, t2.people.size());
	}
	
	@Test
	// Constructor test with unacceptable input
	public void test_ConstructorErrorDesk(){
		try{
			Table t1 = new Desk(-5);
			// it is an error (failure) if it executes the next line.
			fail(); 
		}
		catch(IllegalArgumentException e){
			
		}
	}
	
	@Test
	// Constructor test with unacceptable input
	public void test_ConstructorErrorHochTable(){
		try{
			Table t1 = new HochTable(-5);
			// it is an error (failure) if it executes the next line.
			fail(); 
		}
		catch(IllegalArgumentException e){
			
		}
	}
	
	@Test
	// Constructor test with unacceptable input
	public void test_ConstructorErrorSuperFriendlyHochTable(){
		try{
			Table t1 = new SuperFriendlyHochTable(-5);
			// it is an error (failure) if it executes the next line.
			fail(); 
		}
		catch(IllegalArgumentException e){
			
		}
	}
	
	
	@Test
	// emptySeat test
	public void test_EmptySeatTable(){
		Table t0 = new Table(0);
		assertFalse(t0.emptySeat());
		Table t1 = new Table(1);
		assertTrue(t1.emptySeat());
	}
	@Test
	// emptySeat test
	public void test_EmptySeatHochTable(){
		Table t0 = new HochTable(0);
		assertTrue(t0.emptySeat());
		Table t1 = new HochTable(1);
		assertTrue(t1.emptySeat());
	}
	@Test
	// emptySeat test
	public void test_EmptySeatSuperFriendlyHochTable(){
		Table t0 = new SuperFriendlyHochTable(0);
		assertTrue(t0.emptySeat());
		Table t1 = new SuperFriendlyHochTable(1);
		assertTrue(t1.emptySeat());
	}
	@Test
	// emptySeat test
	public void test_EmptySeatDesk(){
		Table t0 = new Desk(0);
		assertFalse(t0.emptySeat());
		Table t1 = new Desk(1);
		assertTrue(t1.emptySeat());
	}
	
	@Test
	// addPerson(String name) test
	public void test_AddPersonDesk(){
		Table t1 = new Desk(2);
		String salutation;
		salutation = t1.addPerson("Beth");
		assertEquals("Welcome Beth", salutation);
		salutation = t1.addPerson("Colleen");
		assertEquals("Welcome Colleen", salutation);
		salutation = t1.addPerson("Wally");
		assertEquals("Sorry - there is no space for you Wally", salutation);
		assertEquals(2, t1.personCount);
		assertEquals("[Beth, Colleen]", t1.people.toString());
	}
	@Test
	// addPerson(String name) test
	public void test_AddPersonHochTable(){
		Table t1 = new HochTable(2);
		assertEquals(2, t1.chairCount);
		String salutation;
		salutation = t1.addPerson("Beth");
		assertEquals("Welcome Beth!", salutation);
		salutation = t1.addPerson("Colleen");
		assertEquals("Welcome Colleen!", salutation);
		salutation = t1.addPerson("Wally");
		assertEquals("Welcome Wally!", salutation);
		assertEquals(3, t1.personCount);
		assertEquals(3, t1.chairCount);
		assertEquals("[Beth, Colleen, Wally]", t1.people.toString());
	}
	@Test
	// addPerson(String name) test
	public void test_AddPersonSuperFriendlyHochTable(){
		Table t1 = new SuperFriendlyHochTable(2);
		assertEquals(2, t1.chairCount);
		String salutation;
		salutation = t1.addPerson("Beth");
		assertEquals("Hello Beth!!!!!", salutation);
		salutation = t1.addPerson("Colleen");
		assertEquals("Hello Beth, Colleen!!!!!", salutation);
		salutation = t1.addPerson("Wally");
		assertEquals("Hello Beth, Colleen, Wally!!!!!", salutation);
		assertEquals(3, t1.personCount);
		assertEquals(3, t1.chairCount);
		assertEquals("[Beth, Colleen, Wally]", t1.people.toString());
	}
	
	@Test
	// addPerson(String name) test
	public void test_RemovePersonDesk(){
		Table t1 = new Desk(3);
		String salutation;
		t1.addPerson("Beth");
		salutation = t1.removePerson("Alien");
		assertEquals("Weird! Alien was never here!", salutation);
		t1.addPerson("Colleen");
		t1.addPerson("Wally");
		salutation = t1.removePerson("Colleen");
		assertEquals("Bye Colleen", salutation);
		salutation = t1.removePerson("Colleen");
		assertEquals("Weird! Colleen was never here!", salutation);
		t1.removePerson("Beth");
		salutation = t1.removePerson("Wally");
		assertEquals("(Silence - no one is here to say goodbye)", salutation);
	}
	@Test
	// addPerson(String name) test
	public void test_RemovePersonHochTable(){
		Table t1 = new HochTable(2);
		String salutation;
		t1.addPerson("Beth");
		salutation = t1.removePerson("Alien");
		assertEquals("Weird! Alien was never here!", salutation);
		t1.addPerson("Colleen");
		t1.addPerson("Wally");
		salutation = t1.removePerson("Colleen");
		assertEquals("Bye Colleen", salutation);
		salutation = t1.removePerson("Colleen");
		assertEquals("Weird! Colleen was never here!", salutation);
		t1.removePerson("Beth");
		salutation = t1.removePerson("Wally");
		assertEquals("(Silence - no one is here to say goodbye)", salutation);
	}
	@Test
	// addPerson(String name) test
	public void test_RemovePersonSuperFriendlyHochTable(){
		Table t1 = new SuperFriendlyHochTable(2);
		String salutation;
		t1.addPerson("Beth");
		salutation = t1.removePerson("Alien");
		assertEquals("Weird! Alien was never here!", salutation);
		t1.addPerson("Colleen");
		t1.addPerson("Wally");
		salutation = t1.removePerson("Colleen");
		assertEquals("Bye Colleen", salutation);
		salutation = t1.removePerson("Colleen");
		assertEquals("Weird! Colleen was never here!", salutation);
		t1.removePerson("Beth");
		salutation = t1.removePerson("Wally");
		assertEquals("(Silence - no one is here to say goodbye)", salutation);
	}
	@Test
	// addPowerSupply() and addPersonAndLaptop
	public void test_DeskSpecificThings(){
		Desk d1 = new Desk();
		assertEquals(0, d1.laptopCount);
		assertEquals(0, d1.powerOutletCount);
		d1.addPowerSupply();
		assertEquals(0, d1.laptopCount);
		assertEquals(6, d1.powerOutletCount);
		d1.addPowerSupply();
		assertEquals(0, d1.laptopCount);
		assertEquals(12, d1.powerOutletCount);
		String salutation;
		salutation = d1.addPersonAndLaptop("Beth");
		assertEquals("Welcome Beth", salutation);
		assertEquals(1, d1.laptopCount);
		assertEquals(11, d1.powerOutletCount);
	}
	
	@Test
	// test classStartingSoon() 
	public void test_ClassStartingSoon(){
		HochTable t1 = new HochTable(5);
		t1.addPerson("Beth");
		t1.addPerson("Colleen");		
		t1.addPerson("Dodds");
		t1.addPerson("Geoff");
		t1.addPerson("Julie");
		t1.addPerson("Ran");
		t1.addPerson("Eliot");
		t1.classStartingSoon();
		assertEquals(0, t1.personCount);
		assertEquals("[]", t1.people.toString());
	}

	@Test
	// test classStartingSoon() 
	public void test_ClassStartingSoonFriendly(){
		HochTable t1 = new SuperFriendlyHochTable(5);
		t1.addPerson("Beth");
		t1.addPerson("Colleen");		
		t1.addPerson("Dodds");
		t1.addPerson("Geoff");
		t1.addPerson("Julie");
		t1.addPerson("Ran");
		t1.addPerson("Eliot");
		t1.classStartingSoon();
		assertEquals(0, t1.personCount);
		assertEquals("[]", t1.people.toString());
	}
	
}
