package adapter;

public class PrintBanner extends Print {
    // 별도의 인스턴스에게 메서드를 위임.
    private Banner banner;

    public PrintBanner(String title) {
        this.banner = new Banner(title);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printString() {
        banner.showWithAster();
    }
}
