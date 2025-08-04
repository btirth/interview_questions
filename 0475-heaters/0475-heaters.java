class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        /**
        standard heater -> fixed warm radium -> warm all the houses
        position -> houses and heaters

        find min radius such that heater cover all houses.

        heater can go in + and - radius.

        house -> 1
        heater -> 2
        radius -> 1

        heater, heater - radius -> house >= heater - radius AND house <= heater + radius
        heater, heater + radius

        int houseIdx;
        int heaterIdx;

        while(houseIdx < houseLen) {
            if(houses[houseIdx] >= heaters[heaterIdx] - radius && houses[houseIdx] <= heaters[heaterIdx] + radius) {
               houseIdx++; 
            } else {
                heaterIdx++;
            }

            if(heaterIdx == heaterLen) {
                return false;
            }
        }

        return true;

        binary search -> p logp (p -> max position of the house)
         */

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int houseLen = houses.length;
        int heatersLen = heaters.length;
        int left = 0;
        int right = Math.max(houses[houseLen - 1], heaters[heatersLen - 1]);

        int ans = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = (right + left)/2;

            if(isRadiusPossible(houses, heaters, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } 

        return ans;
    }

    boolean isRadiusPossible(int[] houses, int[] heaters, int radius) {
        int houseIdx = 0;
        int heaterIdx = 0;
        int houseLen = houses.length;
        int heaterLen = heaters.length;

        while(houseIdx < houseLen) {
            if(houses[houseIdx] >= heaters[heaterIdx] - radius && houses[houseIdx] <= heaters[heaterIdx] + radius) {
               houseIdx++; 
            } else {
                heaterIdx++;
            }

            if(heaterIdx == heaterLen) {
                return false;
            }
        }

        return true;

    }
}