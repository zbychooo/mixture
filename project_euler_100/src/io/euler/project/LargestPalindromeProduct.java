package io.euler.project;

/**
 * This is project_euler_100. Good Luck!
 */
// TASK 4
public class LargestPalindromeProduct {

    public static void main(String[] args) {

        int maxPalindrome = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                int result = i * j;
                if (isPalindrome(result) && (maxPalindrome < result)) {
                    maxPalindrome = result;
                }
            }
        }

        System.out.println(maxPalindrome);
    }

    private static boolean isPalindrome(int number) {

        String numberString = String.valueOf(number);

        for (int i = 0; i < Math.floor(numberString.length() / 2); i++) {
            if (numberString.charAt(i) != numberString.charAt(numberString.length() - i - 1)) return false;
        }
        return true;
    }

}
