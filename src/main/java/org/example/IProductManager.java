package org.example;

import java.util.List;
import java.util.function.Predicate;

public interface IProductManager {
    List<Product> getProducts(List<Product> products, Predicate<Product> filter);
}
