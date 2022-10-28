/*

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
  Input: strs = ["eat","tea","tan","ate","nat","bat"]
  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
  Input: strs = [""]
  Output: [[""]]

Example 3:
  Input: strs = ["a"]
  Output: [["a"]]
 
Constraints:
  1 <= strs.length <= 10^4
  0 <= strs[i].length <= 100
  strs[i] consists of lowercase English letters.

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String genStr = new String(ch);

            List<String> list = map.getOrDefault(genStr, new ArrayList<>());
            list.add(str);
            map.put(genStr, list);
        }

        return new ArrayList<>(map.values());
    }
}
