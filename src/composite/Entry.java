package composite;

public abstract class Entry {
    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) throws FileThreatmentException {
        throw new FileThreatmentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String str);

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
