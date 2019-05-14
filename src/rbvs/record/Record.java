package rbvs.record;

/**
 * Created by @author Rron Shabani - 1526907
 */
public abstract class Record implements IRecord{
    private long id;

    public Record(long identifier) {
        this.id = identifier;
    }

    public long getIdentifier(){
        return id;
    }
}
