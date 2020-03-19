package adapter;

public class Banner {
    private String title;

    public Banner(String title) {
        this.title = title;
    }

    public void showWithParen() {
        System.out.println("(" + title + ")");
    }

    public void showWithAster() {
        System.out.println("*" + title + "*");
    }
}
