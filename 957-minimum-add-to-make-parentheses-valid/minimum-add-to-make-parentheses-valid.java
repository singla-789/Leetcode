class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans =0;
        for(char a : s.toCharArray()){
            if(st.isEmpty()){
                st.push(a);
                ans++;
            }
            else if(st.peek()=='(' && a==')'){
                st.pop();
                ans--;
            }
            else{
                st.push(a);
                ans++;
            }
        }

        return ans;
    }
}