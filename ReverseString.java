/**
  Write a function that takes a string as input and returns the string reversed.

  Example:
  Given s = "hello", return "olleh".
*/

class Solution {
    public String reverseString(String s) {
        char arr[] = s.toCharArray();
        int length = s.length();

        char tmp;
        int oppositeIndex;
        for (int i = 0; i < length / 2; ++i) {
            oppositeIndex = length - 1 - i;
            tmp = arr[i];

            arr[i] = arr[oppositeIndex];
            arr[oppositeIndex] = tmp;
        }

        return new String(arr);
    }
}

public class ReverseString {
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

            String ret = new Solution().reverseString(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}
