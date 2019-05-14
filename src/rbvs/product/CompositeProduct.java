package rbvs.product;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by @author Rron Shabani - 1526907
 */
public class CompositeProduct extends Product {
    private float discount;
    private Collection<Product> containedProducts = new ArrayList<>();

    public CompositeProduct(String name, float discountPercentage) {
        super(name);
        if(discountPercentage < 0)
            discountPercentage = 0;
        if(discountPercentage > 100)
            discountPercentage = 100;
        this.discount = discountPercentage;
    }

    public CompositeProduct(String name, float discountPercentage, Collection<Product> products) {
        super(name);
        if(discountPercentage < 0)
            discountPercentage = 0;
        if(discountPercentage > 100)
            discountPercentage = 100;
        this.discount = discountPercentage;
        if(products != null)
            this.containedProducts.addAll(products);
    }

    public Collection<Product> getProducts() {
        return containedProducts;
    }

    public IProduct findCompositeProduct(String productName){
        IProduct ret = null;
        for(IProduct product: containedProducts){
            if(product.getName().equals(productName))
                return product;
            if(product instanceof CompositeProduct){
                ret = ((CompositeProduct) product).findCompositeProduct(productName);
                if(ret != null)
                    return ret;
            }
        }
        return null;
    }

    @Override
    public float getPrice(){
        float total = 0;
        for(Product product: containedProducts){
            total += product.getPrice();
        }
        return total*(1-discount/100);
    }

    public void addProduct(Product product){
        if(product != null)
            containedProducts.add(product);
    }

    public boolean removeProduct(Product product){
        return containedProducts.remove(product);
    }

    /**
     * Returns a String that contains all the containedProducts inside of containedProducts-attribute
     * @return String
     */
    private String productList(int tabs){
        if(tabs<0 || tabs > 20)
            tabs = 0;
        String productList = "";
        for(Product iteratingProduct: containedProducts){
            for (int i = 0; i < tabs; i++)
                productList = productList.concat("\t");
            productList = productList.concat("-- " + iteratingProduct.getName() + "\n");
            if(iteratingProduct instanceof CompositeProduct){
                productList = productList.concat(((CompositeProduct) iteratingProduct).productList(tabs+1));
            }
        }
        return productList;
    }

    @Override
    public String toString() {


        return "\nCompositeProduct{" +
                "\nName: " + this.getName() +
                "\nProduct List: \n" + this.productList(1) +
                "Total Price: " + this.getPrice() +
                "}";
    }

    @Override
    public CompositeProduct deepCopy(){
        return new CompositeProduct(this.getName(), this.discount, this.getProducts());
    }
}
