class Solution {
    public boolean canReach(int[] arr, int idx) {
        return help(arr,idx,new boolean[arr.length]);
    }

    public boolean help(int[] arr,int idx,boolean vis[]){

        if(idx<0 || idx>=arr.length) return false;
        if(vis[idx]) return false;
        if(arr[idx] == 0) return true;
        vis[idx] = true;
        return help(arr,idx-arr[idx],vis) || help(arr,idx+arr[idx],vis);
        
    }
}