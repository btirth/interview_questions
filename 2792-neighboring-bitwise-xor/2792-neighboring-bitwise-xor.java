class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = derived[0];
        int n = derived.length;

        for(int i=1; i<n; i++) {
            xor ^= derived[i];
        }

        return xor == 0;
    }
}