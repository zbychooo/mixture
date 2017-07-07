package io.euler.project;

/**
 * This is project_euler_100. Good Luck!
 */
//TASK 9
public class SpecialPythagoreanTriplet {
    public static void main(String[] args) {

        for (int i = 1; i < 999; i++) {
            for (int j = i; j < 999; j++) {
                for (int k = j; k < 999; k++) {

                    if((i*i + j*j) == k*k) {
                       // System.out.println(i + " " + j + " " + k);

                        if(i+j+k==1000) {
                            System.out.println("!!!!! a*b*c=" + i*j*k);
                        }
                    }
                }
            }
        }


    }
}
