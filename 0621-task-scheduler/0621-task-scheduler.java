class Pair{
    int task;
    int time;
    Pair(int a,int b){
        this.task = a;
        this.time = b;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for(char c:tasks){
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq,freq[c-'A']);
        }
        // PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        // for(int i:freq){
        //     if(i!=0)pq.add(i);
        // }
        // Queue<Pair> q = new LinkedList<>();
        // int time = 0;
        // while(!pq.isEmpty() || !q.isEmpty()){
        //     if(!q.isEmpty() && time==q.peek().time)pq.add(q.poll().task);
        //     int task=0;
        //     if(!pq.isEmpty())task = pq.poll();
        //     time++;
        //     if(task>1)
        //         q.add(new Pair(task-1,time+n));
        // }
        // return time;
        int maxFreqCnt = 0;
        for(int i:freq)if(i==maxFreq)maxFreqCnt++;

        int time = (maxFreq-1)*(n+1)+maxFreqCnt;
        return Math.max(time,tasks.length);
    }
}