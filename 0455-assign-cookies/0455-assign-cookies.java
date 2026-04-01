class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int greed = 0;
        int cookie = 0;
        while(greed<g.length && cookie<s.length){
            int gr = g[greed];
            int co = s[cookie];
            if(co>=gr){
                count++;
                greed++;
                cookie++;
            }
            else{
                cookie++;
            }
        }
        return count;
    }
}