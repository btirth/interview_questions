class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int val = 0;
        int prev = -1;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int currVal = map.get(ch);
            if(prev != -1 && prev < currVal) {
                val -= prev;
                val -= prev;
            } 

            val += currVal;
            prev = currVal;
        }

        return val;
    }
}