package io.euler.project;

/**
 * This is project_euler_100. Good Luck!
 */
//TASK 3
public class LargestPrimeFactor {

    public static void main(String[] args) {

        long mber = 600_851_475_143l;
        while (true) {
            long primeFactor = getPrimeFactor(mber);
            mber = mber / primeFactor;
            System.out.println(primeFactor);
            if (mber == primeFactor) break;
        }

    }

    private static long getPrimeFactor(long number) {
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                return i;
            }
        }

        return number;
    }
}
