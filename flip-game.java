class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == '+' && str[i + 1] == '+') {
                str[i] = str[i + 1] = '-';
                res.add(new String(str));
                str[i] = str[i + 1] = '+';
            }
        }
        return res;
    }
}
​
