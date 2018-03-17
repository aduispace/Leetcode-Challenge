/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/

// EASY ONE:

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
    }
}

// VERBOSE ONE:

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<Integer, List<List<String>>> map = new HashMap<>(); // size, pattern
        for (String i : strings) {
            if (!map.containsKey(i.length())) {
                List<List<String>> temp = new ArrayList<List<String>>();
                List<String> l = new ArrayList<>();
                l.add(i);
                temp.add(l);
                map.put(i.length(), temp);
            } else {
                List<List<String>> pattern = map.get(i.length());
                boolean noPattern = true;
                for (List<String> list : pattern) {
                    if (hasSamePattern(list.get(0), i)) {
                        list.add(i);
                        noPattern = false;
                        break;
                    }
                }
                if (noPattern) {
                    List<String> l = new ArrayList<>();
                    l.add(i);
                    pattern.add(l);
                    map.put(i.length(), pattern);
                }
            }
        }
        
        for (List<List<String>> list : map.values()) {
            res.addAll(list);
        }
        return res;
    }
    
    private boolean hasSamePattern(String a, String b) {
        int temp = (a.charAt(0) - b.charAt(0)) < 0? a.charAt(0) - b.charAt(0) + 26 : a.charAt(0) - b.charAt(0);
        for (int i = 1; i < a.length(); i++) {
            int gap = (a.charAt(i) - b.charAt(i)) < 0? a.charAt(i) - b.charAt(i) + 26 : a.charAt(i) - b.charAt(i);
            if (gap != temp) {
                return false;
            }
        }
        return true;
    }
}
