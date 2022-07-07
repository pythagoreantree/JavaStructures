package util.collections.implementations.arrays;

import util.collections.implementations.arrays.enums.ArrayAccess;
import util.collections.Jiterator;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;

public class SecureArray<T> implements Collection<T> {

    private ArrayI<T> array;

    private ArrayAccess access = ArrayAccess.READ;

    @Override
    public T[] getArray() {
        if(access != ArrayAccess.NONE){
            return array.getArray();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public T[] getArray(int length) {
        if(access != ArrayAccess.NONE){
            return array.getArray(length);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean contains(T e) {
        if(access != ArrayAccess.NONE){
            return array.contains(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public T get(int index) {
        if(access != ArrayAccess.NONE){
            return array.get(index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void add(T e, int index) {
        if(access == ArrayAccess.WRITE){
            array.add(e, index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void add(T e) {
        if(access == ArrayAccess.WRITE){
            array.add(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void set(T e, int index) {
        if(access == ArrayAccess.WRITE){
            array.set(e, index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void remove(int index) {
        if(access == ArrayAccess.WRITE){
            array.remove(index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void remove(T e) {
        if(access == ArrayAccess.WRITE){
            array.remove(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void removeAllOccurences(T e) {
        if(access == ArrayAccess.WRITE){
            array.removeAllOccurences(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void addAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            array.addAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void replaceAll(Collection c, int startIndexThis, int startIndexCol, int length) {
        if(access == ArrayAccess.WRITE){
            array.replaceAll(c, startIndexThis, startIndexCol, length);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void retainAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            array.retainAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void removeAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            array.removeAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            return array.containsAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public int size() {
        if(access != ArrayAccess.NONE){
            return array.size();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if(access != ArrayAccess.NONE){
            return array.isEmpty();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void clear() {
        if(access == ArrayAccess.WRITE){
            array.clear();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public Jiterator jiterator() {
        return null;
    }

    @Override
    public Jiterator jiterator(int index) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public ArrayAccess getAccess() {
        return access;
    }

    public void setAccess(ArrayAccess access) {
        this.access = access;
    }
}
