package tasks;

//ENHACEMENT 2 DONE 11/17/25
//This is the node class used for the BST, it holds a reference to a left and right node
//and holds the Task stored

public class TaskNode {
	
	// Variable Declaration
	public Task storedTask;
	public TaskNode left;
	public TaskNode right;
	
	// Default Constructor
	public TaskNode() {
		left = null;
		right = null;
	}
	
	// Loaded Constructor
	public TaskNode(Task newTask) {
		left = null;
		right = null;
		storedTask = newTask;
	}
}
