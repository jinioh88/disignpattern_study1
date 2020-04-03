package visitor;

import java.util.Iterator;
import composite.FileThreatmentException;

public abstract class Entry implements Element {

    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) throws FileThreatmentException {
        throw new FileThreatmentException();
    }

    public Iterator iterator() throws FileThreatmentException {
        throw new FileThreatmentException();
    }
}
