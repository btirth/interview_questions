class TimeMap {
    HashMap<String, TreeSet<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new TreeSet<>((a,b) -> Integer.compare((int)a.getKey(), (int)b.getKey())));
        }

        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        TreeSet<Pair<Integer, String>> set = map.get(key);
        
        Pair pair = set.floor(new Pair(timestamp, ""));
        if(pair == null) {
            return "";
        }

        return (String)pair.getValue(); 
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */