package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class PersonManager implements IPersonManager{

    public List<Person> getFemales(List<Person> people) {
        return people.stream()
                .filter(person -> "Female".equals(person.getSex()))
                .collect(Collectors.toList());
    }
}
