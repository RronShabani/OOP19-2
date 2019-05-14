package util.searchable;

import rbvs.product.Product;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public class TextSearchIgnoreCaseFilter implements ISearchFilter {
    @Override
    public boolean searchFilterFunction(Object originalObject, Object compareObject) {
        if(originalObject != null && compareObject != null)
                return originalObject.toString().toLowerCase().equals(compareObject.toString().toLowerCase());
        return false;
    }
}
