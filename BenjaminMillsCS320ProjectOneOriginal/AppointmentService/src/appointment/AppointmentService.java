package appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	
	// ArrayList that holds the Appointment objects
	public ArrayList<Appointment> Appointments;
	
	public AppointmentService() {
		Appointments = new ArrayList<Appointment>();
	}
	
	// Adds an appointment after ensuring the ID is unique
	public void addAppointment(String id, Date date, String descr) {
		// Checks if Appointments is empty
		if(Appointments.size() != 0) {
			// If it isn't empty, go through all the Appointment objects to make sure the appointmentID isn't in use
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
	
	// Finds and deletes the appointment from the given id
	public void deleteAppointment(String id) {
		// iterates through all the Appointment objects in Appointments
		for(int i = 0; i < Appointments.size(); i++) {
			// When found, remove and return out of the method
			if(Appointments.get(i).getID().equals(id)) {
				Appointments.remove(i);
				return;
			}
		}
		// If none is found, throw an exception
		throw new IllegalArgumentException("No Such appointmentID For Deletion");
	}

}
