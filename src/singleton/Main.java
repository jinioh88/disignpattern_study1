package singleton;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if(s1 == s2) {
            System.out.println("쌤쌤");
        } else {
            System.out.println("달라달라");
        }

        System.out.println("ENd");
    }
}
