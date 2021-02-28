public class Solution{
     void print(int a[]) {
         int l = a.length;
         for(int i=0; i<l; i++) {
            System.out.println(a[i]);
        }
     }
     void merge_sort(int a[], int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = l + (r-l)/2;
        merge_sort(a, l, mid);
        merge_sort(a, mid+1, r);
        
        merge(a, l, mid, r);
       
        return;
     }
     
     void merge(int a[], int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(int i=0; i<n1; i++) {
            L[i] = a[l+i];
        }
        
        for(int i=0; i<n2; i++) {
            R[i] = a[m+i+1];
        }
        
        int lp = 0;   //left pointer
        int rp = 0; //right pointer
        int k = l;
        while(lp < n1 && rp < n2) {
            if(L[lp] <= R[rp]) {
                a[k] = L[lp];
                lp++;
              
            } else {
                a[k] = R[rp];
                rp++;
                
            }
            k++;
        }
        while(lp<n1) {
            a[k] = L[lp];
            k++;
            lp++;
        }
        while(rp<n2) {
            a[k] = R[rp];
            k++;
            rp++;
        }
        
     }
     
     public static void main(String []args){
        System.out.println("Hello World");
        int a[] = {5,4,3,2,1};
        int l = a.length;
        Solution hw = new HelloWorld();
        hw.merge_sort(a, 0, l-1);
        hw.print(a);
        
     }
}