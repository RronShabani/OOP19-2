package util;

import rbvs.product.Product;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public enum ProductCategory {
    BEVERAGE("Beverage"),
    FOOD("Food"),
    DEFAULT("Default");

    private final String label;

    ProductCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
