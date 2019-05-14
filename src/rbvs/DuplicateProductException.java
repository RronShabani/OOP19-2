package rbvs;

import rbvs.product.IProduct;

import java.io.Serializable;

/**
 * Created by @author Rron Shabani - 1526907
 */
public class DuplicateProductException extends Exception implements Serializable{
    private IProduct product;
    private static final long serialVersionUID = -6793101677689532935L;

    public DuplicateProductException(IProduct product) {
        this.product = product;
    }

    public String getMessage() {
        return "Product " + product.getName() + " already exists!";
    }
}
