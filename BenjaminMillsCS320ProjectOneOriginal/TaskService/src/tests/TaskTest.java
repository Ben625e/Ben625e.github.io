package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tasks.Task;

class TaskTest {
	
	// This test ensures that constructor properly stores the variables
	@Test
	void testTaskClass() {
		Task Task = new Task("123456789", "Running A Test", "This Task Pertains to Test Running");
		assertTrue(Task.getTaskID().equals("123456789"));
		assertTrue(Task.getName().equals("Running A Test"));
		assertTrue(Task.getDescription().equals("This Task Pertains to Test Running"));
	}
	
	// Test for a taskID over 10 characters
	@Test
	void testTaskClassIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789123", "Running A Test", "This Task Pertains to Test Running");
		});
	}
	
	// Test for a name over 20 characters
	@Test
	void testTaskClassNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "Running A Test On A Name That Is Too Long", "This Task Pertains to Test Running");
		});
	}
	
	// Test for a description over 50 characters
	@Test
	void testTaskClassDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "Running A Test", "This Description Should Be Over The Fifty Character Limit Set In The Requirements For This Class");
		});
	}
	
	// Test for the name setter with a string that is too long
	@Test
	void testSetTaskClassNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task Task = new Task("123456789", "Running A Test", "This Task Pertains to Test Running");
			Task.setName("Running A Test On A Name That Is Too Long");
		});
	}
	
	// Test for the description setter with a string that is too long
	@Test
	void testSetTaskClassDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task Task = new Task("123456789", "Running A Test", "This Task Pertains to Test Running");
			Task.setName("This Description Should Be Over The Fifty Character Limit Set In The Requirements For This Class");
		});
	}
	
	// Test for the taskID sending null value
	@Test
	void testTaskClassIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Running A Test", "This Task Pertains to Test Running");
		});
	}
	
	// Test for the name sending null value
	@Test
	void testTaskClassNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", null, "This Task Pertains to Test Running");
		});
	}
	
	// Test for the description sending null value
	@Test
	void testTaskClassDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "Running A Test", null);
		});
	}
	
	// Test for the name setter sending null value
	@Test
	void testSetTaskClassNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task Task = new Task("123456789", "Running A Test", "This Task Pertains to Test Running");
			Task.setName(null);
		});
	}
	
	// Test for the description setter sending null value
	@Test
	void testSetTaskClassDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task Task = new Task("123456789", "Running A Test", "This Task Pertains to Test Running");
			Task.setName(null);
		});
	}
}
