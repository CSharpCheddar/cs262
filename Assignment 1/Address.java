
/**
 * Stores all information about a person's address.
 *
 * @author Martin Mueller
 * @version 03/14/2018
 */
public class Address {
    //declare all instance variables
    private String addressFirstLine;
    private String city;
    private String state;
    private int zipcode;
    /**
     * The constructor collects all information needed for the address,
     * then sets all instance variables accordingly.
     * 
     * @param  addressFirstLine  the first line of an address (as it would appear on a letter)
     * @param  city              the city in which the address is located
     * @param  state             the state in which the address is located
     * @param  zipcode           the zipcode in which the address is located
     */
    public Address(String addressFirstLine, String city, String state, int zipcode) {
        this.addressFirstLine = addressFirstLine;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    /**
     * Returns the object as a string if printed.
     * 
     * @return  if the object is printed, returns relevant information
     */
    public String toString() {
        return "Address:\n" + 
                getAddressFirstLine() + "\n" +  
                getCity() + ", " + getState() + " " + getZipcode();
    }
    /**
     * Gets the first line of the address (as it would appear on a letter)
     * 
     * @return  the first line of the address (as it would appear on a letter)
     */
    public String getAddressFirstLine() {
        return addressFirstLine;
    }
    /**
     * Gets the city in which the address is located
     * 
     * @return  the city in which the address is located
     */
    public String getCity() {
        return city;
    }
    /**
     * Gets the state in which the address is located
     * 
     * @return  the state in which the address is located
     */
    public String getState() {
        return state;
    }
    /**
     * Gets the zipcode in which the address is located
     * 
     * @return the zipcode in which the address is located
     */
    public int getZipcode() {
        return zipcode;
    }
}
