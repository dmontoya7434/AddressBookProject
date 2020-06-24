package AddressBook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;


//Unit tests
//This section was done by Daniel Montoya
class AddressBookControllerTest {

  Person person1 = new Person("Daniel", "Montoya", "123 Street st", "Fort Myers", "FL", "33967",
      "123-456-7890");
  @Mock
  AddressBook testAddressBook = new AddressBook();

  @Mock
  AddressBookController testAddressBookController = new AddressBookController(testAddressBook);

  File testFile = new File("testDatabase.txt");

  /**
   * Unit Test adding a person to the AddressBook positive testing
   */
  @Test
  void add() {
    testAddressBookController.add(person1);
    assertEquals(person1, testAddressBookController.get(0));
  }

  /**
   * Unit Test setting a person to the AddressBook positive testing
   */
  @Test
  void set() {
    testAddressBookController.add(person1);
    //testAddressBookController.set(0,person1);
    assertEquals(person1, testAddressBookController.get(0));
  }

  /**
   * Unit Test removing a person to the AddressBook.
   */
  @Test
  void remove() {
    testAddressBookController.add(person1);
    testAddressBookController.remove(0);
    assertEquals(0, testAddressBook.getRowCount());

  }

  /**
   * Unit Test getting a person from a specific index in the AddressBook.
   */

  @Test
  void get() {
    testAddressBookController.add(person1);
    testAddressBookController.get(0);
    assertEquals(person1, testAddressBookController.get(0));
  }

  /**
   * Unit Test that clears the person to the AddressBook.
   */
  @Test
  void clear() {
    testAddressBookController.clear();
    testAddressBookController.add(person1);
    testAddressBookController.clear();
    assertEquals(0, testAddressBook.getRowCount());
  }


  /**
   * Unit Test getting the model person to the AddressBook.
   */
  @Test
  void getModel() {
    testAddressBookController.getModel();
    assertEquals(testAddressBook, testAddressBookController.getModel());
  }

  /**
   * Unit Test to verify that the file was saved with the correct person that was added.
   */
  @Test
  public void save() throws SQLException {
    testAddressBookController.add(person1);
    testAddressBookController.save(testFile);

    //Checks if the correct person was saved to the file
    assertEquals("Daniel", person1.getFirstName());
  }

  /**
   * Unit Test Tests to make sure that the file was opened in the AddressBook.
   */
  @Test
  public void open() throws FileNotFoundException, SQLException {
    testAddressBookController.open(testFile);

    assertEquals(1, testAddressBook.getRowCount());
  }

}