class Solution {
    public int earliestTime(int[][] tasks) {
        int sum=100000;
        for(int i=0;i<tasks.length;i++){
            sum = Math.min(sum,tasks[i][0]+tasks[i][1]);
        }

        return sum;
    }
}