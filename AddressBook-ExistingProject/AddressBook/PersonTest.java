package AddressBook;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//Unit tests that uses positive and negative testing
// within the Person class.
//This Section was done by Daniel Montoya
class PersonTest {

  private Person Daniel;

  @BeforeEach
  public void setUp() {
    Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");
  }


  // Unit Test case to ensure the getFirstName method
  // works correctly and returns the correct first name
  @Test
  void getFirstName() {
    // create person object with each field
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    // Check expected first name result with the actual result
    assertEquals("Daniel", Daniel.getFirstName());
  }

  // Unit Test case to ensure the getFirstName method
  // that fails the test.
  @Test
  void getFirstNameInvalid() {
    // create person object with each field
    Person Daniel = new Person(" ", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    // Check expected first name result with the actual result
    assertEquals("Daniel", Daniel.getFirstName());
  }


  // Unit test case to ensure the getLastName method
  // works correctly and returns the correct last name
  @Test
  void getLastName() {
    // create person object with each field
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    //check expected last name result with actual result
    assertEquals("Montoya", Daniel.getLastName());
  }

  // Unit test case to ensure the getLastName method
  // that fails the test.
  @Test
  void getLastNameInvalid() {
    // create person object
    Person Daniel = new Person("Daniel", " ", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    //check expected last name result with actual result
    assertEquals("Montoya", Daniel.getLastName());
  }

  // Unit test case to ensure the getAddress method works
  // correctly and returns the correct address
  @Test
  void getAddress() {
    // create person object with each field
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    // check expected address result with actual result
    assertEquals("1234 Street", Daniel.getAddress());
  }

  // Unit test case to ensure the getAddress method
  // fails the test.
  @Test
  void getAddressInvalid() {
    // create person object
    Person Daniel = new Person("Daniel", "Montoya", " ", "Fort Myers", "Florida",
        "33913", "1234567890");

    // check expected address result with actual result
    assertEquals("1234 Street", Daniel.getAddress());
  }

  // Unit test case to ensure the getCity method works
  // correctly and returns the correct city
  @Test
  void getCity() {
    // create person object with each field
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    // check expected city result with actual result
    assertEquals("Fort Myers", Daniel.getCity());
  }


  // Unit test case to ensure the getCity method
  // fails the test.
  @Test
  void getCityInvalid() {
    // create person object
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", " ", "Florida",
        "33913", "1234567890");

    // check expected city result with actual result
    assertEquals("Fort Myers", Daniel.getCity());
  }

  // Unit test case to ensure the getState method works
  // correctly and returns the correct state
  @Test
  void getState() {
    // create person object with each field
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "FL",
        "33913", "1234567890");

    // check expected state result with actual result
    assertEquals("FL", Daniel.getState());
  }

  // Unit test case to ensure the getState method
  // fails the test.
  @Test
  void getStateInvalid() {
    // create person object
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    // check expected state result with actual result
    assertEquals("Florida", Daniel.getState());
  }


  // Unit test case to ensure the getZip method works
  // correctly and returns the correct zip
  @Test
  void getZip() {
    // create person object with each field
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    // check expected zip result with actual result
    assertEquals("33913", Daniel.getZip());
  }

  @Test
  void getZipInvalid() {
    // create person object
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        " ", "1234567890");

    // check expected state result with actual result
    assertEquals("33913", Daniel.getZip());
  }

  // Unit test case to ensure the getPhone method works
  // correctly and returns the correct phone number
  @Test
  void getPhone() {
    // create person object with each field
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", "1234567890");

    // check expected number result with actual result
    assertEquals("1234567890", Daniel.getPhone());
  }

  @Test
  void getPhoneInvalid() {
    // create person object
    Person Daniel = new Person("Daniel", "Montoya", "1234 Street", "Fort Myers", "Florida",
        "33913", " ");

    // check expected state result with actual result
    assertEquals("1234567890", Daniel.getPhone());
  }


  // Unit test case to ensure the toString method works
  // correctly and returns the correct full name
  @Test
  void testToString() {
    // check expected toString name result with actual result
    assertEquals("Montoya, Daniel", Daniel.toString());
  }

  @Test
  void containsString() {

    assertEquals(true, Daniel.containsString("Daniel"));
    assertEquals(true, Daniel.containsString("Montoya"));
    assertEquals(true, Daniel.containsString("1234 Street"));
    assertEquals(true, Daniel.containsString("Fort Myers"));
    assertEquals(true, Daniel.containsString("FL"));
    assertEquals(true, Daniel.containsString("33913"));
    assertEquals(true, Daniel.containsString("1234567890"));
  }

  // Unit test case to ensure the getField method works
  // correctly and returns the correct field
  @Test
  void getField() {
    assertEquals("Montoya", Daniel.getField(0));
    assertEquals("Daniel", Daniel.getField(1));
    assertEquals("1234 Street", Daniel.getField(2));
    assertEquals("Fort Myers", Daniel.getField(3));
    assertEquals("Florida", Daniel.getField(4));
    assertEquals("33913", Daniel.getField(5));
    assertEquals("1234567890", Daniel.getField(6));
    assertThrows(IllegalArgumentException.class, () -> {
      Daniel.getField(7);
    });
  }

  //Tests to see if the letter matches the Regex
  @Test
  void validLetters() {
    String firstLetter = "D";
    assertTrue(firstLetter.matches("[a-zA-Z]"));
  }


}