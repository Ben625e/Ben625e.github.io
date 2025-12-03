package appointment;

import java.util.ArrayList;

// ENHACEMENT 2 DONE 11/18/25
// This is the BST class for Appointment
// It replaces the ArrayList structure from AppointmentService to a BST structure
// All functions from AppointmentService which include adding, deleting, and reading
// Appointments stored are fully implemented in this class

public class AppointmentBSTService {

	// Private Variable Declaration
	
	// The root node for the BST, the top of the tree and the starting point for searching
	private AppointmentNode root;
	
	// Default Constructor
	public AppointmentBSTService() {
		root = null;
	}
	
	// This function adds an Appointment into the BST
	public void addAppointment(Appointment newAppointment) {
		// If the root node is empty, the newAppointment becomes root node
		if(root == null) {
			root = new AppointmentNode(newAppointment);
		}
		// Else, call recursive insertAppointment function sending root and newAppointment
		else {
			insertAppointment(root, newAppointment);
		}
	}
	
	// This function is an extension of addAppointment
	// It looks at the current AppointmentNode and the unique ID from the newAppointment to
	// determine which way to move down the BST, once the correct location is found, the
	// newAppointment is inserted
	private void insertAppointment(AppointmentNode curNode, Appointment newAppointment) {
		// If the ID in the current Node is larger than newAppointment
		if(curNode.storedAppointment.getID().compareTo(newAppointment.getID()) > 0) {
			// If left Node is empty, newAppointment becomes the new left Node
			if(curNode.left == null) {
				curNode.left = new AppointmentNode(newAppointment);
			}
			// Else, recurse down the left node
			else {
				insertAppointment(curNode.left, newAppointment);
			}
		}
		// Else If the ID in current Node is smaller than newAppointment
		else if(curNode.storedAppointment.getID().compareTo(newAppointment.getID()) < 0) {
			// If the right Node is empty, newAppointment becomes the new right node
			if(curNode.right == null) {
				curNode.right = new AppointmentNode(newAppointment);
			}
			// Else, recurse down the right node
			else {
				insertAppointment(curNode.right, newAppointment);
			}
		}
		// Else, the ID is in use
		else {
			throw new IllegalArgumentException("In Use appointmentID");
		}
	}
	
	// This function deletes a Appointment from the BST, key is the ID that wants to be deleted
	public void deleteAppointment(String key) {
		// If the root node is empty, throw an exception
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// Else, call recursive removeAppointment function sending root and key
		else {
			root = removeAppointment(root, key);
		}
	}
	
	// This function is an extension of deleteAppointment
	// It looks at the current AppointmentNode and the unique ID from the key to
	// determine which way to move down the BST, once the correct location is found, the
	// matching Appointment is deleted and a successor Node is returned
	private AppointmentNode removeAppointment(AppointmentNode curNode, String key) {
		// If the ID in the current Node is larger than the key
		if(curNode.storedAppointment.getID().compareTo(key) > 0) {
			// If left Node is empty, throw an exception
			if(curNode.left == null) {
				throw new IllegalArgumentException("No Such appointmentID For Deletion");
			}
			// Else, recurse down the left node
			else {
				curNode.left = removeAppointment(curNode.left, key);
			}
		}
		// Else If the ID in current Node is smaller than the key
		else if(curNode.storedAppointment.getID().compareTo(key) < 0) {
			// If the right Node is empty, throw an exception
			if(curNode.right == null) {
				throw new IllegalArgumentException("No Such appointmentID For Deletion");
			}
			// Else, recurse down the right node
			else {
				curNode.right = removeAppointment(curNode.right, key);
			}
		}
		// Else, the ID is found
		else {
			// If the Node has 0 or 1 child Nodes
			if(curNode.left == null) return curNode.right;
			if(curNode.right == null) return curNode.left;
			
			// Else the Node has 2 children
			AppointmentNode succNode = getSuccessor(curNode);
			curNode.storedAppointment = succNode.storedAppointment;
			curNode.right = removeAppointment(curNode.right, succNode.storedAppointment.getID());
		}
		return curNode;
	}
	
	// Gets the successor Node by following the smallest right path
	private AppointmentNode getSuccessor(AppointmentNode curNode) {
		curNode = curNode.right;
		while(curNode != null && curNode.left != null) {
			curNode = curNode.left;
		}
		return curNode;
	}
	
	// This function returns an ArrayList of Appointments sorted by Date
	public ArrayList<Appointment> readAppointments() {
		ArrayList<Appointment> sortedAppointments = new ArrayList<>();
		// If the BST is empty
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// else call recursive inOrder function
		else {
			inOrder(sortedAppointments, root);
		}
		// Go through entire list, insert current appointment into sorted list in the correct order
		for(int i = 1; i < sortedAppointments.size(); i++) {
			Appointment holderApp = sortedAppointments.get(i);
			int j = i;
			while(j > 0 && sortedAppointments.get(j-1).getDate().after(holderApp.getDate())) {
				sortedAppointments.set(j, sortedAppointments.get(j-1));
				j--;
			}
			sortedAppointments.set(j, holderApp);
		}
		return sortedAppointments;
	}
	
	// This function is an extension of readAppointments
	// This function fills the Appointments ArrayList starting with curNode going by the
	// left most Node first
	private void inOrder(ArrayList<Appointment> Appointments, AppointmentNode curNode) {
		// If curNode is not empty, recurse to left, insert Appointment, then recurse to right
		if(curNode != null) {
			inOrder(Appointments, curNode.left);
			Appointments.add(curNode.storedAppointment);
			inOrder(Appointments, curNode.right);
		}
	}
	
	// This function finds an Appointment using the unique ID labeled key
	public Appointment findAppointment(String key) {
		// If the root node is empty, throw exception
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// Else, call recursive searchAppointment function sending root and the key
		else {
			Appointment foundAppointment = searchAppointment(root, key);
			if(foundAppointment == null) {
				throw new IllegalArgumentException("Appointment Not Found");
			}
			return foundAppointment;
		}
	}
		
	// This function is an extension of findAppointment
	// It looks at the current AppointmentNode and the unique ID from the key to
	// determine which way to move down the BST, once the correct Appointment is found,
	// return the Appointment
	private Appointment searchAppointment(AppointmentNode curNode, String key) {
		// If the curNode is null, return null
		if(curNode == null) {
			return null;
		}
		// Else If the ID in current Node matches, return curNode Appointment
		else if(curNode.storedAppointment.getID().compareTo(key) == 0) {
			return curNode.storedAppointment;
		}
		// Else if the ID in the current Node is larger than the key, go down the left side
		else if(curNode.storedAppointment.getID().compareTo(key) > 0) {
			return searchAppointment(curNode.left, key);
		}
		// Else, go down the right side
		else {
			return searchAppointment(curNode.right, key);
		}
	}
}
