package com.akshay.ds.practise.codelib.practice.array;

public class MaxSubArrayToaSum {
    // input nums = [2,3,4,5,0,0,7,7,9], sum = 14 result = [0,5]
    public static int[] getLongestSubArray(int[] nums, int s) {
        int left = 0;
        int right = 0;
        int[] result = new int[]{-1};
        int length = nums.length;
        int sum = 0;
        while (right < length) {
            sum += nums[right];
            while (left < right && sum > s) {
                sum -= nums[left++];
            }
            if (sum == s && (length == 1 || result[1] - result[0] < right - left)) {
                result = new int[]{left + 1, right + 1};
            }
            right++;
        }
        return result;
    }
}
