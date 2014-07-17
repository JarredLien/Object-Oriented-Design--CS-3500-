package kvmap;




import java.util.*;

/**
 * @author Jarred Lien
 * @version Assignment 4
 * Class that represents a function object (comparator) for integers
 */
public class IntComp implements Comparator<Integer> {

    /**
     * method that compares the two given integers
     * @param i1 the first integer to use for comparing
     * @param i2 the second integer to compare to the first
     * @return less than 0 if i2 is greater than i1,
     * == 0 if they're the same, and greater than 0 if i1 is greater
     */
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }

}
