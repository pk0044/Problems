package com.pk.Problems;

public class NumberOfIsland {
	
	int row = 0;
	int col = 0;
	
	int[][] visited;
	char[][] grid;
	
	int count = 0;
	
	private void traverse(int r, int c) {
		if(r+1 < this.row && visited[r+1][c] == 0 && grid[r+1][c] == '1') {
			visited[r+1][c] = 1;
			traverse(r+1, c);
		}
		
		if(r-1 >= 0 && visited[r-1][c] == 0 && grid[r-1][c] == '1') {
			visited[r-1][c] = 1;
			traverse(r-1, c);
		}
		
		if(c+1 < this.col && visited[r][c+1] == 0 && grid[r][c+1] == '1') {
			visited[r][c+1] = 1;
			traverse(r, c+1);
		}
		
		if(c-1 >= 0 && visited[r][c-1] == 0 && grid[r][c-1] == '1') {
			visited[r][c-1] = 1;
			traverse(r, c-1);
		}
	}
	
	
    public int numIslands(char[][] grid) {
    	this.grid = grid;
    	count = 0;
    	
    	int size = grid.length;
    	if(size == 0) {
    		return 0;
    	}
    	
    	int row = grid.length;
    	int col = grid[0].length;
    	
    	this.row = row;
    	this.col = col;
    	
    	visited = new int[row][col];
    	
    	for(int i=0; i<row; i++) {
    		for(int j=0; j<col; j++) {
    			if(visited[i][j] == 0 && grid[i][j] == '1') {
    				visited[i][j] = 1;
    				count++;
    				traverse(i, j);
    			}
    		}
    	}
    	
		return count;
    }
}
