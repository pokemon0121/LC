class Solution {
    public String nextClosestTime(String time) {
        List<Character> digits = new ArrayList<>();
        time = new StringBuilder(time).deleteCharAt(2).toString();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                digits.add(c);
            }
        }
        Collections.sort(digits);
        TreeSet<String> possibleTime = new TreeSet<>();
        getPossibleTime(digits, possibleTime, new StringBuilder());
        //System.out.println(possibleTime);
        if (possibleTime.higher(time) == null) {
            return new StringBuilder(possibleTime.first()).insert(2, ':').toString();
        }
        return new StringBuilder(possibleTime.higher(time)).insert(2, ':').toString();
    }
    
    private void getPossibleTime(List<Character> digits, TreeSet<String> res, StringBuilder cur) {
        //System.out.println(cur);
        if (cur.length() == 4) {
            res.add(cur.toString());
            return;
        }
        if (cur.length() == 0) {
            for (char c : digits) {
                if (c >= '0' && c <= '2') {
                    cur.append(c);
                    getPossibleTime(digits, res, cur);
                    cur.deleteCharAt(cur.length() - 1);
                }
            }
        }
        else if (cur.length() == 1) {
            if (cur.toString().equals("2")) {
                for (char c : digits) {
                    if (c >= '0' && c <= '3') {
                        cur.append(c);
                        getPossibleTime(digits, res, cur);
                        cur.deleteCharAt(cur.length() - 1);
                    }
                }
            }
            else {
                for (char c : digits) {
                    cur.append(c);
                    getPossibleTime(digits, res, cur);
                    cur.deleteCharAt(cur.length() - 1);
                }
            }
        }
        else if (cur.length() == 2) {
            for (char c : digits) {
                if (c >= '0' && c <= '5') {
                    cur.append(c);
                    getPossibleTime(digits, res, cur);
                    cur.deleteCharAt(cur.length() - 1);
                }
            }
        }
        else {
            for (char c : digits) {
                cur.append(c);
                getPossibleTime(digits, res, cur);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
