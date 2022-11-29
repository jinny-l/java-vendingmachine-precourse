package vendingmachine.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String PRODUCT_INFO_DELIMITER = ",";
    private static final String PRODUCT_DELIMITER = ";";
    private static final String EMPTY = "";
    private static final String WHITE_SPACE = "\\s*";

    public static List<List<String>> toList(String input) {
        List<String> products = separateProducts(removeBrackets(input));
        List<List<String>> productsInfo = new ArrayList<>();
        for (String product : products) {
            productsInfo.add(Stream.of(product.split(WHITE_SPACE + PRODUCT_INFO_DELIMITER + WHITE_SPACE))
                    .collect(Collectors.toList()));
        }
        return productsInfo;
    }

    private static List<String> separateProducts(String input) {
        return Stream.of(input.split(WHITE_SPACE + PRODUCT_DELIMITER + WHITE_SPACE))
                .collect(Collectors.toList());
    }

    private static String removeBrackets(String input) {
        return input.replace(LEFT_SQUARE_BRACKET, EMPTY)
                .replace(RIGHT_SQUARE_BRACKET, EMPTY);
    }

}
