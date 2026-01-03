class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[][] visited = new boolean[M][N];
        int[][] diff = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;
        int row = 0;
        int col = 0;
        result.add(matrix[row][col]);
        visited[row][col]=true;
        while(true){
            while(col+1<N && !visited[row][col+1]){
                row = row+diff[index][0];
                col = col+diff[index][1];
                result.add(matrix[row][col]);
                visited[row][col]=true;
            }
            index = index+1;
            while(row+1<M && !visited[row+1][col]){
                row = row+diff[index][0];
                col = col+diff[index][1];
                result.add(matrix[row][col]);
                visited[row][col]=true;
            }
            index = index+1;
            while(col-1>=0 && !visited[row][col-1]){
                row = row+diff[index][0];
                col = col+diff[index][1];
                result.add(matrix[row][col]);
                visited[row][col]=true;
            }
            index = index+1;
            while(row-1>=0 && !visited[row-1][col]){
                row = row+diff[index][0];
                col = col+diff[index][1];
                result.add(matrix[row][col]);
                visited[row][col]=true;
            }
            if(col+1<N && !visited[row][col+1]) index = 0;
            else break;
        }
        return result;
    }
}