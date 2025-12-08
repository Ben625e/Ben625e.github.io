package appointment;

import java.util.Date;

// Appointment Class that stores a unique id, date, and description

public class Appointment {
	
	// Private Variable declaration
	
	// Unique ID, Not null and <= 10 characters, Not updatable
	private String appointmentID;
	// Date of Appointment, Not null and Not in past
	private Date appointmentDate;
	// Description of appointment, Not null and <= 50 characters
	private String description;
	
	public Appointment(String id, Date date, String descr) {
		// appointmentID input validation
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid appointmentID");
		}
		// appointmentDate input validation
		if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointmentDate");
		}
		// description input validation
		if(descr == null || descr.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		// Values checked, set them into the private variables
		this.appointmentID = id;
		this.appointmentDate = date;
		this.description = descr;
	}
	
	// Setters for appointmentDate and description
	public void setDate(Date date) {
		// appointmentDate input validation
		if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointmentDate");
		}
		// Value checked, set them into the private variables
		this.appointmentDate = date;
	}
	
	public void setDescription(String descr) {
		// description input validation
		if(descr == null || descr.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		// Value checked, set them into the private variables
		this.description = descr;
	}
	
	// Getters for all the private variables
	public String getID() {
		return appointmentID;
	}
	
	public Date getDate() {
		return appointmentDate;
	}
	
	public String getDescription() {
		return description;
	}

}
