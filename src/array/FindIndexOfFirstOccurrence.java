package array;

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */

public class FindIndexOfFirstOccurrence {

    public static void main(String[] args) {
        String str1 = "aadbutsad";
        String str2 = "sad";
        System.out.println(strStr(str1, str2));
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;
        boolean flag = false;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                flag = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (k == haystack.length()) {
                        flag = false;
                        break;
                    }
                    if (haystack.charAt(k) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                    k++;
                }
            }
            if (flag) {
                index = i;
                return index;
            }
        }
        return index;
    }

}
