class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for(int i : a) {
            if(i == 0) {
                count0++;
            } else if(i == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        
        int idx = 0;
        
        while(count0-- > 0) {
            a[idx++] = 0;
        }
        
        while(count1-- > 0) {
            a[idx++] = 1;
        }
        
        while(count2-- > 0) {
            a[idx++] = 2;
        }
        
    }
}
