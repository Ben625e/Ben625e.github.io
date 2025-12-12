package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

import appointment.Appointment;

// Test class for the Appointment class

class AppointmentTest {

	// This tests the default constructor of the class
	@Test
	public void testAppointmentClass() {
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2026, 1 ,1);
		Appointment Appointment = new Appointment("123456789", futureDate, "This Appointment Pertains to Test Running");
		assertTrue(Appointment.getID().equals("123456789"));
		assertTrue(Appointment.getDate().equals(futureDate));
		assertTrue(Appointment.getDescription().equals("This Appointment Pertains to Test Running"));
	}
	
	// The following tests test null values sent to the default constructor
	@Test
	public void testAppointmentClassIDNull() {
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2026, 1 ,1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate, "This Appointment Pertains to Test Running");
		});
	}
	
	@Test
	public void testAppointmentClassDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", null, "This Appointment Pertains to Test Running");
		});
	}
	
	@Test
	public void testAppointmentClassDescriptionNull() {
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2026, 1 ,1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", futureDate, null);
		});
	}
	
	// The following tests test incorrect values sent to the default constructor
	@Test
	public void testAppointmentClassIDTooLong() {
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2026, 1 ,1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789123", futureDate, "This Appointment Pertains to Test Running");
		});
	}
	
	@Test
	public void testAppointmentClassDateBefore() {
		Date pastDate = new Date(100);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", pastDate, "This Appointment Pertains to Test Running");
		});
	}
	
	@Test
	public void testAppointmentClassDescriptionTooLong() {
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2026, 1 ,1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", futureDate, "This Appointments Description Is Over The Fifty Character Limit");
		});
	}
	
	// The following tests test null values sent to the setters
	@Test
	public void testAppointmentSetDateNull() {
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2026, 1 ,1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment Appointment = new Appointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			Appointment.setDate(null);
		});
	}
		
	@Test
	public void testAppointmentSetDescriptionNull() {
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2026, 1 ,1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment Appointment = new Appointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			Appointment.setDescription(null);
		});
	}
	
	// Tests incorrect values sent to the setters
	@Test
	public void testAppointmentSetDateBefore() {
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2026, 1 ,1);
		Date pastDate = new Date(100);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment Appointment = new Appointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			Appointment.setDate(pastDate);
		});
	}
	

}
