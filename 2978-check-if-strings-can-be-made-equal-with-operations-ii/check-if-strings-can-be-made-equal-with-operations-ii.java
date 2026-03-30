class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();

        HashMap<Character, Integer> even1 = new HashMap<>();
        HashMap<Character, Integer> odd1 = new HashMap<>();
        HashMap<Character, Integer> even2 = new HashMap<>();
        HashMap<Character, Integer> odd2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if (i % 2 == 0) {
                even1.put(a, even1.getOrDefault(a, 0) + 1);
                even2.put(b, even2.getOrDefault(b, 0) + 1);
            } else {
                odd1.put(a, odd1.getOrDefault(a, 0) + 1);
                odd2.put(b, odd2.getOrDefault(b, 0) + 1);
            }
        }

        return even1.equals(even2) && odd1.equals(odd2);
    }
}