package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("1","Lekme","3", "15"),
                new Product("2","Condom","6", "75"),
                new Product("3","Milk","4", "90"),
                new Product("4","Egg","1", "7"),
                new Product("5","Silk","1", "1000"));

        List<Person> people = Arrays.asList(
                new Person("Sam","Ahuja","Male"),
                new Person("Sumit","Agarwal","Male"),
                new Person("Amit","Damani","Male"),
                new Person("Rita","Mukharji","Female"),
                new Person("Niti","Sexena","Female"));

        Predicate<Product> productAmountLessThanNinety = (product -> Integer.parseInt(product.getProductAmount()) <
                90);

        Sample sample = new Sample();
        List<Product> cheapProducts = sample.getProducts(products,productAmountLessThanNinety);
        List<Person> females = sample.getFemales(people);
        cheapProducts.forEach(product -> System.out.println(product));
    }

    public List<Person> getFemales(List<Person> people) {
        return people.stream()
                     .filter(person -> "Female".equals(person.getSex()))
                     .collect(Collectors.toList());
    }

    public List<Product> getProducts(List<Product> products, Predicate<Product> filter){
        return products.stream().filter(filter).collect(Collectors.toList());
    }
}
