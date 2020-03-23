package factory.idcard;

import factory.framework.Product;

public class IDCard extends Product {
    private String owner;


    public IDCard(String owner) {
        System.out.println(owner + "의 카드를 만듬.");
        this.owner = owner;
    }


    @Override
    public void use() {
        System.out.println(owner + "의 카드를 사용.");
    }


    public String getOwner() {
        return owner;
    }
}
