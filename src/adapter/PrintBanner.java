package adapter;

public class PrintBanner extends Banner implements Print {
    public PrintBanner(String title) {
        super(title);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printString() {
        showWithAster();
    }
}
