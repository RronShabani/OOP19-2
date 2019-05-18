import container.Container;
import rbvs.product.CompositeProduct;
import rbvs.product.IProduct;
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

        //Seafood
        CompositeProduct seafood = new CompositeProduct("Seafood", 5.0f);
        seafood.addProduct(new SimpleProduct("Crab", 20f));
        seafood.addProduct(new SimpleProduct("Shrimp", 19f));
        CompositeProduct fish = new CompositeProduct("Fish", 6.0f);
        fish.addProduct(new SimpleProduct("Salmon", 18f));
        fish.addProduct(new SimpleProduct("Trout", 17f));
        fish.addProduct(new SimpleProduct("Bass", 16f));
        seafood.addProduct(fish);


        //Drinks
        CompositeProduct drinks = new CompositeProduct("Drinks", 5.0f);
        CompositeProduct beer = new CompositeProduct("Beer", 3.5f);
        beer.addProduct(new SimpleProduct("Ottakringer", 2.8f));
        beer.addProduct(new SimpleProduct("Stigl", 2.8f));
        drinks.addProduct(beer);
        drinks.addProduct(new SimpleProduct("Wine", 3.8f));
        CompositeProduct nonAlcoholic = new CompositeProduct("Non-alcoholic", 6.0f);
        nonAlcoholic.addProduct(new SimpleProduct("Orange Juice", 2.8f));
        nonAlcoholic.addProduct(new SimpleProduct("Apple Juice", 2.8f));
        nonAlcoholic.addProduct(new SimpleProduct("Ice-Tea", 3.2f));
        drinks.addProduct(nonAlcoholic);


        ProductTreeNode prodNode = new ProductTreeNode(new CompositeProduct("Product List",0f));
        prodNode.getChildren().add(new ProductTreeNode(drinks));
        prodNode.getChildren().add(new ProductTreeNode(seafood));
        ProductTreeNode prodNode2 = prodNode.deepCopy();
//        System.out.println(prodNode2.getChildren());
//        System.out.println(prodNode.generateConsoleView(" ", "|-"));
//        System.out.println(prodNode2.generateConsoleView(" ", "|-"));
//        System.out.println(prodNode.findNodeByValue(salmon).getLabel());


        GenericTree tree = new GenericTree(prodNode);
        System.out.println(tree.generateConsoleView(" "));
        //System.out.println(tree.findNode(salmon).getLabel());
    }
}
