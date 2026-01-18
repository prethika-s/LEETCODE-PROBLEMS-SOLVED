class Solution {
    public int num = 0;
    public int isSigned = 1;
    public int recursive(String s, int index, boolean hasSeenNumber){       
        if(index>=s.length()) return num*isSigned;
        if(hasSeenNumber && !Character.isDigit(s.charAt(index))) {
            return num*isSigned;
        }
        if(!hasSeenNumber && (s.charAt(index)=='+' || s.charAt(index)=='-') && (index+1 < s.length() && !Character.isDigit(s.charAt(index + 1)))) {
            return 0;
        }
        if(!hasSeenNumber && s.charAt(index)=='-'){
            isSigned = -1;
            return recursive(s, index+1, hasSeenNumber);
        }
        else if(!hasSeenNumber && s.charAt(index)=='+'){
            isSigned = 1;
            return recursive(s, index+1, hasSeenNumber);
        }
        if(Character.isDigit(s.charAt(index))){
            if(!hasSeenNumber){
                hasSeenNumber = true;
                num = s.charAt(index)-'0';
                return recursive(s, index+1, hasSeenNumber);
            }
            else if(hasSeenNumber){
                int digit = s.charAt(index)-'0';
                if(num > (Integer.MAX_VALUE - digit) / 10){
                    return isSigned == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = (num*10) + digit;
                return recursive(s, index+1, hasSeenNumber);
            }
    }
    return num*isSigned;
    }
    public int myAtoi(String s) {
        String temp = s.strip();
        //System.out.println(temp);
        boolean hasSeenNumber = false;
        return recursive(temp,0, hasSeenNumber);
    }
}