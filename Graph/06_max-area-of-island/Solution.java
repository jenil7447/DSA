// Time And Space Complexity:O(n * m)
class Solution {
    static  int subArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int Area = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 1){
                    subArea = 0;
                    dfs(grid,i,j);
                    if(Area < subArea){
                        Area = subArea;
                    }
                }
            }
        }
        return Area;
    }
    void dfs(int[][] grid,int i,int j){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 ){
                return ;
            }
            grid[i][j] = 0;
            subArea ++;
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
    }

}
