/* Thoughts: Out of time limit! */

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() < needle.length()) { // no need to determine the haystack.length() == 0, cuz the record afterwards takes care of it!
            return -1;
        }
        if (needle.length() == 0) {
            return 0; // take care of this corner case, if needle == "", it must be valid, so return 0!
        }
        
        for (int i = 0; i < haystack.length(); i++) {
            for (int k = 0; k < needle.length(); k++) {
                if (k + i >= haystack.length() || haystack.charAt(i + k) != needle.charAt(k)) {break;}
                if (k == needle.length() - 1) {return i;}
            }
        }
        
        return -1;
    }
}


/* reduce some conditional clauses to save time */
/* Thoughts: time limit is okay right now */

public class Solution {
    public int strStr(String haystack, String needle) {
        /* it must be vaild when needle is empty */
        if (needle.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i < haystack.length(); i++) {
            for (int k = 0; k < needle.length(); k++) {
                if (k + i >= haystack.length()) {return -1;} // k+i has exceed the range of haystack length, but found nothing, so return -1                                         
                if (haystack.charAt(i + k) != needle.charAt(k)) {break;} // basic break case
                if (k == needle.length() - 1) {return i;} // hang on until last step before k exceeds!
                
            }
        }   
        return -1;
    }
  
}
