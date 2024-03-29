//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting{
    int start;
    int end;
    Meeting(int a,int b){
        this.start = a;
        this.end = b;
    }
}

class Solution
{
    //Function to find the maximum number of meetings that can
    //be performed by a single person.
    public static int maxMeetings(int start[], int end[], int n)
    {
        Meeting[] meetings = new Meeting[n];
        for(int i=0;i<n;i++){
            meetings[i] = new Meeting(start[i],end[i]);
        }
        Arrays.sort(meetings,(x,y)->x.end-y.end);
        int count = 0;
        int lastDone = 0;
        for(int i=0;i<n;i++){
            if(meetings[i].start > lastDone){
                count++;
                lastDone = meetings[i].end;
            }
        }
        return count++;
    }
}


