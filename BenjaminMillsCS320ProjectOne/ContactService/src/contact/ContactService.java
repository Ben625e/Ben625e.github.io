package contact;

import java.util.ArrayList;

// ContactService which stores Contact objects in an ArrayList and has the following functionality
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
		// If Contacts isn't empty, If a matching ID is found, throw an exception as it isn't unique
		if(Contacts.size() != 0) {
			for(int i = 0; i < Contacts.size(); i++) {
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
		// For all of Contacts, find and Remove Contact then exit method
		for(int i = 0; i < Contacts.size(); i++) {
			if(Contacts.get(i).getContactID().equals(id)) {
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
	
	// ENHANCEMENT DONE 11/10/2025 BY BENJAMIN MILLS
	// UPDATE DONE 11/24/2025: Change sort type from ID to first name
	// This function returns an ArrayList of Contacts, sorted by contact ID
	public ArrayList<Contact> readContacts() {
		// Declare variable that will be returned
		ArrayList<Contact>  sortedContacts = new ArrayList<>(Contacts);
		
		// Try to return sorted list, catch error and print them out then throw exception
		try {
			// If the list is empty, return the empty list
			if(sortedContacts.size() == 0 ) {
				return sortedContacts;
			}
			// Go through entire list, insert current appointment into sorted list in the correct order, then return list
			for(int i = 1; i < Contacts.size(); i++) {
				Contact holderCon = sortedContacts.get(i);
				int j = i;
				while(j > 0 && sortedContacts.get(j-1).getFirstName().compareTo(holderCon.getFirstName()) > 0) {
					sortedContacts.set(j, sortedContacts.get(j-1));
					j--;
				}
				sortedContacts.set(j, holderCon);
			}
			return sortedContacts;
		} catch (Exception e){
			System.out.println("Exception Occured in readContacts");
			throw e;
		}
	}

}
