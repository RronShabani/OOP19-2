package container;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public class Itr<E> implements Iterator<E> {

    private IContainerElement<E> next;

    public Itr(IContainerElement<E> firstElement) {
        this.next = firstElement;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public E next() {
        if(!hasNext())
            throw new NoSuchElementException();

        E temp = next.getData();
        next = next.getNextElement();
        return temp;
    }

    /*public int count(IContainerElement<E> first){
        if(first==null)
            return 0;

        int count = 1;
        while(next.getNextElement()!=null){
            count++;
        }
        return count;
    }*/

    @Override
    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
}
