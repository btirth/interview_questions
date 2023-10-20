class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();

        int sidx = -1;
        for(int i=0; i<s.length(); i++) {
            if(sch[i] != '#') {
                sch[++sidx] = sch[i];
            } else {
                if(sidx >= 0)
                    sidx--;
            }
        }

        int tidx = -1;
        for(int i=0; i<t.length(); i++) {
            if(tch[i] != '#') {
                tch[++tidx] = tch[i];
            } else {
                if(tidx >= 0)
                    tidx--;
            }
        }

        if(tidx != sidx) {
            return false;
        }

        System.out.println(sidx+" "+tidx);
        for(int i=0; i<=sidx; i++) {
            if(tch[i] != sch[i]) {
                return false;
            }
        }

        return true;
    }
}