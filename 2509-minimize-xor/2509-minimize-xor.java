class Solution {
    public int minimizeXor(int num1, int num2) {
        /**
        XOR:
        1 0 -> 1
        0 1 -> 1
        0 0 -> 0
        1 1 -> 0


        num2 -> 6 bit
        num1 XOR x = minimize

        count 1 in num1 make it 1 in x 
        substract that count from bits of num2

        remaining bits
        -> Go from left to right
        If bit is not already set, set it
        
        num & (1 << i) > 0 -> to check if ith bit is set or not

        i | (1 << i) -> Set ith bit
        
        */


        int bitCount = 0;
        for(int i=0; i<32; i++) {
            if((num2 & (1 << i)) > 0) {
                bitCount++;
            }
        }

        int x = 0;
        for(int i=31; bitCount > 0 && i >= 0; i--) {
            if((num1 & (1 << i)) > 0) {
                x |= (1 << i);
                bitCount--;
            }
        }

        for(int i=0; bitCount > 0 && i < 32; i++) {
            if((x & (1 << i)) == 0) {
                x |= (1 << i);
                bitCount--;
            }
        }

        return x;
    }
}