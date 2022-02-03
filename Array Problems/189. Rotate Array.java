/**

Problem : Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]

Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

**/

// Solution

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // When the number of steps is greater than the length of the array 
        
        // Reversing the whole Array
        reverse(nums, 0, nums.length-1);
        // Reversing the first k elements
        reverse(nums, 0, k-1);
        // Reversing the remaining elements
        reverse(nums, k, nums.length-1);
    }
    
    public void reverse(int[] arr, int start, int end) {
        // Logic for reversing an array
        while(start < end) {
            // Swapping the first and last elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
} 
