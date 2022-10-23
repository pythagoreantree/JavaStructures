package util.collections.implementations.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.collections.implementations.array.Array;
import util.collections.implementations.array.primitives.IntegerArray;

class ArrayTest {

    @Test
    void createArray(){
        Array<Integer> arr = new Array<>();
        System.out.println(arr.size());
        arr.add(10);
        arr.add(11);
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
        Object[] intArr = arr.getArray();
        for (int j = 0; j < intArr.length; j++){
            System.out.println(intArr[j]);
        }
    }

    @Test
    void createIntegerArray(){
        Array<Integer> arr = new Array<>(Integer.class);
        Assertions.assertEquals(16, arr.capacity());
        arr = new Array<>(Integer.class, 10);
        Assertions.assertEquals(10, arr.capacity());
        Assertions.assertTrue(arr.isEmpty());
        arr.add(null);
        arr.add(null);
        arr.add(null);
        Assertions.assertEquals(3, arr.size());
        Assertions.assertFalse(arr.isEmpty());
        System.out.println(arr.toString());
        Array<Integer> arr2 = new Array<>(Integer.class, 7);
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(3);
        arr2.add(5);
        arr2.add(3);
//        arr2.set(6, 6);
//        arr2.removeAtIndex(5);
        System.out.println(arr2.toString());
        arr.addAll(arr2);
        System.out.println(arr.toString());
        System.out.println(arr.size());
        Array<Integer> arr3 = new Array<>(Integer.class, 1);
        arr3.add(3);
        System.out.println(arr3.toString());
        arr.removeAll(arr3);
        System.out.println(arr.toString());
        //removeAll is not right. should remove only one 3
    }

    @Test
    void createPrimitiveIntegerArray(){
        IntegerArray arr = new IntegerArray();
        System.out.println(arr.size());
        System.out.println(arr.capacity());
        arr = new IntegerArray(10);
        System.out.println(arr.size());
        System.out.println(arr.capacity());
        System.out.println(arr.isEmpty());
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(arr.toString());
        arr.remove(3);
        System.out.println(arr.size());
        System.out.println(arr.toString());
        arr.set(0, 0);
        System.out.println(arr.toString());
        arr.add(null);
        System.out.println(arr.size());
        System.out.println(arr.toString());
        arr.remove(null);
        System.out.println(arr.size());
        System.out.println(arr.toString());
        arr.add(1, 1);
        System.out.println(arr.size());
        System.out.println(arr.toString());
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void testToArray() {
    }

    @Test
    void contains() {
    }

    @Test
    void get() {
    }

    @Test
    void add() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void set() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void removeAllOccurences() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void testSize() {
    }
}