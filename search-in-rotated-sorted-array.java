public class Solution {
    public int search(int[] array, int target) {
        // check
        if (array == null || array.length == 0) return -1;
        int rotationPoint = 0; 
        if (array[0] > array[array.length - 1]) {
            int start = 0, end = array.length - 1, mid = 0;
            while (start + 1 < end) {
                mid = start + (end - start) / 2;
                if (array[mid] == target) return mid;
                if (array[mid] > array[end]) start = mid;
                else if (array[mid] < array[start]) end = mid;
            }
            rotationPoint = end;
        }
        //System.out.println(rotationPoint);
        // do general bs to find out the index
        // start <= end: solution 3, good for find target, no post-processing
        int start = 0, end = array.length - 1, mid = 0, realMid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            realMid = (mid + rotationPoint) % array.length;
            if (array[realMid] == target) return realMid;
            else if (array[realMid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
​
