/*

Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.

Example 1:
    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.

*/



class Solution {
    public String removeKdigits(String num, int k) {
        if(num==null || num.length()==0 || num.length()<=k) {
            return "0";
        }
        
        LinkedList<Character> stack = new LinkedList<Character>();
        int L = num.length();
        
        int i=0;
        while(i < L) {
            char c = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peekLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.add(c);
            
            if(k==0) break;
            i++;
        }
        
        while(k>0) {
            stack.removeLast();
            k--;
        }
        
        while(!stack.isEmpty() && stack.peekFirst() =='0') {
            stack.removeFirst();
        }
        
        if(stack.isEmpty() && i == L-1) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }
        
        if(i<L-1) {
            
            sb.append(num.substring(i+1));
        }
        
        
        
        return sb.toString();
    }
}