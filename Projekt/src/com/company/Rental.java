package com.company;


        import java.util.Collection;
        import java.util.List;

public class Rental<E> {
    private List<E> rentalPool;
    private int maxNum;

    public Rental(int maxNum, List<E> rentalPool) {
        this.maxNum = maxNum;
        this.rentalPool = rentalPool;
    }

    public Object getRental() {
        // blocks until there's something available
        return rentalPool.get(0);
    }

    public void returnRental(E e) {
        rentalPool.add(e);
    }
}

class Car {

    Collection<Object> o = null;
}

class CarRental extends Rental {
    public CarRental(int maxNum, List<Car> rentalPool) {
        super(maxNum, rentalPool);
    }

    public Car getRental() {
        return (Car) super.getRental();
    }

    public void returnRental(Car c) {
        super.returnRental(c);
    }

    public void returnRental(Object o) {
        if (o instanceof Car) {
            super.returnRental(o);
        } else {
            System.out.println("Cannot add a non-Car");
            // probably throw an exception
        }
    }
}
