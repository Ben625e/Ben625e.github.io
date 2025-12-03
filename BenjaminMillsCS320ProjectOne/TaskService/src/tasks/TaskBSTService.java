package tasks;

import java.util.ArrayList;

// ENHANCEMENT 2 DONE 11/20/25
// This is the BST class for Task
// It replaces the ArrayList structure from TaskService to a BST structure
// All functions from TaskService which include adding, deleting, updating
// and reading Tasks stored are fully implemented in this class

public class TaskBSTService {
	
	// Private Variable Declaration
	
	// The root node for the BST, the top of the tree and the starting point for searching
	private TaskNode root;
	
	// Default Constructor
	public TaskBSTService() {
		root = null;
	}
	
	// This function adds a Task into the BST
	public void addTask(Task newTask) {
		// If the root node is empty, the newTask becomes root node
		if(root == null) {
			root = new TaskNode(newTask);
		}
		// Else, call recursive insertTask function sending root and newTask
		else {
			insertTask(root, newTask);
		}
	}
	
	// This function is an extension of addTask
	// It looks at the current TaskNode and the unique ID from newTask to
	// determine which way to move down the BST, once the correct location
	// is found, the newTask is inserted
	private void insertTask(TaskNode curNode, Task newTask) {
		// If the ID in the current Node is larger than newTask
		if(curNode.storedTask.getTaskID().compareTo(newTask.getTaskID()) > 0) {
			// If left node is empty, newTask becomes the new left node
			if(curNode.left == null) {
				curNode.left = new TaskNode(newTask);
			}
			// Else, recurse down the left node
			else {
				insertTask(curNode.left, newTask);
			}
		}
		// Else If the ID in current node is smaller than newTask
		else if(curNode.storedTask.getTaskID().compareTo(newTask.getTaskID()) < 0) {
			// If the right node is empty, newTask becomes the new right node
			if(curNode.right == null) {
				curNode.right = new TaskNode(newTask);
			}
			// Else, recurse down the right node
			else {
				insertTask(curNode.right, newTask);
			}
		}
		// Else, the ID is in use
		else {
			throw new IllegalArgumentException("In Use TaskID");
		}
	}
	
	// This function deletes a Task from the BST, key is the ID thats wants to be deleted
	public void deleteTask(String key) {
		// If the root node is empty, throw an exception
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// Else, call recursive removeTask function sending root and key
		else {
			root = removeTask(root, key);
		}
	}
	
	// This function is an extension of deleteTask
	// It looks at the current TaskNode and the unique ID from the key to
	// determine which way to move down the BST, once the correct location is found,
	// the matching Task is deleted and a successor Node is returned
	private TaskNode removeTask(TaskNode curNode, String key) {
		// If the ID in the current Node is the larger than the key
		if(curNode.storedTask.getTaskID().compareTo(key) > 0) {
			// If left Node is empty, throw an exception
			if(curNode.left == null) {
				throw new IllegalArgumentException("No such TaskID for Deletion");
			}
			// Else, recurse down the left node
			else {
				curNode.left = removeTask(curNode.left, key);
			}
		}
		// Else If the ID in current node is smaller than the key
		else if(curNode.storedTask.getTaskID().compareTo(key) < 0) {
			// If the right node is empty, throw an exception
			if(curNode.right == null) {
				throw new IllegalArgumentException("No such TaskID for Deletion");
			}
			// Else, recurse down the right node
			else {
				curNode.right = removeTask(curNode.right, key);
			}
		}
		// Else, the ID is found
		else {
			//If the node has 0 or 1 child nodes
			if(curNode.left == null) return curNode.right;
			if(curNode.right == null) return curNode.left;
			
			// Else the node has 2 children
			TaskNode succNode = getSuccessor(curNode);
			curNode.storedTask = succNode.storedTask;
			curNode.right = removeTask(curNode.right, succNode.storedTask.getTaskID());
		}
		return curNode;
	}
	
	// Gets the successor Node by following the smallest right path
	private TaskNode getSuccessor(TaskNode curNode) {
		curNode = curNode.right;
		while(curNode != null && curNode.left != null) {
			curNode = curNode.left;
		}
		return curNode;
	}
	
	// This function finds a Task using the unique ID labeled key
	public Task findTask(String key) {
		// If the root node is empty, throw exception
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// Else, call recursive searchTask function sending root and the key
		else {
			Task foundTask = searchTask(root, key);
			if(foundTask == null) {
				throw new IllegalArgumentException("Task Not Found");
			}
			return foundTask;
		}
	}
	
	// This function is an extension of findTask
	// It looks at the current TaskNode and the unique from the key to
	// determine which way to move down the BST, once the correct Task is
	// found, return the Task
	private Task searchTask(TaskNode curNode, String key) {
		// If the curNode is null, return null
		if(curNode == null) {
			return null;
		}
		// Else If the ID in the current node matches, return curNode Task
		else if(curNode.storedTask.getTaskID().compareTo(key) == 0) {
			return curNode.storedTask;
		}
		// Else if the ID in the current node is larger than the key, go down the left side
		else if (curNode.storedTask.getTaskID().compareTo(key) > 0) {
			return searchTask(curNode.left, key);
		}
		// Else, go down the right side
		else {
			return searchTask(curNode.right, key);
		}
	}
	
	// This function finds the Task from the key and updates the name
	public void updateTaskName(String key, String name) {
		findTask(key).setName(name);
	}
	
	// This function finds the Task from the key and updates the description
	public void updateTaskDescription(String key, String description) {
		findTask(key).setDescription(description);
	}
	
	// This function returns an ArrayList of Tasks sorted by Name in ascending order
	public ArrayList<Task> readTasks() {
		ArrayList<Task> sortedTasks = new ArrayList<>();
		// If the BST is empty
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// Else call recursive inOrder function
		else {
			inOrder(sortedTasks, root);
		}
		// Go through entire list, insert current Task into sorted list in the correct order
		for(int i = 1; i < sortedTasks.size(); i++) {
			Task holderTask = sortedTasks.get(i);
			int j = i;
			while(j > 0 && sortedTasks.get(j-1).getName().compareTo(holderTask.getName()) > 0) {
				sortedTasks.set(j,  sortedTasks.get(j-1));
				j--;
			}
			sortedTasks.set(j,  holderTask);
		}
		return sortedTasks;
	}
	
	// This function is an extension of readTasks
	// This functions fills the Tasks ArrayList starting with curNode going by the
	// left most Node first
	private void inOrder(ArrayList<Task> Tasks, TaskNode curNode) {
		// If curNode is not empty, recurse to left, insert Task, then recurse to the right
		if(curNode != null) {
			inOrder(Tasks, curNode.left);
			Tasks.add(curNode.storedTask);
			inOrder(Tasks, curNode.right);
		}
	}
}
