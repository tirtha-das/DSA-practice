class Solution {
    public int maxPartitionFactor(int[][] points) {
        int n = points.length;
        
        if(n==2){
            return 0;
        }

        long low = 0,high = (long)(4e9);

        long ans = 0;
        while(low<=high){
            // System.out.println(low+" "+high);
            long mid = (high+low)/2;

            if(isPossible(points,mid)){
                ans = mid;
                low = mid+1;
                //System.out.println(low);
               // System.out.println("done done");
            }else{
                high = mid-1;
            }

           // System.out.println("In the while");
        }

        return (int)ans;
    }

    boolean isPossible(int[][] points,long maxDist){
       // System.out.println("hi");
        int n = points.length;
        List<Integer>[] adjList = new List[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(calDist(points[i],points[j])<maxDist){
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }


        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(!dfs(i,1,adjList,vis)){
                    return false;
                }
               // System.out.println("done");
            }
        }

        return true;

        
    }

    boolean dfs(int node,int color, List<Integer>[] adjList,int[] vis){
       // System.out.println("hello");
        vis[node] = color;
        int nextColor = (color==1? 2: 1);
        
        for(int next : adjList[node]){
            if(vis[next]==0){
                if(!dfs(next,nextColor,adjList,vis)){
                    return false;
                }
            }else if(vis[next]!=nextColor){
                return false;
            }
        }

        return true;
    }

    long calDist(int[] first,int[] second){
        long dist = Math.abs(first[0]-second[0]);
        dist += Math.abs(first[1]-second[1]);

        return dist;
    }
}