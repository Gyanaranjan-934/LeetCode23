from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        low = 0
        high = len(nums1)

        total_len = len(nums1) + len(nums2)
        half_len = (total_len + 1) // 2

        while low <= high:
            mid = (low + high) // 2

            l1 = mid - 1
            l2 = half_len - mid - 1
            r1 = l1 + 1
            r2 = l2 + 1

            max_left_nums1 = nums1[l1] if l1 >= 0 else float('-inf')
            min_right_nums1 = nums1[r1] if r1 < len(nums1) else float('inf')

            max_left_nums2 = nums2[l2] if l2 >= 0 else float('-inf')
            min_right_nums2 = nums2[r2] if r2 < len(nums2) else float('inf')

            if max_left_nums1 <= min_right_nums2 and max_left_nums2 <= min_right_nums1:
                if total_len % 2 == 0:
                    return (max(max_left_nums1, max_left_nums2) + min(min_right_nums1, min_right_nums2)) / 2
                else:
                    return max(max_left_nums1, max_left_nums2)

            elif max_left_nums1 > min_right_nums2:
                high = mid - 1
            else:
                low = mid + 1

        return -1
