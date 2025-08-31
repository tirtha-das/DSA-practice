// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        // Complete the function
        
        int cnt = 0;
        for(int val:arr){
            if(val<=k){
                cnt++;
            }
        }
        
        if(cnt==0) return 0;
        
        int ans = arr.length;
        int bad = 0,left=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>k) bad++;
            
            if(i-left+1==cnt){
                ans = Math.min(ans,bad);
                if(arr[left]>k) bad--;
                left++;
            }
        }
        
        return ans;
    }
}
