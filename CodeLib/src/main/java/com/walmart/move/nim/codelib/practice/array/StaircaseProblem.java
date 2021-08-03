package com.walmart.move.nim.codelib.practice.array;

public class StaircaseProblem {
    public static void main(String[] args) {

    }

    public static int numWaysRec(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }
        return numWaysRec(steps - 1) + numWaysRec(steps - 2) + numWaysRec(steps - 3);
    }

    public static int numWaysMemo(int steps) {
        return numWaysMemoImpl(steps, new int[steps + 1]);
    }

    private static int numWaysMemoImpl(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }
        if (memo[steps] == 0) {
            memo[steps] = numWaysMemoImpl(steps - 1, memo) + numWaysMemoImpl(steps - 2, memo) + numWaysMemoImpl(steps - 3, memo);
        }
        return memo[steps];
    }
}
