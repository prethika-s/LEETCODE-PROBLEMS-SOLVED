class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=(height.length)-1;
        int tank=0;
        int maxTank=0;
        while(left<right){
            int distance=Math.abs(left-right);
            int minHeight=Math.min(height[left],height[right]);
            tank=minHeight*distance;
            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
            maxTank=Math.max(maxTank,tank);

        }
        return maxTank;
    }
}