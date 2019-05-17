package tree;

import rbvs.copy.IDeepCopy;
import tree.node.ITreeNode;
import util.searchable.ISearchableByFilter;

/**
 * Created by @author Rron Shabani - 1526907
 * on 17/05/2019
 */
public interface ITree<TREETYPE> extends IDeepCopy, ISearchableByFilter<ITreeNode<TREETYPE>> {
    ITreeNode<TREETYPE> getRoot();
    void setRoot(ITreeNode<TREETYPE> root);
    ITreeNode<TREETYPE> findNode(TREETYPE searchValue);
    ITreeNode<TREETYPE> findNode(ITreeNode<TREETYPE> searchNode);
    String generateConsoleView(String spacer);
    ITree<TREETYPE> deepCopy();
}
