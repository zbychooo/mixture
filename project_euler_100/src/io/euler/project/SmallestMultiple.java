package io.euler.project;

/**
 * This is project_euler_100. Good Luck!
 */

// TASK 5
public class SmallestMultiple {


    static int[] sample1 = new int[]{1,2,3,4,5,6,7,8,9,10};

    static int[] sample2 = new int[]{2,4,6,8,10,12,14,16,18,20};

    static int[] sample3 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    public static void main(String[] args) {

        for(int i=10; i<1_000_000_000;i++) {
            if(isDividedByGivenSet(i, sample3)) {
                System.out.println(i);
                break;
            }
        }


    }


    private static boolean isDividedByGivenSet(long nbr, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (nbr % arr[i] != 0) {
                return false;
            }
        }
        return true;
    }







}
