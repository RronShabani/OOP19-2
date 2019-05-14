package rbvs.product;

/**
 * Created by @author Rron Shabani - 1526907
 */
public abstract class Product implements IProduct {

    private String name;
    private float price;

    public Product(String name) {
        if(name == null)
            name = "";
        this.name = name;
        this.price = 0;
    }

    public Product(String name, float price) {
        if(name == null)
            name = "";
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    public void setName(String name) {
        if (name == null)
            name = "";

        this.name = name;
    }

    public void setPrice (float price) throws IllegalArgumentException {
        if(price < 0){
            throw new IllegalArgumentException("You entered a negative number!", new Throwable(String.valueOf(price)) );
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Product){
            return (this.getName().equals(((IProduct)obj).getName()));
        }
        System.out.println("Invalid Object Type");
        return false;
    }

    private void initialize(String name, float price){
        if (name == null)
            name = "";

        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                "}";
    }

    public abstract Product deepCopy();
}