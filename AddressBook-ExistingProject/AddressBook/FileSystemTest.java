package AddressBook;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//This section was done by Eric Hoffman
class FileSystemTest {

  File file = new File("C:\\Program Files\\AddressBook-ExistingProject");
  AddressBook testAddressBook = new AddressBook();
  Person person1 = new Person("Daniel", "Montoya", "123 Street st", "Fort Myers", "FL", "33967",
      "123-456-7890");

  Path tempDirectory;

  @BeforeEach
  void setUp() {
    assertTrue(Files.isDirectory(this.tempDirectory));
  }

  //Unit Test:
  //Tests read file
  @Test
  void readFile() {
    FileSystem fileSystem = new FileSystem();
    Throwable execption2 = assertThrows(SQLException.class, () -> {
      throw new SQLException("SQL Exception");
    });
    assertDoesNotThrow(() -> fileSystem.saveFile(testAddressBook, file));
  }

  //Unit Test:
  //Tests the saving file
  @Test
  void saveFile() throws FileNotFoundException, SQLException {
    FileSystem testFileSystem = new FileSystem();
    testAddressBook.add(person1);

    Throwable exception = assertThrows(FileNotFoundException.class, () -> {
      throw new FileNotFoundException("File Not Found");
    });

    Throwable exception2 = assertThrows(SQLException.class, () -> {
      throw new SQLException("SQL Exception");
    });

    File file = new File("Address Book");
    assertDoesNotThrow(() -> testFileSystem.saveFile(testAddressBook, file));
    assertDoesNotThrow(() -> testFileSystem.readFile(testAddressBook, file));

    assertTrue(testAddressBook.getRowCount() == 1);

    assertEquals("File Not Found", exception);
    assertEquals("SQL Exception", exception2);

  }
}