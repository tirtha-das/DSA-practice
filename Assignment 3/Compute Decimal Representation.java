class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer>digits = new ArrayList<>();

        int temp=n;

        while(temp>0){
            digits.add(temp%10);
            temp/=10;
        }

         Collections.reverse(digits);
         int sz = digits.size();
        int cnt=0;
         for(int i=0;i<digits.size();i++){
             if(digits.get(i)>0){
                 int mul = (int)Math.pow(10,sz-(i+1));
                 int val = digits.get(i)*mul;
                 digits.set(i,val);
                 cnt++;
             }
         }

        int[] ans = new int[cnt];
        int idx = 0;
        for(int i=0;i<digits.size();i++){
            if(digits.get(i)!=0){
                ans[idx] = digits.get(i);
                idx++;
            }
        }
        return ans;
    }
}