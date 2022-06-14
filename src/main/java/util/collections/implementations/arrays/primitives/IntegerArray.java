package util.collections.implementations.arrays.primitives;

import util.collections.Jiterator;
import util.collections.implementations.arrays.Array;

import java.util.Iterator;

public class IntegerArray {

    private Array<Integer> data;

    public IntegerArray() {
        this.data = new Array<>();
    }

    public IntegerArray(int initialCapacity) {
        this.data = new Array<>(initialCapacity);
    }

    public IntegerArray(int[] integerArray) {
        data = new Array<>(integerArray.length);
        for (int i = 0; i < integerArray.length; i++) {
            data.add(Integer.valueOf(integerArray[i]), i);
        }
    }

    public int size() {
        return data != null? data.size(): 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        data.clear();
    }

    public Array<Integer> getIntegers() {
        return data;
    }

    public Object[] getArray() {
        return data.toArray();
    }

    public Object[] getArray(int length) {
        return data.toArray(length);
    }


    public boolean contains(int val) {
        return data.contains(Integer.valueOf(val));
    }

    public Integer get(int index) {
        return data.get(index);
    }

    /*
     * I should add my own exceptions for an array
     * */
    public void add(int val, int index) {
        data.add(Integer.valueOf(val), index);
    }

    public void add(int val) {
        data.add(Integer.valueOf(val));
    }

    public void set(int val, int index) {
        data.set(Integer.valueOf(val), index);
    }

    public void removeAtIndex(int index) {
        data.remove(index);
    }

    public void remove(int val) {
        data.remove(Integer.valueOf(val));
    }

    public void removeAllOccurences(int val) {
        data.removeAllOccurences(Integer.valueOf(val));
    }

    public int indexOf(int val) {
        return data.indexOf(Integer.valueOf(val));
    }

    public int lastIndexOf(int val) {
        return data.lastIndexOf(Integer.valueOf(val));
    }

    public boolean containsAll(int[] iArray) {
        return false;
    }

    public boolean addAll(int[] iArray) {
        return false;
    }

    public boolean replaceAll(int[] iArray, int startIndexThis, int startIndexCol, int length) {
        return false;
    }

    public boolean removeAll(int[] iArray) {
        return false;
    }

    public boolean retainAll(int[] iArray) {
        return false;
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
