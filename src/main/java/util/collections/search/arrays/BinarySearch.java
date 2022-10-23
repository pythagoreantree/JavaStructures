package util.collections.search.arrays;

import util.collections.implementations.array.primitives.*;
import util.collections.sort.MergeSort;
import util.collections.sort.SortingAlgorithm;

import java.util.Comparator;

public class BinarySearch {

    /*
    * Classic Raw Binary Search (with Comparator and Comparable).
    * */
    public static <E> int search(E[] arr, E elem, Comparator<? super E> comparator) {
        if (arr == null || arr.length == 0)
            return -1;

        if (elem == null)
            return -1;

        if (comparator == null)
            throw new RuntimeException("Cannot compare this type of elements");

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonResult = comparator.compare(arr[mid], elem);
            if (comparisonResult == 0) {
                return mid;
            } else if (comparisonResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int search(E[] arr, E elem) {
        if (arr == null || arr.length == 0)
            return -1;

        if (elem == null)
            return -1;

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonResult = arr[mid].compareTo(elem);
            if (comparisonResult == 0) {
                return mid;
            } else if (comparisonResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*
    * Binary Search for primitives
    * */
    public static int binarySearch(long[] arr, long elem) {
        return search(new LongArray(arr).getLongs().getArray(), Long.valueOf(elem));
    }

    public static int binarySearch(int[] arr, int elem) {
        return search(new IntegerArray(arr).getIntegers().getArray(), Integer.valueOf(elem));
    }

    public static int binarySearch(short[] arr, short elem) {
        return search(new ShortArray(arr).getShorts().getArray(), Short.valueOf(elem));
    }

    public static int binarySearch(char[] arr, char elem) {
        return search(new CharArray(arr).getChars().getArray(), Character.valueOf(elem));
    }

    public static int binarySearch(byte[] arr, byte elem) {
        return search(new ByteArray(arr).getBytes().getArray(), Byte.valueOf(elem));
    }

    public static int binarySearch(double[] arr, double elem){
        return search(new DoubleArray(arr).getDoubles().getArray(), Double.valueOf(elem));
    }

    public static int binarySearch(float[] arr, float elem){
        return search(new FloatArray(arr).getFloat().getArray(), Float.valueOf(elem));
    }

    /*
    * Sort and Search Array
    * */
    public static <E extends Comparable<E>> int sortAndSearch(E[] arr, E elem) {
        MergeSort.sort(arr);
        return search(arr, elem);
    }

    public static <E extends Comparable<E>> int sortAndSearch(E[] arr, E elem, SortingAlgorithm<E> algorithm) {
        if (algorithm == null)
            throw new RuntimeException("Please, define the sorting algorythm");
        algorithm.sort(arr);
        return search(arr, elem);
    }

}
