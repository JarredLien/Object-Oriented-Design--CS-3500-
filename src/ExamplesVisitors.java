
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import tester.Tester;
import kvmap.IntComp;
import kvmap.KVMap;

/**
 * Examples Class for testing the Function Objects
 * @author Jarred Lien
 * @version Assignment 8
 */
public class ExamplesVisitors {

    private BlackHeight<Integer, Integer> bh = 
            new BlackHeight<Integer, Integer>();
    private GCD gcd = new GCD();
    private PathLengths<Integer, Integer> pl = 
            new PathLengths<Integer, Integer>();
    private StringWithNumber swn = new StringWithNumber();

    private KVMap<Integer, Integer> empty = KVMap.emptyMap();
    private KVMap<Integer, Integer> list1 = empty.assign(500, 10);
    private KVMap<Integer, Integer> list2 = list1.assign(250, 20);

    private KVMap<Integer, Integer> list19 = empty.assign(250, 10);
    private KVMap<Integer, Integer> list20 = list19.assign(500, 10);

    private KVMap<Integer, String> empty2 = KVMap.emptyMap();
    private KVMap<Integer, String> l1 = empty2.assign(50, "A");
    private KVMap<Integer, String> l2 = l1.assign(60, "B");
    private KVMap<Integer, String> l19 = empty2.assign(60, "B 60");
    private KVMap<Integer, String> l20 = l19.assign(50, "A 50");


    private Comparator<Integer> comp = new IntComp();
    private KVMap<Integer, Integer> leaf = KVMap.emptyMap(comp);

    private KVMap<Integer, Integer> n1 = leaf.assign(500, 10);
    private KVMap<Integer, Integer> n2 = n1.assign(250, 20);
    private KVMap<Integer, Integer> n3 = n2.assign(750, 30);
    private KVMap<Integer, Integer> n4 = n3.assign(125, 5);
    private KVMap<Integer, Integer> n5 = n4.assign(600, 25);

    private KVMap<Integer, Integer> n19 = leaf.assign(500, 10);
    private KVMap<Integer, Integer> n20 = n19.assign(250, 10); 

    private KVMap<Integer, String> leaf2 = KVMap.emptyMap(comp);
    private KVMap<Integer, String> n10 = leaf2.assign(50, "A");
    private KVMap<Integer, String> n11 = n10.assign(60, "B");
    private KVMap<Integer, String> n13 = leaf2.assign(50,  "A 50");
    private KVMap<Integer, String> n14 = n13.assign(60, "B 60");

    /**
     * Tests the blackHeight function object
     * @param t the tester
     */
    public void testBlackHeight(Tester t) {
        t.checkExpect(leaf.acceptRBT(bh), 0);
        t.checkExpect(n1.acceptRBT(bh), 1);
        t.checkExpect(n2.acceptRBT(bh), 1);
        t.checkExpect(n3.acceptRBT(bh), 1);
        t.checkExpect(n4.acceptRBT(bh), 2);
    }



    /**
     * Tests the GCD function object
     * @param t the tester
     */
    public void testGCD(Tester t) {
        //KVMap testing
        t.checkExpect(empty.accept(gcd), empty);
        t.checkExpect(list1.accept(gcd), list1);
        t.checkExpect(list2.accept(gcd), list20);

        //RBT testing
        t.checkExpect(leaf.accept(gcd), leaf);
        t.checkExpect(n1.accept(gcd), n1);
        t.checkExpect(n2.accept(gcd), n20);
    }

    /**
     * Tests the StringWithNumber function object
     * @param t the tester
     */
    public void testStringWithNumber(Tester t) {
        //KVMap testing
        t.checkExpect(empty2.accept(swn), empty2);
        t.checkExpect(l1.accept(swn), empty2.assign(50, "A 50"));
        t.checkExpect(l2.accept(swn), l20);

        //RBT Testing
        t.checkExpect(leaf2.accept(swn), leaf2);
        t.checkExpect(n10.accept(swn), leaf2.assign(50, "A 50"));
        t.checkExpect(n11.accept(swn), n14);
    }

    /**
     * Tests the path lengths function object
     * @param t the tester
     */
    public void testPathLengths(Tester t) {
        t.checkExpect(n1.acceptRBT(pl),
                new ArrayList<Integer>(Arrays.asList(1, 1)));
        t.checkExpect(n2.acceptRBT(pl),
                new ArrayList<Integer>(Arrays.asList(2, 2, 1)));
        t.checkExpect(n5.acceptRBT(pl),
                new ArrayList<Integer>(Arrays.asList(2, 2, 3, 3, 3, 3)));
    }


    /**
     * test to see if a list like structure throws an unsupported exception
     * @param t tester t
     */
    public void testRBTVisitorException(Tester t) {
        try {
            t.checkExpect(list1.acceptRBT(pl), "A");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


}







