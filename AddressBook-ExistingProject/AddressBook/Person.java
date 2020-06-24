package AddressBook;

import java.util.regex.Pattern;


public class Person {

    public static final String[] fields =
        {
            "Last Name",
            "First Name",
            "Address",
            "City",
            "State",
            "ZIP",
            "Phone",
        };

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;

    // Patterns found online
    private String Name_Regex = "^[a-zA-Z]+(([',\\- ] [a-zA-Z ])?[a-zA-Z]*)*$";
    private String Address_Regex = "^\\d+\\s[A-z]+\\s[A-z]+";
    private String Number_Regex = "^\\d+$";
    private String Phone_Regex = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}";

    private Pattern namePattern = Pattern.compile(Name_Regex);
    private Pattern addressPattern = Pattern.compile(Address_Regex);
    private Pattern numberPattern = Pattern.compile(Number_Regex);
    private Pattern phonePattern = Pattern.compile(Phone_Regex);


    public Person(String firstName, String lastName, String address, String city, String state, String zip, String phone) {

        // Check each user input field with the patterns above
        if (firstName == null || firstName.isEmpty() || !namePattern.matcher(firstName).matches())
            throw new IllegalArgumentException("First name cannot be empty or invalid");
        if (lastName == null || lastName.isEmpty() || !namePattern.matcher(lastName).matches())
            throw new IllegalArgumentException("Last name cannot be empty or invalid");
        if(address.isEmpty() && !addressPattern.matcher(address).matches())
            throw new IllegalArgumentException("Address cannot be empty or invalid");
        if(city.isEmpty() && !namePattern.matcher(city).matches())
            throw new IllegalArgumentException("City cannot be empty or invalid");
        if(!state.isEmpty() && !namePattern.matcher(state).matches())
            throw new IllegalArgumentException("State cannot be empty or invalid");
        if(!zip.isEmpty() && !numberPattern.matcher(zip).matches())
            throw new IllegalArgumentException("Zip cannot be empty or invalid");
        if(!phone.isEmpty() && !phonePattern.matcher(phone).matches())
            throw new IllegalArgumentException("Phone cannot be empty or invalid");


        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    /**
     * Returns this Person's first name.
     *
     * @return first name of this Person
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Returns this Person's last name.
     *
     * @return last name of this Person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns this Person's address.
     *
     * @return address of this Person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns this Person's city.
     *
     * @return city of this Person
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns this Person's state.
     *
     * @return state of this Person
     */
    public String getState() {
        return state;
    }

    /**
     * Returns this Person's ZIP code.
     *
     * @return ZIP code of this Person
     */
    public String getZip() {
        return zip;
    }

    /**
     * Returns this Person's telephone number.
     *
     * @return Telephone number of this Person.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns this Person's full name.
     *
     * @return full name of this Person
     */
    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }


    public boolean containsString(String findMe) {
        Pattern p = Pattern.compile(Pattern.quote(findMe), Pattern.CASE_INSENSITIVE);
        return p.matcher(firstName).find()
            || p.matcher(lastName).find()
            || p.matcher(address).find()
            || p.matcher(city).find()
            || p.matcher(state).find()
            || p.matcher(zip).find()
            || p.matcher(phone).find();
    }

    /**
     * Returns this Person's selected field.
     *
     * @return selected field of this Person
     */
    public String getField(int field) {
        switch (field) {
            case 0:
                return lastName;
            case 1:
                return firstName;
            case 2:
                return address;
            case 3:
                return city;
            case 4:
                return state;
            case 5:
                return zip;
            case 6:
                return phone;
            default:
                throw new IllegalArgumentException("Field number out of bounds");
        }
    }
}