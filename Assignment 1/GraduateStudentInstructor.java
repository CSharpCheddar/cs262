
/**
 * Describes a graduate student who is also a university instructor.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class GraduateStudentInstructor extends GraduateStudent implements Instructor {
    //declare all instance variables
    private int creditsTaught;
    private int salary;
    /**
     * The constructor collects all information needed to make the graduate student instructor,
     * then sets all instance variables accordingly.
     * 
     * @param  firstName         the graduate student's first name
     * @param  middleName        the graduate student's middle name
     * @param  lastName          the graduate student's last name
     * @param  dateOfBirth       the graduate student's date of birth
     * @param  gender            the graduate student's gender
     * @param  address           the graduate student's address (in the form of an Address object)
     * @param  currentSemester   the semester the graduate student is currently enrolled in
     * @param  creditsCompleted  the amount of credits the graduate student has completed so far
     * @param  enrolledCredits   the amount of credits the graduate student is currently taking
     * @param  graduationStatus  tells whether or not the graduate student is graduated
     * @param  phdStatus         tells whether or not the graduate student is whorking towards a PhD
     * @param  creditsTaught     the amount of credit hours in classes the graduate student has taught
     * @param  salary            the graduate student's salary as an instructor
     */
    public GraduateStudentInstructor(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address,
                                     String currentSemester,int creditsCompleted, int enrolledCredits, boolean graduationStatus,
                                     boolean phdStatus, int creditsTaught, int salary) {
        super(firstName, middleName, lastName, dateOfBirth, gender, address,
              currentSemester, creditsCompleted, enrolledCredits, graduationStatus, phdStatus);
        this.creditsTaught = creditsTaught;
        this.salary = salary;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the graduate student instructor
     */
    public String toString() {
        return getPersonalInformation() +
               "\nStatus: " + status() + 
               "\nFull Time: " + isFullTime() +
               "\nCurrent Semester Enrolled: " + getCurrentSemester() +
               "\nCredits Enrolled In: " + getEnrolledCredits() +
               "\nCredits Completed: " + getCreditsCompleted() +
               "\nCredits Taught: " + creditsTaught() + 
               "\nSalary: " + salary();
    }
    /**
     * Gets how many total credit hours there were in classes the graduate student taught.
     * 
     * @return  the number of credits the graduate student taught
     */
    public int creditsTaught() {
        return creditsTaught;
    }
    /**
     * Gets the salary of the graduate student.
     * 
     * @return  the salary of the graduate student
     */
    public int salary() {
        return salary;
    }
}
