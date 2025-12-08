package tasks;

// Task class which holds a unique ID, a name, and description for tasks in the mobile application
public class Task {
	
	// Private variables used in the task class
	// taskID will not have a setter, it is non-updatable
	private String taskID;
	private String name;
	private String description;
	
	// Default constructor with input checking and error handling
	public Task(String id, String name, String descr) {
		// taskID must be less than 10 characters and not null
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid taskID");
		}
		// name must be less than 20 characters and not null
		if(name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid name");
		}
		// description must be less than 50 characters and not null
		if(descr == null || descr.length()>50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		// Put checked data in class variables
		this.taskID = id;
		this.name = name;
		this.description = descr;
	}
	
	// getter for name
	public String getName() {
		return name;
	}
	
	// setter for name with input checking and error handling
	public void setName(String name) {
		if(name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
	}
	
	// getter for description
	public String getDescription() {
		return description;
	}
	
	// setter for description with input checking and error handling
	public void setDescription(String descr) {
		if(descr == null || descr.length()>50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = descr;
	}
	
	// getter for taskID
	public String getTaskID() {
		return taskID;
	}
}
