class NumberOfIslands_200{
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length <= 0 || grid[0].length <= 0)
            return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i)
            for(int j = 0; j < grid[0].length; ++j)
                visited[i][j] = false; 
        
        int record = 0;
        Stack<Pointer> stack = new Stack<Pointer>();

        for(int i = 0; i < grid.length; ++i){

            for(int j = 0; j < grid[0].length; ++j){
                //System.out.println(i + " " + j);
                if(!visited[i][j]){
                    visited[i][j] = true;
                    if(grid[i][j] == '1'){
                        ++record;
                        stack.push(new Pointer(i, j));
                        dfs(grid, visited, stack);
                    }
                }
                
            }
            
        }
            
            
        
        return record;
    } 
    
    private void dfs(char[][] grid, boolean[][] visited, Stack<Pointer> stack){
        while(!stack.isEmpty()){
                
                Pointer p = stack.peek();
                //System.out.println("stack :" + p.x + " " + p.y);
                if (p.y + 1 < grid[0].length && !visited[p.x][p.y + 1] && grid[p.x][p.y + 1] == '1'){
                    visited[p.x][p.y + 1] = true;
                    stack.push(new Pointer(p.x, p.y + 1));
                        
                }
                else if (p.x + 1 < grid.length && !visited[p.x + 1][p.y] && grid[p.x + 1][p.y] == '1'){
                    visited[p.x + 1][p.y] = true;
                    stack.push(new Pointer(p.x + 1, p.y));
                }
                else if (p.y - 1 >= 0 && !visited[p.x][p.y - 1] && grid[p.x][p.y - 1] == '1'){
                    visited[p.x][p.y - 1] = true;
                    stack.push(new Pointer(p.x, p.y - 1));
                }
                else if (p.x - 1 >= 0 && !visited[p.x - 1][p.y] && grid[p.x - 1][p.y] == '1'){
                    visited[p.x - 1][p.y] = true;
                    stack.push(new Pointer(p.x - 1, p.y));
                }
                else{
                    stack.pop();
                }
            }
    }
    
    class Pointer{
        int x = 0;
        int y = 0;
        Pointer(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}