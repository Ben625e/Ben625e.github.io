package contact;

//ENHACEMENT 2 DONE 11/17/25
//This is the node class used for the BST, it holds a reference to a left and right node
//and holds the Contact stored

public class ContactNode {

	// Variable Declaration
	public Contact storedContact;
	public ContactNode left;
	public ContactNode right;
	
	// Default Constructor
	public ContactNode() {
		left = null;
		right = null;
	}
	
	// Loaded Constructor
	public ContactNode(Contact newContact) {
		left = null;
		right = null;
		storedContact = newContact;
	}
}
