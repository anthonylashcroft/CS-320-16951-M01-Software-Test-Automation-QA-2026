package cs320_Milestones_Tests;

/*
 * Anthony Ashcroft
 * SNHU CS320
 * 2026
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cs320_Milestones.ContactService;
import cs320_Milestones.Contact;

class ContactServiceTest {
	
	private ContactService test;
	
    @BeforeAll
    static void setUpAll() {
        System.out.println("Starting ContactService tests...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Finished ContactService tests.");
    }
    
    @BeforeEach
    void setUp() {
        test = new ContactService();
    }
    
    // Test adding a contact to the service list
    @DisplayName("Test add valid contact to array")
    @Test
    void testAddContact() {
    	
		String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";

		assertTrue(test.listEmpty());

		test.addContact(new Contact(contact, firstName, lastName, phone, address));

		assertFalse(test.listEmpty());
		assertEquals("1001", test.listGet(0).getContact());
		assertEquals(firstName, test.listGet(0).getFirstName());
		assertEquals(lastName, test.listGet(0).getLastName());
		assertEquals(phone, test.listGet(0).getPhone());
		assertEquals(address, test.listGet(0).getAddress());

    }
    
    // Test adding an invalid contact to the service list
    @DisplayName("Test add invalid contact to array")
    @Test
    void testAddInvalidContact() {

		assertTrue(test.listEmpty());
		
		// Invalid contact number
		assertThrows(IllegalArgumentException.class, () ->
			test.addContact(new Contact("10010000000", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street"))
		);
		
		assertThrows(IllegalArgumentException.class, () ->
		test.addContact(new Contact(null, "Anthony", "Ashcroft", "1234567890", "123 Fourth Street"))
		);
		
		// Invalid contact first
		assertThrows(IllegalArgumentException.class, () ->
			test.addContact(new Contact("1001", "AnthonyLynton", "Ashcroft", "1234567890", "123 Fourth Street"))
		);
		
		assertThrows(IllegalArgumentException.class, () ->
		test.addContact(new Contact("1001", null, "Ashcroft", "1234567890", "123 Fourth Street"))
		);
		
		// Invalid contact last
		assertThrows(IllegalArgumentException.class, () ->
			test.addContact(new Contact("1001", "Anthony", "LyntonAshcroft", "1234567890", "123 Fourth Street"))
		);
		
		assertThrows(IllegalArgumentException.class, () ->
		test.addContact(new Contact("1001", "Anthony", null, "1234567890", "123 Fourth Street"))
		);
		
		// Invalid contact phone
		assertThrows(IllegalArgumentException.class, () ->
			test.addContact(new Contact("1001", "Anthony", "Ashcroft", "12345678900", "123 Fourth Street"))
		);
		
		assertThrows(IllegalArgumentException.class, () ->
		test.addContact(new Contact("1001", "Anthony", "Ashcroft", null, "123 Fourth Street"))
		);
		
		assertThrows(IllegalArgumentException.class, () ->
		test.addContact(new Contact("1001", "Anthony", "Ashcroft", "1234a67890", "123 Fourth Street"))
		);
	
		
		// Invalid contact address
		assertThrows(IllegalArgumentException.class, () ->
			test.addContact(new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street123 Fourth Street"))
		);
		
		assertThrows(IllegalArgumentException.class, () ->
		test.addContact(new Contact("1001", "Anthony", "Ashcroft", "1234567890", null))
		);
		
		assertTrue(test.listEmpty());
    }

    
    // Test removing a contact from the service list
    @DisplayName("Test delete contact from array")
    @Test
    void testDeleteContact() {
		  
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";
		boolean testBool = false;
		
		assertTrue(test.listEmpty());
		
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		contact = "1002";
    	firstName = "Anthony";
		lastName = "Ashcroft";
		phone = "1234567890";
		address = "123 Fourth Street";
		
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		contact = "1003";
    	firstName = "Anthony";
		lastName = "Ashcroft";
		phone = "1234567890";
		address = "123 Fourth Street";
		
		
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm list size
		assertEquals(3,test.listSize());
		
		//Confirm contact is found in list
		testBool = false;
				
		for(int i = 0; i < test.listSize(); i++) {
			if(test.listGet(i).getContact().equals("1001")) {
					testBool = true;
			}
		}		
		assertTrue(testBool);
		
		// Delete contact from list
		test.deleteContact("1001");
		
		// Confirm updated list size
		assertEquals(2,test.listSize());
		
		
		//Ensure removal of contact from list
		testBool = false;
		
		for(int i = 0; i < test.listSize(); i++) {
			if(test.listGet(i).getContact().equals("1001")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);
		
    }
    
    // Test updating first name
    @DisplayName("Test updating a first name")
    @Test
    void testUpdateFirst() {
		
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";

		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		contact = "1002";
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that first name has been stored
		assertEquals(firstName, test.listGet(0).getFirstName());
		
		test.updateFirstName("1001", "Tony");
		
		// Confirm that first name has been updated
		assertEquals("Tony", test.listGet(0).getFirstName());
		
    }
    
    // Test updating contact last name
    @DisplayName("Test updating a last name")
    @Test
    void testUpdateLast() {

    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";
		  
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		contact = "1002";
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that last name is stored
		assertEquals(lastName, test.listGet(0).getLastName());
		
		test.updateLastName("1001", "Ash");
		
		// Confirm that last name has been updated
		assertEquals("Ash", test.listGet(0).getLastName());
		
    }
    
    // Test updating contact phone number
    @DisplayName("Test updating a phone number")
    @Test
    void testUpdatePhone() {
    	
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";
		
		test.addContact(new Contact(contact,firstName, lastName, phone, address));
		
		contact = "1002";
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that phone number is stored
		assertEquals(phone, test.listGet(0).getPhone());
		
		test.updateNumber("1001", "1987654321");
		
		// Confirm that phone number has been updated
		assertEquals("1987654321", test.listGet(0).getPhone());
		
    }

    // Test updating address
    @DisplayName("Test updating an address")
    @Test
    void testUpdateAddress() {
		
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";

		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		contact = "1002";
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that address is stored
		assertEquals(address, test.listGet(0).getAddress());
		
		test.updateAddress("1001", "123 Fourth Street East");
		
		// Confirm that address has been updated
		assertEquals("123 Fourth Street East", test.listGet(0).getAddress());
	}
    
    // Test updating first name with invalid information
    @DisplayName("Test updating a invalid first name")
    @Test
    void testUpdateInvalidFirst() {
		
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";

		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that first name has been stored
		assertEquals(firstName, test.listGet(0).getFirstName());
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateFirstName("1001", "AnthonyLynton"));
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateFirstName("1001", null));
		
		
		// Confirm that first name has not been updated
		assertEquals("Anthony", test.listGet(0).getFirstName());
		
    }
    
    // Test updating contact last name with invalid information
    @DisplayName("Test updating a invalid last name")
    @Test
    void testUpdateInvalidLast() {

    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";
		  
		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that last name is stored
		assertEquals(lastName, test.listGet(0).getLastName());
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateLastName("1001", "LyntonAshcroft"));
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateLastName("1001", null));
		
		
		// Confirm that last name has not been updated
		assertEquals("Ashcroft", test.listGet(0).getLastName());
    }
    
    // Test updating contact phone number with invalid information
    @DisplayName("Test updating a invalid phone number")
    @Test
    void testUpdateInvalidPhone() {
    	
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";
		  
		
		test.addContact(new Contact(contact,firstName, lastName, phone, address));
		
		// Confirm that phone number is stored
		assertEquals(phone, test.listGet(0).getPhone());
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateNumber("1001", "12345678900"));
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateNumber("1001", null));
		
		
		// Confirm that phone number has not been updated
		assertEquals("1234567890", test.listGet(0).getPhone());
		
    }

    // Test updating address with invalid information
    @DisplayName("Test updating an invalid address")
    @Test
    void testUpdateInvalidAddress() {
		
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";

		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that address is stored
		assertEquals(address, test.listGet(0).getAddress());
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateAddress("1001", "123 Fourth Street123 Fourth Street"));
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateAddress("1001", null));
		
		
		// Confirm that address has not been updated
		assertEquals("123 Fourth Street", test.listGet(0).getAddress());
	}
    
    // Test updating non existing contact
    @DisplayName("Test updating a non existing contact")
    @Test
    void testDeleteNoContact() {
		
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";

		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that contact has been stored
		assertEquals(contact, test.listGet(0).getContact());
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateFirstName("1002", "Tony"));
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateLastName("1002", "Ash"));
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateNumber("1002", "1234567891"));
		
		assertThrows(IllegalArgumentException.class,
                () -> test.updateAddress("1002", "123 Fifth Street"));
		
		
		// Confirm that contact list has not changed
		assertEquals(1,test.listSize());
		
    }
    
    // Test deleting non existing contact
    @DisplayName("Test updating a non existing appointment")
    @Test
    void testUpdateNoContact() {
		
    	String contact = "1001";
    	String firstName = "Anthony";
		String lastName = "Ashcroft";
		String phone = "1234567890";
		String address = "123 Fourth Street";

		test.addContact(new Contact(contact, firstName, lastName, phone, address));
		
		// Confirm that contact has been stored
		assertEquals(contact, test.listGet(0).getContact());
		
		assertThrows(IllegalArgumentException.class,
                () -> test.deleteContact("1002"));
		
		
		// Confirm that contact list size has not changed
		assertEquals(1,test.listSize());
		
    }
}