package util.collections.implementations.arrays;

import util.collections.Jiterator;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;
import java.util.Objects;

public class ObjectArray<T> implements ArrayI<T> {

    private static final int DEFAULT_CAPACITY = 16;

    private int capacity = 0;

    public Object[] array;

    public ObjectArray() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ObjectArray(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    public ObjectArray(T[] definedArray){
        array = definedArray;
    }

    public ObjectArray(Collection<? extends T> collection){
        Objects.requireNonNull(collection);
        array = new Object[collection.size()];
        for (T elem: collection){
//            add(elem);
        }
    }

    @Override
    public int indexOf(T e) {
        return 0;
    }

    @Override
    public int lastIndexOf(T e) {
        return 0;
    }

    @Override
    public ArrayI<T> subArray(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public T[] getArray() {
        return null;
    }

    @Override
    public T[] getArray(int length) {
        return null;
    }

    @Override
    public boolean contains(T e) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void add(T e, int index) {

    }

    @Override
    public void add(T e) {

    }

    @Override
    public void set(T e, int index) {

    }

    @Override
    public void removeAtIndex(int index) {

    }

    @Override
    public void remove(T e) {

    }

    @Override
    public void removeFirst(T e) {

    }

    @Override
    public void removeLast(T e) {

    }

    @Override
    public void removeAllOccurences(T e) {

    }

    @Override
    public boolean containsAll(Collection<T> c) {
        return false;
    }

    @Override
    public void addAll(Collection<T> c) {

    }

    @Override
    public void replaceAll(Collection<T> c) {

    }

    @Override
    public void replaceAll(Collection<T> c, int startIndexThis, int startIndexCol, int length) {

    }

    @Override
    public void removeAll(Collection<T> c) {

    }

    @Override
    public void retainAll(Collection<T> c) {

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
    public int size() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
