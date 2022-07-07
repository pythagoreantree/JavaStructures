package util.collections.implementations.arrays.primitives;

import util.collections.Jiterator;
import util.collections.implementations.arrays.Array;
import util.collections.interfaces.collection.Collection;

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
        return data.getArray();
    }

    public Object[] getArray(int length) {
        return data.getArray(length);
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

    //Need a method with an array
    public void containsAll(Collection<Integer> iArray) {
        data.containsAll(iArray);
    }

    public void addAll(Collection<Integer> iArray) {
       data.addAll(iArray);
    }

    public void replaceAll(Collection<Integer> iArray, int startIndexThis, int startIndexCol, int length) {
        data.replaceAll(iArray, startIndexThis, startIndexCol, length);
    }

    public void removeAll(Collection<Integer> iArray) {
        data.removeAll(iArray);
    }

    public void retainAll(Collection<Integer> iArray) {
        data.retainAll(iArray);
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
