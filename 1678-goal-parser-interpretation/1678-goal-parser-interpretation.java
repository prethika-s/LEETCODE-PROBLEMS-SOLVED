class Solution {
    public String interpret(String command) {
        String goal = "";
        for(int i=0; i<command.length(); i++){
            if(command.charAt(i)==')'){
                if(command.charAt(i-1)=='(') goal+='o';
                continue;
            }
            else if(command.charAt(i)!='(' && command.charAt(i)!=')'){
                goal+=command.charAt(i);
            }
        }
        return goal;
    }
}