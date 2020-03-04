
/**
 * Outlines all the properties of a graduate student.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class GraduateStudent extends Student {
    //declare all instance variables
    private boolean phdStatus;
    /**
     * The constructor collects all information needed to make the graduate student,
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
     */
    public GraduateStudent(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address,
                           String currentSemester,int creditsCompleted, int enrolledCredits, boolean graduationStatus,
                           boolean phdStatus) {
        super(firstName, middleName, lastName, dateOfBirth, gender, address,
              currentSemester, creditsCompleted, enrolledCredits, graduationStatus);
        this.phdStatus = phdStatus;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the graduate student
     */
    public String toString() {
        return getPersonalInformation() +
               "\nStatus: " + status() + 
               "\nFull Time: " + isFullTime() +
               "\nCurrent Semester Enrolled: " + getCurrentSemester() +
               "\nCredits Enrolled In: " + getEnrolledCredits() +
               "\nCredits Completed: " + getCreditsCompleted();
    }
    /**
     * Determines the graduate student's class standing.
     * 
     * @return  the graduate student's class standing (if applicable)
     */
    public String status() {
        if(getGraduationStatus() == true) {
            return "graduated";
        } else if(phdStatus == true) {
            return "doctoral";
        }
        return "masters";
    }
    /**
     * Determines if the graduate student is full time or not.
     * 
     * @return  whether or not the graduate student is considered full time
     */
    public boolean isFullTime() {
        if(phdStatus == true) {
            return true;
        }
        return getEnrolledCredits() >= 6 ? true : false;
    }
    /**
     * Attempts to change the graduate student's graduation status to true.
     * 
     * @return  whether or not the graduate student graduated sucessfully
     */
    public boolean graduate() {
        if((getCreditsCompleted() + getEnrolledCredits()) >= 120 && status().equals("doctoral")) {
            graduationStatus = true;
            enrolledCredits = 0;
            return true;
        } else if((getCreditsCompleted() + getEnrolledCredits()) >= 30 && status().equals("masters")) {
            graduationStatus = true;
            enrolledCredits = 0;
            return true;
        }
        return false;
    }
}
