
/******************************************************************
 *
 *   Julian Solis / 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     * Input: [1,50,55,80,90], [55,90]
     * Output: true
     * Input: [1,50,55,80,90], [55,90, 99]
     * Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE
        HashSet<Integer> set1 = new HashSet<>();

        for (int num : list1) {// Adding all elements from list1 into our HashSet
            set1.add(num);

        }

        for (int num : list2) {// for each element in list2, if any value in list2 is not in list1 then it is
                               // not a subset
            if (!set1.contains(num)) {
                return false;
            }

        }

        return true;// if we have reached this point, we know that all elements in list2 are within
                    // list1, return true
    }

    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     * Input: [1,7,3,10,34,5,8], 4
     * Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();// create minHeap

        for (int i = 0; i <= k; i++) {// Add k elements to our minHeap
            minHeap.add(array[i]);// Adding k elements to our minHeap
        }

        for (int i = k; i < array.length; i++) {// iterate over the rest of the array, comparing the root of the minHeap
                                                // to the rest of the array, which will help us maintain the top k-th
                                                // integers
            if (minHeap.peek() < array[i]) {// if the integer at the root is less than a value in the array, remove the
                                            // integer at the root and replace it with this value. minHeap property
                                            // helps us maintain top k elements.
                minHeap.poll();// remove the element from the root
                minHeap.add(array[i]);// add the element that was larger than the element in the root to the minHeap
            }
        }

        return minHeap.peek();// return the element in the root as it is the kth maximum value
    }

    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     * Input: [4,1,5], [3,2]
     * Output: 1 2 3 4 5
     *
     * @param array1 - Input array 1
     * @param array2 - Input array 2
     * @return - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE
        // Create minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Create an array of that is as large as the size of both arrays combined
        int[] sortedArray = new int[array1.length + array2.length];

        // Add all elements from array1 to the minHeap
        for (int num : array1) {
            minHeap.add(num);
        }

        // Add all elements from array2 to the minHeap
        for (int num : array2) {
            minHeap.add(num);
        }

        int index = 0;// initialize an int index to track our position in the sorted array as we add
                      // the root of the minHeap into the array
        while (!minHeap.isEmpty()) {// while the minHeap still contains elements
            sortedArray[index++] = minHeap.poll();// pull the root of the minHeap and place it into the array which
                                                  // effectively creates a sorted array as the minHeap maintains the
                                                  // lowest element in it's root.
        }

        return sortedArray;// return the sort array
    }

}