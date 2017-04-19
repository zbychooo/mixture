package com.company;

public class Main {

    public static void main(String[] args) {

        MyCollection<String> strings = new SingleLinked<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        //AlgorithmService.printAllRawItems(strings);

        MyCollection<Number> numbers = new SingleLinked<>();
        numbers.add(100000);
        numbers.add(2);
        numbers.add(4.3);
        // AlgorithmService.printAllItems(numbers);

        MyCollection<Step> steps = new SingleLinked<>();
        steps.add(new SimpleStep("aaa"));
        steps.add(new SimpleStep("bbb"));
        steps.add(new ComplexStep("ccc"));
        AlgorithmService.printAllItems(steps);

        MyCollection<Step> steps2 = new SingleLinked<>();
        steps2.add(new Step("111"));
        steps2.add(new Step("222"));

        AlgorithmService.merge(steps, steps2);
        System.out.println("steps 1 size:" + steps.size());
        System.out.println("steps 2 size:" + steps2.size());

        MyCollection<SimpleStep> simpleSteps = new SingleLinked<>();
        simpleSteps.add(new SimpleStep("single1"));
        simpleSteps.add(new SimpleStep("single2"));
        simpleSteps.add(new SimpleStep("single3"));
        simpleSteps.add(new SimpleStep("single4"));
        AlgorithmService.printAllItems(simpleSteps);


        MyCollection<Step> complexSteps = new SingleLinked<>();
        complexSteps.add(new ComplexStep("ccc1"));
        complexSteps.add(new ComplexStep("ccc2"));
        complexSteps.add(new ComplexStep("ccc3"));

        System.out.println("simpleSteps size:" + simpleSteps.size());
        System.out.println("complexSteps size:" + complexSteps.size());
        AlgorithmService.merge(simpleSteps, complexSteps);
        System.out.println("simpleSteps size:" + simpleSteps.size());
        System.out.println("complexSteps size:" + complexSteps.size());

    }
}


class Step {
    String description;
    public Step(String description) {
        this.description = description;
    }
}

class SimpleStep extends Step {
    public SimpleStep(String description) {
        super(description);
    }
}

class ComplexStep extends Step {
    public ComplexStep(String description) {
        super(description);
    }
}

class AlgorithmService {

    public static void printAllItems(MyCollection<? extends Step> myCollection) {

        for (int i = 0; i < myCollection.size(); i++) {
            print(myCollection.get(i));
        }
    }

    public static MyCollection<? super Step> merge(MyCollection<? extends Step> source, MyCollection<? super Step> target) {
        target.addAll(source);
        return target;
    }

    public static void printAllRawItems(MyCollection myCollection) {

        for (int i = 0; i < myCollection.size(); i++) {
            Step step = (Step) myCollection.get(i); //Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to com.company.Step
            print(step);
        }
    }

    public static <E extends Step> void print(E e) {
        System.out.println(e.description);
    }
}