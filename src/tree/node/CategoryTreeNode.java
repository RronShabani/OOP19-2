package tree.node;

import util.ProductCategory;

/**
 * Created by @author Rron Shabani - 1526907
 * on 15/05/2019
 */
public class CategoryTreeNode<NODETYPE,CATEGORY> extends GenericTreeNode<NODETYPE>{
    private CATEGORY category;

    public CategoryTreeNode(CATEGORY category) {
        super(category.toString(), null);
        this.category = category;
    }

    public CATEGORY getCategory(){
        return category;
    }

    @Override
    public NODETYPE nodeValue() {
        return null;
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }

    @Override
    public ITreeNode<NODETYPE> deepCopy() {
        ITreeNode<NODETYPE> deepCopy = new CategoryTreeNode<>(this.getCategory());
        for(ITreeNode<NODETYPE> itr: this.getChildren()){
            deepCopy.getChildren().add(itr.deepCopy());
        }
        return deepCopy;
    }
}
