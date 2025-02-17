class Solution {
    public int numTilePossibilities(String tiles) {
        /**
        A -> A
        AB -> AB, BA, A, B
        ABC -> A,B,C,AB,BC,AC,ABC,ACB,CAB,
        
        A -> 2
        B -> 1

        "" -> A -> 1, B1 ->count = 1 (A)
            A0, B1 count = 3 (AA)
                A0, B0 count = 5 (AAB)
            A1, B0 count = 4 (AB)
                A0 B0 count = 6 (ABA)
        "" -> A -> 2, B0 -> count 2 (B)
            A1, B0 -> count 7 (BA)
            A0, B0 -> Count 8 (BAA)


         */ 
        int[] freq = new int[26];
        for(char ch: tiles.toCharArray()) {
            freq[ch - 'A']++;
        } 

        return helper(freq);
    }

    
    int helper(int[] freq) {
        int count = 0;

        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                count++;
                freq[i]--;
                count += helper(freq);
                freq[i]++;
            }
        }

        return count;
    }
}