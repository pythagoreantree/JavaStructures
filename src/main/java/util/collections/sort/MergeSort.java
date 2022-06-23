package util.collections.sort;

public class MergeSort {

    public static <E> void sort(E[] arr) {
    }

    public static void sort(int[] arr) {
        sort(arr, arr.length);
    }

    public static void sort(int[] arr, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = arr[i];
        }
        sort(left, mid);
        sort(right, length - mid);

        merge(arr, left, right, mid, length - mid);
    }

    public static void merge(int[] arr, int[] left, int[] right, int n, int m) {
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n) {
            arr[k++] = left[i++];
        }
        while (j < m) {
            arr[k++] = right[j++];
        }
    }
}
