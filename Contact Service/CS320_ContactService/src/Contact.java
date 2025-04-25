/*
 * CS320 Software Test, Automation QA 
 * Module 3 Milestone 1
 * Instructor: Angelo Luo
 * Student: Travis Williamson
 * 
 */


public class Contact {
	private String contactID,
				   firstName,
				   lastName,
				   phoneNumber,
				   address;
	
	private boolean isValidContact = true;
	
	Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
		
		isValidContact = (validateContactID(id) && validateFirstName(firstName) && validateLastName(lastName) 
				&& validatePhoneNumber(phoneNumber) && validateAddress(address));
		
		//Only update this contacts information if all provided information meets requirements
		if(isValidContact) {
			this.contactID = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.address = address;
		}
	}

	/*
	 *  If the provided String firstName meets the requirements for the first name,
	 *  update this Contacts first name.
	 */
	public void updateFirstName(String firstName) {
		if(validateFirstName(firstName)) {
			this.firstName = firstName;
		}
	}
	
	/*
	 *  If the provided String lastName meets the requirements for the last name,
	 *  update this Contacts last name.
	 */
	public void updateLastName(String lastName) {
		if(validateLastName(lastName)) {
			this.lastName = lastName;
		}
	}
	
	/*
	 *  If the provided String phone number meets the requirements for the 
	 *  phone number, update this Contacts phone number 
	 */	
	public void updatePhoneNumber(String phoneNumber) {
		if(validatePhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}
	}
	
	/*
	 *  If the provided String address meets the requirements for the address, update this Contacts address 
	 */
	public void updateAddress(String address) {
		if(validateAddress(address)) {
			this.address = address;
		}
	}
	
	/*
	 *  Verifies that the provided String is 10 characters or less and not null
	 */
	private boolean validateFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			return false;
		}
		return true;
	}
	
	
	/*
	 *  Verifies that the provided String is 10 characters or less and not null
	 */
	private boolean validateContactID(String id) {
		if(id == null || id.length() > 10) {
			return false;
		}
		return true;
	}
	
	/*
	 *  Verifies that the provided String is 10 characters or less and not null
	 */
	private boolean validateLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			return false;
		}
		return true;
	}
	
	
	/*
	 *  Verifies that the the provided String is not null, is 10 characters long, and all characters are digits
	 */
	private boolean validatePhoneNumber(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length() != 10) {
			return false;
		}
		else {
			for(int i = 0; i < phoneNumber.length(); i++) {
				if(!Character.isDigit(phoneNumber.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	/*
	 *  Verifies that the provided String is neither null nor longer than 30 characters
	 */
	private boolean validateAddress(String address) {
		if(address == null || address.length() > 30) {
			return false;
		}
		return true;
	}
	
	public String getID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public boolean getValidContact() {
		return isValidContact;
	}
}
