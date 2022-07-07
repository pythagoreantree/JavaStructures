package util.collections.implementations.arrays;

import util.collections.implementations.arrays.enums.ArrayAccess;
import util.collections.Jiterator;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;

public class SecureArray<T> implements Collection<T> {

    private ArrayI<T> array;
    
    private ArrayAccess access = ArrayAccess.READ;

    public SecureArray(){
        array = new Array();
    }

    public SecureArray(Class<T> tClass){
        array = new Array(tClass);
    }
    public SecureArray(Class<T> tClass, int initCapacity){
        array = new Array(tClass, initCapacity);
    }

    private ArrayI<T> requireNonNull(ArrayI<T> array){
        if (array == null)
            throw new NullPointerException("SecureArray is not initialized.");
        return array;
    }

    @Override
    public T[] getArray() {
        if(access != ArrayAccess.NONE){
            return requireNonNull(array).getArray();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public T[] getArray(int length) {
        if(access != ArrayAccess.NONE){
            return requireNonNull(array).getArray(length);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean contains(T e) {
        if(access != ArrayAccess.NONE){
            return requireNonNull(array).contains(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public T get(int index) {
        if(access != ArrayAccess.NONE){
            return requireNonNull(array).get(index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void add(T e, int index) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).add(e, index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void add(T e) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).add(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void set(T e, int index) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).set(e, index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void remove(int index) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).remove(index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void remove(T e) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).remove(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void removeAllOccurences(T e) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).removeAllOccurences(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void addAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).addAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void replaceAll(Collection<T> c) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).replaceAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void replaceAll(Collection c, int startIndexThis, int startIndexCol, int length) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).replaceAll(c, startIndexThis, startIndexCol, length);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void retainAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).retainAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void removeAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).removeAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            return requireNonNull(array).containsAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public int size() {
        if(access != ArrayAccess.NONE){
            return requireNonNull(array).size();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public int capacity() {
        return requireNonNull(array).capacity();
    }

    @Override
    public boolean isEmpty() {
        if(access != ArrayAccess.NONE){
            return requireNonNull(array).isEmpty();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void clear() {
        if(access == ArrayAccess.WRITE){
            requireNonNull(array).clear();
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
