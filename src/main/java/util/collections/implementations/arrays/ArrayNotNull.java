package util.collections.implementations.arrays;

import util.collections.interfaces.collection.Collection;

import java.util.Objects;

public class ArrayNotNull<T> extends Array<T> {

    public ArrayNotNull() {
        super();
    }

    public ArrayNotNull(int initialCapacity) {
        super(initialCapacity);
    }

    public ArrayNotNull(Class<T> eClass) {
        super(eClass);
    }

    public ArrayNotNull(Class<T> eClass, int initialCapacity) {
        super(eClass, initialCapacity);
    }

    @Override
    public boolean contains(T e) {
        if (e == null)
            return false;
        return indexOf(e) >= 0;
    }

    @Override
    public void add(T e, int index) {
        if (e == null)
            throw new RuntimeException("Can't add null element to this type of array");
        super.add(e, index);
    }

    @Override
    public void add(T e) {
        if (e == null)
            throw new RuntimeException("Can't add null element to this type of array");
        super.add(e);
    }

    @Override
    public void set(T e, int index) {
        if (e == null)
            throw new RuntimeException("Can't add null element to this type of array");
        super.set(e, index);
    }

    @Override
    public void remove(T e) {
        if (e == null)
            throw new RuntimeException("Can't remove null element from this type of array");
        super.remove(e);
    }

    @Override
    public void removeAllOccurences(T e) {
        if (e == null)
            throw new RuntimeException("Can't remove null element from this type of array");
        super.removeAllOccurences(e);
    }

    @Override
    public int indexOf(T e) {
        if (e == null)
            return -1;
        for (int i = 0; i < size(); i++) {
            if (e.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T e) {
        if (e == null)
            return -1;
        for (int i = size() - 1; i >= 0; i--) {
            if (e.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        collection.removeAllOccurences(null);
        return super.containsAll(collection);
    }

    @Override
    public void addAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        collection.removeAllOccurences(null);
        super.addAll(collection);
    }

    @Override
    public void replaceAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        collection.removeAllOccurences(null);
        super.replaceAll(collection);
    }

    @Override
    public void replaceAll(Collection<T> collection, int startIndexThis, int startIndexCol, int length) {
        Objects.requireNonNull(collection);
        collection.removeAllOccurences(null);
        super.replaceAll(collection, startIndexThis, startIndexCol, length);
    }

    @Override
    public void removeAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        collection.removeAllOccurences(null);
        super.removeAll(collection);
    }

    @Override
    public void retainAll(Collection<T> collection) {
        Objects.requireNonNull(collection);
        collection.removeAllOccurences(null);
        super.retainAll(collection);
    }
}
