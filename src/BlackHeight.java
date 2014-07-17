import java.util.Comparator;

import kvmap.KVMap;
import kvmap.RBTVisitor;
/**
 * Class that represents a function object for a client to implement on
 * a red-black tree that computes the height of a path of black nodes
 * @author Jarred Lien
 * @version Assignment 8
 * @param <K> the key
 * @param <V> the value
 */
public class BlackHeight<K, V> implements RBTVisitor<K, V, Integer> {

    /**
     * Calculates the black node height for the Leaf
     * @param comp the comparator
     * @param color the color
     * @return 0 because it is empty.
     */
    public Integer visitEmpty(Comparator<? super K> comp, String color) {
        return 0;
    }


    /**
     * Calculates the black node height for the Node
     * @param color the color
     * @param comp the comparator
     * @param k the key
     * @param v the value
     * @param left the left KVMap
     * @param right the right KVMap
     * @return 1 plus the recursion on the left if the node is black
     * because it doesn't matter if you go down the left or right (all
     * paths have the same number of black nodes in a RBTree).
     */
    public Integer visitNode(String color, Comparator<K> comp, K k, V v,
            KVMap<K, V> left, KVMap<K, V> right) {
        if (!color.equals("black")) {
            return left.acceptRBT(this);
        }
        else {
            return 1 + left.acceptRBT(this);
        }
    }


}
