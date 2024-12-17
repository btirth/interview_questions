class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        Set<Pair<Integer, Integer>> set = new TreeSet<>((a,b) -> b.getKey() - a.getKey());
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(freq[i] > 0)
                set.add(new Pair(i, freq[i]));
        }

        StringBuilder sb = new StringBuilder("");
        int prev = -1;
        int prevCount = 0;
        boolean foundAnother = true;
        while(foundAnother) {
            foundAnother = false;
            Iterator<Pair<Integer, Integer>> iterator = set.iterator();
            while(iterator.hasNext()) {
                Pair p = iterator.next();
                int i = (int)p.getKey();
                int f = (int)p.getValue();

                if(i != prev || prevCount < repeatLimit -1) {
                    foundAnother = true;
                    sb.append("" + (char)(i + 'a'));
                    f--;
                    if(f == 0) {
                        
                        iterator.remove();
                    } else {
                        iterator.remove();
                        set.add(new Pair<>(i, f));
                    }

                    if(i == prev) {
                        prevCount++;
                    } else {
                        prev = i;
                        prevCount = 0;
                    }

                    break;
                }
            }
        }

        return sb.toString();
    }
}