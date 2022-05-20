package util.collections.implementations.array.primitives;

import util.collections.Jiterator;
import util.collections.search.BinarySearch;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class IntegerArray {
    private static final int DEFAULT_CAPACITY = 0;

    private int[] data;

    private int capacity = 0;
    private int size = 0;

    public IntegerArray() {
        this.data = getEmptyArray();
    }

    public IntegerArray(int initialCapacity) {
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        if (initialCapacity > 0) {
            this.data = new int[initialCapacity];
            this.capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.data = getEmptyArray();
        }
    }

    public IntegerArray(int[] array) {
        Objects.requireNonNull(array);
        //here I need to copy
        this.data = new int[]{};
        this.capacity = data.length;
        this.size = 0;
    }

    private int[] getEmptyArray(){
        return new int[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        for (int i=0; i<capacity; i++){
            data[i] = 0;
        }
        this.size = 0;
    }

    public int[] toArray() {
        return (size() == 0)? copyArray(size()): getEmptyArray();
    }

    public int[] toArray(int length) {
        if (length == 0){
            return getEmptyArray();
        }
        if (length >= size()){
            return toArray();
        }
        return copyArray(size(), length);
    }

    private int[] copyArray(int length){
        //as for the logic length would be size but
        //I need to check it in case oof other usages
        int[] copy = new int[length];
        for (int i=0; i<length; i++){
            copy[i] = data[i];
        }
        return copy;
    }

    private int[] copyArray(int arrLength, int fillLength){
        int[] copy = new int[arrLength];
        for (int i=0; i<fillLength; i++){
            copy[i] = data[i];
        }
        //here I would have added zeros
        return copy;
    }

    public boolean contains(int iVal) {
        return indexOf(iVal) >= 0;
    }

    //int or Integer
    //I need some standards
    //Either I give an opportunity to work with primitives
    //Or all primitives would be converted to Integer, Long, Double and so on
    public int get(int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        return data[index];
    }

    /*
     * I should add my own exceptions for an array
     * */
    public void add(int iVal, int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        if (size == capacity){
            throw new RuntimeException("No place for a new element");
        }
        if (size < capacity){
            //I add an element in this index and all other goes right
            for(int i=index; i<size; i++){
                data[i+1] = data[i];
            }
            data[index] = iVal;
            size++;
        }
    }

    public void add(int iVal) {
        if (size == capacity){
            throw new RuntimeException("No place for a new element");
        }
        if (size < capacity){
            data[size] = iVal;
            size++;
        }
    }

    public void set(int iVal, int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        data[index] = iVal;
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        removeByIndex(index);
    }

    public void remove(int iVal) {
        if(!contains(iVal)){
            throw new NoSuchElementException("");
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == iVal) {
                removeByIndex(i);
                break;
            }
        }
    }

    public void removeAllOccurences(int iVal) {
        if(!contains(iVal)){
            throw new NoSuchElementException("");
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == iVal) {
                removeByIndex(i);
            }
        }
    }

    private void removeByIndex(int index) {
        int lastIndex = size - 1;
        for (int i=index; i<lastIndex; i++){
            data[i] = data[i+1];
        }
        data[lastIndex] = 0;
        size--;
    }

    public int indexOf(int iVal) {
        for (int i = 0; i < size; i++) {
            if (data[i] == iVal)
                return i;
        }
        return -1;
    }

    public int lastIndexOf(int iVal) {
        for (int i = size-1; i >= 0; i--) {
            if (data[i] == iVal)
                return i;
        }
        return -1;
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

    /*
    * Search block
    * */
    public int search(int elem){
        return BinarySearch.search(data, elem);
    }

}
