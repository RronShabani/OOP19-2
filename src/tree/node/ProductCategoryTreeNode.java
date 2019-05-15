package tree.node;

import util.ProductCategory;

/**
 * Created by @author Rron Shabani - 1526907
 * on 15/05/2019
 */
public class ProductCategoryTreeNode<NODETYPE> extends CategoryTreeNode<NODETYPE, ProductCategory> {
    public ProductCategoryTreeNode(ProductCategory productCategory) {
        super(productCategory);
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }
}
