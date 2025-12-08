package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tasks.TaskService;

class TaskServiceTest {
	
	// Test creating and adding a Task to TaskService
	@Test
	void testTaskServiceClass() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		assertTrue(TaskService.Tasks.get(0).getTaskID().equals("123456789"));
		assertTrue(TaskService.Tasks.get(0).getName().equals("Running A Test"));
		assertTrue(TaskService.Tasks.get(0).getDescription().equals("This Task Pertains to Test Running"));
	}
	
	// Test creating TaskService with bad data
	@Test
	void testTaskServiceClassWrongData() {
		TaskService TaskService = new TaskService();
		// Too Long Data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask("12345678912", "Running A Test", "This Task Pertains to Test Running");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask("123456789", "This Task Has A Name Longer Than Allowed", "This Task Pertains to Test Running");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask("123456789", "Running A Test", "The Description Has To Be Over fifty Characters"
					+ " Which Is So Long I had To Move To The Next Line To Ensure It Is Stil Clean");
		});
		// Null Data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask(null, "Running A Test", "This Task Pertains to Test Running");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask("123456789", null, "This Task Pertains to Test Running");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask("123456789", "Running A Test", null);
		});
	}
	
	// Tries to add a Task with the same ID
	@Test
	void testTaskServiceClassSameID() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask("123456789", "Same ID Test", "Tries With Same ID");
		});
	}
	
	// Test for creating the same task with a different ID
	@Test
	void testTaskServiceClassDifferentID() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		TaskService.addTask("987654321", "Running A Test", "This Task Pertains to Test Running");
	}
	
	// Tests deletion of a Task from TaskService
	@Test
	void testTaskServiceClassDelete() {
		// taskID that will be deleted and checked for
		String taskIdToDelete = "987654321";
		TaskService TaskService = new TaskService();
		// Add several Task objects
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		TaskService.addTask(taskIdToDelete, "Deleting A Task", "This Task Pertains to Deleting");
		TaskService.addTask("456789123", "I am a Task", "This Task should still exist");
		TaskService.addTask("789123456", "I am a Task Too", "Hopefully I Still Exist");
		TaskService.deleteTask(taskIdToDelete);
		// For all of Tasks, check if deleted Task still exists
		for(int i = 0; i < TaskService.Tasks.size(); i++) {
			assertFalse(TaskService.Tasks.get(i).getTaskID().equals(taskIdToDelete));
		}
	}
	
	// Tests deletion of a non-existent Task
	@Test
	void testTaskServiceClassDeleteNoID() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.deleteTask("987654321");
		});
	}
	
	// Tests the updateTaskName method changes name
	@Test
	void testTaskServiceClassUpdateName() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		TaskService.updateTaskName("123456789", "Changing Name");
		assertTrue(TaskService.Tasks.get(0).getName().equals("Changing Name"));
	}
	
	// Tests the updateTaskDescription method changes name
	@Test
	void testTaskServiceClassUpdateDescription() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		TaskService.updateTaskDescription("123456789", "This Task Description Is Changed");
		assertTrue(TaskService.Tasks.get(0).getDescription().equals("This Task Description Is Changed"));
	}
	
	// Tests the updateTaskName method with a wrong taskID
	@Test
	void testTaskServiceClassUpdateNameWrongID() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.updateTaskName("987654321", "Changing Name");
		});
	}
	
	// Tests the updateTaskDescription method with a wrong taskID
	@Test
	void testTaskServiceClassUpdateDescriptionWrongID() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.updateTaskDescription("987654321", "This Is The Wrong TaskID");
		});
	}
	
	// Tests the update methods with wrong data
	@Test
	void testTaskServiceClassUpdateWrongData() {
		TaskService TaskService = new TaskService();
		TaskService.addTask("123456789", "Running A Test", "This Task Pertains to Test Running");
		// Too Long Data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.updateTaskName("123456789", "This Is Over The Twenty Character Limit");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.updateTaskDescription("123456789", "Fifty Characters Is Short For A Description"
					+ " But It Certainly Feels Long When Writing It In Code");
		});
		// Null Data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.updateTaskName("123456789", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.updateTaskDescription("123456789", null);
		});
	}

}
