/*
 * CS320 Software Test, Automation QA 
 * Module 3 Milestone 1
 * Instructor: Angelo Luo
 * Student: Travis Williamson
 * 
 */

import junit.framework.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.jupiter.api.Test;

public class ContactTest extends TestCase{
	
		protected Contact contact1, contact2, contact3, contact4,
			    contact5, contact6, contact7, contact8,
			    contact9, contact10, contact11, contact12;
	@Test		
	public void testContactSuccessfullyCreated() {
		//All information fits requirements
		contact1 = new Contact("1", "John", "Carmack", "1234567890", "123 Apogee Way");
		
		assertEquals("John",contact1.getFirstName());
	}
	
	//Test fails if any other information was updated
	@Test	
	public void testNullID() {
		//null id, no contact created
		contact2 = new Contact(null, "John", "Romero", "1234567890", "123 Apogee Way");		
		
		assertNull(contact2.getFirstName());
	}

	@Test
	public void testIDTooLong() {
		//id longer than 10 characters
		contact3 = new Contact("12345678900", "Sid", "Meier", "1234567890", "123 Firaxis Ave");
		assertNull(contact3.getFirstName());
	}

	@Test
	public void testFirstNameTooLong() {
		//first name longer than 10 characters
		contact4 = new Contact("123", "Christopher", "Taylor", "1234567890", "Total Annhilation Blvd");		
		assertNull(contact4.getFirstName());
	}

	@Test
	public void testFirstNameNull() {
		//first name null
		contact5 = new Contact("123", null, "Persson", "1234567890", "Just A Last Name Bend");		
		assertNull(contact5.getID());
	}
	
	@Test	
	public void testLastNameTooLong() {
		//last name longer than 10 characters
		contact6 = new Contact("123", "Tim", "Cain is great", "1234567890", "1 Arcanum Dr.");		
		assertNull(contact6.getLastName());
	}
	
	@Test	
	public void testLastNameNull() {
		//last name null
		contact7 = new Contact("123", "Lord", null, "1234567890", "British");
		assertNull(contact7.getFirstName());
	}
	
	@Test
	public void testInvalidPhoneNumberNonDigits() {
		//phone number contains non digit
		contact8 = new Contact("123", "John", "Carmack", "A123456789", "Get a better Phonebook");
		
		assertNotSame("A123456789",contact8.getPhoneNumber());
	}
	
	@Test
	public void testInvalidPhoneNumberWrongLength() {
		//phone number not equal to 10 digits
		contact9 = new Contact("123", "Leonard", "Boyarsky", "13", "In a Vault");
		
		assertNotSame("13", contact9.getPhoneNumber());
	}
	
	@Test
	public void testContactCreateNullPhoneNumber() {
		//phone number null;
		contact10 = new Contact("123", "Hideo", "Kojima", null, "Somewhere");
		
		assertNotSame("123", contact10.getID());
	}
	
	@Test
	public void testAddressTooLong() {
		//address longer than 30 characters
		contact11 = new Contact("123", "Marc", "Laidlaw", "1234567890", "Half Life 3 - Coming Soon to a Fever Dream Near You!");
		
		assertNotSame("Half Life 3 - Coming Soon to a Fever Dream Near You!",contact11.getAddress());
	}
	
	@Test
	public void testAddressNull() {
		//address null
		contact12 = new Contact("123", "Jim", "Walls", "1234567890", null);
		
		assertNotSame("123", contact12.getID());
	}
	
	

	public class TestRunner {
		public void main(String[] args) {			
			
			Result result = JUnitCore.runClasses(ContactTest.class);
			for(Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			
			System.out.println(result.wasSuccessful());			
		}			
	}
}


