package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.ContactService;

// Tester class for ContactService class
class ContactServiceTest {
	
	// Test case for if the ContactService does properly store a Contact with the addContact method
	@Test
	void testContactServiceClass() {
		// Create a new ContactService
		ContactService ContactService = new ContactService();
		// Call addContact with valid data
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		// Check Contacts if the data was stored properly
		assertTrue(ContactService.Contacts.get(0).getContactID().equals("WorkFriend"));
		assertTrue(ContactService.Contacts.get(0).getFirstName().equals("John"));
		assertTrue(ContactService.Contacts.get(0).getLastName().equals("Doe"));
		assertTrue(ContactService.Contacts.get(0).getNumber().equals("1235552347"));
		assertTrue(ContactService.Contacts.get(0).getAddress().equals("123 Test Street"));
	}
	
	// Test case for if addContact throws exception for in use contactID
	@Test
	void testContactServiceClassAddInUseID() {
		// Create a new ContactService
		ContactService ContactService = new ContactService();
		// Call addContact with valid data
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		// Call addContact with invalid data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "Jane", "Dee", "3215552347", "321 Test Street");
		});
	}
	
	// Test case for if addContact throws exception if bad data is sent
	@Test
	void testContactServiceClassAddBadData() {
		// Create a new ContactService
		ContactService ContactService = new ContactService();
		// Call addContact with wrong length data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("OverTenLetters", "Jane", "Dee", "3215552347", "321 Test Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "OverTenLetters", "Dee", "3215552347", "321 Test Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "Jane", "OverTenLetters", "3215552347", "321 Test Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "Jane", "Dee", "12355512345", "321 Test Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "Jane", "Dee", "3215552347", "This is over the thirty letter limit for addresses");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "Jane", "Dee", "123555321", "321 Test Street");
		});
		// Call addContact with null data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact(null, "Jane", "Dee", "3215552347", "321 Test Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", null, "Dee", "3215552347", "321 Test Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "Jane", null, "3215552347", "321 Test Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "Jane", "Dee", null, "321 Test Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("WorkFriend", "Jane", "Dee", "3215552347", null);
		});
	}
	
	// Test case for the deleteContact method
	@Test
	void testContactServiceClassDelete() {
		// The id that will be deleted and checked
		String idToDelete = "WorkFriend";
		// Create a new ContactService
		ContactService ContactService = new ContactService();
		// Add several Contact objects, one with the idToDelete
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		ContactService.addContact("Seperate", "Jane", "Dee", "3215552347", "321 Test Street");
		ContactService.addContact("Different", "Janent", "Deeth", "3215552347", "456 Test Street");
		ContactService.addContact("New", "Johnet", "Doeth", "3215552347", "654 Test Street");
		ContactService.deleteContact(idToDelete);
		// For all Contact in Contacts
		for(int i = 0; i < ContactService.Contacts.size(); i++) {
			// Check if deleted ID is inside of Contacts
			// Only checks contactID as other variable can match other Contact variables
			assertFalse(ContactService.Contacts.get(i).getContactID().equals(idToDelete));
		}
	}
	
	// Test case for the deleteContact method with wrong contactID
	@Test
	void testContactServiceClassDeleteMissing() {
		// Create a new ContactService
		ContactService ContactService = new ContactService();
		// Add several Contact objects
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		ContactService.addContact("Seperate", "Jane", "Dee", "3215552347", "321 Test Street");
		ContactService.addContact("Different", "Janent", "Deeth", "3215552347", "456 Test Street");
		ContactService.addContact("New", "Johnet", "Doeth", "3215552347", "654 Test Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.deleteContact("WrongID");
		});
	}
	
	// The following test cases check if the update methods properly update the chosen variable
	
	@Test
	void testContactServiceClassUpdateFirstName() {
		ContactService ContactService = new ContactService();
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		ContactService.updateContactFirstName("WorkFriend", "Jeff");
		assertTrue(ContactService.Contacts.get(0).getFirstName().equals("Jeff"));
	}
	
	@Test
	void testContactServiceClassUpdateLastName() {
		ContactService ContactService = new ContactService();
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		ContactService.updateContactLastName("WorkFriend", "Soe");
		assertTrue(ContactService.Contacts.get(0).getLastName().equals("Soe"));
	}
	
	@Test
	void testContactServiceClassUpdateNumber() {
		ContactService ContactService = new ContactService();
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		ContactService.updateContactNumber("WorkFriend", "3215557432");
		assertTrue(ContactService.Contacts.get(0).getNumber().equals("3215557432"));
	}
	
	@Test
	void testContactServiceClassUpdateAddress() {
		ContactService ContactService = new ContactService();
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		ContactService.updateContactAddress("WorkFriend", "321 Test Drive");
		assertTrue(ContactService.Contacts.get(0).getAddress().equals("321 Test Drive"));
	}
	
	// Tests the update methods with bad data
	@Test
	void testContactServiceClassUpdateBadData() {
		ContactService ContactService = new ContactService();
		ContactService.addContact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		ContactService.updateContactAddress("WorkFriend", "321 Test Drive");
		// Call update methods with wrong length data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactFirstName("WorkFriend", "OverTenLetters");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactLastName("WorkFriend", "OverTenLetters");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactNumber("WorkFriend", "12355512345");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactNumber("WorkFriend", "123555321");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactAddress("WorkFriend", "This is over the thirty letter limit for addresses");
		});
		// Call update methods with null data
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactFirstName("WorkFriend", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactLastName("WorkFriend", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactNumber("WorkFriend", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContactAddress("WorkFriend", null);
		});
	}

}
