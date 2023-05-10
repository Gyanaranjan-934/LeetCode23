//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String p, String s)
    {
        int[][] dp = new int[s.length()][p.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return recFunc(s.length()-1,p.length()-1,s,p,dp) ? 1 : 0;
    }
    public boolean isAllStars(String p,int j){
        for(int i=j;i>=0;i--){
            if(p.charAt(i)!='*')return false;
        }
        return true;
    }
    public boolean recFunc(int i,int j,String s, String p,int[][] dp){
        if(j<0 && i<0)return true;
        if(i>=0 && j<0)return false;
        if(i<0 && j>=0)return isAllStars(p,j);

        if(dp[i][j]!=-1)return dp[i][j]==1?true:false;

        if(s.charAt(i) == p.charAt(j) ||p.charAt(j) =='?'){
            boolean res = recFunc(i-1,j-1,s,p,dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }
        else{
            if(p.charAt(j) =='*'){
                boolean res = recFunc(i-1,j,s,p,dp)||recFunc(i,j-1,s,p,dp) ;
                dp[i][j] = res ? 1 : 0;
                return res;
            }
            else{
                dp[i][j] = 0;
                return false;
            }
        }
    }
}
