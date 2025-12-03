package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
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
		void testAppointmentServiceClassSameID() {
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
		void testAppointmentServiceClassWrongData() {
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
		void testAppointmentServiceClassDifferentID() {
			@SuppressWarnings("deprecation")
			Date futureDate = new Date(2026,1,1);
			AppointmentService AppointmentService = new AppointmentService();
			AppointmentService.addAppointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			AppointmentService.addAppointment("987654321", futureDate, "This Appointment Is New");
		}
		
		// Tests deletion of an Appointment from AppointmentService
		@Test
		void testAppointmentServiceClassDelete() {
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
		void testAppointmentServiceClassDeleteNoID() {
			@SuppressWarnings("deprecation")
			Date futureDate = new Date(2026,1,1);
			AppointmentService AppointmentService = new AppointmentService();
			AppointmentService.addAppointment("123456789", futureDate, "This Appointment Pertains to Test Running");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService.deleteAppointment("987654321");
			});
		}
		
		// ENHANCEMENT DONE 11/12/2025 BY BENJAMIN MILLS
		@SuppressWarnings("deprecation")
		// Tests newly created read function is working as intended
		@Test
		public void testAppointmentServiceClassRead() {
			Date Date1 = new Date(2026, 1 ,1);
			Date Date2 = new Date(2026, 2 ,1);
			Date Date3 = new Date(2026, 3 ,1);
			Date Date4 = new Date(2026, 4 ,1);
			Date Date5 = new Date(2026, 5 ,1);
			AppointmentService AppointmentService = new AppointmentService();
			AppointmentService.addAppointment("123456789", Date2, "This has the second Date");
			AppointmentService.addAppointment("234516978", Date4, "This has the fourth Date");
			AppointmentService.addAppointment("345167891", Date3, "This has the third Date");
			AppointmentService.addAppointment("457689132", Date1, "This has the first Date");
			AppointmentService.addAppointment("976834516", Date5, "This has the fifth Date");
			ArrayList<Appointment> sortedAppointments = AppointmentService.readAppointments();
			// Goes through the list and makes sure it is in sorted ascending order
			for(int i = 1; i < sortedAppointments.size(); i++) {
				assertTrue(sortedAppointments.get(i-1).getDate().before(sortedAppointments.get(i).getDate()));
			}
		}
		
		// ENHANCEMENT 2 DONE 11/21/25
		// Tests the speed of adding 10000 Appointments to the ArrayList
		@SuppressWarnings("deprecation")
		@Test
		void testAppointmentServiceClassSpeedLow() {
			Date futureDate = new Date(2026,1,1);
			String description = "This is a valid Description";
			AppointmentService AppointmentService = new AppointmentService();
			ArrayList<String> randomIDs = new ArrayList<>();
			for(int i = 0; i < 10000; i++) {
				randomIDs.add(Integer.toString(i));
			}
			// Shuffles the ArrayList randomly
			Collections.shuffle(randomIDs);
			for(int i = 0; i < randomIDs.size(); i++) {
				AppointmentService.addAppointment(randomIDs.get(i), futureDate, description);
			}
		}
		
		// ENHANCEMENT 2 DONE 11/21/25
		// Tests the speed of adding 50000 Appointments to the ArrayList
		@SuppressWarnings("deprecation")
		@Test
		void testAppointmentServiceClassSpeedMid() {
			Date futureDate = new Date(2026,1,1);
			String description = "This is a valid Description";
			AppointmentService AppointmentService = new AppointmentService();
			ArrayList<String> randomIDs = new ArrayList<>();
			for(int i = 0; i < 50000; i++) {
				randomIDs.add(Integer.toString(i));
			}
			// Shuffles the ArrayList randomly
			Collections.shuffle(randomIDs);
			for(int i = 0; i < randomIDs.size(); i++) {
				AppointmentService.addAppointment(randomIDs.get(i), futureDate, description);
			}
		}
				
		// ENHANCEMENT 2 DONE 11/21/25
		// Tests the speed of adding 100000 Appointments to the ArrayList
		@SuppressWarnings("deprecation")
		@Test
		void testAppointmentServiceClassSpeedHigh() {
			Date futureDate = new Date(2026,1,1);
			String description = "This is a valid Description";
			AppointmentService AppointmentService = new AppointmentService();
			ArrayList<String> randomIDs = new ArrayList<>();
			for(int i = 0; i < 100000; i++) {
				randomIDs.add(Integer.toString(i));
			}
			// Shuffles the ArrayList randomly
			Collections.shuffle(randomIDs);
			for(int i = 0; i < randomIDs.size(); i++) {
				AppointmentService.addAppointment(randomIDs.get(i), futureDate, description);
			}
		}
}
