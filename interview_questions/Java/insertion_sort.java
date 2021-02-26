public class Solution{

     public static void main(String []args){
        
        int a[] = {5,4,3,2,1};
        int l = a.length;
        for(int i=1; i<l; i++) {
            int key = a[i];
            for(int j=i-1; j>=0; j--) {
                if(key < a[j]) {
                    int temp = a[j];
                    a[j] = key;
                    a[j+1] = temp;
                }
            }
        }
        
        for(int i=0; i<l; i++) {
            System.out.println(a[i]);
        }
     }
}