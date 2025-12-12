package appointment;

import java.util.Date;

// Appointment Class that stores a unique id, date, and description
// The current implementation has the data stored locally
// The variables have the following parameters set by the stakeholders
// Unique ID should not be null, > 10 characters, and Not updatable
// Date should not be null or set in the past
// Description should not be null or > 50 characters

public class Appointment {
	
	// Private Variable declaration
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	// Public Function Declaration
	
	// Constructor
	public Appointment(String id, Date date, String descr) {
		// Input Validation
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid appointmentID");
		}
		if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointmentDate");
		}
		if(descr == null || descr.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		// Value being set
		this.appointmentID = id;
		this.appointmentDate = date;
		this.description = descr;
	}
	
	// Setters, no Setter for the unique ID
	public void setDate(Date date) {
		// Input Validation
		if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointmentDate");
		}
		
		this.appointmentDate = date;
	}
	
	public void setDescription(String descr) {
		// Input Validation
		if(descr == null || descr.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.description = descr;
	}
	
	// Getters
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
