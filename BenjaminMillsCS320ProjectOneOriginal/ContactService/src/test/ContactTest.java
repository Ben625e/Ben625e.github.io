package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

// Tester class for the Contact class
class ContactTest {

	// This test case tests if Contact properly stores valid data
	@Test
	void testContactClass() {
		// Create a new contact with good data
		Contact Contact= new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
		// Check each variable if the data is stored in the correct variable
		assertTrue(Contact.getContactID().equals("WorkFriend"));
		assertTrue(Contact.getFirstName().equals("John"));
		assertTrue(Contact.getLastName().equals("Doe"));
		assertTrue(Contact.getNumber().equals("1235552347"));
		assertTrue(Contact.getAddress().equals("123 Test Street"));
	}
	
	// The following test cases test if creating a Contact with a too long variable throws an exception
	
	@Test
	void testContactClassIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("OverTenLetters", "John", "Doe", "1235552347", "123 Test Street");
		});
	}
	
	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", "OverTenLetters", "Doe", "1235552347", "123 Test Street");
		});
	}
	
	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", "John", "OverTenLetters", "1235552347", "123 Test Street");
		});
	}
	
	@Test
	void testContactClassNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", "John", "Doe", "123456789012", "123 Test Street");
		});
	}
	
	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", "John", "Doe", "1235552347", "1234567890 Too Long For The Address Street");
		});
	}
	
	// Test case for creating a Contact with number being too short, which should be exactly 10 characters
	@Test
	void testContactClassNumberTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", "John", "Doe", "123555321", "123 Test Street");
		});
	}
	
	// The following test cases test if creating a Contact with a null variable throws an exception
	
	@Test
	void testContactClassIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "1235552347", "123 Test Street");
		});
	}
	
	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", null, "Doe", "1235552347", "123 Test Street");
		});
	}
	
	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", "John", null, "1235552347", "123 Test Street");
		});
	}
	
	@Test
	void testContactClassNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", "John", "Doe", null, "123 Test Street");
		});
	}
	
	@Test
	void testContactClassAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("WorkFriend", "John", "Doe", "1235552347", null);
		});
	}
	
	// The following test cases are testing sending too long data to the setter methods
	
	@Test
	void testSetContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setFirstName("OverTenLetters");
		});
	}
	
	@Test
	void testSetContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setLastName("OverTenLetters");
		});
	}
	
	@Test
	void testSetContactClassNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setNumber("123456789012");
		});
	}
	
	@Test
	void testSetContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setAddress("1234567890 Too Long For The Address Street");
		});
	}
	
	// Test for sending too short of a number to the setter
	@Test
	void testSetContactClassNumberShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setNumber("123555321");
		});
	}
	
	// The following test cases send a null value to the setter methods
	
	@Test
	void testSetContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setFirstName(null);
		});
	}
	
	@Test
	void testSetContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setLastName(null);
		});
	}
	
	@Test
	void testSetContactClassNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setNumber(null);
		});
	}
	
	@Test
	void testSetContactClassAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact Contact = new Contact("WorkFriend", "John", "Doe", "1235552347", "123 Test Street");
			Contact.setAddress(null);
		});
	}

}
