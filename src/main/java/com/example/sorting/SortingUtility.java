package com.example.sorting;

public class SortingUtility {



    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        int pos = 0;
                while (pos < a.length) {
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos++;
            } else {
                swap(a, pos, pos - 1);
                pos--;
            }
                }
        // TODO implement Gnome Sort here
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {
        boolean swapped = true;
        int start = 0;
        int end = a.length - 1;

        while (swapped) {
            swapped = false;

            // Traverse from left to right
            for (int i = start; i < end; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            // If nothing moved, then the array is sorted
            if (!swapped) {
                break;
            }

            // Otherwise, reset the swapped flag so that it can be used in the next stage
            swapped = false;

            // Move the end point back by one, as the last element is already sorted
            end--;

            // Traverse from right to left
            for (int i = end - 1; i >= start; i--) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            // Move the start point forward by one, as the first element is already sorted
            start++;
        }

        // TODO implement Cocktail Shaker Sort here
    }


    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int n = a.length;
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1}; // Knuth's gap sequence
        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                T temp = a[i];
                int j=i;
                while (j >= gap && a[j - gap].compareTo(temp) > 0) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
        }

        // TODO implement Shell Sort here
    }

    private static <T extends Comparable<T>> void swap(T[] a, int index1, int index2) {

        T temp = a[index1];
        a[index1] = a[index2];
        a [index2] = temp;

    }
}





