package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Products {

    private final List<Product> products = new ArrayList<>();

    public List<Integer> getProductPrice(String input) {
        return products.stream()
                .filter(product -> product.getName().equals(input))
                .map(Product::getPrice)
                .collect(Collectors.toList());
    }

    public List<Integer> getProductsPrice() {
        return products.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());
    }

    public void add(Product product) {
        products.add(product);
    }

    public void buy(String input) {
        products.stream()
                .filter(product -> product.getName().equals(input))
                .forEach(Product::decreaseCount);
    }

}
