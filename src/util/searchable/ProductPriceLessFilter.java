package util.searchable;

import rbvs.product.Product;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public class ProductPriceLessFilter implements ISearchFilter{
    @Override
    public boolean searchFilterFunction(Object originalObject, Object compareObject) {
        if(originalObject!=null && compareObject!=null)
            if(originalObject instanceof Product && compareObject instanceof Product)
                return ((Product)originalObject).getPrice()<((Product)compareObject).getPrice();

        return false;
    }
}
