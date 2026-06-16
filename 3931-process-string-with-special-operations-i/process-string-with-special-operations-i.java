class Solution {
    public String processStr(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();

        for(int i =0 ;i<n;i++){
            char a = s.charAt(i);

            if(a=='*'){
                if(!res.isEmpty()) res.deleteCharAt(res.length()-1);
            }else if(a=='#'){
                res.append(res);
            }else if(a=='%'){
                res.reverse();
            }else{
                res.append(a);
            }
        }

        return res.toString();
    }
}