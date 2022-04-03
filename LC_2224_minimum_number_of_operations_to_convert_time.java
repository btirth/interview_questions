/*

You are given two strings current and correct representing two 24-hour times.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.

In one operation you can increase the time current by 1, 5, 15, or 60 minutes. You can perform this operation any number of times.

Return the minimum number of operations needed to convert current to correct.

Example 1:
  Input: current = "02:30", correct = "04:35"
  Output: 3
  Explanation:
    We can convert current to correct in 3 operations as follows:
    - Add 60 minutes to current. current becomes "03:30".
    - Add 60 minutes to current. current becomes "04:30".
    - Add 5 minutes to current. current becomes "04:35".
    It can be proven that it is not possible to convert current to correct in fewer than 3 operations.
  
Example 2:
  Input: current = "11:00", correct = "11:01"
  Output: 1
  Explanation: We only have to add one minute to current, so the minimum number of operations needed is 1.

Constraints:
  current and correct are in the format "HH:MM"
  current <= correct

*/


class Solution {
    public int convertTime(String current, String correct) {
        int count = 0;
        int h1 = Integer.valueOf(current.substring(0, 2));
        int h2 = Integer.valueOf(correct.substring(0, 2));
        
        int m1 = Integer.valueOf(current.substring(3, 5));
        int m2 = Integer.valueOf(correct.substring(3, 5));
        
        int t1 = (h1*60) + m1;
        int t2 = (h2*60) + m2;
       
        while(t1 <= t2-60) {
            if(t1 == t2) {
                return count;
            }
            
            t1 += 60;
            count++;
        }
        
        while(t1 <= t2-15) {
            if(t1 == t2) {
                return count;
            }
            
            t1 += 15;
            count++;
        }
        
        while(t1 <= t2-5) {
            if(t1 == t2) {
                return count;
            }
            t1 += 5;
            count++;
        }
        
        while(t1 <= t2) {
            if(t1 == t2) {
                return count;
            }
            t1++;
            count++;
        }
        
        return count;
    }
}
