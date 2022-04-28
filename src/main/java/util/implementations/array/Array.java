package util.implementations.array;

import util.ArrayUtils;
import util.interfaces.Jiterator;
import util.interfaces.collection.Collection;
import util.interfaces.collection.array.ArrayI;

import java.util.Comparator;
import java.util.Iterator;

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
        if (collection.size() != 0) {
            data = ArrayUtils.copyOf(collection.toArray(), size);
        } else {
            data = (E[]) new Object[]{};
        }
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
        for (int i = 0; i < size; i++)
            data[i] = null;
        size = 0;
    }

    /*Collection base realization*/

    @Override
    public E[] toArray() {
        return ArrayUtils.copyOf(data, size);
    }

    @Override
    public E[] toArray(E[] arr) {
        if (arr.length < size)
            return ArrayUtils.copyOf(data, arr.length);
        System.arraycopy(data, 0, arr, 0, size);
        if (arr.length > size)
            for(int i = size; i < arr.length; i++){
                arr[i] = null;
            }
        return arr;
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
        return (E) data[index];
    }

    /*Modification operations Implementation*/

    @Override
    public E add(E e, int index) {
        return null;
    }

    @Override
    public E add(E e) {
        ensureCapacityInternal(size + 1);
        data[size++] = e;
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
        data = ArrayUtils.copyOf(data, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)? Integer.MAX_VALUE: MAX_ARRAY_SIZE;
    }

    @Override
    public E set(E e, int index) {
        return null;
    }

    @Override
    public E remove(E e) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void sort(Comparator<? super E> comparator) {
        ArrayUtils.sort(data, 0, size, comparator);
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
        return 0;
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
