//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends
class Pair{
    String word;
    int dist;
    Pair(String s,int d){
        this.word = s;
        this.dist = d;
    }
}

class Solution {
    public int wordLadderLength(String beginWord, String endWord, String[] wordList) {

        HashSet<String> set = new HashSet<>();
        for(String s : wordList)set.add(s);

        if(set.contains(beginWord))set.remove(beginWord);

        // Applying BFS
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().dist;
            q.remove();
            if(word.equals(endWord))return steps;            
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }

        }

        return 0;

    }
}