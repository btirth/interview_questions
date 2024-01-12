class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int c1 = 0;
        int c2 = 0;
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        for(int i=0; i<n/2; i++) {
            if(vowels.contains(s.charAt(i))) {
                c1++;
            }
        }

        for(int i=n/2; i<n; i++) {
            if(vowels.contains(s.charAt(i))) {
                c2++;
            }
        }

        return c1 == c2;
    }
}