class Solution {
    class Pair implements Comparable<Pair>{
        int idx;
        String str;

        Pair(int idx) {
            this.idx = idx;
            this.str = "";
        }

        public int compareTo(Pair p) {
            return Integer.compare(p.str.length(), this.str.length());
        }
    }
    public String frequencySort(String s) {
        Pair[] pairs = new Pair[128];

        for(int i=0; i<128; i++) {
            pairs[i] = new Pair(i);
        }

        for(char ch: s.toCharArray()) {
            pairs[ch-'0'].str += ch;
        }

        Arrays.sort(pairs);

        String ans = "";

        for(int i=0; i<128; i++) {
            if(pairs[i].str.length() > 0) {
                ans += pairs[i].str;
            }
        }

        return ans;
    }
}