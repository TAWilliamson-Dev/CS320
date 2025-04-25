/*
 * CS320 Software Test, Automation QA
 * Module 5 Milestone - AppointmentTest.java
 * Instructor: Angelo Luo
 * Student: Travis Williamson
 * 
 */

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppointmentTest {
	
	private Date date = new Date(System.currentTimeMillis() + 1000);
	
	@Test
	void testValidAppointment() {
		Appointment appointment = new Appointment("123", date, "ABC");
		
		assertEquals("123", appointment.getAppointmentID());
	}
	
	@Test
	void testIdNull( ) {
		Appointment appointment = new Appointment(null, date, "ABC");
		
		assertNull(appointment.getAppointmentDate());
	}
	
	@Test
	void testIdTooLong() {
		Appointment appointment = new Appointment("12345678900", date, "ABC");
		
		assertNull(appointment.getAppointmentDate());		
	}
	
	@Test
	void testIdExactLength() {
		Appointment appointment = new Appointment("1234567890", date, "ABC");
		
		assertEquals("1234567890", appointment.getAppointmentID());
	}
	
	@Test
	void testPastDate() {
		Date pastDate = new Date(0);
		
		Appointment appointment = new Appointment("123", pastDate, "ABC");
		
		assertNull(appointment.getAppointmentID());
	}

	@Test
	void testCurrentDate() {
		Date currentTime = new Date(System.currentTimeMillis());
		
		Appointment appointment = new Appointment("123", currentTime, "ABC");
		
		assertEquals("123", appointment.getAppointmentID());
	}
	
	@Test
	void testTimeNull() {
		Appointment appointment = new Appointment("123", null, "ABC");
		
		assertNull(appointment.getAppointmentID());		
	}
	
	@Test
	void testDescNull() {
		Appointment appointment = new Appointment("1234567890", date, null);
		
		assertNull(appointment.getAppointmentID());
	}
	
	@Test
	void testDescTooLong() {
		String tooLong = "A 1234567890 1234567890 1234567890 1234567890 1234567890";
		Appointment appointment = new Appointment("1234567890", date, tooLong);
		
		assertNull(appointment.getAppointmentID());		
	}
	
	@Test
	void testDescExactMaxLength() {
		String exactMax = "123456789 123456789 123456789 123456789 1234567890";
		Appointment appointment = new Appointment("1234567890", date, exactMax);
		
		assertEquals("1234567890", appointment.getAppointmentID());
	}
}
