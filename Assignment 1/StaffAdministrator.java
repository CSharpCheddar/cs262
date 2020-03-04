
/**
 * Defines all the characteristics of a university staff administrator.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class StaffAdministrator extends Staff implements Administrator {
    //declare all instance variables
    private String position;
    /**
     * The constructor collects all information needed to make the staff administrator,
     * then sets all instance variables accordingly.
     * 
     * @param  firstName    the staff administrator's first name
     * @param  middleName   the staff administrator's middle name
     * @param  lastName     the staff administrator's last name
     * @param  dateOfBirth  the staff administrator's date of birth
     * @param  gender       the staff administrator's gender
     * @param  address      the staff administrator's address (in the form of an Address object)
     * @param  salary       the staff administrator's salary
     * @param  position     the staff administrator's administrative position
     */
    public StaffAdministrator(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address,
                              int salary, String position) {
        super(firstName, middleName, lastName, dateOfBirth, gender, address, salary);
        this.position = position;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the staff administrator
     */
    public String toString() {
        return getPersonalInformation() +
               "\nSalary: " + salary() +
               "\nPosition: " + position();
    }
    /**
     * Returns the staff administrator's administrative position.
     * 
     * @return  the staff administrator's administrative position
     */
    public String position() {
        return position;
    }
}
