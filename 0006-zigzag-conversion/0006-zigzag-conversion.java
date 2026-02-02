class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }
        int row = 0;
        boolean goingDown = false;
        for (char ch : s.toCharArray()){
            rows[row].append(ch);
            if (row == 0 || row == numRows-1){
                goingDown = !goingDown;
            }
            row += goingDown ? 1:-1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows){
            res.append(sb);
        }
        return res.toString();
    }
}