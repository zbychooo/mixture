package edu.cracking.coding.interview;


import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class RemoteRunner {

    public static void main(String[] args) {



        Address a = new Address("Wall Street", 1,1, new ZipCode(90,"-", 300));

        List<Employee> employees = Arrays.asList(
                Employee.builder().id(1).firstName("a0").lastName("b0").age(32).sex(Sex.MALE).salary(2000).build(),
                Employee.builder().id(2).firstName("a1").lastName("b1").age(20).sex(Sex.FEMALE).salary(6000).build(),
                Employee.builder().id(3).firstName("a2").lastName("b2").age(66).sex(Sex.MALE).salary(12000).address(a).build()
                );

        employees.forEach(System.out::println);

        Stream<String> stringStream = employees.stream().map(Employee::toString);

/*
Optional<Other> result =
    things.stream()
          .map(this::resolve)
          .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
          .findFirst();
 */
        employees.stream().filter(e -> e.getAddress() != null).filter(e -> e.getAddress().getZipCode() != null);

        System.out.println("");
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
}

enum Sex {
    MALE, FEMALE
}

