package kvmap;




import java.util.*;

/**
 * @author Jarred Lien
 * @version Assignment 4
 * Class that represents a function object (comparator) for strings
 */
public class StringComp implements Comparator<String> {

    /**
     * method that compares the two strings
     * @param s1 the first string to compare
     * @param s2 the second string to compare to the first
     * @return less than 0 if s2 is ahead of s1, == to 0 if they're the same
     * and greater than 0 if s1 is ahead of s2.
     */
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }

}
