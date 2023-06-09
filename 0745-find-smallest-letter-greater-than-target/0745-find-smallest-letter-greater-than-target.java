class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int[] arr = new int[letters.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=letters[i]-'a';
        
        int tar = target-'a';
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=tar)low=mid+1;
            else high = mid-1;
        }
        if(low==arr.length)return letters[0];
        return letters[low];
    }
}