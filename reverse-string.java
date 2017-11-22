public class Solution {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
​
        while(begin < end) {
            // swap(str[begin], str[end]);
            char t = str[begin];
            str[begin] = str[end];
            str[end] = t;
​
            begin++;
            end--;
        }
​
        return new String(str);
    }
}
