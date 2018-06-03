/**
  Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

  Symbol       Value
  I             1
  V             5
  X             10
  L             50
  C             100
  D             500
  M             1000
  For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

  Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

  I can be placed before V (5) and X (10) to make 4 and 9.
  X can be placed before L (50) and C (100) to make 40 and 90.
  C can be placed before D (500) and M (1000) to make 400 and 900.
  Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

  Example 1:
    Input: "III"
    Output: 3
  Example 2:
    Input: "IV"
    Output: 4
  Example 3:
    Input: "IX"
    Output: 9
  Example 4:
    Input: "LVIII"
    Output: 58
    Explanation: C = 100, L = 50, XXX = 30 and III = 3.
  Example 5:
    Input: "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; ++i) {
            // Get the value of the current Roman letter
            int num1 = getInt(s.charAt(i));

            if (i < length - 1) {
                // Get the value of the next Roman letter
                int num2 = getInt(s.charAt(i + 1));

                // If the first Roman letter is smaller in value than the next letter, then subtract
                if (num1 < num2) {
                    // Update total with both the numbers
                    total += num2 - num1;
                    // Update the i pointer and continue
                    ++i;
                    continue;
                }
            }

            // Add the current Roman letter's value to the total
            total += num1;
        }

        return total;
    }

    private int getInt(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

public class RomanToInteger {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().romanToInt(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
