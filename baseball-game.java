class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        for (String op : ops) {
            if (op.equals("+")) {
                int a = s.pop();
                int b = s.pop();
                sum += a + b;
                s.push(b);
                s.push(a);
                s.push(b + a);
            }
            else if (op.equals("D")) {
                int a = s.pop();
                s.push(a);
                sum += 2 * a;
                s.push(2 * a);
            }
            else if (op.equals("C")) {
                int a = s.pop();
                sum -= a;
            }
            else {
                int a = Integer.parseInt(op);
                sum += a;
                s.push(a);
            }
        }
        return sum;
    }
}
​
