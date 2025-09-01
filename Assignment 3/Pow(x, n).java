class Solution {
     double solve(double base,long power){
        if(power==0) return (double)1;
      

        double res  = solve(base,power/2);

        res*=res;

        if(power%2==1){
            res*=base;
        }
       // System.out.println(res);
        return res;
     }

    public double myPow(double x, int n) {

        //System.out.println(Math.abs(n));
        double ans = solve(x,Math.abs((long)n));


       // System.out.println(ans);

        if(n<0){
            ans = ((double)1)/ans;
        }

        return ans;
    }
}