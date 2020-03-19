package adapter;

public class Main {
    public static void main(String[] args) {
        // Banner 클래스의 사용이 완전히 감춰졌다.
        // Main은 PrintBanner가 어떻게 생겨먹은지 몰라도 된다.
        Print p = new PrintBanner("Hello");
        p.printString();
        p.printWeak();
    }
}
