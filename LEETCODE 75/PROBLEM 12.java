/*
PROBLEM STATEMENT
CONTAINER WITH MOST WATER
  
You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/

// SOLUTION  
// APPROACH 1 21/65 PASSED
  class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int front=0;
        for(int i=1;i<n/2;i++)
        {
            if(height[i]>height[front])
            {
                front=i;
            }
        }
        int last=front+1;
        System.out.println(front);
        for(int i=last;i<n-1;i++)
        {
            
            if((height[i]<height[i+1]) && (((i-front)*height[i])<((i+1-front)*height[i+1])))
            {
                last=i+1;
            }
        }
       int h=Math.min(height[last],height[front]);
       int l=last-front;
       int area=l*h;
       return area;
        
    }
}

//APPROCH 2 -----59/65 passes time limit exceeded
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int area=0;
        int h=0;
        int l=0;
        for(int i=0;i<n;i++)
        {
            
            for(int j=i+1;j<n;j++)
            {
                 l=j-i;
                 h=Math.min(height[i],height[j]);
                if(area<(l*h))
                {
                    area=l*h;
                }
                
            }
           
        }
        return area;
    }
}
//APPROACH 3
class Solution {
    public int maxArea(int[] height) {
       int n=height.length;
       int left=0;
       int right=n-1;
       int maxArea=0;
       while(left<right)
       {
        int l=right-left;
        int b=Math.min(height[right],height[left]);
        int area=l*b;
        maxArea=Math.max(maxArea,area);
        if(height[right]<height[left])
        {
            right--;
        }
        else
        {
            left++;
        }
       } 
    return maxArea;
    }
}
