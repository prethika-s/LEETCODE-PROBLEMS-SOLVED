class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int N = people.length;
        Arrays.sort(people);
        int count = 0;
        int low = 0;
        int high = N-1;
        while(low<=high){
            int sum = people[low]+people[high];
            if(sum<=limit){
                count++;
                low++;
                high--;
            }
            else{
                high--;
                count++;
            }
        }
        return count;
    }
}