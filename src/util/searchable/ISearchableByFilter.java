package util.searchable;

import java.util.Collection;

/**
 * Created by @author Rron Shabani - 1526907
 * on 14/05/2019
 */
public interface ISearchableByFilter<T> {
    Collection<T> searchByFilter(ISearchFilter filter, Object object);
}
