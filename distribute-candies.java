public class Solution {
    public int distributeCandies(int[] candies) {
        // n/2 candies, each person
        // k kinds of candies.
        // if k > n/2, so the answer is n/2
        // else, answer = k
        Set<Integer> s = new HashSet<>();
        for (int c : candies) {
            s.add(c);
        }
        int n = candies.length / 2;
        return s.size() > n ? n : s.size();
    }
}
​
