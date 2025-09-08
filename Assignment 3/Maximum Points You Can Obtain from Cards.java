class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leave = n-k;
        int left = 0;
        int sum = 0;
        int sum2 = 0;
        int ans = Integer.MAX_VALUE;
        for(int right = 0;right<n;right++){
          sum+=cardPoints[right];
          sum2+=cardPoints[right];

          if(right-left==leave-1){
            ans = Math.min(ans,sum2);
            sum2 -= cardPoints[left];
            left++;
          }
        }
        if(leave==0){
            return sum;
        }
        return sum-ans;
    }
}