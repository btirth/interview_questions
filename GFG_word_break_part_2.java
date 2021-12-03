/*

Given a string s and a dictionary of words dict of length n, add spaces in s to construct a sentence where each word is a valid dictionary word. Each dictionary word can be used more than once. Return all such possible sentences.

Follow examples for better understanding.

Example 1:
  Input: s = "catsanddog", n = 5 dict = {"cats", "cat", "and", "sand", "dog"}
  Output: (cats and dog)(cat sand dog)
  Explanation: All the words in the given sentences are present in the dictionary.

Example 2:
  Input: s = "catsandog", n = 5 dict = {"cats", "cat", "and", "sand", "dog"}
  Output: Empty
  Explanation: There is no possible breaking of the string s where all the words are present in dict.

Your Task:
You do not need to read input or print anything. Your task is to complete the function wordBreak() which takes n, dict and s as input parameters and returns a list of possible sentences. If no sentence is possible it returns an empty list.

Expected Time Complexity: O(N2*n) where N = |s|
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ n ≤ 20
1 ≤ dict[i] ≤ 15
1 ≤ |s| ≤ 500 

*/


class Solution{
    static List<String> ans;
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        // code here
        ans = new ArrayList<>();
        helper(dict, s, 0, "");
        return ans;
    }
    
    static void helper(List<String> dict, String s, int index, String str) {
        if(index == s.length()) {
            ans.add(str);
            return;
        }
        
        for(int i=index; i<=s.length(); i++) {
            if(dict.contains(s.substring(index, i))) {
                if(i == s.length()) {
                    helper(dict, s, i, str+s.substring(index, i));
                } else {
                    helper(dict, s, i, str+s.substring(index, i)+" ");    
                }
                
            }
        }
    }
}
