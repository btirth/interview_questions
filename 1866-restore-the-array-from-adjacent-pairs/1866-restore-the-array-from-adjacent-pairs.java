class Solution {
    public int[] restoreArray(int[][] pairs) {
        int n = pairs.length + 1;
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pair: pairs) {
            if(!map.containsKey(pair[0])) {
                map.put(pair[0], new ArrayList<>());
            }
            if(!map.containsKey(pair[1])) {
                map.put(pair[1], new ArrayList<>());
            }

            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()) {
            if(e.getValue().size() == 1) {
                if(ans[0] == Integer.MAX_VALUE) {
                    ans[0] = e.getKey();
                    ans[1] = e.getValue().get(0);
                } 
            }
        }

        for(int k=1; k<n-1; k++) {
            System.out.println("k" + ans[k]);
            int n1 = map.get(ans[k]).get(0);
            int n2 = map.get(ans[k]).get(1);
            System.out.println(ans[k]+" "+n1+" "+n2);
            ans[k+1] = ans[k-1] == n1 ? n2 : n1;
            //k++;
        }




        return ans;
    }
}