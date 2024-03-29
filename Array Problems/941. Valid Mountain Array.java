/**
Problem :-
Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
--> arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
--> arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Example 1:
Input: arr = [2,1]
Output: false
Example 2:
Input: arr = [3,5,5]
Output: false
Example 3:
Input: arr = [0,3,2,1]
Output: true
**/

// Solution :-

// Solution 1

class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
		while(i < arr.length && (i+1) < arr.length && arr[i] < arr[i+1]) {
		    i++;
		}
		if(i==0 || (i+1) == arr.length) {
		    return false;
		}
		while(i < arr.length && (i+1) < arr.length) {
		    if(arr[i] <= arr[i++ +1])
		        return false;
		}
		return true;
    }
}

/**
1. Simple Approach :-
*  Using (i) as a pointer through the array, we find the index to which the array is strictly increasing. After traversal, if (i) is 0 or equal to the length of the array -> it means that either the array has no increasing part or the array has only increasing part. Therefore we return false
*  After that we check for the strictly decreasing part. Here we check in a opposite way.If any value is found which is not less than the previous one, then we return false otherwise the process continues.
*  In the end, after all of this checked we return true as all the possibilities of the array not being a Valid Moountain array have been processed.
**/

//Solution 2
class Solution {
    public boolean validMountainArray(int[] arr) {
        int count = 0;
        if(arr.length<3){
            return false;
        }
        else{
            if(arr[0] < arr[1] && arr[arr.length-1] < arr[arr.length-2]){
                for(int i = 1; i <arr.length-1;i++){
                    if(arr[i] != arr[i+1]){
                      if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                        count++;
                      }
                    }
                    else count++;
                }
            }
        }
                if(count == 1){
                    return true;
                }
                else return false;
            
     }
        
 }
 
/**
 2. Peak Value Approach :-
* Here we check for the element of the array which is greater than both of its neighbours.
* If we have more than one such value than the array is not a Valid Mountain Array.
* We also add an extra if statement to compare the values at the boundaries and check if they are in order.
**/
