package util.implementations.array;

import util.interfaces.Jiterator;
import util.interfaces.collection.Collection;
import util.interfaces.collection.array.ArrayI;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
 * To-Do
 * 1. size vs capacity (which variable shows which concept)
 * 2. test everything
 * */
public class DynamicArray<E> implements ArrayI<E> {

    /*Constants*/
    private static final int DEFAULT_CAPACITY = 0;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private static final double MEMORY_INCREASE_INDEX = 1.5;
    private static final double MEMORY_DECREASE_INDEX = 0.75;
    private static final double HALF = 0.5;

    int capacity = 0;

    /*main array to present the list*/
    transient E[] data;

    public DynamicArray() {
        this.data = getEmptyArray();
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = (E[]) new Object[initialCapacity];
            this.capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.data = getEmptyArray();
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public DynamicArray(Collection<? extends E> collection) {
        Objects.requireNonNull(collection);
        this.data = collection.toArray();
        this.capacity = data.length;
    }

    private E[] getEmptyArray(){
        return (E[]) new Object[]{};
    }

    /*Container methods realization*/

    /*size means how much it is filled*/
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /*
    * clear может иметь 2 значения:
    * 1. capacity останется. numberOfElements станет 0. Все элементы станут null.
    * 2. capacity станет 0, numberOfElements станет 0. Элементов не будет.
    * Вопрос, что тут выбрать?
    * Оба варианта имеют место быть.
    * При добавлении capacity будет увеличиваться, поэтому можно просто сделать пустой массив.
    * Или можно оставить capacity и просто занулить.
    * Так как это моя коллекция, мне бы хотелось здесь установить на дефолтное значение.
    * Для этого можно сделать отдельную функцию reset()
    * Я бы хотела начинать с пустого массива. И на clear делать его нулевой длины
    * Пусть динамика будет именно такой
    * */
    @Override
    public void clear() {
        data = getEmptyArray();
    }

    /*Collection base realization*/

    /*
    * По идее это getCopyArray()
    * Для этой коллекции нам совсем не нужен метод toArray()
    * Иначе получается DynamicArray.toArray() очень странный метод
    * Это скорее getCopy() или copy()
    * */
    @Override
    public E[] toArray() {
        return (size != 0)? copyArray(size): getEmptyArray();
    }


    @Override
    public E[] toArray(int arrLength) {
        if (arrLength == 0){
            return getEmptyArray();
        }
        if (arrLength < size){
            return copyArray(arrLength);
        } else if (arrLength == size) {
            return toArray();
        } else {
            E[] copy = (E[]) new Object[arrLength];
            for (int i=0; i<size; i++){
                copy[i] = data[i];
            }
            //not sure if it's needed
            for(int i = size; i < arrLength; i++){
                copy[i] = null;
            }
            return copy;
        }
    }

    private E[] copyArray(int length){
        E[] copy = (E[]) new Object[length];
        for (int i=0; i<length; i++){
            copy[i] = data[i];
        }
        return copy;
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
    public void add(E e, int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index >= size){
            add(e);
        } else {
            int currentSize = size;
            //what would be here after size? Nulls or rubbish?
            ensureCapacityInternal(size + 1);
            for (int i=currentSize-1; i>index; i--){
                data[i] = data[i-1];
            }
//        System.arraycopy(data, index, data, index + 1, size - index);
            addElem(e, index);
        }
    }

    @Override
    public void add(E e) {
        ensureCapacityInternal(size + 1);
        addElem(e, size);
    }

    private void addElem(E e, int index){
        data[index] = e;
        size++;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(minCapacity);
    }

//    private int calculateCapacity(Object[] data, int minCapacity) {
//        if (data == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//            return Math.max(DEFAULT_CAPACITY, minCapacity);
//        }
//        return minCapacity;
//    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - data.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        this.capacity = Double.valueOf(capacity*MEMORY_INCREASE_INDEX).intValue();
//        if (this.capacity - minCapacity < 0)
//            this.capacity = minCapacity;
        if (this.capacity - MAX_ARRAY_SIZE > 0)
            this.capacity = hugeCapacity(minCapacity);
        this.data = toArray(this.capacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)? Integer.MAX_VALUE: MAX_ARRAY_SIZE;
    }

    @Override
    public void set(E e, int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        data[index] = e;
    }

    @Override
    public void remove(E e) {
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
        optimizeCapacity();
    }

    private void optimizeCapacity(){
        if (size == 0){
            capacity = DEFAULT_CAPACITY;
            data = getEmptyArray();
        } else {
            if (size < Double.valueOf(capacity*HALF).intValue()){
                capacity = Double.valueOf(capacity*MEMORY_DECREASE_INDEX).intValue();
                data = toArray(this.capacity);
            }
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        removeByIndex(index);
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

    /*
    * Возможно, size всегда лучше брать через size(), но это неточно
    * */
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
