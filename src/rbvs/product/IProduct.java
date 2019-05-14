package rbvs.product;

import rbvs.copy.IDeepCopy;

/**
 * Created by @author Rron Shabani - 1526907
 */
public interface IProduct extends IDeepCopy {
    String getName();
    float getPrice();
}
