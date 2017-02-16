/* Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

/* Thoughts : use HashMap to store magazine and compare the key with ransomNote
   Notes: 1. Always consider corner cases firstly! if ransom is larger, it must be false!
          2. HashMap allows duplicate values with different key, but not allows duplicate keys!
          3. try to use for (char : Array) {} to iterate the entire array
          4. getOrDefault(Object key, V defaultValue) Returns the value to which the specified key is mapped, 
             or defaultValue if this map contains no mapping for the key
   
   Time Complexity: O(M+N)
   Space Complexity: O(N) or O(M)
*/ 
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        /* iterate over the magazine */
        for (char c : magazine.toCharArray()) {
            int newCount = map.getOrDefault(c, 0) + 1;
            map.put(c, newCount);
        }
        for (char c : ransomNote.toCharArray()) {
            int newCount = map.getOrDefault(c, 0) - 1;
            if (newCount < 0) {
                return false; // no available letter 
            }
            map.put(c, newCount);
        }
        return true;
    }
}
