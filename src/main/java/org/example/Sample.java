package org.example;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.ProvidedBy;
import com.google.inject.Provider;
import com.google.inject.Stage;
import org.example.config.PersonModule;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class Sample {

    @Inject
    public IProductManager productManager;

    @Inject
    IPersonManager personManager;

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

        Injector injector = Guice.createInjector(new PersonModule());
        Sample sample = injector.getInstance(Sample.class);

        List<Product> cheapProducts = sample.getProducts(products,productAmountLessThanNinety);
        List<Person> females = sample.getFemales(people);
        cheapProducts.forEach(product -> System.out.println(product));
    }

    public List<Product> getProducts(List<Product> products, Predicate<Product> productAmountLessThanNinety) {
        return productManager.getProducts(products,productAmountLessThanNinety);
    }

    public List<Person> getFemales(List<Person> people) {
        return personManager.getFemales(people);
    }
}
