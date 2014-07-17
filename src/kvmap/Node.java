package kvmap;

import java.util.*;

/**
 * 
 * @author Jarred Lien
 * @version Assignment 5
 * Subclass of KVTree that represents a non-empty Node in a BST data structure
 * @param <K> the key
 * @param <V> the value
 */
public class Node<K, V> extends KVTree<K, V> {
    /** color is either red or black */
    private String color;
    /** comparator to use in sorting this BST */
    private Comparator<K> comp;
    /** the key in this Node */
    private K key;
    /** the value in this Node */
    private V value;
    /** the left subTree of this Node */
    private KVTree<K, V> kvmLeft;
    /** the right subTree of this Node */
    private KVTree<K, V> kvmRight;
    /** the size of this Tree */
    private int size;

    /**
     * default constructor for this Node
     * @param color the color of this Node
     * @param c the comparator
     * @param k the key
     * @param v the value
     * @param kL the left subTree
     * @param kR the right subTree
     */
    Node(String color, Comparator<K> c, K k, V v, 
            KVTree<K, V> kL, KVTree<K, V> kR) {

        this.color = color;
        this.comp = c;
        this.key = k;
        this.value = v;
        this.kvmLeft = kL;
        this.kvmRight = kR;
        // gets the size right away for performance efficiency
        this.size = 1 + this.kvmLeft.size() + this.kvmRight.size();
    }

    /**
     * Helper Method for Assign so that the whole tree can be re-created and
     * then balanced so that when the Assign method gets this, it can just turn
     * the root node into black.
     * @param k the key
     * @param v the value
     * @return a new balanced tree.
     */
    KVTree<K, V> insert(K k, V v) {
        if (this.comp.compare(this.key, k) < 0) {
            return new Node<K, V>(returnColor(), this.comp, 
                    returnKey(), returnValue(), this.kvmLeft, 
                    this.kvmRight.insert(k, v)).balanceTree();
        }
        if (this.comp.compare(this.key, k) > 0)  {
            return new Node<K, V>(returnColor(), this.comp,
                    returnKey(), returnValue(), 
                    this.kvmLeft.insert(k, v), 
                    this.kvmRight).balanceTree();
        }
        else {
            return new Node<K, V>(this.color, this.comp, this.key, v, 
                    this.kvmLeft, this.kvmRight);
        }
    }

    /**
     * method that checks to see if this is empty
     * @return false because this is a nonEmpty BST
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * method that gets the size of this
     * @return calls the constructor's size
     */
    public int size() {
        return this.size;
    }

    /**
     * method that checks to see if the given key is in this
     * @param k the key being checked for
     * @return true if the given key is this key or in the left or the right
     */
    public boolean containsKey(K k) {
        if (comp.compare(this.key, k) == 0) {
            return true;
        }
        if (comp.compare(this.key, k) > 0) {
            return this.kvmLeft.containsKey(k);
        }
        else {
            return this.kvmRight.containsKey(k);
        }
    }

    /**
     * method that checks to see if the given value is in this
     * @param v the value being checked for
     * @return true if this value equals the given one or the left or right
     * recursion contains it
     */
    public boolean containsValue(V v) {
        if (this.value.equals(v)) {
            return true;
        }
        else { 
            return this.kvmLeft.containsValue(v) ||
                    this.kvmRight.containsValue(v);
        }
    }

    /**
     * method that gets the key in this (if it exists)
     * @param k the key to get
     * @return the value at the given key if it exists
     */
    public V get(K k) {
        if (comp.compare(this.key, k) == 0) {
            return this.value;
        }
        if (comp.compare(this.key, k) > 0) {
            return this.kvmLeft.get(k);
        }
        else {
            return this.kvmRight.get(k);
        }
    }


    /**
     * method that gets all of the keys from the BST
     * @param alist an arrayList to put the keys into
     * @return an arrayList of all of the keys in this BST
     */
    ArrayList<K> getAllKeys(ArrayList<K> alist) {

        alist = new ArrayList<K>();
        // The empty arrayList for the left tree
        ArrayList<K> lList = new ArrayList<K>();
        // The empty arrayList for the right tree
        ArrayList<K> rList = new ArrayList<K>();

        HashSet<K> set = new HashSet<K>();

        set.add(this.key);
        set.addAll(kvmLeft.getAllKeys(lList));
        set.addAll(kvmRight.getAllKeys(rList));

        alist.addAll(set);

        return alist;

    }

    /**
     * Method that turns this node into a black one if it isn't one already
     * @return this or this changed to black
     */
    KVTree<K, V> blackRoot() {
        if (this.colorBlack()) {
            return this;
        }
        else {
            return new Node<K, V>("black", this.comp, this.key, this.value,
                    this.kvmLeft, this.kvmRight);
        }
    }

    /**
     * balance the tree if it is in one of the 4 possible cases that it
     * could be in when a new node has been inserted into it.
     * @return a select helper method that does the balancing
     */
    KVTree<K, V> balanceTree() {
        // If the node gets inserted into the left node's left node
        if ((!this.returnLeft().colorBlack()) &&
                (!this.returnLeft().returnLeft().colorBlack())) {
            return leftLeft();
        }
        // If the node gets inserted into the left node's right node
        if ((!this.returnLeft().colorBlack()) &&
                (!this.returnLeft().returnRight().colorBlack())) {
            return leftRight();
        }
        // If the node gets inserted into the right node's left node
        if ((!this.returnRight().colorBlack()) &&
                (!this.returnRight().returnLeft().colorBlack())) {
            return rightLeft();
        }       
        // If the node gets inserted into the right node's right node
        if ((!this.returnRight().colorBlack()) &&
                (!this.returnRight().returnRight().colorBlack())) {
            return rightRight();
        }
        else {
            // If it is not one of the 4 above cases, just return this
            return this;
        }
    }

    /**
     * Tree Possibility 1 where the node gets added to the left node's left
     * @return a new balanced Tree
     */
    KVTree<K, V> leftLeft() {
        KVTree<K, V> a = this.returnLeft().returnLeft().returnLeft();
        KVTree<K, V> b = this.returnLeft().returnLeft().returnRight();
        KVTree<K, V> c = this.returnLeft().returnRight();
        KVTree<K, V> d = this.returnRight();

        KVTree<K, V> x = this.returnLeft().returnLeft();
        KVTree<K, V> y = this.returnLeft();
        KVTree<K, V> z = this;

        KVTree<K, V> newLeft = new Node<K, V>("black", 
                this.comp, x.returnKey(), x.returnValue(), a, b);
        KVTree<K, V> newRight = new Node<K, V>("black", 
                this.comp, z.returnKey(), z.returnValue(), c, d);
        KVTree<K, V> newTree = new Node<K, V>("red", 
                this.comp, y.returnKey(), y.returnValue(), newLeft, newRight);

        return newTree;


    }

    /**
     * Tree Possibility 2 where the node gets added to the left node's right
     * @return a new balanced Tree
     */
    KVTree<K, V> leftRight() {
        KVTree<K, V> a = this.returnLeft().returnLeft();
        KVTree<K, V> b = this.returnLeft().returnRight().returnLeft();
        KVTree<K, V> c = this.returnLeft().returnRight().returnRight();
        KVTree<K, V> d = this.returnRight();

        KVTree<K, V> x = this.returnLeft();
        KVTree<K, V> y = this.returnLeft().returnRight();
        KVTree<K, V> z = this;

        KVTree<K, V> newLeft = new Node<K, V>("black", 
                this.comp, x.returnKey(), x.returnValue(), a, b);
        KVTree<K, V> newRight = new Node<K, V>("black", 
                this.comp, z.returnKey(), z.returnValue(), c, d);
        KVTree<K, V> newTree = new Node<K, V>("red", 
                this.comp, y.returnKey(), y.returnValue(), newLeft, newRight);

        return newTree;
    }

    /**
     * Tree Possibility 3 where the node gets added to the right node's left
     * @return a new balanced tree
     */
    KVTree<K, V> rightLeft() {
        KVTree<K, V> a = this.returnLeft();
        KVTree<K, V> b = this.returnRight().returnLeft().returnLeft();
        KVTree<K, V> c = this.returnRight().returnLeft().returnRight();
        KVTree<K, V> d = this.returnRight().returnRight();

        KVTree<K, V> x = this;
        KVTree<K, V> y = this.returnRight().returnLeft();
        KVTree<K, V> z = this.returnRight();

        KVTree<K, V> newLeft = new Node<K, V>("black",
                this.comp, x.returnKey(), x.returnValue(), a, b);
        KVTree<K, V> newRight = new Node<K, V>("black", 
                this.comp, z.returnKey(), z.returnValue(), c, d);
        KVTree<K, V> newTree = new Node<K, V>("red", 
                this.comp, y.returnKey(), y.returnValue(), newLeft, newRight);

        return newTree;
    }


    /**
     * Tree Possibility 4 where the node gets added to the right node's right
     * @return a new balanced Tree
     */
    KVTree<K, V> rightRight() {
        KVTree<K, V> a = this.returnLeft();
        KVTree<K, V> b = this.returnRight().returnLeft();
        KVTree<K, V> c = this.returnRight().returnRight().returnLeft();
        KVTree<K, V> d = this.returnRight().returnRight().returnRight();

        KVTree<K, V> x = this;
        KVTree<K, V> y = this.returnRight();
        KVTree<K, V> z = this.returnRight().returnRight();

        KVTree<K, V> newLeft = new Node<K, V>("black", 
                this.comp, x.returnKey(), x.returnValue(), a, b);
        KVTree<K, V> newRight = new Node<K, V>("black", 
                this.comp, z.returnKey(), z.returnValue(), c, d);
        KVTree<K, V> newTree = new Node<K, V>("red", 
                this.comp, y.returnKey(), y.returnValue(), newLeft, newRight);

        return newTree;
    }


    /**
     * Accessor method for deep recursion
     * @return this color
     */
    String returnColor() {
        return this.color;
    }

    /**
     * Accessor method for deep recursion
     * @return this value
     */
    V returnValue() {
        return this.value;
    }

    /**
     * Accessor method for deep recursion
     * @return this key
     */
    K returnKey() {
        return this.key;
    }

    /**
     * Accessor method for deep recursion
     * @return the left tree in this
     */
    KVTree<K, V> returnLeft() {
        return this.kvmLeft;
    }

    /**
     * Accessor method for deep recursion
     * @return the right key in this
     */
    KVTree<K, V> returnRight() {
        return this.kvmRight;
    }

    /**
     * Method to check if the node is black or red
     * @return true if this color is black
     */
    boolean colorBlack() {
        return this.returnColor().equals("black");
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
            KVMap<K, V> node2 = ((KVMap<K, V>) obj);

            // for each loop that goes through every key in this
            // to make sure that the given object has the key and that
            // the value at the key is the same as well
            for (K k: this) {
                if (!(node2.containsKey(k))) {
                    return false;
                }
                if (!this.get(k).equals(node2.get(k))) {
                    return false;
                }
            }
            // if the object makes it out of the for each loop,
            // then the last thing to do is to check if its size is
            // the same as this size
            return this.size() == node2.size();
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
     * method that allows the given visitor to go through this
     * @param rbv the visitor for only red-black
     * @param <R> the return type of the visitor
     * @return the given visitor visiting this node
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> rbv) {

        return rbv.visitNode(this.color, this.comp, this.key, 
                this.value, this.kvmLeft, this.kvmRight);
    }

    /**
     * method that allows the given visitor to go through this node,
     * as well as the left and right trees within this.
     * @param visitor the given visitor
     * @return a new node of this, as well as the left and right accepting
     * the given visitor
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> visitor) {

        KVTree<K, V> left = (KVTree<K, V>) this.kvmLeft.accept(visitor);
        KVTree<K, V> right = (KVTree<K, V>) this.kvmRight.accept(visitor);

        return new Node<K, V>(this.color, this.comp, this.key, 
                visitor.visit(this.key, this.get(this.key)), left, right);
    }


}
