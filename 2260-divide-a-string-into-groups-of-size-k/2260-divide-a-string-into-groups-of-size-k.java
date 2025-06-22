class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length()%k != 0) {
            sb.append(fill);
        }

        s = sb.toString();
        int len = s.length();
        String[] ans = new String[len/k];
        int idx = 0;

        while(idx < ans.length) {
            int startIdx = idx * k;

            String partition = s.substring(startIdx, startIdx + k);
            ans[idx] = partition;
            idx++;
        }

        return ans;
    }
}