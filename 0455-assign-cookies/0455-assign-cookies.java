class Solution {
    public int findContentChildren(int[] students, int[] cookies) {
        int count = 0;
        Arrays.sort(students);
        Arrays.sort(cookies);
        int left = 0;
        int right = 0;
        while(right!=students.length && left!=cookies.length){
            int greedFactor = students[right];
            int cookie = cookies[left];
            if(cookie>=greedFactor){
                count++;
                left++;
                right++;
            }
            else{
                left++;
            }
        }
        return count;
    }
}