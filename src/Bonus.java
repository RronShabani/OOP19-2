import container.NetworkContainer;
import rbvs.DuplicateProductException;
import rbvs.product.CompositeProduct;
import rbvs.product.ExtendedProduct;
import rbvs.product.IProduct;
import rbvs.product.SimpleProduct;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by @author Rron Shabani - 1526907
 * on 18/05/2019
 */
public class Bonus {
    public static void main(String[] args) {
        NetworkContainer<IProduct> sContainer = new NetworkContainer<>("localhost", 34624, 0);
        NetworkContainer<IProduct> rContainer = new NetworkContainer<>("localhost", 0, 34624);

        boolean stop = false;
        while(!stop) {
            System.out.println("\n======================================");
            System.out.println("Menu options:");
            System.out.println("\t (1) Add Simple Product - to server");
            System.out.println("\t (2) Remove Simple Product - to server");
            System.out.println("\t (3) Print Server");
            System.out.println("\t (4) Print Client");
            System.out.println("\t (0) Exit");
            System.out.println("--------------------------------------");

            Scanner scanner = new Scanner(System.in);
            int menuOption = -1;
            try {
                menuOption = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException:\t" + e.getMessage());
            }
            String input_name;
            float input_price;

            switch (menuOption) {
                case 1:
                    System.out.println("(2) Enter the Product name:");
                    scanner.skip("\n");
                    input_name = scanner.nextLine();
                    System.out.println("(2) Enter the price:");
                    input_price = scanner.nextFloat();
                    sContainer.add(new SimpleProduct(input_name, input_price));
                    break;
                case 2:
                    System.out.println("(2) Enter the Product name:");
                    scanner.skip("\n");
                    input_name = scanner.nextLine();
                    System.out.println("(2) Enter the price:");
                    input_price = scanner.nextFloat();
                    sContainer.remove(new SimpleProduct(input_name, input_price));
                    break;
                case 3:
                    System.out.println("Server: \n"+sContainer);
                    break;
                case 4:
                    System.out.println("Client: \n"+rContainer);
                    break;
                case 0:
                    scanner.close();
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
        rContainer.stop();
        sContainer.stop();
    }
}
