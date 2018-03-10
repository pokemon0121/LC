public class Solution {
    
    public int strStr(String haystack, String needle) {
        /*
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
        */
        return strStr2(needle, haystack);
    }
    
    public int strStr2(String shortStr, String longStr) {
        if (shortStr == null || longStr == null) return -1;
        if (shortStr.length() == 0) return 0;
        if (longStr.length() == 0) return -1;
        //if (shortStr.length() > longStr.length()) return strStr2(longStr, shortStr);
        for (int i = 0; i < longStr.length() - shortStr.length() + 1; i++) {
            int j = 0;
            while (j < shortStr.length() && longStr.charAt(i + j) == shortStr.charAt(j)) {
                j++;
            }
            if (j == shortStr.length()) return i;
        }
        return -1;
    }
}
​
