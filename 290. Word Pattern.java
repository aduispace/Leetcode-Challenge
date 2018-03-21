/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
*/

// 一个map保存映射关系，但由于是1-1的映射，而java hashmap可以多对1（有重复values），所以要用set去重！！！ 
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (set.contains(arr[i])) {
                    return false;
                } else {
                    map.put(pattern.charAt(i), arr[i]);
                    set.add(arr[i]);
                }
            } else {
                if (!map.get(pattern.charAt(i)).equals(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
