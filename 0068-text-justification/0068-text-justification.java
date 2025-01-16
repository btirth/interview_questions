class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        int right = 0;
        int width = 0;
        int n = words.length;
        for(; right < n; right++) {
            int currLen = words[right].length();

            if(width + currLen > maxWidth) {
                process(words, left, right -1, maxWidth, width-1);
                left = right;
                width = 0;
            }

            width += (currLen + 1);
        }

        lastLineProcess(words, left, right - 1, maxWidth);
        return ans;
    }

    void process(String[] words, int left, int right, int maxWidth, int width) {
        int remainingWidth = maxWidth - width;
        int wordsCount = right - left;
        int evenSpaces = 0;
        int extraSpaces = remainingWidth;
        if(wordsCount > 0) {
            evenSpaces = remainingWidth/wordsCount;
            extraSpaces = remainingWidth%wordsCount;
        }
    
        StringBuilder sb = new StringBuilder("");
        for(int i=left; i<=right; i++) {
            sb.append(words[i]);

            if(i == right) {
                continue;
            }

            sb.append(" ");
            for(int j=0; j<evenSpaces; j++) {
                sb.append(" ");
            }

            if(extraSpaces > 0) {
                sb.append(" ");
                extraSpaces--;
            }
        }

        while(extraSpaces > 0) {
            sb.append(" ");
            extraSpaces--;
        }

        ans.add(sb.toString());
    }

    void lastLineProcess(String[] words, int left, int right, int maxW) {
        StringBuilder sb = new StringBuilder("");
        for(int i=left; i<=right; i++) {
            sb.append(words[i]);

            if(i == right) {
                continue;
            }

            sb.append(" ");
        }

        while(sb.length() < maxW) {
            sb.append(" ");
        }

        ans.add(sb.toString());
    }
}