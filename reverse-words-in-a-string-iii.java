public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String r = "";
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            r += sb.toString();
            r += i == words.length - 1 ? "" : " ";
        }
        return r;
    }
}
​
