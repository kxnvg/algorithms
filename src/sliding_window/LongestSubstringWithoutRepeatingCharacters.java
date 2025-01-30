package sliding_window;

/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int tempCount = 0;
        int firstIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                result = Math.max(tempCount, result);

                Integer idx = map.get(ch);
                int j = idx;
                while (j >= 0) {
                    map.remove(j);
                }


                idx++;
                int skippedChar = idx - firstIndex;
                tempCount -= skippedChar;
                map.put(ch, i);
                tempCount++;
                firstIndex = idx;
            } else {
                map.put(ch, i);
                tempCount++;
                result = Math.max(tempCount, result);
            }
        }
        return result;
    }
}
