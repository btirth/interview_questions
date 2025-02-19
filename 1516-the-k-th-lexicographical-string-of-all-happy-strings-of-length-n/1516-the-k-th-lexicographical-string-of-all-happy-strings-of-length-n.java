class Solution {
    int k;
    int[] ans;
    public String getHappyString(int n, int k) {
        ans = new int[n];
        this.k = k;
        helper(n, new int[n], 0);

        char[] ch = new char[n];
        for(int i=0; i<n; i++) {
            if(ans[i] == 1) {
                ch[i] = 'a';
            } else if(ans[i] == 2) {
                ch[i] = 'b';
            } else if(ans[i] == 3) {
                ch[i] = 'c';
            }
        }

        if(this.k > 0) {
            return "";
        }

        return new String(ch);
    }

    void helper(int n, int[] arr, int idx) {
        if(idx == n) {
            k--;

            if(k == 0) {
                ans = Arrays.copyOf(arr, arr.length);
            }

            return;
        }

        if(k <= 0) {
            return;
        }

        for(int i=1; i<=3; i++) {
            if(idx == 0 || arr[idx-1] != i) {
                arr[idx] = i;
                helper(n, arr, idx + 1);
                arr[idx] = 0;
            }
        }
    }
}