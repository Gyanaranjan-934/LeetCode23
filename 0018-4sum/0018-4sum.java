class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        if (nums.length < 4) {
            return res;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                long tar = (long) target - (nums[i] + nums[j]);  // Change the variable type to long
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    long sum = (long) nums[low] + nums[high];  // Change the variable type to long
                    if (sum == tar) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        set.add(temp);
                        low++;
                        high--;
                    } else if (sum < tar) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }
}
