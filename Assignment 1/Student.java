
/**
 * Outlines all information needed to define a university student.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class Student extends Person {
    //declare all instance varaibles
    private String currentSemester;
    private int creditsCompleted;
    protected int enrolledCredits;
    protected boolean graduationStatus;
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
     */
    public Student(String firstName, String middleName, String lastName, String dateOfBirth, String gender, Address address,
                   String currentSemester, int creditsCompleted, int enrolledCredits, boolean graduationStatus) {
        super(firstName, middleName, lastName, dateOfBirth, gender, address);
        this.currentSemester = currentSemester;
        this.creditsCompleted = creditsCompleted;
        this.enrolledCredits = enrolledCredits;
        this.graduationStatus = graduationStatus;
    }
    /**
     * If attempting to print an object,
     * this method returns a String that prints instead.
     * 
     * @return  all relevant information about the student
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
     * Gets the current semester the student is enrolled in.
     * 
     * @return  the current semester the student is enrolled in (e.g. spring or fall)
     */
    public String getCurrentSemester() {
        return currentSemester;
    }
    /**
     * Gets the amount of credit the student has completed so far.
     * 
     * @return  the amount of credits the student has completed so far
     */
    public int getCreditsCompleted() {
        return creditsCompleted;
    }
    /**
     * Gets the amount of credits the student is currently taking.
     * 
     * @return  the amount of credits the student is currently taking
     */
    public int getEnrolledCredits() {
        return enrolledCredits;
    }
    /**
     * Tells whether or not the student has graduated yet.
     * 
     * @return  whether or not the student has graduated yet
     */
    public boolean getGraduationStatus() {
        return graduationStatus;
    }
    /**
     * Determines the student's class standing.
     * 
     * @return  the student's class standing (if applicable)
     */
    public String status() {
        if(getGraduationStatus() == true) {
            return "graduated";
        } else if(creditsCompleted >= 0 && creditsCompleted <= 30) {
            return "freshman";
        } else if(creditsCompleted >= 31 && creditsCompleted <= 60) {
            return "sophomore";
        } else if(creditsCompleted >= 61 && creditsCompleted <= 90) {
            return "junior";
        } else if(creditsCompleted > 90) {
            return "senior";
        }
        return "special";
    }
    /**
     * Determines if the student is full time or not.
     * 
     * @return  whether or not the student is considered full time
     */
    public boolean isFullTime() {
        return getEnrolledCredits() >=12 ? true : false;
    }
    /**
     * Attempts to change the student's graduation status to true.
     * 
     * @return  whether or not the student graduated sucessfully
     */
    public boolean graduate() {
        if((creditsCompleted + enrolledCredits) >= 120 && !status().equals("special")) {
            graduationStatus = true;
            enrolledCredits = 0;
            return true;
        }
        return false;
    }
}
 