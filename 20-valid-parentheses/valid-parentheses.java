class Solution {
    public boolean isValid(String S) {
        Stack<Character> s = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        for(char a : S.toCharArray()){
            if(a=='{' || a=='[' || a=='('){
                s.push(a);
            }else{
                if(s.isEmpty()) return false;
                if(s.peek()==map.get(a)) s.pop();
                else return false;
            }
        }

        return s.isEmpty() ? true : false ;
    }
}