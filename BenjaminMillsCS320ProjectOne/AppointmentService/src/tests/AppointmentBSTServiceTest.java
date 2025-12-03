package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentBSTService;

// ENHANCEMENT 2 DONE 11/20/25
// Test class for the newly implemented BST
// Implements all the tests from the previous AppointmentServiceTest
// These include creating a BST, adding to the BST, deleting from the BST
// reading from the BST, and includes the newly added single search from the BST

class AppointmentBSTServiceTest {

	// Test For creating an instance of the BST, adding an Appointment, and finding Appointment
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClass() {
		Date futureDate = new Date(2026,1,1);
		Appointment newAppointment = new Appointment("123456789", futureDate, "This is a Test");
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		AppointmentBSTService.addAppointment(newAppointment);
		Appointment testAppointment = AppointmentBSTService.findAppointment("123456789");
		assertTrue(testAppointment.getID().equals("123456789"));
		assertTrue(testAppointment.getDate().equals(futureDate));
		assertTrue(testAppointment.getDescription().equals("This is a Test"));
	}
	
	// Attempts to add an Appointment with the same ID which should result in an exception
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassSameID() {
		Date futureDate = new Date(2026,1,1);
		Appointment newAppointment = new Appointment("123456789", futureDate, "This is a Test");
		Appointment sameIDAppointment = new Appointment("123456789", futureDate, "This ID is in Use");
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		AppointmentBSTService.addAppointment(newAppointment);
		assertTrue(newAppointment == AppointmentBSTService.findAppointment("123456789"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.addAppointment(sameIDAppointment);
		});
	}
	
	// Attempts to add an Appointment with invalid data from the parameters set by the company
	// found in the Appointment class
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassWrongData() {
		// Sets up valid data for Appointment
		Date futureDate = new Date(2026,1,1);
		String id = "123456789";
		String description = "This is a valid Description";
		// Sets up invalid data for Appointment
		Date pastDate = new Date(1);
		String badID = "12345678912";
		String badDescription = "This Description is over the fifty character limit which is over the parameters";
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		// Adds with valid data to ensure it is valid
		AppointmentBSTService.addAppointment(new Appointment(id, futureDate, description));
		
		// Tests an exception is thrown with each bad data being inputed
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.addAppointment(new Appointment(badID, futureDate, description));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.addAppointment(new Appointment(id, pastDate, description));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.addAppointment(new Appointment(id, futureDate, badDescription));
		});
		
		// Checks if an exception is thrown with null values
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.addAppointment(new Appointment(null, futureDate, description));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.addAppointment(new Appointment(id, null, description));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.addAppointment(new Appointment(id, futureDate, null));
		});
	}
	
	// Tests for adding multiple Appointments with different ID
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassDifferentID() {
		Date futureDate = new Date(2026,1,1);
		String id1 = "548791623";
		String id2 = "234576891";
		String id3 = "781946532";
		String id4 = "123456789";
		String id5 = "987654321";
		String description = "This is a valid Description";
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		AppointmentBSTService.addAppointment(new Appointment(id1, futureDate, description));
		AppointmentBSTService.addAppointment(new Appointment(id2, futureDate, description));
		AppointmentBSTService.addAppointment(new Appointment(id3, futureDate, description));
		AppointmentBSTService.addAppointment(new Appointment(id4, futureDate, description));
		AppointmentBSTService.addAppointment(new Appointment(id5, futureDate, description));
	}
	
	// Tests the deletion function
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassDelete() {
		Date futureDate = new Date(2026,1,1);
		String id1 = "123456789";
		String id2 = "547896321";
		String description = "This is a valid Description";
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		AppointmentBSTService.addAppointment(new Appointment(id1, futureDate, description));
		AppointmentBSTService.findAppointment(id1);
		// Adds an Appointment as exception is thrown searching an empty BST
		AppointmentBSTService.addAppointment(new Appointment(id2, futureDate, "Completely new Appointment"));
		// Checks if the Appointment can be found
		AppointmentBSTService.findAppointment(id1);
		AppointmentBSTService.deleteAppointment(id1);
		// If deletion occurred, an exception should occur
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.findAppointment(id1);
		});
		// Checks that exception wasn't thrown due to empty BST
		AppointmentBSTService.findAppointment(id2);
	}
	
	// Tests exception for deleting non-existant Appointment
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassDeleteNotFound() {
		Date futureDate = new Date(2026,1,1);
		String id = "123456789";
		String description = "This is a valid Description";
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		// Adds an Appointment as exception is thrown deleting from an empty BST
		AppointmentBSTService.addAppointment(new Appointment(id, futureDate, description));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentBSTService.deleteAppointment("987654321");
		});
	}
	
	// Tests the read function sends an ArrayList back and checks it is sorted correctly
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassRead() {
		// Sets different dates as sorted data should be by date in ascending order
		Date Date1 = new Date(2026,1,1);
		Date Date2 = new Date(2026,2,1);
		Date Date3 = new Date(2026,3,1);
		Date Date4 = new Date(2026,4,1);
		Date Date5 = new Date(2026,5,1);
		String id1 = "548791623";
		String id2 = "234576891";
		String id3 = "781946532";
		String id4 = "123456789";
		String id5 = "987654321";
		String description = "This is a valid Description";
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		// Adds Appointments in random order to ensure they are not sorted prior to read
		AppointmentBSTService.addAppointment(new Appointment(id3, Date2, description));
		AppointmentBSTService.addAppointment(new Appointment(id2, Date4, description));
		AppointmentBSTService.addAppointment(new Appointment(id4, Date3, description));
		AppointmentBSTService.addAppointment(new Appointment(id1, Date1, description));
		AppointmentBSTService.addAppointment(new Appointment(id5, Date5, description));
		ArrayList<Appointment> sortedAppointments = AppointmentBSTService.readAppointments();
		// Goes through ArrayList and checks it is sorted in ascending order
		for(int i = 1; i < sortedAppointments.size(); i++) {
			assertTrue(sortedAppointments.get(i-1).getDate().before(sortedAppointments.get(i).getDate()));
		}
		assertTrue(sortedAppointments.size() == 5);
	}
	
	// Tests the speed of adding 10000 to the BST in a random order
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassSpeedLow() {
		Date futureDate = new Date(2026,1,1);
		String description = "This is a valid Description";
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		ArrayList<String> randomIDs = new ArrayList<>();
		for(int i = 0; i < 10000; i++) {
			randomIDs.add(Integer.toString(i));
		}
		// Shuffles the ArrayList randomly
		Collections.shuffle(randomIDs);
		for(int i = 0; i < randomIDs.size(); i++) {
			AppointmentBSTService.addAppointment(new Appointment(randomIDs.get(i), futureDate, description));
		}
	}
	
	// Tests the speed of adding 50000 to the BST in a random order
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassSpeedMid() {
		Date futureDate = new Date(2026,1,1);
		String description = "This is a valid Description";
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		ArrayList<String> randomIDs = new ArrayList<>();
		for(int i = 0; i < 50000; i++) {
			randomIDs.add(Integer.toString(i));
		}
		// Shuffles the ArrayList randomly
		Collections.shuffle(randomIDs);
		for(int i = 0; i < randomIDs.size(); i++) {
			AppointmentBSTService.addAppointment(new Appointment(randomIDs.get(i), futureDate, description));
		}
	}
		
	// Tests the speed of adding 100000 to the BST in a random order
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentBSTServiceClassSpeedHigh() {
		Date futureDate = new Date(2026,1,1);
		String description = "This is a valid Description";
		AppointmentBSTService AppointmentBSTService = new AppointmentBSTService();
		ArrayList<String> randomIDs = new ArrayList<>();
		for(int i = 0; i < 100000; i++) {
			randomIDs.add(Integer.toString(i));
		}
		// Shuffles the ArrayList randomly
		Collections.shuffle(randomIDs);
		for(int i = 0; i < randomIDs.size(); i++) {
			AppointmentBSTService.addAppointment(new Appointment(randomIDs.get(i), futureDate, description));
		}
	}
}
