/*

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:
  Input: s = "aab"
  Output: [["a","a","b"],["aa","b"]]

Example 2:
  Input: s = "a"
  Output: [["a"]]
 
Constraints:
  1 <= s.length <= 16
  s contains only lowercase English letters.

*/


class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partition(s, 0, path, res);
        return res;
    }
    
    boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    void partition(String s, int idx, List<String> path, List<List<String>> res) {
        if(idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=idx; i<s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i+1));
                partition(s, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }
}
