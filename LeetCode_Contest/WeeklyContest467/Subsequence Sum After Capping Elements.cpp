class Solution {
public:
     void set(int idx,vector<bool>&res,int n){
         for(;idx<=n;idx++){
             res[idx-1]=true;
         }
     }
    
      vector<vector<int>> getTable(vector<int>& nums, int k){
        int n = nums.size();
         sort(nums.begin(),nums.end());
         reverse(nums.begin(),nums.end());       
         vector<vector<int>>dp(n+1,vector<int>(k+1,0));

        for(int i=0;i<n+1;i++){
           dp[i][0] = 1; 
        }


        for(int idx = n-1;idx>=0;idx--){
            for(int tar = 1;tar<=k;tar++){
                 int np = dp[idx+1][tar];
                 int p =0;
                if(tar>=nums[idx]){
                    p = dp[idx+1][tar-nums[idx]];
                }



         
         if(np==1 || p==1) dp[idx][tar] =1;
            }
        }
         return dp;
     }
    
   
    
    vector<bool> subsequenceSumAfterCapping(vector<int>& nums, int k) {
        int n = nums.size();
         vector<bool> res(n,false);

        vector<vector<int>>dp=getTable(nums,k);
       vector<int>seen(k+1,0);

        seen[0] = 1;
        int small = n-1;
        for(int i=1;i<=n;i++){
            
           while(small>=0 && nums[small]<i){
               for(int j=0;j<=k;j++){
                   if(dp[small][j]==1){
                      seen[j]=1;
                       if(j==k){
                         set(i,res,n);
                           return res;
                       }
                   }
               }
               small--;
               
           }
        

          int cnt = 0;
          for(int l=0;l<=small;l++){
             cnt+=i;
              if(k-cnt>=0 && seen[k-cnt]==1){
                  res[i-1] = true;
                  break;
              }

              if(k<cnt){
                  break;
              }
          }
        }
       
       
        
        return res;
    }
};