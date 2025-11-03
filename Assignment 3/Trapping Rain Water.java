public class Solution {
    public static long getTrappedWater(long []arr, int n) {
        // Write your code here.
        // int n = arr.length;
         if(n<3) return 0;
        int i = 0;
        int j = n-1;

        long ans = 0;
        long lmax = arr[0];
        long rmax = arr[n-1];

         while(i<j){
             if(arr[i]<=arr[j]){
               if(arr[i]<lmax){
                ans += (lmax-arr[i]);
               }else{
                lmax = arr[i];
               }
               i++;
             }else{
                if(arr[j]<rmax){
                    ans+= (rmax - arr[j]);
                }else{
                    rmax = arr[j];
                }
                j--;
             }
         }

         return ans;
    }
}