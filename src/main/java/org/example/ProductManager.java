package org.example;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductManager implements IProductManager{
    public List<Product> getProducts(List<Product> products, Predicate<Product> filter){
        return products.stream().filter(filter).collect(Collectors.toList());
    }
}
