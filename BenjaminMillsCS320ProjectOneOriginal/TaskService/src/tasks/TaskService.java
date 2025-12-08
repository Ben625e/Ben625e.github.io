package tasks;

// Imports ArrayList to hold the Task objects
import java.util.ArrayList;

// Holds the Task objects and allow for adding, deleting, and updating them
public class TaskService {
	
	// Array that holds the Task objects
	public ArrayList<Task> Tasks;
	
	// Default constructor method which create an empty ArrayList of Task objects
	public TaskService() {
		Tasks = new ArrayList<Task>();
	}
	
	// Adds a Task using the provided id, name, and descr
	public void addTask(String id, String name, String descr) {
		// Checks if TaskService is empty
		if(Tasks.size() != 0) {
			// If it isn't empty, go through all the Task objects to make sure the taskID isn't in use
			for(int i = 0; i < Tasks.size(); i++) {
				// Throw an exception if id is in use
				if(Tasks.get(i).getTaskID().equals(id)) {
					throw new IllegalArgumentException("In Use taskID");
				}
			}
		}
		// Adds a new Task object to TaskService
		Task Task = new Task(id, name, descr);
		Tasks.add(Task);
	}
	
	// Deletes a task with the provide taskID
	public void deleteTask(String id) {
		// iterates through all the Task objects in TaskService
		for(int i = 0; i < Tasks.size(); i++) {
			// When found, remove and return out of the method
			if(Tasks.get(i).getTaskID().equals(id)) {
				Tasks.remove(i);
				return;
			}
		}
		// If none is found, throw an exception
		throw new IllegalArgumentException("No Such taskID For Deletion");
	}
	
	// Used to update the name of the task with the given taskID
	public void updateTaskName(String id, String name) {
		// for all the Task objects in TaskService
		for(int i = 0; i < Tasks.size(); i++) {
			// when a match is found, call setName and return out of the method
			if(Tasks.get(i).getTaskID().equals(id)) {
				Tasks.get(i).setName(name);;
				return;
			}
		}
		// if no match is found, throw an exception
		throw new IllegalArgumentException("No Such taskID For Name");
	}
	
	// Used to update the description of the task with the given taskID
	public void updateTaskDescription(String id, String descr) {
		// for all the Task objects in TaskService
		for(int i = 0; i < Tasks.size(); i++) {
			// when a match is found, call setDescription and return out of the method
			if(Tasks.get(i).getTaskID().equals(id)) {
				Tasks.get(i).setDescription(descr);;
				return;
			}
		}
		// if no match is found, throw an exception
		throw new IllegalArgumentException("No Such taskID For Description");
	}
}
