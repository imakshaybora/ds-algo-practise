package com.akshay.ds.practise.codelib.practice.array;

public class MaxSumNoTwoAdjacentTogether {
    public static int maxSumNoTwoAdjacent(int n, int[] arr) {
        if (arr.length <= 0) {
            return -1;
        }

        int incl = arr[0];
        int excl = 0;
        for (int i = 0; i <= n - 1; i++) {
            int temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        return incl;
    }
}
