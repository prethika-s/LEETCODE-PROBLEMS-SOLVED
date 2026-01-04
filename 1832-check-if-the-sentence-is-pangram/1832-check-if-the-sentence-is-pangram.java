class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] alpha = new int[26];
        for(int i=0; i<sentence.length(); i++){
            int index = sentence.charAt(i)-'a';
            alpha[index]++;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(alpha[i]>0){
                count++;
            }
        }
        if(count==26) return true;
        else return false;
    }
}