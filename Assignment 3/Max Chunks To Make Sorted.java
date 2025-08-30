class Solution {
    public int maxChunksToSorted(int[] arr) {
      int ans = 0;
      int originalSum = 0;
      int desiredSum = 0;
      int start = 0;
      for(int val : arr){
         originalSum += val;
         desiredSum += start;

         if(originalSum==desiredSum) ans++;

         start++;
      }

      return ans;
    }
}