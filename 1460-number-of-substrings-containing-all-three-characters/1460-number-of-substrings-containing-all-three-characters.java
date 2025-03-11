class Solution {
    public int numberOfSubstrings(String s) {
        Deque<Integer> qA = new LinkedList<>();
        Deque<Integer> qB = new LinkedList<>();
        Deque<Integer> qC = new LinkedList<>();
        int n = s.length();
        
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == 'a') {
                qA.add(i);
            } else if(s.charAt(i) == 'b') {
                qB.add(i);
            } else {
                qC.add(i);
            } 
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            if(qA.isEmpty() || qB.isEmpty() || qC.isEmpty()) {
                break;
            }

            count += (n - Math.max(qA.peek(), Math.max(qB.peek(), qC.peek())));

            if(s.charAt(i) == 'a') {
                qA.removeFirst();
            } else if(s.charAt(i) == 'b') {
                qB.removeFirst();
            } else {
                qC.removeFirst();
            } 
        }

        return count;
    }
}