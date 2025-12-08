package contact;

import java.util.ArrayList;

// ContactService which stores Contact objects and has the following functionality
// It can add, delete, and update Contact objects
// It can only update a Contact's firstName, lastName, number, and address
public class ContactService {
	
	// Stores Contact objects in an ArrayList, also known as a vector in other languages
	public ArrayList<Contact> Contacts;
	
	// Default Constructor
	public ContactService() {
		Contacts = new ArrayList<Contact>();
	}

	// Adds a Contact to the ArrayList Contacts
	public void addContact(String id, String first, String last, String num, String addr) {
		// If Contacts isn't empty
		if(Contacts.size() != 0) {
			// Checks all Contact in Contacts for a matching ID
			for(int i = 0; i < Contacts.size(); i++) {
				// If a matching ID is found, throw an exception as it isn't unique
				if(Contacts.get(i).getContactID().equals(id)) {
					throw new IllegalArgumentException("In Use contactID");
				}
			}

		}
		// Adds Contact to Contacts
		Contact Contact = new Contact(id, first, last, num, addr);
		Contacts.add(Contact);
	}
	
	// Finds and Deletes a Contact from Contacts
	public void deleteContact(String id) {
		// For all of Contacts
		for(int i = 0; i < Contacts.size(); i++) {
			// if current Contact matches id
			if(Contacts.get(i).getContactID().equals(id)) {
				// Remove Contact and exit method
				Contacts.remove(i);
				return;
			}
		}
		// If all Contacts checked and nothing found, throws an exception
		throw new IllegalArgumentException("No Such contactID For Deletion");
	}
	
	// The following methods are for updating variables from the given id
	// They check all of Contacts for a matching id and then sets the appropriate variable then exits
	// If the id isnt't found, then an exception is thrown
	// Data isn't checked here as it will be checked in their respective setter methods
	
	public void updateContactFirstName(String id, String first) {
		for(int i = 0; i < Contacts.size(); i++) {
			if(Contacts.get(i).getContactID().equals(id)) {
				Contacts.get(i).setFirstName(first);;
				return;
			}
		}
		throw new IllegalArgumentException("No Such contactID For First Name");
	}
	
	public void updateContactLastName(String id, String last) {
		for(int i = 0; i < Contacts.size(); i++) {
			if(Contacts.get(i).getContactID().equals(id)) {
				Contacts.get(i).setLastName(last);;
				return;
			}
		}
		throw new IllegalArgumentException("No Such contactID For Last Name");
	}
	
	public void updateContactNumber(String id, String num) {
		for(int i = 0; i < Contacts.size(); i++) {
			if(Contacts.get(i).getContactID().equals(id)) {
				Contacts.get(i).setNumber(num);;
				return;
			}
		}
		throw new IllegalArgumentException("No Such contactID For Number");
	}
	
	public void updateContactAddress(String id, String addr) {
		for(int i = 0; i < Contacts.size(); i++) {
			if(Contacts.get(i).getContactID().equals(id)) {
				Contacts.get(i).setAddress(addr);;
				return;
			}
		}
		throw new IllegalArgumentException("No Such contactID For Address");
	}

}
