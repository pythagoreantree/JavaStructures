package util.collections.implementations.arrays.primitives;

import util.collections.Jiterator;
import util.collections.implementations.arrays.Array;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;

public class LongArray implements ArrayI<Long> {

    private Array<Long> array;

    public LongArray() {
        this.array = new Array<>(Long.class);
    }

    public LongArray(int initialCapacity) {
        this.array = new Array<>(Long.class, initialCapacity);
    }

    public LongArray(long[] longArray) {
        array = new Array<>(Long.class, longArray.length);
        for (int i = 0; i < longArray.length; i++) {
            array.add(Long.valueOf(longArray[i]), i);
        }
    }

    public LongArray(Long[] longArray) {
        array = new Array<>(Long.class, longArray.length);
        for (int i = 0; i < longArray.length; i++) {
            array.add(longArray[i], i);
        }
    }

    private Array<Long> requireNonNull(Array<Long> array){
        if (array == null)
            throw new NullPointerException("LongArray pointer is null.");
        return array;
    }

    public int size() {
        return array != null? array.size(): 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int capacity() {
        return array != null? array.capacity(): 0;
    }

    public void clear() {
        requireNonNull(array).clear();
    }

    public Long[] getArray() {
        return requireNonNull(array).getArray();
    }

    public Long[] getArray(int length) {
        return requireNonNull(array).getArray(length);
    }

    @Override
    public boolean contains(Long l) {
        return requireNonNull(array).contains(l);
    }

    public Long get(int index) {
        return requireNonNull(array).get(index);
    }

    public Array<Long> getLongs() {
        return array;
    }

    @Override
    public void add(Long e, int index) {
        requireNonNull(array).add(e, index);
    }

    @Override
    public void add(Long e) {
        requireNonNull(array).add(e);
    }

    @Override
    public void set(Long e, int index) {
        requireNonNull(array).set(e, index);
    }

    @Override
    public int indexOf(Long val) {
        return requireNonNull(array).indexOf(val);
    }

    public int lastIndexOf(Long val) {
        return requireNonNull(array).lastIndexOf(val);
    }

    @Override
    public ArrayI<Long> subArray(int fromIndex, int toIndex) {
        return requireNonNull(array).subArray(fromIndex, toIndex);
    }

    @Override
    public void remove(int index) {
        requireNonNull(array).remove(index);
    }

    @Override
    public void remove(Long e) {
        requireNonNull(array).remove(e);
    }

    @Override
    public void removeAllOccurences(Long e) {
        requireNonNull(array).remove(e);
    }

    @Override
    public boolean containsAll(Collection<Long> collection) {
        return requireNonNull(array).containsAll(collection);
    }

    @Override
    public void addAll(Collection<Long> collection) {
        requireNonNull(array).addAll(collection);
    }

    @Override
    public void replaceAll(Collection<Long> collection, int startIndexThis, int startIndexCol, int length) {
        requireNonNull(array).replaceAll(collection, startIndexThis, startIndexCol, length);
    }

    @Override
    public void removeAll(Collection<Long> collection) {
        requireNonNull(array).removeAll(collection);
    }

    @Override
    public void retainAll(Collection<Long> collection) {
        requireNonNull(array).retainAll(collection);
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
