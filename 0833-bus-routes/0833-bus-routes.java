class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        boolean[] visited = new boolean[n];
        if(source == target) {
            return 0;
        }
        HashMap<Integer, List<Integer>> stationRoutes = new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int station: routes[i]) {
                List<Integer> stationRoute = new ArrayList<>();
                if(stationRoutes.containsKey(station)) {
                    stationRoute = stationRoutes.get(station);
                }

                stationRoute.add(i);
                stationRoutes.put(station, stationRoute);
            }
        }

        // If source/target is not present in any route
        if(!stationRoutes.containsKey(source) || !stationRoutes.containsKey(target)) {
            return -1;
        }

        Queue<Integer> stationQueue = new LinkedList<>();
        int buses = 0;
        stationQueue.add(source);

        while(!stationQueue.isEmpty()) {
            int size = stationQueue.size();
            while(size-- > 0) {
                int station = stationQueue.poll();
                
                for(int route: stationRoutes.get(station)) {
                    if(!visited[route]) {
                        visited[route] = true;

                        for(int nextStation: routes[route]) {
                            stationQueue.add(nextStation);

                            if(nextStation == target) {
                                return buses + 1;
                            }
                        }
                    }
                }
            }

            buses++;
        }

        return -1;
    }
}