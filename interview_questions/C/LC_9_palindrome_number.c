/*Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:
	Input: 121
	Output: true

Example 2:
	Input: -121
	Output: false
	Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
	Input: 10
	Output: false
	Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/


bool isPalindrome(int x) {
    int temp,i=0,n;    //i is a reverse number 
                       //n is a remainder
    temp = x;   //copy given number
    while(temp!=0)
    {
        n = temp%10;
        i = i*10 + n ;
        temp = temp/10;
        
    }
    if(i == x && x>=0)
    {
        return true;
    }
    else
    {
        return false;
    }
}