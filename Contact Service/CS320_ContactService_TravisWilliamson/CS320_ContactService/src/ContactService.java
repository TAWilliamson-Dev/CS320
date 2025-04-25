/*
 * CS320 Software Test, Automation QA 
 * Module 3 Milestone 1
 * Instructor: Angelo Luo
 * Student: Travis Williamson
 * 
 */

import java.util.HashMap;

public class ContactService {
	
	private HashMap<String, Contact> contacts;
	
	public ContactService() {
		contacts = new HashMap<String,Contact>();
	}
	
	public void addContact(String id, String firstName, String lastName, String phoneNumber, String address) {
		
		if(!contacts.containsKey(id)) {
			Contact temp = new Contact(id,firstName,lastName,phoneNumber,address);
			if(temp.getValidContact()) {
				contacts.put(id, temp);

			}
		}
	}
	
	public Contact getContact(String id) {
		return contacts.get(id);
	}
	
	public void deleteContact(String id) {
		if(contacts.containsKey(id)) {
			contacts.remove(id);
		}
	}
	
	/*
	 *  Update the given value if the key currently exists in the table.
	 */
	public void updateContactFirstName(String id, String firstName) {
		if(contacts.containsKey(id)) {
			contacts.get(id).updateFirstName(firstName);
		}
	}
	
	public void updateContactLastName(String id, String lastName) {
		if(contacts.containsKey(id)) {
			contacts.get(id).updateLastName(lastName);
		}
	}
	
	public void updateContactPhoneNumber(String id, String phoneNumber) {
		if(contacts.containsKey(id)) {
			contacts.get(id).updatePhoneNumber(phoneNumber);
		}
	}
	
	public void updateContactAddress(String id, String address) {
		if(contacts.containsKey(id)) {
			contacts.get(id).updateAddress(address);
		}
	}
}
