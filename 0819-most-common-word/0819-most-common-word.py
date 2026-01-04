class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        for ch in ",.!?;:":
            paragraph = paragraph.replace(ch, " ")
        freq = dict({})
        most_freq_word = ""
        freq[most_freq_word] = 0

        def trimWord(word):
            word = word.lower()
            trimmed_word = ""
            for char in word:
                if (char >= 'a' and char <= 'z'):
                    trimmed_word += char
            
            return trimmed_word

        for word in paragraph.split(" "):

            word = trimWord(word)
            if word == "":
                continue
                
            if word not in banned:
                if word not in freq:
                    freq[word] = 0
                
                freq[word] += 1

                if freq[word] > freq[most_freq_word]:
                    most_freq_word = word

        return most_freq_word



