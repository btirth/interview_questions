// Quick Sort


public class Solution{
    int Sort(int[] a, int s, int l) {
      
        int pivot = a[l];
        int i = s-1;
        
        for(int j=s; j<=l-1; j++) {
            if(a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[l] = a[i+1];
        a[i+1] = pivot;
        
        return i+1;
    } 
    
    void QuickSort(int[] a, int s, int l) {
        if(s < l) {
            int m = Sort(a, s, l);
            QuickSort(a, s, m-1);
            QuickSort(a, m+1, l);    
        }
        
    }
    public static void main(String []args){
        System.out.println("Hello World");
        int a[] = {5,4,3,2,1};
        int l = a.length;
        
        Solution hw = new Solution();
        hw.QuickSort(a, 0, l-1);
        
        for(int i=0; i<l; i++) {
            System.out.print(a[i]+" ");
        }
    }
}