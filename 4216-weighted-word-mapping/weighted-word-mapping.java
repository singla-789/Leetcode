class Solution {
    public String mapWordWeights(String[] words, int[] wg) {
        StringBuilder ans = new StringBuilder();
        for(String str : words){
            int sc = 0;
            for(char a  : str.toCharArray()){
                sc += wg[a-'a'];
            }
            int num = 26-(sc%26);
            ans.append((char)('a'+num-1));
        }
        return ans.toString();
    }
}