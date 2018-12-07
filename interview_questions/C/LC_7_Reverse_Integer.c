/*Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
	Input: 123
	Output: 321

Example 2:
	Input: -123
	Output: -321

Example 3:
	Input: 120
	Output: 21
*/

int reverse(int x) {
    int reverse=0,n,i,temp,q;  //temp is copy of given number
                           //reverse is a reverse number
                           //n is a remainder
    temp = x;
    
    while(temp!=0)
    {
        q = reverse;
        n = temp%10;
        reverse = reverse*10 + n;
        temp/=10;
        if((reverse-n)/10 !=q)   //to check overflow
        {
            reverse = 0;
        }
        
    } 
    return reverse;
}