package util.collections.implementations.arrays;

import util.collections.implementations.arrays.enums.ArrayAccess;
import util.collections.Jiterator;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;

public class SecureArray<T> extends Array<T> {

    private ArrayAccess access = ArrayAccess.READ;

    public SecureArray(){
        super();
    }

    @Override
    public T[] getArray() {
        if(access != ArrayAccess.NONE){
            return super.getArray();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public T[] getArray(int length) {
        if(access != ArrayAccess.NONE){
            return super.getArray(length);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean contains(T e) {
        if(access != ArrayAccess.NONE){
            return super.contains(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public T get(int index) {
        if(access != ArrayAccess.NONE){
            return super.get(index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void add(T e, int index) {
        if(access == ArrayAccess.WRITE){
            super.add(e, index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void add(T e) {
        if(access == ArrayAccess.WRITE){
            super.add(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void set(T e, int index) {
        if(access == ArrayAccess.WRITE){
            super.set(e, index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void remove(int index) {
        if(access == ArrayAccess.WRITE){
            super.remove(index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void remove(T e) {
        if(access == ArrayAccess.WRITE){
            super.remove(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void removeAllOccurences(T e) {
        if(access == ArrayAccess.WRITE){
            super.removeAllOccurences(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void addAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            super.addAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void replaceAll(Collection c, int startIndexThis, int startIndexCol, int length) {
        if(access == ArrayAccess.WRITE){
            super.replaceAll(c, startIndexThis, startIndexCol, length);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void retainAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            super.retainAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void removeAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            super.removeAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            return super.containsAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public int size() {
        if(access != ArrayAccess.NONE){
            return super.size();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public int capacity() {
        return super.capacity();
    }

    @Override
    public boolean isEmpty() {
        if(access != ArrayAccess.NONE){
            return super.isEmpty();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void clear() {
        if(access == ArrayAccess.WRITE){
            super.clear();
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
