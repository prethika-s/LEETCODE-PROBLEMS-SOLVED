class Solution {
    void paranthesis(String s, int openCount, int closeCount, ArrayList<String> result,int n){
        if(s.length()==2*n){
            result.add(s);
            return;
        }
        if(openCount<n){
            paranthesis(s+"(",openCount+1,closeCount,result,n);
        }
        if(closeCount<openCount){
            paranthesis(s+")",openCount,closeCount+1,result,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        int openCount=0;
        int closeCount=0;
        String s="";
        paranthesis(s,openCount,closeCount,result,n);
        return result;
    }
}