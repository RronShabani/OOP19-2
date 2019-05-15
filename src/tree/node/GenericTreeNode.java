package tree.node;

import container.Container;
import util.searchable.ISearchFilter;

import java.util.Collection;

/**
 * Created by @author Rron Shabani - 1526907
 * on 15/05/2019
 */
public class GenericTreeNode<NODETYPE> implements ITreeNode<NODETYPE>{
    private String label;
    private NODETYPE nodeValue;
    private Collection<ITreeNode<NODETYPE>> children;

    public GenericTreeNode(String label, NODETYPE nodeValue) {
        this.label = label;
        this.nodeValue = nodeValue;
        this.children = new Container<>();
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public boolean isLeaf() {
        return this.children==null;
    }

    @Override
    public NODETYPE nodeValue() {
        return this.nodeValue;
    }

    @Override
    public Collection<ITreeNode<NODETYPE>> getChildren() {
        return this.children;
    }

    @Override
    public boolean checkNodeByValue(NODETYPE value){
        return this.nodeValue.equals(value);
    }

    @Override
    public ITreeNode<NODETYPE> findNodeByNode(ITreeNode<NODETYPE> searchNode) {
        if(searchNode==null)
            return null;
        ITreeNode<NODETYPE> temp = null;
        if(searchNode.equals(this)){
            return this;
        }else {
            for(ITreeNode<NODETYPE> itr: children) {
                temp = itr .findNodeByNode(searchNode);
                if(temp != null)
                    break;
            }
        }
        return temp;
    }

    @Override
    public ITreeNode<NODETYPE> findNodeByValue(NODETYPE searchValue) {
        if(searchValue==null)
            return null;
        ITreeNode<NODETYPE> temp = null;
        if(searchValue.equals(this.nodeValue())){
            return this;
        }else {
            for(ITreeNode<NODETYPE> itr: children) {
                temp = itr.findNodeByValue(searchValue);
                if(temp != null)
                    break;
            }
        }
        return temp;
    }

    //TODO Check again
    @Override
    public Collection<ITreeNode<NODETYPE>> searchByFilter(ISearchFilter filter, Object object) {
        Collection<ITreeNode<NODETYPE>> outCollection = new Container<>();

        if (filter.searchFilterFunction(this, object) || filter.searchFilterFunction(this.nodeValue(), object)){
            outCollection.add(this);
        }
        if(children!=null)
            for(ITreeNode<NODETYPE> child: children){
                outCollection.addAll(child.searchByFilter(filter, object));
            }
        return outCollection;
    }

    @Override
    public String generateConsoleView(String spacer, String preamble) {
        String out = "";
        if(this.getChildren()==null)
            return preamble + spacer + this.getLabel();

        for(ITreeNode<NODETYPE> itr: children) {
            if(itr!=null)//Should always be true, is there just in case!
            {
                out.concat(generateConsoleView(spacer + spacer, "") + "\n");
            }
        }
        return out.concat(preamble + spacer + this.getLabel());
    }

    @Override
    public ITreeNode<NODETYPE> deepCopy() {
        ITreeNode<NODETYPE> deepCopy = new GenericTreeNode<>(this.getLabel(), this.nodeValue());
        for(ITreeNode<NODETYPE> itr: this.getChildren()){
            deepCopy.getChildren().add(itr.deepCopy());
        }
        return deepCopy;
    }
}
