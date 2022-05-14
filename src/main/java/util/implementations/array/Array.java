package util.implementations.array;

import util.interfaces.Jiterator;
import util.interfaces.collection.Collection;
import util.interfaces.collection.array.ArrayI;

import java.util.Comparator;
import java.util.Iterator;


public class Array<E> implements ArrayI<E> {


    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public ArrayI<E> subArray(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public E[] toArray(int length) {
        return null;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void add(E e, int index) {
    }

    @Override
    public void add(E e) {
    }

    @Override
    public void set(E e, int index) {
    }

    @Override
    public void remove(int index) {
    }

    @Override
    public void remove(E e) {
    }

    @Override
    public void removeAllOccurences(E e) {

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

    @Override
    public int size() {
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
