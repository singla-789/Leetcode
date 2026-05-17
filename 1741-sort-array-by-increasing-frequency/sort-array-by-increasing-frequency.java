class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int n = nums.length;
        Integer arr[] = new Integer[n];

        for(int i =0;i<n;i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr,(a,b) -> {

            int fa = map.get(a);
            int fb = map.get(b);

            if(fa!=fb) return fa-fb;

            return b-a;
        });


        for(int i =0;i<n;i++){
            nums[i] = arr[i];
        }

        return nums;





    }
}