/**
 *
 *  535. Encode and Decode TinyUR
 *    TinyURL is a URL shortening service where you enter a URL such as 
 *    https://leetcode.com/problems/design-tinyurl and it returns a short URL such as 
 *    http://tinyurl.com/4e9iAk.
 *    
 *    Design the encode and decode methods for the TinyURL service. There is no 
 *    restriction on how your encode/decode algorithm should work. You just need to 
 *    ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to 
 *    the original URL.
 *
 */
import java.util.*;

public class Codec {
	int index = 0;
	HashMap<String, String> map = new HashMap<>();
	
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String shortUrl = String.valueOf(index++);
		map.put(shortUrl, longUrl);
		return shortUrl;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return map.containsKey(shortUrl) ? map.get(shortUrl) : "";
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));