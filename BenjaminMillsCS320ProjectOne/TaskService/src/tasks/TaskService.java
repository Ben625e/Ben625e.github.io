package tasks;

import java.util.ArrayList;

// TaskService which stores Task objects in an ArrayList and has the following functionality
// It can add, delete, read, and update Contact objects
// It can only update a Task's name and description

public class TaskService {
	
	// Array that holds the Task objects
	public ArrayList<Task> Tasks;
	
	// Default constructor method which create an empty ArrayList of Task objects
	public TaskService() {
		Tasks = new ArrayList<Task>();
	}
	
	// Adds a Task using the provided id, name, and descr
	public void addTask(String id, String name, String descr) {
		// If Tasks isn't empty, If a matching ID is found, throw an exception as it isn't unique
		if(Tasks.size() != 0) {
			for(int i = 0; i < Tasks.size(); i++) {
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
		// For all Tasks, If a matching ID is found, remove and return out of the method
		for(int i = 0; i < Tasks.size(); i++) {
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
		// for all the Task objects in TaskService, If a matching ID is found, call setName and return out of the method
		for(int i = 0; i < Tasks.size(); i++) {
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
		// for all the Task objects in TaskService, If a matching ID is found, call setDescription and return out of the method
		for(int i = 0; i < Tasks.size(); i++) {
			if(Tasks.get(i).getTaskID().equals(id)) {
				Tasks.get(i).setDescription(descr);;
				return;
			}
		}
		// if no match is found, throw an exception
		throw new IllegalArgumentException("No Such taskID For Description");
	}
	
	// ENHANCEMENT DONE 11/10/2025 BY BENJAMIN MILLS
	// UPDATE DONE 11/24/2025 : Change sorted type from ID to name
	// This function returns an ArrayList of Tasks, sorted by task ID
	public ArrayList<Task> readTasks() {
		// Declare variable that will be returned
		ArrayList<Task>  sortedTasks = new ArrayList<>(Tasks);
		
		// Try to return sorted list, catch error and print them out then throw exception
		try {
			// If the list is empty, return the empty list
			if(sortedTasks.size() == 0 ) {
				return sortedTasks;
			}
			// Go through entire list, insert current appointment into sorted list in the correct order, then return list
			for(int i = 1; i < Tasks.size(); i++) {
				Task holderApp = sortedTasks.get(i);
				int j = i;
				while(j > 0 && sortedTasks.get(j-1).getName().compareTo(holderApp.getName()) > 0) {
					sortedTasks.set(j, sortedTasks.get(j-1));
					j--;
				}
				sortedTasks.set(j, holderApp);
			}
			return sortedTasks;
		} catch (Exception e){
			System.out.println("Exception Occured in readTasks");
			throw e;
		}
	}
}
