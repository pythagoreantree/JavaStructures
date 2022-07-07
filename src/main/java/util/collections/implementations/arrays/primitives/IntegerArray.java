package util.collections.implementations.arrays.primitives;

import util.collections.Jiterator;
import util.collections.implementations.arrays.Array;
import util.collections.interfaces.collection.Collection;

import java.util.Iterator;

public class IntegerArray {

    private Array<Integer> array;

    public IntegerArray() {
        this.array = new Array<>(Integer.class);
    }

    public IntegerArray(int initialCapacity) {
        this.array = new Array<>(Integer.class, initialCapacity);
    }

    public IntegerArray(int[] integerArray) {
        array = new Array<>(Integer.class, integerArray.length);
        for (int i = 0; i < integerArray.length; i++) {
            array.add(Integer.valueOf(integerArray[i]), i);
        }
    }

    public IntegerArray(Integer[] integerArray) {
        array = new Array<>(Integer.class, integerArray.length);
        for (int i = 0; i < integerArray.length; i++) {
            array.add(integerArray[i], i);
        }
    }

    public int size() {
        return array != null? array.size(): 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        array.clear();
    }

    public Array<Integer> getIntegers() {
        return array;
    }

    public Object[] getArray() {
        return array.getArray();
    }

    public Object[] getArray(int length) {
        return array.getArray(length);
    }


    public boolean contains(int val) {
        return array.contains(Integer.valueOf(val));
    }

    public Integer get(int index) {
        return array.get(index);
    }

    /*
     * I should add my own exceptions for an array
     * */
    public void add(int val, int index) {
        array.add(Integer.valueOf(val), index);
    }

    public void add(int val) {
        array.add(Integer.valueOf(val));
    }

    public void set(int val, int index) {
        array.set(Integer.valueOf(val), index);
    }

    public void removeAtIndex(int index) {
        array.remove(index);
    }

    public void remove(int val) {
        array.remove(Integer.valueOf(val));
    }

    public void removeAllOccurences(int val) {
        array.removeAllOccurences(Integer.valueOf(val));
    }

    public int indexOf(int val) {
        return array.indexOf(Integer.valueOf(val));
    }

    public int lastIndexOf(int val) {
        return array.lastIndexOf(Integer.valueOf(val));
    }

    //Need a method with an array
    public void containsAll(Collection<Integer> iArray) {
        array.containsAll(iArray);
    }

    public void addAll(Collection<Integer> iArray) {
       array.addAll(iArray);
    }

    public void replaceAll(Collection<Integer> iArray, int startIndexThis, int startIndexCol, int length) {
        array.replaceAll(iArray, startIndexThis, startIndexCol, length);
    }

    public void removeAll(Collection<Integer> iArray) {
        array.removeAll(iArray);
    }

    public void retainAll(Collection<Integer> iArray) {
        array.retainAll(iArray);
    }

    public Jiterator jiterator() {
        return null;
    }

    public Jiterator jiterator(int index) {
        return null;
    }

    public Iterator iterator() {
        return null;
    }

}
