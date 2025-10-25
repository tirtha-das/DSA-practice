class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // long maxi = (long)(num)*9;
        // if(maxi<(long)sum){
        //     return new String();
        // }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<num;i++){
            int cur = Math.min(9,sum);
            sum -= cur;
            char ch = (char)('0'+cur);
            sb.append(ch);
        }

        if(sum!=0){
            return new String();
        }

        return sb.toString();
    }
}