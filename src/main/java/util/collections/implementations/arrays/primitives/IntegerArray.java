package util.collections.implementations.arrays.primitives;

import util.collections.Jiterator;
import util.collections.implementations.arrays.Array;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;

public class IntegerArray implements ArrayI<Integer> {

    private static final int DEFAULT_CAPACITY = 32;

    private Array<Integer> array;

    public IntegerArray() {
        this.array = new Array<>(Integer.class);
    }

    public IntegerArray(int initialCapacity) {
        this.array = new Array<>(Integer.class, initialCapacity);
    }

    public IntegerArray(int[] integerArray) {
        if (integerArray == null)
            integerArray = new int[DEFAULT_CAPACITY];
        Integer[] arrayI = new Integer[integerArray.length];
        for (int i = 0; i < integerArray.length; i++)
            arrayI[i] = integerArray[i];
        initArray(arrayI);
    }

    public IntegerArray(Integer[] integerArray) {
        initArray(integerArray);
    }

    private void initArray(Integer[] integerArray){
        this.array = new Array<>(Integer.class, integerArray.length);
        this.array.setData(integerArray);
    }

    private Array<Integer> requireNonNull(Array<Integer> array){
        if (array == null)
            throw new NullPointerException("IntegerArray pointer is null.");
        return array;
    }

    public int size() {
        return array != null? array.size(): 0;
    }

    @Override
    public int capacity() {
        return array != null? array.capacity(): 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        requireNonNull(array).clear();
    }

    public Array<Integer> getIntegers() {
        return array;
    }

    @Override
    public Integer[] getArray() {
        return requireNonNull(array).getArray();
    }

    @Override
    public Integer[] getArray(int length) {
        return requireNonNull(array).getArray(length);
    }

    @Override
    public boolean contains(Integer val) {
        return requireNonNull(array).contains(val);
    }

    @Override
    public Integer get(int index) {
        return requireNonNull(array).get(index);
    }

    @Override
    public void add(Integer val, int index) {
        requireNonNull(array).add(val, index);
    }

    @Override
    public void add(Integer val) {
        requireNonNull(array).add(Integer.valueOf(val));
    }

    @Override
    public void set(Integer val, int index) {
        requireNonNull(array).set(val, index);
    }

    @Override
    public void remove(int index) {
        requireNonNull(array).remove(index);
    }

    @Override
    public void remove(Integer val) {
        requireNonNull(array).remove(val);
    }

    @Override
    public void removeAllOccurences(Integer val) {
        requireNonNull(array).removeAllOccurences(val);
    }

    @Override
    public int indexOf(Integer val) {
        return requireNonNull(array).indexOf(val);
    }

    @Override
    public int lastIndexOf(Integer val) {
        return requireNonNull(array).lastIndexOf(val);
    }

    @Override
    public ArrayI<Integer> subArray(int fromIndex, int toIndex) {
        return requireNonNull(array).subArray(fromIndex, toIndex);
    }

    @Override
    public boolean containsAll(Collection<Integer> collection) {
        return requireNonNull(array).containsAll(collection);
    }

    @Override
    public void addAll(Collection<Integer> collection) {
       requireNonNull(array).addAll(collection);
    }

    @Override
    public void replaceAll(Collection<Integer> collection) {
        requireNonNull(array).replaceAll(collection);
    }

    @Override
    public void replaceAll(Collection<Integer> collection, int startIndexThis, int startIndexCol, int length) {
        requireNonNull(array).replaceAll(collection, startIndexThis, startIndexCol, length);
    }

    @Override
    public void removeAll(Collection<Integer> collection) {
        requireNonNull(array).removeAll(collection);
    }

    @Override
    public void retainAll(Collection<Integer> collection) {
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
