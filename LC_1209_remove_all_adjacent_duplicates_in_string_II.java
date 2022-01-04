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


// O(n*m)
class Solution {
    List<String> list = new LinkedList<String>();
    public String removeDuplicates(String s, int k) {
        int L = s.length();
        if(L<k) {
            return s;
        }
        
        char[] c = new char[L];
        
        int n = 0;
        for(int i=0; i<L; i++) {
            boolean removed = false;
            char ch = s.charAt(i);
            if(n < k-1) {
                c[n] = ch;
                n++;
                continue;
            }
            
            int copy_k = k-1;
            while(copy_k > 0) {
            
                if(c[n-copy_k] != ch) {
                    
                    break;
                }
                
                if (copy_k==1) {
                    removed = true;
                    
                    n -= k-1;
                }
                copy_k -= 1;
            }
            if(removed == false){
                c[n] = ch;
                n++;
            }
        }
        
        return new String(c, 0, n);
        
    }
}
