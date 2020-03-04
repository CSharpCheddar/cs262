
/**
 * Defines an undergraduate student who is a university employee.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class StudentEmployee extends Student implements Employee {
    //declare all instance variables
    private int salary;
    /**
     * The constructor collects all information needed to make the student,
     * then sets all instance variables accordingly.
     * 
     * @param  firstName         the student's first name
     * @param  middleName        the student's middle name
     * @param  lastName          the student's last name
     * @param  dateOfBirth       the student's date of birth
     * @param  gender            the student's gender
     * @param  address           the student's address (in the form of an Address object)
     * @param  currentSemester   the semester the student is currently enrolled in
     * @param  creditsCompleted  the amount of credits the student has completed so far
     * @param  enrolledCredits   the amount of credits the student is currently taking
     * @param  graduationStatus  tells whether or not the student is graduated
     * @param  salary            the student's salary
     */
    public StudentEmployee(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address,
                           String currentSemester, int creditsCompleted, int enrolledCredits, boolean graduationStatus,
                           int salary) {
        super(firstName, middleName, lastName, dateOfBirth, gender, address,
              currentSemester, creditsCompleted, enrolledCredits, graduationStatus);
        this.salary = salary;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the student employee
     */
    public String toString() {
        return getPersonalInformation() +
               "\nStatus: " + status() + 
               "\nFull Time: " + isFullTime() +
               "\nCurrent Semester Enrolled: " + getCurrentSemester() +
               "\nCredits Enrolled In: " + getEnrolledCredits() +
               "\nCredits Completed: " + getCreditsCompleted() + 
               "\nSalary: " + salary();
    }
    /**
     * Gets the student's salary as a university employee.
     * 
     * @return  the student's salary
     */
    public int salary() {
        return salary;
    }
}
