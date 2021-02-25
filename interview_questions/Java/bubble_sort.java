public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        int a[] = {5,4,3,2,1};
        
        int l = a.length;
        for(int i=0; i<l-1; i++) {
            for(int j=0; j<l-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;  
                }
            }
        }
        
        for(int i=0; i<l; i++) {
            System.out.println(a[i]);
        }
     }
}