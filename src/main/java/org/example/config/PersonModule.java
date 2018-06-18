package org.example.config;

import com.google.inject.AbstractModule;
import org.example.IPersonManager;
import org.example.IProductManager;
import org.example.PersonManager;
import org.example.Product;
import org.example.ProductManager;

public class PersonModule extends AbstractModule{
    protected void configure() {
        bind(IPersonManager.class).to(PersonManager.class);
        bind(IProductManager.class).to(ProductManager.class);
    }
}
