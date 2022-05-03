package util.implementations.array;

import util.interfaces.Jiterator;
import util.interfaces.collection.Collection;
import util.interfaces.collection.array.ArrayI;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
* To-Do
* 1. size vs capacity (which variable shows which concept)
* 2. test everything
* */
public class Array<E> implements ArrayI<E> {

    /*Constants*/
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /*main array to present the list*/
    transient E[] data;

    public Array() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public Array(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.data = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public Array(Collection<? extends E> collection) {
        data = collection.toArray();
    }

    /*Container methods realization*/

    /*size means how much it is filled*/
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
//        for (int i = 0; i < size; i++)
//            data[i] = null;
        int current_size = size();
        data = (E[]) new Object[current_size];
    }

    /*Collection base realization*/

    @Override
    public E[] toArray() {
        if (size != 0) {
            E[] copy = (E[]) new Object[size];
            for (int i=0; i<size; i++){
                copy[i] = data[i];
            }
            return copy;
        } else {
            return (E[]) new Object[DEFAULT_CAPACITY];
        }

    }


    @Override
    public E[] toArray(int arrLength) {
        if (arrLength == 0){
            return (E[]) new Object[DEFAULT_CAPACITY];
        }
        if (arrLength < size){
            E[] copy = (E[]) new Object[arrLength];
            for (int i=0; i<arrLength; i++){
                copy[i] = data[i];
            }
            return copy;
        } else if (arrLength == size) {
            return toArray();
        } else {
            E[] copy = (E[]) new Object[arrLength];
            for (int i=0; i<size; i++){
                copy[i] = data[i];
            }
            //not sure it is needed
            for(int i = size; i < arrLength; i++){
                copy[i] = null;
            }
            return copy;
        }
    }

    /*Query operations Implementation*/

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index];
    }

    /*Modification operations Implementation*/

    @Override
    public E add(E e, int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index >= size){
            return add(e);
        }
        int currentSize = size;
        //what would be here after size? Nulls or rubbish?
        ensureCapacityInternal(size + 1);
        for (int i=currentSize-1; i>index; i--){
            data[i] = data[i-1];
        }
//        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        return e;
    }

    @Override
    public E add(E e) {
        ensureCapacityInternal(size + 1);
        data[size++] = e; //разобраться, что тут значит size!
        return e;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(data, minCapacity));
    }

    private int calculateCapacity(Object[] data, int minCapacity) {
        if (data == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - data.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        data = toArray(newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)? Integer.MAX_VALUE: MAX_ARRAY_SIZE;
    }

    @Override
    public E set(E e, int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        E oldValue = data[index];
        data[index] = e;
        return oldValue;
    }

    @Override
    public E remove(E e) {
        if(!contains(e)){
            throw new NoSuchElementException("");
        }
        for (int i = 0; i < size; i++) {
            if (e == null && data[i] == null) {
                return removeByIndex(i);
            }
            if (e != null && e.equals(data[i])) {
                return removeByIndex(i);
            }
        }
        return e;
    }

    private E removeByIndex(int index) {
        E oldValue = data[index];
        for (int i=index; i<size-1; i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        return removeByIndex(index);
    }

    @Override
    public void removeAllOccurences(E e){
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

    @Override
    public void sort(Comparator<? super E> comparator) {
//        ArrayUtils.sort(data, 0, size, comparator);
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
    public Array<E> subArray(int fromIndex, int toIndex) {
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


}
