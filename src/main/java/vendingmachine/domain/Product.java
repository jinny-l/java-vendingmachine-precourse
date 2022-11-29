package vendingmachine.domain;

import java.util.List;

public class Product {

    private final String name;
    private final int price;
    private int count;

    public Product(List<String> product) {
        this.name = product.get(0);
        this.price = Integer.parseInt(product.get(1));
        this.count = Integer.parseInt(product.get(2));
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void decreaseCount() {
        count--;
    }

}
