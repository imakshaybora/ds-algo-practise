package com.walmart.move.nim.codelib.practice.array;

public class CheckPallindrome {
    public static boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int front = 0;
        int back = charArr.length - 1;
        boolean isPallindrome = false;
        while (front != back) {
            int asciiCharFront = (int) charArr[front];
            int asciiCharBack = (int) charArr[back];
            if (isChararterNotAlphabet(asciiCharFront)) {
                front++;
            }
            if (isChararterNotAlphabet(asciiCharBack)) {
                back--;
            }
            if (Character.toLowerCase(charArr[front]) == Character.toLowerCase(charArr[back])) {
                isPallindrome = true;
                front++;
                back--;
            } else {
                isPallindrome = false;
                break;
            }

        }
        return isPallindrome;
    }

    public static boolean isChararterNotAlphabet(int ch) {
        return (ch < 65 || ch > 90) && (ch < 97 || ch > 122);
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input));
    }
}