class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i =0;i<n-1;i++){
            min = Math.min(arr[i+1]-arr[i],min);
        }

        List<List<Integer>> list = new ArrayList<>();

        for(int i =0;i<n-1;i++){
            if(arr[i+1]-arr[i] == min){
                list.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }

        return list;


    }
}