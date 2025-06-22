class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        String[] ans = new String[(int)Math.ceil((1.0*len) / k)];

        int idx = 0;
        while(idx < ans.length) {
            int startIdx = idx * k;

            String partition = s.substring(startIdx, Math.min(len, startIdx + k));

            while(partition.length() < k) {
                partition = partition + fill;
            }

            ans[idx] = partition;
            idx++;
        }

        return ans;
    }
}