package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactBSTService;

// ENHANCEMENT 2 DONE 11/21/25
// Test class for the newly implemented BST
// Implements all the tests from the previous AppointmentServiceTest
// These include creating a BST, adding to the BST, deleting from the BST,
// updating from the BST, reading from the BST, and includes the newly 
// added single search from the BST

class ContactBSTServiceTest {

	// Test Variables that are used frequently
	String id = "123456789";
	String first = "John";
	String last = "Doe";
	String num = "5555555555";
	String addr = "123 Test Drive";
	ContactBSTService ContactBST = new ContactBSTService();
	
	// Test for creating an instance of the BST, adding a Contact, and finding the Contact
	@Test
	void testContactBSTServiceClass() {
		ContactBST.addContact(new Contact(id,first,last,num,addr));
		Contact testContact = ContactBST.findContact(id);
		assertTrue(testContact.getContactID().equals(id));
		assertTrue(testContact.getFirstName().equals(first));
		assertTrue(testContact.getLastName().equals(last));
		assertTrue(testContact.getNumber().equals(num));
		assertTrue(testContact.getAddress().equals(addr));
	}
	
	// Attempts to add a Contact with an ID in use, exception thrown is expected
	@Test
	void testContactBSTServiceClassSameID() {
		ContactBST.addContact(new Contact(id,first,last,num,addr));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,"Jane","Dee","1235556789","321 Testing Ave"));
		});
	}
	
	// Attempts to add a Contact with invalid data from the parameters set by the company
	// defined in the Contact class
	@Test
	void testContactBSTServiceClassWrongData() {
		// Sets up invalid data
		String badID = "12345678912";
		String badFirst = "TooLongNameTimothy";
		String badLast = "TooLongNameAfton";
		String badNumShort = "123555123";
		String badNumLong = "123555512345";
		String badAddr = "123456789 Too Long Of An Address Drive Avenue";
		// Adds with valid data to ensure it is valid
		ContactBST.addContact(new Contact(id,first,last,num,addr));
		
		// Tests for exception being thrown from bad data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(badID,first,last,num,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,badFirst,last,num,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,first,badLast,num,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,first,last,badNumShort,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,first,last,badNumLong,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,first,last,num,badAddr));
		});
		
		// Tests for exception being thrown from null data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(null,first,last,num,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,null,last,num,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,first,null,num,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,first,last,null,addr));
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.addContact(new Contact(id,first,last,num,null));
		});
	}
	
	// Tests for adding multiple Contacts with different ID
	@Test
	void testContactBSTServiceClassDifferentID() {
		String id1 = "123456789";
		String id2 = "456789123";
		String id3 = "789123456";
		String id4 = "123789456";
		String id5 = "456123789";
		ContactBST.addContact(new Contact(id1,first,last,num,addr));
		ContactBST.addContact(new Contact(id2,first,last,num,addr));
		ContactBST.addContact(new Contact(id3,first,last,num,addr));
		ContactBST.addContact(new Contact(id4,first,last,num,addr));
		ContactBST.addContact(new Contact(id5,first,last,num,addr));
	}
	
	// Tests the deletion function
	@Test
	void testContactBSTServiceClassDelete() {
		String id1 = "123456789";
		String id2 = "987654321";
		ContactBST.addContact(new Contact(id1,first,last,num,addr));
		ContactBST.findContact(id1);
		// Adds a Contact as exception is thrown searching an empty BST
		ContactBST.addContact(new Contact(id2,first,last,num,addr));
		// Checks if the Contact can be found
		ContactBST.findContact(id1);
		ContactBST.deleteContact(id1);
		// If deletion occurred, an exception should occur
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.findContact(id1);
		});
		// Checks that exception wasn't due to empty BST
		ContactBST.findContact(id2);
	}
	
	// Tests exception from deleting empty BST and non-existant Contact
	@Test
	void testContactBSTServiceClassDeleteNotFound() {
		// BST is Empty, any ID should throw an exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.deleteContact(id);
		});
		ContactBST.addContact(new Contact(id,first,last,num,addr));
		// Attempts to delete random ID not in Use
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactBST.deleteContact("987654321");
		});
	}
	
	// Tests the Update function for first name
	@Test
	void testContactBSTServiceClassUpdateFirst() {
		ContactBST.addContact(new Contact(id,first,last,num,addr));
		ContactBST.updateContactFirstName(id, "Jane");
		assertTrue(ContactBST.findContact(id).getFirstName().equals("Jane"));
	}
	
	// Tests the Update function for last name
	@Test
	void testContactBSTServiceClassUpdateLast() {
		ContactBST.addContact(new Contact(id,first,last,num,addr));
		ContactBST.updateContactLastName(id, "Dee");
		assertTrue(ContactBST.findContact(id).getLastName().equals("Dee"));
	}
	
	// Tests the Update function for number
	@Test
	void testContactBSTServiceClassUpdateNumber() {
		ContactBST.addContact(new Contact(id,first,last,num,addr));
		ContactBST.updateContactNumber(id, "1235556789");
		assertTrue(ContactBST.findContact(id).getNumber().equals("1235556789"));
	}
	
	// Tests the Update function for address
	@Test
	void testContactBSTServiceClassUpdateAddress() {
		ContactBST.addContact(new Contact(id,first,last,num,addr));
		ContactBST.updateContactAddress(id, "321 Testing Ave");
		assertTrue(ContactBST.findContact(id).getAddress().equals("321 Testing Ave"));
	}
	
	// Tests that the read function sends a sorted ArrayList back
	@Test
	void testContactBSTServiceClassRead() {
		String id1 = "123456789";
		String id2 = "456789123";
		String id3 = "789123456";
		String id4 = "123789456";
		String id5 = "456123789";
		String first1 = "Kilo";
		String first2 = "Jane";
		String first3 = "Jacob";
		String first4 = "Ben";
		String first5 = "Peter";
		// Adds the Contacts in a random order that is not sorted prior to read
		ContactBST.addContact(new Contact(id2,first3,last,num,addr));
		ContactBST.addContact(new Contact(id3,first2,last,num,addr));
		ContactBST.addContact(new Contact(id1,first5,last,num,addr));
		ContactBST.addContact(new Contact(id5,first1,last,num,addr));
		ContactBST.addContact(new Contact(id4,first4,last,num,addr));
		ArrayList<Contact> sortedContacts = ContactBST.readContacts();
		// Goes through ArrayList and checks it is sorted by first name in ascending order
		for(int i = 1; i < sortedContacts.size(); i++) {
			assertTrue(sortedContacts.get(i-1).getFirstName().compareTo(sortedContacts.get(i).getFirstName()) < 0);
		}
	}

}
