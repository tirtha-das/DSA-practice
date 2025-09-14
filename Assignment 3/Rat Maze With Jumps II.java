class Solution{
    // Check if a given coordinates (x, y) are safe within the matrix boundaries and the value at that position is non-zero.
	boolean isSafe(int x, int y, int [][] matrix){
		int n = matrix.length;
		return (x >= 0 && x < n && y >=0 && y < n && matrix[x][y] != 0);
	}
	
	// Recursive helper function to find the shortest distance from (0, 0) to (n-1, n-1) in the matrix.
	boolean helper(int x, int y, int [][] matrix, int [][] sol){
		int n = matrix.length;
		
		// If we have reached the destination (n-1, n-1), mark it as a valid path.
		if(x == n-1 && y == n-1){
			sol[x][y] = 1;
			return true;
		}
		
		// If we are at a safe position, mark it as a valid path and explore all possible steps.
		if(isSafe(x, y, matrix)){
			sol[x][y] = 1;
			
			// Explore all possible steps from the current position.
			for(int step = 1; step <= matrix[x][y] && step < n; step++){
				// Try moving right and check if it leads to a valid path.
				if(helper(x, y+step, matrix, sol))
					return true;
				
				// Try moving down and check if it leads to a valid path.
				if(helper(x+step, y, matrix, sol))
					return true;
			}
			
			// If no valid path is found, mark the current position as invalid and backtrack.
			sol[x][y] = 0;
			return false;
		}
		
		// If we are at an unsafe position, return false.
		return false;
	}
    
    public int[][] ShortestDistance(int[][] matrix)
    {
        int  n = matrix.length;
		int [][] sol = new int[n][n];
		// Call the helper function to find the shortest distance path from (0, 0) to (n-1, n-1).
		helper(0, 0, matrix, sol);
		
		// If no valid path is found, return a matrix with a single element indicating failure.
		if(sol[n-1][n-1] == 0){
		    int [][] ans = new int[1][1];
		    ans[0][0] = -1;
		    return ans;
		}
		
		// Otherwise, return the solution matrix representing the shortest distance path.
		return sol;
    }
}


int solve(vector<int>&nums){
	
}