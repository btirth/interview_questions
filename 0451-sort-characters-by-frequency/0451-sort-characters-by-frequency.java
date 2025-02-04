class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char ch: s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        for(Map.Entry<Character, Integer> e: freq.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            char ch = (char)p.getKey();
            int f = (int)p.getValue();

            while(f > 0) {
                sb.append(ch);
                f--;
            }
        }

        return sb.toString();
    }
}