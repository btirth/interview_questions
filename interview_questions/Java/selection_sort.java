public class Solution{

     public static void main(String []args){
        int a[] = {5,4,3,2,1};
        int l = a.length;
        int smallest;
        for(int i=0; i<l; i++) {
            smallest = i;
            for(int j=i+1; j<l; j++) {
                if(a[j] < a[smallest]) {
                    smallest = j;
                }
            }
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }
        
        for(int i=0; i<l; i++) {
            System.out.println(a[i]);
        }
     }
}