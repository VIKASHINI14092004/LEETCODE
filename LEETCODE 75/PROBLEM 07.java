/*
PROBLEM STATEMENT
PRODUCT OF ARRAY EXCEPT ITSELF
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
  
Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

SOLUTION */

//APPROACH 1
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        int prod=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    prod*=nums[j];
                }
            }
            result[i]=prod;
            prod=1;

        }
        return result;---APPROACH-1 19/24 TESTCASE PASS TIME LIMIT ER
    }
}

//APPROACH 2
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        int totalProd=1;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                totalProd*=nums[i];
            }
            else{
                count++;
            }}
        Arrays.fill(result,0);
        if(count>=2)
        {
            return result;
        }
        else{
            for(int i=0;i<n;i++){
                if(count==1){
                     if(nums[i]==0){
                         result[i]=totalProd;
                        }
                }
                else{
                    result[i]=totalProd/nums[i];
                    }
        }
        }
    return result;
    }
}
 
