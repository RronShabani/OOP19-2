import container.Container;
import rbvs.product.CompositeProduct;
import rbvs.product.SimpleProduct;
import tree.GenericTree;
import tree.node.ProductTreeNode;

import java.util.*;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public class Application {
    public static void main(String[] args){
        /** Container
        Container<Integer> container = new Container<>();
        for(int i=0; i < 3; i++) {
            container.add(i);
        }
        System.out.println(container.toString());
        container.remove(1);
        container.addAll(new ArrayList<Integer>(Arrays.asList(2,3,4,1,4,2)));
        System.out.println(container.toString());
        System.out.println(container.contains(5));
        System.out.println(container.get(1));
        System.out.println(container.removeAll(new ArrayList<Integer>(Arrays.asList())));
        System.out.println(container.toString());
        */

        CompositeProduct seafood = new CompositeProduct("Seafood", 5.0f);
        seafood.addProduct(new SimpleProduct("Crab", 20f));
        seafood.addProduct(new SimpleProduct("Shrimp", 19f));
        CompositeProduct fish = new CompositeProduct("Fish", 6.0f);
        SimpleProduct salmon = new SimpleProduct("Salmon", 18f);
        fish.addProduct(salmon);
        fish.addProduct(new SimpleProduct("Trout", 17f));
        fish.addProduct(new SimpleProduct("Bass", 16f));
        seafood.addProduct(fish);

        ProductTreeNode prodNode = new ProductTreeNode((CompositeProduct)seafood);
        ProductTreeNode prodNode2 = prodNode.deepCopy();
//        System.out.println(prodNode2.getChildren());
//        System.out.println(prodNode.generateConsoleView(" ", "|-"));
//        System.out.println(prodNode2.generateConsoleView(" ", "|-"));
//        System.out.println(prodNode.findNodeByValue(salmon).getLabel());


        GenericTree tree = new GenericTree(prodNode);
        System.out.println(tree.generateConsoleView(" "));
        System.out.println(tree.findNode(salmon).getLabel());
    }
}
