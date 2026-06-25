class Solution {
    public String countAndSay(int n) {
        String cas = "1";
        for (int i = 2; i <= n; i++) {
            cas = help(cas);
        }
        return cas;
    }

    class pair {
        int val;
        int count;

        pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public String help(String s) {
        int n = s.length();

        List<pair> l = new ArrayList<>();

        int pre = s.charAt(0) - '0';
        l.add(new pair(pre, 1));

        for (int i = 1; i < n; i++) {
            int curr = s.charAt(i) - '0';

            if (curr == pre) {
                l.get(l.size() - 1).count++;
            } else {
                pre = curr;
                l.add(new pair(curr, 1));
            }
        }

        return create(l);
    }

    public String create(List<pair> l) {
        StringBuilder ans = new StringBuilder();
        for (pair p : l) {
            ans.append(Integer.toString(p.count));
            ans.append(Integer.toString(p.val));
        }
        return ans.toString();
    }
}