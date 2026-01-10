class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        if(N1>N2) return findMedianSortedArrays(nums2, nums1);
        int left = 0;
        int right = N1;
        int L = (N1+N2+1)/2;
        int N = N1+N2;
        while(left<=right){
            int mid1 = (left+right)/2;
            int mid2 = L - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 < N1) r1 = nums1[mid1];
            if(mid2 < N2) r2 = nums2[mid2];
            if(mid1-1>=0) l1 = nums1[mid1-1];
            if(mid2-1>=0) l2 = nums2[mid2-1];
            if(l1<=r2 && l2<=r1){
                if(N%2==1) return Math.max(l1, l2);
                return ((double)(Math.max(l1,l2)+Math.min(r1,r2)))/2.0;
            }
            else if(l1>l2) right = mid1-1;
            else left = mid1+1;
        }
        return 0;
    }
}