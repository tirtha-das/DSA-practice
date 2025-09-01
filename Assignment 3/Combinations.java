class Solution {
     void solve(int idx,int n,int k,List<Integer>res,List<List<Integer>>ans,int prev){
        if(idx==k){
            ans.add(res);
            return;
        }

        

        
        for(int i=prev+1;i<=n;i++){
            
              List<Integer> newres = new ArrayList<>();
        for(int val:res){
                newres.add(val);
            }

            newres.add(i);
              
              solve(idx+1,n,k,newres,ans,i);
            
        }


     }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans =  new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        // for(int i=0;i<k;i++){
        //     res.add(0);
        // }

        solve(0,n,k,res,ans,0);

        return ans;
    }
}