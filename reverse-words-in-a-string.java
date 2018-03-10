public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        reverseCharArray(chars, 0, chars.length - 1);
        int slow = 0, fast = 0;
        while (fast < chars.length) {
            // get slow to start of the word
            while (fast < chars.length && chars[fast] == ' ') {
                slow = ++fast;
            }
            // find end of word
            while (fast < chars.length && chars[fast] != ' ') {
                fast++;
            }
            // found a word: [slow, fast)
            reverseCharArray(chars, slow, fast - 1);
            // move together
            slow = fast;
        }
        // post processing, trim
        return trimCharArray(chars);
    }
    
    private void reverseCharArray(char[] s, int i, int j) {
        if (s == null || s.length <= 1) return;
        while (i < j) {
            swap(s, i++, j--);
        }
    }
    
    private String trimCharArray(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            // keep every space after a word
            if (chars[fast] != ' ' || (fast != 0 && chars[fast - 1] != ' '))
                chars[slow++] = chars[fast];
        }
        if (slow == 0) return "";
        // chars[slow - 1] might equal to 0
        // because last word might have trailing 0. if yes, then we have an extra 0; if not, we don't have that
        return new String(chars, 0, chars[slow - 1] == ' ' ? slow - 1 : slow);
    }
    
    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
​
