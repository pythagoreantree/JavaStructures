package util.collections.implementations.arrays;

import org.junit.jupiter.api.Test;
import java.util.Collection;

import java.util.ArrayList;

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
    void createArrayV2(){
//        Array<Integer> arr = new Array<Integer>(Integer.class, 100);
//        System.out.println(arr.clone());
//        arr.add(null);
//        arr.add(null);
//        arr.add(1);
//        System.out.println(arr.data.getClass());
//        System.out.println(arr.data.getClass());
//        System.out.println(Arrays.stream(arr.data).filter(o -> o != null).map(o -> o.toString()).collect(Collectors.toList()));
//        ArrayList<Integer> al = new ArrayList<>();
//        al.add(1);
//        Array<Integer> arr = new Array<Integer>(al);
//        System.out.println(al);
//        System.out.println(al.toArray().getClass());
//        al.add(1);
//        System.out.println(al.toArray().getClass());
//        System.out.println(al.get(0).getClass());
//        System.out.println(al.toArray().getClass());
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