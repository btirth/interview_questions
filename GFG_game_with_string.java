/*

Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of ‘k’ characters.
The value of a string is defined as the sum of squares of the count of each distinct character.
 
Example 1:
  Input: s = abccc, k = 1
  Output: 6
  Explaination: We remove c to get the value as 12 + 12 + 22
 

Example 2:
  Input: s = aabcbcbcabcc, k = 3
  Output: 27
  Explaination: We remove two 'c' and one 'b'. Now we get the value as 32 + 32 + 32.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minValue() which takes s and k as input parameters and returns the minimum possible required value.

Expected Time Complexity: O(N*logN)  where N is the length of string
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ k ≤ |string length| ≤ 100

*/


class Solution{
    static int minValue(String s, int k){
        // code here
        int[] ch = new int[26];
        
        for(char c : s.toCharArray()) {
            ch[c-'a']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : ch) {
            pq.add(i);
        }
        
        while(pq.size() > 0 && k-- > 0) {
            pq.add(pq.poll()-1);
        }
        
        int res = 0;
        while(pq.size() > 0) {
            int val = pq.poll();
            res += (val*val);
        }
        
        return res;
        
    }
}
