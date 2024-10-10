package array;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

public class ZigzagConversion {

    public String convert(String s, int skip) {
        if (skip == 1 || skip >= s.length()) return s;
        StringBuilder str = new StringBuilder();

        int l = 0;
        int num = skip * 2 - 2;
        int gap = num;
        int gap2 = 0;
        while (skip-- > 0) {
            int i = l;
            boolean flag = true;

            while (i < s.length()) {
                str.append(s.charAt(i));
                if (flag == true && gap != 0 || gap2 == 0) {
                    i = i + gap;
                    flag = false;
                } else if (flag == false || gap == 0) {
                    i = i + gap2;
                    flag = true;
                }
            }
            l++;
            gap = gap - 2;
            gap2 = gap2 + 2;
        }
        return str.toString();
    }
}
