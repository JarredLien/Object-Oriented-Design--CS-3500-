package kvmap;




import java.util.*;
/**
 * @author Jarred Lien
 * @version Assignment 4
 * class to represent an Empty Map in a list data structure form
 * @param <K> the key
 * @param <V> the value
 */
public class EmptyMap<K, V> extends KVList<K, V> {
    /**
     * empty constructor
     */
    EmptyMap() {
        /** empty constructor */
    }

    /**
     * method that checks if this is empty
     * @return true because this is empty
     */
    public boolean isEmpty() {
        return true;
    }


    /**
     * method that gets the size of this
     * @return 0 because this is empty
     */
    public int size() {
        return 0;
    }


    /**
     * method that checks to see if the given key is in this
     * @param k the key
     * @return false because this is empty
     */
    public boolean containsKey(K k) {
        return false;
    }

    /**
     * method that checks to see if this contains the given value
     * @param v the value
     * @return false because this is empty
     */
    public boolean containsValue(V v) {
        return false;
    }

    /**
     * Helper method for containsValue that skips over the given key
     * @param k the key
     * @return an emptyMap because there is no key to skip in this
     */
    KVList<K, V> skipperK(K k) {
        return this;
    }

    /**
     * method that gets the value specified at the given key
     * @param k the key
     * @return an exception because there is no key to get a value from in this
     */
    public V get(K k) {
        throw new RuntimeException("no key in empty");
    }



    /**
     * overridden equals method that checks if the given object
     * is an instance of this and that it is empty
     * @param obj the object being checked for
     * @return true if the given object is an emptyMap.
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj instanceof KVMap) {
            return ((KVMap<K, V>) obj).isEmpty();
        }
        else {
            return false;
        }
    }


    /**
     * method that gets all of the keys in this
     * and puts them into an array list
     * @param alist the array list
     * @return the array list because 
     * there are no keys in this to put in it
     */
    ArrayList<K> getAllKeys(ArrayList<K> alist) {
        return alist;
    }


    /**
     * overridden method that returns a hashCode for this
     * @return 0 because this is empty
     */
    public int hashCode() {
        return -31;
    }

    /**
     * Method that takes in a client's visitor and allows it to alter this
     * @param kvm the client visitor
     * @return this because this is empty and there is nothing to change in it
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> kvm) {
        return this;
    }


}






