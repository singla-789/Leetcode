class Solution {
    ArrayList<String> list = new ArrayList<>();

    public void help(String s, int n) {
        if (n == 0) {
            list.add(s);
            return;
        }

        if (s.length() == 0 || s.charAt(s.length() - 1) != 'a') {
            help(s + "a", n - 1);
        }

        if (s.length() == 0 || s.charAt(s.length() - 1) != 'b') {
            help(s + "b", n - 1);
        }

        if (s.length() == 0 || s.charAt(s.length() - 1) != 'c') {
            help(s + "c", n - 1);
        }
    }

    public String getHappyString(int n, int k) {
        help("", n);

        Collections.sort(list);

        if (k > list.size()) return "";

        return list.get(k - 1);
    }
}