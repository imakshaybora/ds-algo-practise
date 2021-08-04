package com.akshay.ds.practise.codelib.practice.array;

public class PascalTriangleNthRow {
    static void generateNthrow(int N)
    {

        // nC0 = 1
        int prev = 1;
        System.out.print(prev);

        for(int i = 1; i <= N; i++)
        {
            // nCr = (nCr-1 * (n - r + 1))/r
            int curr = (prev * (N - i + 1)) / i;
            System.out.print(", " + curr);
            prev = curr;
        }
    }

    public static void main(String[] args) {
        generateNthrow(5);
    }
}
