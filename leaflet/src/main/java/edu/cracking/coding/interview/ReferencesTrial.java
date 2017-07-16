package edu.cracking.coding.interview;

/**
 * This is leaflet. Good Luck!
 */
public class ReferencesTrial {

    public static void main(String args[]) {
        System.out.println("");


        int a = 3;
        int b = 4;

        System.out.println("a=" + a + " b=" + b);
        ReferencesTrial rt = new ReferencesTrial();
        rt.swapInt(a, b);
        System.out.println("a=" + a + " b=" + b);

    }

    private void swapInt(int x, int y) {
        int swap = x;
        x = y;
        y = swap;

        System.out.println("Inside swapInt method: x=" + x + " y=" + y);
    }
}
