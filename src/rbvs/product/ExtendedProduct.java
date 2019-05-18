package rbvs.product;

/**
 * Created by @author Rron Shabani - 1526907
 */
public class ExtendedProduct extends SimpleProduct{
    private ExtendedProduct savedState = null;

    public ExtendedProduct(String name, float price) {
        super(name, price);
    }

    public ExtendedProduct(ExtendedProduct product) {
        super(product.getName(), product.getPrice());
        this.savedState = product.savedState;
    }

    @Override
    public void setName(String name) {
        this.savedState = new ExtendedProduct(this);
            if (name == null)
               name = "";

        super.setName(name);
    }

    @Override
    public void setPrice (float price) throws IllegalArgumentException {
        if(price < 0){
            throw new IllegalArgumentException("You entered a negative number!", new Throwable(String.valueOf(price)) );
        }
        if(savedState!=null)
            savedState = new ExtendedProduct(this);
        super.setPrice(price);
    }

    @Override
    public String toString() {
        return "\nExtendedProduct{" +
                "Name =" + this.getName() +
                "Price =" + this.getPrice() +
                "Undoable =" + (savedState != null) +
                "}";
    }

    public boolean undo(){
        if(savedState == null)
            return false;

        this.setName(savedState.getName());
        this.setPrice(savedState.getPrice());
        return true;
    }

    @Override
    public ExtendedProduct deepCopy(){
        return new ExtendedProduct(this);
    }
}
