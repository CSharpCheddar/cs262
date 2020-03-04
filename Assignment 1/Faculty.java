
/**
 * Defines all characteristics of a university faculty member.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class Faculty extends Person implements Instructor {
    //declare all instance variables
    private int creditsTaught;
    private int salary;
    /**
     * The constructor collects all information needed to make the faculty member,
     * then sets all instance variables accordingly.
     * 
     * @param  firstName      the faculty member's first name
     * @param  middleName     the faculty member's middle name
     * @param  lastName       the faculty member's last name
     * @param  dateOfBirth    the faculty member's date of birth
     * @param  gender         the faculty member's gender
     * @param  address        the faculty member's address (in the form of an Address object)
     * @param  creditsTaught  the amount of credit hours in classes the faculty member has taught
     * @param  salary         the salary of the faculty member
     */
    public Faculty(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address,
                    int creditsTaught, int salary) {
        super(firstName, middleName, lastName, dateOfBirth, gender, address);
        this.creditsTaught = creditsTaught;
        this.salary = salary;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the faculty member
     */
    public String toString() {
        return getPersonalInformation() + 
               "\nCredits Taught: " + creditsTaught() +
               "\nSalary: " + salary();
    }
    /**
     * Gets how many total credit hours there were in classes the faculty member taught.
     * 
     * @return  the number of credits the faculty member taught
     */
    public int creditsTaught() {
        return creditsTaught;
    }
    /**
     * Gets the salary of the faculty member.
     * 
     * @return  the salary of the faculty member
     */
    public int salary() {
        return salary;
    }
}
