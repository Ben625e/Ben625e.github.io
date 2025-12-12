package appointment;

import java.util.ArrayList;
import java.util.Date;

// This class is the controller that makes use of the Appointment class
// It uses an ArrayList structure and allows for adding, deleting, and reading
// Appointments stored

public class AppointmentService {
	
	// ArrayList that holds the Appointment objects
	public ArrayList<Appointment> Appointments;
	
	// Default Constructor
	public AppointmentService() {
		Appointments = new ArrayList<Appointment>();
	}
	
	// Add Appointment after ensuring the ID is not in use
	public void addAppointment(String id, Date date, String descr) {
		// If it isn't empty, go through all the Appointment objects to make sure the appointmentID isn't in use
		if(Appointments.size() != 0) {
			for(int i = 0; i < Appointments.size(); i++) {
				if(Appointments.get(i).getID().equals(id)) {
					throw new IllegalArgumentException("In Use appointmentID");
				}
			}
		}
		// Adds a new Appointment object to Appointments
		Appointment Appointment = new Appointment(id, date, descr);
		Appointments.add(Appointment);
	}
	
	// Finds and deletes the Appointment from the given ID
	public void deleteAppointment(String id) {
		// Go through entire List, When found, remove and return out of the method
		for(int i = 0; i < Appointments.size(); i++) {
			if(Appointments.get(i).getID().equals(id)) {
				Appointments.remove(i);
				return;
			}
		}
		// If none is found, throw an exception
		throw new IllegalArgumentException("No Such appointmentID For Deletion");
	}
	
	// ENHANCEMENT DONE 11/10/2025 BY BENJAMIN MILLS
	// This function returns an ArrayList of Appointments, sorted by date by most recent first, Using Insertion Method
	public ArrayList<Appointment> readAppointments() {
		// Declare variable that will be returned
		ArrayList<Appointment>  sortedAppointments = new ArrayList<>(Appointments);
		
		// Try to return sorted list, catch error and print them out then throw exception
		try {
			// If the list is empty, return the empty list
			if(sortedAppointments.size() == 0 ) {
				return sortedAppointments;
			}
			// Go through entire list, insert current appointment into sorted list in the correct order, then return list
			for(int i = 1; i < Appointments.size(); i++) {
				Appointment holderApp = sortedAppointments.get(i);
				int j = i;
				while(j > 0 && sortedAppointments.get(j-1).getDate().after(holderApp.getDate())) {
					sortedAppointments.set(j, sortedAppointments.get(j-1));
					j--;
				}
				sortedAppointments.set(j, holderApp);
			}
			return sortedAppointments;
		} catch (Exception e){
			System.out.println("Exception Occured in readAppointments");
			throw e;
		}
	}

}
