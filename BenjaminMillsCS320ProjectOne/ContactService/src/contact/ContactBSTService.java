package contact;

import java.util.ArrayList;

// ENHANCEMENT 2 DONE 11/20/25
// This is the BST class for Contact
// It replaces the ArrayList structure from ContactService to a BST structure
// All functions from ContactService which include adding, deleting, updating,
// and reading Contacts stored are fully implemented in this class

public class ContactBSTService {

	// Private Variable Declaration
	
	// The root node for the BST, the top of the tree and the starting point for searching
	private ContactNode root;
	
	// Default Constructor
	public ContactBSTService() {
		root = null;
	}
	
	// This function adds a Contact into the BST
	public void addContact(Contact newContact) {
		// If root node is empty, the newContact becomes root node
		if(root == null) {
			root = new ContactNode(newContact);
		}
		// Else, call recursive insertContact function sending root and newContact
		else {
			insertContact(root, newContact);
		}
	}
	
	// This function is an extension of addContact
	// It looks at the current ContactNode and the unique ID from the newContact to
	// determine which way to move down the BST, once the correct location is found, the
	// newContact is inserted
	private void insertContact(ContactNode curNode, Contact newContact) {
		// If the ID in the current Node is larger than newContact
		if(curNode.storedContact.getContactID().compareTo(newContact.getContactID()) > 0) {
			// If left Node is empty, newContact becomes the new left Node
			if(curNode.left == null) {
				curNode.left = new ContactNode(newContact);
			}
			// Else, recurse down the left node
			else {
				insertContact(curNode.left, newContact);
			}
		}
		// Else If the ID in the current Node is smaller than newContact
		else if(curNode.storedContact.getContactID().compareTo(newContact.getContactID()) < 0) {
			// If the right Node is empty, newContact becomes the new right node
			if(curNode.right == null) {
				curNode.right = new ContactNode(newContact);
			}
			// Else, recurse down the right Node
			else {
				insertContact(curNode.right, newContact);
			}
		}
		// Else, the ID is in use
		else {
			throw new IllegalArgumentException("In Use ContactID");
		}
	}
	
	// This function deletes a Contact from the BST, key is the ID that wants to be deleted
	public void deleteContact(String key) {
		// If the root node is empty, throw an exception
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// Else, call recursive removeContact function sending root and key
		else {
			root = removeContact(root, key);
		}
	}
	
	// This function is an extension of deleteContact
	// It looks at the current ContactNode and the unique ID from the key to
	// determine which way to move down the BST, once the correct location is found, the
	// matching Contact is deleted and a successor Node is returned
	private ContactNode removeContact(ContactNode curNode, String key) {
		// If the ID in the current Node is larger than newContact
		if(curNode.storedContact.getContactID().compareTo(key) > 0) {
			// If left Node is empty, throw exception
			if(curNode.left == null) {
				throw new IllegalArgumentException("No Such ContactID for Deletion");
			}
			// Else, recurse down the left node
			else {
				curNode.left = removeContact(curNode.left, key);
			}
		}
		// Else If the ID in the current Node is smaller than newContact
		else if(curNode.storedContact.getContactID().compareTo(key) < 0) {
			// If the right Node is empty, throw an exception
			if(curNode.right == null) {
				throw new IllegalArgumentException("No Such ContactID for Deletion");
			}
			// Else, recurse down the right node
			else {
				curNode.right = removeContact(curNode.right, key);
			}
		}
		// Else, the ID is found
		else {
			// If the Node has 0 or 1 child Nodes
			if(curNode.left == null) return curNode.right;
			if(curNode.right == null) return curNode.left;
			
			// Else the Node has 2 children
			ContactNode succNode = getSuccessor(curNode);
			curNode.storedContact = succNode.storedContact;
			curNode.right = removeContact(curNode.right, succNode.storedContact.getContactID());
		}
		return curNode;
	}
	
	// Gets the successor Node by following the smallest right path
	private ContactNode getSuccessor(ContactNode curNode) {
		curNode = curNode.right;
		while(curNode != null && curNode.left != null) {
			curNode = curNode.left;
		}
		return curNode;
	}
	
	// This function finds a Contact using the unique ID defined as key
	public Contact findContact(String key) {
		// If the root node is empty, throw an exception
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// Else, call recursive searchContact function sending root and the key
		else {
			Contact foundContact = searchContact(root, key);
			if(foundContact == null) {
				throw new IllegalArgumentException("Contact Not Found");
			}
			return foundContact;
		}
	}
	
	// This function is an extension of findContact
	// It looks at the current ContactNode and the unique ID from key to
	// determine which way to move down the BST, once the correct Contact is found,
	// return the Contact
	private Contact searchContact(ContactNode curNode, String key) {
		// If the curNode is null, return null
		if(curNode == null) {
			return null;
		}
		// Else If the ID in current Node matches, return curNode stored Contact
		else if(curNode.storedContact.getContactID().compareTo(key) == 0) {
			return curNode.storedContact;
		}
		// Else if the ID in the current Node is larger than the key, go down the left node
		else if(curNode.storedContact.getContactID().compareTo(key) > 0) {
			return searchContact(curNode.left, key);
		}
		// Else go down the right node
		else {
			return searchContact(curNode.right, key); 
		}
	}
	
	// This function finds the Contact from the unique ID defined by key and updates the
	// first name
	public void updateContactFirstName(String key, String first) {
		findContact(key).setFirstName(first);
	}
	
	// This function finds the Contact from the unique ID defined by key and updates the
	// last name
	public void updateContactLastName(String key, String last) {
		findContact(key).setLastName(last);
	}
	
	// This function finds the Contact from the unique ID defined by key and updates the
	// Number
	public void updateContactNumber(String key, String num) {
		findContact(key).setNumber(num);
	}
	
	// This function finds the Contact from the unique ID defined by key and updates the
	// Address
	public void updateContactAddress(String key, String addr) {
		findContact(key).setAddress(addr);
	}
	
	// This function returns an ArrayList of Contacts sorted by first name
	public ArrayList<Contact> readContacts() {
		ArrayList<Contact> sortedContacts = new ArrayList<>();
		// If the BST is empty
		if(root == null) {
			throw new IllegalArgumentException("Empty BST");
		}
		// else call recursive inOrder function
		else {
			inOrder(sortedContacts, root);
		}
		// Go through entire list, insert current Contact into sorted list in the correct order
		for(int i = 1; i < sortedContacts.size(); i++) {
			Contact holderCon = sortedContacts.get(i);
			int j = i;
			while(j > 0 && sortedContacts.get(j-1).getFirstName().compareTo(holderCon.getFirstName()) > 0) {
				sortedContacts.set(j, sortedContacts.get(j-1));
				j--;
			}
			sortedContacts.set(j, holderCon);
		}
		return sortedContacts;
	}
	
	// This function is an extension of readContacts
	// This functions fills the Contacts ArrayList starting with curNode going by the
	// left mode Node first
	private void inOrder(ArrayList<Contact> Contacts, ContactNode curNode) {
		// If curNode is not empty, recurse to left, insert Contact, then recurse to right
		if(curNode != null) {
			inOrder(Contacts, curNode.left);
			Contacts.add(curNode.storedContact);
			inOrder(Contacts, curNode.right);
		}
	}
}
