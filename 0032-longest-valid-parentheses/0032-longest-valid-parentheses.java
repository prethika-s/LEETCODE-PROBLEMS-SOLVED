class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result=0;
        for(int index=0;index<s.length();index++){
            if(s.charAt(index)=='('){
                stack.push(index);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }

                if(!stack.isEmpty()){
                    result=Math.max(result,index-stack.peek());
                }else{
                    stack.push(index);
                }
            }
        }
        return result;
    }
}