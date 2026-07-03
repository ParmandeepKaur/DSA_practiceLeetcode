class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp1 = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp1[i][j] = dp1[i - 1][j - 1] + 1;
                } else {
                    dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i][j - 1]);
                }
            }
        }

        int[][] dp2 = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp2[i][j] = dp2[i + 1][j + 1] + 1;
                } else {
                    dp2[i][j] = Math.max(dp2[i + 1][j], dp2[i][j + 1]);
                }
            }
        }

        int lcs = dp1[n][m];
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            boolean[] used = new boolean[26];

            for (int j = 0; j < m; j++) {
                int ch = s2.charAt(j) - 'a';

                if (!used[ch] && dp1[i][j] + dp2[i][j + 1] == lcs) {
                    ans++;
                    used[ch] = true;
                }
            }
        }

        return ans;
    }
}