/**
Problem :- Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5

Example 2:

Input: s = " "
Output: 0
**/

// Solution :-

class Solution {
    public int lengthOfLastWord(String s) {
        int diff = 0;
		for(int i = s.length()-1;i >= 0;i--) {
		    if(s.charAt(i)==' ') {
		        continue;
		    }
		    else {
		        s = s.substring(0,i);
		        diff = i - s.lastIndexOf(' ');
		        break;
		    }
		}
        return diff;
    }
}

/**
Approach :-
* First reach to the last letter of the last word in the sentence ignoring all the spaces.
* Now extract a substring from the beginning to that character.
* Now the method lastIndexOf(' ') will give the index just before the last word starts.
* Now, when we subtract this index from the length of the extracted substring, we'll get the length of the last word. 
**/
