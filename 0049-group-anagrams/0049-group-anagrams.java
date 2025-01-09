class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        sort each string and hashmap
        character freq array for each string
        
        
         */
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String resultStr = new String(ch);
            List<String> list = map.getOrDefault(resultStr, new ArrayList<>());
            list.add(str);
            map.put(resultStr, list);
        }

        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}