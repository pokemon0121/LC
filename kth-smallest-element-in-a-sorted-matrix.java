public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /*
        // BFS, still too slow??
        // hashset de-duplicate, space O(2k)
        // minHeap, space O(k)
        // time O(klogk)
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return -1; // or exception
        int rows = matrix.length, cols = matrix[0].length;
        // minHeap, element is position of the element, but compare the value in matrix
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (matrix[a / cols][a % cols] - matrix[b / cols][b % cols]));
        Set<Integer> visitedIndex = new HashSet<>();
        minHeap.offer(0);
        int cur = 0;
        while (k > 0) {
            cur = minHeap.poll();
            //System.out.println("top of minheap: index=" + cur + ", value=" + matrix[cur / cols][cur % cols]);
            if (visitedIndex.contains(cur)) continue;
            visitedIndex.add(cur);
            int x = cur / cols, y = cur % cols;
            if (x + 1 < rows) {
                minHeap.offer((x + 1) * cols + y);
            }
            if (y + 1 < cols) {
                minHeap.offer(x * cols + (y + 1));
            }
            k--;
        }
        return matrix[cur / cols][cur % cols];
        */
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return -1; // or exception
        int rows = matrix.length, cols = matrix[0].length;
        int start = matrix[0][0], end = matrix[rows - 1][cols - 1] + 1, mid = 0;
        while (start < end) { // O(log(maxValue - minValue))
            mid = start + (end - start) / 2;
            int smaller = 0, j = cols - 1;
            // if (i, j) > mid, then (i + 1, j) < mid!
            for (int i = 0; i < rows; i++) { // O(cols)
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                smaller += (j + 1);
            }
            if (smaller < k) start = mid + 1;
            else end = mid;
        }
        return start;
    }
​
}
​
