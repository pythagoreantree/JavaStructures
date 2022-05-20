package util.collections.implementations.arrays.primitives;

import util.collections.Jiterator;
import util.collections.implementations.arrays.Array;
import util.collections.search.BinarySearch;
import util.collections.search.Search;
import util.collections.search.Searchable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerArray implements Searchable {
    private int[] data;

    private int capacity = 0;
    private int size = 0;

    private Search search;

    public IntegerArray() {
        this.data = getEmptyArray();
    }

    public IntegerArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        if (initialCapacity > 0) {
            this.data = new int[initialCapacity];
            this.capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.data = getEmptyArray();
        }
    }

    private int[] getEmptyArray() {
        return new int[]{};
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            data[i] = 0;
        }
        this.size = 0;
    }

    public int[] getArray() {
        return (size() != 0)? copyArray(size()): getEmptyArray();
    }

    public int[] getArray(int length) {
        if (length == 0) {
            return getEmptyArray();
        }
        if (length >= size()) {
            return getArray();
        }
        return copyArray(size(), length);
    }

    private int[] copyArray(int length) {
        //as for the logic length would be size but
        //I need to check it in case oof other usages
        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i] = data[i];
        }
        return copy;
    }

    private int[] copyArray(int arrLength, int fillLength) {
        int[] copy = new int[arrLength];
        for (int i = 0; i < fillLength; i++) {
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
        if (size == capacity) {
            throw new RuntimeException("No place for a new element");
        }
        if (size < capacity) {
            //I add an element in this index and all other goes right
            for (int i = index; i < size; i++) {
                data[i + 1] = data[i];
            }
            data[index] = iVal;
            size++;
        }
    }

    public void add(int iVal) {
        if (size == capacity) {
            throw new RuntimeException("No place for a new element");
        }
        if (size < capacity) {
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
        if (!contains(iVal)) {
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
        if (!contains(iVal)) {
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
        for (int i = index; i < lastIndex; i++) {
            data[i] = data[i + 1];
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
        for (int i = size - 1; i >= 0; i--) {
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
    @Override
    public <Integer> int search(Integer elem) {
        return getSearch().search(getIntegers().toArray(), elem);
    }

    private Array<Integer> getIntegers() {
        Array<Integer> array = new Array<>(capacity);
        for (int k = 0; k < capacity; k++) {
            array.add(data[k]);
        }
        return array;
    }

    private Search getSearch() {
        if(search == null){
            search = new BinarySearch();
        }
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
