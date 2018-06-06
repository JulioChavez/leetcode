/*
  Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

  The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

  You may assume the integer does not contain any leading zero, except the number 0 itself.

  Example 1:

  Input: [1,2,3]
  Output: [1,2,4]
  Explanation: The array represents the integer 123.
  Example 2:

  Input: [4,3,2,1]
  Output: [4,3,2,2]
  Explanation: The array represents the integer 4321.
  */

  class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }

            digits[i] = 0;
        }

        int[] extraDigitArray = new int[digits.length + 1];
        extraDigitArray[0] = 1;
        for (int i = 0; i < digits.length; ++i) {
            extraDigitArray[i + 1] = digits[i];
        }
        return extraDigitArray;
    }
}

public class PlusOne {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] digits = stringToIntegerArray(line);

            int[] ret = new Solution().plusOne(digits);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
