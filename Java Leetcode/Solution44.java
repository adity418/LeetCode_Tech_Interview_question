//  44. WildCard Matching

class Solution44 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // Initialize dp array for dp[i+1] row (dp_ip1) with True for the last cell and handle '*' at the end
        boolean[] dp_ip1 = new boolean[n + 1];
        dp_ip1[n] = true;  // dp_ip1[n] corresponds to the base case of matching empty strings

        // Fill dp_ip1 for the last row where s is empty but p might contain '*'
        for (int j = n - 1; j >= 0; j--) {
            dp_ip1[j] = p.charAt(j) == '*' && dp_ip1[j + 1];
        }

        // Bottom-up DP approach
        for (int i = m - 1; i >= 0; i--) {
            boolean[] dp_i = new boolean[n + 1];
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp_i[j] = dp_ip1[j + 1];
                } else if (p.charAt(j) == '*') {
                    dp_i[j] = dp_ip1[j] || dp_i[j + 1];
                } else {
                    dp_i[j] = false;
                }
            }
            dp_ip1 = dp_i;  // Move to the next row
        }
        
        return dp_ip1[0];
    }
}
