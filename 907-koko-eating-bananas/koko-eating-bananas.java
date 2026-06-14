class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int l =1;
        int r = Integer.MIN_VALUE;
        for(int a: piles){
            r = Math.max(r,a);
            
        }

        while(l<r){
            int m = l +(r-l)/2;

            if(help(m,piles,h)){
                r = m;
            }else{
                l = m+1;
            }
        }

        return l;

    }

    public boolean help(int m,int[] arr,int h){
        int t = 0;

        for(int a : arr){
            t += (a+m-1)/m;
        }

        return h>=t;
    }
}