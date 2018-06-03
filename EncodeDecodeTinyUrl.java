/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
  TinyURL is a URL shortening service where you enter a URL such as
  https://leetcode.com/problems/design-tinyurl and it returns a short URL
  such as http://tinyurl.com/4e9iAk.

  Design the encode and decode methods for the TinyURL service. There is no
  restriction on how your encode/decode algorithm should work. You just need to
  ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded
  to the original URL.
*/

public class Codec {
    private static HashMap<String, String> longToShortUrl = new HashMap<String, String>();
    private static HashMap<String, String> shortToLongUrl = new HashMap<String, String>();
    private final String CHARACTER_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private final int CHARACTER_SET_LENGTH = 62;
    private final int LENGTH_OF_SHORT_URL = 6;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = generateShortUrl(longUrl);

        longToShortUrl.put(longUrl, shortUrl);
        shortToLongUrl.put(shortUrl, longUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortToLongUrl.containsKey(shortUrl))
            return shortToLongUrl.get(shortUrl);

        return "";
    }

    private String generateShortUrl(String longUrl) {
        char characters[] = new char[LENGTH_OF_SHORT_URL];
        String shortUrl;

        do {
            for (int i = 0; i < LENGTH_OF_SHORT_URL; ++i) {
                int index = (int) (Math.random() * (CHARACTER_SET_LENGTH - 1));
                characters[i] = CHARACTER_SET.charAt(index);
            }
            shortUrl = new String(characters);
        } while(longToShortUrl.containsKey(shortUrl));

        return shortUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

public class EncodeDecodeTinyUrl {
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
            String url = stringToString(line);

            String ret = new Solution().CodecDriver(url);

            String out = (ret);

            System.out.print(out);
        }
    }
}
