class Solution {
    public int findCircleNum(int[][] isConnected) {
       boolean[] visitedArray = new boolean[isConnected.length];
       int count = 0 ;
       for(int i = 0 ; i < visitedArray.length ; i++){
        if(!visitedArray[i]){
            count ++;
            dfs(i,isConnected,visitedArray);
        }
       }
       return count;
    }
    void dfs(int node, int[][] isConnected ,boolean[]visitedArray){
        visitedArray[node] =  true;
        for(int neighbor = 0; neighbor < isConnected.length; neighbor++){
            if (isConnected[node][neighbor] == 1 && !visitedArray[neighbor]) {
                dfs(neighbor, isConnected, visitedArray); 
            }
        }
    }
}
