class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        // use treeset, nlogn
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int cur = flowers[i];
            Integer higher = set.higher(cur);
            if (higher != null && higher - cur - 1 == k)
                return i + 1;
            Integer lower = set.lower(cur);
            if (lower != null && cur - lower - 1 == k)
                return i + 1;
            set.add(cur); // lgn
        }
        return -1;
    }
}
