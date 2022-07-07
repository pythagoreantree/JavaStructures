package util.collections.implementations.arrays;

import util.collections.Jiterator;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Array<T> implements ArrayI<T> {

    private static final int DEFAULT_CAPACITY = 16;

    private int capacity = 0;

    private Class eClass;

    protected T[] data;

    public Array() {
        throw new RuntimeException("Cant init this way");
    }

    public Array(int initialCapacity) {
        throw new RuntimeException("Cant init this way");
    }

    public Array(Class<T> eClass) {
        this.eClass = eClass;
        this.data = getArrayData(eClass, DEFAULT_CAPACITY);
        this.capacity = data.length;
    }

    public Array(Class<T> eClass, int initialCapacity) {
        if (initialCapacity > 0) {
            this.eClass = eClass;
            this.data = getArrayData(eClass, initialCapacity);
            this.capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.eClass = eClass;
            this.data = getArrayData(eClass, DEFAULT_CAPACITY);
            this.capacity = DEFAULT_CAPACITY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public Array(Collection<? extends T> collection) {
        Objects.requireNonNull(collection);
        boolean allNulls = true;
        Class eClass = null;
        for (T elem:collection){
            if (allNulls && elem != null) {
                allNulls = false;
                eClass = elem.getClass();
            }
        }
        if (allNulls)
            throw new RuntimeException("Cant init with empty collection");
        this.eClass = eClass;
        if (eClass != null){
            this.eClass = eClass;
            this.data = getArrayData(eClass, collection.capacity());
            this.capacity = collection.capacity();
        } else {
            throw new RuntimeException("Cant define the class of elements");
        }
    }

    private T[] getArrayData(Class eClass, int length){
        return (T[]) java.lang.reflect.Array.newInstance(eClass, length);
    }

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    /*
     * As this is an array of fixed size I just make all cells empty
     * */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        this.size = 0;
    }

    @Override
    public T[] getArray() {
        if (isEmpty()) {
            return getArrayData(eClass, 0);
        }
        T[] elems = getArrayData(eClass, size);
        for (int i = 0; i < size; i++) {
            elems[i] = data[i];
        }
        return elems;
    }

    @Override
    public T[] getArray(int length) {
        if (length == 0) {
            return getArrayData(eClass, 0);
        }
        if (length >= size()) {
            return getArray();
        }
        return copyArray(size(), length);
    }

    protected Array clone() {
        Array<T> dataClone = new Array(eClass, capacity);
        T[] elements = getArrayData(eClass, capacity);
        for (int i = 0; i < size; i++) {
            elements[i] = data[i];
        }
        dataClone.setData(elements);
        return dataClone;
    }

    public void setData(T[] data) {
        this.data = data;
        this.size = data.length;
    }

    private T[] copyArray(int arrLength, int fillLength) {
        T[] copy = getArrayData(eClass, fillLength);
        for (int i = 0; i < arrLength; i++) {
            copy[i] = data[i];
        }
        return copy;
    }

    @Override
    public boolean contains(T e) {
        return indexOf(e) >= 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        return data[index];
    }

    /*
     * I should add my own exceptions for an array
     * */
    @Override
    public void add(T e, int index) {
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
            size++;
            data[index] = e;
        }
    }

    @Override
    public void add(T e) {
        if (size == capacity) {
            throw new RuntimeException("No place for a new element");
        }
        if (size < capacity) {
            data[size++] = e;
        }
    }

    @Override
    public void set(T e, int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        data[index] = e;
    }

    @Override
    public void removeAtIndex(int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        removeByIndex(index);
    }

    @Override
    public void remove(T e) {
        if (!contains(e)) {
            throw new NoSuchElementException("");
        }
        for (int i = 0; i < size; i++) {
            if (e == null && data[i] == null) {
                removeByIndex(i);
                break;
            }
            if (e != null && e.equals(data[i])) {
                removeByIndex(i);
                break;
            }
        }
    }

    @Override
    public void removeFirst(T e) {
        int index = indexOf(e);
        removeAtIndex(index);
    }

    @Override
    public void removeLast(T e) {
        int index = lastIndexOf(e);
        removeAtIndex(index);
    }

    @Override
    public void removeAllOccurences(T e) {
        if (!contains(e)) {
            throw new NoSuchElementException("");
        }
        for (int i = 0; i < size; i++) {
            if (e == null && data[i] == null) {
                removeByIndex(i);
            }
            if (e != null && e.equals(data[i])) {
                removeByIndex(i);
            }
        }
    }

    private void removeByIndex(int index) {
        int lastIndex = size - 1;
        for (int i = index; i < lastIndex; i++) {
            data[i] = data[i + 1];
        }
        data[lastIndex] = null;
        size--;
    }

    @Override
    public int indexOf(T e) {
        for (int i = 0; i < size; i++) {
            if (e == null && data[i] == null)
                return i;
            if (e != null && e.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e == null && data[i] == null)
                return i;
            if (e != null && e.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public ArrayI<T> subArray(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        boolean containsAll = true;
        for (T element: collection){
            if (!contains(element)) {
                containsAll = false;
                break;
            }
        }
        return containsAll;
    }

    @Override
    public void addAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        int freeSpace = capacity() - size();
        if (collection.size() > freeSpace){
            throw new RuntimeException("Cannot add all elements, no free space.");
        }
        int j = 0;
        for (int i = size; i < size + collection.size(); i++){
            data[i] = collection.get(j++);
        }
        size += collection.size();
    }

    @Override
    public void replaceAll(Collection<T> collection) {
        replaceAll(collection, 0, 0, collection.size());
    }

    @Override
    public void replaceAll(Collection<T> collection, int startIndexThis, int startIndexCol, int length) {
        Objects.requireNonNull(collection);
        T[] colArray = collection.getArray();
        //startIndexThis should be in range
        if (startIndexThis < 0 || startIndexThis >= capacity)
            throw new IndexOutOfBoundsException("Index: " + startIndexThis + ", Size: " + capacity);
        //startIndexCol should be in range
        if (startIndexCol < 0 || startIndexCol >= colArray.length)
            throw new IndexOutOfBoundsException("Index: " + startIndexCol + ", Size: " + colArray.length);
        //startIndexThis + length - 1 should be in range
        int endIndex = startIndexThis + length;
        if (endIndex < 0 || endIndex > capacity)
            throw new IndexOutOfBoundsException("Index: " + endIndex + ", Size: " + capacity);
        for (int i = startIndexThis; i < endIndex; i++){
            data[i] = colArray[startIndexCol];
            startIndexCol++;
        }
    }

    @Override
    public void removeAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        for (T element: data){
            if (collection.contains(element))
                remove(element);
        }
    }

    @Override
    public void retainAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        for (T element: data){
            if (!collection.contains(element))
                remove(element);
        }
    }

    @Override
    public Jiterator<T> jiterator() {
        return null;
    }

    @Override
    public Jiterator<T> jiterator(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString(){
        if (data == null)
            return "";
        if (isEmpty())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (T element: data) {
            sb.append(element).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
