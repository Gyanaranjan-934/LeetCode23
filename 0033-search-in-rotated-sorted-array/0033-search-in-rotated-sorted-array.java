class Solution {
    public int search(int[] arr, int key) {
        int low = 0,high=arr.length-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(arr[mid]==key)return mid;
            // check if left part is sorted if it is not, then it's obvious right is sorted
            if(arr[low]<=arr[mid]){
                if(arr[low]<=key && key<arr[mid]) //check if the key present in sorted part or not
                    high = mid-1;
                else low = mid+1; // if it is not then go for unsorted part
            }
            else{
                if(arr[mid]<key && key<=arr[high])low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}