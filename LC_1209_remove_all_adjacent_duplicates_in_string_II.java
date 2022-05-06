/*
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made.
It is guaranteed that the answer is unique.
 
Example 1
    Input: s = "abcd", k = 2
    Output: "abcd"
    Explanation: There's nothing to delete.
Example 2:
    Input: s = "deeedbbcccbdaa", k = 3
    Output: "aa"
    Explanation: 
        First delete "eee" and "ccc", get "ddbbbdaa"
        Then delete "bbb", get "dddaa"
        Finally delete "ddd", get "aa"
Example 3:
    Input: s = "pbbcggttciiippooaais", k = 2
    Output: "ps"
*/


//O(n)
class Solution {
    public String removeDuplicates(String s, int k) {
        int L = s.length();
        if(L < k) {
            return s;
        }
        int[] c = new int[L];
        char[] a = new char[L];
        int j = 0;
        int n = 1;
        a[0] = s.charAt(0);
        c[0] = 1;
        
        for(int i=1; i<L; i++) {
            
            char ch = s.charAt(i);
           
            if(n>0 && a[n-1] == ch) {
                
                a[n] = ch;
                c[j]++;
                
                if(c[j] == k) {
                    j--;
                    n -= k-1;
                    continue;
                }
                
                n++;

            } else {
                a[n] = ch;
                n++;
                j++;
                c[j] = 1;
            }
        }
        return new String(a, 0, n);
    }
}


class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int i=0;
        int count = 0;
        while (i < s.length()){
            if (sb.length() == 0){
                sb.append(s.charAt(i));
                count++;
                i++;
                continue;
            } else {
                if (s.charAt(i) == sb.charAt(sb.length()-1)){
                    sb.append(s.charAt(i));
                    count++;
                    if (count == k){
                       sb.delete(sb.length() - k,sb.length());
                        count = stack.isEmpty() ? 0 : stack.pollLast();
                    }

                }else{
                    stack.add(count);
                    sb.append(s.charAt(i));
                    count = 1;
                }   
            }
            i++;
        }
        return sb.toString();
    }
}




class Solution {
    class Pair {
        char ch;
        int count;
        
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char chAtI = s.charAt(i);
            if(!stack.empty() && stack.peek().ch == chAtI) {
                stack.peek().count += 1;
            } else {
                stack.push(new Pair(chAtI, 1));
            }
            
            if(stack.peek().count == k) {
                stack.pop();
            }
        }
        
        String result = "";
        while(!stack.empty()) {
            Pair pair = stack.pop();
            for(int i=0; i<pair.count; i++) {
                result = pair.ch + result;
            }
        }
        
        return result;
    }
}
