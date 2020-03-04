
/**
 * Defines properties of a university instructor.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public interface Instructor extends Employee {
    /**
     * Requires that all instructors keep track of the amount of credits they've taught.
     * 
     * @return  the number of credits the instructor taught
     */
    int creditsTaught();
}
