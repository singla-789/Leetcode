import java.util.*;

class Solution {
    Map<String, Integer> dp = new HashMap<>();

    public int minimumDistance(String word) {
        return solv(word, 0, -1, -1, -1, -1);
    }

    public int solv(String s, int i, int x1, int y1, int x2, int y2) {
        if (i == s.length()) return 0;

        String key = i + "," + x1 + "," + y1 + "," + x2 + "," + y2;
        if (dp.containsKey(key)) return dp.get(key);

        int[] cor = getPos(s.charAt(i));

        int res;

        if (x1 == -1 && x2 == -1) {
            res = solv(s, i + 1, cor[0], cor[1], x2, y2);
        } else if (x2 == -1) {
            int dis1 = dis(cor[0], cor[1], x1, y1) + solv(s, i + 1, cor[0], cor[1], x2, y2);
            int dis2 = solv(s, i + 1, x1, y1, cor[0], cor[1]);
            res = Math.min(dis1, dis2);
        } else {
            int dis1 = dis(cor[0], cor[1], x1, y1) + solv(s, i + 1, cor[0], cor[1], x2, y2);
            int dis2 = dis(cor[0], cor[1], x2, y2) + solv(s, i + 1, x1, y1, cor[0], cor[1]);
            res = Math.min(dis1, dis2);
        }

        dp.put(key, res);
        return res;
    }

    public int[] getPos(char a) {
        return new int[]{(a - 'A') / 6, (a - 'A') % 6};
    }

    public int dis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}