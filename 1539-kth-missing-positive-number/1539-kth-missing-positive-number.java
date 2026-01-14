class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 1;
        int high = arr[n - 1] + k;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = mid - countLessOrEqual(arr, mid);
            if (missing >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private int countLessOrEqual(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= x) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}
