class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        Set<String> set = new HashSet<>();
        boolean found = false;
        boolean couldBe = false;
        boolean foundPair = false;

        for(int i=0; i<s.length(); i++) {
           if(s.charAt(i) != goal.charAt(i)) {
               if(!set.contains(goal.charAt(i)+"-"+s.charAt(i))) {
                   if(found || foundPair) {
                       return false;
                   } else {
                       found = true;
                   }
               } else {
                   if(foundPair) {
                       return false;
                   }
                   foundPair = true;
               }
           } else {
               if(set.contains(goal.charAt(i)+"-"+s.charAt(i))) {
                   couldBe = true;
               }
           }

           set.add(s.charAt(i)+"-"+goal.charAt(i));
        }

        if(found) {
            if(foundPair) {
                return true;
            }

            return false;
        }

        return couldBe;
    }
}