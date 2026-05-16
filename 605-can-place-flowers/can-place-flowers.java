class Solution {
    public boolean canPlaceFlowers(int[] flo, int m) {
        int n = flo.length;
        for(int i =0;i<n;i++){
            boolean l = i==0 || flo[i-1]==0;
            boolean r = i==n-1 || flo[i+1] == 0;

            if(l && r && flo[i]==0){
                m--;
                flo[i]=1;
            }
            
        }

        return m<=0;
    }
}