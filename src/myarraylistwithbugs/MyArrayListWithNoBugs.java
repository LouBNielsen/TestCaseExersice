/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarraylistwithbugs;

/**
 *
 * @author Louise Nielsen
 */
public class MyArrayListWithNoBugs {

    public static void main(String[] args) {

        MyArrayListWithNoBugs instance = new MyArrayListWithNoBugs();

        System.out.println("No bugs");

        System.out.println("Size " + instance.size() + ". Therefore, add 6 objects");

        Object oo = new Object();
        Object ooo = new Object();
        Object oooo = new Object();
        Object ooooo = new Object();
        Object oooooo = new Object();
        Object ooooooo = new Object();

        instance.add(oo);
        instance.add(ooo);
        instance.add(oooo);
        instance.add(ooooo);
        instance.add(oooooo);
        instance.add(ooooooo);

        System.out.println("Size " + instance.size());

        instance.add(0, oo);
        instance.add(1, ooo);
        instance.add(2, oooo);
        instance.add(3, ooooo);
        instance.add(4, oooooo);
        instance.add(5, ooooooo);

        System.out.println("Index 0 " + instance.get(0));
        System.out.println("Index 1 " + instance.get(1));
        System.out.println("Index 2 " + instance.get(2));
        System.out.println("Index 3 " + instance.get(3));
        System.out.println("Index 4 " + instance.get(4));
        System.out.println("Index 5 " + instance.get(5));

        instance.remove(0);
        System.out.println("Index 0 removed, but got next index object: " + instance.get(0));

        System.out.println("Index 0 " + instance.get(0));
        System.out.println("Index 1 " + instance.get(1));
        System.out.println("Index 2 " + instance.get(2));
        System.out.println("Index 3 " + instance.get(3));
        System.out.println("Index 4 " + instance.get(4));
        System.out.println("Index 5 " + instance.get(5));
        
        System.out.println("Replace index 0 object with next object AND creates two times last object ind array");

        System.out.println("Size is now smaller than before: " + instance.size());

    }

    private Object[] list;
    int nextFree;

    // Creates a new empty list
    public MyArrayListWithNoBugs() {
        list = new Object[5];
        nextFree = 0;
    }

    // Inserts object at the end of list
    public void add(Object o) {
        // check capacity
        if (list.length <= nextFree) {
            list = getLongerList();
        }

        list[nextFree] = o;
        nextFree++;
    }

    // Returns the number of objects in the list
    public int size() {
        return nextFree;
    }

    // Returns a reference to the object at position index
    // Throws IndexOutOfBoundsException
    public Object get(int index) {
        if (index < 0 || nextFree < index) {
            throw new IndexOutOfBoundsException("Error (get): Invalid index"
                    + index);
        }

        return list[index];
    }

    // Inserts object at position index
    // Throws IndexOutOfBoundsException
    public void add(int index, Object o) {
        if (index < 0 || nextFree < index) {
            throw new IndexOutOfBoundsException("Error (add): Invalid index"
                    + index);
        }

        // check capacity
        if (list.length <= nextFree) {
            list = getLongerList();
        }

        // Shift elements upwards to make position index free
        // Start with last element and move backwards
        for (int i = nextFree - 1; i < index; i--) {
            list[i] = list[i - 1];
        }

        list[index] = o;
    }

    // Removes object at position index
    // Returns a reference to the removed object
    // Throws IndexOutOfBoundsException
    public Object remove(int index) {
        if (index < 0 || nextFree <= index) {
            throw new IndexOutOfBoundsException("Error (remove): Invalid index"
                    + index);
        }

        // Shift elements down to fill indexed position
        // Start with first element
        for (int i = index; i < nextFree-1; i++) {
            list[i] = list[i + 1];
        }
        nextFree--;

        return list[index];

    }

    //============== private helper methods ==========
    // create a list with double capacity and
    // copy all elements to this
    private Object[] getLongerList() {
        Object[] tempList = new Object[list.length * 2];
        for (int i = 0; i < list.length; i++) {
            tempList[i] = list[i];
        }
        return tempList;
    }

}
