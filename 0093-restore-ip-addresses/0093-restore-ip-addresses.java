class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int N = s.length();
        generate(result, temp, 0, s, N);
        return result;
    }
    public void generate(List<String> result, List<String> temp, int idx, String s, int N) {
        if (temp.size() == 4) {
            if (idx == N) {
                result.add(String.join(".", temp));
            }
            return;
        }
        for (int i = idx; i < N && i < idx + 3; i++) {
            String part = s.substring(idx, i + 1);
            if (isValid(part)) {
                temp.add(part);
                generate(result, temp, i + 1, s, N);
                temp.remove(temp.size() - 1); 
            }
        }
    }
    public boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}
