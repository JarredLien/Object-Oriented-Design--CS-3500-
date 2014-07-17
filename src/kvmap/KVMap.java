package kvmap;




import java.util.*;

/**
 * @author Jarred Lien
 * @version Assignment 4
 * Abstract class to represent a Map data structure
 * @param <K> the key
 * @param <V> the value
 */
public abstract class KVMap<K, V> implements Iterable<K> {

    /**
     * static method that creates a new empty map
     * @param <K> the key
     * @param <V> the value
     * @return a new empty map
     */
    public static <K, V> KVList<K, V> emptyMap() {
        return new EmptyMap<K, V>();
    }

    /**
     * static method that creates a new empty map
     * @param c the comparator
     * @param <K> the key
     * @param <V> the value
     * @return a new empty map
     */
    public static <K, V> KVTree<K, V> emptyMap(Comparator<K> c) {
        return new Leaf<K, V>("black", c);
    }

    /**
     * method that creates a nonEmpty map
     * @param key the key to give the assign
     * @param val the value to give to the assign
     * @return a new non empty map
     */
    public abstract KVMap<K, V> assign(K key, V val);


    /**
     * abstract method that checks to see if a map is empty
     * @return true if the map is empty
     */
    public abstract boolean isEmpty();

    /**
     * abstract method that gets the size
     * @return the size of the map
     */
    public abstract int size();

    /**
     * abstract method that checks to see if the given key is in the map
     * @param k the key to check for
     * @return true if the given key is in the map
     */
    public abstract boolean containsKey(K k);

    /**
     * abstract method that checks to see if the given value is in the map
     * @param v the value being checked for
     * @return true if the given value is in the map
     */
    public abstract boolean containsValue(V v);

    /**
     * abstract method that gets the value at the given key
     * @param k the key to get the value from
     * @return the value that is associated with the key
     */
    public abstract V get(K k);


    /**
     * abstract overridden equals method that checks for exact equality
     * @param obj the given object to check
     * @return true if two maps are exactly the same 
     */
    public abstract boolean equals(Object obj);

    /**
     * abstract overridden hashCode that creates a unique hashCode for a map
     * @return a unique hashCode for the map
     */
    public abstract int hashCode();


    /**
     * overridden toString that creates a 
     * better representation of the map's data
     * @return a string that tells the size of the map
     */
    public String toString() {
        return "{...[There are " + this.size() 
                + " unique key(s) mapped to "
                + "value(s) in this KVMap]...}";
    }


    /**
     * abstract method for the iterator that takes all of the keys from
     * this map and puts them into an ArrayList
     * @param alist the array list to put the keys into
     * @return an array list of keys
     */
    abstract ArrayList<K> getAllKeys(ArrayList<K> alist);


    /**
     * method that creates an iterator
     * @return a new iterator
     */
    public Iterator<K> iterator() {
        ArrayList<K> klist = new ArrayList<K>();
        return new Iterate<K>(getAllKeys(klist));
    }

    /**
     * method that creates an iterator with a comparator
     * @param comp the comparator
     * @return a new iterator
     */
    public Iterator<K> iterator(Comparator<K> comp) {
        ArrayList<K> klist = new ArrayList<K>();
        return new Iterate<K>(comp, this.getAllKeys(klist));
    }

    /**
     * Abstract method that accepts the given visitor
     * @param kvr the given visitor
     * @return a KVMap that has been visited.
     */
    public abstract KVMap<K, V> accept(KVMapVisitor<K, V> kvr);

    /**
     * Abstract method that accepts the given visitor for only trees
     * @param rbv the given visitor
     * @param <R> the return type of the visitor
     * @return the return type that the visitor specifies
     */
    public abstract <R> R acceptRBT(RBTVisitor<K, V, R> rbv);

}











