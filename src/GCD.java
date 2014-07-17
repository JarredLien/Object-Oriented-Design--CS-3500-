import kvmap.KVMapVisitor;

/**
 * Class that represents a function object that computes the greatest
 * common denominator between the two integers given.
 * @author Jarred Lien
 * @version Assignment 8
 *
 */
public class GCD implements KVMapVisitor<Integer, Integer> {

    /**
     * computes the greatest common denominator between i1 and i2
     * @param i1 the integer
     * @param i2 the integer
     * @return the first integer if the 2nd is 0, otherwise recur,
     * but with the numbers flipped and i1 modulo i2 for the 2nd number
     */
    public Integer visit(Integer i1, Integer i2) {
        if (i2 != 0) {
            return visit(i2, i1 % i2);
        }
        else {
            return i1;
        }
    }


}
