package kvmap;


/**
 * 
 * @author Jarred Lien
 * @version Assignment 5
 * Abstract class that represents a Map in a Binary Search Tree Data Structure
 * @param <K> the key
 * @param <V> the value
 */
public abstract class KVTree<K, V> extends KVMap<K, V> {

    /**
     * Method that assigns the given key and value into this.
     * It calls Insert which does the actual assigning, but then
     * when insert is done and balanced, this changes the root to black
     * @param k the key
     * @param v the value
     * @return a new balanced Tree
     */
    public KVTree<K, V> assign(K k, V v) {
        return this.insert(k, v).blackRoot();
    }

    /**
     * Abstract method that inserts into this tree
     * @param k the key
     * @param v the value
     * @return a new balanced Tree with the key and value inserted
     */
    abstract KVTree<K, V> insert(K k, V v);

    /**
     * Abstract Accessor method for deep recursion
     * @return the color in this (either red or black)
     */
    abstract String returnColor();

    /**
     * Abstract Accessor method for deep recursion
     * @return the value in this 
     */
    abstract V returnValue();

    /**
     * Abstract Accessor method for deep recursion
     * @return the key in this
     */
    abstract K returnKey();

    /**
     * Abstract Accessor method for deep recursion
     * @return the left tree in this
     */
    abstract KVTree<K, V> returnLeft();

    /**
     * Abstract Accessor method for deep recursion
     * @return the right tree in this
     */
    abstract KVTree<K, V> returnRight();

    /**
     * Abstract method that balances the Tree if the key and value
     * are inserted into the left node's left node.
     * @return a balanced tree
     */
    abstract KVTree<K, V> leftLeft();

    /**
     * Abstract method that balances the Tree if the key and value
     * are inserted into the left node's right node.
     * @return a balanced tree
     */
    abstract KVTree<K, V> leftRight();

    /**
     * Abstract method that balances the Tree if the key and value
     * are inserted into the right node's left node.
     * @return a balanced tree
     */
    abstract KVTree<K, V> rightLeft();

    /**
     * Abstract method that balances the Tree if the key and value
     * are inserted into the right node's right node.
     * @return a balanced tree
     */
    abstract KVTree<K, V> rightRight();

    /**
     * Abstract method that balances the Tree
     * @return a helper method that does that balancing if needed
     */
    abstract KVTree<K, V> balanceTree();

    /**
     * Abstract method that checks to see if the color is black
     * @return true if it is black
     */
    abstract boolean colorBlack();

    /**
     * Abstract method that turns a Node into a black one
     * @return the same Tree but black if it isn't already
     */
    abstract KVTree<K, V> blackRoot();

    /**
     * Abstract method that takes in a visitor for trees
     * @param rbt the client visitor for trees
     * @param <R> the return type of the visitor
     * @return the type that the client visitor returns
     */
    public abstract <R> R acceptRBT(RBTVisitor<K, V, R> rbt);

    /**
     * Abstract method that takes in a client visitor to alter this
     * @param kvr the client visitor
     * @return a kvmap that has been altered by the visitor
     */
    public abstract KVMap<K, V> accept(KVMapVisitor<K, V> kvr);
}
