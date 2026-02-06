class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int start = 1;
        generate(result, temp, n, k, start);
        return result;
    }
    public void generate(List<List<Integer>> result, List<Integer> temp, int limit, int size, int start){
        if(temp.size()==size){
            result.add(new ArrayList<Integer> (temp));
        }
        for(int i=start; i<=limit; i++){
            temp.add(i);
            generate(result, temp, limit, size, i+1);
            if(temp.size()!=0) temp.remove(temp.size()-1);
        }
    }
}