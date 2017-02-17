/* Thoughts: 1. consider the corner cases, especially when only one string in the array, it itself will be valid prefix;
   2. nest loop? k for strs, i for char in a string
   3. 如何优化？
   
   Notes:注意了，经常在==这样的问题上犯错！
   
*/ 
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].length() == 0) { // consider all empty Strings
            return "";
        }
        
        if (strs.length == 1) {
            return strs[0];
        }
        
        StringBuilder record = new StringBuilder(""); // cannot assign a String to StringBuilder!
        int i = 0;
        int least = leastLen(strs); 
        while (i < least) { // 避免反复调用函数
            char a = strs[0].charAt(i);
            boolean judge = false;
            for (int k = 1; k < strs.length; k++) {
                if (a == strs[k].charAt(i)) {
                    judge = true;
                } else {
                    judge = false;
                    break; // two cases to end the loop, if break to end, the judge will be false; if end naturally, judge is true        
                }
            }
            if (judge == true) { // ==!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                record.append(a);
                i++;
            } else {
                break;
            }
            
        }
        return record.toString();
    }
    
        /* calculate the least length of String in strs  */
        private int leastLen(String[] strs) {
            List<Integer> list = new ArrayList<Integer>(); // to sort the length
            for (int i = 0; i < strs.length; i++) {
                list.add(strs[i].length());
            }
            Collections.sort(list);
            return list.get(0); // return the smallest num
        }    
        
        
}
