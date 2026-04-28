class Solution {
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        if(N==1) return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for(int i=0; i<N; i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                while(map.containsKey(ch)){
                    char temp = s.charAt(start);
                    int freq = map.get(temp);
                    map.put(temp, freq-1);
                    if(map.get(temp)==0) map.remove(temp);
                    start++;
                }
                map.put(ch, 1);
            }
                int windowSize = i-start+1;
                maxLen = Math.max(maxLen, windowSize);
        }
        return maxLen;
    }
}