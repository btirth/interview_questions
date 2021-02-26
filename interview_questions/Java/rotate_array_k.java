import java.util.*;
public class HelloWorld{
    public static void rotate(int[] a, int start, int end) {
        
        while(start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void rotateByK(int[] a, int k) {
        int len = a.length;
        k %= len;
        rotate(a, 0, k-1);
        rotate(a, k, len-1);
        rotate(a, 0, len-1);
        
        for(int i=0; i<len; i++) {
            System.out.print(a[i]);
        }
    }
    
    public static void main(String []args){
        int[] a = {1,2,3,4,5,6,7};
        rotateByK(a, 2);
    }
}