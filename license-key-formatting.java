class Solution {
    public String licenseKeyFormatting(String S, int K) {
        // convert to alphanumerical characters only
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') continue;
            if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z')
                sb.append(Character.toUpperCase(S.charAt(i)));
            else sb.append(S.charAt(i));
        }
        String s = sb.toString();
        int n = s.length();
        if (n == 0) return "";
        // find starting point
        int r = n % K == 0 ? 0 : (n / K + 1) * K - n;
        sb = new StringBuilder();  
        for (int i = 0, c = r; i < n; i++) {
            sb.append(s.charAt(i));
            if (++c >= K && i != n - 1) {
                sb.append('-');
                c = 0;
            }
        }
        return sb.toString();
    }
}
