class Solution {
    public String sortVowels(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        List<Character> vowels = new ArrayList<>();    
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');



        for(char ch: s.toCharArray()) {
            if(vowels.contains(ch))
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        char[] res = s.toCharArray();
        int vowelIdx = 0;

        for(int i=0; i<s.length(); i++) {
            if(vowels.contains(res[i])) {
                while(vowelIdx < vowels.size() && !freq.containsKey(vowels.get(vowelIdx))) {
                    vowelIdx++;
                }

                char ch = vowels.get(vowelIdx);
                res[i] = ch;
                freq.put(ch, freq.get(ch) - 1);

                if(freq.get(ch) == 0) {
                    freq.remove(ch);
                }
            }
        }

        return new String(res);
    }
}