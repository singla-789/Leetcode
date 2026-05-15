class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = help(s);
        Stack<Character> s2 = help(t);

        if(s1.size()!=s2.size()){
            return false;
        }

        while(!s1.isEmpty()){
            if(s1.pop() != s2.pop()){
                return false;
            }
        }

        return true;
    }

    public Stack<Character> help(String str){
        Stack<Character> s = new Stack<>();

        for(char a : str.toCharArray()){
            if(a == '#'){
                if(!s.isEmpty()) s.pop();
            }
            else{
                s.push(a);
            }
        }

        return s;
    }
}