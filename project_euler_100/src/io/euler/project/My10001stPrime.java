package io.euler.project;

/**
 * This is project_euler_100. Good Luck!
 */
// TASK 7
public class My10001stPrime {

    public static void main(String[] args) {

        boolean prime = isPrime(20);
        boolean prime1 = isPrime(17);

        int counter = 0;
        int index = 10001;
        int mynumber = 2;
        while (true) {

            if (isPrime(mynumber)) {
                counter++;
            }

            if(counter==index) break;

            mynumber++;
        }


        System.out.println(counter + " " + mynumber);
    }


    private static boolean isPrime(int number) {

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
