class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int n : nums1) set.add(n);
        for (int n : nums2)
            if (set.contains(n)) intersect.add(n);
        int[] res = new int[intersect.size()];
        int i = 0;
        for (int n : intersect) 
            res[i++] = n;
        return res;
    }
}
​
