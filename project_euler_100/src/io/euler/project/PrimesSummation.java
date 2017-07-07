package io.euler.project;

/**
 * This is project_euler_100. Good Luck!
 */
//TASK 10
public class PrimesSummation {

    public static void main(String[] args) {


        long sum = 0;
        for (int i = 2; i < 2_000_000; i++) {

            if (isPrime(i)) {

                sum += i;
                System.out.println(i + " " + sum);
            }
        }


        System.out.println("sum " + sum);
    }


    private static boolean isPrime(int number) {

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static boolean isPrime2(int number) {

        for (int i = 3; i < number; i=i+2) {
            if (number % i == 0) return false;
        }

        return true;
    }

    private static boolean check3459(int number) {

        String s = String.valueOf(number);

        if(Character.getNumericValue(s.charAt(s.length()-1))==5) return false;



        return false;
    }
}
