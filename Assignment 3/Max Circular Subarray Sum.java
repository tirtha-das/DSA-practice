class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int mini = Integer.MAX_VALUE;
        int sum = 0;
        int cnt = 0;
       
        int maxi = (int)(-1e5);
        int minisum = 0; 
        
        int maxsum = 0;
        int res = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(arr[i]>0){
             cnt++;
            }
            
            minisum+=(arr[i]);
            mini = Math.min(mini,minisum);
            if(minisum>0) minisum = 0;
            
            maxi =Math.max(arr[i],maxi);
            
             maxsum+=(arr[i]);
            res = Math.max(res,maxsum);
            if(maxsum<0) maxsum = 0;
        }
        
        if(cnt==0) return maxi;
        
    
       // System.out.println(res);
        return Math.max(res,sum-mini);
        
    }
}
