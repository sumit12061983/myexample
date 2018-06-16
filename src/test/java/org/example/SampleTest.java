package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static java.lang.System.out;

public class SampleTest {

    List<Product> products = null;
    List<Person> people = null;


    @Before
    public void prepareForTest() {
        products = Arrays.asList(
                new Product("1","Lekme","3", "15"),
                new Product("2","Condom","6", "75"),
                new Product("3","Milk","4", "90"),
                new Product("4","Egg","1", "7"),
                new Product("5","Silk","1", "1000"));

        people = Arrays.asList(
                new Person("Sam","Ahuja","Male"),
                new Person("Sumit","Agarwal","Male"),
                new Person("Amit","Damani","Male"),
                new Person("Rita","Mukharji","Female"),
                new Person("Niti","Sexena","Female"));
    }

    @After
    public void tearDown() {
        products = null;
        people = null;
    }

    @Test
    public void test_get_females_valid_output_when_valid_data_set_is_provided() {
        Sample sample = new Sample();
        List<Person> females = sample.getFemales(people);
        Assert.assertTrue(females.size() == 2);
        Assert.assertTrue(females
                            .stream()
                            .filter(Objects::nonNull)
                            .map(female -> female.getSex())
                            .allMatch(Predicate.isEqual("Female")));
        females.stream().forEach(System.out::println);
    }

    @Test
    public void test_get_products_empty_list_when_product_amount_is_less_than_1000_and_filter_greater_than_1000(){
        Sample sample = new Sample();
        List<Product> emptyProducts = sample.getProducts(products,
                (product -> Integer.parseInt(product.getProductAmount()) > 1000));
        Assert.assertTrue(emptyProducts.size() == 0);
    }
}
