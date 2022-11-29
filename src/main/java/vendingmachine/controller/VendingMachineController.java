package vendingmachine.controller;

import java.util.List;
import vendingmachine.Coin;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.util.CoinRandomGenerator;
import vendingmachine.util.Parser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private List<List<String>> productsInfo;
    private Products products;
    private Money money;
    private boolean hasEnoughMoney = true;

    public void run() {
        initialize();
        printCoinsInfo();
        readProductsInfo();
        addProducts();
        readMoney();
        while (hasEnoughMoney) {
            readProductToBuy();
            checkEnoughMoney();
        }
        String todo = "todo";
        printResult(todo);
    }

    private void initialize() {
        try {
            int coins = InputView.readCoins();
            CoinRandomGenerator coinRandomGenerator = new CoinRandomGenerator();
            coinRandomGenerator.generate(coins);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            initialize();
        }
    }

    private void printCoinsInfo() {
        OutputView.printVendingMachineCoins(Coin.getCoinsInfo());
    }

    private void readProductsInfo() {
        productsInfo = Parser.toList(InputView.readProductsInfo());
    }

    private void addProducts() {
        products = new Products();
        for (List<String> productInfo : productsInfo) {
            products.add(new Product(productInfo));
        }
    }

    private void readMoney() {
        try {
            money = new Money(InputView.readMoney());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            readMoney();
        }
    }

    private void readProductToBuy() {
        OutputView.printChanges(money.getMoney());
        String productToBuy = InputView.readProductToBuy();
        products.buy(productToBuy);
        money.decreaseMoney(products.getProductPrice(productToBuy));
    }

    private void checkEnoughMoney() {
        List<Integer> productPrices = products.getProductsPrice();
        int changes = money.getMoney();
        for (Integer productPrice : productPrices) {
            if (changes < productPrice) {
                hasEnoughMoney = false;
                break;
            }
        }
    }

    private void printChanges() {
        OutputView.printChanges(money.getMoney());
    }

    private void printResult(String todo) {
        OutputView.printChanges(money.getMoney());
        OutputView.printResult(todo);
    }

}
