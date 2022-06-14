package util.collections.implementations.arrays.primitives;

import util.collections.Jiterator;
import util.collections.implementations.arrays.Array;

import java.util.Iterator;

public class LongArray {

    private Array<Long> data;

    public LongArray() {
        this.data = new Array<>();
    }

    public LongArray(int initialCapacity) {
        this.data = new Array<>(initialCapacity);
    }

    public LongArray(long[] longArray) {
        data = new Array<>(longArray.length);
        for (int i = 0; i < longArray.length; i++) {
            data.add(Long.valueOf(longArray[i]), i);
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

    public Array<Long> getLongs() {
        return data;
    }

    public Object[] getArray() {
        return (Long[]) data.toArray();
    }

    public Object[] getArray(int length) {
        return data.toArray(length);
    }

    public boolean contains(long val) {
        return data.contains(Long.valueOf(val));
    }

    public Long get(int index) {
        return data.get(index);
    }

    /*
     * I should add my own exceptions for an array
     * */
    public void add(long val, int index) {
        data.add(Long.valueOf(val), index);
    }

    public void add(long val) {
        data.add(Long.valueOf(val));
    }

    public void set(long val, int index) {
        data.set(Long.valueOf(val), index);
    }

    public void removeAtIndex(int index) {
        data.remove(index);
    }

    public void remove(long val) {
        data.remove(Long.valueOf(val));
    }

    public void removeAllOccurences(long val) {
        data.removeAllOccurences(Long.valueOf(val));
    }

    public int indexOf(long val) {
        return data.indexOf(Long.valueOf(val));
    }

    public int lastIndexOf(long val) {
        return data.lastIndexOf(Long.valueOf(val));
    }

    public boolean containsAll(long[] lArray) {
        return false;
    }

    public boolean addAll(long[] lArray) {
        return false;
    }

    public boolean replaceAll(long[] lArray, int startIndexThis, int startIndexCol, int length) {
        return false;
    }

    public boolean removeAll(long[] lArray) {
        return false;
    }

    public boolean retainAll(long[] lArray) {
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
