package com.keplux;

/**
 * Utility class containing sort methods.
 */
public class Sort {
    /**
     * This function takes an array and breaks it down into individual arrays.
     *
     * @param array The array to break down.
     */
    public static void mergeSort(int[] array) {
        int arraySize = array.length;

        // If there's only one element, there's nothing left to break down.
        if (arraySize == 1) {
            return;
        }

        // Get the middle index to break down the array.
        int midIndex = arraySize / 2;

        // Get size of each individual array.
        int leftSize = midIndex;
        int rightSize = arraySize - midIndex;

        // Create temporary arrays to copy values from original array to.
        // Left array:
        int[] leftArray = new int[leftSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[i];
        }
        // Right array:
        int[] rightArray = new int[rightSize];
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = array[midIndex];
            midIndex++;
        }

        // Recursively break down the arrays.
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Merge the arrays with the helper method.
        merge(array, leftArray, rightArray);
    }

    /**
     * Helper method to merge two arrays into a main array.
     * @param array The main array.
     * @param leftArray The left array.
     * @param rightArray The right array.
     */
    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        // Get the size of the smaller arrays.
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        // Initialize variables to track indexes.
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = 0;

        // Merge elements from the left and right arrays while both arrays have
        // more elements.
        while (leftIndex < leftSize && rightIndex < rightSize) {
            // If the left array's value is <= to the right array's value, set
            // it as the value at the array's current index.
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[arrayIndex] = leftArray[leftIndex];
                leftIndex++; // Move to the next position
            }
            // Otherwise, set the value with the right array.
            else {
                array[arrayIndex] = rightArray[rightIndex];
                rightIndex++; // Move to the next position
            }
            arrayIndex++; // Move to the next position
        }

        // Put leftover elements in the main array.
        // When rightArray is empty:
        while (leftIndex < leftSize) {
            array[arrayIndex] = leftArray[leftIndex];
            leftIndex++;
            arrayIndex++;
        }
        // When leftArray is empty:
        while (rightIndex < rightSize) {
            array[arrayIndex] = rightArray[rightIndex];
            rightIndex++;
            arrayIndex++;
        }
    }
}
