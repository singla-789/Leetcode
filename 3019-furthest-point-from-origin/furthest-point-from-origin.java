class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lc = 0;
        int rc = 0;
        int bc = 0;

        for(char a : moves.toCharArray()){
            if(a=='L') lc++;
            else if(a=='R') rc++;
            else bc++;
        }

        return Math.max(lc,rc)+bc-Math.min(rc,lc);
    }
}