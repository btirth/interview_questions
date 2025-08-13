class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String encoded = new String(ch);
            
            List<String> group = new ArrayList<>();
            if(map.containsKey(encoded)) {
                group = map.get(encoded);
            }

            group.add(str);
            map.put(encoded, group);
        }

        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}