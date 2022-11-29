package vendingmachine.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Products {

    private List<Product> products;

    public List<Integer> getProductPrice(String input) {
        return products.stream()
                .filter(product -> product.getName().equals(input))
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
