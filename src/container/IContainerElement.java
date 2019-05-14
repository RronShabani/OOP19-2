package container;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public interface IContainerElement<E> {
    E getData();
    IContainerElement<E> getNextElement();
    boolean hasNextElement();
    void setNextElement(IContainerElement<E> next);
}
