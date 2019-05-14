package container;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public class ContainerElement<E> implements IContainerElement<E>{
    private E data;
    private IContainerElement<E> nextElement;

    public ContainerElement(E data) {
        this.data = data;
        nextElement = null;
    }

    public ContainerElement(E data, IContainerElement<E> nextElement) {
        this.data = data;
        this.nextElement = nextElement;
    }

    @Override
    public E getData() {
        return data;
    }

    @Override
    public IContainerElement<E> getNextElement() {
        return nextElement;
    }

    @Override
    public boolean hasNextElement() {
        return nextElement != null;
    }

    @Override
    public void setNextElement(IContainerElement<E> next) {
        this.nextElement = next;
    }
}
