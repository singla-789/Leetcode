class Solution {
    public int minimumDeletions(String str) {
        Stack<Character> s = new Stack<>();
        int ans =0;
        for(char c : str.toCharArray()){
            if(c == 'b'){
                s.push(c);
            }
            else if( !s.isEmpty() && s.peek()=='b' && c == 'a'){
                s.pop();
                ans++;
            }
        }
        return ans;
    }
}