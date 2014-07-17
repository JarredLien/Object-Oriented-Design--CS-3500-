package kvmap;

import java.util.*;

/**
 * @author Jarred Lien
 * @version Assignment 5
 * Subclass of a KVTree that represents an empty Node in a BST data structure
 * @param <K> the key
 * @param <V> the value
 */
public class Leaf<K, V> extends KVTree<K, V> {
    /** Comparator to use for the BST */
    private Comparator<K> comp;

    /**
     * Constructor for the empty BST (leaf)
     * @param color the color of this leaf (always black)
     * @param comp the comparator
     */
    Leaf(String color, Comparator<K> comp) {
        this.comp = comp;
    }

    /**
     * inserts the key and value by creating a new tree from this
     * @param k the key
     * @param v the value
     * @return a new tree that may not be balanced yet
     */
    KVTree<K, V> insert(K k, V v) {
        return new Node<K, V>("red", this.comp, k, v, this, this);
    }

    /**
     * method that checks to see if this is empty
     * @return true because this is an empty Node
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
     * @param k the key to check for
     * @return false because this is empty
     */
    public boolean containsKey(K k) {
        return false;
    }

    /**
     * method that checks to see if the given value is in this
     * @param v the value to check for
     * @return false because this is empty
     */
    public boolean containsValue(V v) {
        return false;
    }

    /**
     * method that gets the value at the specified key (if it exists)
     * @param k the key to get the value from
     * @return an exception because there is no value in this to get
     */
    public V get(K k) {
        throw new RuntimeException("no key in a leaf");
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
     * Accessor method that returns the color of a Tree
     * @return black because this is always black
     */
    String returnColor() {
        return "black";
    }

    /**
     * Accessor method that returns the value in this
     * @return an exception because this is a Leaf
     */
    V returnValue() {
        throw new RuntimeException("There is nothing in a Leaf");
    }

    /**
     * Accessor method that returns the key in this
     * @return an exception because this is a Leaf
     * 
     */
    K returnKey() {
        throw new RuntimeException("There is nothing in a Leaf");
    }

    /**
     * Accessor method that returns the left Tree in this
     * @return an exception because this is a Leaf
     */
    KVTree<K, V> returnLeft() {
        throw new RuntimeException("This is the end of the Tree");
    }

    /**
     * Accessor method that returns the Right Tree in this
     * @return an exception because this is a Leaf
     * 
     */
    KVTree<K, V> returnRight() {
        throw new RuntimeException("This is the end of the Tree");
    }

    /**
     * Helper method for balancing the tree
     * @return this Leaf is always balanced 
     */
    KVTree<K, V> leftLeft() {
        return this;
    }

    /**
     * Helper method for balancing the tree
     * @return this Leaf is always balanced 
     */
    KVTree<K, V> leftRight() {
        return this;
    }

    /**
     * Helper method for balancing the tree
     * @return this Leaf is always balanced 
     */
    KVTree<K, V> rightLeft() {
        return this;
    }

    /**
     * Helper method for balancing the tree
     * @return this Leaf is always balanced 
     */
    KVTree<K, V> rightRight() {
        return this;
    }

    /**
     * Method that checks to see if this color is black
     * @return true because this is always black
     */
    boolean colorBlack() {
        return true;
    }

    /**
     * Method that balances this tree
     * @return this because a Leaf is always balanced
     */
    KVTree<K, V> balanceTree() {
        return this;
    }

    /**
     * Makes sure that the root is black and same with every Leaf
     * @return this because this is always black
     */
    KVTree<K, V> blackRoot() {
        return this;
    }


    /**
     * overridden equals method that checks if the given object
     * is an instance of this and that it is empty
     * @param obj the object being checked for
     * @return true if the given object is an emptyMap.
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        return (obj instanceof KVMap) &&
                ((KVMap<K, V>) obj).isEmpty();
    }

    /**
     * overridden method that returns a hashCode for this
     * @return 0 because this is empty
     */
    public int hashCode() {
        return -31;
    }

    /**
     * Method that takes in a visitor for trees only
     * @param rbt the tree visitor
     * @param <R> the return type of the visitor
     * @return the visitor's empty method for this.
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> rbt) {
        return rbt.visitEmpty(this.comp, "black");
    }

    /**
     * Method that takes in a visitor to alter this
     * @param kvr the client visitor
     * @return this because there is nothing to change in this
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> kvr) {
        return this;
    }

}





