package tree.node;

import rbvs.copy.IDeepCopy;

/**
 * Created by @author Rron Shabani - 1526907
 * on 15/05/2019
 */
public class CopyableTreeNode<NODETYPE extends IDeepCopy> extends GenericTreeNode<NODETYPE>{

    public CopyableTreeNode(String label, NODETYPE nodeValue) {
        super(label, nodeValue);
    }

    public CopyableTreeNode<NODETYPE> deepCopy(){
        ITreeNode<NODETYPE> deepCopy = new CopyableTreeNode<>(this.getLabel(), this.nodeValue());
        for(ITreeNode<NODETYPE> itr: this.getChildren()){
            deepCopy.getChildren().add(itr.deepCopy());
        }
        return (CopyableTreeNode<NODETYPE>) deepCopy;
    }
}
