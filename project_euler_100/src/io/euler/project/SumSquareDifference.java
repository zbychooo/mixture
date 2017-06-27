package io.euler.project;

/**
 * This is project_euler_100. Good Luck!
 */
//TASK 6
public class SumSquareDifference {


    public static void main(String[] args) {

        int initNbr = 100;

        long sum1 = 0;
        long sum2 = 0;

        for(int i=1; i<=initNbr; i++) {
            sum1 = (long) (sum1 + Math.pow(i, 2));
        }
        System.out.println(sum1);

        for(int j=1; j<=initNbr; j++) {
            sum2 = sum2+j;
        }

        sum2 = (int) Math.pow(sum2, 2);
        System.out.println(sum2);

        long diff = (sum2 - sum1);
        System.out.println(diff);

    }
}
