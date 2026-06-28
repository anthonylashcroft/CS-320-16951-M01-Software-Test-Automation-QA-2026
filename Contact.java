package cs320_Milestones;

/*
 * Anthony Ashcroft
 * SNHU CS320
 * 2026
 */

public class Contact {
	
	// Provide necessary contact information
	final private String contact; //Set to final so that it cannot be updated
	private String firstName;
	private String lastName;
	private String phone;
	private String address;	
	
	// Check for valid contact number
	private final boolean checkContact(String contact) {
		if(contact == null || contact.length() > 10) {
			return false;			
		}		
		return true;
	}
	
	// Check for valid last name
	private final boolean checkLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			return false;			
		}
		return true;
	}

	// Check for valid first name
	private final boolean checkFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {	
			return false;			
		}
		return true;
	}

	// Check for valid phone number
	private final boolean checkPhone(String phone) {
		if(phone == null || phone.length() != 10 || phone.matches(".*\\D.*")) {
			return false;			
		}
		return true;
	}
	
	// Check for valid address
	private boolean checkAddress(String address) {
		if(address == null || address.length() > 30) {
			return false;			
		}
		return true;
	}
	
	// Define contact class
	public Contact(
			String contact, 
			String firstName, 
			String lastName, 
			String phone, 
			String address
			) {
		
		// Report invalid contact
		if(!this.checkContact(contact)) {
			throw new IllegalArgumentException("Invalid contact number");
		}
		
		// Report invalid first name
		if(!this.checkFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		// Report invalid last name
		if(!this.checkLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		// Report invalid phone number
		if(!this.checkPhone(phone)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		// Report invalid address
		if(!this.checkAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}		
		
		this.contact = contact;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	// Declare accessors
	
	// Get contact number
	public String getContact() {
		return contact;
	}

	// Get contact first name
	public String getFirstName() {
		return firstName;
	}
	
	// Get contact last name
	public String getLastName() {
		return lastName;
	}
	
	// Get contact phone number
	public String getPhone() {
		return phone;
	}
	
	// Get contact address
	public String getAddress() {
		return address;
	}
	
	// Declare mutators
	
	// Set contact first name
	public void setFirstName(String firstName) {
		if(!this.checkFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	// Set contact last name
	public void setLastName(String lastName) {
		if(!this.checkLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	// Set phone number
	public void setPhone(String phone) {
		if(!this.checkPhone(phone)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone;
	}
	
	// Set contact address
	public void setAddress(String address) {
		if(!this.checkAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}	
		this.address = address;
	}

}
