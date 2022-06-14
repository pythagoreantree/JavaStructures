package util.collections.implementations.arrays;

import util.collections.implementations.arrays.enums.ArrayAccess;
import util.collections.Jiterator;
import util.collections.interfaces.collection.Collection;
import util.collections.interfaces.collection.array.ArrayI;

import java.util.Iterator;

public class SecureArray<E> implements Collection<E> {

    private ArrayI<E> array;

    private ArrayAccess access = ArrayAccess.READ;

    @Override
    public Object[] toArray() {
        if(access != ArrayAccess.NONE){
            return array.toArray();
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public Object[] toArray(int length) {
        if(access != ArrayAccess.NONE){
            return array.toArray(length);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean contains(E e) {
        if(access != ArrayAccess.NONE){
            return array.contains(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public E get(int index) {
        if(access != ArrayAccess.NONE){
            return array.get(index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void add(E e, int index) {
        if(access == ArrayAccess.WRITE){
            array.add(e, index);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void add(E e) {
        if(access == ArrayAccess.WRITE){
            array.add(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void set(E e, int index) {
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
    public void remove(E e) {
        if(access == ArrayAccess.WRITE){
            array.remove(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public void removeAllOccurences(E e) {
        if(access == ArrayAccess.WRITE){
            array.removeAllOccurences(e);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean addAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            return array.addAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean replaceAll(Collection c, int startIndexThis, int startIndexCol, int length) {
        if(access == ArrayAccess.WRITE){
            return array.replaceAll(c, startIndexThis, startIndexCol, length);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean retainAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            return array.retainAll(c);
        } else {
            throw new RuntimeException("Permission denied.");
        }
    }

    @Override
    public boolean removeAll(Collection c) {
        if(access == ArrayAccess.WRITE){
            return array.removeAll(c);
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
