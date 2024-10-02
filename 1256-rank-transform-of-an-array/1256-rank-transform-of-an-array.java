class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, List<Integer>> idx = new HashMap<>(); 
        for(int i=0; i<arr.length; i++) {
            int num = arr[i];
            
            if(!idx.containsKey(num)) {
                idx.put(num, new ArrayList<>());
                pq.add(num);
            }
            List<Integer> idxList = idx.get(num);
            idxList.add(i);
            idx.put(num, idxList);
        }

        int rank = 1;
        while(!pq.isEmpty()) {
            for(int index: idx.get(pq.poll())) {
                arr[index] = rank;
            }

            rank++;
        }

        return arr;
    }
}