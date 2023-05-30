class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i+1)continue;
            else{
                while(arr[arr[i]-1]!=arr[i]){
                    int a=arr[i]-1;
                    int b=i; 
                    int temp=arr[a];
                    arr[a]=arr[b];
                    arr[b]=temp;
                }
            }
        }
        for(int i=0;i<n;i++)
            if(arr[i]!=i+1)res.add(arr[i]);
        
        return res;
    }
}