//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for(int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


class Solution
{
    int countLcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) dp[i][j] = 0;
                else if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }

    Set<String> st = new HashSet<>();

    void helper(String s, String t, int i, int j, StringBuilder temp, List<String> ans, int count) {
        if(count == 0) {
            if(!st.contains(temp.toString())) {
                st.add(temp.toString());
                ans.add(temp.toString());
            }
            return;
        }
        if(i >= s.length() || j >= t.length()) return;

        for(int r=i; r<s.length(); r++) {
            for(int c=j; c<t.length(); c++) {
                if(s.charAt(r) == t.charAt(c)) {
                    temp.append(s.charAt(r));
                    helper(s, t, r+1, c+1, temp, ans, count-1);
                    temp.deleteCharAt(temp.length()-1);
                }
            }
        }
    }

    public List<String> all_longest_common_subsequences(String s, String t) {
        int a = countLcs(s, t);
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        helper(s, t, 0, 0, temp, ans, a);
        Collections.sort(ans);
        return ans;
    }
}
