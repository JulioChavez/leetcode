/**
  Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

  Example 1:

  Input: 121
  Output: true
  Example 2:

  Input: -121
  Output: false
  Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
  Example 3:

  Input: 10
  Output: false
  Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
  Follow up:

  Could you solve it without converting the integer to a string?
*/

class Solution {
    public boolean isPalindrome(int x) {
        /* Edge cases:
           - negative numbers
           - numbers that end in 0 and are not equal
             to 0 since those numbers would never have a leading 0 to make them
             a palindrome
        */
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int mirroredNum = 0;
        while (mirroredNum < x) {
            // Increase the mirrored number's magnitude and add to it the last
            // number from x
            mirroredNum = 10 * mirroredNum + x % 10;

            // Remove the last number from x if the mirrored number is smaller
            if (mirroredNum < x)
                x /= 10;
        }

        return mirroredNum == x;
    }
}

public class PalindromeNumber {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            boolean ret = new Solution().isPalindrome(x);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
