package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;
import prototype.product.MessageBox;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        MessageBox messageBox = new MessageBox('*');
        manager.register("warn box", messageBox);

        Product p1 = manager.create("warn box");
        p1.use("hello");
    }
}
