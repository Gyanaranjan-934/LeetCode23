class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Boolean> map = new HashMap<>();
        int cnt=0;
        int m=arr.length;
        int n=arr[0].length;
        for(int i=0;i<=(arr.length-1)/2;i++)
        {
            if(cnt==m*n)break;
            for(int j=i;j<arr[i].length-i;j++)
            {
                list.add(arr[i][j]);
                cnt++;
            }
            if(cnt==m*n)break;
            for(int j=i+1;j<arr.length-i;j++)
            {
                list.add(arr[j][arr[i].length-i-1]);
                cnt++;
            }
            if(cnt==m*n)break;
            for(int j=arr[i].length-i-2;j>=i;j--)
            {
                list.add(arr[arr.length-i-1][j]);
                cnt++;
            }
            if(cnt==m*n)break;
            for(int j=arr.length-i-2;j>i;j--)
            {
                list.add(arr[j][i]);
                cnt++;
            }
        }
        return list;
    }
}