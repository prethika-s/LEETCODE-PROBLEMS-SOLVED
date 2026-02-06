class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(k>n){
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        generateSum(result, temp, sum, n, k, 1);
        return result;
    }
    public void generateSum(List<List<Integer>> result, List<Integer> temp, int sum, int N, int size, int num){
        if(temp.size()>size) return;
        if(sum==N && temp.size()==size) result.add(new ArrayList<Integer> (temp));
        for(int i=num; i<=9; i++){
            sum+=i;
            temp.add(i);
            generateSum(result, temp, sum, N, size, i+1);
            temp.remove(temp.size()-1);
            sum-=i;
        }
    }
}