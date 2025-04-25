/*
 * CS320 Software Test, Automation QA 
 * Module 3 Milestone 1
 * Instructor: Angelo Luo
 * Student: Travis Williamson
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class ContactServiceTest {
	
	protected ContactService service = new ContactService();
	
	/*
	 * Test cases: 	Add Contact with unique ID
	 * 				Attempt to add Contact with non unique ID
	 * 				Delete Contact with existing ID
	 * 				Add new Contact using previous unique ID
	 * 				Test able to update FirstName, LastName, Address, and PhoneNumber on unique Contact
	 */
	
	//Test for adding a Contact with a unique ID
	@Test
	public void testAddUserUniqueID() {
		
		service.addContact("123","Michael","Kirkbride","1234567890","Seyda Neen on 16 Last Seed");
		
		assertEquals("Michael",service.getContact("123").getFirstName());
	}
	
	//Test for attempting to add Contact with non-unique ID
	@Test
	public void testAddUserNonUniqueID() {
		
		service.addContact("123","Michael","Kirkbride","1234567890","Seyda Neen on 16 Last Seed");
		
		service.addContact("123","Dane","Bigham","1234567890","Trenchcoat");
		
		assertEquals("Michael", service.getContact("123").getFirstName());
		assertNotEquals("Dane", service.getContact("123").getFirstName());
	}
	
	//Test for deleting a Contact by ID
	@Test
	public void testDeleteUser() {
		
		service.addContact("123","Michael","Kirkbride","1234567890","Seyda Neen on 16 Last Seed");
		
		assertNotNull(service.getContact("123"));
		
		service.deleteContact("123");
		
		assertNull(service.getContact("123"));
	}
	
	//Test for deleting and then replacing an existing Contact with a new Contact using the same ID
	@Test
	public void testAddUserReuseDeletedID() {
		
		service.addContact("123","Michael","Kirkbride","1234567890","Seyda Neen on 16 Last Seed");
		
		assertNotNull(service.getContact("123"));
		
		service.deleteContact("123");
		
		assertNull(service.getContact("123"));
		
		service.addContact("123","Dane","Bigham","1234567890","Trenchcoat");
		
		assertEquals("Dane", service.getContact("123").getFirstName());		
	}
	
	//Test for updating an existing Contacts data
	@Test
	public void testUpdateUserData() {
		service.addContact("123","Michael","Kirkbride","1234567890","Seyda Neen on 16 Last Seed");
		
		Contact temp = service.getContact("123");
		
		assertEquals("Michael", temp.getFirstName());
		assertEquals("Kirkbride", temp.getLastName());
		assertEquals("1234567890", temp.getPhoneNumber());
		assertEquals("Seyda Neen on 16 Last Seed", temp.getAddress());
		
		service.updateContactFirstName("123", "Brett");
		service.updateContactLastName("123",  "Sperry");
		service.updateContactPhoneNumber("123", "0987654321");
		service.updateContactAddress("123", "Welcome back, Commander.");
		
		temp = service.getContact("123");
		
		assertEquals("Brett", temp.getFirstName());
		assertEquals("Sperry", temp.getLastName());
		assertEquals("0987654321", temp.getPhoneNumber());
		assertEquals("Welcome back, Commander.", temp.getAddress());
		
		service.updateContactAddress("123", "Establishing Battlefield Control.");
		
		temp = service.getContact("123");
		//Do not update if provided information does not meet requirements
		assertEquals("Welcome back, Commander.", temp.getAddress());
	}
	
	public class TestRunner {
		public void main(String[] args) {			
			
			Result result = JUnitCore.runClasses(ContactServiceTest.class);
			for(Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			
			System.out.println(result.wasSuccessful());			
		}			
	}
}
