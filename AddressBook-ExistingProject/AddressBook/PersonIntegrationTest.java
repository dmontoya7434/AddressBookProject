package AddressBook;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;


public class PersonIntegrationTest {

  // Integration Tests that uses a mock person and adds them
  // to an address book. The getValueAt method is then called
  // to access the mocked person and test the correct field
  // is returned for each test.
  //Section done by Eric


  @Test
  public void stubGetLastName() {
    Person mockedEric = mock(Person.class);

    when(mockedEric.getField(0)).thenReturn("Hoffman");
    AddressBook ericAddressBook = new AddressBook();
    ericAddressBook.add(mockedEric);
    assertEquals(ericAddressBook.getValueAt(0, 0), "Hoffman");
  }

  @Test
  public void stubGetFirstName() {
    Person mockedEric = mock(Person.class);

    when(mockedEric.getField(1)).thenReturn("Eric");
    AddressBook ericAddressBook = new AddressBook();
    ericAddressBook.add(mockedEric);
    assertEquals(ericAddressBook.getValueAt(0, 1), "Eric");
  }

  @Test
  public void stubGetAddress() {
    Person mockedEric = mock(Person.class);

    when(mockedEric.getField(2)).thenReturn("1234 Street");
    AddressBook ericAddressBook = new AddressBook();
    ericAddressBook.add(mockedEric);
    assertEquals(ericAddressBook.getValueAt(0, 2), "1234 Street");
  }

  @Test
  public void stubGetCity() {
    Person mockedEric = mock(Person.class);

    when(mockedEric.getField(3)).thenReturn("Fort Myers");
    AddressBook ericAddressBook = new AddressBook();
    ericAddressBook.add(mockedEric);
    assertEquals(ericAddressBook.getValueAt(0, 3), "Fort Myers");
  }

  @Test
  public void stubGetState() {
    Person mockedEric = mock(Person.class);

    when(mockedEric.getField(4)).thenReturn("FL");
    AddressBook ericAddressBook = new AddressBook();
    ericAddressBook.add(mockedEric);
    assertEquals(ericAddressBook.getValueAt(0, 4), "FL");
  }

  @Test
  public void stubGetZip() {
    Person mockedEric = mock(Person.class);

    when(mockedEric.getField(5)).thenReturn("33913");
    AddressBook ericAddressBook = new AddressBook();
    ericAddressBook.add(mockedEric);
    assertEquals(ericAddressBook.getValueAt(0, 5), "33913");
  }

  @Test
  public void stubGetPhone() {
    Person mockedEric = mock(Person.class);

    when(mockedEric.getField(6)).thenReturn("1234567890");
    AddressBook ericAddressBook = new AddressBook();
    ericAddressBook.add(mockedEric);
    assertEquals(ericAddressBook.getValueAt(0, 6), "1234567890");
  }

}
