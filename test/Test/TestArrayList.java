/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import myarraylistwithbugs.MyArrayListWithNoBugs;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louise Nielsen
 */
public class TestArrayList {

    public TestArrayList() {
    }

    MyArrayListWithNoBugs instance = new MyArrayListWithNoBugs();

    Object object1 = new Object();
    Object object2 = new Object();
    Object object3 = new Object();
    Object object4 = new Object();
    Object object5 = new Object();
    Object object6 = new Object();

    @Test
    public void addObjectToList() {
        System.out.println("Test: Add object to list");

        instance.add(object1);

        assertEquals(object1, instance.get(0));
        assertEquals(instance.size(), 1);
    }

    @Test
    public void addObjectsToList() {
        System.out.println("Test: Add objects to list");

        instance.add(object1);
        instance.add(object2);

        assertEquals(object1, instance.get(0));
        assertEquals(object2, instance.get(1));
        assertEquals(instance.size(), 2);
    }

    @Test
    public void addObjectToListWithSize5() {
        System.out.println("Test: Add object to list with size 5");

        instance.add(object1);
        instance.add(object2);
        instance.add(object3);
        instance.add(object4);
        instance.add(object5);

        System.out.println("The size of the list is 5: " + instance.size());

        instance.add(object6);

        System.out.println("Object added and now the size of the list is 6: " + instance.size());

        assertEquals(instance.size(), 6);
    }

    @Test
    public void addObjectToIndex() {
        System.out.println("Test: Add object to index in list with size 3");

        instance.add(object1);
        instance.add(object2);
        instance.add(object3);

        instance.add(1, object1);

        assertEquals(instance.get(1), object1);
        assertNotEquals(instance.get(1), object2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addObjectToIndexSize0() {
        System.out.println("Test: Add object to index in list with size 0");

        instance.add(8, object1);
        instance.add(0, object1);
        instance.add(-1, object1);
    }

    @Test
    public void removeObjectFromList() {
        System.out.println("Test: Remove object via index in list with size 1");

        instance.add(object1);
        instance.add(0, object1);
        instance.remove(0);

        assertEquals(instance.get(0), object1);
        assertEquals(instance.size(), 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeObjectFromListSize0() {
        System.out.println("Test: Remove object from list with size 0");

        instance.remove(0);
    }

    @Test
    public void removeObjectFromListSize6() {
        System.out.println("Test: Remove object from list with size 6");

        instance.add(object1);
        instance.add(object2);
        instance.add(object3);
        instance.add(object4);
        instance.add(object5);
        instance.add(object6);

        instance.add(0, object1);
        instance.add(1, object2);
        instance.add(2, object3);
        instance.add(3, object4);
        instance.add(4, object5);
        instance.add(5, object6);

        instance.remove(5);
        
        assertEquals(instance.get(5), object6);
        assertEquals(instance.size(), 5);

    }

}
