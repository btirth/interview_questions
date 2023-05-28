class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int minCost(int n, int[] cuts) {
        return minCost(0, n, cuts);
    }

    int minCost(int s, int e, int[] cuts) {
        if(e - s == 1) {
            return 0;
        }

        String key = s+"*"+e;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int cost = Integer.MAX_VALUE;
        for(int cut: cuts) {
            if(cut > s && cut < e) {
                cost = Math.min(cost, minCost(s, cut, cuts) + minCost(cut, e, cuts));
            }
        }

        if (cost == Integer.MAX_VALUE) {
            cost = 0;
        } else {
            cost += (e - s);
        }

        map.put(key, cost);
        return cost;
    }
}