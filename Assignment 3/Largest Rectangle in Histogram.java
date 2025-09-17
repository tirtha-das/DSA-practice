class Solution {
    void update(int[] nums,int[] ans,int n,int start,int dif){
       int cnt = 0;
        //int start = 0;
        Stack<Integer>st = new Stack<>();
        while(cnt<n){
            //System.out.print(val+" ");
          while(st.size()>0 && nums[st.peek()]>nums[start]){
            ans[st.pop()] = start;
          }
          st.push(start);
          start+=dif;
          cnt++;
        }

        // for(int val:ans){
        //     System.out.print(val+" ");
        // }
        //  System.out.println();
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        Arrays.fill(nextSmaller,n);
        Arrays.fill(prevSmaller,-1);

        update(heights,nextSmaller,n,0,1);
        update(heights,prevSmaller,n,n-1,-1);

         int best  = 0;

         for(int i=0;i<n;i++){
           int l = prevSmaller[i]+1;
           int r = nextSmaller[i]-1;
           int area = (r-l+1)*heights[i];
           best = Math.max(best,area);
         }

       return best;
    }
}