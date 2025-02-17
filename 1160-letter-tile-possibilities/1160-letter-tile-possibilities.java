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
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch: tiles.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        } 

        helper(freq);
        return count; 
    }

    int count = 0;
    void helper(HashMap<Character, Integer> freq) {
        

        for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
            int originalValue = entry.getValue();
            if(entry.getValue() > 0) {
                count++;
                freq.put(entry.getKey(), originalValue - 1);
                helper(freq);
                freq.put(entry.getKey(), originalValue);
            }
        }
    }
}