package AddressBook;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


//This section was done by Eric Hoffman
public class FileSystemIntegrationTest {

  // create an address book
  AddressBook ericAddressBook = new AddressBook();

  // Create a person object to be added to address book
  Person Eric = new Person("Eric", "Hoffman", "1234 Street",
      "Fort Myers", "FL", "33913", "1234567890");

  // Create a person object to be added to address book
  Person Daniel = new Person("Daniel", "Montoya", "1234 Drive",
      "Fort Myers", "FL", "33913", "1234567810");

  // Create a temporary directory for the file
  @TempDir
  Path temporaryDirectory;

  // assign the directory for the file before each test
  @BeforeEach
  public void setUp() {
    assertTrue(Files.isDirectory(this.temporaryDirectory));
  }

  // Integration test to make sure a file is saved with a created
  // address book and temporary directory for the file.
  @Test
  public void saveFile() {

    // create a new file system object
    FileSystem sampleFileSystem = new FileSystem();

    // add our previously created Person Objects to the created Address Book
    ericAddressBook.add(Eric);
    ericAddressBook.add(Daniel);

    File sampleFile = new File("Address Book");



  }

}
