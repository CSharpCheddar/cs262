
/**
 * Describes all the properties of a university staff member.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class Staff extends Person implements Employee {
    //declare all instance variables
    private int salary;
    /**
     * The constructor collects all information needed to make the staff member,
     * then sets all instance variables accordingly.
     * 
     * @param  firstName    the staff member's first name
     * @param  middleName   the staff member's middle name
     * @param  lastName     the staff member's last name
     * @param  dateOfBirth  the staff member's date of birth
     * @param  gender       the staff member's gender
     * @param  address      the staff member's address (in the form of an Address object)
     * @param  salary       the staff member's salary
     */
    public Staff(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address,
                 int salary) {
        super(firstName, middleName, lastName, dateOfBirth, gender, address);
        this.salary = salary;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the staff member
     */
    public String toString() {
        return getPersonalInformation() +
               "\nSalary: " + salary();
    }
    /**
     * Returns the staff member's salary.
     * 
     * @return  the staff member's salary
     */
    public int salary() {
        return salary;
    }
}
