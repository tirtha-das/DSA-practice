class Solution {
    public void rearrange(int arr[]) {
        // code here
        Arrays.sort(arr);
         int n = arr.length;
        int maxIdx = n - 1;
        int minIdx = 0;

       
        int maxElem = arr[n - 1] + 1;

       for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx--;
            } else {
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }

        // Decode new values
        for (int i = 0; i < n; i++) {
            arr[i] /= maxElem;
        }
        
    }
}
