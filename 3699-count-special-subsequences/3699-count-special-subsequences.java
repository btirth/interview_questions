class Solution {
    public long numberOfSubsequences(int[] nums) {
        /**
        in one go -> {q, nums[p] / nums[q]} -> TC O(n^2) 1000*1000 -> 1000000
        in second go
        calculate {nums[]}
        
        
         */
        int n = nums.length;
        long count = 0;
        List<Pair<Integer, Double>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=i+2; j<n; j++) {
                list.add(new Pair(j, 1.0 * nums[i] / nums[j]));
            }
        }

        Collections.sort(list, (a,b) -> Integer.compare(a.getKey(), b.getKey()));
        int currIdx = 0;
        HashMap<Double, Long> freq = new HashMap<>();
        for(int i=4; i<n; i++) {
            Pair p = list.get(currIdx);
            while(currIdx < list.size() && (int)p.getKey() < i-1) {
                freq.put((double)p.getValue(), freq.getOrDefault((double)p.getValue(), (long)0) + 1);
                currIdx++;
                if(currIdx == list.size()) {
                    break;
                }
                p = list.get(currIdx);
            }

            for(int j=i+2; j<n; j++) {
                count += freq.getOrDefault(1.0 * nums[j] / nums[i], (long)0);
            }
        }

        return count;
    }
}