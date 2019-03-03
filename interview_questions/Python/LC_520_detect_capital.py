# Given a word, you need to judge whether the usage of capitals in it is right or not.

# We define the usage of capitals in a word to be right when one of the following cases holds:

# All letters in this word are capitals, like "USA".
# All letters in this word are not capitals, like "leetcode".
# Only the first letter in this word is capital if it has more than one letter, like "Google".
# Otherwise, we define that this word doesn't use capitals in a right way.

# Example 1:
#	Input: "USA"
#	Output: True

# Example 2:
#	Input: "FlaG"
#	Output: False

# Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.




class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        if word.isupper()==True :
            return True
        else :
            if word.islower()==True :
                return True
            else :
                word1 = word.capitalize()
                a = 0
                for i in range(1,len(word)):
                    if word1[i] == word[i]:
                        a=0
                    else :
                        a = 1
                        return False
                if a==0:
                    return True
        