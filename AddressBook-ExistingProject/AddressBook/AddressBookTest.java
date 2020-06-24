package AddressBook;

import static org.junit.jupiter.api.Assertions.*;

import AddressBook.AddressBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyInt;

//Testing was done by Daniel Montoya
class AddressBookTest {

  private Person person1;
  private Person person2;
  private AddressBook testAddressBook;

  //This method is called before a test is executed.
  //Creates a Person object named person1
  @BeforeEach
  void setup() {
    testAddressBook = new AddressBook();
    person1 = new Person("Daniel", "Montoya", "123 Street st", "Fort Myers", "FL", "33967",
        "123-456-7890");

  }

  //Gets the person at the specified row
  @Test
  void getPersons() {
    testAddressBook.add(person1);
    testAddressBook.get(0);
    assertEquals(person1, testAddressBook.get(0));
  }


  @Test
  void setPerson() {

    //Adds person1 to AddressBook
    testAddressBook.add(person1);

    // Checks that index 0 contains person1
    assertEquals(person1, testAddressBook.get(0));

    // Replace testPerson with person1
    testAddressBook.set(0, person2);

    // Check that index 0 now contains person2
    assertEquals(person2, testAddressBook.get(0));
  }

  @Test
  void removePerson() {

    //adds a person to AddressBook
    testAddressBook.add(person1);

    //checks that person1 has been added

    assertEquals(1, testAddressBook.getRowCount());
    //Removes person from the AddressBook

    testAddressBook.remove(0);
  }

  //Clears the person from the address book
  @Test
  void clearPerson() {
    testAddressBook.add(person1);
    assertEquals(1, testAddressBook.getRowCount());
    testAddressBook.clear();
    assertEquals(0, testAddressBook.getRowCount());
  }

  //Gets the amount of columns in the addressbook
  @Test
  void getColumnCount() {
    testAddressBook.add(person1);
    assertEquals(7, testAddressBook.getColumnCount());
  }

  //Gets the person at the specified index (row,column)
  @Test
  void getValueAt() {
    testAddressBook.add(person1);
    assertEquals("Montoya", testAddressBook.getValueAt(0, 0));
  }

  //Gets the columns name
  @Test
  void getColumnName() {
    testAddressBook.add(person1);
    testAddressBook.getColumnName(0);
    assertEquals("Last Name", testAddressBook.getColumnName(0));

  }


}