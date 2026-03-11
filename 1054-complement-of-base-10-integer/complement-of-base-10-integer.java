class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        String c = "";
        for(char a : s.toCharArray()){
            c = c + (a == '0'? '1': '0');
        }
        return Integer.parseInt(c,2);
    }
}