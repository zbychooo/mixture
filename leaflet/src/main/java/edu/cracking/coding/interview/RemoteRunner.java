package edu.cracking.coding.interview;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class RemoteRunner {

    public static void main(String[] args) {


        List<Task> tasks = Arrays.asList(
                Task.builder().taskId(100).name("do it right").build(),
                Task.builder().taskId(200).name("do it right").build(),
                Task.builder().taskId(300).name("do it right").build(),
                Task.builder().taskId(400).name("do it right").build(),
                Task.builder().taskId(500).name("do it right").build(),
                Task.builder().taskId(600).name("do it right").build(),
                Task.builder().taskId(700).name("do it right").build()
        );

        List<Task> tasks2 = Arrays.asList(
                Task.builder().taskId(100).name("do it right").build(),
                Task.builder().taskId(200).name("do it right").build(),
                Task.builder().taskId(300).name("do it right").build()
        );


        Address a = new Address("Wall Street", 1, 1, new ZipCode(90, "-", 300));
        Address b = new Address("Wall Street", 1, 2, null);
        List<Employee> employees = Arrays.asList(
                Employee.builder().id(1).firstName("a0").lastName("b0").age(32).sex(Sex.MALE).salary(2000).tasks(tasks).build(),
                Employee.builder().id(2).firstName("a1").lastName("b1").age(20).sex(Sex.FEMALE).salary(6000).tasks(tasks2).address(b).build(),
                Employee.builder().id(3).firstName("a2").lastName("b2").age(66).sex(Sex.MALE).salary(12000).tasks(Collections.emptyList()).address(a).build()
        );

        employees.forEach(System.out::println);

        Stream<String> stringStream = employees.stream().map(Employee::toString);

        List<Employee> collect = employees.stream().filter(RemoteRunner::isAddressNull).collect(toList());

        List<Employee> collect1 = employees.stream()
                .filter(e -> Optional.of(e).map(Employee::getAddress).map(Address::getZipCode).isPresent())
                .collect(toList());

        List<Task> collect2 = employees.stream().map(Employee::getTasks).flatMap(e -> e.stream()).filter(e -> e.getTaskId() > 200).collect(Collectors.toList());

        Map<String, List<Task>> collect3 = employees.stream().collect(toMap(Employee::getFirstName, Employee::getTasks));

        //TODO: Collectors.filtering and Collectors.flatMapping in java9
      //  List<Task> collect4 = employees.stream().map(Employee::getTasks).flatMap(e -> e.stream()).filter(e -> e.getTaskId() > 200).collect(Collectors.toMap(f -> f.getClass(), f -> f));

//        Map<String, List<Task>> collect4 = employees.stream().collect(
//                collectingAndThen(
//                        toMap(e -> e.getFirstName(), e -> e.getAge()),
//                        f -> f.values().removeIf(t -> t > 30)
//                )
//        );

        Map<Sex, Set<Employee>> collect4 = employees.stream().collect(groupingBy(Employee::getSex, toSet()));

        System.out.println("");
    }

    private static boolean isAddressNull(Employee e) {
        return Optional.of(e).map(Employee::getAddress).isPresent();
    }



}

@Data
@AllArgsConstructor
class ZipCode {
    private int prefix;
    private String separator;
    private int postfix;
}

@Data
@AllArgsConstructor
class Address {
    private String streetName;
    private int streetNumber;
    private int flatNumber;
    private ZipCode zipCode;
}

@Data
@Builder
class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;
    private int salary;
    private Address address;
    private List<Task> tasks;
}

@Data
@Builder
class Task{
    private long taskId;
    private String name;
    private String description;
}

enum Sex {
    MALE, FEMALE
}

interface Genericable{}
interface Testable extends Serializable, Genericable {

    int tired = 0;
    void getTest();
    default void myMethod(){}
}

