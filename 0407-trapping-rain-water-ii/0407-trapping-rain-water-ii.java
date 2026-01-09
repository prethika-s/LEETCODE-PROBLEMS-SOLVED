class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;
        boolean[][] visited=new boolean[m][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    pq.add(new int[]{heightMap[i][j], i, j});
                    visited[i][j]=true;
                }
            }
        }
        int[][] direction={ {0,1}, {0,-1}, {1,0}, {-1,0} };
        int waterVolume=0;
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int cv=arr[0];    
            int cr=arr[1];    
            int cc=arr[2];
            for(int[] dir:direction){
                int nr=cr+dir[0];   
                int nc=cc+dir[1];   
                if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc]){
                    if(cv-heightMap[nr][nc]>0){
                        waterVolume+=cv-heightMap[nr][nc];
                        pq.add(new int[]{cv, nr, nc});
                    }
                    else{
                        pq.add(new int[]{heightMap[nr][nc], nr, nc});
                    }

                    visited[nr][nc]=true;
                }
            }
        }
        return waterVolume;
    }
}             