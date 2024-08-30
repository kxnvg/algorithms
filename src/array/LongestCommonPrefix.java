package array;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        int maxLength = s.length();


        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            int curLength = 0;

            int j = 0;
            while (true) {
                if (j == word.length() || j == s.length()) break;
                if (s.charAt(j) == word.charAt(j)) {
                    curLength++;
                    j++;
                } else break;
            }
            maxLength = Math.min(maxLength, curLength);
        }
        return s.substring(0, maxLength);
    }

    public String longestCommonPrefix1(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
