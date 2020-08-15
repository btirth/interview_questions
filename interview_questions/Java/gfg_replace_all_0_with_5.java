/*

You are given an integer N. You need to convert all zeroes of N to 5.

Example 1:
    Input:
    N = 1004
    Output: 1554
    Explanation: There are two zeroes in 1004
    on replacing all zeroes with "5", the new
    number will be "1554".

Example 2:
    Input:
    N = 121
    Output: 121
    Explanation: Since there are no zeroes in
    "121", the number remains as "121".

Your Task:
    Your task is to complete the function convertFive() which takes an integer N as an argument 
    and replaces all zeros in the number N with 5. Your function should return the converted number.

*/


class GfG {
    int convertfive(int num) {
        int a = 0;
        int y = 1;
        while(num>0){
            
            int x = num%10;
            if(x==0) x=5;
            a = a+(x*y);
            
            num /=10;
            y = y*10;    
        }
        
        return a;
    }
}