/*

Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

Example 1:
    Input: n = 1
    Output: 5
    Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

Example 2:
    Input: n = 2
    Output: 15
    Explanation: The 15 sorted strings that consist of vowels only are
        ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
        Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

Example 3:
    Input: n = 33
    Output: 66045
 
Constraints:
    1 <= n <= 50

*/


// time: O(n), space: O(1)
class Solution {
    public int countVowelStrings(int n) {
        int[] count = new int[5];
        Arrays.fill(count, 1);
        
        for(int i=2; i<=n; i++) {
            for(int j=3; j>=0; j--) {
                count[j] += count[j+1];
            }
        }
        
        int ans = 0;
        for(int i=0; i<5; i++) {
            ans += count[i];
        }
        
        return ans;
    }
}



class Solution {
    public int countVowelStrings(int n) {
        int first = 5;
        int second = 15;
        
        if(n == 1) {
            return first;
        }
        
        if(n == 2) {
            return second;
        }
        int result = 0;
        for(int i=3; i<=n; i++) {
            result = 2*second - first + ((i+1)*(i+2))/2;
            first = second;
            second = result;
        }
        
        return second;
    }
}
