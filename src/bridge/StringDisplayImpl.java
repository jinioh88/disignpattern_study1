package bridge;

public class StringDisplayImpl extends DisplayImpl {
    private String string;
    private int width;


    public StringDisplayImpl(String string, int width) {
        this.string = string;
        this.width = width;
    }


    @Override
    public void rawOpen() {
        printLine();
    }


    private void printLine() {
        System.out.print("+");
        for(int i = 0; i <width; i++) {
            System.out.print("-");
        }
        System.out.print("+");
    }


    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }


    @Override
    public void rawClose() {
        printLine();
    }
}
