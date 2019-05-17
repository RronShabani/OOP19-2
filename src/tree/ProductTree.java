package tree;

import rbvs.product.IProduct;
import tree.node.ITreeNode;
import tree.node.ProductTreeNode;

/**
 * Created by @author Rron Shabani - 1526907
 * on 17/05/2019
 */
public class ProductTree extends GenericTree<IProduct> {
    public ProductTree(ITreeNode<IProduct> root) {
        super(root);
    }

    public ProductTree(IProduct product) {
        super(new ProductTreeNode(product));
    }

    public ProductTree() {
        super(null);
    }
}
