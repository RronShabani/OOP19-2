package tree.node;

import rbvs.copy.IDeepCopy;
import util.searchable.ISearchableByFilter;

import java.util.Collection;

/**
 * Created by @author Rron Shabani - 1526907
 * on 15/05/2019
 */
public interface ITreeNode<NODETYPE> extends IDeepCopy, ISearchableByFilter<ITreeNode<NODETYPE>> {
    String getLabel();
    NODETYPE nodeValue();
    Collection<ITreeNode<NODETYPE>> getChildren();
    boolean isLeaf();
    boolean checkNodeByValue(NODETYPE value);
    ITreeNode<NODETYPE> findNodeByNode(ITreeNode<NODETYPE> searchNode);
    ITreeNode<NODETYPE> findNodeByValue(NODETYPE searchValue);
    String generateConsoleView(String spacer, String preamble);
    @Override
    ITreeNode<NODETYPE> deepCopy();
}
