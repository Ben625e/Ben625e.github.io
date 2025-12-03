package appointment;

// ENHACEMENT 2 DONE 11/17/25
// This is the node class used for the BST, it holds a reference to a left and right node
// and holds the Appointment stored

public class AppointmentNode {
	
	// Variable Declaration
	public Appointment storedAppointment;
	public AppointmentNode left;
	public AppointmentNode right;
	
	// Default Constructor
	public AppointmentNode() {
		left = null;
		right = null;
	}
	
	// Loaded Constructor
	public AppointmentNode(Appointment newAppointment) {
		left = null;
		right = null;
		storedAppointment = newAppointment;
	}
}
