/*
PROBLEM STATEMENT
REVERSE VOWELS OF A STRING
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "IceCreAm"
Output: "AceCreIm"
Explanation:
The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

SOLUTION: */
class Solution {
    public String reverseVowels(String s) 
    {
        char arr[]=s.toCharArray();
        int n=arr.length;
        int right=n-1;
        int left=0;
    
        while(left<right)
            {
            
                if(!isvowel(arr[left])) 
                    {
                        left++;
                    }
                else if(!isvowel(arr[right]))
                    {
                        right--;
                    }  
                else
                    {
                        char temp=arr[left];
                        arr[left]=arr[right];
                        arr[right]=temp;
                        right--;
                        left++;
                    } 
           }

        return new String(arr);  
    }
    private boolean isvowel(char c)
    {
        char r=Character.toLowerCase(c);
        return r=='a'||r=='e'||r=='i'||r=='o'||r=='u';
    }
}
