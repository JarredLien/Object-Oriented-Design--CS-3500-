import java.util.ArrayList;
import java.util.Comparator;

import kvmap.KVMap;
import kvmap.RBTVisitor;

/**
 * Class that represents a function object that creates an array list of all 
 * possible paths from the root node to each leaf.
 * @author Jarred Lien
 * @version Assignment 8
 * @param <K> the key
 * @param <V> the value
 */
public class PathLengths<K, V> implements RBTVisitor<K, V, ArrayList<Integer>> {

    /**
     * method for the leaf that just adds 0 for each leaf
     * @param comp the comparator
     * @param color the color
     * @return the array list with 0 in it.
     */
    public ArrayList<Integer> visitEmpty(Comparator<? super K> comp,
            String color) {
        ArrayList<Integer> pathsList = new ArrayList<Integer>();
        pathsList.add(0);
        return pathsList;
    }

    /**
     * method for the node that goes through each possible path and adds their
     * lengths to an array list.  It backtracks throughout the tree to reach 
     * each empty node and add up the lengths.
     * @param color the color
     * @param comp the comparator
     * @param k the key
     * @param v the value
     * @param left the left KVMap
     * @param right the right KVMap
     * @return the arrayList of all different path lengths from the node
     */
    public ArrayList<Integer> visitNode(String color, Comparator<K> comp,
            K k, V v, KVMap<K, V> left, KVMap<K, V> right) {

        // go through the left first
        ArrayList<Integer> pathsList = left.acceptRBT(this);
        // then go through the right and combine with the left
        pathsList.addAll(right.acceptRBT(this));

        //set x to 0 to start off
        int x = 0;
        while (x != pathsList.size()) {
            //set at position x the number that the position of x is + 1
            pathsList.set(x, pathsList.get(x) + 1);
            //then increment x 
            x += 1;
        }
        return pathsList;
    }
}