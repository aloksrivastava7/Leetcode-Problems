/**

Problem : Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

**/

// Solution :

class Solution {
    public boolean isAnagram(String s, String t) {
        
        //  FIRST METHOD 
        if(s.length() == t.length()) {  // Anagram only possible when both strings are of equal length
            // Splitting the Strings into Character Arrays
            char[] str1 = s.toCharArray();  
            char[] str2 = t.toCharArray();
            
            // Sorting both the Arrays
            Arrays.sort(str1);
            Arrays.sort(str2);
            
            // Now checking if each character of both the Arrays are equal
            for(int i = 0; i < str1.length;i++) {
                if(str1[i] != str2[i])
                    return false;
            }
            return true;
        }
        return false;
     
        /**
         Second Method : In this method, A frequency array is used. Frequency of each character in both the strings must be equal for the string to be an Anagram. Therefore whenever we find a character in String s we increment its frequency and decrement its frequency if we find the same character in T. After full traversal of the Strings if each element of the frequency array is 0, it means that both the strings have same characters. 
        **/
      
        if(s.length() != t.length()) // Anagram only possible when both strings are of equal length
            return false;
        char[] freq = new char[26];  // Array which will store the count of each character of the Strings
        for(int i = 0;i < s.length();i++) {
            freq[s.charAt(i) - 'a']++;  
            freq[t.charAt(i) - 'a']--;
        }
        
        for(int i : freq) {
            if(i != 0)
                return false;
        }
        return true;
        
    }
}
