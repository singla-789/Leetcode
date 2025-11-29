class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char a = s.charAt(i);
            if(st.isEmpty()){
                st.push(a);
                continue;
            }
            if(st.peek()=='(' && a == ')'){
                st.pop();
                continue;
            }
            st.push(a);
        }

        return st.size();
    }
}