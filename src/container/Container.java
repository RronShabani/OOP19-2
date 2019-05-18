package container;

import util.searchable.ISearchFilter;
import util.searchable.ISearchableByFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public class Container<E> implements Collection<E>, ISearchableByFilter<E> {
    private IContainerElement<E> firstElement;

    public Container(){
        firstElement = null;
    }

    @Override
    public int size() {
        if(firstElement == null)
            return 0;

        int cnt = 0;
        for(Iterator<E> itr = this.iterator(); itr.hasNext(); itr.next(), cnt++){
        }
        return cnt;
    }

    @Override
    public boolean isEmpty() {
        return firstElement==null;
    }

    @Override
    public boolean contains(Object o) {
        Iterator itr = iterator();
        if(o == null){
            while(itr.hasNext()){
                if(itr.next()==null)
                    return true;
            }
        }else {
            while (itr.hasNext()) {
                if (itr.next().equals(o))
                    return true;
            }
            /* or using forEach
            for (E e : this) {
                if (e.equals(o))
                    return true;
            }
            * */
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr<>(firstElement);
    }

    @Override
    public Object[] toArray()  {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        if(e == null)
            throw new NullPointerException();

        //Adds the new node at the beginning of the list
        //this.firstElement = new ContainerElement<>(e,this.firstElement);

        if(firstElement == null) {
            firstElement = new ContainerElement<E>(e);
            return true;
        }
        IContainerElement<E> temp = firstElement;
        while(temp.hasNextElement())
            temp = temp.getNextElement();
        temp.setNextElement(new ContainerElement<E>(e));

        return true;
    }

    //Removes the first instance of o in the Container
    @Override
    public boolean remove(Object o) {
        IContainerElement<E> current = firstElement;
        IContainerElement<E> previous = null;

        while (current != null) {

            if (current.getData().equals(o)) {
                if(previous == null)
                    firstElement = firstElement.getNextElement();
                else
                    previous.setNextElement(current.getNextElement());

                current.setNextElement(null);
                return true;
            }

            previous = current;
            current = current.getNextElement();
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null)
            throw new NullPointerException();

        boolean flag = true;
        for(Object itr: c){
            if(!this.contains(itr))
                flag=false;
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null)
            throw new NullPointerException();

        boolean flag = true;
        for(E itr: c){
            if(!add(itr))
                flag=false;
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null)
            throw new NullPointerException();

        boolean flag = false;
        for(Object itr: c){
            while (remove(itr))
                flag=true;
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        firstElement = null;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index<0 || index>=this.size())
            throw new IndexOutOfBoundsException();

        IContainerElement<E> containerElement = firstElement;
        int i = 0;
        while (i<index) {
            containerElement = containerElement.getNextElement();
            i++;
        }
        return containerElement.getData();
    }

    @Override
    public Collection<E> searchByFilter(ISearchFilter filter, Object object) {
        Collection<E> out = new ArrayList<>();

        for (Iterator<E> iterator = this.iterator(); iterator.hasNext(); ) {
            E e = iterator.next();
            if (filter.searchFilterFunction(e, object)) {
                out.add(e);
            }
        }
        return out;
    }

    @Override
    public String toString(){
        String out = "{";

        for (Iterator<E> iterator = this.iterator(); iterator.hasNext();) {
            E e = iterator.next();
            out = out.concat(e.toString());
            if(iterator.hasNext())
                out = out+"; ";
        }

        return out+"}";
    }
}
