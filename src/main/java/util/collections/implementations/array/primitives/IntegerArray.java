package util.collections.implementations.array.primitives;

import util.collections.implementations.array.Array;
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
        requireNonNull(array).add(val);
    }

    @Override
    public void set(Integer val, int index) {
        requireNonNull(array).set(val, index);
    }

    @Override
    public void removeAtIndex(int index) {
        requireNonNull(array).removeAtIndex(index);
    }

    @Override
    public void remove(Integer val) {
        requireNonNull(array).remove(val);
    }

    @Override
    public void removeFirst(Integer val) {
        requireNonNull(array).removeFirst(val);
    }

    @Override
    public void removeLast(Integer val) {
        requireNonNull(array).removeLast(val);
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

    public Iterator iterator() {
        return null;
    }

    @Override
    public String toString(){
        if (array == null)
            return "";
        if (isEmpty())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size(); i++) {
            sb.append(array.get(i)).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

}
