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
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        partition(s, 0, curr, ans);
        return ans;
    }
    
    void partition(String str, int idx, List<String> curr, List<List<String>> ans) {
        if(idx == str.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=idx; i<str.length(); i++) {
            if(isPalindrome(str, idx, i)) {
                curr.add(str.substring(idx, i+1));
                partition(str, i+1, curr, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String str, int start, int end) {
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
