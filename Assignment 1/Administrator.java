
/**
 * Defines properties of a university administrator.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public interface Administrator extends Employee {
    /**
     * Requires each administrator to have a specified position.
     * 
     * @return  the position of the administrator
     */
    String position();
}
