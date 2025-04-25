/*
 * CS320 Software Test, Automation QA
 * Module 5 Milestone - AppointmentService.java
 * Instructor: Angelo Luo
 * Student: Travis Williamson
 * 
 */

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {

	private HashMap<String, Appointment> appointments;
	
	public AppointmentService() {
		this.appointments = new HashMap<String, Appointment>(10);	
	}
	
	public void addAppointment(String id, Date date, String desc) {
		Appointment temp = new Appointment(id,date,desc);
		//If appointment object successfully created, add to map otherwise prep for gc
		if(!appointments.containsKey(id) && temp.getAppointmentID() != null) {
			appointments.put(id, temp);
		}
		else {
			temp = null;
		}		
	}
	
	public Appointment getAppointment(String id) {
			return appointments.get(id);
	}
	
	public void deleteAppointment(String id) {
		if(appointments.get(id) != null) {
			appointments.remove(id);
		}
	}
}
