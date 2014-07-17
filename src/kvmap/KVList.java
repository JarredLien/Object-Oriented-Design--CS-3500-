package kvmap;

/**
 * 
 * @author Jarred Lien
 * @version Assignment 5
 * abstract class that represents a list structured KVMap
 * @param <K> the key
 * @param <V> the value
 */
public abstract class KVList<K, V> extends KVMap<K, V> {

    /**
     * Method that assigns the key and value into the AList
     * @param k the key being assigned
     * @param v the value being assigned
     * @return a new AList with the given key and value within it
     */
    public KVList<K, V> assign(K k, V v) {
        return new Assign<K, V>(this, k, v);
    }

    /**
     * Abstract helper method that skips over a key for containsValue
     * @param k the key
     * @return the AList with the key skipped over
     */
    abstract KVList<K, V> skipperK(K k);

    /**
     * Abstract method that allows the given visitor to alter this list
     * @param kvm the client visitor
     * @return a kvmap that has been altered by the client
     */
    public abstract KVMap<K, V> accept(KVMapVisitor<K, V> kvm);

    /**
     * Method that takes in a visitor for trees only
     * @param rbv the tree visitor
     * @param <R> the return type of the visitor
     * @return an exception because this is not a tree
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> rbv) {
        throw new UnsupportedOperationException("DOESN'T SUPPORT A LIST");
    }





}









