
/**
 * Creates an object which stores a list with unique properties.
 *
 * @author Martin Mueller
 * @version 04/11/2018
 */

import java.util.*;

public class StrangeContainer<T extends Comparable<T>> {
    //declare arraylist that actually stores the objects
    private ArrayList<T> container;
    //initialize the arraylist
    public StrangeContainer() {
        container = new ArrayList<>();
    }
    //converts the StringContainer to a string when called/printed
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if(this.size() == 0) {
            return "[]";
        } else {
            string.append("["+container.get(0).toString());
        }
        for(int i=1; i<this.size(); i++) {
            string.append(", "+container.get(i).toString());
        }
        string.append("]");
        return string.toString();
    }
    //add an element to the beginning of the arraylist
    public void add(T object) {
        container.add(0, object);
    }
    //remove the middle element from the arraylist
    //...and shift all other elements up
    public T delete() {
        T object = container.get(container.size()/2);
        container.remove(object);
        return object;
    }
    //returns an object at a specific index
    public T peek(int index) {
        return container.get(index);
    }
    //returns the size of the container
    public int size() {
        return container.size();
    }
    //sorts the container
    public void sort() {
        Collections.sort(container);
    }
    
}
