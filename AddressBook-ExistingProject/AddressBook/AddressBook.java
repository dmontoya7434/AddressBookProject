package AddressBook;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

//This section was given by the instructor for the testing project.

public class AddressBook extends AbstractTableModel {
    private List<Person> persons = new ArrayList<>();


    /**
     * Returns the person at that information
     *
     * @return info of the person at that index
     */
    public Person[] getPersons() {
        return persons.toArray(new Person[persons.size()]);
    }


    /**
     * Adds the person at the new index to the table.
     *
     * @param p Person to insert in to the table.
     */
    public void add(Person p) {
        int newIndex = persons.size();
        persons.add(p);
        fireTableRowsInserted(newIndex, newIndex);
    }

    /**
     * Sets the person at the given index to the Person specified.
     *
     * @param index  Index to update.
     * @param person Person to replace the item with.
     */
    public void set(int index, Person person) {
        persons.set(index, person);
        fireTableRowsUpdated(index, index);
    }


    /**
     * Removes the person at the given index.
     *
     * @param index  Index to remove.
     */
    public void remove(int index) {
        persons.remove(index);
        fireTableRowsDeleted(index, index);
    }

    /**
     * Sets the person at the given index to the Person specified.
     *
     * @param index  Index to return.
     * @return person at given index.
     */
    public Person get(int index) {
        return persons.get(index);
    }

    /**
     * Clears this address book.
     */
    public void clear() {
        if (persons == null || persons.size() == 0) {
            return;
        }
        fireTableRowsDeleted(0, persons.size() - 1);
        persons.clear();
    }

    /**
     * Gets the number of rows in the table
     *
     * @return number of rows
     */
    @Override
    public int getRowCount() {
        return persons.size();
    }

    /**
     * Gets the number of columns in the table
     *
     * @return number of columns
     */
    public int getColumnCount() {
        return Person.fields.length;
    }

    /**
     * Sets the person at the given index to the Person specified.
     *
     * @param row integer of the person index.
     * @param column integer of the person index.
     * @return person at given row and column integer.
     */
    @Override
    public Object getValueAt(int row, int column) {
        return persons.get(row).getField(column);
    }

    /**
     * Gets the name of the column
     *
     * @param column integer of the table index.
     * @return person name of the specified column.
     */
    @Override
    public String getColumnName(int column) {
        return Person.fields[column];
    }
}