package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.AppointmentService;

// Test class for AppointmentService

class AppointmentServiceTest {

	// Test creating creating and adding a Appointment to AppointmentService
		@Test
		void testAppointmentServiceClass() {
			@SuppressWarnings("deprecation")
			Date futureDate = new Date(2026,1,1);
			AppointmentService AppointmentService = new AppointmentService();
			AppointmentService.addAppointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			assertTrue(AppointmentService.Appointments.get(0).getID().equals("123456789"));
			assertTrue(AppointmentService.Appointments.get(0).getDate().equals(futureDate));
			assertTrue(AppointmentService.Appointments.get(0).getDescription().equals("This Appointment Pertains to Test Running"));
		}
		
		// Tries to add a Appointment with the same ID
		@Test
		void testTaskServiceClassSameID() {
			@SuppressWarnings("deprecation")
			Date futureDate = new Date(2026,1,1);
			AppointmentService AppointmentService = new AppointmentService();
			AppointmentService.addAppointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				AppointmentService.addAppointment("123456789", futureDate, "Trying With Same ID");
			});
		}
		
		// Tries to add a Appointment with invalid data
			@Test
			void testTaskServiceClassWrongData() {
				@SuppressWarnings("deprecation")
				Date futureDate = new Date(2026,1,1);
				Date pastDate = new Date(1);
				AppointmentService AppointmentService = new AppointmentService();
				AppointmentService.addAppointment("123456789", futureDate, "This Appointment Pertains to Test Running");
				// The following tests for too long data
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					AppointmentService.addAppointment("12345678912", futureDate, "This Is For Testing");
				});
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					AppointmentService.addAppointment("123456789", futureDate, "This Description Is Over the Fifty Character Limit"
							+ " That Was Set For Descriptions");
				});
				// The following tests for null data
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					AppointmentService.addAppointment(null, futureDate, "This Is For Testing");
				});
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					AppointmentService.addAppointment("123456789", null, "This Is For Testing");
				});
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					AppointmentService.addAppointment("123456789", futureDate, null);
				});
				// The following tests a past date
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					AppointmentService.addAppointment("123456789", pastDate, "This Is For Testing");
				});
			}
		
		// Test for creating the same Appointment with a different ID
		@Test
		void testTaskServiceClassDifferentID() {
			@SuppressWarnings("deprecation")
			Date futureDate = new Date(2026,1,1);
			AppointmentService AppointmentService = new AppointmentService();
			AppointmentService.addAppointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			AppointmentService.addAppointment("987654321", futureDate, "This Appointment Is New");
		}
		
		// Tests deletion of an Appointment from AppointmentService
		@Test
		void testTaskServiceClassDelete() {
			@SuppressWarnings("deprecation")
			Date futureDate = new Date(2026,1,1);
			AppointmentService AppointmentService = new AppointmentService();
			AppointmentService.addAppointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			AppointmentService.addAppointment("987654321", futureDate, "This Appointment Is New");
			AppointmentService.deleteAppointment("987654321");
			// Goes through all Appointments and checks it does not equal the deleted ID
			for(int i = 0; i < AppointmentService.Appointments.size(); i++) {
				assertFalse(AppointmentService.Appointments.get(i).getID().equals("987654321"));
			}
		}
		
		// Tests deletion of a non-existent Appointment
		@Test
		void testTaskServiceClassDeleteNoID() {
			@SuppressWarnings("deprecation")
			Date futureDate = new Date(2026,1,1);
			AppointmentService AppointmentService = new AppointmentService();
			AppointmentService.addAppointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService.deleteAppointment("987654321");
			});
		}

}
