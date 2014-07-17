package kvmap;

import java.util.*;

import tester.Tester;

/**
 * @author Jarred Lien
 * @version Assignment 4
 * Examples class that void tests ALists, BSTs, and Red-Black Trees
 */
public class ExamplesKVMap {
    
    private IntComp compareByInt;

    private Comparator<Integer> iComp = new IntComp();
    private Comparator<String> sComp = new StringComp();

    private KVMap<Integer, String> kvm00 = KVMap.emptyMap();
    private KVMap<Integer, String> kvm0 = KVMap.emptyMap();


    private KVMap<Integer, String> kvm1 = kvm0.assign(0, "");
    private KVMap<Integer, String> kvm2 = kvm1.assign(1, "A");
    private KVMap<Integer, String> kvm3 = kvm2.assign(2, "B");
    private KVMap<Integer, String> kvm4 = kvm3.assign(3, "C");
    private KVMap<Integer, String> kvm5 = kvm4.assign(4, "D");
    private KVMap<Integer, String> kvm6 = kvm5.assign(5, "E");
    private KVMap<Integer, String> kvm7 = kvm6.assign(5, "F");
    private KVMap<Integer, String> kvm8 = kvm7.assign(5, "G");
    private KVMap<Integer, String> kvm9 = kvm8.assign(5, "E");

    private KVMap<Integer, String> kvm10 = kvm00.assign(2, "B");
    private KVMap<Integer, String> kvm11 = kvm10.assign(1, "A");

    private KVMap<Integer, String> kvm12 = kvm00.assign(1, "A");
    private KVMap<Integer, String> kvm13 = kvm12.assign(2, "B");
    private KVMap<Integer, String> kvm14 = kvm13.assign(1, "C");
    private KVMap<Integer, String> kvm15 = kvm13.assign(20, "Z");


    private ArrayList<Integer> klist = new ArrayList<Integer>();

    private ArrayList<Integer> klist5 = 
            new ArrayList<Integer>(Arrays.asList(4, 3, 2, 1, 0));

    private ArrayList<Integer> klist55 =
            new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));

    private Iterator<Integer> intIter0 = kvm0.iterator();
    private Iterator<Integer> intIter5 = kvm5.iterator();

    private Iterate<Integer> intIter = new Iterate<Integer>(klist);
    private Iterate<Integer> intIter55 = new Iterate<Integer>(klist5);
    private Iterate<Integer> intIter555 = new Iterate<Integer>(klist55);

    private Exception e0 = 
            new NoSuchElementException("there is no next in this");
    private Exception e1 = 
            new UnsupportedOperationException("remove is not "
                    + "supported in this");

    //BST EXAMPLE TO TEST
    private KVMap<Integer, String> bst0 = KVMap.emptyMap(iComp);
    private KVMap<Integer, String> bst1 = bst0.assign(10, "A");
    private KVMap<Integer, String> bst2 = bst1.assign(6, "B");
    private KVMap<Integer, String> bst3 = bst2.assign(14, "C");
    private KVMap<Integer, String> bst4 = bst3.assign(4, "E");
    private KVMap<Integer, String> bst5 = bst4.assign(16, "F");
    private KVMap<Integer, String> bst6 = bst5.assign(8, "G");
    private KVMap<Integer, String> bst7 = bst6.assign(12, "H");

    private KVMap<Integer, String> bst100 = bst0.assign(2, "B");
    private KVMap<Integer, String> bst101 = bst100.assign(3, "C");
    private KVMap<Integer, String> bst102 = bst101.assign(1, "A");

    private KVMap<Integer, String> alist100 = kvm0.assign(3, "C");
    private KVMap<Integer, String> alist101 = alist100.assign(2, "B");
    private KVMap<Integer, String> alist102 = alist101.assign(1, "C");

    private ArrayList<Integer> blist0 = new ArrayList<Integer>();
    private ArrayList<Integer> blist1 =
            new ArrayList<Integer>(Arrays.asList(10));
    private ArrayList<Integer> blist2 =
            new ArrayList<Integer>(Arrays.asList(6, 10));
    private ArrayList<Integer> blist3 =
            new ArrayList<Integer>(Arrays.asList(6, 10, 14));

    private ArrayList<Integer> blist4 =
            new ArrayList<Integer>(Arrays.asList(10, 6));
    private ArrayList<Integer> blist5 =
            new ArrayList<Integer>(Arrays.asList(14, 10, 6));


    // RED-BLACK TREES TO TEST
    private KVTree<Integer, String> rb0 = KVMap.emptyMap(iComp);
    private KVTree<Integer, String> rb00 = KVMap.emptyMap(iComp);

    private KVTree<Integer, String> rb20 = rb00.assign(100, "B");

    private KVTree<Integer, String> rb1 = rb0.assign(100, "A");
    private KVTree<Integer, String> rb2 = rb1.assign(50, "B");
    private KVTree<Integer, String> rb3 = rb2.assign(150, "C");
    private KVTree<Integer, String> rb4 = rb3.assign(25, "D");
    private KVTree<Integer, String> rb5 = rb4.assign(175, "E");
    private KVTree<Integer, String> rb6 = rb5.assign(75, "F");
    private KVTree<Integer, String> rb7 = rb6.assign(125, "G");
    private KVTree<Integer, String> rb8 = rb7.assign(60, "H");
    private KVTree<Integer, String> rb9 = rb8.assign(110, "I");

    private KVTree<Integer, String> n1 = 
            new Node<Integer, String>("red", iComp, 50, "B", rb0, rb0);
    private KVTree<Integer, String> n2 = 
            new Node<Integer, String>("red", iComp, 150, "C", rb0, rb0);
    private KVTree<Integer, String> n3 =
            new Node<Integer, String>("black", iComp, 50, "B", rb0, rb0);
    private KVTree<Integer, String> n4 =
            new Node<Integer, String>("black", iComp, 150, "C", rb0, rb0);

    // To test the left left case
    private KVTree<Integer, String> n50 =
            new Node<Integer, String>("red", iComp, 100, "X", rb0, rb0);
    private KVTree<Integer, String> n51 =
            new Node<Integer, String>("red", iComp, 150, "Y", n50, rb0);
    private KVTree<Integer, String> n52 =
            new Node<Integer, String>("black", iComp, 200, "Z", n51, rb0);

    private KVTree<Integer, String> n500 =
            new Node<Integer, String>("black", iComp, 100, "X", rb0, rb0);
    private KVTree<Integer, String> n501 =
            new Node<Integer, String>("black", iComp, 200, "Z", rb0, rb0);
    private KVTree<Integer, String> n502 =
            new Node<Integer, String>("red", iComp, 150, "Y", n500, n501);
    private KVTree<Integer, String> n5000 =
            n502.blackRoot();

    // To test the left right case
    private KVTree<Integer, String> n100 =
            new Node<Integer, String>("red", iComp, 175, "Y", rb00, rb00);
    private KVTree<Integer, String> n101 =
            new Node<Integer, String>("red", iComp, 150, "X", rb00, n100);
    private KVTree<Integer, String> n102 =
            new Node<Integer, String>("black", iComp, 200, "Z", n101, rb00);

    private KVTree<Integer, String> n1000 =
            new Node<Integer, String>("black", iComp, 150, "X", rb0, rb0);
    private KVTree<Integer, String> n1001 =
            new Node<Integer, String>("black", iComp, 200, "Z", rb0, rb0);
    private KVTree<Integer, String> n1002 =
            new Node<Integer, String>("red", iComp, 175, "Y", n1000, n1001);
    private KVTree<Integer, String> n10000 =
            n1002.blackRoot();

    // To test the right left case
    private KVTree<Integer, String> n200 =
            new Node<Integer, String>("red", iComp, 300, "Y", rb00, rb00);
    private KVTree<Integer, String> n201 =
            new Node<Integer, String>("red", iComp, 400, "Z", n200, rb00);
    private KVTree<Integer, String> n202 =
            new Node<Integer, String>("black", iComp, 200, "X", rb00, n201);

    private KVTree<Integer, String> n2000 =
            new Node<Integer, String>("black", iComp, 200, "X", rb0, rb0);
    private KVTree<Integer, String> n2001 =
            new Node<Integer, String>("black", iComp, 400, "Z", rb0, rb0);
    private KVTree<Integer, String> n2002 =
            new Node<Integer, String>("red", iComp, 300, "Y", n2000, n2001);
    private KVTree<Integer, String> n20000 =
            n2002.blackRoot();

    // To test the right right case
    private KVTree<Integer, String> n300 =
            new Node<Integer, String>("red", iComp, 500, "Z", rb00, rb00);
    private KVTree<Integer, String> n301 =
            new Node<Integer, String>("red", iComp, 400, "Y", rb00, n300);
    private KVTree<Integer, String> n302 =
            new Node<Integer, String>("black", iComp, 200, "X", rb00, n301);

    private KVTree<Integer, String> n3000 =
            new Node<Integer, String>("black", iComp, 200, "X", rb00, rb00);
    private KVTree<Integer, String> n3001 =
            new Node<Integer, String>("black", iComp, 500, "Z", rb00, rb00);
    private KVTree<Integer, String> n3002 =
            new Node<Integer, String>("red", iComp, 400, "Y", n3000, n3001);
    private KVTree<Integer, String> n30000 =
            n3002.blackRoot();
    
 //;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//

    /**
     * tests the creator methods (emptyMap and Assign)
     * @param t the tester
     */
    public void testCreators(Tester t) {
        //ALIST TESTS
        t.checkExpect(KVMap.emptyMap(), kvm0);
        t.checkExpect(kvm0.assign(0, ""), kvm1);

        //BST TESTS
        t.checkExpect(KVMap.emptyMap(iComp), bst0);
        t.checkExpect(bst0.assign(10, "A"), bst1);
        t.checkExpect(bst1.assign(6, "B"), bst2);
        t.checkExpect(bst2.assign(14, "C"), bst3);
    }

    /**
     * tests the isEmpty method
     * @param t the tester
     */
    public void testIsEmpty(Tester t) {
        //ALIST TESTS
        t.checkExpect(kvm0.isEmpty());
        t.checkExpect(!kvm1.isEmpty());

        //BST TEST
        t.checkExpect(bst0.isEmpty());
        t.checkExpect(!bst1.isEmpty());
        t.checkExpect(!bst3.isEmpty());

        //RED-BLACK TREE TESTS
        t.checkExpect(rb0.isEmpty());
        t.checkExpect(!rb1.isEmpty());
    }

    /**
     * tests the size method
     * @param t the tester
     */
    public void testSize(Tester t) {
        //ALIST TESTS
        t.checkExpect(kvm0.size(), 0);
        t.checkExpect(kvm1.size(), 1);
        t.checkExpect(kvm6.size(), 6);
        t.checkExpect(kvm9.size(), 6);

        //BST TESTS
        t.checkExpect(bst0.size(), 0);
        t.checkExpect(bst1.size(), 1);
        t.checkExpect(bst4.size(), 4);

        //RED-BLACK TREE TESTS
        t.checkExpect(rb0.size(), 0);
        t.checkExpect(rb1.size(), 1);
        t.checkExpect(rb3.size(), 3);
    }

    /**
     * tests the containsKey method
     * @param t the tester
     */
    public void testContainsKey(Tester t) {
        //ALIST TESTS
        t.checkExpect(!kvm0.containsKey(1));
        t.checkExpect(kvm1.containsKey(0));
        t.checkExpect(!kvm1.containsKey(1));
        t.checkExpect(kvm5.containsKey(3));
        t.checkExpect(kvm7.containsKey(5));

        //BST TEST
        t.checkExpect(!bst0.containsKey(1));
        t.checkExpect(bst1.containsKey(10));
        t.checkExpect(!bst4.containsKey(16));
        t.checkExpect(bst5.containsKey(16));
        t.checkExpect(bst7.containsKey(12));

        //RED-BLACK TREE TESTS
        t.checkExpect(!rb0.containsKey(100));
        t.checkExpect(rb1.containsKey(100));
        t.checkExpect(rb9.containsKey(125));
    }

    /**
     * tests the containsValue method
     * @param t the tester
     */
    public void testContainsValue(Tester t) {
        //ALIST TESTS
        t.checkExpect(!kvm0.containsValue(""));
        t.checkExpect(kvm1.containsValue(""));
        t.checkExpect(!kvm1.containsValue("A"));
        t.checkExpect(kvm5.containsValue("A"));
        t.checkExpect(kvm6.containsValue("C"));
        t.checkExpect(!kvm6.containsValue("G"));
        t.checkExpect(kvm7.containsValue("F"));
        t.checkExpect(kvm8.containsValue("G"));
        t.checkExpect(!kvm8.containsValue("F"));

        //BST TESTS
        t.checkExpect(!bst0.containsValue("A"));
        t.checkExpect(bst1.containsValue("A"));
        t.checkExpect(bst5.containsValue("C"));
        t.checkExpect(!bst6.containsValue("Z"));
        t.checkExpect(bst5.containsValue("B"));

        //RED-BLACK TREE TESTS
        t.checkExpect(!rb0.containsValue("A"));
        t.checkExpect(rb1.containsValue("A"));
        t.checkExpect(rb7.containsValue("C"));
        t.checkExpect(!rb9.containsValue("V"));
    }

    /**
     * tests the get method
     * @param t the tester
     */
    public void testGet(Tester t) {
        //ALIST TESTS
        t.checkExpect(kvm1.get(0), "");
        t.checkExpect(kvm6.get(3), "C");
        t.checkExpect(kvm8.get(5), "G");

        //BST TESTS
        t.checkExpect(bst1.get(10), "A");
        t.checkExpect(bst3.get(10), "A");
        t.checkExpect(bst5.get(4), "E");

        //RED-BLACK TREE TESTS
        t.checkExpect(rb1.get(100), "A");
        t.checkExpect(rb3.get(50), "B");
    }

    /**
     * test to see if emptyMap throws an exception for get
     * @param t tester t
     */
    public void testMapGetException(Tester t) {
        try {
            t.checkExpect(kvm0.get(1), "A");
            t.checkExpect(kvm00.get(2), "B");
        }
        catch (Exception e) {
            System.out.println("no key in empty");
        }
    }

    /**
     * test to see if leaf throws an exception for get
     * @param t tester t
     */
    public void testBSTGetException(Tester t) {
        try {
            t.checkExpect(bst0.get(1), "A");
            t.checkExpect(bst7.get(20), "Z");
        }
        catch (Exception e) {
            System.out.println("no key in a leaf");
        }
    }

    /**
     * test to see if leaf throws an exception for returnLeft
     * @param t tester t
     */
    public void testReturnLeftException(Tester t) {
        try {
            t.checkExpect(rb0.returnLeft(), rb0);
        }
        catch (Exception e) {
            System.out.println("This is the end of the Tree");
        }
    }

    /**
     * test to see if leaf throws an exception for returnRight
     * @param t tester t
     */
    public void testReturnRightException(Tester t) {
        try {
            t.checkExpect(rb0.returnRight(), rb0);
        }
        catch (Exception e) {
            System.out.println("This is the end of the Tree");
        }
    }
    /**
     * test to see if leaf throws an exception for returnValue
     * @param t tester t
     */
    public void testReturnValueException(Tester t) {
        try {
            t.checkExpect(rb0.returnValue(), "A");
        }
        catch (Exception e) {
            System.out.println("There is nothing in a Leaf");
        }
    }

    /**
     * test to see if leaf throws an exception for returnKey
     * @param t tester t
     */
    public void testReturnKeyException(Tester t) {
        try {
            t.checkExpect(rb0.returnKey(), 100);
        }
        catch (Exception e) {
            System.out.println("There is nothing in a Leaf");
        }
    }


    /**
     * tests the overridden toString method
     * @param t the tester
     */
    public void testToString(Tester t) {
        //ALIST TESTS
        t.checkExpect(kvm0.toString(), 
                "{...[There are 0 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");
        t.checkExpect(kvm1.toString(),
                "{...[There are 1 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");
        t.checkExpect(kvm5.toString(),
                "{...[There are 5 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");

        //BST TESTS
        t.checkExpect(bst0.toString(),
                "{...[There are 0 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");
        t.checkExpect(bst1.toString(),
                "{...[There are 1 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");
        t.checkExpect(bst7.toString(),
                "{...[There are 7 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");

        //RED-BLACK TREE TESTS
        t.checkExpect(rb0.toString(),
                "{...[There are 0 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");
        t.checkExpect(rb1.toString(),
                "{...[There are 1 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");
        t.checkExpect(rb6.toString(),
                "{...[There are 6 unique key(s) mapped "
                        + "to value(s) in this KVMap]...}");
    }

    /**
     * tests the overridden equals method
     * @param t the tester
     */
    public void testEquals(Tester t) {
        //ALIST TESTS
        t.checkExpect(!kvm1.equals("Jarred"));
        t.checkExpect(!"jarred".equals(kvm0));
        t.checkExpect(kvm0.equals(kvm00));
        t.checkExpect(!kvm0.equals(kvm1));
        t.checkExpect(!kvm1.equals(kvm0));
        t.checkExpect(!kvm5.equals(kvm6));
        t.checkExpect(kvm1.equals(kvm1));
        t.checkExpect(kvm9.equals(kvm6));
        t.checkExpect(kvm6.equals(kvm9));
        t.checkExpect(!kvm8.equals(kvm6));
        t.checkExpect(!kvm11.equals(kvm14));
        t.checkExpect(!kvm10.equals(5));
        t.checkExpect(!kvm1.equals(kvm15));
        t.checkExpect(!kvm0.equals("Jarred"));
        t.checkExpect(!kvm0.equals(null));
        t.checkExpect(!kvm4.equals(null));
        t.checkExpect(alist102.equals(alist102));

        //BST TESTS
        t.checkExpect(kvm0.equals(bst0));
        t.checkExpect(bst0.equals(kvm0));
        t.checkExpect(!bst0.equals(bst1));
        t.checkExpect(bst1.equals(bst1));
        t.checkExpect(bst6.equals(bst6));
        t.checkExpect(!bst5.equals(bst6));
        t.checkExpect(!bst0.equals("Jarred"));
        t.checkExpect(!bst3.equals("JARRED"));
        t.checkExpect(!bst0.equals(null));
        t.checkExpect(!bst7.equals(null));
        t.checkExpect(!rb9.equals(rb3));
        t.checkExpect(!rb1.equals(n1));
        t.checkExpect(!rb1.equals(rb0));
        t.checkExpect(bst102.equals(bst102));
        t.checkExpect(blist2.equals(blist2));
        t.checkExpect(blist4.equals(blist4));
        t.checkExpect(blist3.equals(blist3));
        t.checkExpect(blist5.equals(blist5));

        //RED-BLACK TREE TESTS
        t.checkExpect(rb0.equals(rb0));
        t.checkExpect(rb00.equals(rb0));
        t.checkExpect(rb1.equals(rb1));
        t.checkExpect(rb5.equals(rb5));
        t.checkExpect(n1.equals(n3));

    }

    /**
     * tests the overridden hashCode method
     * @param t the tester
     */
    public void testhashCode(Tester t) {
        //ALIST TESTS
        t.checkExpect(kvm0.hashCode() == kvm00.hashCode());
        t.checkExpect(kvm1.hashCode() == kvm1.hashCode());
        t.checkExpect(kvm6.hashCode() == kvm9.hashCode());
        t.checkExpect(kvm9.hashCode() == kvm6.hashCode());
        t.checkExpect(kvm5.hashCode() == kvm5.hashCode());
        t.checkExpect(kvm1.hashCode() != kvm2.hashCode());

        //BST TESTS
        t.checkExpect(bst0.hashCode() != bst1.hashCode());
        t.checkExpect(bst5.hashCode() == bst5.hashCode());
        t.checkExpect(bst0.hashCode() == -31);

        // RED-BLACK TREE TESTS
        t.checkExpect(rb0.hashCode() == rb00.hashCode());
        t.checkExpect(rb1.hashCode() == rb1.hashCode());
        t.checkExpect(rb2.hashCode() != rb1.hashCode());
        t.checkExpect(rb9.hashCode() == rb9.hashCode());
        t.checkExpect(rb9.hashCode() != rb8.hashCode());

    }

    /**
     * tests all of the iterator methods
     * @param t the tester
     */
    public void testIterator(Tester t) {
        t.checkException(e0, intIter, "next");
        t.checkException(e1, intIter, "remove");
        t.checkExpect(kvm0.iterator(), intIter0);
        t.checkExpect(kvm5.iterator(), intIter5);
        t.checkExpect(kvm0.iterator(compareByInt), intIter0);
        t.checkExpect(kvm5.iterator(compareByInt), intIter555);
        t.checkExpect(!intIter0.hasNext());
        t.checkExpect(intIter5.hasNext());
        t.checkExpect(intIter5.next(), 4);
    }

    /**
     * tests the getAllKeys method
     * @param t the tester
     */
    public void testGetAllKeys(Tester t) {
        t.checkExpect(kvm0.getAllKeys(klist), klist);
        t.checkExpect(kvm5.getAllKeys(klist), klist5);

        t.checkExpect(bst0.getAllKeys(blist0), blist0);
        t.checkExpect(bst1.getAllKeys(blist0), blist1);
        t.checkExpect(bst2.getAllKeys(blist0), blist2);
        t.checkExpect(bst3.getAllKeys(blist0), blist3);
    }

    /**
     * tests the sortKList method
     * @param t the tester
     */
    public void testSortKlist(Tester t) {
        t.checkExpect(intIter.sortKlist(compareByInt, klist), klist);
        t.checkExpect(intIter55.sortKlist(compareByInt, klist5), klist5);
    }

    /**
     * tests the comparators
     * @param t the tester
     * 
     */
    public void testComparators(Tester t) {
        t.checkExpect(iComp.compare(1, 0), 1);
        t.checkExpect(iComp.compare(0, 0), 0);
        t.checkExpect(iComp.compare(0, 1), -1);
        t.checkExpect(sComp.compare("A", "B"), -1);
        t.checkExpect(sComp.compare("A", "A"), 0);
        t.checkExpect(sComp.compare("B", "A"), 1);
    }

    /**
     * Tests the accessor methods for the red-black trees
     * @param t the tester
     */
    public void testAccessors(Tester t) {
        t.checkExpect(rb1.returnKey(), 100);
        t.checkExpect(rb1.returnValue(), "A");

        t.checkExpect(rb0.returnColor(), "black");
        t.checkExpect(rb2.returnColor(), "black");

        t.checkExpect(rb3.returnLeft().returnColor(), "red");
        t.checkExpect(rb3.returnRight().returnColor(), "red");
        t.checkExpect(rb3.returnLeft().returnLeft().returnColor(), "black");
        t.checkExpect(rb3.returnLeft(), n1);
        t.checkExpect(rb3.returnRight(), n2);
    }

    /**
     * Tests the assign method for red black trees
     * @param t the tester
     */
    public void testAssignRedBlack(Tester t) {
        t.checkExpect(rb0.assign(100, "A"), rb1);
        t.checkExpect(rb1.assign(50, "B"), rb2);
        t.checkExpect(rb3.assign(25, "D"), rb4);
        t.checkExpect(rb7.assign(60, "H"), rb8);
        t.checkExpect(rb2.assign(150, "C"), rb3);
        t.checkExpect(rb4.assign(175, "E"), rb5);
        t.checkExpect(rb8.assign(110, "I"), rb9);
        t.checkExpect(rb1.assign(100, "A"), rb1);
        t.checkExpect(rb1.assign(100, "B"), rb20);

        t.checkExpect(rb0.assign(100, "A").returnColor().equals("black"));
        t.checkExpect(rb3.assign(25, "D").returnColor().equals("black"));
        t.checkExpect(rb2.assign(150, "C").returnLeft(), n1);
        t.checkExpect(rb2.assign(150, "C").returnRight(), n2);

        //Test to see if the tree gets turned to black once assigning
        t.checkExpect(n3002.assign(400, "Y"), n30000);
        t.checkExpect(n502.assign(200, "Z"), n5000);
        t.checkExpect(n1002.assign(150, "X"), n10000);
        t.checkExpect(n2002.assign(400, "Z"), n20000);
    }

    /**
     * Tests the leftLeft, leftRight, rightLeft, rightRight methods
     * @param t the tester
     */
    public void testBalancingMethods(Tester t) {
        t.checkExpect(rb0.leftLeft(), rb0);
        t.checkExpect(rb0.leftRight(), rb0);
        t.checkExpect(rb0.rightLeft(), rb0);
        t.checkExpect(rb0.rightRight(), rb0);

        t.checkExpect(n52.leftLeft(), n502);
        t.checkExpect(n102.leftRight(), n1002);
        t.checkExpect(n202.rightLeft(), n2002);
        t.checkExpect(n302.rightRight(), n3002);
    }

    /**
     * tests to see if the tree gets turned into one with a black root
     * @param t the tester
     */
    public void testBlackRoot(Tester t) {
        t.checkExpect(rb0.blackRoot(), rb0);
        t.checkExpect(n1.blackRoot(), n3);
        t.checkExpect(n2.blackRoot(), n4);
        t.checkExpect(n4.blackRoot(), n4);

        t.checkExpect(n1002.blackRoot(), n10000);
        t.checkExpect(n3002.blackRoot(), n30000);
    }

    /**
     * tests the balancing method of a tree (tests all 4 possibilities)
     * @param t the tester
     */
    public void testBalance(Tester t) {
        t.checkExpect(rb0.balanceTree(), rb0);
        t.checkExpect(rb1.balanceTree(), rb1);
        t.checkExpect(rb6.balanceTree(), rb6);

        t.checkExpect(n52.balanceTree(), n502);
        t.checkExpect(n102.balanceTree(), n1002);
        t.checkExpect(n202.balanceTree(), n2002);
        t.checkExpect(n302.balanceTree(), n3002);
    }

}











