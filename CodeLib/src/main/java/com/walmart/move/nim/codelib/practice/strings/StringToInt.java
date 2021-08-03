package com.walmart.move.nim.codelib.practice.strings;

/*
 * Question:
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 * Read in and ignore any leading whitespace.
 *  Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 *  Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 *  Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 *   If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 *   Return the integer as the final result.
 * Note:
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 * */
public class StringToInt {
    public static int myAtoi(String s) {
        char[] charArr = s.toCharArray();
        int i = 0;
        int value = 0;
        boolean isPositive = true;
        StringBuilder str = new StringBuilder();
        while (i < charArr.length) {
            char item = charArr[i];
            if(Character.isAlphabetic(item) && str.length() == 0){
                return 0;
            }
            if (item == ' ' && str.length() == 0) {
                i++;
                continue;
            }
            if (Character.isDigit(item)|| item =='.') {
                str.append(item);
            }
            if (item == '-') {
                isPositive = false;
            }
            i++;
        }
        int resultNum = 0;
        try {
            resultNum = (int) Double.parseDouble(str.toString());
        } catch (NumberFormatException e) {
            if(isPositive){
                return (int) Math.pow(2, 31) - 1;
            } else {
                return (int) Math.pow(-2, 31);
            }
        }
        if (!isPositive) {
            resultNum = -resultNum;
        }

        if (resultNum < Math.pow(-2, 31)) {
            resultNum = (int) Math.pow(-2, 31);
        } else if (resultNum > Math.pow(2, 31) - 1) {
            resultNum = (int) Math.pow(2, 31) - 1;
        }
        return resultNum;
    }

    public static void main(String[] args) {
        String s ="-91283472332";
        System.out.println(myAtoi(s));
    }
}
