import kvmap.KVMapVisitor;

/**
 * Class that represents a function object that combines the value and key
 * into a string for each value in a non-empty map.
 * @author Jarred Lien
 * @version Assignment 8
 *
 */
public class StringWithNumber implements KVMapVisitor<Integer, String> {

    /**
     * method that turns the key into a string and combines it with the value
     * @param k the key
     * @param v the value
     * @return a string of the value and key combined
     */
    public String visit(Integer k, String v) {
        return v + " "  + Integer.toString(k);
    }

}
