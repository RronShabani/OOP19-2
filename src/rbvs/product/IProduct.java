package rbvs.product;

import rbvs.copy.IDeepCopy;

import java.io.Serializable;

/**
 * Created by @author Rron Shabani - 1526907
 */
public interface IProduct extends IDeepCopy, Serializable {
    String getName();
    float getPrice();
}
