import container.Container;

import java.util.*;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public class TEST {
    public static void main(String[] args){
        Container<Integer> container = new Container<>();
        for(int i=0; i < 3; i++) {
            container.add(i);
        }

        System.out.println(container.toString());

        container.remove(1);
        container.addAll(new ArrayList<Integer>(Arrays.asList(4,5,2)));

        System.out.println(container.toString());
    }
}
