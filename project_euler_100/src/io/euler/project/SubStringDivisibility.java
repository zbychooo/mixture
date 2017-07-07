package io.euler.project;

import java.util.Scanner;

/**
 * This is project_euler_100. Good Luck!
 */
// :: TASK 43
//
// The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
//
// Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
//
// d2d3d4=406 is divisible by 2
// d3d4d5=063 is divisible by 3
// d4d5d6=635 is divisible by 5
// d5d6d7=357 is divisible by 7
// d6d7d8=572 is divisible by 11
// d7d8d9=728 is divisible by 13
// d8d9d10=289 is divisible by 17
// Find the sum of all 0 to 9 pandigital numbers with this property.

public class SubStringDivisibility {

//    public static void main(String[] args) {
//
//
//        int digits[] = new int[]{0,1,2,3,4,5,6,7,8,9};
//
//
//
//
//    }


    public static int counter = 0;

    public static void Permute(int[] input, int startindex) {
        int size = input.length;

        if (size == startindex + 1) {
            System.out.println(counter + "Permutation is");
            for (int i = 0; i < size; i++) {
                System.out.print(input[i] + ",  ");
            }
            System.out.println();
            System.out.println("##########################");
            counter++;
        } else {
            for (int i = startindex; i < size; i++) {

                int temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
                Permute(input, startindex + 1);
                temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input array Length");
        int arraylength = in.nextInt();
        int[] input = new int[arraylength];
        for (int i = 0; i < arraylength; i++) {
            input[i] = in.nextInt();
        }
        counter = 0;
        Permute(input, 0);
        System.out.println(counter + "  number of permutations obtained");
    }

}
