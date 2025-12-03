package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tasks.Task;
import tasks.TaskBSTService;

// ENHANCEMENT 2 DONE 11/21/25
// Test class for the newly implemented BST
// Implements all the tests from the previous AppointmentServiceTest
// These include creating a BST, adding to the BST, deleting from the BST,
// updating from the BST, reading from the BST, and includes the newly 
// added single search from the BST

class TaskBSTServiceTest {

	// Test Variables that are used frequently
	String id = "123456789";
	String name = "John Doe";
	String description = "This is Valid";
	TaskBSTService TaskBST = new TaskBSTService();
	
	// Test for adding a Task to the BST and the find function
	@Test
	void testTaskBSTServiceClass() {
		TaskBST.addTask(new Task(id,name,description));
		Task testTask = TaskBST.findTask(id);
		assertTrue(testTask.getTaskID().equals(id));
		assertTrue(testTask.getName().equals(name));
		assertTrue(testTask.getDescription().equals(description));
	}
	
	// Attempts to add a Task with an ID that is in use, exception is expected
	@Test
	void testTaskBSTServiceClassSameID() {
		TaskBST.addTask(new Task(id,name,description));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.addTask(new Task(id, "Jane Doe", "This is Also Valid"));
		});
	}
	
	// Attempts to add a Task with invalid data which is defined in the Task Class
	@Test
	void testTaskBSTServiceClassWrongData() {
		// Sets up invalid data
		String badID = "12345678912";
		String badName = "FarTooLongNameAnthony";
		String badDescription = "This Description Is Not Valid Because It Is Too Long Surpassing The Fifty Character Limit";
		
		// Adds with valid data to ensure it is valid
		TaskBST.addTask(new Task(id,name,description));
		
		// Tests for exception being thrown from the bad data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.addTask(new Task(badID,name,description));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.addTask(new Task(id,badName,description));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.addTask(new Task(id,name,badDescription));
		});
		
		// Tests for exception being thrown from null value
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.addTask(new Task(null,name,description));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.addTask(new Task(id,null,description));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.addTask(new Task(id,name,null));
		});
	}
	
	// Tests the deletion function
	@Test
	void testTaskBSTServiceClassDelete() {
		String id1 = "123456789";
		String id2 = "987654321";
		TaskBST.addTask(new Task(id1, name, description));
		TaskBST.findTask(id1);
		// Adds a Task as exception is thrown searching an empty BST
		TaskBST.addTask(new Task(id2, name, description));
		// Checks if the Task can be found
		TaskBST.findTask(id1);
		TaskBST.deleteTask(id1);
		// If deletion occurred, an exception should occur
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.findTask(id1);
		});
		// Checks that exception wasn't due to empty BST
		TaskBST.findTask(id2);
	}
	
	// Tests exception from deleting empty BST and non-existant Task
	@Test
	void testTaskBSTServiceClassDeleteNotFound() {
		// BST is Empty, any ID should throw an exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.deleteTask(id);
		});
		TaskBST.addTask(new Task(id,name,description));
		// Attempts to delete random ID not in use
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.deleteTask("654987123");
		});
	}
	
	// Tests the update function for name
	@Test
	void testTaskBSTServiceClassUpdateName() {
		TaskBST.addTask(new Task(id,name,description));
		TaskBST.updateTaskName(id, "Jane Dee");
		assertTrue(TaskBST.findTask(id).getName().equals("Jane Dee"));
	}
	
	// Tests the update function for description
	@Test
	void testTaskBSTServiceClassUpdateDescription() {
		TaskBST.addTask(new Task(id,name,description));
		TaskBST.updateTaskDescription(id, "New Testing Description!");
		assertTrue(TaskBST.findTask(id).getDescription().equals("New Testing Description!"));
	}
	
	// Tests the update functions with incorrect ID
	@Test
	void testTaskBSTServiceClassUpdateWrongID() {
		// Sets up invalid data
		String badID = "12345678912";
		
		TaskBST.addTask(new Task(id,name,description));
		
		// Tests each update with wrong ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.updateTaskName(badID, "Jane Dee");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.updateTaskDescription(badID, "New Description");
		});
	}
	
	// Tests for exception when updating with bad Data
	@Test
	void testTaskBSTServiceClassUpdateWrongData() {
		// Sets up invalid data
		String badName = "FarTooLongNameAnthony";
		String badDescription = "This Description Is Not Valid Because It Is Too Long Surpassing The Fifty Character Limit";
		
		// Adds with valid data to ensure it is valid
		TaskBST.addTask(new Task(id,name,description));
		
		// Tests each update with bad data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.updateTaskName(id, badName);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.updateTaskDescription(id, badDescription);
		});
		
		// Tests each update with null data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.updateTaskName(id, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskBST.updateTaskDescription(id, null);
		});
	}
	
	// Tests the read functions sends a properly sorted ArrayList back
	@Test
	void testTaskBSTServiceClassRead() {
		String id1 = "123456789";
		String id2 = "456789123";
		String id3 = "789123456";
		String id4 = "123789456";
		String id5 = "456123789";
		String name1 = "Kilo Ren";
		String name2 = "Jane Plone";
		String name3 = "Jacob Usuper";
		String name4 = "Ben Mills";
		String name5 = "Peter Griffin";
		// Adds the Tasks in a random order that is not sorted prior to read
		TaskBST.addTask(new Task(id2, name3, description));
		TaskBST.addTask(new Task(id3, name2, description));
		TaskBST.addTask(new Task(id1, name5, description));
		TaskBST.addTask(new Task(id5, name1, description));
		TaskBST.addTask(new Task(id4, name4, description));
		ArrayList<Task> sortedTasks = TaskBST.readTasks();
		// Goes through ArrayList and check it is sorted by name in ascending order
		for(int i = 1; i < sortedTasks.size(); i++) {
			assertTrue(sortedTasks.get(i-1).getName().compareTo(sortedTasks.get(i).getName()) < 0);
		}
	}

}
