package factory;

import factory.framework.Factory;
import factory.framework.Product;
import factory.idcard.IDCardFactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product product1 = factory.create("홍길동");
        Product product2 = factory.create("둘리");
        Product product3 = factory.create("피카츄");

        System.out.println(((IDCardFactory) factory).getOwners().size());

        product1.use();
        product2.use();
        product3.use();
    }
}
