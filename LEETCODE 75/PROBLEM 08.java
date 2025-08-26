/*
PROBLEM STATEMENT
INCREASING TRIPLET SEQUENCE
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. 
If no such indices exists, return false.
  
Example 1:
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
  
Example 2:
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
  
Example 3:
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 
Constraints:
1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1

SOLUTION */

//APPROACH 1 ---NOT PASSED ALL THE TEST CASES
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        boolean result=false;
        int count=0;
        int j,k,l;
        for(int i=0;i<n-2;i++){
            j=i;
            k=i+1;
            l=i+2;
            if((nums[j]<nums[k])&&(nums[k]<nums[l])){
                count+=1;
            }
        }
        if(count>=1){
            return true;
        }
        else{
            return false;
        }
    }
}

//APPROACH 2 ---NOT PASSED ALL THE TEST CASES
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int count;
        int temp;
        for(int i=0;i<n-2;i++){
            temp=nums[i];
            count=0;
            for(int j=i+1;j<n;j++){
                if(temp<nums[j])
                {
                    temp=nums[j];
                    count+=1;
                    if(count>=2){
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
}

//APPROACH 3
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int num:nums)
        {
            if(num<=first)
            {
                first=num;
            }
            else if(num<=second)
            {
                second=num;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
 
