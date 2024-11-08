// 30. Substring with Concatenation of All Words

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        
        if (s.length() < totalLen) {
            return result;
        }

        // Create frequency map for words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Try each possible starting position
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> currentCount = new HashMap<>();
            int left = i;
            int count = 0;
            
            // Process each word-sized substring
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String currentWord = s.substring(j, j + wordLen);
                
                // If this is not a valid word, reset everything
                if (!wordCount.containsKey(currentWord)) {
                    currentCount.clear();
                    count = 0;
                    left = j + wordLen;
                    continue;
                }

                // Add the current word to our window
                currentCount.put(currentWord, currentCount.getOrDefault(currentWord, 0) + 1);
                count++;

                // Remove words from the start if we have too many
                while (currentCount.getOrDefault(currentWord, 0) > wordCount.getOrDefault(currentWord, 0)) {
                    String leftWord = s.substring(left, left + wordLen);
                    currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                // If we have found all words
                if (count == numWords) {
                    result.add(left);
                    // Remove leftmost word and continue sliding
                    String leftWord = s.substring(left, left + wordLen);
                    currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
            }
        }
        
        return result;
    }
}
