package cs320_Milestones;

/*
 * Anthony Ashcroft
 * SNHU CS320
 * 2026
 */

import java.util.List;
import java.util.ArrayList;


public class ContactService {
	
	int currentContactNumber = 0; // Set the current contact number for array navigation

	// Create contact list array
	private List<Contact> contactList = new ArrayList<Contact>();
	

	// Method to create contact
	public void addContact(Contact newContact) {
		
		
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getContact().equals(newContact.getContact())) {
				throw new IllegalArgumentException("An appointment with this ID already exists");
			}
		}
		
		contactList.add(currentContactNumber,newContact);
		
		// Move to next contact in array
		++currentContactNumber;

	}
	
	// Delete contact in array
	public void deleteContact(String contact) {
		boolean removed = false;
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getContact().equals(contact)) {
				contactList.remove(i);
				removed = true;
			}
		}
		
		if (!removed) {
			throw new IllegalArgumentException("An appointment with this ID doesn't exist.");
		}
	}
	
	// Update first name of provided contact
	public void updateFirstName(String contact, String firstName) {
		for(Contact iter : contactList) {
			if(iter.getContact().equals(contact)) {
				iter.setFirstName(firstName);				
			}			
		}	
	}
	

	// Update last name of provided contact
	public void updateLastName(String contact, String lastName) {
		for(Contact iter : contactList) {
			if(iter.getContact().equals(contact)) {
				iter.setLastName(lastName);				
			}			
		}	
	}
	
	// Update phone number of provided contact
	public void updateNumber(String contact, String phone) {
		for(Contact iter : contactList) {
			if(iter.getContact().equals(contact)) {
				iter.setPhone(phone);				
			}			
		}	
	}
	
	// Update address of provided contact
	public void updateAddress(String contact, String address) {
		for(Contact iter : contactList) {
			if(iter.getContact().equals(contact)) {
				iter.setAddress(address);				
			}			
		}	
	}
	
	public boolean listEmpty() {
		return contactList.isEmpty();
	}
	
	public Contact listGet(int contact) {
		return contactList.get(contact);
	}
	
	public int listSize() {
		return contactList.size();
	}
	
	public void listClear() {
		contactList.clear();
	}

}