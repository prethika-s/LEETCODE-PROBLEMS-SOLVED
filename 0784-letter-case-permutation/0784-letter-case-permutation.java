class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        int N = s.length();
        char[] string = s.toCharArray();

        for (int i = 0; i < N; i++) {
            string[i] = Character.toLowerCase(string[i]);
        }

        recursion(string, 0, result, N);
        return result;
    }

    public void recursion(char[] string, int idx, List<String> result, int N) {
        // add result at every recursion entry
        result.add(new String(string));

        for (int i = idx; i < N; i++) {
            if (Character.isDigit(string[i])) continue;

            string[i] = Character.toUpperCase(string[i]);
            recursion(string, i + 1, result, N);
            string[i] = Character.toLowerCase(string[i]); // backtrack
        }
    }
}
