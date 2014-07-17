package kvmap;


import java.util.*;
/**
 * @author Jarred Lien
 * @version Assignment 4
 * class that represents a non-empty map in a list data structure form
 * @param <K> the key
 * @param <V> the value
 */
public class Assign<K, V> extends KVList<K, V> {
    /** another map to use for recursion (the rest) */
    private KVList<K, V> kvm2;
    /** the key in this */
    private K key;
    /** the value in this */
    private V val;

    /**
     * Constructs a new non empty Map
     * @param kvm a KVMap to store in this
     * @param key the key to put in this
     * @param val the value to put in this
     */
    Assign(KVList<K, V> kvm, K key, V val) {
        this.kvm2 = kvm;
        this.key = key;
        this.val = val;
    }

    /**
     * method that checks to see if this is empty
     * @return false because this is a non empty map
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * method that gets the size of this
     * @return the size of this map without counting duplicate keys
     */
    public int size() {
        if (kvm2.containsKey(this.key)) {
            return this.kvm2.size();
        }
        else {
            return 1 + this.kvm2.size();
        }
    }

    /**
     * method that checks to see if the given key is contained in this
     * @param k the key being checked for
     * @return true if the key is in this or in the map that is in this
     */
    public boolean containsKey(K k) {
        return this.key.equals(k) || this.kvm2.containsKey(k);
    }


    /**
     * method that checks to see if the given value is contained in this
     * @param v the value being checked for
     * @return true if the given value is in this
     */
    public boolean containsValue(V v) {
        return (get(key).equals(v)) || kvm2.skipperK(key).containsValue(v);
    }

    /**
     * Helper method for containsValue that skips over a key
     * @param k the key to skip over 
     * @return a KVMap with the key skipped over
     */
    KVList<K, V> skipperK(K k) {
        if (!containsKey(k)) {
            return kvm2.skipperK(k).assign(key, val);
        }
        return kvm2.skipperK(k);
    }

    /**
     * method that gets the value at the given key
     * @param k the key to find the value in
     * @return the value if it is found
     */
    public V get(K k) {
        if (this.key.equals(k)) {
            return this.val;
        }
        else {
            return this.kvm2.get(k);
        }
    }

    /**
     * overridden equals method that checks for exact equality between this
     * and the given object
     * @param obj the object being checked for
     * @return true if the given object is the same as this
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof KVMap)) {
            return false;
        }
        if (((KVMap<K, V>) obj).isEmpty()) {
            return false;
        }
        else {
            KVMap<K, V> map2 = ((KVMap<K, V>) obj);

            // for each loop that goes through every key in this
            // to make sure that the given object has the key and that
            // the value at the key is the same as well
            for (K k: this) {
                if (!(map2.containsKey(k))) {
                    return false;
                }
                if (!this.get(k).equals(map2.get(k))) {
                    return false;
                }
            }
            // if the object makes it out of the for each loop,
            // then the last thing to do is to check if its size is
            // the same as this size
            return this.size() == map2.size();
        }
    }


    /**
     * gets the key in this and the rest of them by recurring
     * @param alist the array list to put the keys into 
     * @return an array list with all of the keys inside of it
     */
    ArrayList<K> getAllKeys(ArrayList<K> alist) {
        if (!kvm2.containsKey(this.key)) {
            alist.add(key);
            return kvm2.getAllKeys(alist);
        }
        else {
            return kvm2.getAllKeys(alist);
        }
    }


    /**
     * overridden hashCode method
     * @return a unique hashCode for this
     */
    public int hashCode() {
        // set up the initial hashCode to be 1.
        int finalHash = 31;

        for (K k : this) {
            finalHash = (finalHash - k.hashCode() -
                    get(k).hashCode() * 19) % 11;
        }
        return finalHash;
    }

    /**
     * Method that takes in the given visitor and lets it use its
     * visit method on every value in this.
     * @param visitor the given client visitor
     * @return the new KVMap that has been altered by the visitor
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> visitor) {
        KVMap<K, V> m2 = KVMap.emptyMap();
        for (K k : this) {
            V v = visitor.visit(k, this.get(k));
            m2 = m2.assign(k, v);
        }
        return m2;
    }



}




