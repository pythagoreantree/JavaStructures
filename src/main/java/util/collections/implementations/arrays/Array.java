package util.collections.implementations.arrays;

import util.collections.Jiterator;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Array<E> implements ArrayI<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private int capacity = 0;

    private ArrayItem<E>[] data;

    private boolean allowNull = true;

    public Array() {
        this.data = getEmptyArray();
        this.capacity = data.length;
    }

    public Array(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = new ArrayItem[initialCapacity];
            this.capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.data = getEmptyArray();
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public Array(Collection<? extends E> collection) {
        Objects.requireNonNull(collection);
//        this.data = collection.toArray();
//        this.capacity = data.length;
//        this.size = collection.size();
    }

    private ArrayItem[] getEmptyArray(){
        return new ArrayItem[DEFAULT_CAPACITY];
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

    /*
    * As this is an array of fixed size I just make all cells empty
    * */
    @Override
    public void clear() {
        for (int i=0; i<size; i++){
            data[i] = null;
        }
        this.size = 0;
    }

//    @Override
    public Object[] toArray() {
        ArrayItem<E>[] arrayItems = copyArray(size());
        Object[] elems = new Object[arrayItems.length];
        for (int i = 0; i < arrayItems.length; i++){
            elems[i] = arrayItems[i].item;
        }
        return elems;
    }

    @Override
    public Object[] toArray(int length) {
        if (length == 0){
            return getEmptyArray();
        }
        if (length >= size()){
            return toArray();
        }
        return copyArray(size(), length);
    }

    private ArrayItem<E>[] copyArray(int length){
        if (length == 0)
            return getEmptyArray();

        ArrayItem<E>[] copy = new ArrayItem[length];
        for (int i=0; i<length; i++){
            copy[i] = data[i];
        }
        return copy;
    }

    private ArrayItem<E>[] copyArray(int arrLength, int fillLength){
        ArrayItem<E>[] copy = new ArrayItem[arrLength];
        for (int i=0; i<fillLength; i++){
            copy[i] = data[i];
        }
        return copy;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        return data[index].item;
    }

    /*
    * I should add my own exceptions for an array
    * */
    @Override
    public void add(E e, int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        if (size == capacity){
            throw new RuntimeException("No place for a new element");
        }
        if (size < capacity){
            if (!allowNull && e == null){
                throw new RuntimeException("Can't add null element to this type of array");
            }
            //I add an element in this index and all other goes right
            for(int i=index; i<size; i++){
                data[i+1] = data[i];
            }
            size++;
            data[index] = new ArrayItem<>(e);
        }
    }

    @Override
    public void add(E e) {
        if (size == capacity){
            throw new RuntimeException("No place for a new element");
        }
        if (size < capacity){
            if (!allowNull && e == null){
                throw new RuntimeException("Can't add null element to this type of array");
            }
            data[size] = new ArrayItem<>(e);
            size++;
        }
    }

    @Override
    public void set(E e, int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        if (!allowNull && e == null){
            throw new RuntimeException("Can't add null element to this type of array");
        }
        data[index].setItem(e);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity);
        removeByIndex(index);
    }

    @Override
    public void remove(E e) {
        if(!contains(e)){
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
    public void removeAllOccurences(E e) {
        if(!contains(e)){
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
        for (int i=index; i<lastIndex; i++){
            data[i] = data[i+1];
        }
        data[lastIndex] = null;
        size--;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e == null && data[i] == null)
                return i;
            if (e != null && e.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size-1; i >= 0; i--) {
            if (e == null && data[i] == null)
                return i;
            if (e != null && e.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public ArrayI<E> subArray(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean replaceAll(Collection<? extends E> c, int startIndexThis, int startIndexCol, int length) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public Jiterator<E> jiterator() {
        return null;
    }

    @Override
    public Jiterator<E> jiterator(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public boolean isAllowNull() {
        return allowNull;
    }

    public void setAllowNull(boolean allowNull) {
        this.allowNull = allowNull;
    }

    private class ArrayItem<E> {
        private E item;
        public ArrayItem(E elem){
            item = elem;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }
    }

}
