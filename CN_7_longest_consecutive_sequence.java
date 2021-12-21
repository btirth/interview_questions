import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        int[] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6};
        
        Arrays.sort(arr);
        
        int len = 0;
        int MStart = arr[0];
        int MFinish = arr[0];
        int CurrentStart = arr[0];
        int maxLen = 0;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == arr[i-1]+1) {
                len++;
            } else {
                if(len >= maxLen) {
                    maxLen = len;
                    MStart = CurrentStart;
                    MFinish = arr[i-1];
                }
                CurrentStart = arr[i];
                len = 0;
            }
        }
        
        System.out.println(MStart+" "+MFinish);
     }
}
