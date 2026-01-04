class Solution {
    public String truncateSentence(String s, int k) {
        String[] parts = s.split(" ");
        String result = "";
        for(int i=1; i<=k-1; i++){
            result+=parts[i-1];
            result+=" ";
        }
        result+=parts[k-1];
        return result;
    }
}