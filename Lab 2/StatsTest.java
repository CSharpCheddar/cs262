
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

/**
 * Tests the Stats class.
 *
 * @author  Martin Mueller
 * @version 02/13/2018
 */

public class StatsTest {
    //declare the test array
    private int array[];
    //declare the Stats object
    private Stats stats;
    //populate the test array and initialize the Stats object
    public StatsTest() {
        int[] array = new int[20];
        Random random = new Random(2625);
        for(int i=0; i<array.length; i++) {
            array[i] = random.nextInt(86) + 10;
        }
        //pass the array into the Stats object
        stats = new Stats(array);
    }
    //test the min method in the Stats class
    @Test
    public void minTest() {
        assertEquals(stats.min(), 10);
    }
    //test the max method in the Stats class
    @Test
    public void maxTest() {
        assertEquals(stats.max(), 93);
    }
}
