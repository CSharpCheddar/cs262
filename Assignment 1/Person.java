
/**
 * Outlines all personal information about someone.
 * It makes no sense to make a Person without a function, so I made this class abstract.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public abstract class Person {
    //declare all instance variables
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private Address address;
    /**
     * The constructor collects all information needed to make the person,
     * then sets all instance variables accordingly.
     * 
     * @param  firstName    the person's first name
     * @param  middleName   the person's middle name
     * @param  lastName     the person's last name
     * @param  dateOfBirth  the person's date of birth
     * @param  gender       the person's gender
     * @param  address      the person's address (in the form of an Address object)
     */
    public Person(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the Person
     */
    public String toString() {
        return getPersonalInformation();
    }
    /**
     * Gets the person's first name.
     * 
     * @return  the person's first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Gets the person's middle name.
     * 
     * @return  the person's middle name
     */
    public String getMiddleName() {
        return middleName;
    }
    /**
     * Gets the person's last name.
     * 
     * @return  the person's last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Gets the person's date of birth.
     * 
     * @return  the person's date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Gets the person's gender.
     * 
     * @return  the person's gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * Gets the person's address.
     * 
     * @return  the person's address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * Packages all of the person's personal information
     * into a well-formatted String, then returns it.
     * 
     * @return  all personal details about a person
     */
    public String getPersonalInformation() {
        return "First Name: " + getFirstName() +
               "\nMiddle Name: " + getMiddleName() +
               "\nLast Name: " + getLastName() +
               "\nDate of Birth: " + getDateOfBirth() +
               "\nGender: " + getGender() +
               "\nAddress:\n" +
               address.getAddressFirstLine() +
               "\n" + address.getCity() + ", " + address.getState() + " " + address.getZipcode();
    }
}
