/**
Problem :- Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3

Example 2:

Input: s = "IV"
Output: 4

Example 3:

Input: s = "IX"
Output: 9

Example 4:

Input: s = "LVIII"
Output: 58

Explanation: L = 50, V= 5, III = 3.

Example 5:

Input: s = "MCMXCIV"
Output: 1994

Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
**/
// Solution :- 

class Solution {
    public int romanToInt(String s) {
        int number = 0;
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(ch=='M') {
                number = number + 1000;
            }
            if(ch=='D') {
                if(i != s.length()-1 && s.charAt(i+1)=='M') {
                    number = number - 500;
                }
                else {
                    number = number + 500;
                }
            }
            if(ch=='C') {
                if(i != s.length()-1 && s.charAt(i+1)=='D') {
                    number = number - 100;
                }
                else {
                    if(i != s.length()-1 && s.charAt(i+1)=='M') {
                        number = number - 100;
                    }
                    else {
                        number = number + 100;
                    }
                }
            }
            if(ch=='L') {
                if(i != s.length()-1 && s.charAt(i+1)=='D') {
                    number = number - 50;
                }
                else {
                    if(i != s.length()-1 && s.charAt(i+1)=='C') {
                        number = number - 50;
                    }
                    else {
                        if(i != s.length()-1 && s.charAt(i+1)=='M') {
                            number = number - 50;
                        }
                        else {
                            number = number + 50;
                        }
                    }
                }

            }
            if(ch=='X') {
                if(i != s.length()-1 && s.charAt(i+1)=='L') {
                    number = number - 10;
                }
                else {
                    if(i != s.length()-1 && s.charAt(i+1)=='C') {
                        number = number - 10;
                    }
                    else {
                        if(i != s.length()-1 && s.charAt(i+1)=='D') {
                            number = number - 10;
                        }
                        else {
                            if(i != s.length()-1 && s.charAt(i+1)=='M') {
                                number = number - 10;
                            }
                            else {
                                number = number + 10;
                            }
                        }
                    }
                }
            }
            if(ch=='V') {
                if(i != s.length()-1 && s.charAt(i+1)=='X') {
                    number = number - 5;
                }
                else {
                    if(i != s.length()-1 && s.charAt(i+1)=='L') {
                        number = number - 5;
                    }
                    else {
                        if(i != s.length()-1 && s.charAt(i+1)=='C') {
                            number = number - 5;
                        }
                        else {
                            if(i != s.length()-1 && s.charAt(i+1)=='D') {
                                number = number - 5;
                            }
                            else {
                                if(i != s.length()-1 && s.charAt(i+1)=='M') {
                                    number = number - 5;
                                }
                                else {
                                    number = number + 5;
                                }
                            }
                        }
                    }
                }
            }
            if(ch=='I') {
                if(i != s.length()-1 && s.charAt(i+1)=='V') {
                    number = number - 1;
                }
                else {
                    if(i != s.length()-1 && s.charAt(i+1)=='X') {
                        number = number - 1;
                    }
                    else {
                        if(i != s.length()-1 && s.charAt(i+1)=='L') {
                            number = number - 1;
                        }
                        else {
                            if(i != s.length()-1 && s.charAt(i+1)=='C') {
                                number = number - 1;
                            }
                            else {
                                if(i != s.length()-1 && s.charAt(i+1)=='D') {
                                    number = number - 1;
                                }
                                else {
                                    if(i != s.length()-1 && s.charAt(i+1)=='M') {
                                        number = number - 1;
                                    }
                                    else {
                                        number = number + 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return number;
    }
}

/**
Approach :-
* The code continuously checks the character at an index (from left to right) and the character at its immediate right position performing the related calculations and increment / decrement operations based on the position of the character.
* number :- this variable stores the value of the roman numeral after each extraction of character.
**/
