class Solution {
     void addSequence(int[][] board,List<List<String>>ans){
        List<String> res = new ArrayList<>();
        for(int []row : board){
            StringBuilder sb = new StringBuilder("");
            for(int val : row){
                if(val>0){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }

            res.add(sb.toString());
        }

        ans.add(res);
     }

    boolean verticalCheck(int row,int col,int[][]board,int n){
        for(int i=0;i<n;i++){
            if(i!=row){
                if(board[i][col]==1){
                    return false;
                }
            }
        }

        return true;
    }

    boolean diagonalCheck(int row,int col,int[][]board,int n){
        int pr = row-1,pc = col-1,nc = col+1;

        while(pr>=0 && pc>=0){
            if(board[pr][pc]==1){
                return false;
            }
            pr--;
            pc--;
        }

        pr = row-1;

        while(pr>=0 && nc<n){
            if(board[pr][nc]==1){
                return false;
            }
            pr--;
            nc++;;
        }


       return true;


    }

    void solve(int row,int n,int[][] board,List<List<String>>ans){
        if(row==n){
            addSequence(board,ans);
            return;
        }

        for(int i=0;i<n;i++){
            if(verticalCheck(row,i,board,n)==true && diagonalCheck(row,i,board,n)==true){
                board[row][i] = 1;
                solve(row+1,n,board,ans);
                board[row][i] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];

         for(int[] row : board){
            
             Arrays.fill(row,0);
             
         }

       List<List<String>>ans = new ArrayList<>();

       solve(0,n,board,ans);

       return ans;
    }
}