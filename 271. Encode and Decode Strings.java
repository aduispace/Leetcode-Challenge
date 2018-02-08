/**
271. Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.


*/
// use (length + '!') as seperator, be careful of how to move i when decoding 

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        // format: num!str, like 12!AVABADFADFAa, can use num = -1 to represent NULL
        for (String str : strs) {
            if (str == null) continue;
            sb.append(str.length()).append('!').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        // example: 3!abc5!abcde
        while (i < s.length()) {
            int mark_index = s.indexOf('!', i);
            int num = Integer.parseInt(s.substring(i, mark_index));
            i = mark_index + num + 1;
            res.add(s.substring(mark_index + 1, i));
        }
        return res;
    }
}
