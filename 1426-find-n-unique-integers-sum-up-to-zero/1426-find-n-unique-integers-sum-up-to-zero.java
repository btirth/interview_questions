class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int idx = 0;
        int num = 1;
        int sum = 0;

        while(idx < n) {
            if(sum != 0) {
                res[idx] = sum;
                sum = 0;
            } else {
                res[idx] = num;
                sum = -1 * num;
                num++;
            }

            idx++;
        }

        if(sum != 0) {
            res[n-1] = 0;
        }

        return res;
    }
}