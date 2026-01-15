class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int len = Math.min(help(hBars),help(vBars));


        return len * len;
    }

    public int help(int[] arr){
        int ans = 2;
        int temp=2;

        for(int i = 1;i<arr.length;i++){
            if(arr[i] - arr[i-1] == 1) temp++;
            else temp =2;

            ans = Math.max(ans,temp);

        }

        return ans;
    }
}