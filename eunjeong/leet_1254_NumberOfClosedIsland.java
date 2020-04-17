// 전형적인 dfs, bfs 탐색문
// bfs로도 바꿔서 풀어보자
class Solution {
int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
public int closedIsland(int[][] grid) {
    int result=0; 
    for(int x=0; x<grid.length; x++){ 
        for(int y=0; y<grid[0].length ; y++){
            //  땅일 때 dfs 수행
            if(grid[x][y] == 0){ 
                //
                if(dfs(grid, x, y)){
                    result++;
                }
            }

        }
    }
    return result;
}

boolean dfs(int[][] grid, int x, int y){
    boolean result=true;

    if(x==0||x==grid.length-1||y==0||y==grid[0].length-1){
        result=false;
    }

    //  해당 영역 탐색했으면 체크해주기
    grid[x][y]=2;

    for(int[] direction : directions){
        //  움직일 방향
        int row= x+direction[0], col= y+direction[1];
        //  범위안에 있고, 이동한 영역이 땅이라면
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==0){
            result = dfs(grid, row, col) && result;
        }
    }
    return result;
}
}


