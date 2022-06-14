package util.collections.implementations.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        Object[] intArr = arr.toArray();
        for (int j = 0; j < intArr.length; j++){
            System.out.println(intArr[j]);
        }
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
}