
/**
 * Outlines a university faculty member with an administrative position.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class FacultyAdministrator extends Faculty implements Administrator {
    //declare all instance variables
    private String position;
    /**
     * The constructor collects all information needed to make the faculty administrator,
     * then sets all instance variables accordingly.
     * 
     * @param  firstName      the faculty administrator's first name
     * @param  middleName     the faculty administrator's middle name
     * @param  lastName       the faculty administrator's last name
     * @param  dateOfBirth    the faculty administrator's date of birth
     * @param  gender         the faculty administrator's gender
     * @param  address        the faculty administrator's address (in the form of an Address object)
     * @param  creditsTaught  the amount of credit hours in classes the faculty administrator has taught
     * @param  position       the administrative position the faculty administrator holds
     * @param  salary         the salary of the faculty administrator
     */
    public FacultyAdministrator(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address,
                                int creditsTaught, String position, int salary) {
        super(firstName, middleName, lastName, dateOfBirth, gender, address, creditsTaught, salary);
        this.position = position;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the faculty administrator
     */
    public String toString() {
        return getPersonalInformation() + 
               "\nPosition: " + position() +
               "\nCredits Taught: " + creditsTaught() +
               "\nSalary: " + salary();
    }
    /**
     * Gets the title of the faculty administrator's administrative position.
     * 
     * @return  the title of the faculty administrator's administrative position
     */
    public String position() {
        return position;
    }
}
