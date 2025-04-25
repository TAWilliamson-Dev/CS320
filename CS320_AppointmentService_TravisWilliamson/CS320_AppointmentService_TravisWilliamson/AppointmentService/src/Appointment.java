/*
 * CS320 Software Test, Automation QA
 * Module 5 Milestone - Appointment.java
 * Instructor: Angelo Luo
 * Student: Travis Williamson
 * 
 */

import java.util.Date;

public class Appointment {

	//Cannot be longer than 10 characters or null and cannot be updated once created
	protected String appointmentID;
	
	//Cannot be in the past or null
	protected Date appointmentDate;
	
	//Cannot be longer than 50 characters or null
	protected String appointmentDescription;
	
	
	public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
		//Assign this objects data if and only if all parameters are valid
		if(validateID(appointmentID) && validateDate(appointmentDate) && validateDescription(appointmentDescription)) {
			this.appointmentID = appointmentID;
			this.appointmentDate = appointmentDate;
			this.appointmentDescription = appointmentDescription;
		}
	}
	
	//Accessors
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	public Date getAppointmentDate() {
		return this.appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return this.appointmentDescription;
	}
	
	//Mutators
	public void updateAppointmentDate(Date newDate) {
		if(validateDate(newDate)) { 
			this.appointmentDate = newDate;
		}
	}
	
	public void updateAppointmentDescription(String appointmentDescription) {
		if(validateDescription(appointmentDescription)) {
			this.appointmentDescription = appointmentDescription;
		}
	}
	
	//Validate that the provided ID is neither null nor longer than 10 characters
	private boolean validateID(String appointmentID) {
		if(appointmentID == null || appointmentID.length() > 10) {
			return false;
		}
		else {
			return true;
		}
	}	
	
	//Validate that the provided date is neither null nor is it in the past
	private boolean validateDate(Date appointmentDate) {
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Validate that the provided description is neither null nor longer than 50 characters
	private boolean validateDescription(String appointmentDescription) {
		if(appointmentDescription == null || appointmentDescription.length() > 50) {
			return false;
		}
		else {
			return true;
		}
	}	
}
