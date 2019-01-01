package Leetcode;

import java.util.HashMap;
import java.util.Random;

/*
    TinyURL is a URL shortening service where you enter a URL
    such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

    Design the encode and decode methods for the TinyURL service.
    There is no restriction on how your encode/decode algorithm should work.
    You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class Medium_EncodeURL_535 {
    public static void main(String[] args){
        Codec codec = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        String result = codec.decode(codec.encode(url));
        System.out.println(result);
    }
}

// Runtime: 6 ms, faster than 57.28% of Java online submissions
class Codec {

    final String prefix = "http://tinyurl.com/";
    private HashMap<String, String> hm = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random num = new Random();
        String key = prefix + (char) num.nextInt(26 + 'a');
        hm.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hm.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));