class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int idx = 0;
        int N = s.length();
        generate(result, temp, idx, s, N, true);
        return result;
    }
    public void generate(List<List<String>> result, List<String> temp, int idx, String s, int N, boolean flag){
        if(!flag) return;
        if(idx==N){
            result.add(new ArrayList<String> (temp));
        }
        for(int i=idx; i<N; i++){
            String ts = s.substring(idx,i+1);
            boolean flag1 = checkPalindrome(ts);
            if(flag1){
                temp.add(ts);                
                generate(result, temp, i+1, s, N, flag1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean checkPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}