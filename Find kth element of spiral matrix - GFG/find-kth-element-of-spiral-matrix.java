//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int arr[][], int rows, int cols, int k)
    {
        // k--;
        int cnt=0;
        for(int i=0;i<=(rows-1)/2;i++)
        {
            if(cnt==rows*cols)break;
            for(int j=i;j<cols-i;j++)
            {
                k--;
                if(k==0)return arr[i][j];
                cnt++;
            }
            if(cnt==rows*cols)break;
            for(int j=i+1;j<rows-i;j++)
            {
                k--;
                if(k==0)return (arr[j][cols-i-1]);
                cnt++;
            }
            if(cnt==rows*cols)break;
            for(int j=cols-i-2;j>=i;j--)
            {
                k--;
                if(k==0)return (arr[rows-i-1][j]);
                cnt++;
            }
            if(cnt==rows*cols)break;
            for(int j=rows-i-2;j>i;j--)
            {
                k--;
                if(k==0)return (arr[j][i]);
                cnt++;
            }
        }
        return -1;
    }
}