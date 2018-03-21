/*
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/


public class Codec {

    // Encodes a URL to a shortened URL.
    Map<Integer, String> map = new HashMap<>();
    String host = "http://tinyurl.com/";
    
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return host + Integer.toString(longUrl.hashCode());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replaceAll(host, "");
        String res = map.get(Integer.parseInt(key));
        return res;
    }
}
