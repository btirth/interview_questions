class Solution {
    public int candy(int[] r) {
        int ans[]=new int[r.length];
        for(int i=0;i<r.length;i++)
            ans[i]=1;
        
        //left-right
        for(int i=1;i<r.length;i++)
        {
            if(r[i]>r[i-1] && ans[i]<=ans[i-1])
                ans[i]=ans[i-1]+1;
        }
        
        //right-left
        for(int i=r.length-2;i>=0;i--)
        {
            if(r[i]>r[i+1] && ans[i]<=ans[i+1])
                ans[i]=ans[i+1]+1;
        }
        //sum
        int sum=0;
        for(int i=0;i<ans.length;i++)
            sum+=ans[i];
        return sum;
    }
}