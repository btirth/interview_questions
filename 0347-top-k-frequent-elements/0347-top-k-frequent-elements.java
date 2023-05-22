class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxFreq = 0;
        for(Map.Entry e: freq.entrySet()) {
            List<Integer> similarFreq = new ArrayList<>();
            if(map.containsKey(e.getValue())) {
                similarFreq = map.get(e.getValue());
            }

            similarFreq.add((int)e.getKey());
            map.put((int)e.getValue(), similarFreq);
            maxFreq = Math.max(maxFreq, (int)e.getValue());
        }

        int[] topK = new int[k];
        int idx = 0;
        for(int fq=maxFreq; fq>0; fq--) {
            if(map.containsKey(fq)) {
                List<Integer> list = map.get(fq);
                for(int j=0; j<list.size(); j++) {
                    
                    topK[idx++] = list.get(j);
                    if(idx == k) {
                        return topK;
                    }
                }
            }
        }

        return topK;
    }
}