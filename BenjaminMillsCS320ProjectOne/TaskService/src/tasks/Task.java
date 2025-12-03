package tasks;

// Task Class that stores a unique id, name, and description
// The current implementation has the data stored locally
// The variables have the following parameters set by the stakeholders
// Unique ID should not be null, > 10 characters, and Not updatable
// Name should not be null or > 20 characters
// Description should not be null or > 50 characters

public class Task {
	
	// Private variables used in the task class
	private String taskID;
	private String name;
	private String description;
	
	// Default constructor
	public Task(String id, String name, String descr) {
		// Input Validation
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid taskID");
		}
		if(name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid name");
		}
		if(descr == null || descr.length()>50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		// Put checked data in class variables
		this.taskID = id;
		this.name = name;
		this.description = descr;
	}
	
	// Setters, no Setter for unique ID
	public void setName(String name) {
		if(name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
	}
	
	public void setDescription(String descr) {
		if(descr == null || descr.length()>50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = descr;
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getTaskID() {
		return taskID;
	}
}
