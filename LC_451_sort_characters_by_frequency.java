/*

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:
  Input: s = "tree"
  Output: "eert"
  Explanation: 'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
  Input: s = "cccaaa"
  Output: "aaaccc"
  Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
    Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
  Input: s = "Aabb"
  Output: "bbAa"
  Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.
 

Constraints:
  1 <= s.length <= 5 * 10^5
  s consists of uppercase and lowercase English letters and digits.

*/

class Solution {
    public String frequencySort(String s) {
        // Count the occurence on each character
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        
        // Sorting
        List<Character> chars = new ArrayList(cnt.keySet());
        Collections.sort(chars, (a, b) -> (cnt.get(b) - cnt.get(a)));

        // Build string
        StringBuilder sb = new StringBuilder();
        for (Object c : chars) {
            for (int i = 0; i < cnt.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
