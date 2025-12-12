package contact;

// Contact Class that stores a unique id, first name, last name, number and address
// The current implementation has the data stored locally
// The variables have the following parameters set by the stakeholders
// Unique ID should not be null, > 10 characters, and Not updatable
// First name should not be null or > 10 characters
// Last name should not be null or > 10 characters
// Number should be 10 characters exactly and not null
// Address should not be null or > 30 characters

public class Contact {

	// Private Variable Declaration
	private String contactID;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	// Public Functions
	
	// Default Class Constructor
	public Contact(String id, String first, String last, String num, String addr) {
		// Input Validation
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
		
		// Values Set
		this.contactID = id;
		this.firstName = first;
		this.lastName = last;
		this.Number = num;
		this.Address = addr;
	}
	
	// Setters except for contactID
	public void setFirstName(String first) {
		if(first == null || first.length()>10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		this.firstName = first;
	}
	
	
	public void setLastName(String last) {
		if(last == null || last.length()>10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		this.lastName = last;
	}
	
	
	public void setNumber(String num) {
		if(num == null || num.length()!=10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		this.Number = num;
	}
	
	public void setAddress(String addr) {
		if(addr == null || addr.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.Address = addr;
	}
	
	// Getters
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNumber() {
		return Number;
	}
	
	public String getAddress() {
		return Address;
	}
	
	// contactID is non-updatable, so only has a getter and no setter
	public String getContactID() {
		return contactID;
	}
	
}
