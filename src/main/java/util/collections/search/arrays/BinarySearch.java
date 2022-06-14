package util.collections.search.arrays;

import util.collections.implementations.arrays.Array;
import util.collections.implementations.arrays.primitives.*;
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

    public static <E> int search(E[] arr, E elem) {
        if (arr == null || arr.length == 0)
            return -1;

        if (elem == null)
            return -1;

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Comparable<E> midElem = (Comparable) arr[mid];
            int comparisonResult = midElem.compareTo(elem);
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
        return searchPrimitive(new LongArray(arr).getLongs(), Long.valueOf(elem));
    }

    public static int binarySearch(int[] arr, int elem) {
        return searchPrimitive(new IntegerArray(arr).getIntegers(), Integer.valueOf(elem));
    }

    public static int binarySearch(short[] arr, short elem) {
        return searchPrimitive(new ShortArray(arr).getShorts(), Short.valueOf(elem));
    }

    public static int binarySearch(char[] arr, char elem) {
        return searchChars(new CharArray(arr).getChars(), Character.valueOf(elem));
    }

    public static int binarySearch(byte[] arr, byte elem) {
        return searchPrimitive(new ByteArray(arr).getBytes(), Byte.valueOf(elem));
    }

    public static int binarySearch(double[] arr, double elem){
        return searchPrimitive(new DoubleArray(arr).getDoubles(), Double.valueOf(elem));
    }

    public static int binarySearch(float[] arr, float elem){
        return searchPrimitive(new FloatArray(arr).getFloat(), Float.valueOf(elem));
    }

    private static int searchPrimitive(Array<? extends Number> arr, Number elem){
        return search(arr.toArray(), elem);
    }

    private static int searchChars(Array<Character> arr, Character elem){
        return search(arr.toArray(), elem);
    }

    /*
    * Sort and Search Array
    * */
    public static <E> int sortAndSearch(E[] arr, E elem) {
        MergeSort.sort(arr);
        return search(arr, elem);
    }

    public static <E> int sortAndSearch(E[] arr, E elem, SortingAlgorithm<E> algorithm) {
        if (algorithm == null)
            throw new RuntimeException("Please, define the sorting algorythm");
        algorithm.sort(arr);
        return search(arr, elem);
    }

}
