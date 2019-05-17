package tree.node;

import rbvs.product.CompositeProduct;
import rbvs.product.IProduct;
import rbvs.product.Product;

/**
 * Created by @author Rron Shabani - 1526907
 * on 15/05/2019
 */
public class ProductTreeNode extends GenericTreeNode<IProduct> {
    private ProductTreeNode(CompositeProduct value){
        super(value.getName(), value);
    }

    public ProductTreeNode(String label, IProduct value) {
        super(label, value);
    }

    public ProductTreeNode(IProduct value){
        super(value.getName(), value);
        if(value instanceof CompositeProduct)
            this.initialize(value);
    }



    private void initialize(IProduct item){
        for(IProduct itr: ((CompositeProduct) item).getProducts()){
            this.getChildren().add(new ProductTreeNode(itr));
        }
    }

    public ProductTreeNode deepCopy(){
        ProductTreeNode copy;
        if(this.nodeValue() instanceof CompositeProduct) {
            copy = new ProductTreeNode((CompositeProduct) this.nodeValue().deepCopy());
        } else {
            copy = new ProductTreeNode((IProduct) this.nodeValue().deepCopy());
        }
        for(ITreeNode<IProduct> itr: this.getChildren()){
            copy.getChildren().add(itr.deepCopy());
        }

        return copy;
    }
}
