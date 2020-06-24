package AddressBook;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sun.jndi.cosnaming.IiopUrl.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Integration testing within the Addressbook project This section was done by Daniel Montoya.
 */

public class AddressBookIntegrationTest {

  private AddressBook ericAddressBook;
  private AddressBook danielAddressBook = new AddressBook();
  private Person Eric;
  private Person Daniel;
  private Person mockedEric;
  private Person mockedDaniel;


  /**
   * Set up the mock address book and give inputs for each person
   */

  @BeforeEach
  public void SetUp() {
    ericAddressBook = mock(AddressBook.class);
    Eric = new Person("Eric", "Hoffman", "1234 Street",
        "Fort Myers", "FL", "33913", "1234567890");
    Daniel = new Person("Daniel", "Montoya", "1234 Drive",
        "Fort Myers", "FL", "33913", "1234567810");

  }

  /**
   * Integration test that adds people to an address book and returns their name to confirm it's the
   * correct person that was added.
   */

  @Test
  public void addPerson() {
    ericAddressBook.add(Eric);
    ericAddressBook.add(Daniel);

    // test to see if the added person has the correct name
    assertEquals(Eric.getFirstName(), "Eric");
    assertEquals(Daniel.getFirstName(), "Daniel");
  }

  /**
   * Integration test that uses a mock to check for validation
   */

  @Test
  public void removePerson() {

    mockedEric = mock(Person.class);
    mockedDaniel = mock(Person.class);
    danielAddressBook.add(mockedEric);
    danielAddressBook.add(mockedDaniel);
    Person removedPerson = mockedDaniel;

    danielAddressBook.remove(1);

    // check if there is only one person in the address book
    // after removing the mockedDaniel Person
    assertEquals(danielAddressBook.getRowCount(), 1);

    Person savedPerson = danielAddressBook.get(0);

    // check that the removed and saved person are not the same
    assertNotEquals(removedPerson, savedPerson);

  }

}
