package rbvs.product;

import java.io.Serializable;

/**
 * Created by @author Rron Shabani - 1526907
 */
public class SimpleProduct extends Product {

    public SimpleProduct(String name, float price) {
        super(name, price);
    }

    public SimpleProduct deepCopy(){
        return new SimpleProduct(this.getName(), this.getPrice());
    }
}
