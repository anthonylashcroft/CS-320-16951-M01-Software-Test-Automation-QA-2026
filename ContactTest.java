package cs320_Milestones_Tests;

/*
 * Anthony Ashcroft
 * SNHU CS320
 * 2026
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cs320_Milestones.Contact;

class ContactTest {
	
	 @BeforeAll
	 static void setUpBeforeClass() {
	     System.out.println("Starting Contact tests...");
	 }

	 @AfterAll
	 static void tearDownAfterClass() {
	     System.out.println("Finished Contact tests.");
	 }

    @Test
    @DisplayName("Test a valid contact creation")
    void testValidContact() {
        String contact = "1001";
        String firstName = "Anthony";
        String lastName = "Ashcroft";
        String phone = "1234567890";
        String address = "123 Fourth Street";

        Contact testContact = new Contact(contact, firstName, lastName, phone, address);

        assertEquals("1001", testContact.getContact());
        assertEquals(firstName, testContact.getFirstName());
        assertEquals(lastName, testContact.getLastName());
        assertEquals(phone, testContact.getPhone());
        assertEquals(address, testContact.getAddress());
    }

    // Test invalid information
    @Test
    @DisplayName("Test null contact")
    void testNullContact() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Anthony", "Ashcroft", "1234567890", "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test long contact")
    void testLongContact() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("10000000000", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test null first")
    void testNullFirst() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", null, "Ashcroft", "1234567890", "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test long first")
    void testLongFirst() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "AnthonyLynton", "Ashcroft", "1234567890", "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test null last")
    void testNullLast() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Anthony", null, "1234567890", "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test long last")
    void testLongLast() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Anthony", "LyntonAshcroft", "1234567890", "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test null phone")
    void testNullPhone() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Anthony", "Ashcroft", null, "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test non-digit phone")
    void testNonDigitPhone() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Anthony", "Ashcroft", "1234a67890", "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test long phone")
    void testLongPhone() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Anthony", "Ashcroft", "12345678901", "123 Fourth Street")
        );
    }
    
    @Test
    @DisplayName("Test null address")
    void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Anthony", "Ashcroft", "1234567890", null)
        );
    }
    
    @Test
    @DisplayName("Test long address")
    void testLongAddress() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street123 Fourth Street")
        );
    }

    // Test valid updates
    @Test
    @DisplayName("Test a valid first update")
    void testValidFirstUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");

        testContact.setFirstName("Tony");
        assertEquals("Tony", testContact.getFirstName());
    }
    
    @Test
    @DisplayName("Test a valid last update")
    void testValidLastUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");

        testContact.setLastName("Ash");
        assertEquals("Ash", testContact.getLastName());
    }
    
    @Test
    @DisplayName("Test a valid phone update")
    void testValidPhoneUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");

        testContact.setPhone("1234567899");
        assertEquals("1234567899", testContact.getPhone());
    }
    
    @Test
    @DisplayName("Test a valid address update")
    void testValidAddressUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");

        testContact.setAddress("123 Fourth Street East");
        assertEquals("123 Fourth Street East", testContact.getAddress());
    }

    // Test invalid updates
    @Test
    @DisplayName("Test a null first update")
    void testNullFirstUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
        
        assertThrows(IllegalArgumentException.class,
                () -> testContact.setFirstName(null));
    }
    
    @Test
    @DisplayName("Test a long first update")
    void testLongFirstUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");    

        assertThrows(IllegalArgumentException.class,
                () -> testContact.setFirstName("AnthonyLynton"));
    }
    
    @Test
    @DisplayName("Test a null last update")
    void testNullLastUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
        
        assertThrows(IllegalArgumentException.class,
                () -> testContact.setLastName(null));
    }
    
    @Test
    @DisplayName("Test a long last update")
    void testLongLastUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
        
        assertThrows(IllegalArgumentException.class,
                () -> testContact.setLastName("LyntonAshcroft"));
    }
    
    @Test
    @DisplayName("Test a null phone update")
    void testNullPhoneUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
        
        assertThrows(IllegalArgumentException.class,
                () -> testContact.setPhone(null));
    }
    
    @Test
    @DisplayName("Test a long phone update")
    void testLongPhoneUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
        
        assertThrows(IllegalArgumentException.class,
                () -> testContact.setPhone("12345678901"));
    }
    
    @Test
    @DisplayName("Test a null address update")
    void testNullAddressUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
        
        assertThrows(IllegalArgumentException.class,
                () -> testContact.setAddress(null));
    }
    
    @Test
    @DisplayName("Test a long address update")
    void testLongAddressUpdate() {
        Contact testContact =
                new Contact("1001", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
        
        assertThrows(IllegalArgumentException.class,
                () -> testContact.setAddress("123 Fourth Street123 Fourth Street"));
    }
    
    // Boundary tests
    
    @Test
    @DisplayName("Test boundary 9 digit contact")
    void testNineContact() {
            Contact testContact = new Contact("100000000", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
            assertEquals("100000000",testContact.getContact());
    }
    
    @Test
    @DisplayName("Test boundary 10 digit contact")
    void testTenContact() {
            Contact testContact = new Contact("1000000000", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street");
            assertEquals("1000000000",testContact.getContact());
    }
    
    @Test
    @DisplayName("Test boundary 11 digit contact")
    void testElevenContact() {
    	assertThrows(IllegalArgumentException.class, () ->
        	new Contact("12345678901", "Anthony", "Ashcroft", "1234567890", "123 Fourth Street")
    	);
    }
}