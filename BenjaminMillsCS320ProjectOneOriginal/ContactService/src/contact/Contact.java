package contact;

// Contact Class which stores a unique ID, first and last name, phone number, and address
// All are strings and must meet certain requirements listed with their respective variable

public class Contact {

	// Unique ID which is no longer than 10 characters, not null, and not updatable
	private String contactID;
	// First Name which is not longer than 10 characters and not null
	private String firstName;
	// Last Name which is not longer than 10 characters and not null
	private String lastName;
	// First Name which is exactly 10 characters and not null
	private String Number;
	// Address which is not longer than 30 characters and not null
	private String Address;
	
	// Default Class Constructor
	public Contact(String id, String first, String last, String num, String addr) {
		// First checks for improper inputs, if found then throw an error
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid contactID");
		}
		if(first == null || first.length()>10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		if(last == null || last.length()>10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		if(num == null || num.length()!=10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		if(addr == null || addr.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		// If all are good inputs, set them to class variables
		this.contactID = id;
		this.firstName = first;
		this.lastName = last;
		this.Number = num;
		this.Address = addr;
	}
	
	// Setter and Getter Variables for each except contactID
	// Getters first check for proper data before assigning
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String first) {
		if(first == null || first.length()>10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		this.firstName = first;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String last) {
		if(last == null || last.length()>10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		this.lastName = last;
	}
	
	public String getNumber() {
		return Number;
	}
	
	public void setNumber(String num) {
		if(num == null || num.length()!=10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		this.Number = num;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String addr) {
		if(addr == null || addr.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.Address = addr;
	}
	
	// contactID is non-updatable, so only has a getter and no setter
	public String getContactID() {
		return contactID;
	}
	
}
