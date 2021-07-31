/*

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":

Given a positive integer n, return the nth term of the count-and-say sequence.

Example 1:
  Input: n = 1
  Output: "1"
  Explanation: This is the base case.

Example 2:
  Input: n = 4
  Output: "1211"
  Explanation:
    countAndSay(1) = "1"
    countAndSay(2) = say "1" = one 1 = "11"
    countAndSay(3) = say "11" = two 1's = "21"
    countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 
Constraints:
  1 <= n <= 30


*/


// Recursive method
class Solution {
    public String countAndSay(int n) {
        if(n==1) {
            return new String("1");
        }
        if(n==2) {
            return new String("11");
        }
        return countAndSay(n, new String("11"), 3);
    }
    
    public String countAndSay(int n, String str, int i) {
        if(i == n+1) {
            return str;
        }
        StringBuilder sb = new StringBuilder("");
        int idx = 0;
        int len = str.length();
        int count = 0;
        while(idx<len-1) {
            if(str.charAt(idx) == str.charAt(idx+1)) {
                count++;
            } else {
                count++;
                sb.append(count);
                sb.append(str.charAt(idx));
                count = 0;
            }
            idx++;
        }
        count++;
        sb.append(count);
        sb.append(str.charAt(idx));
        
        return countAndSay(n, new String(sb), i+1);
        
    }
}



// Iterative method
class Solution {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder pre;
        
        for(int i=1; i<n; i++){
            pre = curr;
            curr = new StringBuilder();
            int count = 1;
            int len = pre.length();
            char say = pre.charAt(0);
            
            for(int j=1; j<len; j++){
                if(pre.charAt(j) != say){
                    curr.append(count).append(say);
                    say = pre.charAt(j);
                    count = 1;   
                } else {
                    count++;
                }   
            }
            curr.append(count).append(say);   
        }
        return curr.toString();
    }
}
