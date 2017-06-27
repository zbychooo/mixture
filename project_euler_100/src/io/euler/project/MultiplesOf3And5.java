package io.euler.project;

//TASK 1
public class MultiplesOf3And5 {
    public static void main(String[] args) {

        MultiplesOf3And5 m = new MultiplesOf3And5();
        int sumOfMultiplies = m.getSumOfMultiplies(1000);
        System.out.println(sumOfMultiplies);

    }

    private int getSumOfMultiplies(int maxLimit) {

        int sum = 0;
        for (int i = 1; i < maxLimit; i++) {
            if (isMultiplied(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private boolean isMultiplied(int number) {
        return (((number % 3) == 0) || ((number % 5) == 0));
    }
}