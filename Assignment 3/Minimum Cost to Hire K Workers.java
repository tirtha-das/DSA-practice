class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] options = new double[n][2];

        for(int i=0;i<n;i++){
            options[i][0] = quality[i];
            options[i][1] = ((double)wage[i])/quality[i];
        }

        Comparator<double[]> comp = (d1,d2)->{
            if(Double.compare(d1[1],d2[1])==0){
                return Double.compare(d1[0],d2[0]);
            }
            return Double.compare(d1[1],d2[1]);
        };



        Arrays.sort(options,comp);

        // for(double[] cur : options){
        //     System.out.println(cur[0]+" "+cur[1]);
        // }

        PriorityQueue<Double>pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b,a);
        });

        double sum = 0;
        double ans = Double.MAX_VALUE;
        for(int i=0;i<n;i++){
              sum += options[i][0];
              pq.add(options[i][0]);
              if(pq.size()==k){
               double tempAns = (sum)*options[i][1];
               ans = Math.min(ans,tempAns);
               sum-=pq.poll();
              }
              
        }

        return ans;



    }
}