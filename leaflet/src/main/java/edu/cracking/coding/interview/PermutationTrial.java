package edu.cracking.coding.interview;

import java.util.HashSet;
import java.util.Set;

public class PermutationTrial {


    public Set<String> getPermutation(int[] numbers) {


        Set<String> permutation = new HashSet<>();
        String item;
        int swap;
        for (int i = 0; i < numbers.length; i++) {

            if (i != 0) {
                swap = numbers[0];
                numbers[0] = numbers[i];
                numbers[i] = swap;
            }

            item = intsToString(numbers);
            if (!permutation.contains(item)) {
                permutation.add(item);
            }

            for (int j = 1; j < numbers.length; j++) {
                swap = numbers[j - 1];
                numbers[j - 1] = numbers[j];
                numbers[j] = swap;
                item = intsToString(numbers);
                if (!permutation.contains(item)) {
                    permutation.add(item);
                }
            }

        }

        return permutation;

    }

    private String intsToString(int[] ints) {

        StringBuilder builder = new StringBuilder();
        for (int i : ints) {
            builder.append(i);
        }

        return builder.toString();
    }

    public static void main(String args[]) {

        PermutationTrial trial = new PermutationTrial();
        Set<String> permutation = trial.getPermutation(new int[]{1, 2, 3});
        //  Set<String> permutation = trial.getPermutation(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        System.out.println(permutation);

    }
}
