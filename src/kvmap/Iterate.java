package kvmap;




import java.util.*;

/**
 * @author Jarred Lien
 * @version Assignment 4
 * class that represents an Iterator to use in the for each loops
 * @param <K> the key to iterate through
 */
public class Iterate<K> implements Iterator<K> {
    /** comparator to use for sorting */
    Comparator<K> comp;
    /** array list to iterate through */
    private ArrayList<K> klist;


    /**
     * constructor that just takes in an array list
     * @param k the array list of keys
     */
    Iterate(ArrayList<K> k) {
        this.klist = k;
    }

    /**
     * constructor with the comparator
     * @param comp is the comparator
     * @param klist is the array list of keys
     */
    Iterate(Comparator<K> comp, ArrayList<K> klist) {
        this.comp = comp;
        this.klist = this.sortKlist(comp, klist);
    }

    /**
     * overridden method that checks if a next element exist in the collection?
     * @return true if there is a next element in the collection
     */
    public boolean hasNext() {
        return klist.size() >= 1;
    }

    /**
     * gets the next element in the collection
     * @return the next element if there is one, otherwise throw exception
     */
    public K next() {
        if (this.hasNext()) {
            return this.klist.remove(0);
        }
        else {
            throw new NoSuchElementException("there is no next in this");

        }
    }

    /**
     * removes an element from the collection.
     * @throw an exception because it is not needed here
     */
    public void remove() {
        throw new UnsupportedOperationException("remove is not "
                + "supported in this");
    }


    /**
     * method that sorts the given array list
     * @param klizzle the given array list to sort
     * @param c the comparator to use for sorting
     * @return the array list after it has been sorted
     */
    ArrayList<K> sortKlist(Comparator<K> c, ArrayList<K> klizzle) {
        Collections.sort(klizzle, c);
        return klizzle;
    }

}
