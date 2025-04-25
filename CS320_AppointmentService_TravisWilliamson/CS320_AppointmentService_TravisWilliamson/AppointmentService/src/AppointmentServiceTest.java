import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * CS320 Software Test, Automation QA
 * Module 5 Milestone - AppointmentServiceTest.java
 * Instructor: Angelo Luo
 * Student: Travis Williamson
 * 
 * Test 1: Valid appointment added
 * Test 2: Duplicate appointment id not added
 * Test 3: Invalid appointment not added
 * Test 4: Appointment successfully deleted
 */

class AppointmentServiceTest {

	private AppointmentService appointments = new AppointmentService();
	@Test
	void testValidAppointment() {
		Date date = new Date();
		Date futureDate = new Date(date.getTime() + 1);
		
		Appointment temp = new Appointment("123",futureDate, "ABC");	
		
		appointments.addAppointment("123",futureDate, "ABC");
		
		assertEquals(temp.getAppointmentID(), appointments.getAppointment("123").getAppointmentID());
	}
	
	@Test
	void testDuplicateNotAdded() {
		Date date = new Date();
		Date futureDate = new Date(date.getTime() + 1);
		
		appointments.addAppointment("123",futureDate,"ABC");
		appointments.addAppointment("123", futureDate, "DEF");
		
		assertNotEquals("DEF", appointments.getAppointment("123").getAppointmentDescription());
	}
	
	//Fail to add appointment in the past
	@Test
	void testInvalidAppointment() {
		Date date = new Date();
		Date pastDate = new Date(date.getTime() - 1);
		
		appointments.addAppointment("456", pastDate, "ABC");
		
		assertNull(appointments.getAppointment("456"));
	}
	
	@Test
	void testDeleteAppointment() {
		Date date = new Date();
		Date futureDate = new Date(date.getTime() + 1);
		
		appointments.addAppointment("123", futureDate, "ABC");
		
		assertEquals("123",appointments.getAppointment("123").getAppointmentID());
		
		appointments.deleteAppointment("123");
		
		assertNull(appointments.getAppointment("123"));
	}

}
