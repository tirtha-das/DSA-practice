class Solution {
    private boolean isValid(int mid, int[] tasks, int[]workers, int pills, int strength){
        if(mid == 0){
            return true;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int[] newTasks = new int[mid];
        int[] newWorkers = new int[mid];

        for(int i = 0; i < mid; i++){
            newTasks[i] = tasks[i];
            newWorkers[i] = workers[i];
        }

        for(int task : newTasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int count = 0;
        int usedPills = 0;

        for(int i = newTasks.length - 1; i >= 0; i--){
            Map.Entry<Integer, Integer> entry = map.lowerEntry(newWorkers[i] + 1);

            if(entry != null){
                count += 1;
                int key = entry.getKey();
                if(map.get(key)==1){
                    map.remove(key);
                }
                else {
                    map.put(key,map.get(key)- 1);
                }
             }
            else if(usedPills < pills){
                    usedPills += 1;
                    entry = map.lowerEntry(newWorkers[i]+strength + 1);

                    if(entry != null){
                        count += 1;
                       int key = entry.getKey();
                        if(map.get(key)==1){
                           map.remove(key);
                        }
                        else {
                            map.put(key,map.get(key)- 1);
                        }
                       }
                    else{
                        return false;
                    }
                }
            else{
                    return false;
                }
                
            }
        

        return true;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        // Observation: on maintaining the given tasks and workers order;
        // [0 => 3, 3 => 2, 3 => 1]
        // 1 => 3 => 0

        // tasks workers pills strength
        // tasks = [3, 2, 1]
        // workers = [0, 3, 3]
        // pills = 1
        // strength = 1
        // output => 3

        // [1, 2, 3]
        // [0, 3, 3]
        // used pill 0
        // worker 0 => 1
        // tasks done => 0indexed, 1indexed, 2indexed;

        // tasks = [4, 5]
        // workers = [0, 0, 0]
        // used pill 0 if pill becomes == 0 and worker[i] < tasks[i] break
        // worker 0 => 5
        // tasks done => 0indexed;

        // tasks = [10, 15, 30]
        // workers = [0, 10, 10, 10, 10]
        // used pill 1(2) 2(1), 3(0)
        // worker 0 => 10 & 10 => 20 & 10 => 20
        // tasks done => 0indexed, 1indexed

        // [5, 5, 8]
        // [4, 6, 6]
        // pill = 0 (strength = 4)
        // worker 4 => 8
        // tasks done => 0indexed, 1indexed
        // workers [4, 6, 6] => 8, 10, 10
        // 8 10 10 (10 - 4)
        // 8 5 5
        // counter => 1
        // tasks => 0


        // Binary Search on Ans:

        // low = 0
        // high = n

        // mid = 

        Arrays.sort(tasks);

        // Sort descending
        Arrays.sort(workers);

        // Reverse manually
        for (int i = 0, j = workers.length - 1; i < j; i++, j--) {
            int temp = workers[i];
            workers[i] = workers[j];
            workers[j] = temp;
        }

        int n = tasks.length;
        int low = 0;
        int high = Math.min(tasks.length,workers.length);
        int limit = high;

        int maxTasks = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isValid(mid, tasks, workers, pills, strength)){
                maxTasks = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
         
        return maxTasks; 
    }
}