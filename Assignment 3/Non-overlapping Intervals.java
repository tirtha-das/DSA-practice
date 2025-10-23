
class Solution {
  

    public int eraseOverlapIntervals(int[][] intervals) {
        

        Comparator<int[]>comp = (p1,p2)->{
           
                return Integer.compare(p1[1],p2[1]);
            

           
        };

        Arrays.sort(intervals,comp);

       int n = intervals.length;
       int ans = 1;
       int limit  = intervals[0][1];

        for(int i=1;i<n;i++){
           if(intervals[i][0]>=limit){
            ans++;
            limit = intervals[i][1];
           }
        }

        return n-ans;


    }
}