class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int freq;
        Pair(int num) {
            this.num = num;
            this.freq = 0;
        }

        public int compareTo(Pair p) {
            return Integer.compare(this.freq, p.freq);
        }
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Pair> map = new HashMap<>();
        int n = arr.length;
        

        for(int num: arr) {
            Pair p = map.getOrDefault(num, new Pair(num));
            p.freq++;
            map.put(num, p);
        }    

        int uniquePair = map.size();
        Pair[] pairs = new Pair[uniquePair];
        int idx = 0;
        for(Map.Entry<Integer, Pair> entry: map.entrySet()) {
            pairs[idx++] = entry.getValue();
        }
        Arrays.sort(pairs);
        idx = 0;
        while(k>0) {
            k -= pairs[idx++].freq;
            if(k>=0) {
                uniquePair--;
            }
        }

        return uniquePair;
    }
}