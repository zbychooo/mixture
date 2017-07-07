package io.euler.project;

/**
 * This is project_euler_100. Good Luck!
 */
// task 11
public class HighlyDivisibleTriangularNumber {


    public static void main(String[] args) {

        int counter = 0;
        long sum;
        long lastSum = 0;
        int currentMax = 0;

        while (true) {
            sum = lastSum + counter;
            lastSum = sum;
            int divisors = getDivisorsNumber(sum);

            if (divisors > currentMax) {
                currentMax = divisors;
                System.out.println("current max status: " + sum + " " + currentMax);
            }


            if (divisors > 500) {
                System.out.println("result: " + sum);
                break;
            }
            counter++;
        }

    }

    // too time consuming
//    private static long getSum(int number) {
//        long sum = 0;
//        for (int i = 1; i <= number; i++) {
//            sum += i;
//        }
//        return sum;
//    }



    private static int getDivisorsNumber(long number) {

        int factorsSum = 2;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                factorsSum++;
            }
        }
        return factorsSum;
    }
}
