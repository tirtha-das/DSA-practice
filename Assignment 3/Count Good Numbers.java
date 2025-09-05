class Solution {
     long MOD = (long)(1e9+7);

     long cal(long val,long pow){
        if(pow==0){
            return 1;
        }

        long half = cal(val,pow/2);
        long res = ((half%MOD)*(half%MOD))%MOD;
        if(pow%2==1){
            res *= val;
            res%=MOD;
        }

        return res;
     }

    public int countGoodNumbers(long n) {
        long pow1 = n/2;
        

        long pow2 = pow1;
        if(n%2==1) pow1++;

        long ans1 = cal(5,pow1);
        long ans2 = cal(4,pow2);

        long ans = ((ans1%MOD)*(ans2%MOD))%MOD;

        return (int) ans;
        

    }
}