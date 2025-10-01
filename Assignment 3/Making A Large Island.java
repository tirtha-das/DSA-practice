class DSU{
    int[] parent;
    int[] noOfNodes;

    public DSU(int n){
        parent = new int[n];
        noOfNodes = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            noOfNodes[i] = 1;
        }
    }

    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    public void unionByCount(int child1,int child2){
        int p1 = findParent(child1);
        int p2 = findParent(child2);

        if(p1!=p2){
            if(noOfNodes[p1]>=noOfNodes[p2]){
                parent[p2] = p1;
                noOfNodes[p1] += noOfNodes[p2];
            }else{
                parent[p1] = p2;
                noOfNodes[p2] += noOfNodes[p1];
            }
        }
    }

    public int countSize(int node){
       return noOfNodes[node];
    }
}


class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sz = n*m;
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,-1,0,1};

        DSU ds = new DSU(sz);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                int cell = (i*m)+j;
                
                for(int k = 0;k<4;k++){
                    int nr = dr[k]+i;
                    int nc = dc[k]+j;
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                               int next = (nr*m)+nc;
                               ds.unionByCount(next,cell);
                    }
                  }
                }
            }
        }

        int ans = ds.countSize(ds.findParent(0));

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                int cell = (i*m)+j;
                Set<Integer>set = new HashSet<>();
                for(int k = 0;k<4;k++){
                    int nr = dr[k]+i;
                    int nc = dc[k]+j;
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                               int next = (nr*m)+nc;
                              set.add(ds.findParent(next));
                    }
                  }
                  int res = 0;
                  //System.out.println("index "+i+" "+j);
                  for(int p : set){
                   // System.out.println(p);
                     res += ds.countSize(p);
                  }

                  ans = Math.max(ans,res+1);
                }
            }
        }

        return ans;





    }
}