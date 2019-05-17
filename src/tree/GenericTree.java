package tree;

import tree.node.ITreeNode;
import util.searchable.ISearchFilter;

import java.util.Collection;

/**
 * Created by @author Rron Shabani - 1526907
 * on 17/05/2019
 */
public class GenericTree<TREETYPE>
        extends Object
        implements ITree<TREETYPE>{
    private ITreeNode<TREETYPE> root;

    public GenericTree(ITreeNode<TREETYPE> root) {
        this.root = root;
    }

    @Override
    public ITreeNode<TREETYPE> getRoot() {
        return this.root;
    }

    @Override
    public void setRoot(ITreeNode<TREETYPE> root) {
        this.root = root;
    }

    @Override
    public ITreeNode<TREETYPE> findNode(TREETYPE searchValue) {
        return this.root.findNodeByValue(searchValue);
    }

    @Override
    public ITreeNode<TREETYPE> findNode(ITreeNode<TREETYPE> searchNode) {
        return this.root.findNodeByNode(searchNode);
    }

    @Override
    public String generateConsoleView(String spacer) {
        return this.root.generateConsoleView(spacer,"|-");
    }

    @Override
    public ITree<TREETYPE> deepCopy() {
        return new GenericTree<TREETYPE>(this.root.deepCopy());
    }

    @Override
    public Collection<ITreeNode<TREETYPE>> searchByFilter(ISearchFilter filter, Object object) {
        return this.root.searchByFilter(filter, object);
    }
}
