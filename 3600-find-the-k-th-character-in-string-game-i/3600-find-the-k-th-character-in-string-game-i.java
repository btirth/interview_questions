class Solution {
    public char kthCharacter(int k) {
        int[] res = new int[k];
        /**
        a -> ab [b]
        ab -> abbc [bc]
        abbc -> abbcbccd [bccd]
        abbcbccd -> bccdcdde
        bccdcdde -> cdde
        
         */
        int idx = 1;
        res[0] = 0;

        while(idx < k) {
            int size = idx;
            int prevIdx = 0;
            while(idx<k && size-- > 0) {
                res[idx++] = res[prevIdx] + 1;
                prevIdx++;
            }    
        }

        return (char)('a' + res[k-1]);
    }
}