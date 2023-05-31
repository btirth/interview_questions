class UndergroundSystem {
    HashMap<Integer, CheckInPair> checkInMap;
    HashMap<String, AvgTimePair> avgTimeMap;

    class CheckInPair {
        String stationName;
        int t;

        CheckInPair(String stationName, int t) {
            this.stationName = stationName;
            this.t = t; 
        }
    }

    class AvgTimePair {
        int t = 0;
        int n = 0;


    }
    
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        avgTimeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInPair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInPair checkIn = checkInMap.get(id);
        int travelTime = t - checkIn.t;
        AvgTimePair avgTime = new AvgTimePair();
        if(avgTimeMap.containsKey(checkIn.stationName+"__"+stationName)) {
            avgTime = avgTimeMap.get(checkIn.stationName+"__"+stationName);
        }

        avgTime.t += travelTime;
        avgTime.n++;
        avgTimeMap.put(checkIn.stationName+"__"+stationName, avgTime);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        AvgTimePair avgTime = avgTimeMap.get(startStation+"__"+endStation);
        return (double)avgTime.t/avgTime.n;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */