/**
Problem :- Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1

Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

Example 3:

Input: nums = [1]
Output: 1
**/

// Solution :-

class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int c = map.get(nums[i]);
                map.put(nums[i],++c);
            }
            else {
                map.put(nums[i],1);
            }
        }
        for(Integer element : map.keySet()) {
            if(map.get(element) == 1) {
                num = element;
                break;
            }
        }
        return num;
    }
}

/**
Approach :-
* Using Hashmap, we map frequency of each element in the array and then using that return the element whose frequency is 1.
**/
