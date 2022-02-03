/**

Problem : Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []

**/

// Solution :

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // A + B + C = 0 
        // B + C = -A  : MAIN LOGIC
        
        // Sorting the Array
        Arrays.sort(nums);
        // Result List
        List<List<Integer>> result = new LinkedList<>();
        // First element of triplet - A
        for(int i = 0;i < nums.length-2;i++) { // n-2 because of triplets
            // To skip duplicate elements at the start
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i+1; // Second element of triplet - B
                int high = nums.length - 1; // Third element of triplet - C
                int sum = 0 - nums[i];  // to find the value of (-A)
                
                while(low < high) {
                    
                    // Checking if B + C = -A
                    if(nums[low] + nums[high] == sum) { 
                        
                        // Adding the triplet
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // Skipping Duplicates
                        while(low < high && nums[low] == nums[low+1])
                            low++;
                        while(low < high && nums[high] == nums[high-1])
                            high--;
                        
                        low++;
                        high--;
                    }
                    
                    // If B + C < -A
                    else if(nums[low] + nums[high] < sum) low++;
                    
                    else high--; // If B + C > -A
                }
            }
        }
        return result;
    }
}
