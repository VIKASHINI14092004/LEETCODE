/*
PROBLEM:
GREATEST COMMON DIVISOR OF STRINGS

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
  
Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
  
Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.

SOLUTION: 1
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {

        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcd = findGCD(str1.length(),str2.length());
       
        String res = str1.substring(0,gcd);
        return res;
        
        
        
    }
    int findGCD(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}


// SOLUTION: 2

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!((str1+str2).equals(str2+str1)))
        {
            return"";
        }
        int gcdl=gcd(str1.length(),str2.length());
        return str1.substring(0,gcdl);
    }
    private int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }
}





